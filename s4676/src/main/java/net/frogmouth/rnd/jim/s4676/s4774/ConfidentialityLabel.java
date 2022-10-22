package net.frogmouth.rnd.jim.s4676.s4774;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Confidentiality Label.
 *
 * <p>The confidentiality label provides security labelling for the associated data object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"ConfidentialityInformation", "CreationDateTime"})
public class ConfidentialityLabel {
    @JacksonXmlProperty(
            namespace = "urn:nato:stanag:4774:confidentialitymetadatalabel:1:0",
            localName = "ConfidentialityInformation")
    private ConfidentialityInformation confidentialityInformation =
            new ConfidentialityInformation();

    @JacksonXmlProperty(
            namespace = "urn:nato:stanag:4774:confidentialitymetadatalabel:1:0",
            localName = "CreationDateTime")
    private String creationDateTime =
            ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);

    /**
     * Confidentiality information.
     *
     * <p>This is the classification and policy framework.
     *
     * @return the confidentiality information
     */
    public ConfidentialityInformation getConfidentialityInformation() {
        return confidentialityInformation;
    }

    /**
     * Set the confidentiality information.
     *
     * <p>This is the classification and policy framework.
     *
     * @param confidentialityInformation the confidentiality information
     */
    public void setConfidentialityInformation(
            ConfidentialityInformation confidentialityInformation) {
        this.confidentialityInformation = confidentialityInformation;
    }

    /**
     * Creation time.
     *
     * <p>This is the time the security label was created. It may not match the time the information
     * was created.
     *
     * @return date / time as a String.
     */
    public String getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Set the creation time.
     *
     * <p>This is the time the security label was created. It may not match the time the information
     * was created.
     *
     * @param creationDateTime date / time as a String.
     */
    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
}
