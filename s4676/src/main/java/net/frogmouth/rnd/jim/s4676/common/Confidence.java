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
    // TODO: sourceReliability
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private boolean valid;

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
        this.valid = true;
    }

    // TODO: getters and setters
}
