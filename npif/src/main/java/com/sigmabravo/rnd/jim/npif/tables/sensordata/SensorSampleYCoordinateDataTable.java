package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import java.util.Arrays;

/*
	This table is used to describe the pixel registration of the sensor data.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
*/
public class SensorSampleYCoordinateDataTable extends AbstractSensorDataTable {
    private byte[] sampleYCoordinate;

    public byte[] getSampleYCoordinate() {
        return Arrays.copyOf(sampleYCoordinate, sampleYCoordinate.length);
    }

    public void setSampleYCoordinate(byte[] sampleYCoordinate) {
        this.sampleYCoordinate = Arrays.copyOf(sampleYCoordinate, sampleYCoordinate.length);
    }
}
