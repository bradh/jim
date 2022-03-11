package net.frogmouth.rnd.jim.s4607.jobrequest;

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
 * Serialiser for {@link JobRequestSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class JobRequestSegmentSerialiser extends AbstractSegmentSerialiser
        implements ISegmentSerialiser {

    /** Constructor. */
    public JobRequestSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobRequestSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        JobRequestSegment jobRequestSegment = (JobRequestSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(SerialisationUtils.padString(jobRequestSegment.getRequestorID(), 10));
        baos.writeBytes(SerialisationUtils.padString(jobRequestSegment.getRequestorTaskId(), 10));
        baos.writeBytes(writeI8(jobRequestSegment.getPriority()));
        BoundingAreaSerialiser.writeBoundingArea(jobRequestSegment.getBoundingArea(), baos);
        baos.writeBytes(writeE8(jobRequestSegment.getRadarMode()));
        baos.writeBytes(writeI16(jobRequestSegment.getRadarResolutionRange()));
        baos.writeBytes(writeI16(jobRequestSegment.getRadarResolutionCrossRange()));
        ZonedDateTime zdt = jobRequestSegment.getEarliestStartTime();
        baos.writeBytes(writeI16(zdt.getYear()));
        baos.writeBytes(writeI8(zdt.getMonth().getValue()));
        baos.writeBytes(writeI8(zdt.getDayOfMonth()));
        baos.writeBytes(writeI8(zdt.getHour()));
        baos.writeBytes(writeI8(zdt.getMinute()));
        baos.writeBytes(writeI8(zdt.getSecond()));
        baos.writeBytes(writeI16(jobRequestSegment.getStartTimeAllowedDelay()));
        baos.writeBytes(writeI16(jobRequestSegment.getDuration()));
        baos.writeBytes(writeI16(jobRequestSegment.getRevisitInterval()));
        baos.writeBytes(writeE8(jobRequestSegment.getSensorIdType()));
        baos.writeBytes(SerialisationUtils.padString(jobRequestSegment.getSensorIdModel(), 6));
        baos.writeBytes(writeFL8(jobRequestSegment.getRequestType()));
        return baos.toByteArray();
    }
}
