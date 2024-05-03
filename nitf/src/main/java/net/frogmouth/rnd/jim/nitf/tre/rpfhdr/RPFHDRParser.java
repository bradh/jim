package net.frogmouth.rnd.jim.nitf.tre.rpfhdr;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;
import net.frogmouth.rnd.jim.nitf.utils.ReaderUtils;

/** RPFHDR TRE Parser. */
public class RPFHDRParser extends AbstractTaggedRecordExtensionParser {

    private static final int ENDIAN_INDICATOR_LEN = 1;
    private static final int HEADER_SECTION_LENGTH_LEN = 2;
    private static final int FILE_NAME_LEN = 12;
    private static final int NEW_REPLACEMENT_UPDATE_INDICATOR_LEN = 1;
    private static final int GOVERNING_SPECIFICATION_NUMBER_LEN = 15;
    private static final int GOVERNING_SPECIFICATION_DATE_LEN = 8;
    private static final int SECURITY_CLASSIFICATION_LEN = 1;
    private static final int SECURITY_COUNTRY_INTERNATIONAL_CODE_LEN = 2;
    private static final int SECURITY_RELEASE_MARKING_LEN = 2;
    private static final int LOCATION_SECTION_LOCATION_LEN = 4;

    @Override
    public String getTag() {
        return "RPFHDR";
    }

    @Override
    public RPFHDR parse(String tag, byte[] bytes) {
        RPFHDR tre = new RPFHDR();
        int offset = 0;
        int littleBigEndianIndicator = bytes[offset] & 0xFF;
        tre.setLittleEndianIndicator(littleBigEndianIndicator == 0xFF);
        offset += ENDIAN_INDICATOR_LEN;
        int headerSectionLength =
                readUnsignedInteger(
                        bytes, offset, HEADER_SECTION_LENGTH_LEN, tre.isLittleEndianIndicator());
        tre.setHeaderSectionLength(headerSectionLength);
        offset += HEADER_SECTION_LENGTH_LEN;
        tre.setFileName(ReaderUtils.convertByteArrayToBCSA(bytes, offset, FILE_NAME_LEN));
        offset += FILE_NAME_LEN;
        tre.setNewReplacementUpdateIndicator(bytes[offset] & 0xFF);
        offset += NEW_REPLACEMENT_UPDATE_INDICATOR_LEN;
        tre.setGoverningSpecificationNumber(
                ReaderUtils.convertByteArrayToBCSA(
                        bytes, offset, GOVERNING_SPECIFICATION_NUMBER_LEN));
        offset += GOVERNING_SPECIFICATION_NUMBER_LEN;
        tre.setGoverningSpecificationDate(
                ReaderUtils.convertByteArrayToBCSA(
                        bytes, offset, GOVERNING_SPECIFICATION_DATE_LEN));
        offset += GOVERNING_SPECIFICATION_DATE_LEN;
        tre.setSecurityClassification(
                ReaderUtils.convertByteArrayToBCSA(bytes, offset, SECURITY_CLASSIFICATION_LEN));
        offset += SECURITY_CLASSIFICATION_LEN;
        tre.setSecurityCountryInternationalCode(
                ReaderUtils.convertByteArrayToBCSA(
                        bytes, offset, SECURITY_COUNTRY_INTERNATIONAL_CODE_LEN));
        offset += SECURITY_COUNTRY_INTERNATIONAL_CODE_LEN;
        tre.setSecurityReleaseMarking(
                ReaderUtils.convertByteArrayToBCSA(bytes, offset, SECURITY_RELEASE_MARKING_LEN));
        offset += SECURITY_RELEASE_MARKING_LEN;
        tre.setLocationSectionLocation(
                this.readUnsignedInteger(
                        bytes,
                        offset,
                        LOCATION_SECTION_LOCATION_LEN,
                        tre.isLittleEndianIndicator()));
        offset += LOCATION_SECTION_LOCATION_LEN;
        assert offset == bytes.length;
        return tre;
    }

    private int readUnsignedInteger(
            byte[] bytes, final int offset, final int numBytesToRead, final boolean littleEndian) {
        if (littleEndian) {
            throw new UnsupportedOperationException(
                    "cannot read little endian unsigned integer yet");
        }
        int result = 0;
        for (int i = 0; i < numBytesToRead; i++) {
            result = (result << Byte.SIZE) + (bytes[offset + i] & 0xFF);
        }
        return result;
    }
}
