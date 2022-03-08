package net.frogmouth.rnd.jim.s4607.platformlocation;

import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Platform Location Segment.
 *
 * <p>The Platform Location Segment provides information pertaining to the location of the sensor
 * platform during periods when the sensor is not collecting data. It shall be sent as required
 * during periods in which the sensor is not collecting data, such as en-route to an orbit location,
 * during a turn, or any other time at which platform location is required.
 *
 * <p>All fields in the Platform Location Segment are mandatory.
 */
public class PlatformLocationSegment extends Segment {

    private long locationTime;
    private double platformPositionLatitude;
    private double platformPositionLongitude;
    private int platformPositionAltitude;
    private double platformTrack;
    private long platformSpeed;
    private int platformVerticalVelocity;

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.PlatformLocationSegment;
    }

    /**
     * Location Time (L1).
     *
     * <p>The elapsed time, expressed in milliseconds, from midnight at the beginning of the day
     * specified in the Reference Time fields of the Mission Segment to the time the report is
     * prepared. In this manner, the Location Time corresponds to the day's UTC time converted to
     * milliseconds, with the possible addition of multiples of 86400000 for multi-day missions.
     *
     * @return the location time in milliseconds.
     */
    public long getLocationTime() {
        return locationTime;
    }

    /**
     * Set the Location Time (L1).
     *
     * <p>The elapsed time, expressed in milliseconds, from midnight at the beginning of the day
     * specified in the Reference Time fields of the Mission Segment to the time the report is
     * prepared. In this manner, the Location Time corresponds to the day's UTC time converted to
     * milliseconds, with the possible addition of multiples of 86400000 for multi-day missions.
     *
     * @param timeOffset the elapsed time in milliseconds.
     */
    public void setLocationTime(long timeOffset) {
        this.locationTime = timeOffset;
    }

    /**
     * Platform Position – Latitude (L2).
     *
     * <p>The North-South position of the platform at the time the report is prepared, expressed as
     * degrees North (positive) or South (negative) of the Equator.
     *
     * @return the platform latitude in degrees.
     */
    public double getPlatformPositionLatitude() {
        return platformPositionLatitude;
    }

    /**
     * Set the Platform Position – Latitude (L2).
     *
     * <p>The North-South position of the platform at the time the report is prepared, expressed as
     * degrees North (positive) or South (negative) of the Equator.
     *
     * @param latitude the latitude in degrees (valid range is -90 to +89.999999958).
     */
    public void setPlatformPositionLatitude(double latitude) {
        this.platformPositionLatitude = latitude;
    }

    /**
     * Platform Position – Longitude (L3).
     *
     * <p>The East-West position of the platform at the time the report is prepared, expressed as
     * degrees East (positive) from the Prime Meridian.
     *
     * @return platform longitude in degrees (range is 0 to +359.999999916)
     */
    public double getPlatformPositionLongitude() {
        return platformPositionLongitude;
    }

    /**
     * Set the Platform Position – Longitude (L3).
     *
     * <p>The East-West position of the platform at the time the report is prepared, expressed as
     * degrees East (positive) from the Prime Meridian.
     *
     * @param longitude platform longitude in degrees (valid range is 0 to +359.999999916)
     */
    public void setPlatformPositionLongitude(double longitude) {
        this.platformPositionLongitude = longitude;
    }

    /**
     * Platform Position – Altitude (L4).
     *
     * <p>The altitude of the platform at the time the report is prepared, referenced to its
     * position above the WGS 84 ellipsoid, expressed in centimetres.
     *
     * @return altitude in centimetres above the ellipsoid (HAE).
     */
    public int getPlatformPositionAltitude() {
        return platformPositionAltitude;
    }

    /**
     * Set the Platform Position – Altitude (L4).
     *
     * <p>The altitude of the platform at the time the report is prepared, referenced to its
     * position above the WGS 84 ellipsoid, expressed in centimetres.
     *
     * @param altitude altitude in centimetres above the ellipsoid (HAE) in the valid range of
     *     -50000 to 2 billion.
     */
    public void setPlatformPositionAltitude(int altitude) {
        this.platformPositionAltitude = altitude;
    }

    /**
     * Platform Track (L5).
     *
     * <p>The ground track of the platform at the time the report is prepared, expressed as the
     * angle in degrees (clockwise) from True North.
     *
     * @return the ground track in degrees (0 to 359.9945)
     */
    public double getPlatformTrack() {
        return platformTrack;
    }

    /**
     * Set the Platform Track (L5).
     *
     * <p>The ground track of the platform at the time the report is prepared, expressed as the
     * angle in degrees (clockwise) from True North.
     *
     * @param track the ground track in degrees (valid range 0 to 359.9945)
     */
    public void setPlatformTrack(double track) {
        this.platformTrack = track;
    }

    /**
     * Platform Speed (L6).
     *
     * <p>The ground speed of the platform at the time the report is prepared, expressed as
     * millimetres per second.
     *
     * @return the platform speed in millimetres / second.
     */
    public long getPlatformSpeed() {
        return platformSpeed;
    }

    /**
     * Set the Platform Speed (L6).
     *
     * <p>The ground speed of the platform at the time the report is prepared, expressed as
     * millimetres per second.
     *
     * @param speed speed in millimetres per second (valid range 0 to 8000000)
     */
    public void setPlatformSpeed(long speed) {
        this.platformSpeed = speed;
    }

    /**
     * Platform Vertical Velocity (L7).
     *
     * <p>The velocity of the platform in the vertical direction, expressed as decimetres per
     * second.
     *
     * @return platform vertical velocity in decimetres per second.
     */
    public int getPlatformVerticalVelocity() {
        return platformVerticalVelocity;
    }

    /**
     * Set the Platform Vertical Velocity (L7).
     *
     * <p>The velocity of the platform in the vertical direction, expressed as decimetres per
     * second.
     *
     * @param velocity platform vertical velocity in decimetres per second (valid range -128 to
     *     +127).
     */
    public void setPlatformVerticalVelocity(int velocity) {
        this.platformVerticalVelocity = velocity;
    }
}
