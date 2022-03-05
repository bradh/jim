package net.frogmouth.rnd.jim.s4607.mission;

import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Mission Segment.
 *
 * <p>The Mission Segment provides information concerning the mission and shall be sent periodically
 * at least once every two minutes. It includes information on the mission and flight plans, the
 * type and configuration of the platform, and the reference time.
 *
 * <p>Note that the Dwell Time (field D6) specified in any associated Dwell Segments is referenced
 * to the Reference Time (fields M5-M7) in the Mission Segment, and will not be resolved as to the
 * day of the mission until the Mission Segment is received from the transmitting platform.
 *
 * <p>All fields are mandatory in the Mission Segment.
 */
public class MissionSegment extends Segment {
    private String missionPlan;
    private String flightPlan;
    private int platformType;
    private String platformConfiguration;
    private int year;
    private int month;
    private int day;

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.MissionSegment;
    }

    /**
     * Mission Plan (M1).
     *
     * <p>An alphanumeric field that identifies the mission, and which shall be unique for all the
     * missions defined for that platform. For aircraft or land-based systems, the Mission Number
     * from the Air Tasking Order (ATO) or an equivalent document shall be used. For space-based
     * platforms, the mission identifier or a suitable designator such as “yymmhhnn”, where yy
     * (year), mm (month), and hh (hour) indicate the time the collection mission began and nn is
     * the identifying number of the satellite, shall be used.
     *
     * <p>If there is no Mission Plan, or there are unused bytes in the field, the field shall be
     * filled with the BCS space character (hex 0x20). You may wish to call {@code trim()} on the
     * returned value.
     *
     * @return the mission plan as a string value.
     */
    public String getMissionPlan() {
        return missionPlan;
    }

    /**
     * Set the Mission Plan (M1).
     *
     * <p>An alphanumeric field that identifies the mission, and which shall be unique for all the
     * missions defined for that platform. For aircraft or land-based systems, the Mission Number
     * from the Air Tasking Order (ATO) or an equivalent document shall be used. For space-based
     * platforms, the mission identifier or a suitable designator such as “yymmhhnn”, where yy
     * (year), mm (month), and hh (hour) indicate the time the collection mission began and nn is
     * the identifying number of the satellite, shall be used.
     *
     * <p>If there is no Mission Plan, or there are unused bytes in the field, the field shall be
     * filled with the BCS space character (hex 0x20).
     *
     * @param missionPlan the mission plan - 12 bytes maximum.
     */
    public void setMissionPlan(String missionPlan) {
        validateBCS(missionPlan, 12);
        this.missionPlan = missionPlan;
    }

    /**
     * Flight Plan (M2).
     *
     * <p>An alphanumeric field that identifies the flight plan. This field provides a unique
     * identification of the flight plan. If the flight plan is not available from the ATO or an
     * equivalent source, a suitable unique identifier may be inserted in this field. If there is no
     * Flight Plan to be sent, or if there are unused bytes in the field, the field shall be filled
     * with the BCS space character (hex 0x20).
     *
     * @return the flight plan as a string value.
     */
    public String getFlightPlan() {
        return flightPlan;
    }

    /**
     * Set the Flight Plan (M2).
     *
     * <p>An alphanumeric field that identifies the flight plan. This field provides a unique
     * identification of the flight plan. If the flight plan is not available from the ATO or an
     * equivalent source, a suitable unique identifier may be inserted in this field. If there is no
     * Flight Plan to be sent, or if there are unused bytes in the field, the field shall be filled
     * with the BCS space character (hex 0x20).
     *
     * @param flightPlan the flight plan - 12 bytes maximum.
     */
    public void setFlightPlan(String flightPlan) {
        validateBCS(flightPlan, 12);
        this.flightPlan = flightPlan;
    }

    /**
     * Platform Type (M3).
     *
     * <p>An enumeration value that identifies the type of platform that originated the data.
     *
     * <p>See {@link PlatformTypeLookupTable} for relevant values.
     *
     * @return the platform type as an enumeration index.
     */
    public int getPlatformType() {
        return platformType;
    }

    /**
     * Platform Type (M3).
     *
     * <p>An enumeration value that identifies the type of platform that originated the data.
     *
     * <p>See {@link PlatformTypeLookupTable} for relevant values.
     *
     * @return the platform type as a text value.
     */
    public String getPlatformTypeAsText() {
        return PlatformTypeLookupTable.getValue(platformType);
    }

    /**
     * Set the Platform Type (M3).
     *
     * <p>An enumeration value that identifies the type of platform that originated the data.
     *
     * <p>See {@link PlatformTypeLookupTable} for relevant values.
     *
     * @param platformType the platform type as an enumeration index.
     */
    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }

    /**
     * Platform Configuration (M4).
     *
     * <p>An alphanumeric field indicating the particular variant of the platform. Identifies sensor
     * complements, upgrades, or other identifying information. Examples would be a model number,
     * software release number, clarifications of differences in platform types, or identification
     * of the platform as a test article. A recommended default value is an identification of the
     * software and/or hardware version. If there is no Platform Configuration to be sent, the
     * fields shall be filled with the BCS space character (hex 0x20).
     *
     * @return the platform configuration as a short string.
     */
    public String getPlatformConfiguration() {
        return platformConfiguration;
    }

    /**
     * Set the Platform Configuration (M4).
     *
     * <p>An alphanumeric field indicating the particular variant of the platform. Identifies sensor
     * complements, upgrades, or other identifying information. Examples would be a model number,
     * software release number, clarifications of differences in platform types, or identification
     * of the platform as a test article. A recommended default value is an identification of the
     * software and/or hardware version. If there is no Platform Configuration to be sent, the
     * fields shall be filled with the BCS space character (hex 0x20).
     *
     * @param platformConfiguration the platform configuration - 10 bytes maximum.
     */
    public void setPlatformConfiguration(String platformConfiguration) {
        validateBCS(platformConfiguration, 10);
        this.platformConfiguration = platformConfiguration;
    }

    /**
     * Reference Time – Year (M5).
     *
     * <p>The year in which the mission originated. For airborne platforms, this shall be the
     * takeoff time. For spaceborne platforms, this shall be an epoch time, which shall be selected
     * suitable for the collection. For ground-based platforms, a time reference suitable for
     * collection shall be selected.
     *
     * @return the year as an integer value (Gregorian calendar)
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the Reference Time – Year (M5).
     *
     * <p>The year in which the mission originated. For airborne platforms, this shall be the
     * takeoff time. For spaceborne platforms, this shall be an epoch time, which shall be selected
     * suitable for the collection. For ground-based platforms, a time reference suitable for
     * collection shall be selected.
     *
     * @param year the year as an integer value (Gregorian calendar)
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Reference Time – Month (M6). The month of the year in which the mission originated. For
     * airborne platforms, this shall be the takeoff time. For spaceborne platforms, this shall be
     * an epoch time, which shall be selected suitable for the collection. For ground-based
     * platforms, a time reference suitable for collection shall be selected.
     *
     * @return the month as an integer value (in the range 1 to 12).
     */
    public int getMonth() {
        return month;
    }

    /**
     * Set the Reference Time – Month (M6). The month of the year in which the mission originated.
     * For airborne platforms, this shall be the takeoff time. For spaceborne platforms, this shall
     * be an epoch time, which shall be selected suitable for the collection. For ground-based
     * platforms, a time reference suitable for collection shall be selected.
     *
     * @param month the month as an integer value (in the range 1 to 12).
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Reference Time – Day (M7). The day of the month in which the mission originated, UTC. For
     * airborne platforms, this shall be the day of takeoff. For satellite platforms, this shall be
     * an epoch time, which shall be selected suitable for the collection. For ground-based
     * platforms, a time reference suitable for collection shall be selected.
     *
     * @return the day of the month (in the range 1 to 31).
     */
    public int getDay() {
        return day;
    }

    /**
     * Set the Reference Time – Day (M7). The day of the month in which the mission originated, UTC.
     * For airborne platforms, this shall be the day of takeoff. For satellite platforms, this shall
     * be an epoch time, which shall be selected suitable for the collection. For ground-based
     * platforms, a time reference suitable for collection shall be selected.
     *
     * @param day the day of the month (in the range 1 to 31).
     */
    public void setDay(int day) {
        this.day = day;
    }
}
