package net.frogmouth.rnd.jim.s4676.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.message.detection.Detection;
import net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation.DynamicSourceInformation;
import net.frogmouth.rnd.jim.s4676.message.motionevent.MotionEvent;
import net.frogmouth.rnd.jim.s4676.message.processedtrack.ProcessedTrack;
import net.frogmouth.rnd.jim.s4676.message.tracklinkage.TrackLinkage;

/**
 * Track Message.
 *
 * <p>The TrackMessage contains objects specifying the actual detections, tracks, and information
 * derived from the tracks. A data provider may include any number of TrackMessage objects within a
 * single NITSRoot object. However, depending on the individual data syntax being used, the data
 * provider can be restricted both in number of messages and whether messages can be interleaved
 * with the other contents of the containing NITSRoot object.
 *
 * <p>All instances of the relTime attribute in other objects directly or indirectly contained
 * within a single TrackMessage object are recorded as a relative number of time step integers away
 * from a start time, specified through the baseTime and relTimeIncrement attributes directly
 * contained within the TrackMessage object. This model allows for the data provider to minimize the
 * data size required to transmit multiple timestamps by limiting precision to the actual available
 * precision, and by setting a base time such that each relative timestamp is a small number. The
 * absolute time (in UTC) associated with each relTime attribute is calculated as:
 * TrackMessage.baseTime + relTime*TrackMessage.relTimeIncrement.
 *
 * <p>In all cases, if a relTime attribute is defined for an object directly or indirectly contained
 * within the TrackMessage object, but that individual relTime is omitted from the data stream, then
 * the time associated with that object is equal to the baseTime specified in the TrackMessage
 * object (i.e., interpreted as if relTime = 0).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "baseTime",
    "relTimeIncrement",
    "dynSrcInfo",
    "detection",
    "track",
    "processedTrack",
    "trackLinkage",
    "motionEvent"
})
public class TrackMessage {
    @JacksonXmlProperty(isAttribute = true)
    private Integer numDetections;

    @JacksonXmlProperty(isAttribute = true)
    private Integer numTracks;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ZonedDateTime baseTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private double relTimeIncrement;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private List<DynamicSourceInformation> dynSrcInfo;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "detection")
    private List<Detection> detections;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "track")
    private List<TrackData> tracks;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "processedTrack")
    private List<ProcessedTrack> processedTracks;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "trackLinkage")
    private List<TrackLinkage> trackLinkages;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "motionEvent")
    private List<MotionEvent> motionEvents;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version taking the time base and increments.
     */
    private TrackMessage() {}

    /**
     * Constructor.
     *
     * <p>The base time is an (absolute) time stamp in UTC. This should be the earliest time among
     * all the time stamps in the constituent parts of TrackMessage so that all times listed in this
     * track message can be specified as a relative number of time steps after this baseTime.
     *
     * <p>The relative time increment is the time, in decimal seconds, equal to 1 relative time
     * increment. Conceptually, this is the length of a "tick" in the time scale.
     *
     * @param baseTime the base time value
     * @param relTimeIncrement the relative time increment.
     */
    public TrackMessage(ZonedDateTime baseTime, double relTimeIncrement) {
        this.baseTime = baseTime;
        this.relTimeIncrement = relTimeIncrement;
    }

    /**
     * Base time for this message.
     *
     * <p>An (absolute) time stamp in UTC. This should be the earliest time among all the time
     * stamps in the constituent parts of TrackMessage so that all times listed in this track
     * message can be specified as a relative number of time steps after this baseTime.
     *
     * @return the base time for the message
     */
    public ZonedDateTime getBaseTime() {
        return baseTime;
    }

    /**
     * Base time for this message.
     *
     * <p>An (absolute) time stamp in UTC. This should be the earliest time among all the time
     * stamps in the constituent parts of TrackMessage so that all times listed in this track
     * message can be specified as a relative number of time steps after this baseTime.
     *
     * @param baseTime the base time for the message.
     */
    public void setBaseTime(ZonedDateTime baseTime) {
        this.baseTime = baseTime;
    }

    /**
     * Relative time increment.
     *
     * <p>The time, in decimal seconds, equal to 1 relative time increment.
     *
     * <p>Conceptually, this is the length of a "tick" in the time scale.
     *
     * @return the relative time increment in seconds.
     */
    public double getRelTimeIncrement() {
        return relTimeIncrement;
    }

    /**
     * Set the relative time increment.
     *
     * <p>The time, in decimal seconds, equal to 1 relative time increment.
     *
     * <p>Conceptually, this is the length of a "tick" in the time scale.
     *
     * @param increment the relative time increment in seconds.
     */
    public void setRelTimeIncrement(double increment) {
        this.relTimeIncrement = increment;
    }

    /**
     * Get the dynamic source information for this message.
     *
     * <p>Information common to a single frame of data, and potentially only to that frame of data.
     *
     * @return list of dynamic source information
     */
    @JsonIgnore
    public List<DynamicSourceInformation> getDynamicSourceInformation() {
        return this.dynSrcInfo;
    }

    /**
     * Add dynamic source information for this message.
     *
     * <p>Information common to a single frame of data, and potentially only to that frame of data.
     *
     * @param dynSrcInfo dynamic source information
     */
    public void addDynamicSourceInformation(DynamicSourceInformation dynSrcInfo) {
        if (this.dynSrcInfo == null) {
            this.dynSrcInfo = new ArrayList<>();
        }
        this.dynSrcInfo.add(dynSrcInfo);
    }

    /**
     * Get the detections for this message.
     *
     * <p>A record of zero or more detections. Each detection is assigned a UID and or LID
     * internally to the detection object that can be later referred to in the Evidence class of
     * TrackPoint. In this way, a single detection can serve as evidence for multiple track points,
     * and multiple detections can serve as evidence for a single track point.
     *
     * @return list of dynamic source information
     */
    @JsonIgnore
    public List<Detection> getDetections() {
        return this.detections;
    }

    /**
     * Add detection to this message.
     *
     * <p>Each detection is assigned a UID and or LID internally to the detection object that can be
     * later referred to in the Evidence class of TrackPoint. In this way, a single detection can
     * serve as evidence for multiple track points, and multiple detections can serve as evidence
     * for a single track point.
     *
     * @param detection dynamic source information
     */
    public void addDetection(Detection detection) {
        if (this.detections == null) {
            this.detections = new ArrayList<>();
        }
        this.detections.add(detection);
    }

    /**
     * Get the track data for this message.
     *
     * <p>Data specific to a particular track (such as the track segments and points, dynamics, and
     * evidence).
     *
     * @return list of tracks
     */
    @JsonIgnore
    public List<TrackData> getTracks() {
        return tracks;
    }

    /**
     * Add track data to this message.
     *
     * <p>Data specific to a particular track (such as the track segments and points, dynamics, and
     * evidence).
     *
     * @param trackData track data
     */
    public void addTrack(TrackData trackData) {
        if (this.tracks == null) {
            this.tracks = new ArrayList<>();
        }
        this.tracks.add(trackData);
    }

    /**
     * Get the processed tracks for this message.
     *
     * <p>One or more tracks (referenced via their UIDs/LIDs) undergoing an analytical or other
     * method to create a single output track that subsumes the input tracks.
     *
     * <p>Used to reflect changes such as fused or smoothed tracks.
     *
     * @return list of processed tracks
     */
    @JsonIgnore
    public List<ProcessedTrack> getProcessedTracks() {
        return processedTracks;
    }

    /**
     * Add processed track data to this message.
     *
     * <p>One or more tracks (referenced via their UIDs/LIDs) undergoing an analytical or other
     * method to create a single output track that subsumes the input tracks.
     *
     * <p>Used to reflect changes such as fused or smoothed tracks.
     *
     * @param processedTrack processed track references
     */
    public void addProcessedTrack(ProcessedTrack processedTrack) {
        if (this.processedTracks == null) {
            this.processedTracks = new ArrayList<>();
        }
        this.processedTracks.add(processedTrack);
    }

    /**
     * Get the track linkages for this message.
     *
     * <p>Describes a link between two or more tracks (referenced via their UIDs/LIDs). Possible
     * link types include split, merge, and stitch.
     *
     * @return list of track linkages
     */
    @JsonIgnore
    public List<TrackLinkage> getTrackLinkages() {
        return this.trackLinkages;
    }

    /**
     * Add track linkage data to this message.
     *
     * <p>Describes a link between two or more tracks (referenced via their UIDs/LIDs). Possible
     * link types include split, merge, and stitch.
     *
     * @param trackLinkage track linkage
     */
    public void addTrackLinkage(TrackLinkage trackLinkage) {
        if (this.trackLinkages == null) {
            this.trackLinkages = new ArrayList<>();
        }
        this.trackLinkages.add(trackLinkage);
    }

    /**
     * Get the motion events for this message.
     *
     * <p>A particular manoeuvre involving one or more tracks that is of interest to the producer.
     *
     * @return list of motion events
     */
    @JsonIgnore
    public List<MotionEvent> getMotionEvents() {
        return this.motionEvents;
    }

    /**
     * Add a motion event to this message.
     *
     * <p>A particular manoeuvre involving one or more tracks that is of interest to the producer.
     *
     * @param motionEvent the motion event
     */
    public void addMotionEvent(MotionEvent motionEvent) {
        if (this.motionEvents == null) {
            this.motionEvents = new ArrayList<>();
        }
        this.motionEvents.add(motionEvent);
    }
}
