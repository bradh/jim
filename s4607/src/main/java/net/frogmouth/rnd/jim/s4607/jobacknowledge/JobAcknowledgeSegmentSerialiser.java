package net.frogmouth.rnd.jim.s4607.jobacknowledge;

import java.io.ByteArrayOutputStream;
import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;
import net.frogmouth.rnd.jim.s4607.impl.BoundingAreaSerialiser;
import net.frogmouth.rnd.jim.s4607.impl.SerialisationUtils;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Serialiser for {@link JobAcknowledgeSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class JobAcknowledgeSegmentSerialiser extends AbstractSegmentSerialiser
        implements ISegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobAcknowledgeSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        JobAcknowledgeSegment jobAcknowledgeSegment = (JobAcknowledgeSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(writeI32(jobAcknowledgeSegment.getJobId()));
        baos.writeBytes(SerialisationUtils.padString(jobAcknowledgeSegment.getRequestorID(), 10));
        baos.writeBytes(
                SerialisationUtils.padString(jobAcknowledgeSegment.getRequestorTaskId(), 10));
        baos.writeBytes(writeE8(jobAcknowledgeSegment.getSensorIdType()));
        baos.writeBytes(SerialisationUtils.padString(jobAcknowledgeSegment.getSensorIdModel(), 6));
        baos.writeBytes(writeI8(jobAcknowledgeSegment.getPriority()));
        BoundingAreaSerialiser.writeBoundingArea(jobAcknowledgeSegment.getBoundingArea(), baos);
        baos.writeBytes(writeE8(jobAcknowledgeSegment.getRadarMode()));
        baos.writeBytes(writeI16(jobAcknowledgeSegment.getDuration()));
        baos.writeBytes(writeI16(jobAcknowledgeSegment.getRevisitInterval()));
        baos.writeBytes(writeE8(jobAcknowledgeSegment.getRequestStatus()));
        ZonedDateTime zdt = jobAcknowledgeSegment.getRadarJobStartTime();
        baos.writeBytes(writeI16(zdt.getYear()));
        baos.writeBytes(writeI8(zdt.getMonth().getValue()));
        baos.writeBytes(writeI8(zdt.getDayOfMonth()));
        baos.writeBytes(writeI8(zdt.getHour()));
        baos.writeBytes(writeI8(zdt.getMinute()));
        baos.writeBytes(writeI8(zdt.getSecond()));
        baos.writeBytes(
                SerialisationUtils.padString(jobAcknowledgeSegment.getRequestorNationalityId(), 2));
        return baos.toByteArray();
    }
}
