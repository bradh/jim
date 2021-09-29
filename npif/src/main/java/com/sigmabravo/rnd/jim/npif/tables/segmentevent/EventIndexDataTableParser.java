package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
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
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        System.out.println("Event Index Data Table");
        return new DataTable();
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
