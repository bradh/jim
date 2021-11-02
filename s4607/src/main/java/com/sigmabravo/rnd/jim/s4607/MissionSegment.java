package com.sigmabravo.rnd.jim.s4607;

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
