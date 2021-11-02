package com.sigmabravo.rnd.jim.s4607;

public abstract class Segment {
    private final SegmentHeader header;

    public Segment(SegmentHeader header) {
        this.header = header;
    }
}
