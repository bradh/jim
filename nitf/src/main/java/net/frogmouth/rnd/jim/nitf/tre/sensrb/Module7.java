package net.frogmouth.rnd.jim.nitf.tre.sensrb;

// TODO: this might be better with some subclasses

import java.io.ByteArrayOutputStream;

public class Module7 {
    private int sensorAngleModel;
    private double sensorAngle1;
    private double sensorAngle2;
    private double sensorAngle3;
    private String platformRelative;
    private String platformHeading;
    private String platformPitch;
    private String platformRoll;

    public Module7() {}

    public Module7(Module7 other) {
        this.sensorAngleModel = other.sensorAngleModel;
        this.sensorAngle1 = other.sensorAngle1;
        this.sensorAngle2 = other.sensorAngle2;
        this.sensorAngle3 = other.sensorAngle3;
        this.platformRelative = other.platformRelative;
        this.platformHeading = other.platformHeading;
        this.platformPitch = other.platformPitch;
        this.platformRoll = other.platformRoll;
    }

    public int getSensorAngleModel() {
        return sensorAngleModel;
    }

    public void setSensorAngleModel(int sensorAngleModel) {
        this.sensorAngleModel = sensorAngleModel;
    }

    public double getSensorAngle1() {
        return sensorAngle1;
    }

    public void setSensorAngle1(double sensorAngle1) {
        this.sensorAngle1 = sensorAngle1;
    }

    public double getSensorAngle2() {
        return sensorAngle2;
    }

    public void setSensorAngle2(double sensorAngle2) {
        this.sensorAngle2 = sensorAngle2;
    }

    public double getSensorAngle3() {
        return sensorAngle3;
    }

    public void setSensorAngle3(double sensorAngle3) {
        this.sensorAngle3 = sensorAngle3;
    }

    public String getPlatformRelative() {
        return platformRelative;
    }

    public void setPlatformRelative(String platformRelative) {
        this.platformRelative = platformRelative;
    }

    public String getPlatformHeading() {
        return platformHeading;
    }

    public void setPlatformHeading(String platformHeading) {
        this.platformHeading = platformHeading;
    }

    public String getPlatformPitch() {
        return platformPitch;
    }

    public void setPlatformPitch(String platformPitch) {
        this.platformPitch = platformPitch;
    }

    public String getPlatformRoll() {
        return platformRoll;
    }

    public void setPlatformRoll(String platformRoll) {
        this.platformRoll = platformRoll;
    }

    void appendBytes(ByteArrayOutputStream baos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
