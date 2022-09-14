package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.message.tracksegment.TrackSegment;
import net.frogmouth.rnd.jim.s4676.message.tracksource.TrackSource;

/**
 * Track Data.
 *
 * <p>The TrackData class contains information specific to a particular track. Multiple instances of
 * the TrackData class can be used to describe the track as a whole and can be segmented into
 * multiple TrackMessages or even multiple NITSRoot root objects, as long as those TrackData objects
 * are tied together using the same UID and or LID.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "trackSource", "segment", "object"})
public class TrackData extends IdentifiedElement {

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "segment")
    private List<TrackSegment> segments;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private TrackSource trackSource;

    // TODO: constructors
    // TODO: private TrackedObject object

    /**
     * Track Segments.
     *
     * <p>Each track segment consists of zero or more track points that are adjacent in time. Note
     * that it is not necessary for a track to consist of more than one track segment.
     *
     * @return the list of track segments
     */
    public List<TrackSegment> getSegments() {
        return segments;
    }

    // TODO: convert this to be an adder
    /**
     * Set the Track Segments.
     *
     * <p>Each track segment consists of zero or more track points that are adjacent in time. Note
     * that it is not necessary for a track to consist of more than one track segment.
     *
     * @param segments the list of track segments
     */
    public void setSegments(List<TrackSegment> segments) {
        this.segments = segments;
    }

    // TODO: missing getters and setters
}
