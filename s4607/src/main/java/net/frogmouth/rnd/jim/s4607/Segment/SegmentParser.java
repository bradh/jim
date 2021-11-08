package net.frogmouth.rnd.jim.s4607.Segment;

import net.frogmouth.rnd.jim.s4607.ParseContext;

public abstract class SegmentParser {

    protected ParseContext context;

    public final void setParseContext(ParseContext context) {
        this.context = context;
    }

    public abstract SegmentType getSegmentType();

    public abstract Segment parse(SegmentHeader segmentHeader);
}
