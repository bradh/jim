package net.frogmouth.rnd.jim.s4676.message.trackpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.Shape;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;
import net.frogmouth.rnd.jim.s4676.message.sensormeasurement.SensorMeasurement;

/**
 * Track Point.
 *
 * <p>The TrackPoint class specifies the position and movement of the tracked object for a single
 * point in time. The values contained in the contents of this TrackPoint are valid for this and
 * only for this TrackPoint, even if those values are provided only in a subset of the TrackPoints.
 * For example, if the objects velocity is omitted from a TrackPoint, the data consumer shall not
 * infer that the object is travelling at the same speed as it was at a previous point in time.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "dynSrcUID",
    "dynSrcLID",
    "associatedDetection",
    "processType",
    "confidence",
    "comment",
    "outline",
    "outlineObscured",
    "nearestConfuser",
    "nearestConfuserConfidence",
    "dynamics",
    "evidence",
    "sm"
})
public class TrackPoint extends IdentifiedElement {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long relTime;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcUID")
    private UniqueID dynamicSourceUID;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcLID")
    private Long dynamicSourceLID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Boolean associatedDetection;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IProcessType processType;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String comment;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Shape outline;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Shape outlineObscured;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double nearestConfuser;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence nearestConfuserConfidence;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynamics")
    private List<Dynamics> dynamics;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "evidence")
    private List<Evidence> evidences;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "sm")
    private List<SensorMeasurement> sensorMeasurements;

    /**
     * Constructor.
     *
     * <p>No part of the track point is mandatory, although typically at least one {@code Dynamics}
     * element would be provided.
     */
    public TrackPoint() {}

    /**
     * Relative time.
     *
     * <p>The number of relative time increments (TrackMessage.relTimeIncrements) since the start
     * time of the track segment (TrackMessage.baseTime). This should be an integer value. This
     * value is required unless the value would be 0 (that is, the track point time is the same as
     * the baseTime in TrackMessage). The absolute time is this value (TrackPoint.relTime)
     * multiplied by TrackMessage.relTimeIncrement and added TrackMessage.baseTime.
     *
     * @return the relative time
     */
    public long getRelTime() {
        return relTime;
    }

    /**
     * Set the relative time.
     *
     * <p>The number of relative time increments (TrackMessage.relTimeIncrements) since the start
     * time of the track segment (TrackMessage.baseTime). This should be an integer value. This
     * value is required unless the value would be 0 (that is, the track point time is the same as
     * the baseTime in TrackMessage). The absolute time is this value (TrackPoint.relTime)
     * multiplied by TrackMessage.relTimeIncrement and added TrackMessage.baseTime.
     *
     * @param relTime the relative time.
     */
    public void setRelTime(long relTime) {
        this.relTime = relTime;
    }

    /**
     * Dynamic source unique identifier (UID).
     *
     * <p>An optional reference to the related block of dynamic source information.
     *
     * @return the unique identifier, or null if not set.
     */
    public UniqueID getDynamicSourceUID() {
        return dynamicSourceUID;
    }

    /**
     * Set the dynamic source unique identifier (UID).
     *
     * <p>An optional reference to the related block of dynamic source information.
     *
     * @param dynamicSourceUID the unique identifier.
     */
    public void setDynamicSourceUID(UniqueID dynamicSourceUID) {
        this.dynamicSourceUID = dynamicSourceUID;
    }

    /**
     * Dynamic source local identifier (LID).
     *
     * <p>An optional reference to the related block of dynamic source information.
     *
     * @return the local identifier, or null if not set.
     */
    public Long getDynamicSourceLID() {
        return dynamicSourceLID;
    }

    /**
     * Set the dynamic source local identifier (LID).
     *
     * <p>An optional reference to the related block of dynamic source information.
     *
     * @param dynamicSourceLID the local identifier
     */
    public void setDynamicSourceLID(Long dynamicSourceLID) {
        this.dynamicSourceLID = dynamicSourceLID;
    }

    /**
     * Associated detection.
     *
     * <p>Boolean indication of whether a track point has an associated detection.
     *
     * <ul>
     *   <li>TRUE indicates that the track point has an associated detection
     *   <li>FALSE indicates that the track point has no associated detection
     * </ul>
     *
     * @return whether the track point has an associated detection, or null if not set.
     */
    public Boolean getAssociatedDetection() {
        return associatedDetection;
    }

    /**
     * Set associated detection.
     *
     * <p>Boolean indication of whether a track point has an associated detection.
     *
     * <ul>
     *   <li>TRUE indicates that the track point has an associated detection
     *   <li>FALSE indicates that the track point has no associated detection
     * </ul>
     *
     * @param associatedDetection whether the track point has an associated detection.
     */
    public void setAssociatedDetection(Boolean associatedDetection) {
        this.associatedDetection = associatedDetection;
    }

    /**
     * Process type.
     *
     * <p>Indicator whether a track point was generated by or modified by a human or an algorithm.
     *
     * <p>Unless extended, this will be one of the enumeration values from {@link ProcessType}.
     *
     * @return the process type, or null if not set.
     */
    public IProcessType getProcessType() {
        return processType;
    }

    /**
     * Set the process type.
     *
     * <p>Indicator whether a track point was generated by or modified by a human or an algorithm.
     *
     * <p>Unless extended, this will be one of the enumeration values from {@link ProcessType}.
     *
     * @param processType the process type.
     */
    public void setProcessType(IProcessType processType) {
        this.processType = processType;
    }

    /**
     * Confidence.
     *
     * <p>The producer’s confidence that this track point belongs to the track segment.
     *
     * @return the confidence, or null if not set.
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Set the confidence.
     *
     * <p>The producer’s confidence that this track point belongs to the track segment.
     *
     * @param confidence the confidence
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Comment.
     *
     * <p>A comment about the track point.
     *
     * @return the comment as a String, or null if not set.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment.
     *
     * <p>A comment about the track point.
     *
     * @param comment the comment as a String.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Tracked object outline.
     *
     * <p>The producer’s estimate of the outline of the tracked object at this point in time. If the
     * object that is being tracked cannot be identified as a resolvable area, then this field
     * should be omitted from the report.
     *
     * <p>For ground truth, this should represent the true outlined area/volume of the tracked
     * object.
     *
     * @return the outline shape, typically a Polygon, or null if not set.
     */
    public Shape getOutline() {
        return outline;
    }

    /**
     * Set the tracked object outline.
     *
     * <p>The producer’s estimate of the outline of the tracked object at this point in time. If the
     * object that is being tracked cannot be identified as a resolvable area, then this field
     * should be omitted from the report.
     *
     * <p>For ground truth, this should represent the true outlined area/volume of the tracked
     * object.
     *
     * @param outline the outline shape, typically a Polygon.
     */
    public void setOutline(Shape outline) {
        this.outline = outline;
    }

    /**
     * Obscured part of tracked object outline.
     *
     * <p>The producer’s estimate of the outline of the part of the tracked object that is obscured
     * at this point in time. This outline should be a portion of the outline reported in {@code
     * outline}, and therefore should not be reported unless {@code outline} is also reported.
     *
     * @return the obscured part of the outline
     */
    public Shape getOutlineObscured() {
        return outlineObscured;
    }

    /**
     * Set the obscured part of tracked object outline.
     *
     * <p>The producer’s estimate of the outline of the part of the tracked object that is obscured
     * at this point in time. This outline should be a portion of the outline reported in {@code
     * outline}, and therefore should not be reported unless {@code outline} is also reported.
     *
     * @param outlineObscured the obscured part of the outline
     */
    public void setOutlineObscured(Shape outlineObscured) {
        this.outlineObscured = outlineObscured;
    }

    /**
     * Nearest confuser distance.
     *
     * <p>The smallest edge-to-edge distance between confusers, in units of metres. A “confuser”
     * must be defined by the data producer, but in general is a similarly-shaped object with
     * similar dynamics.
     *
     * <p>For example, two cars that are travelling at high speeds in opposite directions are
     * unlikely to be confused with one another. Similarly, a semi- tractor trailer is unlikely to
     * be confused with a car, even if both vehicles are moving at the same speed.
     *
     * @return the distance in metres, or null if not set.
     */
    public Double getNearestConfuser() {
        return nearestConfuser;
    }

    /**
     * Set the nearest confuser distance.
     *
     * <p>The smallest edge-to-edge distance between confusers, in units of metres. A “confuser”
     * must be defined by the data producer, but in general is a similarly-shaped object with
     * similar dynamics.
     *
     * <p>For example, two cars that are travelling at high speeds in opposite directions are
     * unlikely to be confused with one another. Similarly, a semi- tractor trailer is unlikely to
     * be confused with a car, even if both vehicles are moving at the same speed.
     *
     * @param nearestConfuser the distance in metres.
     */
    public void setNearestConfuser(Double nearestConfuser) {
        this.nearestConfuser = nearestConfuser;
    }

    /**
     * Nearest confuser distance confidence.
     *
     * <p>The producer’s confidence in the reported distance to the nearest confuser.
     *
     * @return confidence, or null if not set.
     */
    public Confidence getNearestConfuserConfidence() {
        return nearestConfuserConfidence;
    }

    /**
     * Set the nearest confuser distance confidence.
     *
     * <p>The producer’s confidence in the reported distance to the nearest confuser.
     *
     * @param nearestConfuserConfidence confidence.
     */
    public void setNearestConfuserConfidence(Confidence nearestConfuserConfidence) {
        this.nearestConfuserConfidence = nearestConfuserConfidence;
    }

    /**
     * Dynamics of the tracked object.
     *
     * <p>Position, velocity, acceleration, and covariance matrix data, as estimated by the data
     * producer.
     *
     * <p>This is a list to support providing equivalent information in multiple coordinate
     * reference systems. It does not provide for alternate estimates (e.g. supporting different
     * hypotheses).
     *
     * @return the dynamics of the object, or null
     */
    public List<Dynamics> getDynamics() {
        return dynamics;
    }

    /**
     * Add dynamics of the tracked object.
     *
     * <p>Position, velocity, acceleration, and covariance matrix data, as estimated by the data
     * producer.
     *
     * <p>This supports providing equivalent information in multiple coordinate reference systems.
     * It does not provide for alternate estimates (e.g. supporting different hypotheses).
     *
     * @param dyn the dynamics of the object.
     */
    public void addDynamics(Dynamics dyn) {
        if (this.dynamics == null) {
            this.dynamics = new ArrayList<>();
        }
        this.dynamics.add(dyn);
    }

    /**
     * Evidence.
     *
     * <p>The sensed information that provides the evidence for the conclusion that the tracked
     * object is at the specified location at the specified time. Multiple pieces of evidence can be
     * included for a single track point; for example, a vehicle moving through a desert, as well as
     * the plume of dust emanating from behind that vehicle.
     *
     * @return the list of evidence, or null
     */
    public List<Evidence> getEvidences() {
        return evidences;
    }

    /**
     * Add an evidence entry to the track point.
     *
     * <p>The sensed information that provides the evidence for the conclusion that the tracked
     * object is at the specified location at the specified time. Multiple pieces of evidence can be
     * included for a single track point; for example, a vehicle moving through a desert, as well as
     * the plume of dust emanating from behind that vehicle.
     *
     * @param evidence the evidence to add
     */
    public void addEvidence(Evidence evidence) {
        if (this.evidences == null) {
            this.evidences = new ArrayList<>();
        }
        this.evidences.add(evidence);
    }

    /**
     * Sensor measurements.
     *
     * <p>Provides one or more quantities associated with a detection.
     *
     * @return sensor measurements, or null.
     */
    public List<SensorMeasurement> getSensorMeasurements() {
        return sensorMeasurements;
    }

    /**
     * Add a sensor measurement.
     *
     * <p>Provides one or more quantities associated with a detection.
     *
     * @param sensorMeasurement the sensor measurement to add.
     */
    public void addSensorMeasurements(SensorMeasurement sensorMeasurement) {
        if (this.sensorMeasurements == null) {
            this.sensorMeasurements = new ArrayList<>();
        }
        this.sensorMeasurements.add(sensorMeasurement);
    }
}
