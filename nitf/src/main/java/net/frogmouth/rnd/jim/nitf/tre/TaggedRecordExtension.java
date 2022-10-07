package net.frogmouth.rnd.jim.nitf.tre;

/**
 * Abstract Tagged Registered Extension (TRE).
 *
 * <p>All TRE implementations should extend this class.
 */
public abstract class TaggedRecordExtension extends TreePart {
    private final String tag;

    /**
     * Constructor.
     *
     * @param tag the TRE tag (including version, if any) identifier.
     */
    public TaggedRecordExtension(String tag) {
        this.tag = tag;
    }

    /**
     * Get the TRE tag.
     *
     * @return the TRE tag (including version, if any)
     */
    public String getTag() {
        return tag;
    }
}
