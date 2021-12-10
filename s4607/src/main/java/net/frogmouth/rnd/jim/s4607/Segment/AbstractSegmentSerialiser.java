package net.frogmouth.rnd.jim.s4607.Segment;

import java.nio.ByteBuffer;

public abstract class AbstractSegmentSerialiser {

    public abstract SegmentType getSegmentType();

    public abstract byte[] serialise(Segment segment);

    protected static byte[] writeE8(int enumvalue) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) enumvalue);
        return bb.array();
    }

    protected static byte[] writeI16(int value) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.putShort((short) value);
        return bb.array();
    }

    protected static byte[] writeI8(int value) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) value);
        return bb.array();
    }
}
