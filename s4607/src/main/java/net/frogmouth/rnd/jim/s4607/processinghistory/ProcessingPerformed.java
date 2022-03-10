package net.frogmouth.rnd.jim.s4607.processinghistory;

import java.util.EnumSet;

/**
 * Processing Performed bit mask.
 *
 * <p>This corresponds to the Processing Performed (C6.6) value within the Processing History
 * segment.
 */
public class ProcessingPerformed {
    private final EnumSet<ProcessingPerformedFlag> flags;

    private ProcessingPerformed(EnumSet<ProcessingPerformedFlag> statusFlags) {
        this.flags = statusFlags;
    }

    /**
     * Create a new Processing Performed instance from an encoded integer.
     *
     * @param v the (short) integer representation
     * @return the equivalent hardware status.
     */
    public static ProcessingPerformed fromInteger(int v) {
        EnumSet<ProcessingPerformedFlag> statusFlags =
                EnumSet.noneOf(ProcessingPerformedFlag.class);
        for (int shift = 0; shift < Short.SIZE; shift++) {
            int flagValue = 1 << shift;
            if ((v & flagValue) == flagValue) {
                ProcessingPerformedFlag flag = ProcessingPerformedFlag.lookupValue(flagValue);
                statusFlags.add(flag);
            }
        }
        return new ProcessingPerformed(statusFlags);
    }

    /**
     * Create a new Processing Performed instance from an enumeration set.
     *
     * <p>Set flags indicate the processing that was performed.
     *
     * @param processingFlags the processing flags that should be set
     * @return the equivalent processing performed value.
     */
    public static ProcessingPerformed fromFlags(EnumSet<ProcessingPerformedFlag> processingFlags) {
        return new ProcessingPerformed(EnumSet.copyOf(processingFlags));
    }

    /**
     * Get the encoded value of the processing performed flags.
     *
     * <p>Bits set to 1 indicate the kind of processing that was performed by the system, bits set
     * to 0 indicate that this kind of processing was not performed by the system.
     *
     * <p>This is intended to support serialisation, and is not normally useful for display to a
     * user. Instead, enumerate on the flags that are set.
     *
     * @return bit flags for the mode status.
     */
    public int toInteger() {
        int res = 0x00;
        for (ProcessingPerformedFlag flag : flags) {
            res |= flag.getFlagValue();
        }
        return res;
    }

    /**
     * Get the flags that are set in this processing performed report.
     *
     * <p>Set flags indicate the kind of processing that was performed by the system, unset flags
     * (not present in the set) indicate that this kind of processing was not performed by the
     * system.
     *
     * @return the enumeration set of flags that are set (indicating failure).
     */
    public EnumSet<ProcessingPerformedFlag> getFlags() {
        return EnumSet.copyOf(flags);
    }
}
