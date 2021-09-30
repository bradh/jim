package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	Identifies the algorithms and parameters of the imagery compression scheme used. This file defines the compression scheme used on the image data. If the sensor
	data is not compressed then this file is not used.
	The compression flag of the header, which is a boolean, cannot specify what kind of compression (JPEG or JPEG 2000) has been used. Therefore, for a given
	sensor, once a compression type has been set, it is assumed that there is no change on the compression type as long as no new compression table is sent again.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	A-10.2      JPEG Compression Data Tables
	If Image Compression is by the JPEG method, then the tables described in this section may be required.
	The JPEG compression method complies with the international standard for image compression, ISO/IEC 10918-1:1994.
	The JPEG compression format specified within STANAG 7023 ensures that each Image Data Packet contains only complete fully ISO/IEC JPEG compliant
	interchange format data stream.
	An important table to be used in conjunction with JPEG compression format is the Sensor Description Data Table and the figure that appears with it – The STANAG
	7023 Sensor Frame Description to accommodate Tiles (e.g. JPEG files).
	JPEG Interchange Format (monochrome and interleaved
	YCbCr601)
	ENTROPY
	DRI and
	DQT and       DHT and                       SOF and       SOS and         DATA and
	SOI                               PARAMETERS                                                  EOI
	PARAMETERS    PARAMETERS                    PARAMETERS    PARAMETERS       optional RST
	(Optional)
	Markers
	JPEG Interchange Format (Non-interleaved YCbCr601)
	ENTROPY
	DRI and
	DQT and       DHT and                       SOF and       SOS and         DATA and
	SOI                               PARAMETERS
	PARAMETERS    PARAMETERS                    PARAMETERS    PARAMETERS       optional RST
	(Optional)
	Markers
	ENTROPY                     ENTROPY
	SOS and      DATA and        SOS and     DATA and
	EOI
	PARAMETERS    optional RST   PARAMETERS   optional RST
	Markers                     Markers
	Figure A-2 - The JPEG Interchange Format
	For low bandwidth systems the JPEG abbreviated image format can be used, in which case the JPEG Sensor Quantisation Data Table and the JPEG Sensor
	Huffman Data Table can be omitted from the Image Data Packets. These two tables must occur elsewhere in the record prior to the relevant Image Data Packets.
	JPEG Abbreviated Format (monochrome and interleaved
	YCbCr601)
	ENTROPY DATA
	DRI and
	SOF and             SOS and          with interleaved
	SOI         PARAMETERS                                                                EOI
	PARAMETERS          PARAMETERS          optional RST
	(Optional)
	Markers
	JPEG Abbreviated Format (Non-interleaved YCbCr601)
	ENTROPY
	DRI and
	SOF and        SOS and         DATA and
	SOI    PARAMETERS
	PARAMETERS     PARAMETERS       optional RST
	(Optional)
	Markers
	ENTROPY                       ENTROPY
	SOS and       DATA and         SOS and      DATA and
	EOI
	PARAMETERS     optional RST    PARAMETERS    optional RST
	Markers                       Markers
	Figure A-3 - The JPEG Abbreviated Image Format
	The JPEG processes supported by STANAG 7023 are the 8-bit precision baseline JPEG process and the 12-bit precision extended sequential JPEG process for
	both monochrome and colour images.
	Arithmetic entropy coding, and progressive/hierarchical representations are not supported by STANAG 7023.
	It is mandatory to convert RGB colour source data to YCbCr601 in accordance with CCIR601 before JPEG compression.
	Each Image Data Packet shall contain one single JPEG image. The required JPEG markers within this JPEG image are as follows. (The order that the markers
	appear in the Image Data Packet is as listed):
	SOI                     Start of Image Marker
	SOF0 or SOF1            Start of Frame Marker and Parameters
	SOS                     Start of Scan Marker and Parameters
	EOI                     End of Image Marker
	The JPEG interchange format requires that the following markers appear between SOI and SOS and before each subsequent SOS if subsequent SOS markers
	exist:
	DQT                     Define Quantisation Table Marker and Parameters
	DHT                     Define Huffman Table Marker and Parameters
	One or both of these two markers (DQT and DHT) may be omitted if the abbreviated image format is used.
	If scan restarts are used then the Define Restart Interval Marker (DRI) and Parameters shall appear between SOI and SOS and before each subsequent SOS if
	there is more than one scan.
	No other JPEG markers are allowed by STANAG 7023.
	Compressed image data shall follow each SOS. RSTn markers may be interleaved within the compressed image data if specified by the Define Restart Interval
	Marker.
*/
public class SensorCompressionDataTable extends DataTable {
    private int compressionAlgorithm;
}
