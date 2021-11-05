package net.frogmouth.rnd.jim.npif.tables.sensordata;

import java.util.Arrays;

/*
	This table is used to describe the timing of the sensor data samples.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 10xxxxxx, where xxxxxx is the sensor number.
	This table is used in conjunction with the Sensor Sample Timing Description Data Table.
	Differential timing
	Sample        Sample       Sample    Sample          Sample       Sample        Sample
	3           2            1.5           1            1.5         2             3
	0             3            5            6.5        7.5            9            11            14
	Time (ms)
	Cumulative timing
	Exampleof
	Example  of Sample
	Sample Timing
	Timingmethods
	methods
	Regardless of data ordering (BIP, BSQ, BIL) sample timing shall express the timing relationship of adjacent samples of the same element.
*/
public class SensorSampleTimingDataTable extends AbstractSensorDataTable {
    private byte[] sampleTiming;

    public byte[] getSampleTiming() {
        return Arrays.copyOf(sampleTiming, sampleTiming.length);
    }

    public void setSampleTiming(byte[] sampleTiming) {
        this.sampleTiming = Arrays.copyOf(sampleTiming, sampleTiming.length);
        ;
    }
}
