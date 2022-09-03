package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.IDData;
import net.frogmouth.rnd.jim.s4676.enumeration.ModalityType;

/**
 * Sensor Information.
 *
 * <p>The SensorInformation class contains high-level information for a sensor used to collect data
 * on which tracking is performed. If a system has multiple sensors that are used to produce
 * detections, each sensor's information must be recorded as a separate instance of this class.
 * Information specified through the SensorInformation class is static throughout the entire
 * collection. Attributes of the sensor or how it is being operated that change over the course of
 * the collection are specified using the DynamicSourceInformation class, contained within the
 * TrackMessage class.
 *
 * <p>If the data producer is using the STANDALONE compliance profile, the NITS-compliant file must
 * contain at least one block of sensor information, unless the track data contained within is
 * ground truth tracks that are not derived from sensor measurements. If the data producer is using
 * the DATASTREAM compliance profile, the complete set of all NITSRoot objects in the data stream
 * must include at least one block of sensor information, but each sensor only has to be specified
 * in one object in that stream.
 *
 * <p>Tracks generated from evidence detected by one or more sensor(s) can specify the associated
 * sensor(s) by sensor UID/LID (see TrackSource). If there is only one sensor in the object, then it
 * is not required that the data producer designate a sensor UID/LID (since all tracks were
 * generated by the same sensor). However, the data producer must be cognizant of the intended use
 * of these objects by the data consumer. For example, if the intent of the data consumer is to
 * compare these data to other data sets that did not use the same sensor, then it may be critical
 * that the data producer assign an ID to the sensor and refer to it in each TrackSource object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "sensorID",
    "name",
    "description",
    "modality",
    "url",
    "collectionMode",
    "comment",
    "absTimeUncertainty",
    "relTimeUncertainty",
    "imagingSensor",
    "radarSensor",
    "esmSensor"
})
public class SensorInformation {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String uid;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    Long lid;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IDData sensorID;

    /** The name of the sensor. */
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String name;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String description;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ModalityType modality;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String url;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String collectionMode;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String comment;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a name and modality.
     */
    private SensorInformation() {}

    /**
     * Constructor.
     *
     * <p>There are two mandatory elements to the Sensor Information - a name, and the sensor
     * modality.
     *
     * <p>The name is a common name for the sensor.
     *
     * <p>The modality is a category of the sensor according to the type of signal it can detect.
     *
     * @param name the name
     * @param modality the modality
     */
    public SensorInformation(String name, ModalityType modality) {
        this.name = name;
        this.modality = modality;
    }

    /**
     * Sensor Unique Identifier.
     *
     * <p>A UUID associated with a particular block of sensor information.
     *
     * @return the unique identifier for this sensor information.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the Sensor Unique Identifier.
     *
     * <p>A UUID associated with a particular block of sensor information.
     *
     * @param uid the unique identifier for this sensor information.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Sensor Local Identifier.
     *
     * <p>A local ID associated with a particular block of sensor information.
     *
     * @return the local identifier for this sensor information.
     */
    public Long getLid() {
        return lid;
    }

    /**
     * Set the Sensor Local Identifier.
     *
     * <p>A local ID associated with a particular block of sensor information.
     *
     * @param lid the local identifier for this sensor information.
     */
    public void setLid(Long lid) {
        this.lid = lid;
    }

    /**
     * Get the sensor ID.
     *
     * <p>Identification information for a given NITS-capable system.
     *
     * @return the sensor ID
     */
    public IDData getSensorID() {
        return sensorID;
    }

    /**
     * Set the sensor ID.
     *
     * <p>Identification information for a given NITS-capable system.
     *
     * @param sensorID the sensor ID
     */
    public void setSensorID(IDData sensorID) {
        this.sensorID = sensorID;
    }

    /**
     * Get the sensor name.
     *
     * <p>The name of the sensor.
     *
     * @return the name of the sensor
     */
    public String getName() {
        return name;
    }

    /**
     * Get the sensor description.
     *
     * <p>A brief text depiction of the sensor.
     *
     * @return the sensor description as a text String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the sensor description.
     *
     * <p>A brief text depiction of the sensor.
     *
     * @param description the sensor description as a text String.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the sensor modality.
     *
     * <p>Category of the sensor according to the type of signal it can detect.
     *
     * @return the modality
     */
    public ModalityType getModality() {
        return modality;
    }

    /**
     * Set the sensor modality.
     *
     * <p>Category of the sensor according to the type of signal it can detect.
     *
     * @param modality the modality
     */
    public void setModality(ModalityType modality) {
        this.modality = modality;
    }

    /**
     * Get the URL.
     *
     * <p>A URL or URI describing the location of the sensor information data.
     *
     * @return String containing the URL or URI
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL.
     *
     * <p>A URL or URI describing the location of the sensor information data.
     *
     * @param url String containing the URL or URI
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the collection mode.
     *
     * <p>A string that describes the collection mode of the sensor. Likely to be dropped in future
     * releases once each modality has a standard way to refer to a database of data products.
     *
     * @return the collection mode
     */
    public String getCollectionMode() {
        return collectionMode;
    }

    /**
     * Set the collection mode.
     *
     * <p>A string that describes the collection mode of the sensor. Likely to be dropped in future
     * releases once each modality has a standard way to refer to a database of data products.
     *
     * @param collectionMode the collection mode
     */
    public void setCollectionMode(String collectionMode) {
        this.collectionMode = collectionMode;
    }

    /**
     * Get the comment.
     *
     * <p>A comment about the sensor.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment.
     *
     * <p>A comment about the sensor.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
