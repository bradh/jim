package net.frogmouth.rnd.jim.s4676.message.motionevent;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Motion Event Type.
 *
 * <p>The specific motion event kind.
 */
public enum MotionEventType implements IMotionEventType {
    /**
     * Start.
     *
     * <p>The tracked object starts to move (from a stop).
     */
    START,

    /**
     * Stop.
     *
     * <p>The tracked object stops.
     */
    STOP,

    /**
     * Intermittent motion.
     *
     * <p>The tracked object executes at least one start-stop-start-stop sequence.
     */
    INTERMITTENT_MOTION,

    /**
     * Left turn.
     *
     * <p>The tracked object makes a left turn.
     */
    LEFT_TURN,

    /**
     * Right turn.
     *
     * <p>The tracked object makes a right turn.
     */
    RIGHT_TURN,

    /**
     * Left U-Turn.
     *
     * <p>The tracked object makes a left U-turn.
     */
    @JsonProperty("LEFT_U-TURN")
    LEFT_U_TURN,

    /**
     * Right U-Turn.
     *
     * <p>The tracked object makes a right U-turn.
     */
    @JsonProperty("RIGHT_U-TURN")
    RIGHT_U_TURN,

    /**
     * Acceleration.
     *
     * <p>The tracked object’s speed increases.
     */
    ACCELERATION,

    /**
     * Deceleration.
     *
     * <p>The tracked object’s speed decreases.
     */
    DECELERATION,

    /**
     * Collision.
     *
     * <p>Mover comes in direct contact with another mover or a stationary object.
     */
    COLLISION,

    /**
     * Meeting.
     *
     * <p>Two or more movers come to a stop and exchange information.
     */
    MEETING,

    /**
     * Obscured.
     *
     * <p>The mover is not detectable (even though it’s probably in the field-of- view) because its
     * signal is blocked by an object along the line-of-sight.
     */
    OBSCURED,

    /**
     * Entered Region of Interest (ROI).
     *
     * <p>The mover enters a location that is of interest.
     */
    ENTERING_ROI,

    /**
     * Inside Region of Interest (ROI).
     *
     * <p>The mover resides in a location that is of interest.
     */
    INSIDE_ROI,

    /**
     * Exiting Region of Interest (ROI).
     *
     * <p>The mover exits a location that is of interest.
     */
    EXITING_ROI,

    /**
     * Cross trip-wire.
     *
     * <p>The mover crosses over a tripwire.
     */
    CROSSING_TRIPWIRE,

    /**
     * Convoy.
     *
     * <p>Two or more movers have similar dynamics.
     */
    CONVOY
}
