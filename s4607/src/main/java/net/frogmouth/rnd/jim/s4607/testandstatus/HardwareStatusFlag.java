package net.frogmouth.rnd.jim.s4607.testandstatus;

import java.util.HashMap;
import java.util.Map;

/** Flag values from the Hardware Status (T5). */
public enum HardwareStatusFlag {
    /** Antenna Status. */
    AntennaStatus(0x80, "Antenna Status"),
    /** RF Electronics Status. */
    RfElectronicsStatus(0x40, "RF Electronics Status"),
    /** Processor Status. */
    ProcessorStatus(0x20, "Processor Status"),
    /** Datalink Status. */
    DatalinkStatus(0x10, "Datalink Status"),
    /** Calibration Mode Status. */
    CalibrationModeStatus(0x08, "Calibration Mode Status"),
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

    private HardwareStatusFlag(int flagValue, String label) {
        this.flagValue = flagValue;
        this.label = label;
    }

    private static final Map<Integer, HardwareStatusFlag> lookupTable = new HashMap<>();

    static {
        for (HardwareStatusFlag c : values()) {
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
    public static HardwareStatusFlag lookupValue(int value) {
        if (lookupTable.containsKey(value)) {
            return lookupTable.get(value);
        }
        throw new IllegalArgumentException("Invalid Hardware Status Flag encoded value: " + value);
    }
}
