package net.frogmouth.rnd.jim.s4676.message.motionevent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.common.Shape;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Motion Event.
 *
 * <p>The MotionEvent class specifies a particular manoeuvre involving one or more tracks that is of
 * interest to the producer. Since the ability to measure these events is dependent upon the data
 * producer’s capabilities, the definition of each motion event is largely left to the data producer
 * (for example, what speed constitutes a “START” or “STOP” event).
 *
 * <p>Either trackUID(s) or trackLID(s) are required for the event to be meaningful.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "trackUID",
    "trackLID",
    "startRelTime",
    "endRelTime",
    "confidence",
    "region",
    "tripwire"
})
public class MotionEvent extends IdentifiedElement {

    @JacksonXmlProperty(isAttribute = true)
    private IMotionEventType type;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "trackUID")
    private List<UniqueID> trackUIDs;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "trackLID")
    private List<Long> trackLIDs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private long startRelTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long endRelTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Shape region;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private PositionPoints tripwire;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a motion event type and start
     * time.
     */
    private MotionEvent() {}

    /**
     * Constructor.
     *
     * <p>The Motion Event requires a mandatory motion event type and the start time.
     *
     * @param motionEventType the motion event type
     * @param startRelTime the start time (relative to parent base time and relative increment)
     */
    public MotionEvent(IMotionEventType motionEventType, long startRelTime) {
        this.type = motionEventType;
        this.startRelTime = startRelTime;
    }

    /**
     * Type of motion event.
     *
     * <p>The specific motion event.
     *
     * @return the type of motion event.
     */
    public IMotionEventType getType() {
        return type;
    }

    /**
     * Set the type of motion event.
     *
     * <p>The specific motion event.
     *
     * @param type the type of motion event.
     */
    public void setType(IMotionEventType type) {
        this.type = type;
    }

    /**
     * Track unique identifiers (UIDs).
     *
     * <p>The track UID(s) of the vehicles involved in the motion event.
     *
     * @return list of track identifiers
     */
    public List<UniqueID> getTrackUIDs() {
        return trackUIDs;
    }

    /**
     * Add a track unique identifier (UID).
     *
     * <p>The track UID of a vehicle involved in the motion event.
     *
     * @param uid the identifier to add
     */
    public void addTrackUID(UniqueID uid) {
        if (this.trackUIDs == null) {
            this.trackUIDs = new ArrayList<>();
        }
        this.trackUIDs.add(uid);
    }

    /**
     * Track local identifiers (LIDs).
     *
     * <p>The track LID(s) of the vehicles involved in the motion event.
     *
     * @return list of track identifiers
     */
    public List<Long> getTrackLIDs() {
        return trackLIDs;
    }

    /**
     * Add a track local identifier (LID).
     *
     * <p>The track LID of a vehicle involved in the motion event.
     *
     * @param lid the identifier to add
     */
    public void addTrackLID(Long lid) {
        if (this.trackLIDs == null) {
            this.trackLIDs = new ArrayList<>();
        }
        this.trackLIDs.add(lid);
    }

    /**
     * Start relative time.
     *
     * <p>The start time of the motion event, in relative time increments.
     *
     * @return the relative time
     */
    public long getStartRelTime() {
        return startRelTime;
    }

    /**
     * Set the start relative time.
     *
     * <p>The start time of the motion event, in relative time increments.
     *
     * @param startRelTime the relative time
     */
    public void setStartRelTime(long startRelTime) {
        this.startRelTime = startRelTime;
    }

    /**
     * End relative time.
     *
     * <p>The end time of the motion event in relative time increments Where the endRelTime is
     * unknown, it means the data producer does not know the end time OR the end time is
     * instantaneous (endRelTime = startRelTime).
     *
     * @return the end relative time, or null if not set
     */
    public Long getEndRelTime() {
        return endRelTime;
    }

    /**
     * Set the end relative time.
     *
     * <p>The end time of the motion event in relative time increments Where the endRelTime is
     * unknown, it means the data producer does not know the end time OR the end time is
     * instantaneous (endRelTime = startRelTime).
     *
     * @param endRelTime the end relative time
     */
    public void setEndRelTime(Long endRelTime) {
        this.endRelTime = endRelTime;
    }

    /**
     * Confidence.
     *
     * <p>The producer’s estimate of the confidence in the fact of this motion event. Using this
     * attribute and the uid/lid of this class allows the data producer to update
     * previously-reported track motion events.
     *
     * @return confidence estimate
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set the confidence.
     *
     * <p>The producer’s estimate of the confidence in the fact of this motion event. Using this
     * attribute and the uid/lid of this class allows the data producer to update
     * previously-reported track motion events.
     *
     * @param confidence the confidence estimate
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Region of interest (ROI).
     *
     * <p>If the motion event type involves specifying a Region-of-Interest (ROI), that ROI should
     * be detailed with this element.
     *
     * @return the region of interest
     */
    public Shape getRegion() {
        return region;
    }

    /**
     * Set the Region of interest (ROI).
     *
     * <p>If the motion event type involves specifying a Region-of-Interest (ROI), that ROI should
     * be detailed with this element.
     *
     * <p>Note that Shape is an abstract class - typically the concrete instance is of Polygon,
     * although Ellipsoid is also possible.
     *
     * @param region the region of interest
     */
    public void setRegion(Shape region) {
        this.region = region;
    }

    /**
     * Tripwire points.
     *
     * <p>If the motion event type involves specifying a tripwire, the tripwire positions should be
     * detailed with this element. Note that a tripwire can consist of multiple points on the
     * ground, and that it’s assumed that the end points in those positions do not form a closed
     * polygon. The order of the vertices indicates how the tripwire should be drawn.
     *
     * @return tripwire position points
     */
    public PositionPoints getTripwire() {
        return tripwire;
    }

    /**
     * Set tripwire points.
     *
     * <p>If the motion event type involves specifying a tripwire, the tripwire positions should be
     * detailed with this element. Note that a tripwire can consist of multiple points on the
     * ground, and that it’s assumed that the end points in those positions do not form a closed
     * polygon. The order of the vertices indicates how the tripwire should be drawn.
     *
     * @param tripwire tripwire position points
     */
    public void setTripwire(PositionPoints tripwire) {
        this.tripwire = tripwire;
    }
}
