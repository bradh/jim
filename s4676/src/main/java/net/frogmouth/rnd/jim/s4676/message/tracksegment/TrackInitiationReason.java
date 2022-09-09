package net.frogmouth.rnd.jim.s4676.message.tracksegment;

/**
 * Standard track initiation reason enumerated value.
 *
 * <p>The reason that the track was initiated. Only used when the track status is INITIATING.
 */
public enum TrackInitiationReason implements ITrackInitiationReason {
    /**
     * Sensor on.
     *
     * <p>The tracker initiates a new track, based on evidence that was available as soon as the
     * sensor started collecting.
     */
    SENSOR_ON,

    /**
     * Entered field of view (FOV).
     *
     * <p>The tracker initiates a new track, based on evidence from a source that just entered the
     * field-of-view.
     */
    ENTERED_FOV,

    /**
     * Found.
     *
     * <p>The tracker initiates a new track, based on evidence that appeared in part of the scene
     * that the sensor had already been collecting on (and had not previously been present). For
     * example, a car pulls out from under a parking garage near the middle of the scene and the
     * middle of a collect.
     */
    FOUND,

    /**
     * Reinitiating.
     *
     * <p>The tracker is reinitiating a previously-terminated track.
     */
    REINITIATING,

    /**
     * Collection start.
     *
     * <p>The tracker initiates a new track, based on evidence available at the start of the
     * collection.
     */
    COLLECTION_START
}
