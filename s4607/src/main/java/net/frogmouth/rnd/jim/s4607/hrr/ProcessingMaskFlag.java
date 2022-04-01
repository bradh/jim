package net.frogmouth.rnd.jim.s4607.hrr;

import java.util.HashMap;
import java.util.Map;

/** Flag values for the Processing Mask (H24). */
public enum ProcessingMaskFlag {
    /** Clutter Cancellation. */
    ClutterCancellation(0x80, "Clutter Cancellation"),
    /** Single-Ambiguity Keystoning. */
    SingleAmbiguityKeystoning(0x40, "Single-Ambiguity Keystoning"),
    /** Multi-Ambiguity Keystoning. */
    MultiAmbiguityKeystoning(0x20, "Multi-Ambiguity Keystoning"),
    /**
     * Spare Bit 4.
     *
     * <p>This is encoded bit 4 (0x10).
     *
     * <p>This is not a valid value, and should not be created.
     */
    Spare4(0x10, "Spare Bit 4"),
    /**
     * Spare Bit 3.
     *
     * <p>This is encoded bit 3 (0x08).
     *
     * <p>This is not a valid value, and should not be created.
     */
    Spare3(0x08, "Spare Bit 3"),
    /**
     * Spare Bit 2.
     *
     * <p>This is encoded bit 2 (0x04).
     *
     * <p>This is not a valid value, and should not be created.
     */
    Spare2(0x04, "Spare Bit 2"),
    /**
     * Spare Bit 1.
     *
     * <p>This is encoded bit 1 (0x02).
     *
     * <p>This is not a valid value, and should not be created.
     */
    Spare1(0x02, "Spare Bit 1"),
    /**
     * Unknown.
     *
     * <p>This is encoded bit 0 (0x01).
     */
    Unknown(0x01, "Unknown");

    private final int flagValue;
    private final String label;

    private ProcessingMaskFlag(int flagValue, String label) {
        this.flagValue = flagValue;
        this.label = label;
    }

    private static final Map<Integer, ProcessingMaskFlag> lookupTable = new HashMap<>();

    static {
        for (ProcessingMaskFlag c : values()) {
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
     * Get the processing mask flag corresponding to this encoded value.
     *
     * @param value the encoded value
     * @return the corresponding enumeration value
     * @throws IllegalArgumentException if the encoded value is not valid
     */
    public static ProcessingMaskFlag lookupValue(int value) {
        if (lookupTable.containsKey(value)) {
            return lookupTable.get(value);
        }
        throw new IllegalArgumentException("Invalid processing mask flag encoded value: " + value);
    }
}
