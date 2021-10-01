package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	This table describes the position of the centre of the sensor relative to the last gimbal position. If gimbals are not used then this table gives the position of the centre
	of the sensor relative to the aircraft coordinate system.
*/
public class SensorPositionDataTable extends DataTable {
    private double xVectorComponent;
    private double yVectorComponent;
    private double zVectorComponent;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getxVectorComponent() {
        return xVectorComponent;
    }

    public void setxVectorComponent(double xVectorComponent) {
        this.xVectorComponent = xVectorComponent;
    }

    public double getyVectorComponent() {
        return yVectorComponent;
    }

    public void setyVectorComponent(double yVectorComponent) {
        this.yVectorComponent = yVectorComponent;
    }

    public double getzVectorComponent() {
        return zVectorComponent;
    }

    public void setzVectorComponent(double zVectorComponent) {
        this.zVectorComponent = zVectorComponent;
    }
}
