package net.frogmouth.rnd.jim.nitf.tre;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import net.frogmouth.rnd.jim.charsets.ECS_A;

/**
 * Abstract Tagged Record Extension (TRE) parser.
 *
 * <p>Base class for TRE parsers.
 */
public abstract class AbstractTaggedRecordExtensionParser {

    /**
     * UUID field length.
     *
     * <p>This is the usual text representation length in bytes.
     */
    protected static final int UUID_LEN = 36;

    /**
     * Binary-encoded double field length.
     *
     * <p>Length in bytes.
     */
    protected static final int UE13_LEN = 13;

    /**
     * Timestamp field length.
     *
     * <p>Length in bytes.
     */
    protected static final int TIMESTAMP_LEN = 24;

    /**
     * Controlled Extension Tag (CETAG) field length.
     *
     * <p>Also applicable to Registered Extensions.
     *
     * <p>Length in bytes.
     */
    protected static final int CETAG_LEN = 6;

    /**
     * Controlled Extension Length (CEL) field length.
     *
     * <p>Also applicable to Registered Extensions.
     *
     * <p>Length in bytes.
     */
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

    /**
     * Read a BCS-N value.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading from
     * @param len the number of bytes to read
     * @return the integer equivalent to the BCS-N encoded value.
     */
    protected int readBCSN(byte[] bytes, int offset, int len) {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        return Integer.parseInt(s);
    }

    /**
     * Read a UUID from the string representation.
     *
     * <p>The string representation is an ASCII encoded 36 byte array, in canonical form.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading from
     * @return the corresponding UUID
     */
    protected UUID readUUIDAsString(byte[] bytes, int offset) {
        String s = new String(bytes, offset, UUID_LEN, StandardCharsets.US_ASCII);
        return UUID.fromString(s);
    }

    /**
     * Read a standard timestamp from the string representation.
     *
     * <p>Note that timestamps can (and sometimes are) space filled. As such, this may not give back
     * everything need to make a full date or date/time.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading from
     * @return the corresponding String.
     */
    protected String readTimeStampAsString(byte[] bytes, int offset) {
        return readBCSA(bytes, offset, TIMESTAMP_LEN);
    }

    /**
     * Read a BCS-A String value.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the String corresponding to the BCS-A encoded value
     */
    protected String readBCSA(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, StandardCharsets.US_ASCII);
    }

    /**
     * Read an ECS-A String value.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the String corresponding to the ECS-A encoded value
     */
    protected String readECSA(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, new ECS_A());
    }

    /**
     * Read a UTF-8 String value.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the String corresponding to the UTF-8 encoded value
     */
    protected String readUTF8(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, StandardCharsets.UTF_8);
    }

    /**
     * Read a BCS-N(PI) value.
     *
     * <p>This is BCS-N coded, positive integer.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the integer equivalent to the BCS-N encoded value.
     */
    protected int readBCSNPI(byte[] bytes, int offset, int len) {
        return readBCSN(bytes, offset, len);
    }

    protected Double readUE13(byte[] bytes, int offset) {
        String s = new String(bytes, offset, UE13_LEN, StandardCharsets.US_ASCII);
        if (s.trim().equals("NaN")) {
            return null;
        }
        return Double.valueOf(s);
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

    /**
     * Read a potentially-empty field as a BCS-N encoded integer.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the integer value, or null if the field is blank (space filled).
     * @throws NumberFormatException if the value could not be parsed.
     */
    protected Integer readIntegerOrNullFromBCSN(byte[] bytes, int offset, int len)
            throws NumberFormatException {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            return null;
        }
        return Integer.valueOf(s);
    }

    /**
     * Read a potentially-empty field as a BCS-N encoded double.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the double value, or null if the field is blank (space filled).
     * @throws NumberFormatException if the value could not be parsed.
     */
    protected Double readDoubleOrNullFromBCSN(byte[] bytes, int offset, int len)
            throws NumberFormatException {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            return null;
        }
        return Double.valueOf(s);
    }

    /**
     * Read a field as a BCS-N encoded double.
     *
     * @param bytes the byte array to read from
     * @param offset the offset into the byte array to start reading at
     * @param len the number of bytes to read
     * @return the double value
     * @throws NumberFormatException if the value could not be parsed.
     */
    protected double readDoubleFromBCSN(byte[] bytes, int offset, int len)
            throws NumberFormatException {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        double latitude = Double.parseDouble(s);
        return latitude;
    }
}
