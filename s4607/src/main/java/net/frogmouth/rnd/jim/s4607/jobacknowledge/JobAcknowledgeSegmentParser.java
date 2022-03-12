package net.frogmouth.rnd.jim.s4607.jobacknowledge;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.impl.BoundingAreaParser;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link JobAcknowledgeSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class JobAcknowledgeSegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobAcknowledgeSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        JobAcknowledgeSegment jobAcknowledgeSegment = new JobAcknowledgeSegment();
        jobAcknowledgeSegment.setJobId(context.readI32());
        jobAcknowledgeSegment.setRequestorID(context.readASCII(10));
        jobAcknowledgeSegment.setRequestorTaskId(context.readASCII(10));
        jobAcknowledgeSegment.setSensorIdType(context.readE8());
        jobAcknowledgeSegment.setSensorIdModel(context.readASCII(6));
        jobAcknowledgeSegment.setPriority(context.readI8());
        jobAcknowledgeSegment.setBoundingArea(BoundingAreaParser.parseBoundingArea(context));
        jobAcknowledgeSegment.setRadarMode(context.readE8());
        jobAcknowledgeSegment.setDuration(context.readI16());
        jobAcknowledgeSegment.setRevisitInterval(context.readI16());
        jobAcknowledgeSegment.setRequestStatus(context.readE8());
        final int year = context.readI16();
        final int month = context.readI8();
        final int day = context.readI8();
        final int hour = context.readI8();
        final int minutes = context.readI8();
        final int seconds = context.readI8();
        ZonedDateTime startTime =
                ZonedDateTime.of(year, month, day, hour, minutes, seconds, 0, ZoneOffset.UTC);
        jobAcknowledgeSegment.setRadarJobStartTime(startTime);
        jobAcknowledgeSegment.setRequestorNationalityId(context.readASCII(2));
        return jobAcknowledgeSegment;
    }
}
