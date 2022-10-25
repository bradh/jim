package net.frogmouth.rnd.jim.nitf.image;

import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ABPP_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ICAT_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ICOM_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ICORDS_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IC_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IID1_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IID2_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IREP_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ISORCE_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NCOLS_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NICOM_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NROWS_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.PJUST_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.PVTYPE_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.TGTID_LEN;
import static net.frogmouth.rnd.jim.nitf.utils.ReaderUtils.ENCRYP_LEN;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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
    private PixelValueType pixelValueType;
    private ImageRepresentation imageRepresentation;
    private ImageCategory imageCategory;
    private int actualBitsPerPixelPerBand;
    private String pixelJustification = "R";
    private CoordinateRepresentation coordinateRepresentation = CoordinateRepresentation.None;
    private List<String> comments = new ArrayList<>();
    private ImageCompression imageCompression;

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
        baos.writeBytes(WriterUtils.toBCS_A(pixelValueType.getEncodedValue(), PVTYPE_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(imageRepresentation.getEncodedValue(), IREP_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(imageCategory.getEncodedValue(), ICAT_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(actualBitsPerPixelPerBand, ABPP_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(pixelJustification, PJUST_LEN));
        baos.writeBytes(
                WriterUtils.toBCS_A(coordinateRepresentation.getEncodedValue(), ICORDS_LEN));
        // TODO: IGEOLO
        baos.writeBytes(WriterUtils.toBCS_NPI(comments.size(), NICOM_LEN));
        for (String comment : comments) {
            baos.writeBytes(WriterUtils.toECS_A(comment, ICOM_LEN));
        }
        baos.writeBytes(WriterUtils.toBCS_A(imageCompression.getEncodedValue(), IC_LEN));
        // TODO: COMRAT onwards
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

    /**
     * Pixel Value Type (PVTYPE).
     *
     * <p>This field contains an indicator of the type of computer representation used for the value
     * for each pixel for each band in the image.
     *
     * <p>This is typically {@code INT} for visual imagery.
     *
     * @return the pixel value type.
     */
    public PixelValueType getPixelValueType() {
        return pixelValueType;
    }

    /**
     * Set the Pixel Value Type (PVTYPE).
     *
     * <p>This field contains an indicator of the type of computer representation used for the value
     * for each pixel for each band in the image.
     *
     * @param pixelValueType the pixel value type.
     */
    public void setPixelValueType(PixelValueType pixelValueType) {
        this.pixelValueType = pixelValueType;
    }

    /**
     * Image representation (IREP).
     *
     * <p>This field contains a valid indicator of the processing required to display an image.
     *
     * <p>This field should be used in conjunction with the IREPBANDn field to interpret the
     * processing required to display each band in the image
     *
     * @return the image representation for the image segment.
     */
    public ImageRepresentation getImageRepresentation() {
        return imageRepresentation;
    }

    /**
     * Set image representation (IREP).
     *
     * <p>This field contains a valid indicator of the processing required to display an image.
     *
     * <p>This field should be used in conjunction with the IREPBANDn field to interpret the
     * processing required to display each band in the image
     *
     * @param imageRepresentation the image representation for the image segment.
     */
    public void setImageRepresentation(ImageRepresentation imageRepresentation) {
        this.imageRepresentation = imageRepresentation;
    }

    /**
     * Image category (ICAT).
     *
     * <p>This field contains a valid indicator of the specific category of image, raster, or grid
     * data. The specific category of an IS reveals its intended use or the nature of its collector.
     *
     * <p>Where the ICAT field designates a MI implementation, the string “.M” is added to a STI
     * ICAT value. Where adding “.M” causes an ICAT value to exceed the allowed length of 8
     * characters, the last letter(s) of the STI ICAT value are omitted so that the MI ICAT value is
     * exactly 8 characters in length.
     *
     * @return the image category.
     */
    public ImageCategory getImageCategory() {
        return imageCategory;
    }

    /**
     * Set the image category (ICAT).
     *
     * <p>This field contains a valid indicator of the specific category of image, raster, or grid
     * data. The specific category of an IS reveals its intended use or the nature of its collector.
     *
     * <p>Where the ICAT field designates a MI implementation, the string “.M” is added to a STI
     * ICAT value. Where adding “.M” causes an ICAT value to exceed the allowed length of 8
     * characters, the last letter(s) of the STI ICAT value are omitted so that the MI ICAT value is
     * exactly 8 characters in length.
     *
     * @param imageCategory the image category.
     */
    public void setImageCategory(ImageCategory imageCategory) {
        this.imageCategory = imageCategory;
    }

    /**
     * Actual bits per pixel per band (ABPP).
     *
     * <p>This field contains the number of “significant bits” for the value in each band of each
     * pixel without compression. Even for a compressed image, ABPP contains the number of
     * significant bits per pixel that were present in the image before compression. The ABPP field
     * is less than or equal to Number of Bits Per Pixel (field NBPP). The number of adjacent bits
     * within each NBPP represents the value.
     *
     * <p>The ABPP field “representation bits” is left justified or right justified within the bits
     * of the NBPP field, according to the value in the PJUST field. For example, storing 11-bit
     * pixels in 16 bits, the ABPP field is 11 and NBPP is 16. The default number of significant
     * bits is the value contained in NBPP.
     *
     * @return the actual bits per pixel per band.
     */
    public int getActualBitsPerPixelPerBand() {
        return actualBitsPerPixelPerBand;
    }

    /**
     * Set the actual bits per pixel per band (ABPP).
     *
     * <p>This field contains the number of “significant bits” for the value in each band of each
     * pixel without compression. Even for a compressed image, ABPP contains the number of
     * significant bits per pixel that were present in the image before compression. The ABPP field
     * is less than or equal to Number of Bits Per Pixel (field NBPP). The number of adjacent bits
     * within each NBPP represents the value.
     *
     * <p>The ABPP field “representation bits” is left justified or right justified within the bits
     * of the NBPP field, according to the value in the PJUST field. For example, storing 11-bit
     * pixels in 16 bits, the ABPP field is 11 and NBPP is 16. The default number of significant
     * bits is the value contained in NBPP.
     *
     * @param actualBitsPerPixelPerBand the actual bits per pixel per band.
     */
    public void setActualBitsPerPixelPerBand(int actualBitsPerPixelPerBand) {
        this.actualBitsPerPixelPerBand = actualBitsPerPixelPerBand;
    }

    /**
     * Pixel Justification (PJUST).
     *
     * <p>Where that ABPP is not equal to NBPP, this field indicates whether the significant bits
     * are left justified (L) or right justified (R). Nonsignificant bits in each pixel are filled
     * with the binary value 0.
     *
     * <p>Right justification is recommended.
     *
     * @return the pixel justification ({@code L} or {@code R}).
     */
    public String getPixelJustification() {
        return pixelJustification;
    }

    public void setPixelJustification(String pixelJustification) {
        this.pixelJustification = pixelJustification;
    }

    /**
     * Coordinate representation (ICORDS).
     *
     * <p>Indicates the type of coordinate representation used.
     *
     * @return the coordinate representation
     */
    public CoordinateRepresentation getCoordinateRepresentation() {
        return coordinateRepresentation;
    }

    /**
     * Set the coordinate representation (ICORDS).
     *
     * <p>Indicates the type of coordinate representation used.
     *
     * @param coordinateRepresentation the coordinate representation
     */
    public void setCoordinateRepresentation(CoordinateRepresentation coordinateRepresentation) {
        this.coordinateRepresentation = coordinateRepresentation;
    }

    /**
     * Image compression (IC).
     *
     * <p>This specifies the form of compression used in representing the image data.
     *
     * @return the image compression as an enumeration value.
     */
    public ImageCompression getImageCompression() {
        return imageCompression;
    }

    /**
     * Set the image compression (IC).
     *
     * <p>This specifies the form of compression used in representing the image data.
     *
     * @param imageCompression the image compression as an enumeration value.
     */
    public void setImageCompression(ImageCompression imageCompression) {
        this.imageCompression = imageCompression;
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
