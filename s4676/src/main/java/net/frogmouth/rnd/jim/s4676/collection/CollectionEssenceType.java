package net.frogmouth.rnd.jim.s4676.collection;

/**
 * Collection essence type.
 *
 * <p>The realistic/synthetic nature of the collection.
 */
public enum CollectionEssenceType implements ICollectionEssenceType {
    /**
     * Real.
     *
     * <p>The track data are derived from real sensor data.
     */
    REAL,
    /**
     * Simulated.
     *
     * <p>The track data were derived from digitally-simulated sensor data.
     */
    SIMULATED,
    /**
     * Synthetic.
     *
     * <p>These track data are a combination of REAL/SURROGATE and SIMULATED.
     */
    SYNTHETIC,
    /**
     * Surrogate.
     *
     * <p>These track data were derived from real sensor data from a similar but not identical
     * sensor/system.
     */
    SURROGATE
}
