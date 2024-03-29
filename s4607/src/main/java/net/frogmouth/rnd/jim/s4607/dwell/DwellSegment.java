package net.frogmouth.rnd.jim.s4607.dwell;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

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
    private final List<TargetReport> targets = new ArrayList<>();

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

    /**
     * Scale Factor – Latitude Scale (D10).
     *
     * <p>A factor which modifies the value of the reported target latitude (Delta Latitude, field
     * D32.4) when it is necessary to send the reduced bandwidth version of the Target Report. The
     * Latitude Scale factor and Delta Latitude are used in conjunction with the Dwell Area Center
     * Latitude (field D24) to recover the target latitude as follows:
     *
     * <p>Latitude = [(Delta Lat) x (Lat Scale)] + (Center Lat)
     *
     * <p>The Latitude Scale shall be chosen in accordance with the guidance given in the AEDP for
     * STANAG 4607.
     *
     * <p>Field D10 is Conditional and is always sent with field D11. They are sent if and only if
     * the optional difference fields Delta Latitude (D32.4) and Delta Longitude (D32.5) are sent in
     * the Target Report.
     *
     * @return the scale factor value, or null if not set.
     */
    public Double getScaleFactorLatScale() {
        return scaleFactorLatScale;
    }

    /**
     * Set the Scale Factor – Latitude Scale (D10).
     *
     * <p>A factor which modifies the value of the reported target latitude (Delta Latitude, field
     * D32.4) when it is necessary to send the reduced bandwidth version of the Target Report. The
     * Latitude Scale factor and Delta Latitude are used in conjunction with the Dwell Area Center
     * Latitude (field D24) to recover the target latitude as follows:
     *
     * <p>Latitude = [(Delta Lat) x (Lat Scale)] + (Center Lat)
     *
     * <p>The Latitude Scale shall be chosen in accordance with the guidance given in the AEDP for
     * STANAG 4607.
     *
     * <p>Field D10 is Conditional and is always sent with field D11. They are sent if and only if
     * the optional difference fields Delta Latitude (D32.4) and Delta Longitude (D32.5) are sent in
     * the Target Report.
     *
     * @param scaleFactorLatScale the scale factor value
     */
    public void setScaleFactorLatScale(double scaleFactorLatScale) {
        this.scaleFactorLatScale = scaleFactorLatScale;
    }

    /**
     * Scale Factor – Longitude Scale (D11).
     *
     * <p>A factor which modifies the value of the reported target longitude (Delta Longitude, field
     * D32.5) when it is necessary to send the reduced bandwidth version of the Target Report. The
     * Longitude Scale factor and Delta Longitude are used in conjunction with the Dwell Area Center
     * Longitude (field D25) to recover the target latitude as follows:
     *
     * <p>Longitude = [(Delta Long) x (Long Scale)] + (Center Long)
     *
     * <p>The Longitude Scale shall be chosen in accordance with the guidance given in the AEDP for
     * STANAG 4607.
     *
     * <p>Field D11 is Conditional and is always sent with field D10. They are sent if and only if
     * the optional difference fields Delta Latitude (D32.4) and Delta Longitude (D32.5) are sent in
     * the Target Report).
     *
     * @return the scale factor value, or null if not set.
     */
    public Double getScaleFactorLonScale() {
        return scaleFactorLonScale;
    }

    /**
     * Set the Scale Factor – Longitude Scale (D11).
     *
     * <p>A factor which modifies the value of the reported target longitude (Delta Longitude, field
     * D32.5) when it is necessary to send the reduced bandwidth version of the Target Report. The
     * Longitude Scale factor and Delta Longitude are used in conjunction with the Dwell Area Center
     * Longitude (field D25) to recover the target latitude as follows:
     *
     * <p>Longitude = [(Delta Long) x (Long Scale)] + (Center Long)
     *
     * <p>The Longitude Scale shall be chosen in accordance with the guidance given in the AEDP for
     * STANAG 4607.
     *
     * <p>Field D11 is Conditional and is always sent with field D10. They are sent if and only if
     * the optional difference fields Delta Latitude (D32.4) and Delta Longitude (D32.5) are sent in
     * the Target Report).
     *
     * @param scaleFactorLonScale the scale factor value, or null if not set.
     */
    public void setScaleFactorLonScale(Double scaleFactorLonScale) {
        this.scaleFactorLonScale = scaleFactorLonScale;
    }

    /**
     * Sensor Position Uncertainty – Along Track (D12).
     *
     * <p>Estimate of the standard deviation in the estimated horizontal sensor location at the time
     * of the dwell, measured along the sensor track direction (field D15), expressed in
     * centimetres.
     *
     * <p>Field D12 is Optional. It is always sent with fields D13 and D14.
     *
     * @return the sensor position uncertainty in centimetres, or null if not set.
     */
    public Integer getSensorPositionUncertaintyAlongTrack() {
        return sensorPositionUncertaintyAlongTrack;
    }

    /**
     * Set the Sensor Position Uncertainty – Along Track (D12).
     *
     * <p>Estimate of the standard deviation in the estimated horizontal sensor location at the time
     * of the dwell, measured along the sensor track direction (field D15), expressed in
     * centimetres.
     *
     * <p>Field D12 is Optional. It is always sent with fields D13 and D14.
     *
     * @param uncertainty the sensor position uncertainty in centimetres, or null if not set.
     */
    public void setSensorPositionUncertaintyAlongTrack(int uncertainty) {
        this.sensorPositionUncertaintyAlongTrack = uncertainty;
    }

    /**
     * Sensor Position Uncertainty – Cross-Track (D13).
     *
     * <p>Estimate of the standard deviation in the estimated horizontal sensor location at the time
     * of the dwell, measured orthogonal to the sensor track direction (field D15), expressed in
     * centimetres.
     *
     * <p>Field D13 is Optional. It is always sent with fields D12 and D14.
     *
     * @return the sensor position uncertainty in centimetres, or null if not set.
     */
    public Integer getSensorPositionUncertaintyCrossTrack() {
        return sensorPositionUncertaintyCrossTrack;
    }

    /**
     * Set the Sensor Position Uncertainty – Cross-Track (D13).
     *
     * <p>Estimate of the standard deviation in the estimated horizontal sensor location at the time
     * of the dwell, measured orthogonal to the sensor track direction (field D15), expressed in
     * centimetres.
     *
     * <p>Field D13 is Optional. It is always sent with fields D12 and D14.
     *
     * @param uncertainty the sensor position uncertainty in centimetres, or null if not set.
     */
    public void setSensorPositionUncertaintyCrossTrack(int uncertainty) {
        this.sensorPositionUncertaintyCrossTrack = uncertainty;
    }

    /**
     * Sensor Position Uncertainty – Altitude (D14).
     *
     * <p>Standard deviation of the sensor altitude estimate (field D9), expressed in centimetres.
     *
     * <p>Field D14 is Optional. It is always sent with fields D12 and D13
     *
     * @return the sensor position uncertainty in centimetres, or null if not set
     */
    public Integer getSensorPositionUncertaintyAltitude() {
        return sensorPositionUncertaintyAltitude;
    }

    /**
     * Set the Sensor Position Uncertainty – Altitude (D14).
     *
     * <p>Standard deviation of the sensor altitude estimate (field D9), expressed in centimetres.
     *
     * <p>Field D14 is Optional. It is always sent with fields D12 and D13
     *
     * @param uncertainty the sensor position uncertainty in centimetres, or null if not set
     */
    public void setSensorPositionUncertaintyAltitude(Integer uncertainty) {
        this.sensorPositionUncertaintyAltitude = uncertainty;
    }

    /**
     * Sensor Track (D15).
     *
     * <p>The ground track of the sensor at the time of the dwell, expressed as the angle in degrees
     * (clockwise) from True North.
     *
     * <p>Field D15 is Conditional and is always sent with fields D16 and D17. They are sent only
     * when the sensor system provides these parameters.
     *
     * @return sensor track in degrees from true north, or null if not set
     */
    public Double getSensorTrack() {
        return sensorTrack;
    }

    /**
     * Set the Sensor Track (D15).
     *
     * <p>The ground track of the sensor at the time of the dwell, expressed as the angle in degrees
     * (clockwise) from True North.
     *
     * <p>Field D15 is Conditional and is always sent with fields D16 and D17. They are sent only
     * when the sensor system provides these parameters.
     *
     * @param sensorTrack sensor track in degrees from true north
     */
    public void setSensorTrack(double sensorTrack) {
        this.sensorTrack = sensorTrack;
    }

    /**
     * Sensor Speed (D16).
     *
     * <p>The ground speed of the sensor at the time of the dwell, expressed as millimetres per
     * second.
     *
     * <p>Field D16 is Conditional and is always sent with fields D15 and D17. They are sent only
     * when the sensor system provides these parameters.
     *
     * @return sensor speed in millimetres per second, or null if not set.
     */
    public Integer getSensorSpeed() {
        return sensorSpeed;
    }

    /**
     * Set the Sensor Speed (D16).
     *
     * <p>The ground speed of the sensor at the time of the dwell, expressed as millimetres per
     * second.
     *
     * <p>Field D16 is Conditional and is always sent with fields D15 and D17. They are sent only
     * when the sensor system provides these parameters.
     *
     * @param sensorSpeed sensor speed in millimetres per second.
     */
    public void setSensorSpeed(int sensorSpeed) {
        this.sensorSpeed = sensorSpeed;
    }

    /**
     * Sensor Vertical Velocity (D17).
     *
     * <p>The velocity of the sensor in the vertical direction, expressed as decimetres per second.
     *
     * <p>Field D17 is Conditional and is always sent with fields D15 and D16. They are sent only
     * when the sensor system provides these parameters.
     *
     * @return sensor vertical velocity in decimetres per second, or null if not set
     */
    public Integer getSensorVerticalVelocity() {
        return sensorVerticalVelocity;
    }

    /**
     * Set the Sensor Vertical Velocity (D17).
     *
     * <p>The velocity of the sensor in the vertical direction, expressed as decimetres per second.
     *
     * <p>Field D17 is Conditional and is always sent with fields D15 and D16. They are sent only
     * when the sensor system provides these parameters.
     *
     * @param sensorVerticalVelocity sensor vertical velocity in decimetres per second
     */
    public void setSensorVerticalVelocity(int sensorVerticalVelocity) {
        this.sensorVerticalVelocity = sensorVerticalVelocity;
    }

    /**
     * Sensor Track Uncertainty (D18).
     *
     * <p>The standard deviation of the estimate of the sensor track along the ground, expressed in
     * degrees.
     *
     * <p>Field D18 is Optional. It is always sent with fields D19 and D20.
     *
     * @return sensor track uncertainty in degrees, or null if not set.
     */
    public Integer getSensorTrackUncertainty() {
        return sensorTrackUncertainty;
    }

    /**
     * Set the Sensor Track Uncertainty (D18).
     *
     * <p>The standard deviation of the estimate of the sensor track along the ground, expressed in
     * degrees.
     *
     * <p>Field D18 is Optional. It is always sent with fields D19 and D20.
     *
     * @param sensorTrackUncertainty sensor track uncertainty in degrees.
     */
    public void setSensorTrackUncertainty(int sensorTrackUncertainty) {
        this.sensorTrackUncertainty = sensorTrackUncertainty;
    }

    /**
     * Sensor Speed Uncertainty (D19).
     *
     * <p>The standard deviation of estimate of the sensor speed, expressed in millimetres per
     * second.
     *
     * <p>Field D19 is Optional. It is always sent with fields D18 and D20.
     *
     * @return sensor speed uncertainty in millimetres per second, or null if not set
     */
    public Integer getSensorSpeedUncertainty() {
        return sensorSpeedUncertainty;
    }

    /**
     * Set the Sensor Speed Uncertainty (D19).
     *
     * <p>The standard deviation of estimate of the sensor speed, expressed in millimetres per
     * second.
     *
     * <p>Field D19 is Optional. It is always sent with fields D18 and D20.
     *
     * @param sensorSpeedUncertainty sensor speed uncertainty in millimetres per second.
     */
    public void setSensorSpeedUncertainty(Integer sensorSpeedUncertainty) {
        this.sensorSpeedUncertainty = sensorSpeedUncertainty;
    }

    /**
     * Sensor Vertical Velocity Uncertainty (D20).
     *
     * <p>The standard deviation of estimate of the sensor vertical velocity, expressed in
     * centimetres per second.
     *
     * <p>Field D20 is Optional. It is always sent with fields D18 and D19.
     *
     * @return sensor vertical velocity in centimetres per second, or null if not set.
     */
    public Integer getSensorVerticalVelocityUncertainty() {
        return sensorVerticalVelocityUncertainty;
    }

    /**
     * Set the Sensor Vertical Velocity Uncertainty (D20).
     *
     * <p>The standard deviation of estimate of the sensor vertical velocity, expressed in
     * centimetres per second.
     *
     * <p>Field D20 is Optional. It is always sent with fields D18 and D19.
     *
     * @param sensorVerticalVelocityUncertainty sensor vertical velocity in centimetres per second.
     */
    public void setSensorVerticalVelocityUncertainty(int sensorVerticalVelocityUncertainty) {
        this.sensorVerticalVelocityUncertainty = sensorVerticalVelocityUncertainty;
    }

    /**
     * Platform Orientation - Heading (D21).
     *
     * <p>The heading of the platform at the time of the dwell, expressed as the angle in degrees
     * (clockwise) from True North to the roll axis of the platform.
     *
     * <p>Field D21 is Conditional and is always sent with fields D22 and D23. They are sent only
     * when the platform provides these parameters.
     *
     * @return platform heading in degrees from true north, or null if not set.
     */
    public Double getPlatformOrientationHeading() {
        return platformOrientationHeading;
    }

    /**
     * Set the Platform Orientation - Heading (D21).
     *
     * <p>The heading of the platform at the time of the dwell, expressed as the angle in degrees
     * (clockwise) from True North to the roll axis of the platform.
     *
     * <p>Field D21 is Conditional and is always sent with fields D22 and D23. They are sent only
     * when the platform provides these parameters.
     *
     * @param platformOrientationHeading platform heading in degrees from true north
     */
    public void setPlatformOrientationHeading(double platformOrientationHeading) {
        this.platformOrientationHeading = platformOrientationHeading;
    }

    /**
     * Platform Orientation - Pitch (D22).
     *
     * <p>The pitch angle of the platform at the time of the dwell, expressed as the angle in
     * degrees of the rotation of the platform about its pitch axis, where a positive angle is an
     * upward attitude of the nose of the platform.
     *
     * <p>Field D22 is Conditional and is always sent with fields D21 and D23. They are sent only
     * when the platform provides these parameters.
     *
     * @return the platform pitch angle in degrees, or null if not set
     */
    public Double getPlatformOrientationPitch() {
        return platformOrientationPitch;
    }

    /**
     * Platform Orientation - Pitch (D22).
     *
     * <p>The pitch angle of the platform at the time of the dwell, expressed as the angle in
     * degrees of the rotation of the platform about its pitch axis, where a positive angle is an
     * upward attitude of the nose of the platform.
     *
     * <p>Field D22 is Conditional and is always sent with fields D21 and D23. They are sent only
     * when the platform provides these parameters.
     *
     * @param platformOrientationPitch the platform pitch angle in degrees.
     */
    public void setPlatformOrientationPitch(double platformOrientationPitch) {
        this.platformOrientationPitch = platformOrientationPitch;
    }

    /**
     * Platform Orientation - Roll (D23).
     *
     * <p>The roll angle of the platform at the time of the dwell, expressed as the angle in degrees
     * of the rotation of the platform about its roll axis, where a positive angle is the clockwise
     * direction as viewed from the rear of the platform. (NOTE: The term "Platform Bank Angle" is
     * synonymous with the term "Platform Roll Angle".)
     *
     * <p>Field D23 is Conditional and is always sent with fields D21 and D22. They are sent only
     * when the platform provides these parameters.
     *
     * @return platform roll angle in degrees, or null if not set.
     */
    public Double getPlatformOrientationRoll() {
        return platformOrientationRoll;
    }

    /**
     * Set the Platform Orientation - Roll (D23).
     *
     * <p>The roll angle of the platform at the time of the dwell, expressed as the angle in degrees
     * of the rotation of the platform about its roll axis, where a positive angle is the clockwise
     * direction as viewed from the rear of the platform. (NOTE: The term "Platform Bank Angle" is
     * synonymous with the term "Platform Roll Angle".)
     *
     * <p>Field D23 is Conditional and is always sent with fields D21 and D22. They are sent only
     * when the platform provides these parameters.
     *
     * @param platformOrientationRoll platform roll angle in degrees, or null if not set.
     */
    public void setPlatformOrientationRoll(Double platformOrientationRoll) {
        this.platformOrientationRoll = platformOrientationRoll;
    }

    /**
     * Dwell Area – Centre Latitude (D24).
     *
     * <p>The North-South position of the centre of the dwell area, expressed as degrees North
     * (positive) or South (negative) of the Equator.
     *
     * <p>This field is mandatory.
     *
     * @return the latitude in degrees
     */
    public double getDwellCentreLatitude() {
        return dwellCentreLatitude;
    }

    /**
     * Set the Dwell Area – Centre Latitude (D24).
     *
     * <p>The North-South position of the centre of the dwell area, expressed as degrees North
     * (positive) or South (negative) of the Equator.
     *
     * <p>This field is mandatory.
     *
     * @param dwellCentreLatitude the latitude in degrees
     */
    public void setDwellCentreLatitude(double dwellCentreLatitude) {
        this.dwellCentreLatitude = dwellCentreLatitude;
    }

    /**
     * Dwell Area – Centre Longitude (D25).
     *
     * <p>The East-West position of the centre of the dwell area, expressed as degrees East
     * (positive) of the Prime Meridian.
     *
     * <p>This field is mandatory.
     *
     * @return the longitude in degrees.
     */
    public double getDwellCentreLongitude() {
        return dwellCentreLongitude;
    }

    /**
     * Set the Dwell Area – Centre Longitude (D25).
     *
     * <p>The East-West position of the centre of the dwell area, expressed as degrees East
     * (positive) of the Prime Meridian.
     *
     * <p>This field is mandatory.
     *
     * @param dwellCentreLongitude the longitude in degrees.
     */
    public void setDwellCentreLongitude(double dwellCentreLongitude) {
        this.dwellCentreLongitude = dwellCentreLongitude;
    }

    /**
     * Dwell Area – Range Half Extent (D26).
     *
     * <p>The distance on the earth surface, expressed in kilometres, from the near edge to the
     * centre of the dwell area.
     *
     * <p>This field is mandatory.
     *
     * @return the dwell area range value in kilometres
     */
    public double getDwellAreaRangeHalfExtent() {
        return dwellAreaRangeHalfExtent;
    }

    /**
     * Set the Dwell Area – Range Half Extent (D26).
     *
     * <p>The distance on the earth surface, expressed in kilometres, from the near edge to the
     * centre of the dwell area.
     *
     * <p>This field is mandatory.
     *
     * @param dwellAreaRangeHalfExtent the dwell area range value in kilometres
     */
    public void setDwellAreaRangeHalfExtent(double dwellAreaRangeHalfExtent) {
        this.dwellAreaRangeHalfExtent = dwellAreaRangeHalfExtent;
    }

    /**
     * Dwell Area – Dwell Angle Half Extent (D27).
     *
     * <p>For dwell based radars, one-half of the 3-dB beamwidth, expressed in degrees. For
     * non-dwell based radars, the angle between the beginning of the dwell to the centre of the
     * dwell, as measured from the sensor’s position.
     *
     * <p>This field is mandatory.
     *
     * @return the dwell angle in degrees.
     */
    public double getDwellAreaDwellAngleHalfExtent() {
        return dwellAreaDwellAngleHalfExtent;
    }

    /**
     * Set the Dwell Area – Dwell Angle Half Extent (D27).
     *
     * <p>For dwell based radars, one-half of the 3-dB beamwidth, expressed in degrees. For
     * non-dwell based radars, the angle between the beginning of the dwell to the centre of the
     * dwell, as measured from the sensor’s position.
     *
     * <p>This field is mandatory.
     *
     * @param dwellAreaDwellAngleHalfExtent the dwell angle in degrees.
     */
    public void setDwellAreaDwellAngleHalfExtent(double dwellAreaDwellAngleHalfExtent) {
        this.dwellAreaDwellAngleHalfExtent = dwellAreaDwellAngleHalfExtent;
    }

    /**
     * Sensor Orientation – Heading (D28).
     *
     * <p>The rotation of the sensor broadside face about the local vertical axis of the platform,
     * expressed in degrees clockwise when viewed from above. This is the first of three successive
     * rotations from a hypothetical initial position in which the sensor broadside (normal to the
     * sensor face) is in its normal “rest” position (i.e., along the platform roll axis for
     * forward-looking sensors or along the platform pitch axis for side-looking sensors) and the
     * sensor face is nominally level (i.e., the lateral axis of the face is level, pointing along
     * the roll or pitch axis as applicable, and the yaw axis points along the direction of the
     * local vertical). In the case where the sensor is an electronically steerable array (ESA),
     * "Sensor Orientation - Heading" refers to the rotation of the radar beam about the local
     * vertical axis of the platform, and is independent of any mechanical rotation of the sensor.
     *
     * <p>Field D28 is Optional. If at least one of fields D28, D29, or D30 is present, then any
     * omitted field shall represent an angle of zero degrees.
     *
     * @return the orientation of the sensor, or null if not set.
     */
    public Double getSensorOrientationHeading() {
        return sensorOrientationHeading;
    }

    /**
     * Set the Sensor Orientation – Heading (D28).
     *
     * <p>The rotation of the sensor broadside face about the local vertical axis of the platform,
     * expressed in degrees clockwise when viewed from above. This is the first of three successive
     * rotations from a hypothetical initial position in which the sensor broadside (normal to the
     * sensor face) is in its normal “rest” position (i.e., along the platform roll axis for
     * forward-looking sensors or along the platform pitch axis for side-looking sensors) and the
     * sensor face is nominally level (i.e., the lateral axis of the face is level, pointing along
     * the roll or pitch axis as applicable, and the yaw axis points along the direction of the
     * local vertical). In the case where the sensor is an electronically steerable array (ESA),
     * "Sensor Orientation - Heading" refers to the rotation of the radar beam about the local
     * vertical axis of the platform, and is independent of any mechanical rotation of the sensor.
     *
     * <p>Field D28 (this field) is Optional. If at least one of fields D28, D29, or D30 is present,
     * then any omitted field shall represent an angle of zero degrees.
     *
     * @param sensorOrientationHeading the orientation of the sensor.
     */
    public void setSensorOrientationHeading(double sensorOrientationHeading) {
        this.sensorOrientationHeading = sensorOrientationHeading;
    }

    /**
     * Sensor Orientation – Pitch (D29).
     *
     * <p>The rotation angle of the sensor normal about the lateral axis of the sensor broadside,
     * which is pointing in the direction defined by the sensor orientation heading angle. It is
     * expressed in degrees, where an angle above the horizontal is positive. This is the second of
     * three successive rotations from the hypothetical initial position of the sensor, as described
     * above. In the case where the sensor is an electronically steerable array (ESA), 'Sensor
     * Orientation - Pitch' refers to the rotation of the radar beam about the lateral axis of the
     * platform, and is independent of any mechanical rotation of the sensor.
     *
     * <p>Field D29 (this field) is Optional. If at least one of fields D28, D29, or D30 is present,
     * then any omitted field shall represent an angle of zero degrees.
     *
     * @return the orientation of the sensor, or null if not set.
     */
    public Double getSensorOrientationPitch() {
        return sensorOrientationPitch;
    }

    /**
     * Set the Sensor Orientation – Pitch (D29).
     *
     * <p>The rotation angle of the sensor normal about the lateral axis of the sensor broadside,
     * which is pointing in the direction defined by the sensor orientation heading angle. It is
     * expressed in degrees, where an angle above the horizontal is positive. This is the second of
     * three successive rotations from the hypothetical initial position of the sensor, as described
     * above. In the case where the sensor is an electronically steerable array (ESA), 'Sensor
     * Orientation - Pitch' refers to the rotation of the radar beam about the lateral axis of the
     * platform, and is independent of any mechanical rotation of the sensor.
     *
     * <p>Field D29 (this field) is Optional. If at least one of fields D28, D29, or D30 is present,
     * then any omitted field shall represent an angle of zero degrees.
     *
     * @param sensorOrientationPitch the orientation of the sensor.
     */
    public void setSensorOrientationPitch(double sensorOrientationPitch) {
        this.sensorOrientationPitch = sensorOrientationPitch;
    }

    /**
     * Sensor Orientation – Roll (D30).
     *
     * <p>The rotation angle of the sensor about the transverse axis of the sensor broadside, which
     * is pointing in the direction defined by the sensor orientation heading angle. It is expressed
     * in degrees, where a clockwise rotation is positive, as seen from behind the face of the
     * sensor. This is the third of three successive rotations from the hypothetical initial
     * position of the sensor, as described above. In the case where the sensor is an electronically
     * steerable array (ESA), 'Sensor Orientation - Roll' refers to the rotation of the radar beam
     * about the transverse axis of the platform, and is independent of any mechanical rotation of
     * the sensor.
     *
     * <p>Field D30 (this field) is Optional. If at least one of fields D28, D29, or D30 is present,
     * then any omitted field shall represent an angle of zero degrees.
     *
     * @return the orientation of the sensor, or null if not set.
     */
    public Double getSensorOrientationRoll() {
        return sensorOrientationRoll;
    }

    /**
     * Set the Sensor Orientation – Roll (D30).
     *
     * <p>The rotation angle of the sensor about the transverse axis of the sensor broadside, which
     * is pointing in the direction defined by the sensor orientation heading angle. It is expressed
     * in degrees, where a clockwise rotation is positive, as seen from behind the face of the
     * sensor. This is the third of three successive rotations from the hypothetical initial
     * position of the sensor, as described above. In the case where the sensor is an electronically
     * steerable array (ESA), 'Sensor Orientation - Roll' refers to the rotation of the radar beam
     * about the transverse axis of the platform, and is independent of any mechanical rotation of
     * the sensor.
     *
     * <p>Field D30 (this field) is Optional. If at least one of fields D28, D29, or D30 is present,
     * then any omitted field shall represent an angle of zero degrees.
     *
     * @param sensorOrientationRoll the orientation of the sensor.
     */
    public void setSensorOrientationRoll(double sensorOrientationRoll) {
        this.sensorOrientationRoll = sensorOrientationRoll;
    }

    /**
     * Minimum Detectable Velocity, MDV (D31).
     *
     * <p>The minimum velocity component, along the line of sight, which can be detected by the
     * sensor; expressed in decimetres per second.
     *
     * <p>Minimum Detectable Velocity is optional.
     *
     * @return the minimum detectable velocity in decimetres per second.
     */
    public Integer getMinimumDetectableVelocity() {
        return minimumDetectableVelocity;
    }

    /**
     * Set the Minimum Detectable Velocity, MDV (D31).
     *
     * <p>The minimum velocity component, along the line of sight, which can be detected by the
     * sensor; expressed in decimetres per second.
     *
     * <p>Minimum Detectable Velocity is optional.
     *
     * @param minimumDetectableVelocity the minimum detectable velocity in decimetres per second.
     */
    public void setMinimumDetectableVelocity(int minimumDetectableVelocity) {
        this.minimumDetectableVelocity = minimumDetectableVelocity;
    }

    /**
     * Get the list of targets in this dwell segment.
     *
     * @return copy of the list of targets.
     */
    public List<TargetReport> getTargets() {
        return new ArrayList<>(targets);
    }

    /**
     * Add a target to the target list in this dwell segment.
     *
     * @param target the target to add.
     */
    public void addTarget(TargetReport target) {
        this.targets.add(new TargetReport(target));
    }
}
