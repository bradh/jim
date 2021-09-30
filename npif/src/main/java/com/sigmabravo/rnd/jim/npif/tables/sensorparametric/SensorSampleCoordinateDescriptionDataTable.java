package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	This table is used in conjunction with the Sensor Element Data Table and the Sensor Sample “x”, “y” and “z” Coordinate Data Tables.
	Vector modelling may be accomplished on a sample by sample or on a pixel by pixel basis, as indicated by the field “Vector Model”.
	In general there is a one-to-one relationship between a sample and its coordinate components, i.e. Sensor Sample “x”, “y” and “z” Coordinate Data Tables and
	corresponding Sensor Data Table are identically structured (Image size, Tile Size, Data ordering), though they may be different in overall number of bytes.
	If vector modelling is on a pixel by pixel basis:
	     the look vectors of each sample of the same pixel are assumed to be identical and shall not be repeated for each sample, i.e. the “x”, “y” and “z” Sensor Sample
	Coordinate Data Tables are treated alike to single element sensor data;
	     a size of zero for a particular coordinate component (x, y, or z) shall indicate that for all pixels of the image this coordinate component is to be set to zero. In this
	case, the Sensor Sample Coordinate Data Table of that component shall not occur in the data stream.
	The coordinate system for vector modelling is the sensor coordinate system. Its origin (0, 0, 0) is the optical centre of the sensor. The x-axis is the pointing direction
	of the sensor, which, in general falls together with the optical axis of the sensor.
*/
public class SensorSampleCoordinateDescriptionDataTable extends DataTable {
    private int vectorModel;
    private int sizeOfXVectorComponent;
    private int typeOfXVectorComponent;
    private int sizeOfYVectorComponent;
    private int typeOfYVectorComponent;
    private int sizeOfZVectorComponent;
    private int typeOfZVectorComponent;
    // TODO: the last 6 can repeat - probably need a helper class.
}
