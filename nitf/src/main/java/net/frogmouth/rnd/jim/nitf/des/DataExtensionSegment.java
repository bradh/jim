package net.frogmouth.rnd.jim.nitf.des;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.nitf.SecurityMetadata;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class DataExtensionSegment {

    private static final byte[] DE_HEADER = "DE".getBytes(StandardCharsets.US_ASCII);
    private static final int DESID_LEN = 25;
    private static final int DESVER_LEN = 2;
    private static final int DESSHL_LEN = 4;

    private String identifier = "";
    private int version = 1;
    private final SecurityMetadata securityMetadata = new SecurityMetadata();
    private byte[] subheader = new byte[0];
    private byte[] desData = new byte[0];

    public byte[] getSubheaderAsBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(DE_HEADER);
        baos.writeBytes(WriterUtils.toBCS_A(identifier, DESID_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(version, DESVER_LEN));
        baos.writeBytes(securityMetadata.asBytes());
        writeExtensionArea(baos);
        return baos.toByteArray();
    }

    private void writeExtensionArea(ByteArrayOutputStream baos) {
        baos.writeBytes(WriterUtils.toBCS_NPI(subheader.length, DESSHL_LEN));
        baos.writeBytes(subheader);
    }

    /**
     * Identifier for the Data Extension Segment (DESID).
     *
     * <p>This is used to define the kind of segment. Only registered values can be used.
     *
     * @return the identifier.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Set the identifier for the Data Extension Segment (DESID).
     *
     * <p>This is used to define the kind of segment. Only registered values can be used.
     *
     * @param identifier the identifier.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLengthOfDataExtensionSegment() {
        return desData.length;
    }

    public byte[] getDesData() {
        return desData.clone();
    }

    public void setDesData(byte[] desData) {
        this.desData = desData.clone();
    }
}
