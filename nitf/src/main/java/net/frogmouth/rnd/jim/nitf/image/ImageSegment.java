package net.frogmouth.rnd.jim.nitf.image;

import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IID1_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IID2_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ISORCE_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NCOLS_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NROWS_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.TGTID_LEN;
import static net.frogmouth.rnd.jim.nitf.utils.ReaderUtils.ENCRYP_LEN;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.nitf.JBPDateTime;
import net.frogmouth.rnd.jim.nitf.SecurityMetadata;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class ImageSegment {

    private static final byte[] IM_HEADER = "IM".getBytes(StandardCharsets.US_ASCII);
    private static final int DEFAULT_ENCRYP_VALUE = 0;

    private String iid1 = "";
    private JBPDateTime dateTime = new JBPDateTime();
    private String targetId = "";
    private String iid2 = "";
    private SecurityMetadata securityMetadata = new SecurityMetadata();
    private String imageSource = "";
    private int numberOfSignificantRows = 0;
    private int numberOfSignificantColumns = 0;

    public byte[] getSubheaderAsBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(IM_HEADER);
        baos.writeBytes(WriterUtils.toBCS_A(iid1, IID1_LEN));
        baos.writeBytes(dateTime.asBytes());
        baos.writeBytes(WriterUtils.toBCS_A(targetId, TGTID_LEN));
        baos.writeBytes(WriterUtils.toECS_A(iid2, IID2_LEN));
        baos.writeBytes(securityMetadata.asBytes());
        baos.writeBytes(WriterUtils.toBCS_NPI(DEFAULT_ENCRYP_VALUE, ENCRYP_LEN));
        baos.writeBytes(WriterUtils.toECS_A(imageSource, ISORCE_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(numberOfSignificantRows, NROWS_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(numberOfSignificantColumns, NCOLS_LEN));
        // TODO: PVTYPE onwards
        /*
        writeExtensionArea(baos);
        */
        return baos.toByteArray();
    }

    public int getLengthOfImageSegment() {
        // TODO
        return 0;
    }

    public int getSubheaderLengthInBytes() {
        // TODO: just use getSubheaderAsBytes?
        return 439;
    }

    public String getIid1() {
        return iid1;
    }

    public void setIid1(String iid1) {
        this.iid1 = iid1;
    }

    public JBPDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(JBPDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getIid2() {
        return iid2;
    }

    public void setIid2(String iid2) {
        this.iid2 = iid2;
    }

    /**
     * Image Source (ISORCE).
     *
     * <p>This field contains a description of the source of the image.
     *
     * <p>Where the ISORCE field is populated with all ECS-A spaces (0x20), this means no image
     * source data applies. Where the source of the data is classified, the ISORCE field is preceded
     * by the classification of the contents of the ISORCE field, including codeword(s) contained in
     * the NTB Field Value Registry,
     *
     * @return description of the image source, or spaces.
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * Set the Image Source (ISORCE).
     *
     * <p>This field contains a description of the source of the image.
     *
     * <p>Where the ISORCE field is populated with all ECS-A spaces (0x20), this means no image
     * source data applies. Where the source of the data is classified, the ISORCE field is preceded
     * by the classification of the contents of the ISORCE field, including codeword(s) contained in
     * the NTB Field Value Registry,
     *
     * @param imageSource description of the image source.
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public SecurityMetadata getSecurityMetadata() {
        return securityMetadata;
    }

    public void setSecurityMetadata(SecurityMetadata securityMetadata) {
        this.securityMetadata = securityMetadata;
    }

    public byte[] getBodyAsBytes() {
        // TODO:
        return new byte[0];
    }
}
