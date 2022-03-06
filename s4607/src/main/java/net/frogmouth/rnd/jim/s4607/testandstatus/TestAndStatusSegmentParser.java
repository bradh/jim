package net.frogmouth.rnd.jim.s4607.testandstatus;

import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link TestAndStatusSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class TestAndStatusSegmentParser extends SegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.TestAndStatusSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        TestAndStatusSegment testAndStatusSegment = new TestAndStatusSegment();
        testAndStatusSegment.setJobId(context.readI32());
        testAndStatusSegment.setRevisitIndex(context.readI16());
        testAndStatusSegment.setDwellIndex(context.readI16());
        testAndStatusSegment.setDwellTime(context.readI32());
        testAndStatusSegment.setHardwareStatus(HardwareStatus.fromByte((byte) context.readFL8()));
        testAndStatusSegment.setModeStatus(ModeStatus.fromByte((byte) context.readFL8()));
        return testAndStatusSegment;
    }
}
