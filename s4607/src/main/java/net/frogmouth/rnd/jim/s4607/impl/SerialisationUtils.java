package net.frogmouth.rnd.jim.s4607.impl;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/** Serialisation implementation utilities. */
public class SerialisationUtils {

    private static final byte SPACE = 0x20;

    /**
     * Serialise out a 32-bit signed (S32) integer value.
     *
     * @param value the value to serialise.
     * @return the value serialised in S32 format.
     */
    public static byte[] writeS32(int value) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(value);
        return bb.array();
    }

    private SerialisationUtils() {}

    /**
     * Serialise out a 32-bit binary angle (BA32) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in BA32 format.
     */
    public static byte[] writeBA32(double value) {
        double ba32 = value * 64.0 / 45.0 * Math.pow(2.0, 32 - 9);
        int rounded = (int) Math.round(ba32);
        return writeS32(rounded);
    }

    /**
     * Serialise out a 32-bit signed angle (SA32) value.
     *
     * @param value the value to serialise.
     * @return the value serialised in SA32 format.
     */
    public static byte[] writeSA32(double value) {
        double sa32 = value * 64.0 / 45.0 * Math.pow(2.0, 32 - 8);
        int rounded = (int) Math.round(sa32);
        return writeS32(rounded);
    }

    /**
     * Pad a string to a specified length.
     *
     * <p>If the string is longer than the specified length, it will be truncated to the specified
     * length.
     *
     * @param s the string to pad
     * @param length the length to pad to.
     * @return the string padded with spaces to the required length
     */
    public static byte[] padString(String s, final int length) {
        byte[] stringBytes = s.trim().getBytes(StandardCharsets.US_ASCII);
        int numBytesToCopy = stringBytes.length;
        if (numBytesToCopy > length) {
            numBytesToCopy = length;
        }
        byte[] stringBytesPadded = new byte[length];
        Arrays.fill(stringBytesPadded, SPACE);
        System.arraycopy(stringBytes, 0, stringBytesPadded, 0, numBytesToCopy);
        return stringBytesPadded;
    }

    /**
     * Serialise out an 8-bit enumeration (E8) value.
     *
     * @param enumvalue the value to serialise.
     * @return the value serialised in E8 format.
     */
    public static byte[] writeE8(int enumvalue) {
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte) enumvalue);
        return bb.array();
    }

    /**
     * Serialise out a 16-bit flags (FL16) value.
     *
     * @param flags the flags value to serialise.
     * @return the value serialised in FL16 format.
     */
    public static byte[] writeFL16(int flags) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.putShort((short) flags);
        return bb.array();
    }

    /**
     * Serialise out a 32-bit integer (I32) value.
     *
     * @param val the value to serialise.
     * @return the value serialised in I32 format.
     */
    public static byte[] writeI32(long val) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt((int) val);
        return bb.array();
    }
}
