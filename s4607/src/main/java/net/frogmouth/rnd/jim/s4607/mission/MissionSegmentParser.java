package net.frogmouth.rnd.jim.s4607.mission;

import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link MissionSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class MissionSegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.MissionSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        MissionSegment missionSegment = new MissionSegment();
        missionSegment.setMissionPlan(context.readASCII(12));
        missionSegment.setFlightPlan(context.readASCII(12));
        missionSegment.setPlatformType(context.readE8());
        missionSegment.setPlatformConfiguration(context.readASCII(10));
        missionSegment.setYear(context.readI16());
        missionSegment.setMonth(context.readI8());
        missionSegment.setDay(context.readI8());
        return missionSegment;
    }
}
