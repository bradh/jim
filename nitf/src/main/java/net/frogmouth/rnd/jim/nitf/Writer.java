package net.frogmouth.rnd.jim.nitf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Writer {

    // TODO: make shared constants class and share with reader

    private static final byte[] NITF21_BYTES =
            new byte[] {0x4e, 0x49, 0x54, 0x46, 0x30, 0x32, 0x2e, 0x31, 0x30};

    private static final byte[] STYPE_BYTES = "BF01".getBytes(StandardCharsets.US_ASCII);
    private static final int DEFAULT_ENCRYP_VALUE = 0;

    public void write(Nitf nitf, OutputStream outputStream) throws IOException {
        outputStream.write(makeHeader(nitf));
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getComplexityLevel(), 2));
        outputStream.write(STYPE_BYTES);
        outputStream.write(WriterUtils.toBCS_A(nitf.getOriginatingStationID(), 10));
        outputStream.write(nitf.getFileDateTimeAsBytes());
        outputStream.write(WriterUtils.toECS_A(nitf.getFileTitle(), 80));
        outputStream.write(nitf.getSecurityMetadata().asBytes());
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getCopyNumber(), 5));
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getNumberOfCopies(), 5));
        outputStream.write(WriterUtils.toBCS_NPI(DEFAULT_ENCRYP_VALUE, 1));
        outputStream.write(nitf.getBackgroundColourAsBytes());
        outputStream.write(WriterUtils.toECS_A(nitf.getOriginatorName(), 24));
        outputStream.write(WriterUtils.toECS_A(nitf.getOriginatorPhone(), 18));
        outputStream.write(WriterUtils.toBCS_NPI(nitf.calculateFileSize(), 12));
        outputStream.write(WriterUtils.toBCS_NPI(nitf.calculateHeaderSize(), 6));
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getNumberOfImageSegments(), 3));
        // TODO: write out segments
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getNumberOfGraphicSegments(), 3));
        // TODO: write out segments
        outputStream.write(WriterUtils.toBCS_NPI(0, 3));
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getNumberOfTextSegments(), 3));
        for (TextSegment textSegment : nitf.getTextSegments()) {
            outputStream.write(WriterUtils.toBCS_NPI(textSegment.getSubheaderAsBytes().length, 4));
            outputStream.write(WriterUtils.toBCS_NPI(textSegment.getLengthOfTextSegment(), 5));
        }
        outputStream.write(WriterUtils.toBCS_NPI(nitf.getNumberOfDataExtensionSegments(), 3));
        // TODO: write out segments
        outputStream.write(WriterUtils.toBCS_NPI(0, 3));
        // TODO: properly support UDHDL and XHDL, plus conditional bits
        outputStream.write(WriterUtils.toBCS_NPI(0, 5));
        outputStream.write(WriterUtils.toBCS_NPI(0, 5));
        // TODO: output image segments
        // TODO: output graphic segments
        for (TextSegment textSegment : nitf.getTextSegments()) {
            outputStream.write(textSegment.getSubheaderAsBytes());
            // TODO: body
        }
        // TODO: output DES
    }

    private byte[] makeHeader(Nitf nitf) throws IOException {
        if (nitf.isNitf21()) {

            return NITF21_BYTES;
        }
        throw new IOException("Unsupported format");
    }
}
