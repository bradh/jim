package net.frogmouth.rnd.jim.s4676.message.tracksegment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.message.trackpoint.TrackPoint;
import net.frogmouth.rnd.jim.s4676.message.tracksource.TrackSource;

/**
 * Track Segment.
 *
 * <p>The TrackSegment class encapsulates zero or more track points adjacent in time. This provides
 * a way for a data producer to later refer to a group of points in order (for example) to update
 * the confidence of or invalidate the points, without restating or referring to each individual
 * point. TrackSegment is also the class that allows the data producer to report the track status of
 * the included track points. In addition, TrackSegment allows the data producer to associate
 * different track source information with just a specific portion of the track than specified for
 * the track as a whole.
 *
 * <p>If the data producer deems it unnecessary to break a track into multiple track segments, then
 * all track points of the track can be included in a single TrackSegment object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "segmentSource",
    "confidence",
    "comment",
    "status",
    "initiationReason",
    "terminationReason",
    "tp"
})
public class TrackSegment extends IdentifiedElement {
    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "tp")
    private List<TrackPoint> trackPoints;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private TrackSource segmentSource;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String comment;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ITrackStatus status;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ITrackInitiationReason initiationReason;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ITrackTerminationReason terminationReason;

    /**
     * Constructor.
     *
     * <p>All values in the segment are optional, although that may not be a useful segment.
     */
    public TrackSegment() {}

    /**
     * Segment source.
     *
     * <p>Information about the data sources (sensors, trackers, collections and products) used to
     * generate the data within this specific track segment. If track source information was
     * provided for the track as a whole, this information overrides that information for this
     * specific track segment.
     *
     * @return segment source
     */
    public TrackSource getSegmentSource() {
        return segmentSource;
    }

    /**
     * Set the segment source.
     *
     * <p>Information about the data sources (sensors, trackers, collections and products) used to
     * generate the data within this specific track segment. If track source information was
     * provided for the track as a whole, this information overrides that information for this
     * specific track segment.
     *
     * @param segmentSource segment source
     */
    public void setSegmentSource(TrackSource segmentSource) {
        this.segmentSource = segmentSource;
    }

    /**
     * Confidence.
     *
     * <p>The estimated confidence that this track segment is part of the other reported parts of
     * the tracker. For example: a multi-hypothesis tracker generates 10 hypothesized tracks from a
     * sequence of low-SNR (signal-to-noise-ratio) motion images. The tracker isn't sure which of
     * these hypothesized track segments is part of the actual track, so it reports all of them
     * (probably with various confidence values), and retains the opportunity to refine or revise
     * the list of hypothesized track segments in the future.
     *
     * @return confidence
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set the confidence.
     *
     * <p>The estimated confidence that this track segment is part of the other reported parts of
     * the tracker. For example: a multi-hypothesis tracker generates 10 hypothesized tracks from a
     * sequence of low-SNR (signal-to-noise-ratio) motion images. The tracker isn't sure which of
     * these hypothesized track segments is part of the actual track, so it reports all of them
     * (probably with various confidence values), and retains the opportunity to refine or revise
     * the list of hypothesized track segments in the future.
     *
     * @param confidence the confidence
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Comment.
     *
     * <p>A comment about the track segment.
     *
     * @return the comment text.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment.
     *
     * <p>A comment about the track segment.
     *
     * @param comment the comment text.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Track status.
     *
     * <p>The track status of this particular track segment (such as INITIATING or TERMINATED).
     *
     * @return the track status.
     */
    public ITrackStatus getStatus() {
        return status;
    }

    /**
     * Set the track status.
     *
     * <p>The track status of this particular track segment (such as INITIATING or TERMINATED).
     *
     * @param status the track status.
     */
    public void setStatus(ITrackStatus status) {
        this.status = status;
    }

    /**
     * Track initiation reason.
     *
     * <p>The reason that the track was initiated. Only used when the status is INITIATING.
     *
     * @return the track initiation reason.
     */
    public ITrackInitiationReason getInitiationReason() {
        return initiationReason;
    }

    /**
     * Set the track initiation reason.
     *
     * <p>The reason that the track was initiated. Only used when the status is INITIATING.
     *
     * @param initiationReason the track initiation reason.
     */
    public void setInitiationReason(ITrackInitiationReason initiationReason) {
        this.initiationReason = initiationReason;
    }

    /**
     * Track termination reason.
     *
     * <p>The reason that the track was terminated. Only used when the status is TERMINATED.
     *
     * @return track termination reason.
     */
    public ITrackTerminationReason getTerminationReason() {
        return terminationReason;
    }

    /**
     * Set the track termination reason.
     *
     * <p>The reason that the track was terminated. Only used when the status is TERMINATED.
     *
     * @param terminationReason track termination reason.
     */
    public void setTerminationReason(ITrackTerminationReason terminationReason) {
        this.terminationReason = terminationReason;
    }

    /**
     * Track Points.
     *
     * <p>Each track point is a single space-time position of the tracked object.
     *
     * @return the list of track points.
     */
    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    /**
     * Set the Track Points.
     *
     * <p>Each track point is a single space-time position of the tracked object.
     *
     * @param trackPoints the list of track points.
     */
    public void setTrackPoints(List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
