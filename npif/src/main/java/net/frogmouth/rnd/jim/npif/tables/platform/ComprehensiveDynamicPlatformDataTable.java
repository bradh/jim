package net.frogmouth.rnd.jim.npif.tables.platform;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Position;

/*
	File Addressing scheme is $00xx 0001 where xx represents the Platform ID, and Platform ID = $00 is reserved for the aircraft platform data.
	Table Requirement         :       Conditional on the Minimum Dynamic Platform Data Table not sent.
	Order of Navigational Confidence 2-bit codes:
	MSByte                             -------                       LSByte
	NU      F27  F26        F25     F24    ------- -------   F5      F4      F3    F2         F1
	Where Fn is a 2-bit code for field number n, as defined above. E.g. F1 is a 2-bit code that gives the navigational confidence of the field 1 the Platform Time, F2 is a
	2-bit code which gives the navigational confidence of the field 2 the Platform Geo-Location.
*/
public class ComprehensiveDynamicPlatformDataTable extends DataTable {
    private ZonedDateTime platformTime;
    private Position platformGeoLocation;
    private double mslAltitude;
    private double aglAltitude;
    private double gpsAltitude;
    private double platformTrueAirspeed;
    private double platformGroundSpeed;
    private double platformTrueCourse;
    private double platformTrueHeading;
    private double platformPitch;
    private double platformRoll;
    private double platformYaw;
    private double platformVelocityNorth;
    private double platformVelocityEast;
    private double platformVelocityDown;
    private double platformAccelerationNorth;
    private double platformAccelerationEast;
    private double platformAccelerationDown;
    private double platformHeadingRate;
    private double platformPitchRate;
    private double platformRollRate;
    private double platformYawRate;
    private double platformHeadingAngularAcceleration;
    private double platformPitchAngularAcceleration;
    private double platformRollAngularAcceleration;
    private double platformYawAngularAcceleration;
    private double velocityToHeightRatio;
    private int navigationalConfidence;

    public ZonedDateTime getPlatformTime() {
        return platformTime.plusHours(0);
    }

    public void setPlatformTime(ZonedDateTime platformTime) {
        this.platformTime = platformTime.plusHours(0);
    }

    public Position getPlatformGeoLocation() {
        return new Position(platformGeoLocation);
    }

    public void setPlatformGeoLocation(Position platformGeoLocation) {
        this.platformGeoLocation = new Position(platformGeoLocation);
    }

    public double getMslAltitude() {
        return mslAltitude;
    }

    public void setMslAltitude(double mslAltitude) {
        this.mslAltitude = mslAltitude;
    }

    public double getAglAltitude() {
        return aglAltitude;
    }

    public void setAglAltitude(double aglAltitude) {
        this.aglAltitude = aglAltitude;
    }

    public double getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(double gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public double getPlatformTrueAirspeed() {
        return platformTrueAirspeed;
    }

    public void setPlatformTrueAirspeed(double platformTrueAirspeed) {
        this.platformTrueAirspeed = platformTrueAirspeed;
    }

    public double getPlatformGroundSpeed() {
        return platformGroundSpeed;
    }

    public void setPlatformGroundSpeed(double platformGroundSpeed) {
        this.platformGroundSpeed = platformGroundSpeed;
    }

    public double getPlatformTrueCourse() {
        return platformTrueCourse;
    }

    public double getPlatformTrueCourseDegrees() {
        return radiansToDegrees(getPlatformTrueCourse());
    }

    public void setPlatformTrueCourse(double platformTrueCourse) {
        this.platformTrueCourse = platformTrueCourse;
    }

    public double getPlatformTrueHeading() {
        return platformTrueHeading;
    }

    public double getPlatformTrueHeadingDegrees() {
        return radiansToDegrees(getPlatformTrueHeading());
    }

    public void setPlatformTrueHeading(double platformTrueHeading) {
        this.platformTrueHeading = platformTrueHeading;
    }

    public double getPlatformPitch() {
        return platformPitch;
    }

    public double getPlatformPitchDegrees() {
        return radiansToDegrees(getPlatformPitch());
    }

    public void setPlatformPitch(double platformPitch) {
        this.platformPitch = platformPitch;
    }

    public double getPlatformRoll() {
        return platformRoll;
    }

    public double getPlatformRollDegrees() {
        return radiansToDegrees(getPlatformRoll());
    }

    public void setPlatformRoll(double platformRoll) {
        this.platformRoll = platformRoll;
    }

    public double getPlatformYaw() {
        return platformYaw;
    }

    public double getPlatformYawDegrees() {
        return radiansToDegrees(getPlatformYaw());
    }

    public void setPlatformYaw(double platformYaw) {
        this.platformYaw = platformYaw;
    }

    public double getPlatformVelocityNorth() {
        return platformVelocityNorth;
    }

    public void setPlatformVelocityNorth(double platformVelocityNorth) {
        this.platformVelocityNorth = platformVelocityNorth;
    }

    public double getPlatformVelocityEast() {
        return platformVelocityEast;
    }

    public void setPlatformVelocityEast(double platformVelocityEast) {
        this.platformVelocityEast = platformVelocityEast;
    }

    public double getPlatformVelocityDown() {
        return platformVelocityDown;
    }

    public void setPlatformVelocityDown(double platformVelocityDown) {
        this.platformVelocityDown = platformVelocityDown;
    }

    public double getPlatformAccelerationNorth() {
        return platformAccelerationNorth;
    }

    public void setPlatformAccelerationNorth(double platformAccelerationNorth) {
        this.platformAccelerationNorth = platformAccelerationNorth;
    }

    public double getPlatformAccelerationEast() {
        return platformAccelerationEast;
    }

    public void setPlatformAccelerationEast(double platformAccelerationEast) {
        this.platformAccelerationEast = platformAccelerationEast;
    }

    public double getPlatformAccelerationDown() {
        return platformAccelerationDown;
    }

    public void setPlatformAccelerationDown(double platformAccelerationDown) {
        this.platformAccelerationDown = platformAccelerationDown;
    }

    public double getPlatformHeadingRate() {
        return platformHeadingRate;
    }

    public double getPlatformHeadingRateDegrees() {
        return radiansToDegrees(getPlatformHeadingRate());
    }

    public void setPlatformHeadingRate(double platformHeadingRate) {
        this.platformHeadingRate = platformHeadingRate;
    }

    public double getPlatformPitchRate() {
        return platformPitchRate;
    }

    public double getPlatformPitchRateDegrees() {
        return radiansToDegrees(getPlatformPitchRate());
    }

    public void setPlatformPitchRate(double platformPitchRate) {
        this.platformPitchRate = platformPitchRate;
    }

    public double getPlatformRollRate() {
        return platformRollRate;
    }

    public double getPlatformRollRateDegrees() {
        return radiansToDegrees(getPlatformRollRate());
    }

    public void setPlatformRollRate(double platformRollRate) {
        this.platformRollRate = platformRollRate;
    }

    public double getPlatformYawRate() {
        return platformYawRate;
    }

    public double getPlatformYawRateDegrees() {
        return radiansToDegrees(getPlatformYawRate());
    }

    public void setPlatformYawRate(double platformYawRate) {
        this.platformYawRate = platformYawRate;
    }

    public double getPlatformHeadingAngularAcceleration() {
        return platformHeadingAngularAcceleration;
    }

    public double getPlatformHeadingAngularAccelerationDegrees() {
        return radiansToDegrees(getPlatformHeadingAngularAcceleration());
    }

    public void setPlatformHeadingAngularAcceleration(double platformHeadingAngularAcceleration) {
        this.platformHeadingAngularAcceleration = platformHeadingAngularAcceleration;
    }

    public double getPlatformPitchAngularAcceleration() {
        return platformPitchAngularAcceleration;
    }

    public double getPlatformPitchAngularAccelerationDegrees() {
        return radiansToDegrees(getPlatformPitchAngularAcceleration());
    }

    public void setPlatformPitchAngularAcceleration(double platformPitchAngularAcceleration) {
        this.platformPitchAngularAcceleration = platformPitchAngularAcceleration;
    }

    public double getPlatformRollAngularAcceleration() {
        return platformRollAngularAcceleration;
    }

    public double getPlatformRollAngularAccelerationDegrees() {
        return radiansToDegrees(getPlatformRollAngularAcceleration());
    }

    public void setPlatformRollAngularAcceleration(double platformRollAngularAcceleration) {
        this.platformRollAngularAcceleration = platformRollAngularAcceleration;
    }

    public double getPlatformYawAngularAcceleration() {
        return platformYawAngularAcceleration;
    }

    public double getPlatformYawAngularAccelerationDegrees() {
        return radiansToDegrees(getPlatformYawAngularAcceleration());
    }

    public void setPlatformYawAngularAcceleration(double platformYawAngularAcceleration) {
        this.platformYawAngularAcceleration = platformYawAngularAcceleration;
    }

    public double getVelocityToHeightRatio() {
        return velocityToHeightRatio;
    }

    public void setVelocityToHeightRatio(double velocityToHeightRatio) {
        this.velocityToHeightRatio = velocityToHeightRatio;
    }

    public int getNavigationalConfidence() {
        return navigationalConfidence;
    }

    public void setNavigationalConfidence(int navigationalConfidence) {
        this.navigationalConfidence = navigationalConfidence;
    }

    public int getPlatformId() {
        return (getHeader().getDataFileAddress() & 0x00FF0000) >> 16;
    }
}
