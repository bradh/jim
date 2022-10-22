package net.frogmouth.rnd.jim.s4676.s4774;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * STANAG 4774 Confidentiality Information.
 *
 * <p>Contains the confidentiality label which the originator of a data object associated with a
 * data object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"PolicyIdentifier", "Classification"})
public class ConfidentialityInformation {
    @JacksonXmlProperty(
            namespace = "urn:nato:stanag:4774:confidentialitymetadatalabel:1:0",
            localName = "PolicyIdentifier")
    private String policyIdentifier = "NOT SET";

    @JacksonXmlProperty(
            namespace = "urn:nato:stanag:4774:confidentialitymetadatalabel:1:0",
            localName = "Classification")
    private String classification = "NOT SET";

    /**
     * Security Policy Identifier.
     *
     * <p>The PolicyIdentifier element is used to uniquely identify the Governing Security Policy
     * Authority which manages the security policy to which the confidentiality label relates and
     * indicates the semantics of the other confidentiality label elements and attributes.
     *
     * <p>The PolicyIdentifier element also provides an indication of the information domain that
     * governed creation of the data item.
     *
     * @return the policy identifier as a String
     */
    public String getPolicyIdentifier() {
        return policyIdentifier;
    }

    /**
     * Set the security Policy Identifier.
     *
     * <p>The PolicyIdentifier element is used to uniquely identify the Governing Security Policy
     * Authority which manages the security policy to which the confidentiality label relates and
     * indicates the semantics of the other confidentiality label elements and attributes.
     *
     * <p>The PolicyIdentifier element also provides an indication of the information domain that
     * governed creation of the data item.
     *
     * @param policyIdentifier the policy identifier as a String
     */
    public void setPolicyIdentifier(String policyIdentifier) {
        this.policyIdentifier = policyIdentifier;
    }

    /**
     * Classification.
     *
     * <p>The classification of the data object. The set of values for the Classification element,
     * and the use of these values, are defined by the Security Policy Authority (identified in the
     * PolicyIdentifier element).
     *
     * @return classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Set the classification.
     *
     * <p>The classification of the data object. The set of values for the Classification element,
     * and the use of these values, are defined by the Security Policy Authority (identified in the
     * PolicyIdentifier element).
     *
     * @param classification classification as a String.
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }
}
