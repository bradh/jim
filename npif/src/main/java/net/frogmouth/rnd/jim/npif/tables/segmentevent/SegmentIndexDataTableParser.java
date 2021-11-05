package net.frogmouth.rnd.jim.npif.tables.segmentevent;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SegmentIndexDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;
    private static final int FILE_ADDRESS_MASK = 0xFFFF00FF;
    private static final int FILE_ADDRESS_SEGMENT_NUMBER_MASK = 0x0000FF00;
    private int segmentNumber;

    public SegmentIndexDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SegmentIndexDataTable dataTable = new SegmentIndexDataTable();
        dataTable.setName("Segment Index");
        dataTable.setSourceFile("Segment/Event Index");
        dataTable.setStartOfDataSegment(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setEndOfDataSegment(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setStartTimeOfRecording(readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setStopTimeOfRecording(readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setStartOfHeaderTimeTag(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setEndOfHeaderTimeTag(readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAircraftLocationAtTheStartOfRecordingOfTheSegment(
                readPosition(mappedByteBuffer, offset));
        offset += 16;
        dataTable.setAircraftLocationAtTheEndOfRecordingOfTheSegment(
                readPosition(mappedByteBuffer, offset));
        offset += 16;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        segmentNumber = (fileAddress & FILE_ADDRESS_SEGMENT_NUMBER_MASK) >> Byte.SIZE;
        return ((sourceAddress == Constants.SEGMENT_EVENT_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED)
                && (segmentNumber != 0));
    }
}
