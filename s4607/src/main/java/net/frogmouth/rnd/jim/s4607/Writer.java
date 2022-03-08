package net.frogmouth.rnd.jim.s4607;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.impl.SerialisationUtils;
import net.frogmouth.rnd.jim.s4607.packet.Packet;
import net.frogmouth.rnd.jim.s4607.packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentSerialiserManager;

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
        byte[] packetHeaderBytes = serialise(packetHeader, serialisationContext);
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
        ISegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance().getSerialiser(segment.getSegmentType());
        byte[] segmentBytesWithoutHeader = serialiser.serialise(segment, serialisationContext);
        int len = segmentBytesWithoutHeader.length + 5;
        ByteBuffer bb = ByteBuffer.allocate(len);
        bb.put((byte) segment.getSegmentType().getTag());
        bb.putInt(len);
        bb.put(segmentBytesWithoutHeader, 0, segmentBytesWithoutHeader.length);
        return bb.array();
    }

    /**
     * Serialise the packet header to a byte array.
     *
     * <p>This static method provides encoding of a packet header to a byte array.
     *
     * <p>Note that the packet header includes a packet length (i.e. length is not known when the
     * header is serialised), and this needs to be overwritten when available.
     *
     * @param packetHeader the packet header to serialise.
     * @param serialisationContext the serialisation context to use.
     * @return byte array containing the serialised packet header.
     */
    public static byte[] serialise(
            PacketHeader packetHeader, SerialisationContext serialisationContext) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(packetHeader.getVersionId().getBytes(StandardCharsets.US_ASCII));
        // length will be patched in later
        baos.writeBytes(new byte[4]);
        baos.writeBytes(SerialisationUtils.padString(packetHeader.getNationality(), 2));
        baos.writeBytes(SerialisationUtils.writeE8(packetHeader.getClassification()));
        baos.writeBytes(SerialisationUtils.padString(packetHeader.getClassificationSystem(), 2));
        baos.writeBytes(SerialisationUtils.writeFL16(packetHeader.getClassificationCodeFlags()));
        baos.writeBytes(SerialisationUtils.writeE8(packetHeader.getExerciseIndicator()));
        baos.writeBytes(SerialisationUtils.padString(packetHeader.getPlatformId(), 10));
        baos.writeBytes(SerialisationUtils.writeI32(packetHeader.getMissionId()));
        baos.writeBytes(SerialisationUtils.writeI32(packetHeader.getJobId()));
        return baos.toByteArray();
    }
}
