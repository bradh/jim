package net.frogmouth.rnd.jim.s4676;

/**
 * Track Point process type.
 *
 * <p>Indicator whether a track point was generated by or modified by a human or an algorithm.
 */
public enum ProcessType {
    /**
     * Manual.
     *
     * <p>Indicates that the track point was created or modified by a human.
     */
    MANUAL,
    /**
     * Automatic.
     *
     * <p>Indicates that the track point was created or modified by an algorithm.
     */
    AUTOMATIC,
}
