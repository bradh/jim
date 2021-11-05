package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class SensorDataTimingDataTable extends DataTable {
    private double framePeriod;
    private double intraFrameTime;
    private double linePeriod;
    private double intraLineTime;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getFramePeriod() {
        return framePeriod;
    }

    public void setFramePeriod(double framePeriod) {
        this.framePeriod = framePeriod;
    }

    public double getIntraFrameTime() {
        return intraFrameTime;
    }

    public void setIntraFrameTime(double intraFrameTime) {
        this.intraFrameTime = intraFrameTime;
    }

    public double getLinePeriod() {
        return linePeriod;
    }

    public void setLinePeriod(double linePeriod) {
        this.linePeriod = linePeriod;
    }

    public double getIntraLineTime() {
        return intraLineTime;
    }

    public void setIntraLineTime(double intraLineTime) {
        this.intraLineTime = intraLineTime;
    }
}
