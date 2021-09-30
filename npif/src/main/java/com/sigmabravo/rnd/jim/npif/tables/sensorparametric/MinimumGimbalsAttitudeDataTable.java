package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	File Addressing scheme is $0000 006x where x represents the gimbal ID.
	Table Requirement         :        Conditional that the Comprehensive Gimbals Attitude Data Table is not sent
	The order of rotation of the gimbals is in the order of the fields, i.e. Z-axis, Y-axis, X-axis.
	For positive direction of rotation, refer to section 7.2.3 figure 15.
	The sensor is attached to the last gimbal (if gimbals are used) and will have its own attitude data in the Sensor Attitude Data Tables.
*/
public class MinimumGimbalsAttitudeDataTable extends DataTable {
    private double rotationAboutZAxis;
    private double rotationAboutYAxis;
    private double rotationAboutXAxis;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getGimbalId() {
        return (getHeader().getDataFileAddress() & 0x0F);
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
