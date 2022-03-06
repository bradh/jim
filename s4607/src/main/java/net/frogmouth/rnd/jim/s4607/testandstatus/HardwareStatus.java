package net.frogmouth.rnd.jim.s4607.testandstatus;

import java.util.EnumSet;

/**
 * Hardware Status bit mask.
 *
 * <p>This corresponds to the Hardware Status (T5) value within the Test and Status segment.
 */
public class HardwareStatus {
    private final EnumSet<HardwareStatusFlag> flags;

    private HardwareStatus(EnumSet<HardwareStatusFlag> statusFlags) {
        this.flags = statusFlags;
    }

    /**
     * Create a new Hardware Status from an encoded byte.
     *
     * @param b the byte representation
     * @return the equivalent hardware status.
     */
    public static HardwareStatus fromByte(byte b) {
        EnumSet<HardwareStatusFlag> statusFlags = EnumSet.noneOf(HardwareStatusFlag.class);
        for (int shift = 0; shift < 8; shift++) {
            int flagValue = 1 << shift;
            if ((b & flagValue) == flagValue) {
                HardwareStatusFlag flag = HardwareStatusFlag.lookupValue(flagValue);
                statusFlags.add(flag);
            }
        }
        return new HardwareStatus(statusFlags);
    }

    /**
     * Create a new Hardware Status from an enumeration set.
     *
     * <p>Set flags indicate a failed status of that parameter / subsystem.
     *
     * @param statusFlags the status flags that should be set
     * @return the equivalent hardware status.
     */
    public static HardwareStatus fromFlags(EnumSet<HardwareStatusFlag> statusFlags) {
        return new HardwareStatus(EnumSet.copyOf(statusFlags));
    }

    /**
     * Get the encoded value of the hardware status flags.
     *
     * <p>Bits set to 1 indicate failure, bits set to 0 indicate pass status.
     *
     * <p>This is intended to support serialisation, and is not normally useful for display to a
     * user. Instead, enumerate on the flags that are set.
     *
     * @return bit flags for the hardware status.
     */
    public byte toByte() {
        byte res = 0x00;
        for (HardwareStatusFlag flag : flags) {
            res |= flag.getFlagValue();
        }
        return res;
    }

    /**
     * Get the flags that are set in this status report.
     *
     * <p>Set flags indicate a failed status of that parameter / subsystem.
     *
     * @return the enumeration set of flags that are set (indicating failure).
     */
    public EnumSet<HardwareStatusFlag> getFlags() {
        return EnumSet.copyOf(flags);
    }
}
