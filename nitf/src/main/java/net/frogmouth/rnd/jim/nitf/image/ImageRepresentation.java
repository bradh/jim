package net.frogmouth.rnd.jim.nitf.image;

/**
 * Image Representation.
 *
 * <p>This indicates the processing required to display an image.
 */
public enum ImageRepresentation {

    /**
     * Unknown image representation.
     *
     * <p>This denotes an unknown image representation, and typically indicates a broken file or an
     * error during parsing. This is not a valid value in a NITF or NSIF image segment.
     */
    UNKNOWN(""),

    /**
     * Not for display (NODISPLY).
     *
     * <p>For an image not intended for display.
     *
     * <p>Image representation bands (IREPBANDn) are space filled.
     *
     * <p>Valid {@link PixelValueType}s: INT, R, C, B, SI.
     *
     * <p>Valid image category (ICAT) values: BARO, CAVIS, CLOUD, DED, DEPTH, DTEM, ISAR, LOCG,
     * MATR, PIXQUAL, SAR, SARIQ, LWIR, MWIR, NIR, SWIR, UV, VNIR.
     */
    NoDisplay("NODISPLY"),

    /**
     * Monochrome (MONO).
     *
     * <p>Single band. Image representation bands (IREPBANDn) is {@code LU}, {@code M} or space
     * filled.
     *
     * <p>Valid {@link PixelValueType}s: INT, R, B, SI.
     *
     * <p>Valid image category (ICAT) values: BP, CAT, CCD, DTV, EO, EOVIS, FL, FP, HR, HS, IR,
     * ISAR, LEG, LWIR, MAP, MRI, MS, MWIR, NIR, OP, PAN, RD, SAR, SL, SWIR, TI, UV, VD, VIS, VNIR,
     * XRAY.
     */
    Monochrome("MONO"),

    /**
     * Red / green / blue true colour (RGB).
     *
     * <p>Three bands. Image representation bands (IREPBANDn) are {@code R}, {@code G} and {@code
     * B}.
     *
     * <p>Valid {@link PixelValueType}s: INT, R.
     *
     * <p>Valid image category (ICAT) values: CP, EOVIS, DTV, LEG, MAP, OP, PAT, VIS, CCD, MS.
     */
    RGB("RGB"),

    /**
     * Red / green / blue lookup table (RGB/LUT).
     *
     * <p>Single band. Image representation band (IREPBANDn) is {@code LU}.
     *
     * <p>Valid {@link PixelValueType}s: INT, B.
     *
     * <p>Valid image category (ICAT) values: CCD, CP, DTV, EOVIS, LEG, MAP, OP, PAT, VIS.
     */
    RGB_LUT("RGB/LUT"),

    /**
     * Luma / chroma (YCbCr601).
     *
     * <p>Used when compressed in the ITU-R Recommendation BT.601-5 color space using JPEG (IC field
     * = C3).
     *
     * <p>Three bands. Image representation bands (IREPBANDn) are {@code Y}, {@code Cb} and {@code
     * Cr}.
     *
     * <p>Valid {@link PixelValueType}: INT.
     *
     * <p>Valid image category (ICAT) values: CP, DTV, EOVIS, LEG, MAP, OP, PAT, VIS.
     */
    YCbCr601("YCbCr601"),

    /**
     * Cartesian coordinate vector (NVECTOR).
     *
     * <p>For vectors with Cartesian coordinates.
     *
     * <p>Arbitrary number of bands. Image representation bands (IREPBANDn) are space filled.
     *
     * <p>Valid {@link PixelValueType}s: INT, R, C, SI.
     *
     * <p>Valid image category (ICAT) values: none currently identified.
     */
    Vector("NVECTOR"),

    /**
     * Polar coordinate vector (NVECTOR).
     *
     * <p>For vectors with polar coordinates.
     *
     * <p>Two bands. Image representation bands (IREPBANDn) are space filled or M.
     *
     * <p>Valid {@link PixelValueType}s: INT, R, C, SI.
     *
     * <p>Valid image category (ICAT) values: CCD, CURRENT, WIND, SAR. For SAR, values are magnitude
     * and phase, and only magnitude is displayed.
     */
    Polar("POLAR"),

    /**
     * Video phase history (VPH).
     *
     * <p>Two bands. Image representation bands (IREPBANDn) are space filled.
     *
     * <p>Valid {@link PixelValueType}s: INT, R, C, SI.
     *
     * <p>Valid image category (ICAT) values: none currently identified.
     */
    VideoPhaseHistory("VPH"),

    /**
     * Multi-band imagery (MULTI).
     *
     * <p>Arbitrary numbers of bands. Image representation bands (IREPBANDn) are space filled, M, R,
     * G, B or LU.
     *
     * <p>Valid {@link PixelValueType}s: INT, R, C, B, SI.
     *
     * <p>Valid image category (ICAT) values: EOVIS, HS, LWIR, MS, MWIR, NIR, SWIR, UV, VNIR, CAVIS.
     */
    MultiBand("MULTI");

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private ImageRepresentation(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for an imagery representation.
     */
    public String getEncodedValue() {
        return encodedValue;
    }
}
