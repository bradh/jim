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
    VQ_WithMask("M4"),

    /**
     * JPEG DCT Lossless (C5).
     *
     * <p>8-bit, 12-bit, or 16-bit.
     */
    JPEG_DCT_Lossless("C5"),

    /**
     * JPEG DCT Lossless with block mask (M5).
     *
     * <p>8-bit, 12-bit, or 16-bit.
     */
    JPEG_DCT_Lossless_WithMask("M5"),

    /**
     * SARZip (C7).
     *
     * <p>Represents complex and magnitude only SARZip compressed data, the image consists of a
     * single JBP Image Block.
     */
    SARZip("C7"),

    /**
     * SARZip with multiple blocks (M7).
     *
     * <p>Represent complex and magnitude only SARZip compressed data, the image consists of a
     * multiple JBP Image Blocks.
     */
    SARZipMulti("M7"),

    /**
     * Downsampled JPEG DCT (I1).
     *
     * <p>8-bit.
     */
    DownsampledJPEG_DCT("I1"),

    /**
     * ZLIB (CC).
     *
     * <p>ZLIB for numerically lossless compression of floating-point values.
     */
    ZLIB("CC"),

    /**
     * ZLIB with block mask and/or pad pixel mask (CC).
     *
     * <p>ZLIB with Block mask and/or a pad pixel mask for numerically lossless compression of
     * floating-point values.
     */
    ZLIB_WithMask("MC"),

    /**
     * JPEG 2000 (C8).
     *
     * <p>Still imagery only - use {@link JPEG2000MotionImagery} for motion imagery.
     *
     * <p>C8 representing the values from ISO standard compression JPEG 2000 and BPJ2K01.10.
     */
    JPEG2000("C8"),

    /**
     * JPEG 2000 with block mask and/or pad pixel mask (M8).
     *
     * <p>Still imagery only - use {@link JPEG2000MotionImageryWithMask} for motion imagery.
     *
     * <p>M8 with Block mask and/or a pad pixel mask representing the values for ISO standard
     * compression JPEG 2000 and BPJ2K01.10.
     */
    JPEG2000WithMask("M8"),

    /** H.264 motion imagery (C9). */
    H264("C9"),

    /** H.264 motion imagery with block mask (M9). */
    H264WithMask("M9"),

    /** H.265 motion imagery (CA). */
    H265("CA"),

    /** H.265 motion imagery with block mask (MA). */
    H265WithMask("MA"),

    /**
     * JPEG 2000 Motion Imagery (CB).
     *
     * <p>Motion imagery only - use {@link JPEG2000} for still imagery.
     *
     * <p>JPEG 2000 with frames per provisions of NGA.STND.0044, MIE4NITF with time association.
     */
    JPEG2000MotionImagery("CB"),

    /**
     * JPEG 2000 Motion Imagery with mask (MB).
     *
     * <p>Motion imagery only - use {@link JPEG2000WithMask} for still imagery.
     *
     * <p>Blocked JPEG 2000 with frames per provisions of NGA.STND.0044, MIE4NITF with time
     * association.
     */
    JPEG2000MotionImageryWithMask("MB");

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
