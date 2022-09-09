package net.frogmouth.rnd.jim.s4676.message.tracksegment;

/**
 * Standard Track Status enumerated value.
 *
 * <p>The track status of a track segment (such as INITIATING or TERMINATED).
 */
public enum TrackStatus implements ITrackStatus {
    /**
     * Initiating.
     *
     * <p>The tracker initiates a new track. The data producer may specify a TrackInitiationReason.
     */
    INITIATING,
    /**
     * Maintaining.
     *
     * <p>The tracker is maintaining a track.
     */
    MAINTAINING,
    /**
     * Searching.
     *
     * <p>The tracker did not find a detection to associate with at the expected track location.
     */
    SEARCHING,
    /**
     * Terminated.
     *
     * <p>The tracker has terminated the track. The data producer may specify a
     * TrackTerminationReason.
     */
    TERMINATED,
    /**
     * Ground truth.
     *
     * <p>The track is a ground truth track, and therefore has no tracker-specific status.
     */
    GROUND_TRUTH
}
