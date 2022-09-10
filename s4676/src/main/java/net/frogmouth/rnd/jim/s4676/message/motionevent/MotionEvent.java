package net.frogmouth.rnd.jim.s4676.message.motionevent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.common.shape.Shape;

/**
 * Motion Event.
 *
 * <p>The MotionEvent class specifies a particular manoeuvre involving one or more tracks that is of
 * interest to the producer. Since the ability to measure these events is dependent upon the data
 * producer’s capabilities, the definition of each motion event is largely left to the data producer
 * (for example, what speed constitutes a “START” or “STOP” event).
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

    // TODO: "trackUID",

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long trackLID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long startRelTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long endRelTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    // TODO: serialisation needs to specify what kind of shape
    private Shape region;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private PositionPoints tripwire;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a motion event type.
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
