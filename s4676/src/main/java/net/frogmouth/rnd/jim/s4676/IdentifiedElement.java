package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.UUID;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Identified element.
 *
 * <p>This is shared implementation for classes that can be referred to by local (LID) or unique
 * (UID) identifier.
 */
public abstract class IdentifiedElement {

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "uid")
    private UniqueID uniqueID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long lid;

    /**
     * Unique Identifier.
     *
     * <p>A UUID and optional guide prefix associated with a particular block of information.
     *
     * @return the unique identifier for this information as a byte array.
     */
    public UniqueID getUniqueID() {
        return uniqueID;
    }

    /**
     * Unique Identifier as a UUID.
     *
     * <p>A UUID associated with a particular block of information.
     *
     * @return the unique identifier for this information as a UUID.
     */
    @JsonIgnore
    public UUID getUniqueIDAsUUID() {
        if (uniqueID == null) {
            return null;
        }
        return uniqueID.getAsUUID();
    }

    /**
     * Set the Unique Identifier.
     *
     * <p>A UUID and optional guide prefix associated with a particular block of information.
     *
     * @param uid the unique identifier for this information as bytes.
     */
    public void setUid(UniqueID uid) {
        this.uniqueID = uid;
    }

    /**
     * Set the Unique Identifier from a UUID.
     *
     * <p>A UUID associated with a particular block of sensor information.
     *
     * @param uuid the unique identifier for this information as a UUID.
     */
    @JsonIgnore
    public void setUidFromUUID(UUID uuid) {
        setUid(new UniqueID(uuid));
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
