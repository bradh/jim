package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * International designator.
 *
 * <p>The satellite unique international designator as provided by the catalogue specified in the
 * sourceCatalog element.
 *
 * <p>The USSF standard format International Designator as provided by the catalogue specified in
 * the {code sourceCatalog} element.
 *
 * <p>Identifier is of the form {@code YYYY-LLLp\{pp\}}, where:
 *
 * <ul>
 *   <li>YYYY = Year of Launch (0000 to 9999)
 *   <li>- = "-" (visual separator)
 *   <li>LLL = Launch number for the year in which the satellite was launched; 3-digit integer 000
 *       to 999 with leading zeros
 *   <li>p{pp} = Piece designator 1- to 3-character string A to ZZZ; Capital I and Capital O are
 *       excluded from valid characters.
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InternationalDesignator {

    @JacksonXmlProperty(isAttribute = true)
    private PieceType pieceType;

    @JacksonXmlText private String value;

    /**
     * Constructor.
     *
     * <p>This is only for deserialisation support. Use the version that takes piece type and
     * identifier value arguments.
     */
    public InternationalDesignator() {}

    /**
     * Constructor.
     *
     * @param pieceType the piece type as an enumerated value
     * @param value the identifier value
     */
    public InternationalDesignator(PieceType pieceType, String value) {
        this.pieceType = pieceType;
        this.value = value;
    }

    /**
     * Piece type.
     *
     * @return the piece type as an enumerated value
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * International identifier value.
     *
     * <p>{@code YYYY-LLLp\{pp\}} format.
     *
     * @return the identifier value.
     */
    public String getValue() {
        return value;
    }
}
