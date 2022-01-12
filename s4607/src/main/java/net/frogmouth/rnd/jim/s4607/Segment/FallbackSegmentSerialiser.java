package net.frogmouth.rnd.jim.s4607.Segment;

import net.frogmouth.rnd.jim.s4607.SerialisationContext;

public class FallbackSegmentSerialiser extends AbstractSegmentSerialiser {

    public FallbackSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        throw new UnsupportedOperationException("Should never be called");
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationText) {
        return new byte[] {};
    }
}
