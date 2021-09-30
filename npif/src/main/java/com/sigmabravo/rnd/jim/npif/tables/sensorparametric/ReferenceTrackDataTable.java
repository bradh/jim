package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
*/
public class ReferenceTrackDataTable extends DataTable {
    private Position sensorVirtualPositionGeoLocation;
    private double sensorVirtualPositionMSLAltitude;
    private double sensorVirtualPositionAGLAltitude;
    private double sensorVirtualPositionGPSAltitude;
    private double referenceTrackNorth;
    private double referenceTrackEast;
    private double referenceTrackDown;
    private double referenceTrackSpeed;
}
