package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class EndOfRecordMarkerDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;

    public EndOfRecordMarkerDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        EndOfRecordMarkerDataTable dataTable = new EndOfRecordMarkerDataTable();
        dataTable.setName("End of Record Marker");
        dataTable.setSourceFile("Segment/Event Index");
        dataTable.setSizeOfRecord(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.SEGMENT_EVENT_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
