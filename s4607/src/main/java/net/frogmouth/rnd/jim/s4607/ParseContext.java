package net.frogmouth.rnd.jim.s4607;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 * Parsing context.
 *
 * <p>This is used to provide state between parsing stages.
 */
public class ParseContext {

    private final MappedByteBuffer mappedByteBuffer;

    /**
     * Constructor.
     *
     * @param path the path to the file to load
     * @throws IOException if the file could not be loaded
     */
    public ParseContext(Path path) throws IOException {
        try (FileChannel fileChannel =
                (FileChannel) Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ))) {
            mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        }
    }

    /**
     * Test if the parse context has any bytes remaining.
     *
     * @return true if there is any bytes remaining, otherwise false.
     */
    boolean hasRemaining() {
        return mappedByteBuffer.hasRemaining();
    }

    /**
     * Get the current offset into the file.
     *
     * @return the current index position in bytes.
     */
    long position() {
        return mappedByteBuffer.position();
    }

    /**
     * Get a byte array.
     *
     * <p>The number of bytes read matches the size of the destination array.
     *
     * @param dest the destination array.
     */
    void get(byte[] dest) {
        mappedByteBuffer.get(dest);
    }

    /**
     * Get a single 8-bit byte.
     *
     * @return the byte as an integer value.
     */
    byte get() {
        return mappedByteBuffer.get();
    }

    /**
     * Read a 16 bit integer value.
     *
     * @return the integer value read.
     */
    int getShort() {
        return mappedByteBuffer.getShort();
    }

    /**
     * Read a 32 bit integer value.
     *
     * @return the integer value read.
     */
    int getInt() {
        return mappedByteBuffer.getInt();
    }

    /**
     * Read a 64 bit integer value.
     *
     * @return the integer value read.
     */
    long getLong() {
        return mappedByteBuffer.getLong();
    }

    /**
     * Read a specified number of bytes.
     *
     * @param len the number of bytes to read.
     * @return byte array corresponding to the bytes read.
     */
    public byte[] getBytes(int len) {
        byte[] dest = new byte[len];
        get(dest);
        return dest;
    }

    /**
     * Look-ahead a specified number of bytes.
     *
     * <p>This is like {@link getBytes}, but doesn't change the current offset.
     *
     * @param len the number of bytes to read
     * @return byte array corresponding to the bytes read.
     */
    // TODO: we possibly don't need this - maybe remove.
    public byte[] peekBytes(int len) {
        byte[] dest = new byte[len];
        int mark = mappedByteBuffer.position();
        get(dest);
        mappedByteBuffer.position(mark);
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
     * Read a 32 bit (S32) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public long readI32() {
        long i32 = getInt() & 0x00FFFFFFFFL;
        return i32;
    }

    /**
     * Read a signed 32 bit (S32) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readS32() {
        int s32 = getInt();
        return s32;
    }

    /**
     * Read a 16 bit (I16) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readI16() {
        int i16 = getShort() & 0x0000FFFF;
        return i16;
    }

    /**
     * Read a signed 16 bit (S16) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readS16() {
        int s16 = getShort();
        return s16;
    }

    /**
     * Read an 8 bit (I8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readI8() {
        int i8 = get() & 0x00FF;
        return i8;
    }

    /**
     * Read a signed 8 bit (S8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readS8() {
        int s8 = get();
        return s8;
    }

    /**
     * Read an enumerated 8 bit (E8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readE8() {
        int e8 = get() & 0x00FF;
        return e8;
    }

    /**
     * Read a 64 bit flags (FL64) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public long readFL64() {
        return getLong();
    }

    /**
     * Read a 16 bit flags (FL16) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    public int readFL16() {
        return getShort() & 0x0000FFFF;
    }

    /**
     * Read an 8 bit flags (FL8) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
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
    public double readB16() {
        int i = readI16();
        boolean negative = (i & 0x8000) == 0x8000;
        int magnitude = (i & 0x7F80) >> 7;
        int fraction = (i & 0x7F);
        double d = magnitude + (fraction / 128.0);
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
    public double readSA32() {
        long i = readI32();
        boolean negative = (i & 0x80000000) == 0x80000000;
        int magnitude = (int) (i & 0x7FFFFFFF);
        double d = magnitude * 1.40625 / Math.pow(2, 32 - 7);
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    /**
     * Read a SA16 encoded value from the parse context.
     *
     * <p>SA16 is a 16 bit binary signed angle value.
     *
     * @return the decoded value
     */
    public double readSA16() {
        long i = readI16();
        boolean negative = (i & 0x8000) == 0x8000;
        int magnitude = (int) (i & 0x7FFF);
        double d = magnitude * 1.40625 / Math.pow(2, 16 - 7);
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    /**
     * Skip over a specified number of bytes.
     *
     * <p>The intermediate bytes are ignored.
     *
     * @param bytesToSkip the number of bytes to skip over.
     */
    public void skipBytes(long bytesToSkip) {
        long currentPosition = mappedByteBuffer.position();
        mappedByteBuffer.position((int) (currentPosition + bytesToSkip));
    }
}
