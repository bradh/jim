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

    public boolean isUseSAProfileForEmptyDwellTargetMask() {
        return useSAProfileForEmptyDwellTargetMask;
    }

    public void setUseSAProfileForEmptyDwellTargetMask(
            boolean useSAProfileForEmptyDwellTargetMask) {
        this.useSAProfileForEmptyDwellTargetMask = useSAProfileForEmptyDwellTargetMask;
    }
}
