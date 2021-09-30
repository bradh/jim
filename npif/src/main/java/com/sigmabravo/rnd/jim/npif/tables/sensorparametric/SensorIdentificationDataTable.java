package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	The Platform ID (to be associated with the sensor number) is encoded in the upper bytes of the File Address, i.e. $00xx 0000.
	File Address $0000 0000 is by default associated with the Aircraft Platform ID. Values $0001 0000 to $0040 0000 are available for 64 Platform IDs. Each sensor can
	associate itself with any Platform ID.
	If the Sensor Modelling Method is VECTOR MODELLING then the following tables are to be used:
	Sensor sample “x” coordinate data table
	Sensor sample “y” coordinate data table
	Sensor sample “z” coordinate data table
*/
public class SensorIdentificationDataTable extends DataTable {
    private int sensorType;
    private String sensorSerialNumber;
    private String sensorModelNumber;
    private int sensorModellingMethod;
    private int numberOfGimbals;
}
