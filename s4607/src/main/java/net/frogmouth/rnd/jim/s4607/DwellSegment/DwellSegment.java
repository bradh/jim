package net.frogmouth.rnd.jim.s4607.DwellSegment;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

/**
 * Dwell Segment.
 *
 * <p>A Dwell Segment is a report on a grouping of zero or more target reports for which the sensor
 * provides a single time, sensor position, reference position on the ground with simple estimates
 * for the observed area at the reported time, and other pertinent data. A Dwell Segment may be
 * associated with a radar dwell but need not be. The Dwell Segment presents data pertinent to MTI
 * targets. Dwell Segments shall be sent for each logical grouping of target reports. A Dwell
 * Segment is transmitted even if no targets are observed.
 */
public class DwellSegment extends Segment {

    private Integer revisitIndex;
    private Integer dwellIndex;
    private Boolean lastDwellOfRevisit;
    private Integer targetReportCount;
    private Long dwellTime;
    private double sensorLatitude;
    private double sensorLongitude;
    private int sensorAltitude;
    private Double scaleFactorLatScale;
    private Double scaleFactorLonScale;
    private Integer sensorPositionUncertaintyAlongTrack;
    private Integer sensorPositionUncertaintyCrossTrack;
    private Integer sensorPositionUncertaintyAltitude;
    private Double sensorTrack;
    private Integer sensorSpeed;
    private Integer sensorVerticalVelocity;
    private Integer sensorTrackUncertainty;
    private Integer sensorSpeedUncertainty;
    private Integer sensorVerticalVelocityUncertainty;
    private Double platformOrientationHeading;
    private Double platformOrientationPitch;
    private Double platformOrientationRoll;
    private double dwellCentreLatitude;
    private double dwellCentreLongitude;
    private double dwellAreaRangeHalfExtent;
    private double dwellAreaDwellAngleHalfExtent;
    private Double sensorOrientationHeading;
    private Double sensorOrientationPitch;
    private Double sensorOrientationRoll;
    private Integer minimumDetectableVelocity;
    private final List<Target> targets = new ArrayList<>();

    /**
     * Constructor.
     *
     * <p>Note that the Dwell Segment has mandatory elements that need to be set, as noted in the
     * setter javadoc.
     */
    public DwellSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.DwellSegment;
    }

    /**
     * Revisit Index (D2).
     *
     * <p>The sequential count of a revisit of the bounding area in the last sent Job Definition
     * Segment, where a Revisit Index of 0 indicates the first revisit. In other words, if the
     * sensor on that job actually is revisiting the last Job Definition Segment's bounding area,
     * increment the count, otherwise reset to 0.
     *
     * <p>The revisit index is mandatory in the Dwell Segment.
     *
     * @return the revisit index as an integer value.
     */
    public Integer getRevisitIndex() {
        return revisitIndex;
    }

    /**
     * Revisit Index (D2).
     *
     * <p>The sequential count of a revisit of the bounding area in the last sent Job Definition
     * Segment, where a Revisit Index of 0 indicates the first revisit. In other words, if the
     * sensor on that job actually is revisiting the last Job Definition Segment's bounding area,
     * increment the count, otherwise reset to 0.
     *
     * <p>The revisit index is mandatory in the Dwell Segment.
     *
     * @param revisitIndex the revisit index value as an integer, in the valid range of [0, 65535].
     */
    public void setRevisitIndex(Integer revisitIndex) {
        this.revisitIndex = revisitIndex;
    }

    /**
     * Dwell Index (D3).
     *
     * <p>The temporally sequential count of a dwell within the revisit of a particular bounding
     * area for a given job ID. A dwell index of “0” indicates the first dwell of the revisit.
     *
     * <p>The dwell index is mandatory in the Dwell Segment.
     *
     * @return the dwell index as an integer.
     */
    public Integer getDwellIndex() {
        return dwellIndex;
    }

    /**
     * Set the dwell Index (D3).
     *
     * <p>The temporally sequential count of a dwell within the revisit of a particular bounding
     * area for a given job ID. A dwell index of “0” indicates the first dwell of the revisit.
     *
     * <p>The dwell index is mandatory in the Dwell Segment.
     *
     * @param dwellIndex index the dwell index as an integer, in the valid range of [0, 65535].
     */
    public void setDwellIndex(Integer dwellIndex) {
        this.dwellIndex = dwellIndex;
    }

    /**
     * Last Dwell of Revisit (D4).
     *
     * <p>A flag to indicate that this is the last dwell of the revisit. The Last Dwell of Revisit
     * flag set to true indicates there are no additional dwells within that revisit.
     *
     * <p>Note that a Dwell Index, field D3, of 0 and a Last Dwell of Revisit, field D4, of true (1)
     * indicates this is the first and only dwell. This allows the concept of a "dwell" to be used
     * by systems that do not utilize multiple dwells or revisits of the radar beam.
     *
     * <p>Last dwell of revisit is mandatory in the Dwell Segment.
     *
     * @return true if this is the last dwell of revisit, false if this is not the last dwell of
     *     revisit.
     */
    public Boolean getLastDwellOfRevisit() {
        return lastDwellOfRevisit;
    }

    /**
     * Set the Last Dwell of Revisit (D4).
     *
     * <p>A flag to indicate that this is the last dwell of the revisit. The Last Dwell of Revisit
     * flag set to true indicates there are no additional dwells within that revisit.
     *
     * <p>Note that a Dwell Index, field D3, of 0 and a Last Dwell of Revisit, field D4, of true (1)
     * indicates this is the first and only dwell. This allows the concept of a "dwell" to be used
     * by systems that do not utilize multiple dwells or revisits of the radar beam.
     *
     * <p>Last dwell of revisit is mandatory in the Dwell Segment.
     *
     * @param lastDwellOfRevisit true if this is the last dwell of revisit, false if this is not the
     *     last dwell of revisit.
     */
    public void setLastDwellOfRevisit(Boolean lastDwellOfRevisit) {
        this.lastDwellOfRevisit = lastDwellOfRevisit;
    }

    /**
     * Target Report Count (D5).
     *
     * <p>A count of the total number of targets reported during this dwell and sent in this Dwell
     * Segment.
     *
     * @return the target report count
     */
    public Integer getTargetReportCount() {
        return targetReportCount;
    }

    /**
     * Set the Target Report Count (D5).
     *
     * <p>A count of the total number of targets reported during this dwell and sent in this Dwell
     * Segment.
     *
     * <p>Note that the list of targets has to match this value.
     *
     * <p>Target report count is mandatory in the Dwell Segment.
     *
     * @param targetReportCount the target report count (in the valid range [0, 65535]
     */
    public void setTargetReportCount(Integer targetReportCount) {
        this.targetReportCount = targetReportCount;
    }

    /**
     * Dwell Time (D6).
     *
     * <p>The elapsed time, expressed in milliseconds, from the midnight at the beginning of the day
     * specified in the Reference Time fields of the Mission Segment to the temporal center of the
     * dwell. In this manner, the Dwell Time corresponds to the day's UTC time converted to
     * milliseconds, with the possible addition of multiples of 86400000 for multi- day missions.
     *
     * @return the dwell time stamp as a Long value, in milliseconds.
     */
    public Long getDwellTime() {
        return dwellTime;
    }

    /**
     * Set the Dwell Time (D6).
     *
     * <p>The elapsed time, expressed in milliseconds, from the midnight at the beginning of the day
     * specified in the Reference Time fields of the Mission Segment to the temporal center of the
     * dwell. In this manner, the Dwell Time corresponds to the day's UTC time converted to
     * milliseconds, with the possible addition of multiples of 86400000 for multi- day missions.
     *
     * <p>The dwell time is mandatory in the Dwell Segment.
     *
     * @param dwellTime the dwell time stamp, in the range [0, 4.0 x 10<sup>9</sup>] milliseconds.
     */
    public void setDwellTime(Long dwellTime) {
        this.dwellTime = dwellTime;
    }

    /**
     * Sensor Position – Latitude (D7).
     *
     * <p>The North-South position of the sensor at the temporal center of the dwell, expressed as
     * degrees North (positive) or South (negative) of the Equator.
     *
     * @return the latitude as a floating point (decimal degrees) value.
     */
    public double getSensorLatitude() {
        return sensorLatitude;
    }

    /**
     * Set the Sensor Position – Latitude (D7).
     *
     * <p>The North-South position of the sensor at the temporal center of the dwell, expressed as
     * degrees North (positive) or South (negative) of the Equator.
     *
     * @param sensorLatitude the latitude as a floating point (decimal degrees) value.
     */
    public void setSensorLatitude(double sensorLatitude) {
        this.sensorLatitude = sensorLatitude;
    }

    /**
     * Sensor Position – Longitude (D8).
     *
     * <p>The East-West position of the sensor at the temporal center of the dwell, expressed as
     * degrees East (positive) from the Prime Meridian.
     *
     * @return sensor longitude as a floating point (decimal degrees) value.
     */
    public double getSensorLongitude() {
        return sensorLongitude;
    }

    /**
     * Set the Sensor Position – Longitude (D8).
     *
     * <p>The East-West position of the sensor at the temporal center of the dwell, expressed as
     * degrees East (positive) from the Prime Meridian.
     *
     * @param sensorLongitude sensor longitude as a floating point (decimal degrees) value.
     */
    public void setSensorLongitude(double sensorLongitude) {
        this.sensorLongitude = sensorLongitude;
    }

    /**
     * Sensor Position – Altitude (D9).
     *
     * <p>The altitude of the sensor at temporal center of the dwell, referenced to its position
     * above the WGS 84 ellipsoid, expressed in centimeters.
     *
     * @return the sensor altitude as an integer value in centimetres above the ellipsoid (HAE).
     */
    public int getSensorAltitude() {
        return sensorAltitude;
    }

    /**
     * Set the Sensor Position – Altitude (D9).
     *
     * <p>The altitude of the sensor at temporal center of the dwell, referenced to its position
     * above the WGS 84 ellipsoid, expressed in centimeters.
     *
     * @param sensorAltitude the sensor altitude as an integer value in centimetres above the
     *     ellipsoid (HAE).
     */
    public void setSensorAltitude(int sensorAltitude) {
        this.sensorAltitude = sensorAltitude;
    }

    public Double getScaleFactorLatScale() {
        return scaleFactorLatScale;
    }

    public void setScaleFactorLatScale(Double scaleFactorLatScale) {
        this.scaleFactorLatScale = scaleFactorLatScale;
    }

    public Double getScaleFactorLonScale() {
        return scaleFactorLonScale;
    }

    public void setScaleFactorLonScale(Double scaleFactorLonScale) {
        this.scaleFactorLonScale = scaleFactorLonScale;
    }

    public Integer getSensorPositionUncertaintyAlongTrack() {
        return sensorPositionUncertaintyAlongTrack;
    }

    public void setSensorPositionUncertaintyAlongTrack(
            Integer sensorPositionUncertaintyAlongTrack) {
        this.sensorPositionUncertaintyAlongTrack = sensorPositionUncertaintyAlongTrack;
    }

    public Integer getSensorPositionUncertaintyCrossTrack() {
        return sensorPositionUncertaintyCrossTrack;
    }

    public void setSensorPositionUncertaintyCrossTrack(Integer sensorPositionUncertaintyCrossrack) {
        this.sensorPositionUncertaintyCrossTrack = sensorPositionUncertaintyCrossrack;
    }

    public Integer getSensorPositionUncertaintyAltitude() {
        return sensorPositionUncertaintyAltitude;
    }

    public void setSensorPositionUncertaintyAltitude(Integer sensorPositionUncertaintyAltitude) {
        this.sensorPositionUncertaintyAltitude = sensorPositionUncertaintyAltitude;
    }

    public Double getSensorTrack() {
        return sensorTrack;
    }

    public void setSensorTrack(Double sensorTrack) {
        this.sensorTrack = sensorTrack;
    }

    public Integer getSensorSpeed() {
        return sensorSpeed;
    }

    public void setSensorSpeed(Integer sensorSpeed) {
        this.sensorSpeed = sensorSpeed;
    }

    public Integer getSensorVerticalVelocity() {
        return sensorVerticalVelocity;
    }

    public void setSensorVerticalVelocity(Integer sensorVerticalVelocity) {
        this.sensorVerticalVelocity = sensorVerticalVelocity;
    }

    public Integer getSensorTrackUncertainty() {
        return sensorTrackUncertainty;
    }

    public void setSensorTrackUncertainty(Integer sensorTrackUncertainty) {
        this.sensorTrackUncertainty = sensorTrackUncertainty;
    }

    public Integer getSensorSpeedUncertainty() {
        return sensorSpeedUncertainty;
    }

    public void setSensorSpeedUncertainty(Integer sensorSpeedUncertainty) {
        this.sensorSpeedUncertainty = sensorSpeedUncertainty;
    }

    public Integer getSensorVerticalVelocityUncertainty() {
        return sensorVerticalVelocityUncertainty;
    }

    public void setSensorVerticalVelocityUncertainty(Integer sensorVerticalVelocityUncertainty) {
        this.sensorVerticalVelocityUncertainty = sensorVerticalVelocityUncertainty;
    }

    public Double getPlatformOrientationHeading() {
        return platformOrientationHeading;
    }

    public void setPlatformOrientationHeading(Double platformOrientationHeading) {
        this.platformOrientationHeading = platformOrientationHeading;
    }

    public Double getPlatformOrientationPitch() {
        return platformOrientationPitch;
    }

    public void setPlatformOrientationPitch(Double platformOrientationPitch) {
        this.platformOrientationPitch = platformOrientationPitch;
    }

    public Double getPlatformOrientationRoll() {
        return platformOrientationRoll;
    }

    public void setPlatformOrientationRoll(Double platformOrientationRoll) {
        this.platformOrientationRoll = platformOrientationRoll;
    }

    public double getDwellCentreLatitude() {
        return dwellCentreLatitude;
    }

    public void setDwellCentreLatitude(double dwellCentreLatitude) {
        this.dwellCentreLatitude = dwellCentreLatitude;
    }

    public double getDwellCentreLongitude() {
        return dwellCentreLongitude;
    }

    public void setDwellCentreLongitude(double dwellCentreLongitude) {
        this.dwellCentreLongitude = dwellCentreLongitude;
    }

    public double getDwellAreaRangeHalfExtent() {
        return dwellAreaRangeHalfExtent;
    }

    public void setDwellAreaRangeHalfExtent(double dwellAreaRangeHalfExtent) {
        this.dwellAreaRangeHalfExtent = dwellAreaRangeHalfExtent;
    }

    public double getDwellAreaDwellAngleHalfExtent() {
        return dwellAreaDwellAngleHalfExtent;
    }

    public void setDwellAreaDwellAngleHalfExtent(double dwellAreaDwellAngleHalfExtent) {
        this.dwellAreaDwellAngleHalfExtent = dwellAreaDwellAngleHalfExtent;
    }

    public Double getSensorOrientationHeading() {
        return sensorOrientationHeading;
    }

    public void setSensorOrientationHeading(Double sensorOrientationHeading) {
        this.sensorOrientationHeading = sensorOrientationHeading;
    }

    public Double getSensorOrientationPitch() {
        return sensorOrientationPitch;
    }

    public void setSensorOrientationPitch(Double sensorOrientationPitch) {
        this.sensorOrientationPitch = sensorOrientationPitch;
    }

    public Double getSensorOrientationRoll() {
        return sensorOrientationRoll;
    }

    public void setSensorOrientationRoll(Double sensorOrientationRoll) {
        this.sensorOrientationRoll = sensorOrientationRoll;
    }

    public Integer getMinimumDetectableVelocity() {
        return minimumDetectableVelocity;
    }

    public void setMinimumDetectableVelocity(Integer minimumDetectableVelocity) {
        this.minimumDetectableVelocity = minimumDetectableVelocity;
    }

    public List<Target> getTargets() {
        return new ArrayList<>(targets);
    }

    public void addTarget(Target target) {
        // TODO: probably needs to copy
        this.targets.add(target);
    }
}
