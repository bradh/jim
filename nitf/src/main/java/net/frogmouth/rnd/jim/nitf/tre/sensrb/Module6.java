package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.io.ByteArrayOutputStream;

public class Module6 {
    private double latitude_or_x;
    private double longitude_or_y;
    private double altitude_or_z;
    private double sensorOffsetX;
    private double sensorOffsetY;
    private double sensorOffsetZ;

    public Module6() {}

    public Module6(Module6 other) {
        this.latitude_or_x = other.latitude_or_x;
        this.longitude_or_y = other.longitude_or_y;
        this.altitude_or_z = other.altitude_or_z;
        this.sensorOffsetX = other.sensorOffsetX;
        this.sensorOffsetY = other.sensorOffsetY;
        this.sensorOffsetZ = other.sensorOffsetZ;
    }

    public double getLatitude_or_x() {
        return latitude_or_x;
    }

    public void setLatitude_or_x(double latitude_or_x) {
        this.latitude_or_x = latitude_or_x;
    }

    public double getLongitude_or_y() {
        return longitude_or_y;
    }

    public void setLongitude_or_y(double longitude_or_y) {
        this.longitude_or_y = longitude_or_y;
    }

    public double getAltitude_or_z() {
        return altitude_or_z;
    }

    public void setAltitude_or_z(double altitude_or_z) {
        this.altitude_or_z = altitude_or_z;
    }

    public double getSensorOffsetX() {
        return sensorOffsetX;
    }

    public void setSensorOffsetX(double sensorOffsetX) {
        this.sensorOffsetX = sensorOffsetX;
    }

    public double getSensorOffsetY() {
        return sensorOffsetY;
    }

    public void setSensorOffsetY(double sensorOffsetY) {
        this.sensorOffsetY = sensorOffsetY;
    }

    public double getSensorOffsetZ() {
        return sensorOffsetZ;
    }

    public void setSensorOffsetZ(double sensorOffsetZ) {
        this.sensorOffsetZ = sensorOffsetZ;
    }

    void appendBytes(ByteArrayOutputStream baos) {
        // TODO: need proper writer support
    }
}
