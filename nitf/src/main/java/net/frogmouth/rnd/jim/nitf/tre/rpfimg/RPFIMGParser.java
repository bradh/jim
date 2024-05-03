package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

/** RPFIMG TRE Parser. */
public class RPFIMGParser extends AbstractTaggedRecordExtensionParser {

    private static final int LOCATION_SECTION_LENGTH_LEN = 2;
    private static final int COMPONENT_LOCATION_TABLE_OFFSET_LEN = 4;
    private static final int NUMBER_OF_COMPONENT_LOCATION_RECORDS_LEN = 2;
    private static final int COMPONENT_LOCATION_RECORD_LEN = 2;
    private static final int COMPONENT_AGGREGATE_LENGTH_LEN = 4;
    private static final int COMPONENT_ID_LEN = 2;
    private static final int COMPONENT_LENGTH_LEN = 4;
    private static final int COMPONENT_LOCATION_LEN = 4;
    private static final int LATITUDE_LEN = 8;
    private static final int LONGITUDE_LEN = 8;
    private static final int VERTICAL_RESOLUTION_LEN = 8;
    private static final int HORIZONTAL_RESOLUTION_LEN = 8;
    private static final int LATITUDE_VERTICAL_INTERVAL_LEN = 8;
    private static final int LONGITUDE_HORIZONTAL_INTERVAL_LEN = 8;
    private static final int NUMBER_OF_SPECTRAL_GROUPS_LEN = 2;
    private static final int NUMBER_OF_SUBFRAME_TABLES_LEN = 2;
    private static final int NUMBER_OF_SPECTRAL_BAND_TABLES_LEN = 2;
    private static final int NUMBER_OF_SPECTRAL_BAND_LINES_PER_IMAGE_ROW_LEN = 2;
    private static final int NUMBER_OF_SUBFRAMES_LEFT_RIGHT_LEN = 2;
    private static final int NUMBER_OF_SUBFRAMES_UP_DOWN_LEN = 2;
    private static final int NUMBER_OF_OUTPUT_COLUMNS_PER_SUBFRAME_LEN = 4;
    private static final int NUMBER_OF_OUTPUT_ROWS_PER_SUBFRAME_LEN = 4;
    private static final int SUBFRAME_MASK_TABLE_OFFSET_LEN = 4;
    private static final int TRANSPARENCY_MASK_OFFSET_LEN = 4;
    private static final int IMAGE_DESCRIPTION_MIN_LENGTH = 28;

    @Override
    public String getTag() {
        return "RPFIMG";
    }

    @Override
    public RPFIMG parse(String tag, byte[] bytes) {
        RPFIMG tre = new RPFIMG();
        int offset = 0;
        int locationSectionLength = readUnsignedInteger(bytes, offset, LOCATION_SECTION_LENGTH_LEN);
        offset += LOCATION_SECTION_LENGTH_LEN;
        int componentLocationTableOffset =
                readUnsignedInteger(bytes, offset, COMPONENT_LOCATION_TABLE_OFFSET_LEN);
        offset += COMPONENT_LOCATION_TABLE_OFFSET_LEN;
        int numberOfComponentLocationRecords =
                readUnsignedInteger(bytes, offset, NUMBER_OF_COMPONENT_LOCATION_RECORDS_LEN);
        offset += NUMBER_OF_COMPONENT_LOCATION_RECORDS_LEN;
        int componentLocationRecordLength =
                readUnsignedInteger(bytes, offset, COMPONENT_LOCATION_RECORD_LEN);
        offset += COMPONENT_LOCATION_RECORD_LEN;
        int componentAggregateLength =
                readUnsignedInteger(bytes, offset, COMPONENT_AGGREGATE_LENGTH_LEN);
        offset += COMPONENT_AGGREGATE_LENGTH_LEN;
        int componentBaseOffset = 0;
        for (int i = 0; i < numberOfComponentLocationRecords; i++) {
            int componentId = readUnsignedInteger(bytes, offset, COMPONENT_ID_LEN);
            SectionComponentCode componentCode = SectionComponentCode.lookupByIdent(componentId);
            offset += COMPONENT_ID_LEN;
            int componentLength = readUnsignedInteger(bytes, offset, COMPONENT_LENGTH_LEN);
            offset += COMPONENT_LENGTH_LEN;
            int componentLocation = readUnsignedInteger(bytes, offset, COMPONENT_LOCATION_LEN);
            offset += COMPONENT_LOCATION_LEN;
            if (componentCode.equals(SectionComponentCode.Location)) {
                // assume location is the first section in RPFIMG TRE.
                componentBaseOffset = componentLocation;
            }
            ComponentLocationRecord componentLocationRecord =
                    new ComponentLocationRecord(componentCode, componentLength, componentLocation);
            tre.addComponentLocationRecord(componentLocationRecord);
        }
        if (componentBaseOffset > 0) {
            for (ComponentLocationRecord componentLocationRecord :
                    tre.getComponentLocationRecords()) {
                int startOffset =
                        componentLocationRecord.getComponentLocation() - componentBaseOffset;
                int endOffset = startOffset + componentLocationRecord.getComponentLength();
                if (componentIsInBytes(bytes.length, startOffset, endOffset)) {
                    switch (componentLocationRecord.getComponentCode()) {
                        case Coverage:
                            parseCoverageRecord(
                                    tre,
                                    bytes,
                                    startOffset,
                                    componentLocationRecord.getComponentLength());
                            break;
                        case Colormap:
                            parseColourmap(
                                    tre,
                                    bytes,
                                    startOffset,
                                    componentLocationRecord.getComponentLength());
                            break;
                        case ImageDescription:
                            parseImageDescription(
                                    tre,
                                    bytes,
                                    startOffset,
                                    componentLocationRecord.getComponentLength());
                            break;
                        case ColorGrayscale:
                            parseColorGrayscale(
                                    tre,
                                    bytes,
                                    startOffset,
                                    componentLocationRecord.getComponentLength());
                            break;
                        default:
                            System.out.println(componentLocationRecord + " not parsed");
                    }
                } else {
                    System.out.println(
                            "Skipping record "
                                    + componentLocationRecord.getComponentCode()
                                    + ", it is outside the RPFIMG TRE data");
                }
            }
        }
        return tre;
    }

    private int readUnsignedInteger(byte[] bytes, final int offset, final int numBytesToRead) {
        int result = 0;
        for (int i = 0; i < numBytesToRead; i++) {
            result = (result << Byte.SIZE) + (bytes[offset + i] & 0xFF);
        }
        return result;
    }

    private double readDouble(byte[] bytes, int offset) {
        ByteBuffer bb = ByteBuffer.wrap(bytes, offset, Double.BYTES);
        return bb.getDouble();
    }

    private boolean componentIsInBytes(int length, int startOffset, int endOffset) {
        return (endOffset <= length) && (startOffset >= 0);
    }

    private void parseCoverageRecord(RPFIMG tre, byte[] bytes, int startOffset, int length) {
        if (length < 12 * Double.BYTES) {
            // TODO: log
            return;
        }
        int offset = startOffset;
        CoverageRecord coverageRecord = new CoverageRecord();
        coverageRecord.setUpperLeftLatitude(readDouble(bytes, offset));
        offset += LATITUDE_LEN;
        coverageRecord.setUpperLeftLongitude(readDouble(bytes, offset));
        offset += LONGITUDE_LEN;
        coverageRecord.setLowerLeftLatitude(readDouble(bytes, offset));
        offset += LATITUDE_LEN;
        coverageRecord.setLowerLeftLongitude(readDouble(bytes, offset));
        offset += LONGITUDE_LEN;
        coverageRecord.setUpperRightLatitude(readDouble(bytes, offset));
        offset += LATITUDE_LEN;
        coverageRecord.setUpperRightLongitude(readDouble(bytes, offset));
        offset += LONGITUDE_LEN;
        coverageRecord.setLowerRightLatitude(readDouble(bytes, offset));
        offset += LATITUDE_LEN;
        coverageRecord.setLowerRightLongitude(readDouble(bytes, offset));
        offset += LONGITUDE_LEN;
        coverageRecord.setVerticalResolution(readDouble(bytes, offset));
        offset += VERTICAL_RESOLUTION_LEN;
        coverageRecord.setHorizontalResolution(readDouble(bytes, offset));
        offset += HORIZONTAL_RESOLUTION_LEN;
        coverageRecord.setVerticalInterval(readDouble(bytes, offset));
        offset += LATITUDE_VERTICAL_INTERVAL_LEN;
        coverageRecord.setHorizontalInterval(readDouble(bytes, offset));
        offset += LONGITUDE_HORIZONTAL_INTERVAL_LEN;
        assert ((offset - startOffset) == length);
        tre.setCoverage(coverageRecord);
    }

    private void parseImageDescription(RPFIMG tre, byte[] bytes, int startOffset, int length) {
        if (length < IMAGE_DESCRIPTION_MIN_LENGTH) {
            // TODO: log
            return;
        }
        ImageDescription imageDescription = new ImageDescription();
        int offset = startOffset;
        imageDescription.setNumberOfSpectralGroups(
                readUnsignedInteger(bytes, offset, NUMBER_OF_SPECTRAL_GROUPS_LEN));
        offset += NUMBER_OF_SPECTRAL_GROUPS_LEN;
        imageDescription.setNumberOfSubframeTables(
                readUnsignedInteger(bytes, offset, NUMBER_OF_SUBFRAME_TABLES_LEN));
        offset += NUMBER_OF_SUBFRAME_TABLES_LEN;
        imageDescription.setNumberOfSpectralBandTables(
                readUnsignedInteger(bytes, offset, NUMBER_OF_SPECTRAL_BAND_TABLES_LEN));
        offset += NUMBER_OF_SPECTRAL_BAND_TABLES_LEN;
        imageDescription.setNumberOfSpectralBandLinesPerImageRow(
                readUnsignedInteger(
                        bytes, offset, NUMBER_OF_SPECTRAL_BAND_LINES_PER_IMAGE_ROW_LEN));
        offset += NUMBER_OF_SPECTRAL_BAND_LINES_PER_IMAGE_ROW_LEN;
        imageDescription.setNumberOfSubframesInEastWestOrLeftRightDirection(
                readUnsignedInteger(bytes, offset, NUMBER_OF_SUBFRAMES_LEFT_RIGHT_LEN));
        offset += NUMBER_OF_SUBFRAMES_LEFT_RIGHT_LEN;
        imageDescription.setNumberOfSubframesInNorthSouthOrUpDownDirection(
                readUnsignedInteger(bytes, offset, NUMBER_OF_SUBFRAMES_UP_DOWN_LEN));
        offset += NUMBER_OF_SUBFRAMES_UP_DOWN_LEN;
        imageDescription.setNumberOfOutputColumnsPerSubframe(
                readUnsignedInteger(bytes, offset, NUMBER_OF_OUTPUT_COLUMNS_PER_SUBFRAME_LEN));
        offset += NUMBER_OF_OUTPUT_COLUMNS_PER_SUBFRAME_LEN;
        imageDescription.setNumberOfOutputRowsPerSubframe(
                readUnsignedInteger(bytes, offset, NUMBER_OF_OUTPUT_ROWS_PER_SUBFRAME_LEN));
        offset += NUMBER_OF_OUTPUT_ROWS_PER_SUBFRAME_LEN;
        imageDescription.setSubframeMaskTableOffset(
                readUnsignedInteger(bytes, offset, SUBFRAME_MASK_TABLE_OFFSET_LEN));
        offset += SUBFRAME_MASK_TABLE_OFFSET_LEN;
        imageDescription.setTransparencyMaskTableOffset(
                readUnsignedInteger(bytes, offset, TRANSPARENCY_MASK_OFFSET_LEN));
        offset += TRANSPARENCY_MASK_OFFSET_LEN;
        assert ((offset - startOffset) == length);
        tre.setImageDescription(imageDescription);
    }

    private void parseColourmap(RPFIMG tre, byte[] bytes, int startOffset, int length) {
        Colormap colormap = new Colormap();
        int offset = startOffset;
        int colormapTableOffset = readUnsignedInteger(bytes, offset, 4);
        offset += 4;
        int colorGrayscaleOffsetRecordLength = readUnsignedInteger(bytes, offset, 2);
        offset += 2;
        // TODO: implement
        assert ((offset - startOffset) == length);
        tre.setColormap(colormap);
    }

    private void parseColorGrayscale(RPFIMG tre, byte[] bytes, int startOffset, int length) {
        ColorGrayscale colorGrayscale = new ColorGrayscale();
        int offset = startOffset;
        colorGrayscale.setNumberOfColorGrayscaleOffsetRecords(bytes[offset] & 0xFF);
        offset += Byte.BYTES;
        colorGrayscale.setNumberOfColorConverterOffsetRecords(bytes[offset] & 0xFF);
        offset += Byte.BYTES;
        colorGrayscale.setExternalColorGrayscaleFileName(
                new String(bytes, offset, 12, StandardCharsets.US_ASCII));
        offset += 12;
        assert ((offset - startOffset) == length);
        tre.setColorGrayscale(colorGrayscale);
    }
}
