package com.sigmabravo.rnd.jim.npif.tables.platform;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZonedDateTime;

/*
	File Addressing scheme is $00xx 0000 where xx represents the Platform ID, and Platform ID = $00 is reserved for the aircraft platform data.
	Table Requirement         : Conditional on the Comprehensive Dynamic Platform Data Table not sent
	Order of Navigational Confidence 2-bit codes:
	MSByte                                                           LSByte
	F12      F11  F10        F9       F8      F7      F6      F5      F4      F3    F2         F1
	Where Fn is a 2-bit code for field number n, as defined above. E.g. F1 is a 2-bit code that gives the navigational confidence of the field 1 the Platform Time, F2 is a
	2-bit code which gives the navigational confidence of the field 2 the Platform Geo-Location.
*/
public class MinimumDynamicPlatformDataTable extends DataTable {
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

    public int getNavigationalConfidence() {
        return navigationalConfidence;
    }

    public void setNavigationalConfidence(int navigationalConfidence) {
        this.navigationalConfidence = navigationalConfidence;
    }
}
