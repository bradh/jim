package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	If Table A-9.3 “Sync Hierarchy and Image Data Structure Data Table” is not used, the build direction of FRAME and TILE image components, and of samples shall
	be by default “$01 = PDA is X positive, SDA is Y positive”.
	Two illustrative examples concerning Field 7, Image Coordinate System Orientation, are given below:
	Example 1:                                                                                   Example 2:
	Image Coordinate System Orientation = $02                                                    Image Coordinate System Orientation = $07
	Y                                                                                            Y
	vld is X negative,                                                                           vld is Y negative,
	cvld is Y positive                                                                           cvld is X negative
	cvld
	Padded                                                                                      Padded
	zeros                          cvld
	zeros
	Image Length
	Image Length
	X
	vld
	X
	Image Width                                                                                  Image Width
	vld
	Figure A-12 – Illustrative Examples of Image Coordinate System Orientation.
*/
public class RadarSensorDescriptionDataTable extends DataTable {
    private int imageLength;
    private int imageWidth;
    private int packetsPerImage;
    private int tileLength;
    private int tileWidth;
    private int physicalCoordinateSystem;
    private int coordinateSystemOrientation;
    private int sensorMode;
    private int pixelSize;
    private int elementsPerPixel;
    private int dataOrdering;
    private int vldOrientation;
}
