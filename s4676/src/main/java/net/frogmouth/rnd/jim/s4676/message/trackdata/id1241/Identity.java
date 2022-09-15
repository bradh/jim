package net.frogmouth.rnd.jim.s4676.message.trackdata.id1241;

/**
 * Identity.
 *
 * <p>Provides the estimated identity/status of an object being tracked. Values in accordance with
 * STANAG 1241, Edition 5.
 */
public enum Identity {
    /**
     * Unknown.
     *
     * <p>An evaluated track, object, or entity, which does not meet the criteria for any other
     * standard identity.
     */
    UNKNOWN,
    /**
     * Assumed friend.
     *
     * <p>A track, object, or entity which is assumed to be friendly or neutral because of its
     * characteristics, behaviour, or origin.
     */
    ASSUMED_FRIEND,
    /**
     * Friend.
     *
     * <p>An Allied/Coalition military track, object or entity; A track, object or entity supporting
     * friendly forces and belonging to an allied/coalition nation or a declared or recognized
     * friendly faction or group.
     */
    FRIEND,
    /**
     * Neutral.
     *
     * <p>Military or civilian track object, or entity, neither belonging to allied/coalition
     * military forces nor to opposing military forces, whose characteristics, behaviour, origin or
     * nationality indicates that it is neither supporting nor opposing friendly forces nor their
     * mission.
     */
    NEUTRAL,
    /**
     * Suspect.
     *
     * <p>A track, object or entity whose characteristics, behaviour or origin indicate that it
     * potentially belongs to opposing forces or potentially poses a threat to friendly forces or
     * their mission.
     */
    SUSPECT,
    /**
     * Hostile.
     *
     * <p>A track declared to belong to any opposing nation, party, group, or entity, which by
     * virtue of its behaviour or information collected on it such as characteristics, origin, or
     * nationality contributes to the threat to friendly forces.
     */
    HOSTILE
}
