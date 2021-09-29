package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SegmentIndexDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;
    private static final int FILE_ADDRESS_MASK = 0xFFFF00FF;
    private static final int FILE_ADDRESS_SEGMENT_NUMBER_MASK = 0x0000FF00;
    private int segmentNumber;

    public SegmentIndexDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        System.out.println("Segment Index Data Table");
        return new DataTable();
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        segmentNumber = (fileAddress & FILE_ADDRESS_SEGMENT_NUMBER_MASK) >> Byte.SIZE;
        return ((sourceAddress == Constants.SEGMENT_EVENT_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED)
                && (segmentNumber != 0));
    }
}
