package net.frogmouth.rnd.jim.s4607;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeaderSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentSerialiserManager;

/** STANAG 4607 / AEDP-7 GMTI Writer. */
public class Writer {
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    byte[] getBytes() {
        return baos.toByteArray();
    }

    void writePacket(Packet packet) {
        this.writePacket(packet, new SerialisationContext());
    }

    void writePacket(Packet packet, SerialisationContext serialisationContext) {
        PacketHeader packetHeader = packet.getPacketHeader();
        byte[] packetHeaderBytes =
                PacketHeaderSerialiser.serialise(packetHeader, serialisationContext);
        int packetLength = packetHeaderBytes.length;
        List<byte[]> bytesList = new ArrayList<>();
        for (Segment segment : packet.getSegments()) {
            byte[] segmentBytes = serialise(segment, serialisationContext);
            packetLength += segmentBytes.length;
            bytesList.add(segmentBytes);
        }
        ByteBuffer bb = ByteBuffer.wrap(packetHeaderBytes);
        bb.putInt(2, packetLength);
        baos.writeBytes(bb.array());
        bytesList.forEach(
                segmentBytes -> {
                    baos.writeBytes(segmentBytes);
                });
    }

    /**
     * Serialise the segment.
     *
     * @param segment the segment to serialise
     * @param serialisationContext the context providing configuration.
     * @return the byte array corresponding to the Segment.
     */
    static byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        AbstractSegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance().getSerialiser(segment.getSegmentType());
        byte[] segmentBytesWithoutHeader = serialiser.serialise(segment, serialisationContext);
        int len = segmentBytesWithoutHeader.length + 5;
        ByteBuffer bb = ByteBuffer.allocate(len);
        bb.put((byte) segment.getSegmentType().getTag());
        bb.putInt(len);
        bb.put(segmentBytesWithoutHeader, 0, segmentBytesWithoutHeader.length);
        return bb.array();
    }
}
