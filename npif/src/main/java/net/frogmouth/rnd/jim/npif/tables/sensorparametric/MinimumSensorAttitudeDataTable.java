package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	able Requirement         :        Conditional on the Comprehensive Sensor Attitude Data Table not sent.
	The order of rotation of the sensor is in the order of the fields, i.e. Z-axis, Y-axis, X-axis.
	For positive direction of rotation, refer to section 7.2.3 figure 15.
*/
public class MinimumSensorAttitudeDataTable extends DataTable {
    private double rotationAboutZAxis;
    private double rotationAboutYAxis;
    private double rotationAboutXAxis;

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
}
