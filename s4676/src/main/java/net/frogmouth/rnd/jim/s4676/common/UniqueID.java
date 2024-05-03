package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

/**
 * Unique Identifier.
 *
 * <p>This corresponds to the UUID class in NITS, but is named to allow conversion to a standard
 * {@link java.util.UUID}.
 *
 * <p>A universally unique identifier, conformant to ITU-T Rec. X.667 | ISO/IEC 9834-8:2005. The
 * core value of the UUID is a 128-bit number, although the exact syntax on a data stream is
 * dependent on the underlying syntax.
 *
 * <p>In addition, the UUID class supports extension to allow conformance to the US Office of the
 * Director of National Intelligence IC Technical Specification Intelligence Community (IC)
 * Identifier. An IC identifier combines a universally unique identifier (usually a simple UUID)
 * with a “guide prefix”, a simple numeric unsigned integer. That guide prefix is specified through
 * the “gidp” attribute, per the following pattern to form a fully conformant IC Identifier: {@code
 * guide://<gidp>/<UUID class value>}
 */
public class UniqueID {
    /**
     * Convert a byte array to a UUID.
     *
     * @param bytes the byte array
     * @return UUID corresponding to the byte array
     */
    public static UUID arrayToUuid(byte[] bytes) {
        if (16 != bytes.length) {
            throw new IllegalArgumentException("Too few bytes available to read UUID");
        }
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return new UUID(bb.getLong(), bb.getLong());
    }

    /**
     * Get the content of a UUID as a byte array.
     *
     * @param uuid the UUID to convert
     * @return the equivalent value as a byte array.
     */
    public static byte[] uuidToArray(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    @JacksonXmlProperty(isAttribute = true)
    private Long gidp;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonValue
    private byte[] uid;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a UUID.
     */
    private UniqueID() {}

    private UniqueID(String encodedBytes) {
        this.uid = Base64.getDecoder().decode(encodedBytes);
    }

    /**
     * Construct a unique identifier from a UUID.
     *
     * @param uuid the UUID
     */
    public UniqueID(UUID uuid) {
        uid = uuidToArray(uuid);
    }

    /**
     * Guide prefix.
     *
     * <p>The IC Identifier Guide Prefix.
     *
     * @return the prefix
     */
    public Long getGidp() {
        return gidp;
    }

    /**
     * Set the guide prefix.
     *
     * <p>The IC Identifier Guide Prefix.
     *
     * @param gidp the prefix
     */
    public void setGidp(Long gidp) {
        this.gidp = gidp;
    }

    /**
     * Unique identifier.
     *
     * <p>A 128-bit universally unique identifier, conforming to ITU-T Rec. X.667 | ISO/IEC
     * 9834-8:2005.
     *
     * @return the identifier as a byte array
     */
    public byte[] getUid() {
        return uid;
    }

    /**
     * Set the unique identifier.
     *
     * <p>A 128-bit universally unique identifier, conforming to ITU-T Rec. X.667 | ISO/IEC
     * 9834-8:2005.
     *
     * @param uid the identifier as a byte array
     */
    public void setUid(byte[] uid) {
        this.uid = uid;
    }

    /**
     * Get the identifier as a UUID.
     *
     * <p>This ignores the optional IC Identifier Guide prefix.
     *
     * @return the unique identifier as a UUID
     */
    @JsonIgnore
    public UUID getAsUUID() {
        if (uid == null) {
            return null;
        }
        return arrayToUuid(uid);
    }
}
