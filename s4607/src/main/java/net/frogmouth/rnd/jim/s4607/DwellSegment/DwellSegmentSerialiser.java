package net.frogmouth.rnd.jim.s4607.DwellSegment;

import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class DwellSegmentSerialiser extends AbstractSegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.DwellSegment;
    }

    @Override
    public byte[] serialise(Segment segment) {
        // TODO: proper implementation
        return new byte[75];
    }
}
