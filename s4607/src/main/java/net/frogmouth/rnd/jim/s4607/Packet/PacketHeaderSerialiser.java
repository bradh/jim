package net.frogmouth.rnd.jim.s4607.Packet;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class PacketHeaderSerialiser {

    public static byte[] serialise(PacketHeader packetHeader) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(packetHeader.getVersionId().getBytes(StandardCharsets.US_ASCII));
        // length will be patched in later
        baos.writeBytes(new byte[4]);
        baos.writeBytes(packetHeader.getNationality().getBytes(StandardCharsets.US_ASCII));
        baos.writeBytes(writeE8(packetHeader.getClassification()));
        baos.writeBytes(packetHeader.getClassificationSystem().getBytes(StandardCharsets.US_ASCII));
        baos.writeBytes(writeFL16(packetHeader.getClassificationCodeFlags()));
        baos.writeBytes(writeE8(packetHeader.getExerciseIndicator()));
        baos.writeBytes(packetHeader.getPlatformId().getBytes(StandardCharsets.US_ASCII));
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
}
