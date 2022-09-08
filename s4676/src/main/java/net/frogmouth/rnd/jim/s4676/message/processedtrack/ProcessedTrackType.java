package net.frogmouth.rnd.jim.s4676.message.processedtrack;

/**
 * Processed Track Type.
 *
 * <p>The type of the processed track being documented.
 */
public enum ProcessedTrackType implements IProcessedTrackType {
    /**
     * Fused.
     *
     * <p>Multiple tracks (from different sensors or different modalities) are hypothesized to be
     * caused by the same object.
     *
     * <p>This process is specifically for the case where the tracks overlap in time, and the
     * producer has to re-run the tracker to determine the position of the track points.
     */
    FUSED,

    /**
     * Smoothed.
     *
     * <p>Track predictive analysis where the latest track prediction is combined with the
     * associated plot to provide a new, improved estimate of the target state as well as a revised
     * estimate of the errors in this prediction. There are a wide variety of algorithms, of
     * differing complexity and computational load that can be used for this process.
     */
    SMOOTHED
}
