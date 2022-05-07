package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.time.ZonedDateTime;
import java.util.List;

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
public class Message {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ZonedDateTime baseTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private double relTimeIncrement;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "track")
    private List<TrackData> tracks;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version taking the time base and increments.
     */
    private Message() {}

    /**
     * Constructor.
     *
     * <p>The base time is an (absolute) time stamp in UTC. This should be the earliest time among
     * all the time stamps in the constituent parts of TrackMessage so that all times listed in this
     * track message can be specified as a relative number of time steps after this baseTime.
     *
     * @param baseTime the base time value
     *     <p>The relative time increment is the time, in decimal seconds, equal to 1 relative time
     *     increment. Conceptually, this is the length of a "tick" in the time scale.
     * @param relTimeIncrement the relative time increment.
     */
    public Message(ZonedDateTime baseTime, double relTimeIncrement) {
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
     * Set the track data for this message.
     *
     * <p>Data specific to a particular track (such as the track segments and points, dynamics, and
     * evidence).
     *
     * @param trackData list of tracks
     */
    public void setTracks(List<TrackData> trackData) {
        this.tracks = trackData;
    }
}
