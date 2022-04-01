package net.frogmouth.rnd.jim.s4607.hrr;

/**
 * Type of HRR/RDM.
 *
 * <p>An enumeration that designates the type of data being delivered.
 */
public enum TypeOfHrrRdm {
    /**
     * Other.
     *
     * <p>Other type. This is encoded as 0.
     */
    Other(0, "Other"),
    /**
     * 1-D HRR Profile.
     *
     * <p>An HRR chip having samples in a single Doppler bin, multiple range samples and
     * corresponding to a single detected entity.
     *
     * <p>This is encoded as 1.
     */
    HrrProfile1D(1, "1-D HRR Profile"),
    /**
     * 2-D HRR Chip.
     *
     * <p>An HRR chip with samples in both dimensions and corresponding to a single detected entity.
     *
     * <p>This is encoded as 2.
     */
    HrrChip2D(2, "2-D HRR Chip"),
    /**
     * Sparse HRR Chip.
     *
     * <p>A HRR chip with scatterer records sparsely (non-contiguous range and Doppler) representing
     * the range-Doppler space of a single detected entity.
     *
     * <p>This is encoded as 3.
     */
    HrrChipSparse(3, "Sparse HRR Chip"),
    /**
     * Oversized HRR Chip.
     *
     * <p>A 2-D HRR chip with excess range/Doppler beyond the extent of the detected entity to which
     * the chip corresponds (this is basically a partial RDM that is correlated to an entity by the
     * MTI Report Index).
     *
     * <p>This is encoded as 4.
     */
    HrrChipOversized(4, "Oversized HRR Chip"),
    /**
     * Full RDM.
     *
     * <p>A Range Doppler Map with Contiguous Samples in range and Doppler corresponding to the full
     * detection space of the radar system.
     *
     * <p>This is encoded as 5.
     */
    RdmFull(5, "Full RDM"),
    /**
     * Partial RDM.
     *
     * <p>A Range Doppler Map with Contiguous Samples in range and Doppler corresponding to a small
     * portion of the detection space of the radar system.
     *
     * <p>This is encoded as 6.
     */
    RdmPartial(6, "Partial RDM"),
    /**
     * Full Range Pulse Data.
     *
     * <p>A data block of data in pulse-range space following range processing without any Doppler
     * processing performed.
     *
     * <p>This is encoded as 7.
     */
    PulseDataFullRange(7, "Full Range Pulse Data"),
    /**
     * Reserved.
     *
     * <p>This value is part of the Reserved range (8 to 255) of enumeration values.
     *
     * <p>This is encoded as 255.
     */
    Reserved(255, "Reserved"),
    /**
     * Unknown or Invalid type.
     *
     * <p>This should not be intentionally created.
     */
    Unknown(-1, "Unknown / Invalid");

    private TypeOfHrrRdm(int key, String displayLabel) {
        this.tag = key;
        this.displayLabel = displayLabel;
    }

    private final int tag;
    private final String displayLabel;

    /**
     * Get the identifier tag value.
     *
     * <p>This is the integer identifier used to encode the Type of HRR/RDM.
     *
     * @return integer value (in the range 0-255) representing the HRR/RDM data type.
     */
    public int getTag() {
        return tag;
    }

    /**
     * Get a human readable display name for this HRR/RDM type.
     *
     * @return short string containing a human-readable / displayable value for the HRR/RDM type.
     */
    public String getDisplayLabel() {
        return displayLabel;
    }

    /**
     * Look up a HRR/RDM type value by identifier.
     *
     * @param identifier the integer identifier for the value type.
     * @return HRR/RDM data type corresponding to the integer identifier.
     */
    public static TypeOfHrrRdm lookupByIdent(int identifier) {
        if ((identifier >= 8) && (identifier <= 255)) {
            return Reserved;
        }
        for (TypeOfHrrRdm type : TypeOfHrrRdm.values()) {
            if (identifier == type.getTag()) {
                return type;
            }
        }
        return Unknown;
    }
}
