package net.frogmouth.rnd.jim.s4607.Segment;

/**
 * Segment that represents unknown data.
 *
 * <p>This is used as a placeholder in the event of parsing an unsupported segment. It should not be
 * used for other purposes.
 */
public class FallbackSegment extends Segment {

    /** Constructor. */
    FallbackSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.Unknown;
    }
}
