package net.frogmouth.rnd.jim.s4676.message.tracksegment;

/**
 * Standard track termination reason enumerated value.
 *
 * <p>The reason that the track was terminated. Only used when the track status is TERMINATED.
 */
public enum TrackTerminationReason implements ITrackTerminationReason {
    /**
     * Sensor off.
     *
     * <p>The tracker has terminated the track because the sensor has stopped collecting.
     */
    SENSOR_OFF,
    /**
     * Exited field of view (FOV).
     *
     * <p>The tracker has terminated the track because the object (or evidence of the object) has
     * disappeared from the field-of-view.
     */
    EXITED_FOV,
    /**
     * Lost.
     *
     * <p>The tracker has terminated the track because the object (which is still in the
     * field-of-view) can no longer be found.
     */
    LOST,
    /**
     * Obscured.
     *
     * <p>The tracker has terminated the track because the object (which is still in the
     * field-of-view) went behind an obscuration.
     */
    OBSCURED,
    /**
     * Sensor defect.
     *
     * <p>The tracker has terminated the track because a sensor defect prevented the track from
     * being detected.
     */
    SENSOR_DEFECT,
    /**
     * Collection end.
     *
     * <p>The tracker has terminated the track because the collection ended.
     */
    COLLECTION_END
}
