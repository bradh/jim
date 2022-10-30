package net.frogmouth.rnd.jim.nitf.image;

public enum ImageMode {

    /**
     * Unknown image mode.
     *
     * <p>This denotes an unknown image mode, and typically indicates a broken file or an error
     * during parsing. This is not a valid value in a NITF or NSIF image segment.
     */
    UNKNOWN(""),

    /**
     * Band sequential (S).
     *
     * <p>All blocks for the first band are followed by all blocks for the second band.
     */
    BandSequential("S"),

    /**
     * Band interleaved by block (B).
     *
     * <p>. This implies that within each block, the bands follow one another: [(block1, band1),
     * (block1, band2), ...(block1, bandN)], [(block2, band1), (block2, band2), ... (block2,
     * bandN)], ... [(blockM, band1), (blockM, band2), ... (blockM, bandN)]. Note that, in each
     * block, the pixels of the first line appear first and the pixels of the last line appear last.
     */
    BandInterleavedByBlock("B"),

    /**
     * Band interleaved by row (R).
     *
     * <p>The ordering mechanism for this case stores the pixel values of each band in row
     * sequential order. Within each block, all pixel values of the first row of the first band are
     * followed by pixel values of the first row of the second band continuing until all values of
     * the first row are stored. The remaining rows are stored in a similar fashion until the last
     * row of values has been stored. Each block is zero-filled to the next octet boundary when
     * necessary.
     */
    BandInterleavedByRow("R"),

    /**
     * Band interleaved by pixel (P).
     *
     * <p>For each block, one after the other, the full pixel vector (all band values) appears for
     * every pixel in the block, one pixel after another, the block column index varying faster than
     * the block row index.
     */
    BandInterleavedByPixel("P");

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private ImageMode(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for an image mode.
     */
    public String getEncodedValue() {
        return encodedValue;
    }
}
