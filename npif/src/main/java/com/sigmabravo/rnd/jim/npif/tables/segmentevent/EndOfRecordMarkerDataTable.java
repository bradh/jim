package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	This table is to mark the end of a record. Its Header segment value will increment by one from the previous End of Segment Marker (EOS) value. The exception to
	this rule is when the last EOS Header segment number = $FF (the maximum permitted value) then the EOR Header segment value will also take on the value $FF.
	In all situations this table will be considered independent of the previous segment.
	Segment       EOS      Segment          EOS                   Segment     EOS      EOR
	Repeat
	0           0            1            1           for        N          N        N+1
	segment       or         or        or
	2 onwards     $FF        $FF       $FF
	Where EOS = End of Segment Marker Data Table, EOR = End of Record Marker Data Table.
	Table Requirement       :          MANDATORY
*/
public class EndOfRecordMarkerDataTable extends DataTable {
    private long sizeOfRecord;

    public long getSizeOfRecord() {
        return sizeOfRecord;
    }

    public void setSizeOfRecord(long sizeOfRecord) {
        this.sizeOfRecord = sizeOfRecord;
    }
}
