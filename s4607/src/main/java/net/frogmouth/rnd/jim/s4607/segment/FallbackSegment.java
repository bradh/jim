package net.frogmouth.rnd.jim.s4607.segment;

/**
 * Segment that represents unknown data.
 *
 * <p>This is used as a placeholder in the event of parsing an unsupported segment. It should not be
 * used for other purposes.
 */
public class FallbackSegment extends Segment {

    private byte[] unparsedBytes;

    /** Constructor. */
    FallbackSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.Unknown;
    }

    /**
     * Get the unparsed bytes from this segment.
     *
     * @return copy of the byte array of the unparsed content.
     */
    public byte[] getUnparsedBytes() {
        return unparsedBytes.clone();
    }

    /**
     * Set the unparsed bytes for this segment.
     *
     * @param unparsedBytes the unparsed content as a byte array.
     */
    public void setUnparsedBytes(byte[] unparsedBytes) {
        this.unparsedBytes = unparsedBytes.clone();
    }
}
