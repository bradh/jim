package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	For n elements the pixel size is:
	Pixel size = Element size (ID = 0) + Element size (ID = 1) + … + Element size (ID = n-1)
	In analogy to Table A-12.1 “RADAR Sensor Description Data Table”, Fields 6 and 7, the physical coordinate system and coordinate system orientation are defined
	as follows:
	The physical coordinate system associated with the image of a passive sensor is the hfsd / lfsd coordinate system (hfsd: high frequency scanning direction; lfsd: low
	frequency scanning direction) of the sensor, with orientation as given by Fields 16 and 17 of Table A-11.1.
	The orientation of the hfsd / lfsd coordinate system relative to the X and Y axes of the image coordinate system shall be by default: hfsd is X positive, lfsd is Y
	positive.
	If Table A-9.3 “Sync Hierarchy and Image Data Structure Data Table” is not used, the build direction of frame and tile image components, and of samples shall be by
	default “PDA is X positive, SDA is Y positive”.
	The build direction of field, swath and line image components shall be chosen in a way, so that they coincide with the low frequency scanning direction (lfsd).
	General                                  2   = Duration for        3
	8:         No of Swaths
	Sensor y
	9:         any                                                                      “Line Direction”     Direction
	10, 11:    Pixel-Info
	12:        Data Ordering
	15:        Interlaced
	Sensors                                                                      7     =n              000
	000
	Tile 1              Tile 2                   ...        Tile n
	6                                                     000
	Frame
	5                                     000
	13
	1                                     Se
	14                                                Di nso
	rec r x
	tio
	“Frame                                                                            n
	Direction”                          17
	000
	Sensor z                                                                                                       000
	Direction                                                                                               Tile m
	000
	000
	3             16
	4   =m
	Figure A-10 - Interpretation Diagram for the Sensor Description Data Table.
	Additional information concerning the above diagram.
	The 000 on the right represent the padding of pixels up to the edge of the frame in the high frequency direction (field 5).
	Padding of zeros is also allowed in the low frequency direction (field 6, not shown in diagram above).
	The numbers in circles refer to the fields in the table.
	Second Tile of Second
	Swath (TILE SYNC)
	Second Tile of First                                                         Last Tile of First Swath
	Swath (TILE SYNC)                                                                 (TILE SYNC)
	Third Tile of First Swath
	(TILE SYNC)
	First Tile of First Swath
	(FRAME SYNC)
	1*   2*    3*                                                                                                                                 n*
	First Tile of Second
	Swath (SWATH SYNC)                                                            n+1* n+2* n+3*
	Maximum Number of Lines per Frame = 4.29G Lines
	First Tile of Third Swath
	(SWATH SYNC)                                                                                      *   = STANAG 7023 Data File
	Number (Header)
	Maximum Number of Swaths per Frame = 4.29G
	Swaths repeat until end
	of frame
	Swaths
	Tiles repeat until end of
	frame
	Maximum Number of Samples per Line = 4.29G Samples
	Figure A-11 - The STANAG 7023 Sensor Frame Description to Accommodate Tiles (e.g. JPEG Files)
*/
public class PassiveSensorDescriptionDataTable extends DataTable {
    private int frameOrSwathSize;
    private double activeLineTime;
    private int lineSizeOfActiveData;
    private int packetsPerFrameOrSwath;
    private int sizeOfTileInTheHigh;
    private int sizeOfTileInTheLowFrequency;
    private int numberOfTilesAcrossALine;
    private int numberOfSwathsPerFrame;
    private int sensorMode;
    private int pixelSize;
    private int elementsPerPixel;
    private int dataOrdering;
    private double lineFOV;
    private double frameOrSwathFOV;
    private int numberOfFields;
    private int highFrequencyScanning;
    private int lowFrequencyScanning;
}
