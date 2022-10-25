package net.frogmouth.rnd.jim.nitf.image;

/**
 * Image compression values.
 *
 * <p>These are used in the IC value of the image segment subheader.
 */
public enum ImageCompression {

    /**
     * Unknown compression.
     *
     * <p>This denotes an unknown compression type value, and typically indicates a broken file or
     * an error during parsing. This is not a valid value in a NITF or NSIF image segment.
     */
    UNKNOWN(""),

    /**
     * Non-compressed (NC).
     *
     * <p>No compression.
     */
    NonCompressed("NC"),

    /**
     * Non-compressed with mask (NM).
     *
     * <p>Non-compressed data, with block mask and/or a pad pixel mask,
     */
    NonCompressedWithMask("NM"),

    /** Bi-level (C1). */
    BiLevel("C1"),

    /** Bi-level with pad pixel mask (M1). */
    BiLevelWithMask("M1"),

    /** JPEG DCT (C3). */
    JPEG_DCT("C3"),

    /** JPEG DCT with pad pixel mask (M3). */
    JPEG_DCT_WithMask("M3"),

    /** Vector Quantization (C4). */
    VQ("C4"),

    /** Vector Quantization with block mask and/or pad pixel mask (M4). */
    VQMask("M4"),

    // TODO: C5, M5

    // TODO: C7/M7

    /**
     * Downsampled JPEG DCT (I1).
     *
     * <p>8-bit.
     */
    DownsampledJPEG_DCT("I1");

    // TODO: CC/MC

    // TODO: C8/M8

    // TODO: C9/M9

    // TODO: CA/MA

    // TODO: CB/MB

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private ImageCompression(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for an image compression type.
     */
    public String getEncodedValue() {
        return encodedValue;
    }
}
