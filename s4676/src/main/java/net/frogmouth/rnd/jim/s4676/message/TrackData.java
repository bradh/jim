package net.frogmouth.rnd.jim.s4676.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.TrackSegment;

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
public class TrackData {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String uid;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "segment")
    private List<TrackSegment> segments;

    /**
     * Universal identifier.
     *
     * <p>The UUID of the track. Each track is composed of one or more track segments, and each
     * track segment is composed of one or more track points.
     *
     * @return the universal identifier
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the universal identifier.
     *
     * <p>The UUID of the track. Each track is composed of one or more track segments, and each
     * track segment is composed of one or more track points.
     *
     * @param uid the universal identifier
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

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
}
