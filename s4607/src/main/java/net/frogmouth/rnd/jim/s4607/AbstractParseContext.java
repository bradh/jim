package net.frogmouth.rnd.jim.s4607;

import java.nio.charset.StandardCharsets;

/**
 * Parsing context.
 *
 * <p>This is used to provide state between parsing stages.
 */
public abstract class AbstractParseContext implements IParseContext {

    /**
     * Get a byte array.
     *
     * <p>The number of bytes read matches the size of the destination array.
     *
     * @param dest the destination array.
     */
    abstract void get(byte[] dest);

    /**
     * Get a single 8-bit byte.
     *
     * @return the byte as an integer value.
     */
    abstract byte get();

    /**
     * Read a 16 bit integer value.
     *
     * @return the integer value read.
     */
    abstract int getShort();

    /**
     * Read a 32 bit integer value.
     *
     * @return the integer value read.
     */
    abstract int getInt();

    /**
     * Read a 64 bit integer value.
     *
     * @return the integer value read.
     */
    abstract long getLong();

    /**
     * Read a specified number of bytes.
     *
     * @param len the number of bytes to read.
     * @return byte array corresponding to the bytes read.
     */
    @Override
    public byte[] getBytes(int len) {
        byte[] dest = new byte[len];
        get(dest);
        return dest;
    }

    /**
     * Read a specified number of bytes as an ASCII string.
     *
     * <p>If there is an embedded null (0x00), the reading stops, and the remaining bytes are space
     * filled. This is to tolerate files that contain C-style strings.
     *
     * @param numBytes the number of bytes (or characters) to read.
     * @return String equivalent to the specified number of bytes
     */
    @Override
    public String readASCII(int numBytes) {
        byte[] bytes = getBytes(numBytes);
        int indexOfLastValidByte = 0;
        for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] == 0x00) {
                break;
            }
            indexOfLastValidByte = i;
        }
        String cleanString =
                new String(bytes, 0, indexOfLastValidByte + 1, StandardCharsets.US_ASCII);
        return String.format("%-" + numBytes + "s", cleanString);
    }

    /**
     * Read a 32 bit (I32) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public long readI32() {
        long i32 = getInt() & 0x00FFFFFFFFL;
        return i32;
    }

    /**
     * Read a signed 32 bit (S32) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readS32() {
        int s32 = getInt();
        return s32;
    }

    /**
     * Read a 16 bit (I16) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readI16() {
        int i16 = getShort() & 0x0000FFFF;
        return i16;
    }

    /**
     * Read a signed 16 bit (S16) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readS16() {
        int s16 = getShort();
        return s16;
    }

    /**
     * Read an 8 bit (I8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readI8() {
        int i8 = get() & 0x00FF;
        return i8;
    }

    /**
     * Read a signed 8 bit (S8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readS8() {
        int s8 = get();
        return s8;
    }

    /**
     * Read an enumerated 8 bit (E8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readE8() {
        int e8 = get() & 0x00FF;
        return e8;
    }

    /**
     * Read a 64 bit flags (FL64) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public long readFL64() {
        return getLong();
    }

    /**
     * Read a 16 bit flags (FL16) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readFL16() {
        return getShort() & 0x0000FFFF;
    }

    /**
     * Read an 8 bit flags (FL8) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    @Override
    public int readFL8() {
        return get() & 0x00FF;
    }

    /**
     * Read a BA32 encoded value from the parse context.
     *
     * <p>BA32 is a 32 bit binary angle value.
     *
     * @return the decoded binary angle value
     */
    @Override
    public double readBA32() {
        long i = readI32();
        double d = i * 1.40625 / Math.pow(2, 32 - 8);
        return d;
    }

    /**
     * Read a BA16 encoded value from the parse context.
     *
     * <p>BA16 is a 16 bit binary angle value.
     *
     * @return the decoded binary angle value
     */
    @Override
    public double readBA16() {
        long i = readI16();
        double d = i * 1.40625 / Math.pow(2, 16 - 8);
        return d;
    }

    /**
     * Read a B16 encoded value from the parse context.
     *
     * <p>B16 is a 16 bit binary value.
     *
     * @return the decoded value
     */
    @Override
    public double readB16() {
        int i = readI16();
        boolean negative = (i & 0x8000) == 0x8000;
        int magnitude = (i & 0x7F80) >> 7;
        int fraction = i & 0x7F;
        double d = magnitude + (fraction / 128.0);
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    /**
     * Read a B32 encoded value from the parse context.
     *
     * <p>B32 is a 32 bit binary value (1 bit sign, 8 bit integer + 23 bit fraction).
     *
     * @return the decoded value
     */
    @Override
    public double readB32() {
        long i = readI32();
        boolean negative = (i & 0x80000000L) == 0x80000000L;
        int magnitude = (int) ((i & 0x7F800000L) >> 23);
        int fraction = (int) (i & 0x7FFFFFL);
        double d = magnitude + (fraction / Math.pow(2, 23));
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    /**
     * Read a H32 encoded value from the parse context.
     *
     * <p>H32 is a 32 bit binary value (1 bit sign, 15 bit integer + 16 bit fraction).
     *
     * @return the decoded value
     */
    @Override
    public double readH32() {
        long i = readI32();
        boolean negative = (i & 0x80000000L) == 0x80000000L;
        int magnitude = (int) ((i & 0x7FFF0000L) >> 16);
        int fraction = (int) (i & 0x00FFFF);
        double d = magnitude + (fraction / Math.pow(2, 16));
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    /**
     * Read a SA32 encoded value from the parse context.
     *
     * <p>SA32 is a 32 bit binary signed angle value.
     *
     * @return the decoded value
     */
    @Override
    public double readSA32() {
        long i = readS32();
        double d = i * 1.40625 / Math.pow(2, 32 - 7);
        return d;
    }

    /**
     * Read a SA16 encoded value from the parse context.
     *
     * <p>SA16 is a 16 bit binary signed angle value.
     *
     * @return the decoded value
     */
    @Override
    public double readSA16() {
        long i = readS16();
        double d = i * 1.40625 / Math.pow(2, 16 - 7);
        return d;
    }
}
