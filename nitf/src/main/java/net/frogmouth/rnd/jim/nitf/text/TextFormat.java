package net.frogmouth.rnd.jim.nitf.text;

public enum TextFormat {

    /**
     * Unknown text format.
     *
     * <p>This indicates an unknown format, and typically indicates a broken file or an error during
     * parsing. This is not a valid value in a NITF or NSIF text segment.
     */
    UNKNOWN(""),

    /**
     * Message Text Formatting (MTF).
     *
     * <p>MTF indicates that the text data segment contains BCS-A characters formatted according to
     * STANAG 5500 (NSIF) or MIL-STD-6040 (NITF).
     */
    USMTF("MTF"),

    /**
     * Standard (STA).
     *
     * <p>Standard designates BCS character codes in a simple format. Any BCS code may be used in
     * the text data segment when STA is indicated in the TXTFMT field.
     *
     * <p>The encoding requires carriage return followed by line feed to separate lines (or
     * paragraphs).
     */
    Standard("STA"),

    /**
     * ECS Text Formatting (UT1).
     *
     * <p>UT1 is a legacy formatting replaced by the U8S text formatting (U8S). UT1 text formatting
     * uses ECS character codes. Any ECS code may be used in the Text Data Segment when UT1 is
     * indicated in the TXTFMT field.
     *
     * <p>The encoding requires carriage return followed by line feed to separate lines (or
     * paragraphs).
     */
    ExtendedCharacterSet("UT1"),

    /**
     * U8S Text Formatting (U8S).
     *
     * <p>The U8S text formatting replaces the legacy ECS text formatting (UT1). U8S text formatting
     * uses U8S character codes. Any U8S character (either 1-byte or 2- byte encoded) may be used in
     * the Text Data Segment when U8S is indicated in the TXTFMT field.
     *
     * <p>The encoding requires carriage return followed by line feed to separate lines (or
     * paragraphs).
     */
    UTF8Subset("U8S");

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private TextFormat(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for a text format.
     */
    public String getEncodedValue() {
        return encodedValue;
    }

    /**
     * Look up a text format value by identifier.
     *
     * @param identifier the code for the value type.
     * @return text format corresponding to the string identifier.
     */
    public static TextFormat lookupByIdent(String identifier) {
        for (TextFormat textFormat : TextFormat.values()) {
            if (textFormat.getEncodedValue().equals(identifier)) {
                return textFormat;
            }
        }
        return UNKNOWN;
    }
}
