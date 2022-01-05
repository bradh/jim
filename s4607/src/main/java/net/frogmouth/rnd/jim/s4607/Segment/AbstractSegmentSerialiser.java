package net.frogmouth.rnd.jim.s4607.Segment;

import java.nio.ByteBuffer;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

public abstract class AbstractSegmentSerialiser {

    public abstract SegmentType getSegmentType();

    public abstract byte[] serialise(Segment segment, SerialisationContext serialisationText);

    protected static byte[] writeE8(int enumvalue) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) enumvalue);
        return bb.array();
    }

    protected static byte[] writeI32(long value) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt((int) value);
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

    protected static byte[] writeFL8(int flags) {
        return new byte[] {(byte) flags};
    }

    protected static byte[] writeFL8(boolean b) {
        if (b) {
            return new byte[] {0x01};
        } else {
            return new byte[] {0x00};
        }
    }

    protected static byte[] writeBA32(double value) {
        double ba32 = value * 64.0 / 45.0 * Math.pow(2.0, 32 - 9);
        int rounded = (int) Math.round(ba32);
        return writeS32(rounded);
    }

    protected static byte[] writeBA16(double value) {
        double ba16 = value * 64.0 / 45.0 * Math.pow(2.0, 16 - 9);
        int rounded = (int) Math.round(ba16);
        return writeS16(rounded);
    }

    protected static byte[] writeSA32(double value) {
        double sa32 = value * 64.0 / 45.0 * Math.pow(2.0, 32 - 8);
        int rounded = (int) Math.round(sa32);
        return writeS32(rounded);
    }

    protected static byte[] writeSA16(double value) {
        double sa16 = value * 64.0 / 45.0 * Math.pow(2.0, 16 - 8);
        int rounded = (int) Math.round(sa16);
        return writeS16(rounded);
    }

    protected static byte[] writeS32(int value) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(value);
        return bb.array();
    }

    protected static byte[] writeS16(int value) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.putShort((short) value);
        return bb.array();
    }

    protected static byte[] writeB16(double value) {
        boolean isNegative = value < 0;
        double magnitude = Math.abs(value);
        int intPart = (int) magnitude;
        double fracPart = magnitude - intPart;
        int fracInt = (int) (fracPart * Math.pow(2, 7));
        short res = (short) ((intPart << 7) + fracInt);
        byte[] enc = writeS16(res);
        if (isNegative) {
            enc[0] |= (byte) (0x80);
        }
        return enc;
    }

    protected static byte[] writeS8(int value) {
        return new byte[] {(byte) value};
    }
}
