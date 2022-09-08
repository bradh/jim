package net.frogmouth.rnd.jim.s4676.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;

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

    // TODO: "segmentSource",
    // TODO "confidence",
    // TODO: "comment",
    // TODO: "status",
    // TODO: "initiationReason",
    // TODO: "terminationReason",

    // TODO: constructors

    // TODO: other getters and setters
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
