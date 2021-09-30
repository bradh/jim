package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import java.util.Arrays;

/*
	This table is used to describe the pixel registration of the sensor data.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
	The data file size must be a multiple of whole bytes. Any padding will be in the last byte and from the LSB towards the MSB.
*/
public class SensorSampleZCoordinateDataTable extends AbstractSensorDataTable {
    private byte[] sampleZCoordinate;

    public byte[] getSampleZCoordinate() {
        return Arrays.copyOf(sampleZCoordinate, sampleZCoordinate.length);
    }

    public void setSampleZCoordinate(byte[] sampleZCoordinate) {
        this.sampleZCoordinate = Arrays.copyOf(sampleZCoordinate, sampleZCoordinate.length);
    }
}
