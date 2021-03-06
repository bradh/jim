package net.frogmouth.rnd.jim.s4607.segment;

import java.nio.ByteBuffer;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/**
 * Abstract serialiser for a given kind of Segment.
 *
 * <p>The segment serialiser is responsible for converting the segment into a byte array.
 *
 * <p>This will need to be sub-classed and implemented if a new Segment type is added. Instances of
 * concrete sub-classes are usually created by the serialisation code, and it should not be
 * necessary to instantiate these from user code.
 */
public abstract class AbstractSegmentSerialiser implements ISegmentSerialiser {

    private static final byte SPACE = 0x20;

    /**
     * Serialise the segment to a byte array using default context.
     *
     * @param segment the segment to serialise
     * @return byte array corresponding the body of the segment (not the header).
     */
    @Override
    public byte[] serialise(Segment segment) {
        return serialise(segment, new SerialisationContext());
    }

    /**
     * Serialise out an 8-bit enumeration (E8) value.
     *
     * @param enumvalue the value to serialise.
     * @return the value serialised in E8 format.
     */
    protected static byte[] writeE8(int enumvalue) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) enumvalue);
        return bb.array();
    }

    /**
     * Serialise out a 32-bit integer (I32) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in I32 format.
     */
    protected static byte[] writeI32(long value) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt((int) value);
        return bb.array();
    }

    /**
     * Serialise out a 16-bit integer (I16) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in I16 format.
     */
    protected static byte[] writeI16(int value) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.putShort((short) value);
        return bb.array();
    }

    /**
     * Serialise out an 8-bit integer (I8) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in I8 format.
     */
    protected static byte[] writeI8(int value) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) value);
        return bb.array();
    }

    /**
     * Serialise out an 8-bit flags (FL8) value.
     *
     * @param flags the flags value to serialise.
     * @return the value serialised in FL8 format.
     */
    protected static byte[] writeFL8(int flags) {
        return new byte[] {(byte) flags};
    }

    /**
     * Serialise out an 8-bit flags (FL8) value.
     *
     * @param b the boolean value to serialise.
     * @return the value serialised in FL8 format.
     */
    protected static byte[] writeFL8(boolean b) {
        if (b) {
            return new byte[] {0x01};
        } else {
            return new byte[] {0x00};
        }
    }

    /**
     * Serialise out a 16-bit binary angle (BA16) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in BA16 format.
     */
    protected static byte[] writeBA16(double value) {
        double ba16 = value * 64.0 / 45.0 * Math.pow(2.0, 16 - 9);
        int rounded = (int) Math.round(ba16);
        return writeS16(rounded);
    }

    /**
     * Serialise out a 16-bit signed angle (SA16) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in SA16 format.
     */
    protected static byte[] writeSA16(double value) {
        double sa16 = value * 64.0 / 45.0 * Math.pow(2.0, 16 - 8);
        int rounded = (int) Math.round(sa16);
        return writeS16(rounded);
    }

    /**
     * Serialise out a 16-bit signed (S16) integer value.
     *
     * @param value the value to serialise.
     * @return the value serialised in S16 format.
     */
    protected static byte[] writeS16(int value) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.putShort((short) value);
        return bb.array();
    }

    /**
     * Serialise out a 16-bit binary (B16) floating point value.
     *
     * @param value the value to serialise.
     * @return the value serialised in B16 format.
     */
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

    /**
     * Serialise out an 8-bit signed (S8) integer value.
     *
     * @param value the value to serialise.
     * @return the value serialised in S8 format.
     */
    protected static byte[] writeS8(int value) {
        return new byte[] {(byte) value};
    }
}
