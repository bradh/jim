package net.frogmouth.rnd.jim.s4607.testandstatus;

import java.util.EnumSet;

/**
 * Mode Status bit mask.
 *
 * <p>This corresponds to the Mode Status (T6) value within the Test and Status segment.
 */
public class ModeStatus {
    private final EnumSet<ModeStatusFlag> flags;

    private ModeStatus(EnumSet<ModeStatusFlag> statusFlags) {
        this.flags = statusFlags;
    }

    /**
     * Create a new Mode Status from an encoded byte.
     *
     * @param b the byte representation
     * @return the equivalent hardware status.
     */
    public static ModeStatus fromByte(byte b) {
        EnumSet<ModeStatusFlag> statusFlags = EnumSet.noneOf(ModeStatusFlag.class);
        for (int shift = 0; shift < 8; shift++) {
            int flagValue = 1 << shift;
            if ((b & flagValue) == flagValue) {
                ModeStatusFlag flag = ModeStatusFlag.lookupValue(flagValue);
                statusFlags.add(flag);
            }
        }
        return new ModeStatus(statusFlags);
    }

    /**
     * Create a new Mode Status from an enumeration set.
     *
     * <p>Set flags indicate a failed status of that parameter / subsystem.
     *
     * @param statusFlags the status flags that should be set
     * @return the equivalent mode status.
     */
    public static ModeStatus fromFlags(EnumSet<ModeStatusFlag> statusFlags) {
        return new ModeStatus(EnumSet.copyOf(statusFlags));
    }

    /**
     * Get the encoded value of the mode status flags.
     *
     * <p>Bits set to 1 indicate failure, bits set to 0 indicate pass status.
     *
     * <p>This is intended to support serialisation, and is not normally useful for display to a
     * user. Instead, enumerate on the flags that are set.
     *
     * @return bit flags for the mode status.
     */
    public byte toByte() {
        byte res = 0x00;
        for (ModeStatusFlag flag : flags) {
            res |= flag.getFlagValue();
        }
        return res;
    }

    /**
     * Get the flags that are set in this status report.
     *
     * <p>Set flags indicate a failed status of that sensor parameter.
     *
     * @return the enumeration set of flags that are set (indicating failure).
     */
    public EnumSet<ModeStatusFlag> getFlags() {
        return EnumSet.copyOf(flags);
    }
}
