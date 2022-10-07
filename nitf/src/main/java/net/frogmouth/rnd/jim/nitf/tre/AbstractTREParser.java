package net.frogmouth.rnd.jim.nitf.tre;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public abstract class AbstractTREParser {

    protected static final int UUID_LEN = 36;
    protected static final int UE13_LEN = 13;
    protected static final int TIMESTAMP_LEN = 24;
    protected static final int CETAG_LEN = 6;
    protected static final int CEL_LEN = 5;

    /**
     * Get the TRE tag that is supported by this parser.
     *
     * <p>This includes the version / revision. So for the BLOCKA TaggedRecordExtension, this is
     * "BLOCKA".
     *
     * @return the TaggedRecordExtension tag as a String.
     */
    public abstract String getTag();

    /**
     * Parse the TaggedRecordExtension from the given byte array.
     *
     * @param tag the TaggedRecordExtension tag.
     * @param bytes the byte array (not including the tag and length fields)
     * @return the TaggedRecordExtension parsed from the byte array.
     */
    public abstract TaggedRecordExtension parse(String tag, byte[] bytes);

    protected int readBCSN(byte[] bytes, int offset, int len) {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        return Integer.parseInt(s);
    }

    protected UUID readUUIDAsString(byte[] bytes, int offset) {
        String s = new String(bytes, offset, UUID_LEN, StandardCharsets.US_ASCII);
        return UUID.fromString(s);
    }

    protected String readTimeStampAsString(byte[] bytes, int offset) {
        return readBCSA(bytes, offset, TIMESTAMP_LEN);
    }

    protected String readBCSA(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, StandardCharsets.US_ASCII);
    }

    protected String readECSA(byte[] bytes, int offset, int len) {
        // TODO: this isn't right - need to do conversion
        return new String(bytes, offset, len, StandardCharsets.ISO_8859_1);
    }

    protected String readUTF8(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, StandardCharsets.UTF_8);
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

    protected int readBits24(byte[] bytes, int offset) {
        int val = 0;
        for (int i = 0; i < 3; i++) {
            int v = (bytes[offset + i] & 0xFF);
            val = (val << Byte.SIZE);
            val += v;
        }
        return val;
    }

    protected double readBCSNLatitude(byte[] bytes, int offset, int len) {
        double latitude = readDoubleFromBCSN(bytes, offset, len);
        return latitude;
    }

    protected double readBCSNLongitude(byte[] bytes, int offset, int len) {
        double longitude = readDoubleFromBCSN(bytes, offset, len);
        return longitude;
    }

    protected double readBCSNHeight(byte[] bytes, int offset, int len) {
        double ht = readDoubleFromBCSN(bytes, offset, len);
        return ht;
    }

    protected Double readECEF(byte[] bytes, int offset, int len) {
        double v = readDoubleOrNullFromBCSN(bytes, offset, len);
        return v;
    }

    protected Integer readIntegerOrNullFromBCSN(byte[] bytes, int offset, int len)
            throws NumberFormatException {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            return null;
        }
        return Integer.parseInt(s);
    }

    protected Double readDoubleOrNullFromBCSN(byte[] bytes, int offset, int len)
            throws NumberFormatException {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            return null;
        }
        return Double.parseDouble(s);
    }

    protected double readDoubleFromBCSN(byte[] bytes, int offset, int len)
            throws NumberFormatException {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        double latitude = Double.parseDouble(s);
        return latitude;
    }
}
