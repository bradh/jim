package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class ISARTrackDataTable extends DataTable {
    private double roadCurvature;
    private double radialSpeedOfVehicle;
    private int trackID;
    private int trackType;
    private int directionOfRoadCurvature;
    private int directionOfVehicleRadialVelocity;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getRoadCurvature() {
        return roadCurvature;
    }

    public void setRoadCurvature(double roadCurvature) {
        this.roadCurvature = roadCurvature;
    }

    public double getRadialSpeedOfVehicle() {
        return radialSpeedOfVehicle;
    }

    public void setRadialSpeedOfVehicle(double radialSpeedOfVehicle) {
        this.radialSpeedOfVehicle = radialSpeedOfVehicle;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public int getTrackType() {
        return trackType;
    }

    public String getTrackTypeAsText() {
        switch (getTrackType()) {
            case 0x00:
                return "Unused";
            case 0x01:
                return "Link 16";
            case 0x02:
                return "NATO Track number (NTN)";
            default:
                return "Unknown track type (" + getTrackType() + ")";
        }
    }

    public void setTrackType(int trackType) {
        this.trackType = trackType;
    }

    public int getDirectionOfRoadCurvature() {
        return directionOfRoadCurvature;
    }

    public String getDirectionOfRoadCurvatureAsText() {
        switch (getDirectionOfRoadCurvature()) {
            case 0x00:
                return "Unused";
            case 0x01:
                return "Clockwise";
            case 0x02:
                return "Anti-clockwise";
            default:
                return "Unknown direction of road curvature ("
                        + getDirectionOfRoadCurvature()
                        + ")";
        }
    }

    public void setDirectionOfRoadCurvature(int directionOfRoadCurvature) {
        this.directionOfRoadCurvature = directionOfRoadCurvature;
    }

    public int getDirectionOfVehicleRadialVelocity() {
        return directionOfVehicleRadialVelocity;
    }

    public String getDirectionOfVehicleRadialVelocityAsText() {
        switch (getDirectionOfVehicleRadialVelocity()) {
            case 0x00:
                return "Unused";
            case 0x01:
                return "Away from the sensor";
            case 0x02:
                return "Towards the sensor";
            default:
                return "Unknown direction of vehicle radial velocity ("
                        + getDirectionOfVehicleRadialVelocity()
                        + ")";
        }
    }

    public void setDirectionOfVehicleRadialVelocity(int directionOfVehicleRadialVelocity) {
        this.directionOfVehicleRadialVelocity = directionOfVehicleRadialVelocity;
    }
}
