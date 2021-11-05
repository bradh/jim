package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
    The sensor is attached to the last gimbal (if gimbals are used) and will have its own position data in the Sensor Position Data Table.
*/
public class GimbalsPositionDataTable extends DataTable {
    private double xVectorComponent;
    private double yVectorComponent;
    private double zVectorComponent;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getGimbalId() {
        return (getHeader().getDataFileAddress() & 0x0F);
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
