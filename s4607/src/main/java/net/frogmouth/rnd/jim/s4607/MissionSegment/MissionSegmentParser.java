package net.frogmouth.rnd.jim.s4607.MissionSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class MissionSegmentParser extends SegmentParser {

    public MissionSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.MissionSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        MissionSegment missionSegment = new MissionSegment(segmentHeader);
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
