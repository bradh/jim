package net.frogmouth.rnd.jim.s4607.Segment;

import java.nio.ByteBuffer;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/**
 * Segment serialiser.
 *
 * <p>This takes a segment and a serialisation context, which is basically the configuration for
 * serialisation. It produces a byte array corresponding to the segment.
 */
public class SegmentSerialiser {

    /**
     * Serialise the segment.
     *
     * @param segment the segment to serialise
     * @param serialisationContext the context providing configuration.
     * @return the byte array corresponding to the Segment.
     */
    public static byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        AbstractSegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance().getParser(segment.getSegmentType());
        byte[] segmentBytesWithoutHeader = serialiser.serialise(segment, serialisationContext);
        int len = segmentBytesWithoutHeader.length + 5;
        ByteBuffer bb = ByteBuffer.allocate(len);
        bb.put((byte) segment.getSegmentType().getTag());
        bb.putInt(len);
        bb.put(segmentBytesWithoutHeader, 0, segmentBytesWithoutHeader.length);
        return bb.array();
    }
}
