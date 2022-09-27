package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.message.TrackSource;
import net.frogmouth.rnd.jim.s4676.message.tracksegment.TrackSegment;

/**
 * Track data information.
 *
 * <p>The TrackData class contains information specific to a particular track. Multiple instances of
 * the TrackData class can be used to describe the track as a whole and can be segmented into
 * multiple TrackMessages or even multiple NITSRoot root objects, as long as those TrackData objects
 * are tied together using the same UID and or LID.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "trackSource", "segment", "object"})
public class TrackData extends IdentifiedElement {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private TrackSource trackSource;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "segment")
    private List<TrackSegment> segments;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "object")
    private List<TrackedObject> objects;

    /**
     * Constructor.
     *
     * <p>No part of the track data is mandatory, however that may not be a very useful TrackData
     * instance.
     */
    public TrackData() {}

    /**
     * Track source.
     *
     * <p>Information about the sources of data (sensors, trackers, collections and products)
     * pertinent to this track as a whole. This information can be overridden for individual track
     * segments by including source information directly within those segments.
     *
     * @return the track source
     */
    public TrackSource getTrackSource() {
        return trackSource;
    }

    /**
     * Set the track source.
     *
     * <p>Information about the sources of data (sensors, trackers, collections and products)
     * pertinent to this track as a whole. This information can be overridden for individual track
     * segments by including source information directly within those segments.
     *
     * @param trackSource the track source
     */
    public void setTrackSource(TrackSource trackSource) {
        this.trackSource = trackSource;
    }

    /**
     * Track segments.
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
     * Add a track segment.
     *
     * <p>Each track segment consists of zero or more track points that are adjacent in time. Note
     * that it is not necessary for a track to consist of more than one track segment.
     *
     * @param segment the track segment to add
     */
    public void addSegment(TrackSegment segment) {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        this.segments.add(segment);
    }

    /**
     * Tracked objects.
     *
     * <p>Time-invariant information about an object whose movement is described by this instance of
     * TrackData, such as the type of object (e.g., an Automobile or an Open-bed truck), its colour,
     * and its identity ("FRIEND", "HOSTILE"). If multiple objects are specified, the data consumer
     * shall interpret the track data as applying to the set of multiple objects as a group.
     *
     * @return the tracked objects
     */
    public List<TrackedObject> getObjects() {
        return objects;
    }

    /**
     * Add a tracked object.
     *
     * <p>Time-invariant information about an object whose movement is described by this instance of
     * TrackData, such as the type of object (e.g., an Automobile or an Open-bed truck), its colour,
     * and its identity ("FRIEND", "HOSTILE"). If multiple objects are specified, the data consumer
     * shall interpret the track data as applying to the set of multiple objects as a group.
     *
     * @param object the object to add
     */
    public void addObject(TrackedObject object) {
        if (this.objects == null) {
            this.objects = new ArrayList<>();
        }
        this.objects.add(object);
    }
}
