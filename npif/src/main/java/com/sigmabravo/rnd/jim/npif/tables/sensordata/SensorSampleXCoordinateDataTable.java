package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.util.Arrays;

/*
	This table is used to describe the pixel registration of the sensor data.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
	This table is used for the sensor modelling method VECTOR MODELLING. It is used in conjunction with the Sensor Sample Coordinate Description Data Table.
	The data file size must be a multiple of whole bytes. Any padding will be in the last byte and from the LSB towards the MSB.
*/
public class SensorSampleXCoordinateDataTable extends DataTable {
    private byte[] sampleXCoordinate;

    public byte[] getSampleXCoordinate() {
        return Arrays.copyOf(sampleXCoordinate, sampleXCoordinate.length);
    }

    public void setSampleXCoordinate(byte[] sampleXCoordinate) {
        this.sampleXCoordinate = Arrays.copyOf(sampleXCoordinate, sampleXCoordinate.length);
    }
}
