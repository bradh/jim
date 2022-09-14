package net.frogmouth.rnd.jim.s4676.message.trackpoint;

/**
 * Evidence type.
 *
 * <p>A categorization of the evidence. The evidence is either DIRECT or CIRCUMSTANTIAL.
 */
public enum EvidenceType {
    /**
     * Direct.
     *
     * <p>The detection is of the object itself. For example, the tracked boat can be seen or
     * partially seen in a frame of imagery.
     */
    DIRECT,
    /**
     * Circumstantial.
     *
     * <p>The tracked object itself could not be detected even in part, but signs of the object were
     * detected. For example, when tracking a boat, its wake can be seen, but the boat itself cannot
     * be seen.
     */
    CIRCUMSTANTIAL
}
