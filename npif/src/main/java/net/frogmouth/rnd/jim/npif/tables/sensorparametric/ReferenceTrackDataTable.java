package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Position;

public class ReferenceTrackDataTable extends DataTable {
    private Position sensorVirtualPositionGeoLocation;
    private double sensorVirtualPositionMSLAltitude;
    private double sensorVirtualPositionAGLAltitude;
    private double sensorVirtualPositionGPSAltitude;
    private double referenceTrackNorth;
    private double referenceTrackEast;
    private double referenceTrackDown;
    private double referenceTrackSpeed;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public Position getSensorVirtualPositionGeoLocation() {
        return new Position(sensorVirtualPositionGeoLocation);
    }

    public void setSensorVirtualPositionGeoLocation(Position sensorVirtualPositionGeoLocation) {
        this.sensorVirtualPositionGeoLocation = new Position(sensorVirtualPositionGeoLocation);
    }

    public double getSensorVirtualPositionMSLAltitude() {
        return sensorVirtualPositionMSLAltitude;
    }

    public void setSensorVirtualPositionMSLAltitude(double sensorVirtualPositionMSLAltitude) {
        this.sensorVirtualPositionMSLAltitude = sensorVirtualPositionMSLAltitude;
    }

    public double getSensorVirtualPositionAGLAltitude() {
        return sensorVirtualPositionAGLAltitude;
    }

    public void setSensorVirtualPositionAGLAltitude(double sensorVirtualPositionAGLAltitude) {
        this.sensorVirtualPositionAGLAltitude = sensorVirtualPositionAGLAltitude;
    }

    public double getSensorVirtualPositionGPSAltitude() {
        return sensorVirtualPositionGPSAltitude;
    }

    public void setSensorVirtualPositionGPSAltitude(double sensorVirtualPositionGPSAltitude) {
        this.sensorVirtualPositionGPSAltitude = sensorVirtualPositionGPSAltitude;
    }

    public double getReferenceTrackNorth() {
        return referenceTrackNorth;
    }

    public void setReferenceTrackNorth(double referenceTrackNorth) {
        this.referenceTrackNorth = referenceTrackNorth;
    }

    public double getReferenceTrackEast() {
        return referenceTrackEast;
    }

    public void setReferenceTrackEast(double referenceTrackEast) {
        this.referenceTrackEast = referenceTrackEast;
    }

    public double getReferenceTrackDown() {
        return referenceTrackDown;
    }

    public void setReferenceTrackDown(double referenceTrackDown) {
        this.referenceTrackDown = referenceTrackDown;
    }

    public double getReferenceTrackSpeed() {
        return referenceTrackSpeed;
    }

    public void setReferenceTrackSpeed(double referenceTrackSpeed) {
        this.referenceTrackSpeed = referenceTrackSpeed;
    }
}
