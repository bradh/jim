package net.frogmouth.rnd.jim.npif.tables.sensordata;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	This table is used to incorporate Range Finder data.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
*/
public class RangeFinderDataTable extends DataTable {
    private double range;

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getSensorId() {
        return ((getHeader().getSourceAddress() & 0xFF) - 0x80);
    }
}
