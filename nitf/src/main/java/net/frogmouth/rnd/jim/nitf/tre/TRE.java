package net.frogmouth.rnd.jim.nitf.tre;

/**
 * Abstract Tagged Registered Extension (TRE).
 *
 * <p>All TRE implementations should extend this class.
 */
public abstract class TRE extends TreePart {
    private String tag;

    /**
     * Constructor.
     *
     * @param tag the TRE tag (including version, if any) identifier.
     */
    public TRE(String tag) {
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
