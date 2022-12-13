package net.frogmouth.rnd.jim.nitf.des;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.nitf.SecurityMetadata;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

/**
 * Data extension segment (DES).
 *
 * <p>The DES structure allows the format to include different data types within a JBP file. Each
 * data type is encapsulated in its own DES. Each DES can carry only one data type, but a JBP file
 * can contain multiple DES. Multiple DES contained in one JBP file can be of the same or different
 * data types.
 */
public class DataExtensionSegment {

    private static final byte[] DE_HEADER = "DE".getBytes(StandardCharsets.US_ASCII);
    private static final int DESID_LEN = 25;
    private static final int DESVER_LEN = 2;
    private static final int DESSHL_LEN = 4;

    private String identifier = "";
    private int version = 1;
    private final SecurityMetadata securityMetadata = new SecurityMetadata();
    // TODO: should have getter / setter
    private byte[] subheader = new byte[0];
    private byte[] desData = new byte[0];

    /**
     * Data extension segment subheader as byte array.
     *
     * @return byte array corresponding the the serialised DES.
     */
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

    /**
     * Version number for the DES definition (DESVER).
     *
     * <p>A value string containing the alphanumeric version number of the use of the tag.
     *
     * <p>This is about the version of the format, and is a peer to the DESID. It does not represent
     * versioning of the DES content, rather versioning of the DES format.
     *
     * <p>Note: The version number is assigned as part of the registration process.
     *
     * <p>Value Range: 01 to 99
     *
     * @return the DES version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Set the version number for the DES definition (DESVER).
     *
     * <p>A value string containing the alphanumeric version number of the use of the tag.
     *
     * <p>This is about the version of the format, and is a peer to the DESID. It does not represent
     * versioning of the DES content, rather versioning of the DES format.
     *
     * <p>Note: The version number is assigned as part of the registration process.
     *
     * <p>Value Range: 01 to 99
     *
     * @param version the DES version.
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Length of DES content.
     *
     * @return the length of the DES, in bytes.
     */
    public int getLengthOfDataExtensionSegment() {
        return desData.length;
    }

    /**
     * DES data.
     *
     * @return the DES, as a byte array
     */
    public byte[] getDesData() {
        return desData.clone();
    }

    /**
     * Set the DES data.
     *
     * @param desData the DES data as a byte array
     */
    public void setDesData(byte[] desData) {
        this.desData = desData.clone();
    }
}
