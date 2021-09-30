package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	Table Requirement       :       Conditional on the Minimum Sensor Attitude Data Table not sent
	The order of rotation of the sensor is in the order of the fields, i.e. Z-axis, Y-axis, X-axis. For positive direction of rotation, refer to section 7.2.3 figure 15.
*/
public class ComprehensiveSensorAttitudeDataTable extends DataTable {
    private double rotationAboutZAxis;
    private double rotationAboutYAxis;
    private double rotationAboutXAxis;
    private double rotationRateAboutZAxis;
    private double rotationRateAboutYAxis;
    private double rotationRateAboutXAxis;
    private double rotationAccelerationAboutZAxis;
    private double rotationAccelerationAboutYAxis;
    private double rotationAccelerationAboutXAxis;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getRotationAboutZAxis() {
        return rotationAboutZAxis;
    }

    public double getRotationAboutZAxisDegrees() {
        return radiansToDegrees(getRotationAboutZAxis());
    }

    public void setRotationAboutZAxis(double rotationAboutZAxis) {
        this.rotationAboutZAxis = rotationAboutZAxis;
    }

    public double getRotationAboutYAxis() {
        return rotationAboutYAxis;
    }

    public double getRotationAboutYAxisDegrees() {
        return radiansToDegrees(getRotationAboutYAxis());
    }

    public void setRotationAboutYAxis(double rotationAboutYAxis) {
        this.rotationAboutYAxis = rotationAboutYAxis;
    }

    public double getRotationAboutXAxis() {
        return rotationAboutXAxis;
    }

    public double getRotationAboutXAxisDegrees() {
        return radiansToDegrees(getRotationAboutXAxis());
    }

    public void setRotationAboutXAxis(double rotationAboutXAxis) {
        this.rotationAboutXAxis = rotationAboutXAxis;
    }

    public double getRotationRateAboutZAxis() {
        return rotationRateAboutZAxis;
    }

    public double getRotationRateAboutZAxisDegrees() {
        return radiansToDegrees(getRotationRateAboutZAxis());
    }

    public void setRotationRateAboutZAxis(double rotationRateAboutZAxis) {
        this.rotationRateAboutZAxis = rotationRateAboutZAxis;
    }

    public double getRotationRateAboutYAxis() {
        return rotationRateAboutYAxis;
    }

    public double getRotationRateAboutYAxisDegrees() {
        return radiansToDegrees(getRotationRateAboutYAxis());
    }

    public void setRotationRateAboutYAxis(double rotationRateAboutYAxis) {
        this.rotationRateAboutYAxis = rotationRateAboutYAxis;
    }

    public double getRotationRateAboutXAxis() {
        return rotationRateAboutXAxis;
    }

    public double getRotationRateAboutXAxisDegrees() {
        return radiansToDegrees(getRotationRateAboutXAxis());
    }

    public void setRotationRateAboutXAxis(double rotationRateAboutXAxis) {
        this.rotationRateAboutXAxis = rotationRateAboutXAxis;
    }

    public double getRotationAccelerationAboutZAxis() {
        return rotationAccelerationAboutZAxis;
    }

    public double getRotationAccelerationAboutZAxisDegrees() {
        return radiansToDegrees(getRotationAccelerationAboutZAxis());
    }

    public void setRotationAccelerationAboutZAxis(double rotationAccelerationAboutZAxis) {
        this.rotationAccelerationAboutZAxis = rotationAccelerationAboutZAxis;
    }

    public double getRotationAccelerationAboutYAxis() {
        return rotationAccelerationAboutYAxis;
    }

    public double getRotationAccelerationAboutYAxisDegrees() {
        return radiansToDegrees(getRotationAccelerationAboutYAxis());
    }

    public void setRotationAccelerationAboutYAxis(double rotationAccelerationAboutYAxis) {
        this.rotationAccelerationAboutYAxis = rotationAccelerationAboutYAxis;
    }

    public double getRotationAccelerationAboutXAxis() {
        return rotationAccelerationAboutXAxis;
    }

    public double getRotationAccelerationAboutXAxisDegrees() {
        return radiansToDegrees(getRotationAccelerationAboutXAxis());
    }

    public void setRotationAccelerationAboutXAxis(double rotationAccelerationAboutXAxis) {
        this.rotationAccelerationAboutXAxis = rotationAccelerationAboutXAxis;
    }
}
