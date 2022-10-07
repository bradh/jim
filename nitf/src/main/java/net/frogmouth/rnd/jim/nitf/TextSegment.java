package net.frogmouth.rnd.jim.nitf;

import java.io.ByteArrayOutputStream;

public class TextSegment {

    private static final byte[] TE_HEADER = new byte[] {0x54, 0x45};

    private String identifier = "";
    private int attachmentLevel = 0;

    public byte[] getSubheaderAsBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(TE_HEADER);
        baos.writeBytes(WriterUtils.toBCS_A(identifier, 7));
        baos.writeBytes(WriterUtils.toBCS_NPI(attachmentLevel, 3));
        return baos.toByteArray();
    }

    public int getLengthOfTextSegment() {
        // TODO: implement real text length
        return getSubheaderAsBytes().length + 0;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
