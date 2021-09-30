package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import java.util.Arrays;

/*
	This table is used to incorporate 4609 Motion Imagery data.
*/
public class S4609MotionImageryDataTable extends AbstractSensorDataTable {
    private byte[] data;

    public byte[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public void setData(byte[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }
}
