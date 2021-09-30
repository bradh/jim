package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class EventIndexDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;
    private static final int FILE_ADDRESS_MASK = 0xFFFF0000;
    private static final int FILE_ADDRESS_SEGMENT_NUMBER_MASK = 0x0000FF00;
    private static final int FILE_ADDRESS_EVENT_NUMBER_MASK = 0x000000FF;
    private int segmentNumber;
    private int eventNumber;

    public EventIndexDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        EventIndexDataTable dataTable = new EventIndexDataTable();
        dataTable.setName("Event Index");
        dataTable.setSourceFile("Segment/Event Index");
        dataTable.setEventType(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTargetNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTargetSubSection(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTimeTag(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setEventTime(readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAircraftGeoLocation(readPosition(mappedByteBuffer, offset));
        offset += 16;
        dataTable.setPrimarySensorNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setSecondarySensorNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setThirdSensorNumber(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setEventPositionInTheRecord(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setEventName(readASCII(mappedByteBuffer, offset, 32));
        offset += 32;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        segmentNumber = (fileAddress & FILE_ADDRESS_SEGMENT_NUMBER_MASK) >> Byte.SIZE;
        eventNumber = (fileAddress & FILE_ADDRESS_EVENT_NUMBER_MASK);
        return ((sourceAddress == Constants.SEGMENT_EVENT_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED)
                && (segmentNumber != 0)
                && (eventNumber != 0));
    }
}
