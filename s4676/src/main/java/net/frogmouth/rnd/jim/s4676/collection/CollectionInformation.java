package net.frogmouth.rnd.jim.s4676.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;

/**
 * Collection Information.
 *
 * <p>The CollectionInformation class specifies high-level information about a collection from which
 * these tracking data were generated.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "id", "name", "shortName", "effectivity"})
public class CollectionInformation extends IdentifiedElement {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ICollectionIntentType intent;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ICollectionEssenceType essence;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "targetID")
    private String targetId;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes intent and essence.
     */
    private CollectionInformation() {}

    /**
     * Constructor.
     *
     * <p>There are two mandatory elements to the Collection Information - the collection intent,
     * and the collection essence.
     *
     * <p>Intent is the reason the collection was performed, or the high level mode the system was
     * operated in.
     *
     * <p>Essence is the realistic/synthetic nature of the collection.
     *
     * @param intent intent of collection
     * @param essence essence of collection
     */
    public CollectionInformation(ICollectionIntentType intent, ICollectionEssenceType essence) {
        this.intent = intent;
        this.essence = essence;
    }

    /**
     * Get the intent.
     *
     * <p>The reason the collection was performed, or the high level mode the system was operate in.
     *
     * @return the intent.
     */
    public ICollectionIntentType getIntent() {
        return intent;
    }

    /**
     * Set the intent.
     *
     * <p>The reason the collection was performed, or the high level mode the system was operate in.
     *
     * @param intent the intent.
     */
    public void setIntent(ICollectionIntentType intent) {
        this.intent = intent;
    }

    /**
     * Get the essence.
     *
     * <p>The realistic/synthetic nature of the collection.
     *
     * @return the essence.
     */
    public ICollectionEssenceType getEssence() {
        return essence;
    }

    /**
     * Set the essence.
     *
     * <p>The realistic/synthetic nature of the collection.
     *
     * @param essence the essence.
     */
    public void setEssence(ICollectionEssenceType essence) {
        this.essence = essence;
    }

    /**
     * Get the target ID.
     *
     * <p>An identifier for the primary target area of the collection.
     *
     * @return the target ID
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * Set the target ID.
     *
     * <p>An identifier for the primary target area of the collection.
     *
     * @param targetId the target ID
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
