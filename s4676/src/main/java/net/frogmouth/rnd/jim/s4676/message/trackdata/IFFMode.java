package net.frogmouth.rnd.jim.s4676.message.trackdata;

/**
 * IFF Mode.
 *
 * <p>Provides the mode of operation for an IFF system.
 */
public enum IFFMode {
    /**
     * Mode 1.
     *
     * <p>Provides a 2-digit 5-bit mission code. (Military only – cockpit selectable).
     */
    MODE1,

    /**
     * Mode 2.
     *
     * <p>Provides a 4-digit octal unit code. (Military only – set on ground for fighters, can be
     * changed in flight by transport aircraft).
     */
    MODE2,

    /**
     * Mode 3.
     *
     * <p>Mode 3 is shared with civilian secondary surveillance radar (SSR). Mode 3/A – Provides a
     * 4-digit octal identification code for the aircraft, assigned by the air traffic controller.
     * (Military and civilian).
     */
    MODE3,

    /**
     * Mode 4.
     *
     * <p>Provides a 3-pulse reply to cryptographic coded challenge (military only). Modes 4 and 5
     * are designated for use by NATO forces.
     */
    MODE4,

    /**
     * Mode 5.
     *
     * <p>Provides a cryptographically-secured version of Mode S and ADS-B GPS position (military
     * only). Mode 5 is divided into two levels. Both are cryptographic-secure with enhanced
     * encryption, Spread Spectrum Modulation, and Time of Day Authentication. Level 1 is similar to
     * Mode 4 information but enhanced with an Aircraft Unique PIN. Level 2 is the same as Mode 5
     * level one but includes additional information such as Aircraft Position and Other. Modes 4
     * and 5 are designated for use by NATO forces.
     */
    MODE5,

    /**
     * Mode C.
     *
     * <p>Provides a 4-digit octal code for aircraft’s pressure altitude (Military and civilian).
     */
    MODE_C,

    /**
     * Mode S.
     *
     * <p>Provides multiple information formats to a selective interrogation. Each aircraft is
     * assigned a fixed 24-bit address. (Military and civilian)
     */
    MODE_S
}
