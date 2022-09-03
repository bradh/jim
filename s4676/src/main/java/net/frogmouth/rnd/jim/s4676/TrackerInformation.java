package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.common.IDData;
import net.frogmouth.rnd.jim.s4676.enumeration.TrackerType;

/**
 * Tracker Information.
 *
 * <p>The TrackerInformation class contains high-level information specific to a tracker used to
 * form detections into tracks. If a system has multiple trackers that are used to generate tracks,
 * each tracker's information must be recorded as a separate instance of this class.
 *
 * <p>If the data producer is using the STANDALONE compliance profile, the object must contain at
 * least TrackerInformation object, unless that tracks are ground truth tracks (in which case it’s
 * likely no tracker was used). If the data producer is using the DATASTREAM compliance profile, the
 * complete set of all NITSRoot objects in the data stream must include at least one
 * TrackerInformation object, but each Tracker only has to be specified in one object in that
 * stream.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "trackerID",
    "name",
    "description",
    "version",
    "supplementaryData"
})
public class TrackerInformation {

    @JacksonXmlProperty(isAttribute = true)
    private TrackerType type;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String uid;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    Long lid;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IDData trackerID;

    /** The name of the sensor. */
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String name;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String description;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String version;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "supplementaryData")
    private List<SupplementaryData> supplementaryData;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a name and version.
     */
    private TrackerInformation() {}

    /**
     * Constructor.
     *
     * <p>There are three mandatory elements to the Tracker Information - the tracker type, a name,
     * and the tracker version.
     *
     * <p>The tracker type is the type of tracker (such as AUTOMATIC_TRACKER).
     *
     * <p>The name is a common name for the tracker.
     *
     * <p>The version is the version number or string of the tracker algorithm.
     *
     * @param type the tracker type
     * @param name the name
     * @param version the version
     */
    public TrackerInformation(TrackerType type, String name, String version) {
        this.type = type;
        this.name = name;
        this.version = version;
    }

    /**
     * Tracker type.
     *
     * <p>The type of tracker (such as AUTOMATIC_TRACKER).
     *
     * @return the tracker type as an enumerated value
     */
    public TrackerType getType() {
        return type;
    }

    /**
     * Set the tracker type.
     *
     * <p>The type of tracker (such as AUTOMATIC_TRACKER).
     *
     * @param type the tracker type as an enumerated value
     */
    public void setType(TrackerType type) {
        this.type = type;
    }

    /**
     * Tracker Unique Identifier.
     *
     * <p>A UUID associated with a particular block of tracker information.
     *
     * @return the unique identifier for this tracker information.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the Tracker Unique Identifier.
     *
     * <p>A UUID associated with a particular block of tracker information.
     *
     * @param uid the unique identifier for this tracker information.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Version Local Identifier.
     *
     * <p>A local ID associated with a particular block of tracker information.
     *
     * @return the local identifier for this tracker information.
     */
    public Long getLid() {
        return lid;
    }

    /**
     * Set the Version Local Identifier.
     *
     * <p>A local ID associated with a particular block of tracker information.
     *
     * @param lid the local identifier for this tracker information.
     */
    public void setLid(Long lid) {
        this.lid = lid;
    }

    /**
     * Get the tracker ID.
     *
     * <p>Provides a unique station identification number/designator of a STANAG 4676-capable
     * system.
     *
     * @return the tracker ID
     */
    public IDData getTrackerID() {
        return trackerID;
    }

    /**
     * Set the tracker ID.
     *
     * <p>Provides a unique station identification number/designator of a STANAG 4676-capable
     * system.
     *
     * @param trackerID the tracker ID
     */
    public void setTrackerID(IDData trackerID) {
        this.trackerID = trackerID;
    }

    /**
     * Get the tracker name.
     *
     * <p>The name of the tracker.
     *
     * @return the name of the tracker
     */
    public String getName() {
        return name;
    }

    /**
     * Get the tracker description.
     *
     * <p>A string for describing the tracker in greater detail.
     *
     * @return the tracker description as a text String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the tracker description.
     *
     * <p>A string for describing the tracker in greater detail.
     *
     * @param description the tracker description as a text String.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the tracker version.
     *
     * <p>The version number or string of the tracker algorithm. Useful record in case the tracker
     * algorithm gets updated, or a systematic error is discovered.
     *
     * @return the tracker version as a String.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set the tracker version.
     *
     * <p>The version number or string of the tracker algorithm. Useful record in case the tracker
     * algorithm gets updated, or a systematic error is discovered.
     *
     * @param version the tracker version as a String.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Add supplementary data.
     *
     * @param data the supplementary data to add
     */
    public void addSupplementaryData(SupplementaryData data) {
        if (this.supplementaryData == null) {
            this.supplementaryData = new ArrayList<>();
        }
        this.supplementaryData.add(data);
    }

    /**
     * Supplementary Data.
     *
     * <p>The opportunity to record supplementary data that is utilized by the tracking algorithm
     * (such as DEMs or road networks).
     *
     * @return list of supplementary data entries
     */
    @JsonIgnore
    public List<SupplementaryData> getSupplementaryData() {
        return this.supplementaryData;
    }
}
