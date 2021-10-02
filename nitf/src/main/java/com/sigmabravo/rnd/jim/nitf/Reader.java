package com.sigmabravo.rnd.jim.nitf;

import com.sigmabravo.rnd.jim.nitf.image.ImageBlockInfo;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.image.ImageSegmentInfo;
import com.sigmabravo.rnd.jim.nitf.text.TextSegmentHeader;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREParser;
import com.sigmabravo.rnd.jim.nitf.utils.ReaderUtils;
import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
    private static final int FTITLE_OFFSET = FDT_OFFSET + ReaderUtils.DATE_TIME_LEN;
    private static final int FTITLE_LEN = 80;
    private static final int SECURITY_OFFSET = FTITLE_OFFSET + FTITLE_LEN;
    private static final int FSCOP_OFFSET = SECURITY_OFFSET + ReaderUtils.SECURITY_FIELDS_LEN;
    private static final int FSCOP_LEN = 5;
    private static final int FSCPYS_OFFSET = FSCOP_OFFSET + FSCOP_LEN;
    private static final int FSCPYS_LEN = 5;
    private static final int ENCRYP_OFFSET = FSCPYS_OFFSET + FSCPYS_LEN;
    private static final int FBKGC_OFFSET = ENCRYP_OFFSET + ReaderUtils.ENCRYP_LEN;
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

    private List<ImageSegmentInfo> imageSegments = new ArrayList<>();
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
            int numImageSegments = ReaderUtils.convertByteArrayToBCS_NPI(numiBytes);
            int offset = NUMI_OFFSET + NUMI_LEN;
            for (int i = 0; i < numImageSegments; i++) {
                ImageSegmentInfo segmentInfo = new ImageSegmentInfo(i);
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] lishBytes = getBytesAt(offset, LISH_LEN);
                segmentInfo.setSubheaderLength(ReaderUtils.convertByteArrayToBCS_NPI(lishBytes));
                offset += LISH_LEN;
                nextSegmentStartOffset += segmentInfo.getSubheaderLength();
                byte[] liBytes = getBytesAt(offset, LI_LEN);
                segmentInfo.setSegmentLength(ReaderUtils.convertByteArrayToBCS_NPI(liBytes));
                offset += LI_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                imageSegments.add(segmentInfo);
            }
            byte[] numsBytes = getBytesAt(offset, NUMS_LEN);
            offset += NUMS_LEN;
            int numGraphicSegments = ReaderUtils.convertByteArrayToBCS_NPI(numsBytes);
            for (int i = 0; i < numGraphicSegments; i++) {
                SegmentInfo segmentInfo = new SegmentInfo(i);
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] lsshBytes = getBytesAt(offset, LSSH_LEN);
                segmentInfo.setSubheaderLength(ReaderUtils.convertByteArrayToBCS_NPI(lsshBytes));
                offset += LSSH_LEN;
                nextSegmentStartOffset += segmentInfo.getSubheaderLength();
                byte[] lsBytes = getBytesAt(offset, LS_LEN);
                segmentInfo.setSegmentLength(ReaderUtils.convertByteArrayToBCS_NPI(lsBytes));
                offset += LS_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                graphicSegments.add(segmentInfo);
            }
            offset += NUMX_LEN;
            byte[] numtBytes = getBytesAt(offset, NUMT_LEN);
            offset += NUMT_LEN;
            int numTextSegments = ReaderUtils.convertByteArrayToBCS_NPI(numtBytes);
            for (int i = 0; i < numTextSegments; i++) {
                SegmentInfo segmentInfo = new SegmentInfo(i);
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] ltshBytes = getBytesAt(offset, LTSH_LEN);
                segmentInfo.setSubheaderLength(ReaderUtils.convertByteArrayToBCS_NPI(ltshBytes));
                offset += LTSH_LEN;
                nextSegmentStartOffset += segmentInfo.getSubheaderLength();
                byte[] ltBytes = getBytesAt(offset, LT_LEN);
                segmentInfo.setSegmentLength(ReaderUtils.convertByteArrayToBCS_NPI(ltBytes));
                offset += LT_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                textSegments.add(segmentInfo);
            }
            byte[] numdesBytes = getBytesAt(offset, NUMDES_LEN);
            offset += NUMDES_LEN;
            int numDES = ReaderUtils.convertByteArrayToBCS_NPI(numdesBytes);
            for (int i = 0; i < numDES; i++) {
                SegmentInfo segmentInfo = new SegmentInfo(i);
                segmentInfo.setSegmentFileOffset(nextSegmentStartOffset);
                byte[] ldshBytes = getBytesAt(offset, LDSH_LEN);
                segmentInfo.setSubheaderLength(ReaderUtils.convertByteArrayToBCS_NPI(ldshBytes));
                offset += LDSH_LEN;
                nextSegmentStartOffset += segmentInfo.getSubheaderLength();
                byte[] ldBytes = getBytesAt(offset, LD_LEN);
                segmentInfo.setSegmentLength(ReaderUtils.convertByteArrayToBCS_NPI(ldBytes));
                offset += LD_LEN;
                nextSegmentStartOffset += segmentInfo.getSegmentLength();
                dataExtensionSegments.add(segmentInfo);
            }
            offset += NUMRES_LEN;
            // Assume there are never RES
            int udhdl = ReaderUtils.convertByteArrayToBCS_NPI(getBytesAt(offset, UDHDL_LEN));
            offset += UDHDL_LEN;
            if (udhdl != 0) {
                udhofl = ReaderUtils.convertByteArrayToBCS_NPI(getBytesAt(offset, UDHOFL_LEN));
                offset += UDHOFL_LEN;
                udhdOffset = offset;
                udhdLength = udhdl - UDHOFL_LEN;
                offset += udhdLength;
            }
            int xhdl = ReaderUtils.convertByteArrayToBCS_NPI(getBytesAt(offset, XHDL_LEN));
            offset += XHDL_LEN;
            if (xhdl != 0) {
                xhdlofl = ReaderUtils.convertByteArrayToBCS_NPI(getBytesAt(offset, XHDLOFL_LEN));
                offset += XHDLOFL_LEN;
                xhdOffset = offset;
                xhdLength = xhdl - XHDLOFL_LEN;
            }
            for (ImageSegmentInfo imageSegmentInfo : imageSegments) {
                getImageSegmentSpecificInfo(imageSegmentInfo);
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
        return ReaderUtils.convertByteArrayToBCS_NPI(bytes);
    }

    /**
     * Get the originating station identifier for the file.
     *
     * @return originating station as text
     */
    public String getOSTAID() {
        byte[] bytes = getBytesAt(OSTAID_OFFSET, OSTAID_LEN);
        return ReaderUtils.convertByteArrayToBCSA(bytes);
    }

    /**
     * Get the date and time (UTC) of the file’s origination.
     *
     * @return date / time in the format CCYYMMDDhhmmss.
     */
    public String getFileDateTime() {
        byte[] bytes = getBytesAt(FDT_OFFSET, ReaderUtils.DATE_TIME_LEN);
        // The character set is BCS-N, but we need a string here.
        return ReaderUtils.convertByteArrayToBCSA(bytes);
    }

    /**
     * Get the originator's name for the file.
     *
     * @return name as text (can be space filled)
     */
    public String getONAME() {
        byte[] bytes = getBytesAt(ONAME_OFFSET, ONAME_LEN);
        return ReaderUtils.convertByteArrayToECSA(bytes);
    }

    /**
     * Get the originator's phone number for the file.
     *
     * @return phone number as text (can be space filled)
     */
    public String getOPHONE() {
        byte[] bytes = getBytesAt(OPHONE_OFFSET, OPHONE_LEN);
        return ReaderUtils.convertByteArrayToECSA(bytes);
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
        if ((udhdOffset <= 0) || (udhdLength <= 0)) {
            return new byte[0];
        }
        return getBytesAt(udhdOffset, udhdLength);
    }

    public byte[] getExtendedHeaderData() {
        if ((xhdOffset <= 0) || (xhdLength <= 0)) {
            return new byte[0];
        }
        return getBytesAt(xhdOffset, xhdLength);
    }

    public byte[] getBytesAt(int offset, int len) {
        mappedByteBuffer.position(offset);
        byte[] dest = new byte[len];
        mappedByteBuffer.get(dest);
        return dest;
    }

    private int getFileHeaderLength() {
        byte[] bytes = getBytesAt(HL_OFFSET, HL_LEN);
        return ReaderUtils.convertByteArrayToBCS_NPI(bytes);
    }

    public ImageSegmentInfo getImageSegmentInfo(int segmentNumber) {
        return imageSegments.get(segmentNumber);
    }

    public ImageSegmentHeader getImageSegmentHeader(int segmentNumber) {
        SegmentInfo segmentInfo = imageSegments.get(segmentNumber);
        byte[] subheaderBytes =
                getBytesAt(segmentInfo.getSegmentFileOffset(), segmentInfo.getSubheaderLength());
        return new ImageSegmentHeader(subheaderBytes);
    }

    private void getImageSegmentSpecificInfo(ImageSegmentInfo imageSegmentInfo) {
        int segmentNumber = imageSegmentInfo.getSegmentNumber();
        ImageSegmentHeader ish = getImageSegmentHeader(segmentNumber);
        imageSegmentInfo.setImageSegmentHeader(ish);
        // String imode = ish.getImode();
        String ic = ish.getIc();
        // System.out.println("IMODE: " + imode);
        if (ic.startsWith("M") || ic.equals("NM")) {
            int offset =
                    imageSegmentInfo.getSegmentFileOffset() + imageSegmentInfo.getSubheaderLength();
            byte[] offsetBytes = getBytesAt(offset, Integer.BYTES);
            offset += Integer.BYTES;
            int imdatoff = java.nio.ByteBuffer.wrap(offsetBytes).getInt();
            // System.out.println("IMDATOFF: " + imdatoff);
            imageSegmentInfo.setImageDataOffset(imdatoff);
            byte[] bmrlnthBytes = getBytesAt(offset, Short.BYTES);
            offset += Short.BYTES;
            int bmrlnth = java.nio.ByteBuffer.wrap(bmrlnthBytes).getShort();
            // System.out.println("BMRLNTH: " + bmrlnth);
            // byte[] tmrlnthBytes = getBytesAt(offset, Short.BYTES);
            offset += Short.BYTES;
            // int tmrlnth = java.nio.ByteBuffer.wrap(tmrlnthBytes).getShort();
            // System.out.println("TMRLNTH: " + tmrlnth);
            // byte[] tpxcdlnthBytes = getBytesAt(offset, Short.BYTES);
            offset += Short.BYTES;
            // int tpxcdlnth = java.nio.ByteBuffer.wrap(tpxcdlnthBytes).getShort();
            // System.out.println("TPXCDLNTH: " + tpxcdlnth);
            // TODO: this logic isn't complete for all possible masking options
            if (bmrlnth > 0) {
                for (int r = 0; r < ish.getNbpr(); r++) {
                    for (int c = 0; c < ish.getNbpc(); c++) {
                        byte[] bmrBytes = getBytesAt(offset, bmrlnth);
                        offset += bmrlnth;
                        int bmr = java.nio.ByteBuffer.wrap(bmrBytes).getInt();
                        // System.out.println("BMR: " + bmr);
                        ImageBlockInfo imageBlockInfo = new ImageBlockInfo(bmr, c, r);
                        imageSegmentInfo.addImageBlock(imageBlockInfo);
                    }
                }
                for (int i = 0; i < imageSegmentInfo.getImageBlocks().size() - 1; i++) {
                    ImageBlockInfo imageBlockInfo = imageSegmentInfo.getImageBlocks().get(i);
                    ImageBlockInfo nextImageBlockInfo =
                            imageSegmentInfo.getImageBlocks().get(i + 1);
                    int length =
                            nextImageBlockInfo.getBlockOffset() - imageBlockInfo.getBlockOffset();
                    imageBlockInfo.setBlockLength(length);
                }
                // last block, need to use total segment length
                ImageBlockInfo lastBlock =
                        imageSegmentInfo
                                .getImageBlocks()
                                .get(imageSegmentInfo.getImageBlocks().size() - 1);
                int length =
                        imageSegmentInfo.getSegmentLength() - imdatoff - lastBlock.getBlockOffset();
                lastBlock.setBlockLength(length);
            }
        }
    }

    public void saveImageSegmentBody(int segmentNumber, String path) throws IOException {
        ImageSegmentInfo segmentInfo = imageSegments.get(segmentNumber);
        for (int i = 0; i < segmentInfo.getImageBlocks().size(); i++) {
            // TODO: find a way to stream this out
            ImageBlockInfo imageBlockInfo = segmentInfo.getImageBlocks().get(i);
            byte[] blockBytes =
                    getBytesAt(
                            segmentInfo.getSegmentFileOffset()
                                    + segmentInfo.getSubheaderLength()
                                    + segmentInfo.getImageDataOffset()
                                    + imageBlockInfo.getBlockOffset(),
                            imageBlockInfo.getBlockLength());
            File file = new File(path + "_" + i + ".h264");
            Files.write(file.toPath(), blockBytes);
        }
    }

    public TextSegmentHeader getTextSegmentHeader(int segmentNumber) {
        SegmentInfo segmentInfo = textSegments.get(segmentNumber);
        byte[] subheaderBytes =
                getBytesAt(segmentInfo.getSegmentFileOffset(), segmentInfo.getSubheaderLength());
        return new TextSegmentHeader(subheaderBytes);
    }

    public String getTextSegmentBody(int segmentNumber) {
        SegmentInfo segmentInfo = textSegments.get(segmentNumber);
        byte[] segmentBytes =
                getBytesAt(
                        segmentInfo.getSegmentFileOffset() + segmentInfo.getSubheaderLength(),
                        segmentInfo.getSegmentLength());
        return ReaderUtils.convertByteArrayToECSA(segmentBytes);
    }

    // These are temporary.
    public int getUdhofl() {
        return udhofl;
    }

    public int getXhdlofl() {
        return xhdlofl;
    }

    public List<TRE> getFileTREs() {
        TREParser parser = new TREParser();
        List<TRE> tres = new ArrayList<>();
        byte[] udhd = getUserDefinedHeaderData();
        if (udhd.length > 0) {
            tres.addAll(parser.parse(udhd));
        }
        byte[] xhd = getExtendedHeaderData();
        if (xhd.length > 0) {
            tres.addAll(parser.parse(xhd));
        }
        // TODO: overflow DES.
        return tres;
    }
}
