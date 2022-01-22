package net.frogmouth.rnd.jim.s4607.Segment;

/**
 * Parser for unknown segments.
 *
 * <p>This is used when no other parser matches. It does not produce a valid segment, and should not
 * be created manually.
 */
public class FallbackSegmentParser extends SegmentParser {

    /** Constructor. */
    public FallbackSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.Unknown;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        FallbackSegment segment = new FallbackSegment();
        context.skipBytes(segmentHeader.getSegmentSize() - 5);
        return segment;
    }
}
