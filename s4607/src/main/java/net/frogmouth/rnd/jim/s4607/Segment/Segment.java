package net.frogmouth.rnd.jim.s4607.Segment;

public abstract class Segment {
    private final SegmentHeader header;

    public Segment(SegmentHeader header) {
        this.header = header;
    }

    public SegmentHeader getSegmentHeader() {
        return header;
    }
}
