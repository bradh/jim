package net.frogmouth.rnd.jim.s4676.message.trackpoint;

/**
 * Evidence subtype.
 *
 * <p>A subtype of the evidence, such as “WAKE”, “DUST_PLUME”, "TIRE_TRACKS", or “SHADOW”. Only used
 * when the Evidence type is CIRCUMSTANTIAL.
 */
public enum EvidenceSubtype implements IEvidenceSubtype {
    /**
     * Wake.
     *
     * <p>The wake of a boat or ship.
     */
    WAKE,

    /**
     * Dust plume.
     *
     * <p>Signs of dust stirred up by movement of a vehicle over dirt roads.
     */
    DUST_PLUME,

    /** Tire tracks. */
    TIRE_TRACKS,

    /**
     * Shadow.
     *
     * <p>The shadow cast by the tracked object.
     */
    SHADOW
}
