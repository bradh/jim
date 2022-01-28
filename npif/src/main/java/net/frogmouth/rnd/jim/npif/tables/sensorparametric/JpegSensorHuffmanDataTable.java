package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	This JPEG Sensor Huffman Data Table is used whenever one or more of the current DC or AC Huffman tables 0 to 3 are to be updated with new custom DC or AC
	Huffman values. TcTh is used to specify which table is to be replaced.
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	(*) Fields 3, 4 and 5 repeat for each additional Huffman Table up to a maximum of eight tables in total (four DC and four AC tables).
	This table shall be used for the JPEG Abbreviated Image Format.
	There are four possible DC Huffman Tables and four possible AC Huffman Tables that are each numbered 0 to 3. It is mandatory for STANAG 7023 collection
	platforms and exploitation systems that support JPEG compression to have DC and AC Huffman Tables 0 and 1 pre-entered with the following default Huffman
	Tables. These default tables are permanently stored in both the collection platforms and exploitation platforms.
	DC Huffman Table 0 shall be the table that appears in section K.3.1 Table K.3 Luminance DC Difference Table of ISO/IEC 10918-1:1994.
	DC Huffman Table 1 shall be the table that appears in section K.3.1 Table K.4 Chrominance DC Difference Table of ISO/IEC 10918-1:1994.
	AC Huffman Table 0 shall be the table that appears in section K.3.2 Table K.5 Table for Luminance AC Coefficients of ISO/IEC 10918-1:1994.
	AC Huffman Table 1 shall be the table that appears in section K.3.2 Table K.6 Table for Chrominance AC Coefficients of ISO/IEC 10918-1:1994.
	The Default DC and AC Huffman Table 0 shall be used as the default table for monochrome imagery.
	The Huffman Tables 2 and 3 have no values until written by this JPEG Sensor Huffman Data Table. The default tables are permanently valid unless overwritten by a
	custom table during the mission. Once any of the four DC or AC Huffman Tables are overwritten by a custom table that table shall be permanently valid unless it is
	overwritten by a new custom table later in the mission.
	A-10.5        JPEG 2000 Compression
	The JPEG 2000 compression method used, is compliant with the international standard for image compression, ISO/IEC 15444-1 and its specification within
	2000 in STANAG 7023 differs slightly from that in STANAG 4545, however, STANAG 7023 still conforms to the BIIF Profile for JPEG 2000 Version 01.00
	(BPJ2K01.00):
	   No progression changes inside a segment for a particular sensor.
	   RLCP progression is recommended in 7023 whereas an LRCP progression is recommended in [BPJ2K01.00].
	Optional code-block coding styles are allowed, especially those enabling resilience to transmission errors. The use of SOP and EPH marker segments is allowed.
	The additional file format (JP2) defined in the JPEG 2000 part 1 standard is not supported by STANAG 7023.
	Whereas JPEG allows two possible formats (abbreviated or interchange), a JPEG 2000 codestream is always a self-sufficient stream similar to JPEG Interchange
	format. The following scheme describes data organisation of a J2K Stream with 2 levels of resolution and 3 levels of quality (layers).
	Header
	Body                   Body                      Body                   Body                 Body                 Body
	P(r,l,c,p)           P(r,l+1,c,p)             P(r,l+2,c,p)            P(r+1,l,c,p)          P(r+1,l+1,c,p)       P(r+1,l+2,c,p)
	Data corresponding to                      Data corresponding to
	Packet header
	a layer                                    a resolution
	P(r,l,c,p) : A packet of the resolution level r for the quality layer l, the component c and the precinct p
	(rectangular sub-set of the subband)
	Figure A.4 - Schema describing data organisation of a LRCP progression order
	Tiling inside JPEG 2000 stream is not recommended, but may occur for implementation constraints.
	Each Image Data Packet shall contain one single JPEG 2000 image part. The required JPEG 2000 markers are the following:
	SOC: Start of Codestream
	SIZ: Image and Tile Size (a tile is the partition of the image into rectangular regions)
	QCD: Quantization Default (Quantization step sizes)
	COD: Coding Default (Coding parameters)
	SOT: Start of Tile-Part
	SOD: Start of Data
	EOC: End of codestream
	JPEG 2000 Codestream using only required markers
	Main        Tile-part                           Tile-part                  Tile-part                  Tile-part
	Data                           Data                            Data                    Data            EOC
	header        header                              header                     header                     header
	Tile-part
	SOC       SIZ      QCD      COD
	SOT         SOD
	Figure A-5 - JPEG 2000 Codestream
	JPEG 2000 Part 1 supports five progression orders, (a progression order defines the way information (data units) is ordered in the bitstream).
	This ordering of the data depends on four parameters:
	 Resolution (size of the image corresponding to the wavelet filtering)
	 Layer (Quality increment)
	 Components (the bands of the image)
	 Precinct (spatial position)
	The progression orders supported by STANAG 7023 are:
	 Layer-Resolution-Component-Position (LRCP) ordering, where data units are ordered first by layer, second by resolution, third by component and last by spatial
	position. This corresponds to a progressive recovery by quality.
	 Resolution-Layer-Component-Position (RLCP) which corresponds to a progressive recovery by resolution.
	 Resolution-Position-Component-Layer (RPCL) progression
	 Position-Component-Resolution-Layer (PCRL) progression
	 Component-Position-Resolution-Layer (CPRL) progression
	LRCP and RLCP orderings are described in the following figures.
	Main      Tile-part
	header      header                                                                                                                    EOC
	Resolution 1
	Layer 1
	Resolution 2
	Resolution 3
	Figure A-6 - Example of a RLCP Bitstream (with 3 levels of resolution, 4 layers and one component) where the information is ordered, first by resolution, then by
	quality (Layers).
	Main        Tile-part
	header      Layer 1                                                                                                 EOC
	EOC
	header
	Layer 2
	Layer 3
	Layer 4
	Bit rate                0.125 bpp                    0.25 bpp                      0.5 bpp                      Final rate
	Figure A-7 - Example of a LRCP Bitstream (with 4 layers and one component where the information is first ordered by quality
*/
@SuppressFBWarnings
public class JpegSensorHuffmanDataTable extends DataTable {
    private int dHT;
    private int lh;
    private int tcTh;
    private int l1;
    private int vi, j;
}
