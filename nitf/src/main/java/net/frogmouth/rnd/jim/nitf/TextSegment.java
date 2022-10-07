package net.frogmouth.rnd.jim.nitf;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class TextSegment {

    private static final byte[] TE_HEADER = new byte[] {0x54, 0x45};
    private static final int DEFAULT_ENCRYP_VALUE = 0;

    private String identifier = "";
    private int attachmentLevel = 0;
    private final SecurityMetadata securityMetadata = new SecurityMetadata();
    private String body;

    public byte[] getSubheaderAsBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(TE_HEADER);
        baos.writeBytes(WriterUtils.toBCS_A(identifier, 7));
        baos.writeBytes(WriterUtils.toBCS_NPI(attachmentLevel, 3));
        // TODO: proper date handling
        baos.writeBytes(WriterUtils.toBCS_A("--------------", 14));
        // TODO: proper title handling
        baos.writeBytes(WriterUtils.toECS_A("", 80));
        baos.writeBytes(securityMetadata.asBytes());
        baos.writeBytes(WriterUtils.toBCS_NPI(DEFAULT_ENCRYP_VALUE, 1));
        // TODO: proper format encoding - enum?
        baos.writeBytes(WriterUtils.toBCS_A("STA", 3));
        // TODO: proper handling of extension area
        baos.writeBytes(WriterUtils.toBCS_NPI(0, 5));
        return baos.toByteArray();
    }

    public int getLengthOfTextSegment() {
        return getBodyAsBytes().length;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getBodyAsBytes() {
        // TODO: properly handle encoding
        return body.getBytes(StandardCharsets.US_ASCII);
    }
}
