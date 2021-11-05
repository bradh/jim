package net.frogmouth.rnd.jim.npif.tables.segmentevent;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class EventMarkerDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000002;

    public EventMarkerDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        EventMarkerDataTable dataTable = new EventMarkerDataTable();
        dataTable.setName("Event Marker");
        dataTable.setSourceFile("Segment/Event Index");
        dataTable.setEventNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setEventType(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setPrimarySensorNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setSecondarySensorNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setThirdSensorNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTargetNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.SEGMENT_EVENT_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
