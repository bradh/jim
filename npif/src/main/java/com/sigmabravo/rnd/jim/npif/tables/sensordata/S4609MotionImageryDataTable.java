package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.util.Arrays;

/*
	This table is used to incorporate 4609 Motion Imagery data.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
*/
public class S4609MotionImageryDataTable extends DataTable {
    private byte[] data;

    public byte[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public void setData(byte[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }
}
