package net.frogmouth.rnd.jim.s4607.packet;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/** Serialiser for packet header. */
public class PacketHeaderSerialiser {

    private static final byte SPACE = 0x20;

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
        baos.writeBytes(padString(packetHeader.getNationality(), 2));
        baos.writeBytes(writeE8(packetHeader.getClassification()));
        baos.writeBytes(padString(packetHeader.getClassificationSystem(), 2));
        baos.writeBytes(writeFL16(packetHeader.getClassificationCodeFlags()));
        baos.writeBytes(writeE8(packetHeader.getExerciseIndicator()));
        baos.writeBytes(padString(packetHeader.getPlatformId(), 10));
        baos.writeBytes(writeI32(packetHeader.getMissionId()));
        baos.writeBytes(writeI32(packetHeader.getJobId()));
        return baos.toByteArray();
    }

    private static byte[] writeE8(int enumvalue) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) enumvalue);
        return bb.array();
    }

    private static byte[] writeFL16(int flags) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.putShort((short) flags);
        return bb.array();
    }

    private static byte[] writeI32(long val) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt((int) val);
        return bb.array();
    }

    private static byte[] padString(String s, int length) {
        byte[] stringBytes = s.trim().getBytes(StandardCharsets.US_ASCII);
        if (s.length() > length) {
            throw new IllegalArgumentException("String is too long for specified length");
        }
        byte[] stringBytesPadded = new byte[length];
        Arrays.fill(stringBytesPadded, SPACE);
        System.arraycopy(stringBytes, 0, stringBytesPadded, 0, stringBytes.length);
        return stringBytesPadded;
    }
}
