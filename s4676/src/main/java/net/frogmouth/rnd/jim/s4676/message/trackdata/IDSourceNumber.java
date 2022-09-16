package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Identity source number.
 *
 * <p>Generic grouping of ID sources which are based on similar principles regarding the use and
 * meaning of their declarations and concerning the principles to generate the ID source
 * declarations.
 *
 * <p>See Allied Identification Process Publication AIDPP-01, Edition A, Version 1, IDENTIFICATION
 * DATA COMBINING PROCESS (covered by STANAG 4162) for more details. Note that this document is not
 * publicly released.
 */
@JsonPropertyOrder({"sourceType", "sourceSubtype", "sourceDeviceClass"})
public class IDSourceNumber {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String sourceType;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String sourceSubtype;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String sourceDeviceClass;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Please use the version that includes mandatory values.
     */
    private IDSourceNumber() {}

    /**
     * Constructor.
     *
     * <p>The source type is the generic grouping of ID sources which are based on similar
     * principles regarding the use and meaning of their declarations and concerning the principles
     * to generate the ID Source declarations.
     *
     * <p>The source sub-type is one of a subgroup which have similar ID Sources concerning the
     * origin or use of the ID Source.
     *
     * <p>The source device class specifies the precise ID source. All ID sources of a device class
     * use the same collateral or configuration data and the same process for the generation of the
     * ID source declaration.
     *
     * <p>Note that there are specific value and format requirements for these values to be valid.
     *
     * @param sourceType the source type
     * @param sourceSubtype the source sub-type
     * @param sourceDeviceClass the source device class
     */
    public IDSourceNumber(String sourceType, String sourceSubtype, String sourceDeviceClass) {
        this.sourceType = sourceType;
        this.sourceSubtype = sourceSubtype;
        this.sourceDeviceClass = sourceDeviceClass;
    }

    /**
     * Source type.
     *
     * <p>Generic grouping of ID sources which are based on similar principles regarding the use and
     * meaning of their declarations and concerning the principles to generate the ID Source
     * declarations.
     *
     * @return the source type
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Source sub-type.
     *
     * <p>Subgroups which have similar ID Sources concerning the origin or use of the ID Source.
     *
     * @return the source sub-type.
     */
    public String getSourceSubtype() {
        return sourceSubtype;
    }

    /**
     * Source device class.
     *
     * <p>Specifies the precise ID source. All ID sources of a device class use the same collateral
     * or configuration data and the same process for the generation of the ID source declaration.
     *
     * @return source device class
     */
    public String getSourceDeviceClass() {
        return sourceDeviceClass;
    }
}
