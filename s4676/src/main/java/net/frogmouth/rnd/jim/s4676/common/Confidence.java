package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Confidence.
 *
 * <p>A set of information that describes the producer’s confidence in a particular measurement.
 *
 * <p>The Confidence block, when used in addition to a class’s lid or uid, can be used by the data
 * producer to update previously-reported information. For example, if the data producer decides
 * that a previously-reported track correlation did not actually happen as reported, the data
 * producer can report a new trackLinkage with the same lid or uid as the old one, and with a new
 * confidence.valid of INVALID (valid=FALSE). The data consumer will know which information is the
 * most up-to-date via the creation time of the root element. In order for this to be true, the data
 * producer should not be overriding values within a single root element. In other words, when the
 * data producer wishes to update a previously-reported value, they must close the root element and
 * start a new one.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"value", "sourceReliability", "valid"})
public class Confidence {

    @JacksonXmlProperty(isAttribute = true)
    private CertaintyStatisticType type;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private int value;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Integer sourceReliability;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Boolean valid;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the certainty statistic type and
     * value.
     */
    private Confidence() {}

    /**
     * Constructor.
     *
     * @param statisticType the type of confidence measure being reported
     * @param value the value (meaning depends on statistic type)
     */
    public Confidence(CertaintyStatisticType statisticType, int value) {
        this.type = statisticType;
        this.value = value;
    }

    /**
     * Certainty statistic type.
     *
     * <p>Extends means to determine value of Confidence beyond percentage certainty to include
     * P-Values and T-Statistical tests.
     *
     * @return type of confidence being reported.
     */
    public CertaintyStatisticType getType() {
        return type;
    }

    /**
     * Set the certainty statistic type.
     *
     * <p>Extends means to determine value of Confidence beyond percentage certainty to include
     * P-Values and T-Statistical tests.
     *
     * @param type type of confidence being reported.
     */
    public void setType(CertaintyStatisticType type) {
        this.type = type;
    }

    /**
     * Confidence value.
     *
     * <p>Provides a level of confidence or certainty. Allowed values are 0 to 100, indicating a
     * percentage of certainty. No guidance is imposed on how this percentage is calculated, as it
     * will vary depending on the class from which the enumeration is called. The value 0 indicates
     * no confidence; a value of 100 indicates the highest possible confidence. This field is
     * intended to be analogous to credibility (of information) criteria specified in AJP 2.1, whose
     * values range from 1 to 6, but no assignment of qualitative confidence statements is imposed
     * on specific ranges of percentages.
     *
     * @return confidence value
     */
    public int getValue() {
        return value;
    }

    /**
     * Set confidence value.
     *
     * <p>Provides a level of confidence or certainty. Allowed values are 0 to 100, indicating a
     * percentage of certainty. No guidance is imposed on how this percentage is calculated, as it
     * will vary depending on the class from which the enumeration is called. The value 0 indicates
     * no confidence; a value of 100 indicates the highest possible confidence. This field is
     * intended to be analogous to credibility (of information) criteria specified in AJP 2.1, whose
     * values range from 1 to 6, but no assignment of qualitative confidence statements is imposed
     * on specific ranges of percentages.
     *
     * @param value confidence value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Source reliability.
     *
     * <p>Provides a measure of confidence in the reliability of the source that generated the
     * confidence value. Source may be a person, algorithm, exploitation/tracker system, or
     * unit/organization. Allowed values are 0 to 100. The value 0 indicates no reliability; a value
     * of 100 indicates the highest possible reliability. This field is intended to be analogous to
     * reliability (of source) criteria specified in AJP 2.1, whose values range from A to F, but no
     * assignment of qualitative reliability statements is imposed on specific ranges of
     * percentages.
     *
     * @return source reliability, or null if not set
     */
    public Integer getSourceReliability() {
        return sourceReliability;
    }

    /**
     * Set the source reliability.
     *
     * <p>Provides a measure of confidence in the reliability of the source that generated the
     * confidence value. Source may be a person, algorithm, exploitation/tracker system, or
     * unit/organization. Allowed values are 0 to 100. The value 0 indicates no reliability; a value
     * of 100 indicates the highest possible reliability. This field is intended to be analogous to
     * reliability (of source) criteria specified in AJP 2.1, whose values range from A to F, but no
     * assignment of qualitative reliability statements is imposed on specific ranges of
     * percentages.
     *
     * @param sourceReliability source reliability, or null
     */
    public void setSourceReliability(Integer sourceReliability) {
        this.sourceReliability = sourceReliability;
    }

    /**
     * Validity.
     *
     * <p>A logical Boolean, to be used when the data producer wishes to validate or invalidate
     * previously-reported information. Specifically, this value should be set to:
     *
     * <ul>
     *   <li>FALSE when the data producer decides that the previously-reported associated
     *       information was not correctly associated (example: a previously-reported track segment
     *       actually belongs to a different track)
     *   <li>TRUE when the data producer decides that a previously-reported FALSE value was actually
     *       incorrect (example: the data producer decides they were wrong when they said that
     *       previously-reported track did not belong to its original track).
     * </ul>
     *
     * <p>This attribute is unnecessary if the data producer is not invalidating previously-reported
     * information.
     *
     * @return validity, or null if not set
     */
    public Boolean isValid() {
        return valid;
    }

    /**
     * Set the validity.
     *
     * <p>A logical Boolean, to be used when the data producer wishes to validate or invalidate
     * previously-reported information. Specifically, this value should be set to:
     *
     * <ul>
     *   <li>FALSE when the data producer decides that the previously-reported associated
     *       information was not correctly associated (example: a previously-reported track segment
     *       actually belongs to a different track)
     *   <li>TRUE when the data producer decides that a previously-reported FALSE value was actually
     *       incorrect (example: the data producer decides they were wrong when they said that
     *       previously-reported track did not belong to its original track).
     * </ul>
     *
     * <p>This attribute is unnecessary if the data producer is not invalidating previously-reported
     * information.
     *
     * @param valid validity, or null
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
