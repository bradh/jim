package com.sigmabravo.rnd.jim.npif.tables;

import java.nio.MappedByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public abstract class DataTableParser {

    public void init() {};

    public abstract boolean canHandle(final int sourceAddress, final int fileAddress);

    public abstract DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header);

    protected String readASCII(MappedByteBuffer mappedByteBuffer, int offset, int len) {
        byte[] bytes = new byte[len];
        mappedByteBuffer.position(offset).get(bytes);
        String s = new String(bytes, StandardCharsets.US_ASCII).trim();
        // System.out.println(s);
        return s;
    }

    protected ZonedDateTime readDTG(MappedByteBuffer mappedByteBuffer, int offset, int i) {
        int year = mappedByteBuffer.position(offset).getShort();
        int month = mappedByteBuffer.get();
        int day = mappedByteBuffer.get();
        int hour = mappedByteBuffer.get();
        int min = mappedByteBuffer.get();
        int milliseconds = mappedByteBuffer.getShort();
        if ((year == 0)
                && (month == 0)
                && (day == 0)
                && (hour == 0)
                && (min == 0)
                && (milliseconds == 0)) {
            return null;
        }
        int sec = milliseconds / 1000;
        int millis = milliseconds % 1000;

        ZonedDateTime zdt =
                ZonedDateTime.of(
                        year, month, day, hour, min, sec, millis * 1000 * 1000, ZoneOffset.UTC);
        return zdt;
    }

    protected int readUnsignedBinary(MappedByteBuffer mappedByteBuffer, int offset, int len) {
        switch (len) {
            case 1:
                {
                    int res = mappedByteBuffer.position(offset).get();
                    // System.out.println(res);
                    return res;
                }
            case 2:
                {
                    int res = mappedByteBuffer.position(offset).getShort();
                    // System.out.println(res);
                    return res;
                }
            case 4:
                {
                    int res = mappedByteBuffer.position(offset).getInt();
                    // System.out.println(res);
                    return res;
                }
            default:
                throw new RuntimeException("Missing readUnsignedBinary() len: " + len);
        }
    }

    protected double readDouble(MappedByteBuffer mappedByteBuffer, int offset, int len) {
        switch (len) {
            case 8:
                {
                    double res = mappedByteBuffer.position(offset).getDouble();
                    // System.out.println(res);
                    return res;
                }
            default:
                throw new RuntimeException();
        }
    }

    protected Position readPosition(MappedByteBuffer mappedByteBuffer, int offset) {
        double latRadians = readDouble(mappedByteBuffer, offset, 8);
        offset += 8;
        double lonRadians = readDouble(mappedByteBuffer, offset, 8);
        offset += 8;
        Position position = new Position();
        position.setLatitudeRadians(latRadians);
        position.setLongitudeRadians(lonRadians);
        return position;
    }
}
