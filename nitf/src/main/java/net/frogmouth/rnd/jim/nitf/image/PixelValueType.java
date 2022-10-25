package net.frogmouth.rnd.jim.nitf.image;

public enum PixelValueType {

    /**
     * Unknown pixel value type.
     *
     * <p>This denotes an unknown pixel value type, and typically indicates a broken file or an
     * error during parsing. This is not a valid value in a NITF or NSIF image segment.
     */
    UNKNOWN(""),

    /**
     * Integer (INT).
     *
     * <p>Integer pixel values: Where pixel values are not from JPEG2000 compressed images, the bits
     * of a PVTYPE field INT pixel value appears in the file in order of significance, beginning
     * with the MSB and ending with the LSB, INT pixel values are limited to 8, 12, 16, 32 or
     * 64-bits.
     */
    Integer("INT"),

    /**
     * Bilevel (B).
     *
     * <p>Bi-level (Boolean) pixel values: The PVTYPE field for B values (bi-level) pixels are
     * represented as a single bit, binary value 1 or 0.
     */
    Bilevel("B  "),

    /**
     * Signed Integer (S).
     *
     * <p>Signed Integer pixel values: Where SI pixel values are not from JPEG2000 compressed
     * images, the 2’s complement of a PVTYPE field SI pixel value appears in the file in order of
     * significance, beginning with the MSB and ending with the LSB, SI pixel values are limited to
     * 8, 12, 16, 32 or 64-bits.
     */
    SignedInteger("S  "),

    /**
     * Real (R).
     *
     * <p>Real pixel values: The PVTYPE field for R values are represented in accordance with IEEE
     * 32 or 64-bit binary floating-point representation (IEEE 754).
     */
    Real("R  "),

    /**
     * Complex (C).
     *
     * <p>Complex pixel values: The PVTYPE field for C values represented with the Real and
     * Imaginary parts, each represented in accordance with IEEE 32 or 64-bit binary floating-point
     * representation (IEEE 754) and appearing in adjacent four or eight-byte blocks, first Real,
     * then Imaginary.
     */
    Complex("C  ");

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private PixelValueType(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for a pixel value format.
     */
    public String getEncodedValue() {
        return encodedValue;
    }
}
