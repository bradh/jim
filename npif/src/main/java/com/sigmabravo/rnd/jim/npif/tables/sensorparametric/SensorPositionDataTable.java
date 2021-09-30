package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	This table describes the position of the centre of the sensor relative to the last gimbal position. If gimbals are not used then this table gives the position of the centre
	of the sensor relative to the aircraft coordinate system.
*/
public class SensorPositionDataTable extends DataTable {
    private double xVectorComponent;
    private double yVectorComponent;
    private double zVectorComponent;
}
