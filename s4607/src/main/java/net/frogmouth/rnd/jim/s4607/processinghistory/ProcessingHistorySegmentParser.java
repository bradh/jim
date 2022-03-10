package net.frogmouth.rnd.jim.s4607.processinghistory;

import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link ProcessingHistorySegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class ProcessingHistorySegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.ProcessingHistorySegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        ProcessingHistorySegment processingHistorySegment = new ProcessingHistorySegment();
        final int processingHistoryCount = context.readI8();
        processingHistorySegment.setBasedOnNationalityID(context.readASCII(2));
        processingHistorySegment.setBasedOnPlatformID(context.readASCII(10));
        processingHistorySegment.setBasedOnMissionId(context.readI32());
        processingHistorySegment.setBasedOnJobID(context.readI32());
        for (int i = 0; i < processingHistoryCount; i++) {
            ProcessingRecord record = new ProcessingRecord();
            record.setProcessingHistorySequenceNumber(context.readI8());
            record.setNationalityIdOfModifyingSystem(context.readASCII(2));
            record.setPlatformIdOfModifyingSystem(context.readASCII(10));
            record.setMissionIdOfModifyingSystem(context.readI32());
            record.setJobIdOfModifyingSystem(context.readI32());
            record.setProcessingPerformed(ProcessingPerformed.fromInteger(context.readFL16()));
            processingHistorySegment.addProcessingRecord(record);
        }
        return processingHistorySegment;
    }
}
