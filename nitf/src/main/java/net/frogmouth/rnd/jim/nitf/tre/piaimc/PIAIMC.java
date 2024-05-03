package net.frogmouth.rnd.jim.nitf.tre.piaimc;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/**
 * Profile for Imagery Access Image - Version C (PIAIMC).
 *
 * <p>This support extension is designed to provide an area to place fields not currently carried in
 * NITF but are contained in the Standards Profile for Imagery Access (SPIA). Most imagery related
 * information is contained in the NITF main headers and Support Data Extensions (SDEs). The purpose
 * of this extension is to minimize redundant fields while providing space for all information. This
 * extension shall be present no more than once for each image in the NITF file. When present, this
 * extension shall be contained within the image extended subheader data field of the image
 * subheader or within an overflow DES if there is insufficient room to place the entire extension
 * within the image extended subheader data field. This extension may alternatively be placed in the
 * file header, either the extended header or the user defined header locations, when the
 * information it contains pertains to more than one image segment in the file.
 */
public class PIAIMC extends TaggedRecordExtension {

    private static final String TRE_TAG = "PIAIMC";
    private int cloudCover = 999;
    private String standardRadiometricProduct;
    private String sensorMode;
    private String sensorName;
    private String source;
    private int compressionGeneration = 0;
    private String subjectiveQuality;
    // TODO: more field, see page C-9

    public PIAIMC() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "CLOUDCVR")
    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    @TREOrder(order = 2)
    @TREField(label = "SRP")
    public String getStandardRadiometricProduct() {
        return standardRadiometricProduct;
    }

    public void setStandardRadiometricProduct(String standardRadiometricProduct) {
        this.standardRadiometricProduct = standardRadiometricProduct;
    }

    @TREOrder(order = 3)
    @TREField(label = "SENSMODE")
    public String getSensorMode() {
        return sensorMode;
    }

    public void setSensorMode(String sensorMode) {
        this.sensorMode = sensorMode;
    }

    @TREOrder(order = 4)
    @TREField(label = "SENSNAME")
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    @TREOrder(order = 5)
    @TREField(label = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @TREOrder(order = 6)
    @TREField(label = "COMGEN")
    public int getCompressionGeneration() {
        return compressionGeneration;
    }

    public void setCompressionGeneration(int compressionGeneration) {
        this.compressionGeneration = compressionGeneration;
    }

    @TREOrder(order = 7)
    @TREField(label = "SUBQUAL")
    public String getSubjectiveQuality() {
        return subjectiveQuality;
    }

    public void setSubjectiveQuality(String subjectiveQuality) {
        this.subjectiveQuality = subjectiveQuality;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
