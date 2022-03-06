package net.frogmouth.rnd.jim.s4607.testandstatus;

import java.util.HashMap;
import java.util.Map;

/** Flag values for the Mode Status (T6). */
public enum ModeStatusFlag {
    /** Range Limit Exceeded. */
    RangeLimitExceeded(0x80, "Range Limit Exceeded"),
    /** Azimuth Limit Exceeded. */
    AzimuthLimitExceeded(0x40, "Azimuth Limit Exceeded"),
    /** Elevation Limit Exceeded. */
    ElevationLimitExceeded(0x20, "Elevation Limit Exceeded"),
    /** Temperature Limit Exceeded. */
    TemperatureLimitExceeded(0x10, "Temperature Limit Exceeded"),
    /**
     * Spare E.
     *
     * <p>This is encoded bit "e" (0x08).
     *
     * <p>This is not a valid value, and should not be created.
     */
    SpareE(0x08, "Spare E"),
    /**
     * Spare F.
     *
     * <p>This is encoded bit "f" (0x04).
     *
     * <p>This is not a valid value, and should not be created.
     */
    SpareF(0x04, "Spare F"),
    /**
     * Spare G.
     *
     * <p>This is encoded bit "g" (0x02).
     *
     * <p>This is not a valid value, and should not be created.
     */
    SpareG(0x02, "Spare G"),
    /**
     * Spare H.
     *
     * <p>This is encoded bit "h" (0x01).
     *
     * <p>This is not a valid value, and should not be created.
     */
    SpareH(0x01, "Spare H");

    private final int flagValue;
    private final String label;

    private ModeStatusFlag(int flagValue, String label) {
        this.flagValue = flagValue;
        this.label = label;
    }

    private static final Map<Integer, ModeStatusFlag> lookupTable = new HashMap<>();

    static {
        for (ModeStatusFlag c : values()) {
            lookupTable.put(c.flagValue, c);
        }
    }

    /**
     * Get the flag value.
     *
     * @return the encoded value of the flag.
     */
    public int getFlagValue() {
        return flagValue;
    }

    /**
     * Get the flag label.
     *
     * @return the human-readable display value for the flag.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get the status flag corresponding to this encoded value.
     *
     * @param value the encoded value
     * @return the corresponding enumeration value
     * @throws IllegalArgumentException if the encoded value is not valid
     */
    public static ModeStatusFlag lookupValue(int value) {
        if (lookupTable.containsKey(value)) {
            return lookupTable.get(value);
        }
        throw new IllegalArgumentException("Invalid Mode Status Flag encoded value: " + value);
    }
}
