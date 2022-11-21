package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Collection data.
 *
 * <p>The collectionData container specifies information about the telescope imaging the space
 * object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "collectionReqId",
    "priority",
    "revNumber",
    "passNumber",
    "background",
    "lightingCondition",
    "appVisualMagnitude",
    "reflectance",
    "snr"
})
public class CollectionData {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String collectionReqId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer priority;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer revNumber;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer passNumber;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Background background;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "lightingCondition")
    private List<LightingCondition> lightingConditions;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double appVisualMagnitude;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer reflectance;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double snr;

    /** Constructor. */
    public CollectionData() {}

    /**
     * Constructor.
     *
     * @param other the source object to copy values from.
     */
    public CollectionData(CollectionData other) {
        this.collectionReqId = other.collectionReqId;
        this.priority = other.priority;
        this.revNumber = other.revNumber;
        this.passNumber = other.passNumber;
        this.background = other.background;
        this.lightingConditions = other.lightingConditions;
        this.appVisualMagnitude = other.appVisualMagnitude;
        this.reflectance = other.reflectance;
        this.snr = other.snr;
    }

    /**
     * Collection requirement identifier.
     *
     * <p>A unique collection requirement identifier assigned by the information system responsible
     * for the tasking of a specific collection with a space object.
     *
     * @return the collection requirement identifier.
     */
    public String getCollectionReqId() {
        return collectionReqId;
    }

    public void setCollectionReqId(String collectionReqId) {
        this.collectionReqId = collectionReqId;
    }

    /**
     * Priority.
     *
     * <p>The numerically prioritised significance of the tasked space object collection, including
     * any emphasis. A value of zero (0) represents the highest priority and priority decreases as
     * the numeric value of the priority element increases. Beyond the relative relationship between
     * two priority values, interpretation of any specific priority value is dependent on the data
     * provider. Data consumers must consult with the specific data provider to interpret specific
     * priority values.
     *
     * @return the priority, or null if not specified
     */
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Revision number.
     *
     * <p>The cumulative revolution count over the life of the satellite at the time the satellite
     * was imaged. The {@code revNumber} ≥ 0 where {@code rev} 0 is the period from launch until the
     * first ascending node and {@code rev} 1 starts at the first ascending node. {@code rev} number
     * increases by one at each succeeding ascending node.
     *
     * @return the revision number, or null if not specified.
     */
    public Integer getRevNumber() {
        return revNumber;
    }

    public void setRevNumber(Integer revNumber) {
        this.revNumber = revNumber;
    }

    /**
     * Pass number.
     *
     * <p>Indicates the day specific satellite revolution which is one complete orbit beginning at
     * the ascending node at the time the satellite was imaged. Each day, passes are sequentially
     * numbered from 1 to n with Pass 1 beginning at the first ascending node after 00:00 in UTC
     * date and time.
     *
     * @return the pass number, or null if not specified.
     */
    public Integer getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(Integer passNumber) {
        this.passNumber = passNumber;
    }

    /**
     * Background.
     *
     * <p>The primary or most prominent celestial body and its illumination state present in the
     * space object look background.
     *
     * @return the background as an enumerated value, or null if not specified.
     */
    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    /**
     * Lighting conditions.
     *
     * <p>Identifies the natural illumination source of the space object. The data provider shall
     * list all sources of illumination that apply, starting with the most significant source.
     *
     * @return the list of lighting conditions
     */
    public List<LightingCondition> getLightingConditions() {
        return new ArrayList<>(lightingConditions);
    }

    public void setLightingConditions(List<LightingCondition> lightingConditions) {
        this.lightingConditions = new ArrayList<>(lightingConditions);
    }

    /**
     * Apparent visual magnitude.
     *
     * <p>Apparent visual magnitude is a unitless measure based on an unbounded logarithmic scale
     * factored by the space object's apparent brightness as observed at the time of collection, its
     * orientation to any source(s) of illumination, and viewing geometry, of the space object’s
     * measured radiance to a calibrated reference's (e.g., Vega) radiance. Negative values on the
     * graduated scale represent more intense brightness than less intense positive values, where
     * the apparent visual magnitude scale is calibrated relative to a specified space object,
     * typically Vega = 0. Apparent visual magnitude does not factor in distance.
     *
     * @return the apparent visual magnitude, or null if not specified.
     */
    public Double getAppVisualMagnitude() {
        return appVisualMagnitude;
    }

    public void setAppVisualMagnitude(Double appVisualMagnitude) {
        this.appVisualMagnitude = appVisualMagnitude;
    }

    /**
     * Reflectance.
     *
     * <p>The typical coefficient of reflectance of the space object over all possible viewing
     * angles, ranging from 0 (none) to 100 (perfect reflectance).
     *
     * @return the reflectance in the range 0 to 100, or null if not specified.
     */
    public Integer getReflectance() {
        return reflectance;
    }

    public void setReflectance(Integer reflectance) {
        this.reflectance = reflectance;
    }

    /**
     * Signal to noise ratio.
     *
     * <p>Signal-to-Noise Ratio (SNR) is the ratio of a power of a signal to the power of background
     * noise on the space object, expressed in units of decibels (dB).
     *
     * @return the signal to noise ratio, or null if not specified.
     */
    public Double getSnr() {
        return snr;
    }

    public void setSnr(Double snr) {
        this.snr = snr;
    }
}
