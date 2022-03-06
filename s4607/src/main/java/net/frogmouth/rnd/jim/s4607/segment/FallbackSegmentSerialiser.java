package net.frogmouth.rnd.jim.s4607.segment;

import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/**
 * Serialiser for {@link FallbackSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class FallbackSegmentSerialiser extends AbstractSegmentSerialiser {

    /** Constructor. */
    public FallbackSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        throw new UnsupportedOperationException("Should never be called");
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationText) {
        FallbackSegment fallbackSegment = (FallbackSegment) segment;
        return fallbackSegment.getUnparsedBytes();
    }
}
