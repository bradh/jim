package com.sigmabravo.rnd.jim.nitf.tre;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public abstract class AbstractTREParser {
    protected static final int UUID_LEN = 36;
    protected static final int UE13_LEN = 13;

    public abstract void init();

    public abstract String getTag();

    public abstract TRE parse(String tag, byte[] bytes);

    protected int readBCSN(byte[] bytes, int offset, int len) {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        return Integer.parseInt(s);
    }

    protected UUID readUUIDAsString(byte[] bytes, int offset) {
        String s = new String(bytes, offset, UUID_LEN, StandardCharsets.US_ASCII);
        return UUID.fromString(s);
    }

    protected String readBCSA(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, StandardCharsets.US_ASCII);
    }

    protected int readBCSNPI(byte[] bytes, int offset, int len) {
        return readBCSN(bytes, offset, len);
    }

    protected Double readUE13(byte[] bytes, int offset) {
        String s = new String(bytes, offset, UE13_LEN, StandardCharsets.US_ASCII);
        if (s.trim().equals("NaN")) {
            return null;
        }
        return Double.parseDouble(s);
    }
}
