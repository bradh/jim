package com.sigmabravo.rnd.jim.nitf;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREParser;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

/** NITF Reader. */
public class Reader {

    private MappedByteBuffer mappedByteBuffer;
    private static final int FHDR_OFFSET = 0;
    private static final int FHDR_LEN = 4;
    private static final int FVER_OFFSET = FHDR_OFFSET + FHDR_LEN;
    private static final int FVER_LEN = 5;
    private static final int CLEVEL_OFFSET = FVER_OFFSET + FVER_LEN;
    private static final int CLEVEL_LEN = 2;
    private static final int STYPE_OFFSET = CLEVEL_OFFSET + CLEVEL_LEN;
    private static final int STYPE_LEN = 4;
    private static final int OSTAID_OFFSET = STYPE_OFFSET + STYPE_LEN;
    private static final int OSTAID_LEN = 10;
    private static final int FDT_OFFSET = OSTAID_OFFSET + OSTAID_LEN;
    private static final int FDT_LEN = 14;
    private static final int FTITLE_OFFSET = FDT_OFFSET + FDT_LEN;
    private static final int FTITLE_LEN = 80;
    private static final int SECURITY_OFFSET = FTITLE_OFFSET + FTITLE_LEN;
    private static final int SECURITY_LEN = 167;
    private static final int FSCOP_OFFSET = SECURITY_OFFSET + SECURITY_LEN;
    private static final int FSCOP_LEN = 5;
    private static final int FSCPYS_OFFSET = FSCOP_OFFSET + FSCOP_LEN;
    private static final int FSCPYS_LEN = 5;
    private static final int ENCRYP_OFFSET = FSCPYS_OFFSET + FSCPYS_LEN;
    private static final int ENCRYP_LEN = 1;
    private static final int FBKGC_OFFSET = ENCRYP_OFFSET + ENCRYP_LEN;
    private static final int FBKGC_LEN = 3;
    private static final int ONAME_OFFSET = FBKGC_OFFSET + FBKGC_LEN;
    private static final int ONAME_LEN = 24;
    private static final int OPHONE_OFFSET = ONAME_OFFSET + ONAME_LEN;
    private static final int OPHONE_LEN = 18;
    private static final int FL_OFFSET = OPHONE_OFFSET + OPHONE_LEN;
    private static final int FL_LEN = 12;
    private static final int HL_OFFSET = FL_OFFSET + FL_LEN;
    private static final int HL_LEN = 6;
    private static final int NUMI_OFFSET = HL_OFFSET + HL_LEN;
    private static final int NUMI_LEN = 3;
    private static final int LISH_LEN = 6;
    private static final int LI_LEN = 10;
    private static final int NUMS_LEN = 3;
    private static final int LSSH_LEN = 4;
    private static final int LS_LEN = 6;
    private static final int NUMX_LEN = 3;
    private static final int NUMT_LEN = 3;
    private static final int LTSH_LEN = 4;
    private static final int LT_LEN = 5;
    private static final int NUMDES_LEN = 3;
    private static final int LDSH_LEN = 4;
    private static final int LD_LEN = 9;
    private static final int NUMRES_LEN = 3;
    private static final int LRESH_LEN = 4;
    private static final int LRE_LEN = 7;
    private static final int UDHDL_LEN = 5;
    private static final int UDHOFL_LEN = 3;
    private static final int XHDL_LEN = 5;
    private static final int XHDLOFL_LEN = 3;

    private static final byte[] NITF21_BYTES =
            new byte[] {0x4e, 0x49, 0x54, 0x46, 0x30, 0x32, 0x2e, 0x31, 0x30};

    private int fileHeaderLength;
    private int udhofl = 0;
    private int udhdOffset = -1;
    private int udhdLength = 0;
    private int xhdlofl = 0;
    private int xhdOffset = -1;
    private int xhdLength = 0;

    private List<SegmentInfo> imageSegments = new ArrayList<>();
    private List<SegmentInfo> graphicSegments = new ArrayList<>();
    private List<SegmentInfo> textSegments = new ArrayList<>();
    private List<SegmentInfo> dataExtensionSegments = new ArrayList<>();

    public Reader(String filename) throws IOException {
        this(Paths.get(filename));
    }

    public Reader(Path nitfToRead) throws IOException {
        try (FileChannel fileChannel =
                (FileChannel)
                        Files.newByteChannel(nitfToRead, EnumSet.of(StandardOpenOption.READ))) {
            mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        }
        if (isNitf()) {
            fileHeaderLength = getFileHeaderLength();
            int nextSegmentStartOffset = fileHeaderLength;
            byte[] numiBytes = getBytesAt(NUMI_OFFSET, NUMI_LEN);
            int numImageSegments = convertByteArrayToBCS_NPI(numiBytes);
            int offset = NUMI_OFFSET + NUMI_LEN;
            for (int i = 0; i < numImageSegments; i++) {
                SegmentInfo segmentInfo = new SegmentInfo();
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] lishBytes = getBytesAt(offset, LISH_LEN);
                segmentInfo.setSubheaderLength(convertByteArrayToBCS_NPI(lishBytes));
                offset += LISH_LEN;
                byte[] liBytes = getBytesAt(offset, LI_LEN);
                segmentInfo.setSegmentLength(convertByteArrayToBCS_NPI(liBytes));
                offset += LI_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                imageSegments.add(segmentInfo);
            }
            byte[] numsBytes = getBytesAt(offset, NUMS_LEN);
            offset += NUMS_LEN;
            int numGraphicSegments = convertByteArrayToBCS_NPI(numsBytes);
            for (int i = 0; i < numGraphicSegments; i++) {
                SegmentInfo segmentInfo = new SegmentInfo();
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] lsshBytes = getBytesAt(offset, LSSH_LEN);
                segmentInfo.setSubheaderLength(convertByteArrayToBCS_NPI(lsshBytes));
                offset += LSSH_LEN;
                byte[] lsBytes = getBytesAt(offset, LS_LEN);
                segmentInfo.setSegmentLength(convertByteArrayToBCS_NPI(lsBytes));
                offset += LS_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                graphicSegments.add(segmentInfo);
            }
            offset += NUMX_LEN;
            byte[] numtBytes = getBytesAt(offset, NUMT_LEN);
            offset += NUMT_LEN;
            int numTextSegments = convertByteArrayToBCS_NPI(numtBytes);
            for (int i = 0; i < numTextSegments; i++) {
                SegmentInfo segmentInfo = new SegmentInfo();
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] ltshBytes = getBytesAt(offset, LTSH_LEN);
                segmentInfo.setSubheaderLength(convertByteArrayToBCS_NPI(ltshBytes));
                offset += LTSH_LEN;
                byte[] ltBytes = getBytesAt(offset, LT_LEN);
                segmentInfo.setSegmentLength(convertByteArrayToBCS_NPI(ltBytes));
                offset += LT_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                textSegments.add(segmentInfo);
            }
            byte[] numdesBytes = getBytesAt(offset, NUMDES_LEN);
            offset += NUMDES_LEN;
            int numDES = convertByteArrayToBCS_NPI(numdesBytes);
            for (int i = 0; i < numDES; i++) {
                SegmentInfo segmentInfo = new SegmentInfo();
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] ldshBytes = getBytesAt(offset, LDSH_LEN);
                segmentInfo.setSubheaderLength(convertByteArrayToBCS_NPI(ldshBytes));
                offset += LDSH_LEN;
                byte[] ldBytes = getBytesAt(offset, LD_LEN);
                segmentInfo.setSegmentLength(convertByteArrayToBCS_NPI(ldBytes));
                offset += LD_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                dataExtensionSegments.add(segmentInfo);
            }
            offset += NUMRES_LEN;
            // Assume there are never RES
            int udhdl = convertByteArrayToBCS_NPI(getBytesAt(offset, UDHDL_LEN));
            offset += UDHDL_LEN;
            if (udhdl != 0) {
                udhofl = convertByteArrayToBCS_NPI(getBytesAt(offset, UDHOFL_LEN));
                offset += UDHOFL_LEN;
                udhdOffset = offset;
                udhdLength = udhdl - UDHOFL_LEN;
                offset += udhdLength;
            }
            int xhdl = convertByteArrayToBCS_NPI(getBytesAt(offset, XHDL_LEN));
            offset += XHDL_LEN;
            if (xhdl != 0) {
                xhdlofl = convertByteArrayToBCS_NPI(getBytesAt(offset, XHDLOFL_LEN));
                offset += XHDLOFL_LEN;
                xhdOffset = offset;
                xhdLength = xhdl - XHDLOFL_LEN;
            }
        }
    }

    /**
     * Perform a quick sanity check of the file.
     *
     * @return true if it looks like NITF, otherwise false.
     */
    public final boolean isNitf() {
        byte[] bytes = getBytesAt(FHDR_OFFSET, FHDR_LEN + FVER_LEN);
        return (Arrays.equals(bytes, NITF21_BYTES));
    }

    /**
     * Get the reported complexity level for the file.
     *
     * @return CLEVEL value as an integer value
     */
    public int getCLEVEL() {
        byte[] bytes = getBytesAt(CLEVEL_OFFSET, CLEVEL_LEN);
        return convertByteArrayToBCS_NPI(bytes);
    }

    /**
     * Get the originating station identifier for the file.
     *
     * @return originating station as text
     */
    public String getOSTAID() {
        byte[] bytes = getBytesAt(OSTAID_OFFSET, OSTAID_LEN);
        return convertByteArrayToBCSA(bytes);
    }

    /**
     * Get the date and time (UTC) of the file’s origination.
     *
     * @return date / time in the format CCYYMMDDhhmmss.
     */
    public String getFileDateTime() {
        byte[] bytes = getBytesAt(FDT_OFFSET, FDT_LEN);
        // The character set is BCS-N, but we need a string here.
        return convertByteArrayToBCSA(bytes);
    }
    /**
     * Get the originator's name for the file.
     *
     * @return name as text (can be space filled)
     */
    public String getONAME() {
        byte[] bytes = getBytesAt(ONAME_OFFSET, ONAME_LEN);
        return convertByteArrayToECSA(bytes);
    }

    /**
     * Get the originator's phone number for the file.
     *
     * @return phone number as text (can be space filled)
     */
    public String getOPHONE() {
        byte[] bytes = getBytesAt(OPHONE_OFFSET, OPHONE_LEN);
        return convertByteArrayToECSA(bytes);
    }

    /**
     * Get the number of image segments in the file.
     *
     * @return number of image segments as an integer
     */
    public int getNumberOfImageSegments() {
        return imageSegments.size();
    }

    /**
     * Get the number of graphic segments in the file.
     *
     * @return number of graphic segments as an integer
     */
    public int getNumberOfGraphicSegments() {
        return graphicSegments.size();
    }

    /**
     * Get the number of text segments in the file.
     *
     * @return number of text segments as an integer
     */
    public int getNumberOfTextSegments() {
        return textSegments.size();
    }

    /**
     * Get the number of DES in the file.
     *
     * @return number of data extension segments as an integer
     */
    public int getNumberOfDES() {
        return dataExtensionSegments.size();
    }

    public byte[] getUserDefinedHeaderData() {
        return getBytesAt(udhdOffset, udhdLength);
    }

    private byte[] getBytesAt(int offset, int len) {
        mappedByteBuffer.position(offset);
        byte[] dest = new byte[len];
        mappedByteBuffer.get(dest);
        return dest;
    }

    private int convertByteArrayToBCS_NPI(byte[] dest) {
        String s = new String(dest, StandardCharsets.US_ASCII);
        return Integer.parseInt(s);
    }

    private String convertByteArrayToBCSA(byte[] bytes) {
        return new String(bytes, StandardCharsets.US_ASCII);
    }

    private String convertByteArrayToECSA(byte[] bytes) {
        // TODO: this isn't quite right - needs to be more precise
        return new String(bytes, StandardCharsets.ISO_8859_1);
    }

    private int getFileHeaderLength() {
        byte[] bytes = getBytesAt(HL_OFFSET, HL_LEN);
        return convertByteArrayToBCS_NPI(bytes);
    }

    public String getTextSegmentBody(int segmentNumber) {
        SegmentInfo segmentInfo = textSegments.get(segmentNumber);
        byte[] segmentBytes =
                getBytesAt(
                        segmentInfo.getSegmentFileOffset() + segmentInfo.getSubheaderLength(),
                        segmentInfo.getSegmentLength());
        return this.convertByteArrayToECSA(segmentBytes);
    }

    // These are temporary.
    public int getUdhofl() {
        return udhofl;
    }

    public int getXhdlofl() {
        return xhdlofl;
    }

    public int getXhdOffset() {
        return xhdOffset;
    }

    public int getXhdLength() {
        return xhdLength;
    }

    public List<TRE> getFileTREs() {
        TREParser parser = new TREParser();
        List<TRE> tres = new ArrayList<>();
        byte[] udhd = getUserDefinedHeaderData();
        if (udhd.length > 0) {
            tres.addAll(parser.parse(udhd));
        }
        // TODO: xdhd and overflow DES.
        return tres;
    }
}
