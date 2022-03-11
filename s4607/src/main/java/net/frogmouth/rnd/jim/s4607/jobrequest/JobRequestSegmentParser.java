package net.frogmouth.rnd.jim.s4607.jobrequest;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.impl.BoundingAreaParser;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link JobRequestSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class JobRequestSegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobRequestSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        JobRequestSegment jobRequestSegment = new JobRequestSegment();
        jobRequestSegment.setRequestorID(context.readASCII(10));
        jobRequestSegment.setRequestorTaskId(context.readASCII(10));
        jobRequestSegment.setPriority(context.readI8());
        jobRequestSegment.setBoundingArea(BoundingAreaParser.parseBoundingArea(context));
        jobRequestSegment.setRadarMode(context.readE8());
        jobRequestSegment.setRadarResolutionRange(context.readI16());
        jobRequestSegment.setRadarResolutionCrossRange(context.readI16());
        final int year = context.readI16();
        final int month = context.readI8();
        final int day = context.readI8();
        final int hour = context.readI8();
        final int minutes = context.readI8();
        final int seconds = context.readI8();
        ZonedDateTime earliestStartTime =
                ZonedDateTime.of(year, month, day, hour, minutes, seconds, 0, ZoneOffset.UTC);
        jobRequestSegment.setEarliestStartTime(earliestStartTime);
        jobRequestSegment.setStartTimeAllowedDelay(context.readI16());
        jobRequestSegment.setDuration(context.readI16());
        jobRequestSegment.setRevisitInterval(context.readI16());
        jobRequestSegment.setSensorIdType(context.readE8());
        jobRequestSegment.setSensorIdModel(context.readASCII(6));
        jobRequestSegment.setRequestType(context.readFL8());
        return jobRequestSegment;
    }
}
