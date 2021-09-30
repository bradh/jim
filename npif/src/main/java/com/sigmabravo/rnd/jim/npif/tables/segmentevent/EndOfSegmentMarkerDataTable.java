package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	This table is to mark the end of a segment. It is the last segment table to be generated for the segment. The Time Tag value in the Header must be equal to or
	exceed the value for all previous Time Tags generated for other segment data files.
	Table Requirement      :       MANDATORY
	The EOS Marker Data Table shall follow the postamble (if used). The EOS Marker Data Table shall count the number of bytes in the whole of the segment including
	the EOS Marker Data Table itself. The EOS Marker Data Table shall not be regarded as part of the preamble or postamble and shall not be repeated in the
	postambles of subsequent segments.
*/
public class EndOfSegmentMarkerDataTable extends DataTable {
    private long sizeOfSegment;

    public long getSizeOfSegment() {
        return sizeOfSegment;
    }

    public void setSizeOfSegment(long sizeOfSegment) {
        this.sizeOfSegment = sizeOfSegment;
    }
}
