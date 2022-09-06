package net.frogmouth.rnd.jim.s4676.message.tracklinkage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;

/**
 * Track Linkage.
 *
 * <p>The TrackLinkage class describes a relationship between two or more tracks (referenced via
 * their UIDs/LIDs). Possible relationships include split, merge, and stitch.
 *
 * <p>This class can also be used to invalidate previously-reported track relationships (for
 * example, if the tracker decides – based on some new information – that a previously- reported
 * stitch linkage between tracks 1 and 2 cannot be correct, because the cars are different colors).
 * To do so, the data producer must report a TrackLinkage with the same UUID as the now-invalid
 * TrackLinkage, along with an appropriate new confidence value (for example, a confidence value of
 * 0, and a confidence validity of FALSE). There is no need to repeat the LIDs or UUIDs of the
 * tracks involved in the previously-reported TrackLinkage., This feature can only be used if the
 * data producer utilizes LIDs or UUIDs in the TrackLinkage class.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "confidence",
    "preUID",
    "preLID",
    "postUID",
    "postLID"
})
public class TrackLinkage extends IdentifiedElement {

    @JacksonXmlProperty(isAttribute = true)
    private ITrackLinkageType type;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "relTime")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    long relTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    Confidence confidence;

    // TODO: "preUID",

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "preLID")
    private List<Long> preLIDs;

    // TODO: "postUID",

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "postLID")
    private List<Long> postLIDs;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a track linkage type.
     */
    private TrackLinkage() {}

    /**
     * Constructor.
     *
     * <p>The Track Linkage requires a mandatory track linkage type.
     *
     * @param trackLinkageType the track linkage type
     */
    public TrackLinkage(ITrackLinkageType trackLinkageType) {
        this.type = trackLinkageType;
    }

    /**
     * Type of linkage.
     *
     * <p>The type of the relationship being documented.
     *
     * @return the linkage type
     */
    public ITrackLinkageType getType() {
        return type;
    }

    /**
     * Set the type of linkage.
     *
     * <p>The type of the relationship being documented.
     *
     * @param type the linkage type
     */
    public void setType(ITrackLinkageType type) {
        this.type = type;
    }

    /**
     * Relative time.
     *
     * <p>The time when the relationship started. For example, the time when the split or merge
     * first occurred.
     *
     * <p>The absolute time is easily recoverable by the consumer, who must multiply this value by
     * TrackMessage.relTimeIncrements and add TrackMessage.baseTime.
     *
     * @return relative time.
     */
    public long getRelTime() {
        return relTime;
    }

    /**
     * Set relative time.
     *
     * <p>The time when the relationship started. For example, the time when the split or merge
     * first occurred.
     *
     * <p>The absolute time is easily recoverable by the consumer, who must multiply this value by
     * TrackMessage.relTimeIncrements and add TrackMessage.baseTime.
     *
     * @param relTime relative time.
     */
    public void setRelTime(long relTime) {
        this.relTime = relTime;
    }

    /**
     * Confidence.
     *
     * <p>The producer’s estimate of the confidence in the fact of this linkage. The intended use
     * case for this information is for when the producer is generating data products in a stream,
     * and decides that a previously- reported track relationship is no longer valid. In this case,
     * the producer would report that the trackLinkage. UUID now has a validity of FALSE. When
     * declaring a relationship invalid, only the UID/LID and confidence attributes need to be
     * reported.
     *
     * @return confidence in relationship
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set confidence.
     *
     * <p>The producer’s estimate of the confidence in the fact of this linkage. The intended use
     * case for this information is for when the producer is generating data products in a stream,
     * and decides that a previously- reported track relationship is no longer valid. In this case,
     * the producer would report that the trackLinkage. UUID now has a validity of FALSE. When
     * declaring a relationship invalid, only the UID/LID and confidence attributes need to be
     * reported.
     *
     * @param confidence confidence in relationship
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Add local identifier for input track.
     *
     * <p>Track local ID that exists prior to the relationship. The exact number of track UUIDs or
     * localIDs that must be reported depends upon the type of track linkage:
     *
     * <ul>
     *   <li>SPLIT: [1]
     *   <li>MERGE: [2..*]
     *   <li>STITCH: [1]
     * </ul>
     *
     * @param lid the local identifier for the input track to add
     */
    public void addPreLinkageLocalId(long lid) {
        if (this.preLIDs == null) {
            this.preLIDs = new ArrayList<>();
        }
        this.preLIDs.add(lid);
    }

    /**
     * Local identifiers for input tracks.
     *
     * <p>Track local IDs that exist prior to the relationship. The exact number of track UUIDs or
     * localIDs that must be reported depends upon the type of track linkage:
     *
     * <ul>
     *   <li>SPLIT: [1]
     *   <li>MERGE: [2..*]
     *   <li>STITCH: [1]
     * </ul>
     *
     * @return the local identifiers
     */
    @JsonIgnore
    public List<Long> getPreLinkageLocalIds() {
        return this.preLIDs;
    }

    /**
     * Add local identifier for output track.
     *
     * <p>Track local ID that exists after the relationship. The exact number of track UUIDs or
     * localIDs that must be reported depends upon the type of track linkage:
     *
     * <ul>
     *   <li>SPLIT: [2..*]
     *   <li>MERGE: [1]
     *   <li>STITCH: [1]
     * </ul>
     *
     * @param lid the local identifier for the output track to add
     */
    public void addPostLinkageLocalId(long lid) {
        if (this.postLIDs == null) {
            this.postLIDs = new ArrayList<>();
        }
        this.postLIDs.add(lid);
    }

    /**
     * Local identifiers for output track(s).
     *
     * <p>Track local IDs that exist after the relationship. The exact number of track UUIDs or
     * localIDs that must be reported depends upon the type of track linkage:
     *
     * <ul>
     *   <li>SPLIT: [2..*]
     *   <li>MERGE: [1]
     *   <li>STITCH: [1]
     * </ul>
     *
     * @return the local identifiers
     */
    @JsonIgnore
    public List<Long> getPostLinkageLocalIds() {
        return this.postLIDs;
    }
}
