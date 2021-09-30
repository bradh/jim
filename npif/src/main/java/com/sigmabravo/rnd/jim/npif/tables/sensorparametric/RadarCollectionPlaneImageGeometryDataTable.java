package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	n k
	D
	io o
	VL
	ct Lo
	C
	re l
	Di irtua
	Lo ros
	ok s V
	V
	Di irtu
	re a
	ct l
	io
	n
	CV
	LD
	e
	ce ng
	an a
	st R
	Di ear
	N
	
	    Reference Track
	Sensor Virtual
	Position
	Figure A-13 – General Geometry
	Range/Cross Range
	Along Track/Across Track                           (Spot SAR)
	(Squinted Swath SAR)
	 := 90°
	R := const.
	R := const
	
	Sensor Virtual
	Position          R
	     R
	Sensor Position
	=
	Sensor Position                                 Sensor Virtual
	Position
	Figure A-14 Example for Swath SAR               Figure A-15 – Example for Spot SAR
*/
public class RadarCollectionPlaneImageGeometryDataTable extends DataTable {
    private double alpha;
    private double virtualDistanceToTheFirstPixel;
    private double pixelIntervalInTheVirtualLook;
    private double pixelIntervalInTheCross;
    private int unitsOfMeasurementFor;
}
