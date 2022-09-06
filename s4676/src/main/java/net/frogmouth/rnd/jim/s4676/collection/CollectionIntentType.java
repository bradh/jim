package net.frogmouth.rnd.jim.s4676.collection;

/**
 * Collection intent type.
 *
 * <p>The reason the collection was performed.
 */
public enum CollectionIntentType implements ICollectionIntentType {
    /**
     * Operational.
     *
     * <p>The data was collected in an operational mode.
     */
    OPERATIONAL,
    /**
     * Exercise.
     *
     * <p>The data was collected as part of an exercise.
     */
    EXERCISE,
    /**
     * Test.
     *
     * <p>The data was collected as part of a test or demonstration.
     */
    TEST,
    /**
     * Engineering.
     *
     * <p>The data was collected for diagnostic purposes (for example, in support of initialization
     * or calibration).
     */
    ENGINEERING,
    /**
     * Ground Truth.
     *
     * <p>The data is ground truth (either generated automatically, manually, or a combination of
     * the two).
     */
    GROUND_TRUTH,
    /**
     * Initialisation.
     *
     * <p>The data was collected before the sensor or tracker was declared to be fully initialized
     * or calibrated.
     */
    INITIALIZATION,
    /**
     * Experimental.
     *
     * <p>The track data was collected in a non-nominal manner, in support of investigation or
     * potential addition to the exploitation capability.
     */
    EXPERIMENTAL
}
