package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZonedDateTime;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	File Addressing scheme is $0000 02xx where xx represents the segment number.
*/
public class SensorIndexDataTable extends DataTable {
    private ZonedDateTime collectionStartTime;
    private ZonedDateTime collectionStopTime;
    private int startHeaderTimeTag;
    private int endHeaderTimeTag;
    private Position aircraftLocationAtCollectionStartTime;
    private Position aircraftLocationAtCollectionEndTime;
    private int sensorStartPosition;
    private int sensorEndPosition;
    // TODO: these can repeat - helper class?
}
