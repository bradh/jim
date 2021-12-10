package net.frogmouth.rnd.jim.s4607.Segment;

import java.nio.ByteBuffer;

public class SegmentSerialiser {

    public static byte[] serialise(Segment segment) {
        SegmentHeader segmentHeader = segment.getSegmentHeader();
        AbstractSegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance().getParser(segmentHeader.getSegmentType());
        byte[] segmentBytesWithoutHeader = serialiser.serialise(segment);
        int len = segmentBytesWithoutHeader.length + 5;
        ByteBuffer bb = ByteBuffer.allocate(len);
        bb.put((byte) segmentHeader.getSegmentType().getTag());
        bb.putInt(len);
        bb.put(segmentBytesWithoutHeader, 0, segmentBytesWithoutHeader.length);
        return bb.array();
    }
}
