package net.frogmouth.rnd.jim.s4676.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Track Source.
 *
 * <p>The TrackSource class contains references to the information describing the sensors, trackers,
 * collections and products associated with track data or used when generating, merging or fusing
 * track data. The specific track data to which these sources applies depends on the location of the
 * TrackSource object within the file; a TrackSource object directly within a TrackData object
 * applies to that track as a whole, where a TrackSource object directly within a TrackSegment
 * object applies to just that single track segment.
 *
 * <p>These references point back to SensorInformation, TrackerInformation and CollectionInformation
 * objects specified in the root NITSRoot object (for objects conforming to the STANDALONE profile)
 * or to the root NITSRoot object or the root of a previously transmitted object (for objects
 * conforming to the DATASTREAM profile). Links to ProductIdentification objects can only be
 * accomplished if data consumers compile a database of products; this specific NITSRoot
 * (STANDALONE) or a previously transmitted NITSRoot (DATASTREAM) associated with this same product
 * will not contain detailed information about these source products.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "sensorUID",
    "sensorLID",
    "trackerUID",
    "trackerLID",
    "collectionUID",
    "collectionLID",
    "productUID",
    "productLID"
})
public class TrackSource {

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "sensorUID")
    private List<UniqueID> sensorUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "sensorLID")
    private List<Long> sensorLIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "trackerUID")
    private List<UniqueID> trackerUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "trackerLID")
    private List<Long> trackerLIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "collectionUID")
    private List<UniqueID> collectionUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "collectionLID")
    private List<Long> collectionLIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "productUID")
    private List<UniqueID> productUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "productLID")
    private List<Long> productLIDs;

    /**
     * Add sensor unique identifier.
     *
     * <p>The unique ID of a sensor used to generate the detections that went into this track.
     *
     * @param uid the unique identifier to add
     */
    public void addSensorUID(UniqueID uid) {
        if (this.sensorUIDs == null) {
            this.sensorUIDs = new ArrayList<>();
        }
        this.sensorUIDs.add(uid);
    }

    /**
     * Sensor unique identifiers.
     *
     * <p>The unique ID(s) of the sensor(s) used to generate the detections that went into this
     * track.
     *
     * @return list of unique identifiers
     */
    @JsonIgnore
    public List<UniqueID> getSensorUIDs() {
        return this.sensorUIDs;
    }

    /**
     * Add sensor local identifier.
     *
     * <p>The local ID of a sensor used to generate the detections that went into this track.
     *
     * @param lid the local identifier to add
     */
    public void addSensorLID(long lid) {
        if (this.sensorLIDs == null) {
            this.sensorLIDs = new ArrayList<>();
        }
        this.sensorLIDs.add(lid);
    }

    /**
     * Sensor local identifiers.
     *
     * <p>The local ID(s) of the sensor(s) used to generate the detections that went into this
     * track.
     *
     * @return list of local identifiers
     */
    @JsonIgnore
    public List<Long> getSensorLIDs() {
        return this.sensorLIDs;
    }

    /**
     * Add tracker unique identifier.
     *
     * <p>The unique ID of a tracker used to generate the detections that went into this track.
     *
     * @param uid the unique identifier to add
     */
    public void addTrackerUID(UniqueID uid) {
        if (this.trackerUIDs == null) {
            this.trackerUIDs = new ArrayList<>();
        }
        this.trackerUIDs.add(uid);
    }

    /**
     * Tracker unique identifiers.
     *
     * <p>The unique ID(s) of the tracker(s) used to generate the detections that went into this
     * track.
     *
     * @return list of unique identifiers.
     */
    @JsonIgnore
    public List<UniqueID> getTrackerUIDs() {
        return this.trackerUIDs;
    }

    /**
     * Add tracker local identifier.
     *
     * <p>The local ID of a tracker used to generate the detections that went into this track.
     *
     * @param lid the local identifier to add
     */
    public void addTrackerLID(long lid) {
        if (this.trackerLIDs == null) {
            this.trackerLIDs = new ArrayList<>();
        }
        this.trackerLIDs.add(lid);
    }

    /**
     * Tracker local identifiers.
     *
     * <p>The local ID(s) of the tracker(s) used to generate the detections that went into this
     * track.
     *
     * @return list of local identifiers.
     */
    @JsonIgnore
    public List<Long> getTrackerLIDs() {
        return this.trackerLIDs;
    }

    /**
     * Add collection unique identifier.
     *
     * <p>The unique ID of a collection used to generate the detections that went into this track.
     *
     * @param uid the unique identifier to add
     */
    public void addCollectionUID(UniqueID uid) {
        if (this.collectionUIDs == null) {
            this.collectionUIDs = new ArrayList<>();
        }
        this.collectionUIDs.add(uid);
    }

    /**
     * Collection unique identifiers.
     *
     * <p>The unique ID(s) of the collections(s) used to generate the detections that went into this
     * track.
     *
     * @return list of unique identifiers.
     */
    @JsonIgnore
    public List<UniqueID> getCollectionUIDs() {
        return this.collectionUIDs;
    }

    /**
     * Add collection local identifier.
     *
     * <p>The local ID of a collection used to generate the detections that went into this track.
     *
     * @param lid the local identifier to add
     */
    public void addCollectionLID(long lid) {
        if (this.collectionLIDs == null) {
            this.collectionLIDs = new ArrayList<>();
        }
        this.collectionLIDs.add(lid);
    }

    /**
     * Collection local identifiers.
     *
     * <p>The local ID(s) of the collections(s) used to generate the detections that went into this
     * track.
     *
     * @return list of local identifiers.
     */
    @JsonIgnore
    public List<Long> getCollectionLIDs() {
        return this.collectionLIDs;
    }

    /**
     * Add product unique identifier.
     *
     * <p>The unique ID of a product used to generate the detections that went into this track. Note
     * that NITSRoot does not include the capability to obtain information about products other than
     * the specific data product corresponding to that NITSRoot instance. If there are multiple
     * product sources (e.g., this NITSRoot was created by merging data from other specifically
     * identified data products), then the link between the productUID value and the product
     * information must be made with data external to this NITSRoot.
     *
     * @param uid the unique identifier to add
     */
    public void addProductLID(UniqueID uid) {
        if (this.productUIDs == null) {
            this.productUIDs = new ArrayList<>();
        }
        this.productUIDs.add(uid);
    }

    /**
     * Product unique identifiers.
     *
     * <p>The unique ID(s) of the product(s) containing the detections and track points that went
     * into the generation of the applicable track data. Note that NITSRoot does not include the
     * capability to obtain information about products other than the specific data product
     * corresponding to that NITSRoot instance. If there are multiple product sources (e.g., this
     * NITSRoot was created by merging data from other specifically identified data products), then
     * the link between the productUID value and the product information must be made with data
     * external to this NITSRoot.
     *
     * @return list of unique identifiers.
     */
    @JsonIgnore
    public List<UniqueID> getProductUIDs() {
        return this.productUIDs;
    }

    /**
     * Add product local identifier.
     *
     * <p>The local ID of a product used to generate the detections that went into this track. Note
     * that NITSRoot does not include the capability to obtain information about products other than
     * the specific data product corresponding to that NITSRoot instance. If there are multiple
     * product sources (e.g., this NITSRoot was created by merging data from other specifically
     * identified data products), then the link between the productLID value and the product
     * information must be made with data external to this NITSRoot.
     *
     * @param lid the local identifier to add
     */
    public void addProductLID(long lid) {
        if (this.productLIDs == null) {
            this.productLIDs = new ArrayList<>();
        }
        this.productLIDs.add(lid);
    }

    /**
     * Product local identifiers.
     *
     * <p>The local ID(s) of the product(s) containing the detections and track points that went
     * into the generation of the applicable track data. Note that NITSRoot does not include the
     * capability to obtain information about products other than the specific data product
     * corresponding to that NITSRoot instance. If there are multiple product sources (e.g., this
     * NITSRoot was created by merging data from other specifically identified data products), then
     * the link between the productLID value and the product information must be made with data
     * external to this NITSRoot.
     *
     * @return list of local identifiers.
     */
    @JsonIgnore
    public List<Long> getProductLIDs() {
        return this.productLIDs;
    }
}
