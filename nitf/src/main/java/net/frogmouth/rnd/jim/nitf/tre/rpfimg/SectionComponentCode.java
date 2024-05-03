package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

import static net.frogmouth.rnd.jim.nitf.image.PixelValueType.UNKNOWN;

import net.frogmouth.rnd.jim.nitf.image.*;

/**
 * Section / component codes.
 *
 * <p>See MIL-STD-2411-1 Table II.
 */
public enum SectionComponentCode {

    /**
     * Unknown section / component.
     *
     * <p>This typically indicates a broken file or an error during parsing. This is not a valid
     * value.
     */
    UNKNOWN(0, "unknown (invalid)"),

    Header(128, "header component"),
    Location(129, "location component"),
    Coverage(130, "coverage section subheader"),
    Compression(131, "compression section subheader"),
    CompressionLookup(132, "compression lookup subsection"),
    ColorGrayscale(134, "color/grayscale section subheader"),
    Colormap(135, "colourmap subsection"),
    ImageDescription(136, "image description subheader"),
    ImageDisplay(137, "image display parameters subheader"),
    Mask(138, "mask subsection"),
    SpatialData(140, "spatial data subsection"),
    AttributeSection(141, "attribute section subheader"),
    Attribute(142, "attribute subsection");
    // TODO: more values

    private final int encodedValue;
    private final String description;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param id the identifier for the enumeration value.
     * @param textDescription the text description for the enumeration value.
     */
    private SectionComponentCode(final int id, final String textDescription) {
        this.encodedValue = id;
        this.description = textDescription;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for the section/component.
     */
    public int getEncodedValue() {
        return encodedValue;
    }

    /**
     * String description.
     *
     * @return the string description for the section / component.
     */
    public String getStringDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return getStringDescription();
    }

    /**
     * Look up a section / component value type value by identifier.
     *
     * @param identifier the code for the value type.
     * @return section / component type corresponding to the identifier.
     */
    public static SectionComponentCode lookupByIdent(int identifier) {
        for (SectionComponentCode code : SectionComponentCode.values()) {
            if (code.getEncodedValue() == identifier) {
                return code;
            }
        }
        System.out.println("Unhandled ident: " + identifier);
        return UNKNOWN;
    }
}
