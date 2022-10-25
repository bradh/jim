package net.frogmouth.rnd.jim.nitf.image;

public enum CoordinateRepresentation {

    /**
     * Unknown coordinate representation.
     *
     * <p>This denotes an unknown representation, and typically indicates a broken file or an error
     * during parsing. This is not a valid value in a NITF or NSIF image segment.
     */
    UNKNOWN("?"),

    /**
     * Military Grid Reference System (U).
     *
     * <p>Universal Transverse Mercator (UTM) expressed in Military Grid Reference System (MGRS)
     * form.
     */
    MGRS("U"),

    /** UTM/UPS Northern Hemisphere (N). */
    UTM_NORTH("N"),

    /** UTM/UPS Southern Hemisphere (S). */
    UTM_SOUTH("S"),

    /** Universal Polar Stereographic (P). */
    UPS("P"),

    /**
     * Geographic (G).
     *
     * <p>Geographic (Degrees, Minutes, Seconds).
     */
    Geographic("G"),

    /** Decimal Degrees (D). */
    DecimalDegrees("D"),

    /**
     * No coordinates.
     *
     * <p>No coordinate system is identified. If this is used, the coordinates (IGEOLO) is not
     * present.
     */
    None("");

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private CoordinateRepresentation(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for a coordinate representation.
     */
    public String getEncodedValue() {
        return encodedValue;
    }
}
