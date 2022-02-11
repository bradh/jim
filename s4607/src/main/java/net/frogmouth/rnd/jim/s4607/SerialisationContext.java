package net.frogmouth.rnd.jim.s4607;

/**
 * Serialisation settings.
 *
 * <p>In general, default options should be fine.
 */
public class SerialisationContext {

    private boolean useSAProfileForEmptyDwellTargetMask;

    /** Constructor. */
    public SerialisationContext() {}

    /**
     * Whether dwell target mask should match the SA profile.
     *
     * @return true for SA profile, otherwise false.
     */
    public boolean isUseSAProfileForEmptyDwellTargetMask() {
        return useSAProfileForEmptyDwellTargetMask;
    }

    /**
     * Set whether the Dwell Target Mask should use the SA profile.
     *
     * <p>This is a (possibly temporary) setting hack to match the AFRL test data behaviour. The
     * target mask doesn't actually matter if there are no targets.
     *
     * @param useSAProfileForEmptyDwellTargetMask true to use SA profile.
     */
    public void setUseSAProfileForEmptyDwellTargetMask(
            boolean useSAProfileForEmptyDwellTargetMask) {
        this.useSAProfileForEmptyDwellTargetMask = useSAProfileForEmptyDwellTargetMask;
    }
}
