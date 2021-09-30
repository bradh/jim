package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	File Addressing scheme is $0000 005x where x represents the gimbal ID.
	The sensor is attached to the last gimbal (if gimbals are used) and will have its own position data in the Sensor Position Data Table.
*/
public class GimbalsPositionDataTable extends DataTable {
    private double xVectorComponent;
    private double yVectorComponent;
    private double zVectorComponent;
}
