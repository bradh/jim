package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Identified element.
 *
 * <p>This is shared implementation for classes that can be referred to by local (LID) or unique
 * (UID) identifier.
 */
public abstract class IdentifiedElement {

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

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private byte[] uid;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long lid;

    /**
     * Unique Identifier.
     *
     * <p>A UUID associated with a particular block of information.
     *
     * @return the unique identifier for this information as a byte array.
     */
    public byte[] getUid() {
        return uid;
    }

    /**
     * Unique Identifier as a UUID.
     *
     * <p>A UUID associated with a particular block of information.
     *
     * @return the unique identifier for this information as a UUID.
     */
    @JsonIgnore
    public UUID getUidAsUUID() {
        return arrayToUuid(uid);
    }

    /**
     * Set the Unique Identifier.
     *
     * <p>A UUID associated with a particular block of information.
     *
     * @param uid the unique identifier for this information as bytes.
     */
    public void setUid(byte[] uid) {
        this.uid = uid;
    }

    /**
     * Set the Unique Identifier from a UUID.
     *
     * <p>A UUID associated with a particular block of sensor information.
     *
     * @param uid the unique identifier for this information as a UUID.
     */
    @JsonIgnore
    public void setUidFromUUID(UUID uid) {
        setUid(uuidToArray(uid));
    }

    /**
     * Local Identifier.
     *
     * <p>A local ID associated with a particular block of information.
     *
     * @return the local identifier for this information.
     */
    public Long getLid() {
        return lid;
    }

    /**
     * Set the Local Identifier.
     *
     * <p>A local ID associated with a particular block of information.
     *
     * @param lid the local identifier for this information.
     */
    public void setLid(Long lid) {
        this.lid = lid;
    }
}
