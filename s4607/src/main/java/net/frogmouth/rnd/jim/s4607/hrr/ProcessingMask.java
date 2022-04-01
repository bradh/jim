package net.frogmouth.rnd.jim.s4607.hrr;

import java.util.EnumSet;

/**
 * Processing Mask bit mask.
 *
 * <p>This corresponds to the Processing Mask (H24) value within the HRR segment.
 */
public class ProcessingMask {
    private final EnumSet<ProcessingMaskFlag> flags;

    private ProcessingMask(EnumSet<ProcessingMaskFlag> processingFlags) {
        this.flags = processingFlags;
    }

    /**
     * Create a new Mode Status from an encoded byte.
     *
     * @param b the byte representation
     * @return the equivalent hardware status.
     */
    public static ProcessingMask fromByte(byte b) {
        EnumSet<ProcessingMaskFlag> processingFlags = EnumSet.noneOf(ProcessingMaskFlag.class);
        for (int shift = 0; shift < Byte.SIZE; shift++) {
            int flagValue = 1 << shift;
            if ((b & flagValue) == flagValue) {
                ProcessingMaskFlag flag = ProcessingMaskFlag.lookupValue(flagValue);
                processingFlags.add(flag);
            }
        }
        return new ProcessingMask(processingFlags);
    }

    /**
     * Create a new Processing Mask from an enumeration set.
     *
     * <p>Set flags indicate that this kind of processing was performed.
     *
     * @param flags the processing flags that should be set
     * @return the equivalent progressing mask.
     */
    public static ProcessingMask fromFlags(EnumSet<ProcessingMaskFlag> flags) {
        return new ProcessingMask(EnumSet.copyOf(flags));
    }

    /**
     * Get the encoded value of the processing flags.
     *
     * <p>Bits set to 1 indicate processing that was performed, bits set to 0 indicate this kind of
     * processing was not performed.
     *
     * <p>This is intended to support serialisation, and is not normally useful for display to a
     * user. Instead, enumerate on the flags that are set.
     *
     * @return bit flags for the mode status.
     */
    public byte toByte() {
        byte res = 0x00;
        for (ProcessingMaskFlag flag : flags) {
            res |= flag.getFlagValue();
        }
        return res;
    }

    /**
     * Get the flags that are set in this processing mask.
     *
     * <p>Set flags indicate processing that was performed.
     *
     * @return the enumeration set of flags that are set (indicating processing).
     */
    public EnumSet<ProcessingMaskFlag> getFlags() {
        return EnumSet.copyOf(flags);
    }
}
