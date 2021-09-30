package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	This JPEG Sensor Quantisation Data Table is used whenever one or more of the current quantisation tables 0 to 3 are to be updated with new custom quantisation
	values. Tq (See field 3) is used to specify which table is to be replaced.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	Encoded as binary XY where;
	X (4 Bits) is the precision, with:
	$0 is 8-bit precision
	$1 is 16-bit precision.
	Y (4 Bits) is the quantisation table number $0 to $3.
	(*) Fields 3 and 4 repeat for each additional Quantisation Table up to a maximum of four tables in total.
	This table shall be used for the JPEG Abbreviated Image Format.
	There are four possible Quantisation Tables that are numbered 0 to 3. It is mandatory for STANAG 7023 collection platforms and exploitation systems that support
	JPEG compression to have Quantisation Tables 0 and 1 pre-entered with the following default Quantisation Tables. These default tables are permanently stored in
	both the collection platforms and exploitation platforms.
	Quantisation Table 0 shall be the table that appears in section K.1 Table K.1 Luminance Quantisation Table of ISO/IEC 10918-1:1994.
	Quantisation Table 1 shall be the table that appears in section K.1 Table K.2 Chrominance Quantisation Table of ISO/IEC 10918-1:1994.
	The Default Quantisation Table 0 shall be used as the default table for monochrome imagery.
	The Quantisation Tables 2 and 3 have no values until written by this JPEG Sensor Quantisation Data Table. The default tables are permanently valid unless
	overwritten by a custom table during the mission. Once any of the four Quantisation Tables are overwritten by a custom table that table shall be permanently valid
	unless it is overwritten by a new custom table later in the mission.
*/
public class JpegSensorQuantisationDataTable extends DataTable {
    private int dQT;
    private int lq;
    private int pqTqQuantisationTable;
    private int qkQuantisationTableElements;
}
