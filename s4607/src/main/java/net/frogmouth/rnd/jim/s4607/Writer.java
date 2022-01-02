package net.frogmouth.rnd.jim.s4607;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeaderSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentSerialiser;

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
            byte[] segmentBytes = SegmentSerialiser.serialise(segment, serialisationContext);
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
}
