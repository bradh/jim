package net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Dynamic Source Information.
 *
 * <p>The DynamicSourceInformation class contains information describing a single piece of source
 * data. For example, for a motion imagery input, one DynamicSourceInformation object might describe
 * a single frame of source imagery.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "sensorUID",
    "sensorLID",
    "sensorLocation",
    "groupID",
    "numDetections",
    "numReportedDetections",
    "dynCFT",
    "sourceMI",
    "sourceRadar",
    "sourceESM"
})
public class DynamicSourceInformation extends IdentifiedElement {
    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "relTime")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long relativeTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private UniqueID sensorUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long sensorLID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private PositionPoints sensorLocation;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String groupID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Integer numDetections;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Integer numReportedDetections;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynCFT")
    private List<DynamicCFT> dynCFTs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private MotionImageryInformation sourceMI;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private RadarInformation sourceRadar;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ESMInformation sourceESM;

    /**
     * Constructor.
     *
     * <p>No part of the dynamic source information is required, however that would not be a very
     * useful element.
     */
    public DynamicSourceInformation() {}

    /**
     * Relative time.
     *
     * <p>The number of time increments since the baseTime in the TrackMessage. If relTime is not
     * defined, it is assumed to be zero (i.e., this block of DynamicSourceInformation occurred at
     * the same time as the baseTime).
     *
     * @return relative time
     */
    public long getRelativeTime() {
        return relativeTime;
    }

    /**
     * Set the relative time.
     *
     * <p>The number of time increments since the baseTime in the TrackMessage. If relTime is not
     * defined, it is assumed to be zero (i.e., this block of DynamicSourceInformation occurred at
     * the same time as the baseTime).
     *
     * @param relativeTime relative time.
     */
    public void setRelativeTime(long relativeTime) {
        this.relativeTime = relativeTime;
    }

    /**
     * Sensor unique identifier (UID).
     *
     * <p>UID of specific sensor which generated the block of dynamic source data of interest. For
     * this purpose, may designate a UID OR an LID for the sensor, but not both.
     *
     * @return the unique ID, or null if not set
     */
    public UniqueID getSensorUID() {
        return sensorUID;
    }

    /**
     * Set the sensor unique identifier (UID).
     *
     * <p>UID of specific sensor which generated the block of dynamic source data of interest. For
     * this purpose, may designate a UID OR an LID for the sensor, but not both.
     *
     * @param sensorUID the unique ID
     */
    public void setSensorUID(UniqueID sensorUID) {
        this.sensorUID = sensorUID;
    }

    /**
     * Sensor local identifier (LID).
     *
     * <p>LID of specific sensor which generated the block of dynamic source data of interest. For
     * this purpose, may designate a UID OR an LID for the sensor, but not both.
     *
     * @return the local identifier, or null if not set
     */
    public Long getSensorLID() {
        return sensorLID;
    }

    /**
     * Set the sensor local identifier (LID).
     *
     * <p>LID of specific sensor which generated the block of dynamic source data of interest. For
     * this purpose, may designate a UID OR an LID for the sensor, but not both.
     *
     * @param sensorLID the local identifier
     */
    public void setSensorLID(Long sensorLID) {
        this.sensorLID = sensorLID;
    }

    /**
     * Sensor location.
     *
     * <p>The position of the sensor that acquired this set of data, at a particular point in time.
     * The PositionPoints.points array should contain a single coordinate (either 2 or 3 numbers,
     * depending on the coordinate system).
     *
     * @return sensor location, or null if not set
     */
    public PositionPoints getSensorLocation() {
        return sensorLocation;
    }

    /**
     * Set the sensor location.
     *
     * <p>The position of the sensor that acquired this set of data, at a particular point in time.
     * The PositionPoints.points array should contain a single coordinate (either 2 or 3 numbers,
     * depending on the coordinate system).
     *
     * @param sensorLocation sensor location
     */
    public void setSensorLocation(PositionPoints sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    /**
     * Group ID.
     *
     * <p>A program-defined ID assigned to a group of source data blocks from which this STANAG 4676
     * object or the sequence of STANAG 4676 objects was generated.
     *
     * @return the group identifier, or null if not set
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * Set the group ID.
     *
     * <p>A program-defined ID assigned to a group of source data blocks from which this STANAG 4676
     * object or the sequence of STANAG 4676 objects was generated.
     *
     * @param groupID the group identifier
     */
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    /**
     * Number of detections.
     *
     * <p>The total number of detections in the sensor or system field of view, at this instance in
     * time.
     *
     * @return the number of detections in the field of view, or null if not set.
     */
    public Integer getNumDetections() {
        return numDetections;
    }

    /**
     * Set the number of detections.
     *
     * <p>The total number of detections in the sensor or system field of view, at this instance in
     * time.
     *
     * @param numDetections the number of detections in the field of view.
     */
    public void setNumDetections(Integer numDetections) {
        this.numDetections = numDetections;
    }

    /**
     * Number of reported detections.
     *
     * <p>The total number of reported detections in the sensor or system field of view, at this
     * instance in time.
     *
     * @return the number of reported detections, or null if not set.
     */
    public Integer getNumReportedDetections() {
        return numReportedDetections;
    }

    /**
     * Set the number of reported detections.
     *
     * <p>The total number of reported detections in the sensor or system field of view, at this
     * instance in time.
     *
     * @param numReportedDetections the number of reported detections
     */
    public void setNumReportedDetections(Integer numReportedDetections) {
        this.numReportedDetections = numReportedDetections;
    }

    /**
     * Dynamic coordinate frame transformations.
     *
     * <p>A coordinate frame transformation between an absolute coordinate frame and a relative
     * coordinate frame. This information is stated here so that it can be referred to by reference
     * to minimize redundancy.
     *
     * <p>This is not intended to support multiple potential dynamics, but rather multiple potential
     * transformations of the same dynamics to different resulting coordinate frames.
     *
     * @return dynamic coordinate frame transformations, or null.
     */
    public List<DynamicCFT> getDynCFTs() {
        return dynCFTs;
    }

    /**
     * Add a dynamic coordinate frame transformations.
     *
     * <p>A coordinate frame transformation between an absolute coordinate frame and a relative
     * coordinate frame. This information is stated here so that it can be referred to by reference
     * to minimize redundancy.
     *
     * <p>This is not intended to support multiple potential dynamics, but rather multiple potential
     * transformations of the same dynamics to different resulting coordinate frames.
     *
     * @param dynCFT dynamic coordinate frame transformations.
     */
    public void addDynCFTs(DynamicCFT dynCFT) {
        if (this.dynCFTs == null) {
            this.dynCFTs = new ArrayList<>();
        }
        this.dynCFTs.add(dynCFT);
    }

    /**
     * Source motion imagery.
     *
     * <p>Motion imagery information common to a single frame of data, and potentially only to that
     * frame of data.
     *
     * @return the motion imagery, or null if not set.
     */
    public MotionImageryInformation getSourceMI() {
        return sourceMI;
    }

    /**
     * Set the source motion imagery.
     *
     * <p>Motion imagery information common to a single frame of data, and potentially only to that
     * frame of data.
     *
     * @param sourceMI the motion imagery.
     */
    public void setSourceMI(MotionImageryInformation sourceMI) {
        this.sourceMI = sourceMI;
    }

    /**
     * STANAG 4607 (GMTI) radar information.
     *
     * <p>Radar information common to a single revisit/dwell of data, and potentially only to that
     * revisit/dwell of data.
     *
     * @return radar information.
     */
    public RadarInformation getSourceRadar() {
        return sourceRadar;
    }

    /**
     * Set the STANAG 4607 (GMTI) radar information.
     *
     * <p>Radar information common to a single revisit/dwell of data, and potentially only to that
     * revisit/dwell of data.
     *
     * @param sourceRadar radar information.
     */
    public void setSourceRadar(RadarInformation sourceRadar) {
        this.sourceRadar = sourceRadar;
    }

    /**
     * Source electronic support measures (ESM) information.
     *
     * @return ESM information, or null if not set.
     */
    public ESMInformation getSourceESM() {
        return sourceESM;
    }

    /**
     * Set the source electronic support measures (ESM) information.
     *
     * @param sourceESM ESM information, or null if not set.
     */
    public void setSourceESM(ESMInformation sourceESM) {
        this.sourceESM = sourceESM;
    }
}
