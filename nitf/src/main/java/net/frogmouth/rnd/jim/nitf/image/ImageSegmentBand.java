package net.frogmouth.rnd.jim.nitf.image;

import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IFC_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IMFLT_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.IREPBAND_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.ISUBCAT_LEN;
import static net.frogmouth.rnd.jim.nitf.image.ImageConstants.NLUTS_LEN;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

/** Image segment band. */
public class ImageSegmentBand {

    private String bandRepresentation = "";
    private String subCategory = "";
    private String imageFilterCondition = "N";
    private String imageFilterCode = "";
    private List<ImageBandLookupTable> luts = new ArrayList<>();

    public byte[] asBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_A(bandRepresentation, IREPBAND_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(subCategory, ISUBCAT_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(imageFilterCondition, IFC_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(imageFilterCode, IMFLT_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(luts.size(), NLUTS_LEN));
        // TODO: NELUTS / LUTD
        return baos.toByteArray();
    }

    /**
     * Band representation.
     *
     * <p>Note the valid values for this are interdependent on other fields. Refer JBP.
     *
     * @return the band representation as a String value.
     */
    public String getBandRepresentation() {
        return bandRepresentation;
    }

    /**
     * Set the band representation.
     *
     * <p>Note the valid values for this are interdependent on other fields. Refer JBP.
     *
     * @param bandRepresentation the band representation as String value.
     */
    public void setBandRepresentation(String bandRepresentation) {
        this.bandRepresentation = bandRepresentation;
    }

    /**
     * Band subcategory.
     *
     * <p>Note the valid values for this are interdependent on other fields. Refer JBP.
     *
     * @return the band subcategory as a String.
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * Set the band subcategory.
     *
     * <p>Note the valid values for this are interdependent on other fields. Refer JBP.
     *
     * @param subCategory the band subcategory as a String.
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     * Image filter condition (IFC).
     *
     * <p>This field should always contain {@code N}, indicating "None". Other values are reserved
     * for future use.
     *
     * @return the image filter condition as a String
     */
    public String getImageFilterCondition() {
        return imageFilterCondition;
    }

    /**
     * Set the image filter condition (IFC).
     *
     * <p>This field should always contain {@code N}, indicating "None". Other values are reserved
     * for future use.
     *
     * @param imageFilterCondition the image filter condition as a String
     */
    public void setImageFilterCondition(String imageFilterCondition) {
        this.imageFilterCondition = imageFilterCondition;
    }

    /**
     * Image filter code (IMFLT).
     *
     * <p>This field should always be space filled. All values are reserved for future use.
     *
     * @return the image filter code.
     */
    public String getImageFilterCode() {
        return imageFilterCode;
    }

    /**
     * Set the image filter code (IMFLT).
     *
     * <p>This field should always be space filled. All values are reserved for future use.
     *
     * @param imageFilterCode the image filter code.
     */
    public void setImageFilterCode(String imageFilterCode) {
        this.imageFilterCode = imageFilterCode;
    }

    public List<ImageBandLookupTable> getLUTs() {
        return new ArrayList<>(luts);
    }

    void addLUT(ImageBandLookupTable lut) {
        this.luts.add(new ImageBandLookupTable(lut));
    }
}
