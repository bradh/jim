package net.frogmouth.rnd.jim.s4607.MissionSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;

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
 */
public class MissionSegment extends Segment {
    private String missionPlan;
    private String flightPlan;
    private int platformType;
    private String platformConfiguration;
    private int year;
    private int month;
    private int day;

    public MissionSegment(SegmentHeader header) {
        super(header);
    }

    /**
     * Mission Plan (M1) (M).
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

    public void setMissionPlan(String missionPlan) {
        this.missionPlan = missionPlan;
    }

    public String getFlightPlan() {
        return flightPlan;
    }

    public void setFlightPlan(String flightPlan) {
        this.flightPlan = flightPlan;
    }

    public int getPlatformType() {
        return platformType;
    }

    public String getPlatformTypeAsText() {
        return PlatformTypeLookupTable.getValue(platformType);
    }

    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }

    public String getPlatformConfiguration() {
        return platformConfiguration;
    }

    public void setPlatformConfiguration(String platformConfiguration) {
        this.platformConfiguration = platformConfiguration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
