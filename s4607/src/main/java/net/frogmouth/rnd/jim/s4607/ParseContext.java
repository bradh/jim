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

    public ParseContext(Path path) throws IOException {
        try (FileChannel fileChannel =
                (FileChannel) Files.newByteChannel(path, EnumSet.of(StandardOpenOption.READ))) {
            mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        }
    }

    boolean hasRemaining() {
        return mappedByteBuffer.hasRemaining();
    }

    long position() {
        return mappedByteBuffer.position();
    }

    void get(byte[] dest) {
        mappedByteBuffer.get(dest);
    }

    int get() {
        return mappedByteBuffer.get();
    }

    int getInt() {
        return mappedByteBuffer.getInt();
    }

    long getLong() {
        return mappedByteBuffer.getLong();
    }

    int getShort() {
        return mappedByteBuffer.getShort();
    }

    public byte[] getBytes(int len) {
        byte[] dest = new byte[len];
        get(dest);
        return dest;
    }

    public byte[] peekBytes(int len) {
        byte[] dest = new byte[len];
        int mark = mappedByteBuffer.position();
        get(dest);
        mappedByteBuffer.position(mark);
        return dest;
    }

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

    public long readI32() {
        long i32 = getInt() & 0x00FFFFFFFFL;
        return i32;
    }

    public int readS32() {
        int s32 = getInt();
        return s32;
    }

    public int readI16() {
        int i16 = getShort() & 0x0000FFFF;
        return i16;
    }

    public int readS16() {
        int s16 = getShort();
        return s16;
    }

    public int readI8() {
        int i8 = get() & 0x00FF;
        return i8;
    }

    public int readS8() {
        int s8 = get();
        return s8;
    }

    public int readE8() {
        int e8 = get() & 0x00FF;
        return e8;
    }

    public long readFL64() {
        return getLong();
    }

    public int readFL16() {
        return getShort() & 0x0000FFFF;
    }

    public int readFL8() {
        return get() & 0x00FF;
    }

    public double readBA32() {
        long i = readI32();
        double d = i * 1.40625 / Math.pow(2, 32 - 8);
        return d;
    }

    public double readBA16() {
        long i = readI16();
        double d = i * 1.40625 / Math.pow(2, 16 - 8);
        return d;
    }

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

    public void skipBytes(long bytesToSkip) {
        long currentPosition = mappedByteBuffer.position();
        mappedByteBuffer.position((int) (currentPosition + bytesToSkip));
    }
}
