package net.frogmouth.rnd.jim.s4607.Segment;

public class FallbackSegmentSerialiser extends AbstractSegmentSerialiser {

    public FallbackSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        throw new UnsupportedOperationException(
                "Not supported yet."); // To change body of generated methods, choose Tools |
        // Templates.
    }

    @Override
    public byte[] serialise(Segment segment) {
        return new byte[] {};
    }
}
