package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
*/
public class IsarTrackDataTable extends DataTable {
    private double roadCurvature;
    private double radialSpeedOfVehicle;
    private int trackID;
    private int trackType;
    private int directionOfRoadCurvature;
    private int directionOfVehicleRadial;
}
