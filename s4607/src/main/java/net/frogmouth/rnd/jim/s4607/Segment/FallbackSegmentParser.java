package net.frogmouth.rnd.jim.s4607.Segment;

public class FallbackSegmentParser extends SegmentParser {

    public FallbackSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.FreeTextSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        FallbackSegment segment = new FallbackSegment();
        context.skipBytes(segmentHeader.getSegmentSize() - 5);
        return segment;
    }
}
