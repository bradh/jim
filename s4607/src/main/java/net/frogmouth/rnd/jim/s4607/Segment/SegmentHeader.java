package net.frogmouth.rnd.jim.s4607.Segment;

public class SegmentHeader {
    private final SegmentType segmentType;
    private final long segmentSize;

    public SegmentHeader(SegmentType segmentType, long segmentSize) {
        this.segmentType = segmentType;
        this.segmentSize = segmentSize;
    }

    public SegmentType getSegmentType() {
        return segmentType;
    }

    public long getSegmentSize() {
        return segmentSize;
    }
}
