package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	The STANAG allows up to 64K elements per sensor.
	The elements are used to indicate different receptor bands of the sensor. E.g. a colour camera might have 3 elements: 1 for red, 1 for green, and 1 for blue. Starting
	from 0, the elements shall be identified by an incremental Sensor Element ID number.
	The above table allows for arbitrary length Element sizes.
	By specifying the size and bit offset we assume contiguous bits for an element.
	The examples below show three possible representations (band interleaved by pixel (BIP), band sequential (BSQ), band interleaved by line (BIL)) for an RGB image.
	Case 1 (BIP):           R G B R G B R G B R G B R G B R G B ...          (Line 1)
	R G B R G B R G B R G B R G B R ...              (Line 2)
	R G B R G B R G B R G B R G ...                  (Line 3)
	R G B R G B R G B R G B ...                      (Line 4)
	R G B R G B R G B R B ...                        (Line 5)
	....
	Case 2 (BSQ):           R R R R R R R R R R R R R R R R R R ...          (ID = 0, Line 1)
	R R R R R R R R R R R R R R R R ...              (ID = 0, Line 2)
	R R R R R R R R R R R R R R ...                  (ID = 0, Line 3)
	R R R R R R R R R R R R ...                      (ID = 0, Line 4)
	....
	G G G G G G G G G G G G G G G G G G ...          (ID = 1, Line 1)
	G G G G G G G G G G G G G G G G ...              (ID = 1, Line 2)
	G G G G G G G G G G G G G G ...                  (ID = 1, Line 3)
	G G G G G G G G G G G G ...                      (ID = 1, Line 4)
	....
	B B B B B B B B B B B B B B B B B B ...          (ID = 2, Line 1)
	B B B B B B B B B B B B B B B B ...              (ID = 2, Line 2)
	B B B B B B B B B B B B B B ...                  (ID = 2, Line 3)
	B B B B B B B B B B B B ...                      (ID = 2, Line 4)
	....
	Case 3 (BIL):            R R R R R R R R R R R R R R R R R R ...           (ID = 0, Line 1)
	G G G G G G G G G G G G G G G G G G ...           (ID = 1, Line 1)
	B B B B B B B B B B B B B B B B B B ...           (ID = 2, Line 1)
	R R R R R R R R R R R R R R R R ...               (ID = 0, Line 2)
	G G G G G G G G G G G G G G G G ...               (ID = 1, Line 2)
	B B B B B B B B B B B B B B B B ...               (ID = 2, Line 2)
	R R R R R R R R R R R R R R ...                   (ID = 0, Line 3)
	G G G G G G G G G G G G G G ...                   (ID = 1, Line 3)
	B B B B B B B B B B B B B B ...                   (ID = 2, Line 3)
	R R R R R R R R R R R R ...                       (ID = 0, Line 4)
	....
	The size of a frame, swath or tile shall be given by the number of lines and the number of samples per line. For example, this means that for tiles that are different in
	their data ordering only (BIP, BIL or BSQ ordered sensor data) the tile sizes have to be the same.
	For multiple element data ordered according to BSQ or BIL, lines or bands of elements shall be ordered according to Sensor Element ID, with Sensor Element ID =
	0 occurring first.
	For multiple element data ordered according to BIP, the elements shall be ordered according to Sensor Element ID from the most significant to the less significant bit
	of the composite sample, i.e. Element ID =0 contains the most significant bit. An element bit offset of zero designates the most significant bit.
	Sample size
	It should be noted that in BIP the three sensor elements (R, G, B) are combined into one composite sample, leading to a sample size of 3 x 8 = 24 bits. In the BSQ
	and BIL cases the samples of the sensor elements are not combined into a composite one, but remain individually ordered by line or band. Therefore, in these cases
	one sample contains only the information from a single sensor element, leading to a sample size of 8 bits, which is equal to the corresponding element size.
	Example RGB-Sensor:
	(For Elements per pixel and Data Ordering see Passive Sensor Description Data Table)
	BIP               BSQ              BIL
	Case 1            Case 2           Case 3
	Sample size                                       24                8                8
	Elements per pixel                                  3                3                 3
	Data Ordering                                     $01              $02               $03
	Element Size, ID = 0 (R)                            8                8                 8
	Element Size, ID = 1 (G)                            8                8                 8
	Element Size, ID = 2 (B)                            8                8                 8
	Element Bit Offset                                  0                0                 0
	ID = 0 (R)
	Element Bit Offset                                  8                0                 0
	ID = 1 (G)
	Element Bit Offset                                  16               0                 0
	ID = 2 (B)
	In the case of unispectral data (e.g. B/W-Sensor), the field Data Ordering shall be set equal to $00, Elements per pixel equal = 1, and Element size = Sample size.
	A-12        RADAR Data Tables
*/
public class PassiveSensorElementDataTable extends DataTable {
    private int elementSize;
    private int elementBitOffset;
    private int sensorElementID;
    private double minimumWavelength;
    private double maximumWavelength;
}
