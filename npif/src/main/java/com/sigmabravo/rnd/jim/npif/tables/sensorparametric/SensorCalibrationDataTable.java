package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.time.ZonedDateTime;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
*/
public class SensorCalibrationDataTable extends DataTable {
    private ZonedDateTime calibrationDate;
    private String calibrationAgency;
}
