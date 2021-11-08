package net.frogmouth.rnd.jim.s4607.FreeTextSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class FreeTextSegmentParser extends SegmentParser {

    public FreeTextSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.FreeTextSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        FreeTextSegment freeTextSegment = new FreeTextSegment(segmentHeader);
        freeTextSegment.setOriginatorId(context.readASCII(10));
        freeTextSegment.setRecipientId(context.readASCII(10));
        int remainingBytes = (int) (segmentHeader.getSegmentSize() - 25);
        freeTextSegment.setFreeText(context.readASCII(remainingBytes));
        return freeTextSegment;
    }
}
