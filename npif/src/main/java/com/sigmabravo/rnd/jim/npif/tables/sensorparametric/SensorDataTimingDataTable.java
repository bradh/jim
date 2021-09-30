package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	A-10        Sensor Compression Tables
*/
public class SensorDataTimingDataTable extends DataTable {
    private double framePeriod;
    private double intraFrameTime;
    private double linePeriod;
    private double intraLineTime;
}
