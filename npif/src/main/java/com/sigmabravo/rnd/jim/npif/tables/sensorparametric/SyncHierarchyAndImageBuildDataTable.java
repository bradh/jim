package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	This table can be used to supplement the Sensor Description Data Table (PASSIVE and RADAR) and is CONDITIONAL on the Sensor Description Data Table
	being used correctly.
	It describes the data structure hierarchy used to sequence samples.
	The accumulation strategy of the image components at each hierarchical level is referenced to the X and Y axes of the image:
	X is the first dimension of image coordinate system – sample PDA defines the X axis.
	Y is the second dimension of image coordinate system – sample SDA defines the Y axis.
	Build directions are used to indicate the direction of accumulation of image components of a given hierarchical level within the superordinated hierarchical level. A
	sample is always understood to be an image component subordinate to the lowest hierarchical level defined through this table.
	Notation:
	PDA : Primary direction of accumulation within a given hierarchical level
	SDA : Secondary direction of accumulation within a given hierarchical level
	Historically the use of terms such as FRAME, SWATH, TILE, LINE, etc. was understood to be well defined within the reconnaissance community. Now such terms
	are defined differently by different users and FRAME and SWATH are often interchanged. The above use of the phrase “image component” is an attempt to provide
	a system that is independent of the possible misleading terms.
	Fields 1 to 6
	Fields 1 to 6 describe the hierarchy level of image components. These immediate unsigned binary fields can take on 7 values: 0, 1, 2, 3, 4, 5, 6:
	Hierarchy value = 0: Image component is not used in the image structure.
	Hierarchy value = 1: Highest order image component.
	Hierarchy value = 2: Second highest order image component.
	Etc.
	Hierarchy value = 6: Sixth highest order image component.
	Except for zero ($00), no two of these fields can have the same hierarchy value.
	Example: Considering the image structure to be a FRAME built up from TILES, Fields 1 to 6 take on the following values:
	Field no.                     Value            Comment
	1                           0              SUPER FRAME not used = 0
	2                           1              FRAME has hierarchy = 1
	3                           0              FIELD not used = 0
	4                           0              SWATH not used = 0
	5                           2              TILE has hierarchy = 2
	6                           0              LINE not used = 0
	Y                                                                                   STANAG 7023
	Build direction of TILE = $03
	PDA is X negative
	SDA is Y positive
	Padded
	zeros
	12        11        10         9
	8        7         6         5
	Tile length
	4        3         2         1
	X
	Tile width
	Figure A-1 – Example
*/
public class SyncHierarchyAndImageBuildDataTable extends DataTable {
    private int sUPERFRAMEHierarchy;
    private int fRAMEHierarchy;
    private int fIELDHierarchy;
    private int sWATHHierarchy;
    private int tILEHierarchy;
    private int lINEHierarchy;
    private int buildDirectionOf;
    private int frameCoverageRelationship;
}
