package net.frogmouth.rnd.jim.s4607.segment;

/**
 * Segment header.
 *
 * <p>All segments start with the same kind of header, which identifies the type of the segment, and
 * the length of the segment. This class represents that header information.
 */
public class SegmentHeader {
    private final SegmentType segmentType;
    private final long segmentSize;

    /**
     * Constructor.
     *
     * @param segmentType the type of the segment
     * @param segmentSize the length of the segment in bytes, including the 5 bytes in the header.
     */
    public SegmentHeader(SegmentType segmentType, long segmentSize) {
        this.segmentType = segmentType;
        this.segmentSize = segmentSize;
    }

    /**
     * The type of segment.
     *
     * @return the segment as an enumeration value.
     */
    public SegmentType getSegmentType() {
        return segmentType;
    }

    /**
     * The length of the segment.
     *
     * @return the length of the segment in bytes, including the 5 bytes in the header.
     */
    public long getSegmentSize() {
        return segmentSize;
    }
}
