package net.frogmouth.rnd.jim.s4607.processinghistory;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;
import net.frogmouth.rnd.jim.s4607.impl.SerialisationUtils;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Serialiser for {@link ProcessingHistorySegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class ProcessingHistorySegmentSerialiser extends AbstractSegmentSerialiser
        implements ISegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.ProcessingHistorySegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        ProcessingHistorySegment processingHistorySegment = (ProcessingHistorySegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(writeI8(processingHistorySegment.getProcessingRecords().size()));
        baos.writeBytes(
                SerialisationUtils.padString(
                        processingHistorySegment.getBasedOnNationalityID(), 2));
        baos.writeBytes(
                SerialisationUtils.padString(processingHistorySegment.getBasedOnPlatformID(), 10));
        baos.writeBytes(writeI32(processingHistorySegment.getBasedOnMissionId()));
        baos.writeBytes(writeI32(processingHistorySegment.getBasedOnJobID()));
        for (ProcessingRecord processingRecord : processingHistorySegment.getProcessingRecords()) {
            baos.writeBytes(writeI8(processingRecord.getProcessingHistorySequenceNumber()));
            baos.writeBytes(
                    SerialisationUtils.padString(
                            processingRecord.getNationalityIdOfModifyingSystem(), 2));
            baos.writeBytes(
                    SerialisationUtils.padString(
                            processingRecord.getPlatformIdOfModifyingSystem(), 10));
            baos.writeBytes(writeI32(processingRecord.getMissionIdOfModifyingSystem()));
            baos.writeBytes(writeI32(processingRecord.getJobIdOfModifyingSystem()));
            baos.writeBytes(
                    SerialisationUtils.writeFL16(
                            processingRecord.getProcessingPerformed().toInteger()));
        }
        return baos.toByteArray();
    }
}
