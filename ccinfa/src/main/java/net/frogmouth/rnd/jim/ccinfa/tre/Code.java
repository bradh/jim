package net.frogmouth.rnd.jim.ccinfa.tre;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

/**
 * CCINFA Code entry.
 *
 * <p>Each CCINFA TRE consists of one or more code entries that translate a code entry into a full
 * description.
 */
public class Code extends TreePart {

    private String code;
    private String eqtype;
    private String esurn;
    private String detail;

    /**
     * CODE field.
     *
     * <p>The a priori or ad hoc code for which a translation is provided. Codes shall not be padded
     * with BCS spaces.
     *
     * @return the code value, 1-9 BCS-A alpha-numeric values.
     */
    @TREField(label = "CODE")
    @TREOrder(order = 1)
    public String getCode() {
        return code;
    }

    /**
     * Set the CODE field.
     *
     * <p>The a priori or ad hoc code for which a translation is provided. Codes shall not be padded
     * with BCS spaces.
     *
     * @param code the code value, 1-9 BCS-A alpha-numeric values.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Equivalence type (EQTYPE).
     *
     * <p>A flag indicating the type of equivalence represented by the translation of CODEn to
     * ESURNn. Valid values are:
     *
     * <ul>
     *   <li>a BCS space, which means that the short URN-based individual item identifier ESURN
     *       value is to be interpreted as a completely equivalent indicator to the CODE value.
     *   <li>"C", which means that the short URN-based individual item identifier ESURN value is an
     *       ad hoc clarification of the a priori code specified in the CODE value.
     * </ul>
     *
     * <p>Other values may be added in the future.
     *
     * @return the equivalence type as a String.
     */
    @TREField(label = "EQTYPE")
    @TREOrder(order = 2)
    public String getEqtype() {
        return eqtype;
    }

    /**
     * Set the Equivalence type (EQTYPE).
     *
     * <p>A flag indicating the type of equivalence represented by the translation of CODEn to
     * ESURNn. Valid values are:
     *
     * <ul>
     *   <li>a BCS space, which means that the short URN-based individual item identifier ESURN
     *       value is to be interpreted as a completely equivalent indicator to the CODE value.
     *   <li>"C", which means that the short URN-based individual item identifier ESURN value is an
     *       ad hoc clarification of the a priori code specified in the CODE value.
     * </ul>
     *
     * <p>Other values may be added in the future.
     *
     * @param eqtype the equivalence type as a String.
     */
    public void setEqtype(String eqtype) {
        this.eqtype = eqtype;
    }

    /**
     * Equivalent Fully Specified Country Code (ESURN).
     *
     * <p>The equivalent fully specified country code, formatted as a short URN-based individual
     * item identifier, that is equivalent to the a priori or ad hoc code specified in CODEn. The
     * length of this field is specified by ESURN_LENn. This field is formatted per the definition
     * of a short URN-based individual item identifier as specified by the Section 5.4.4.4 of the
     * GENC standard. The value may use any concept type and codespace either defined directly by
     * the GENC standard or registered with an authoritative registrar. Padding on the left or right
     * of the identifier is not permitted.
     *
     * @return the equivalent fully specified country code for the code.
     */
    @TREField(label = "ESURN")
    @TREOrder(order = 3)
    public String getEsurn() {
        return esurn;
    }

    /**
     * Equivalent Fully Specified Country Code (ESURN).
     *
     * <p>The equivalent fully specified country code, formatted as a short URN-based individual
     * item identifier, that is equivalent to the a priori or ad hoc code specified in CODEn. The
     * length of this field is specified by ESURN_LENn. This field is formatted per the definition
     * of a short URN-based individual item identifier as specified by the Section 5.4.4.4 of the
     * GENC standard. The value may use any concept type and codespace either defined directly by
     * the GENC standard or registered with an authoritative registrar. Padding on the left or right
     * of the identifier is not permitted.
     *
     * @param esurn the equivalent fully specified country code for the code, 9 to 99 BCS-A
     *     characters.
     */
    public void setEsurn(String esurn) {
        this.esurn = esurn;
    }

    /**
     * Code detail (DETAIL).
     *
     * <p>Data is formatted per the XML schema specified by the GENC standard as specified for the
     * concept-type and codespace specified by the equivalent short URN-based individual item
     * identifier contained in the ESURN field.
     *
     * @return the detail field in in XML, or null if not set/provided.
     */
    @TREField(label = "DETAIL")
    @TREOrder(order = 4)
    public String getDetail() {
        return detail;
    }

    /**
     * Set the Code detail (DETAIL).
     *
     * <p>Data is formatted per the XML schema specified by the GENC standard as specified for the
     * concept-type and codespace specified by the equivalent short URN-based individual item
     * identifier contained in the ESURN field.
     *
     * @param detail the detail field in in XML, or null if not set/provided.
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Defined Code";
    }
}
