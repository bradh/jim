package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * ID Source Information.
 *
 * <p>Enables an ID fusion node to generate an ID category recommendation on the basis of all
 * relevant ID information. Guarantees therefore that the ID category recommendation is as reliable
 * as possible.
 *
 * <p>See Allied Identification Process Publication AIDPP-01, Edition A, Version 1, IDENTIFICATION
 * DATA COMBINING PROCESS (covered by STANAG 4162) for more details. Note that this document is not
 * publicly released.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "idQualityNumber",
    "sourceDeclarationBinary",
    "sourceDeclarationExtension",
    "relTimeCreation",
    "relTimeExchange",
    "idSourceNumber"
})
public class IDSourceInformation {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String idQualityNumber;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private int sourceDeclarationBinary;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private int sourceDeclarationExtension;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private long relTimeCreation;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private long relTimeExchange;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IDSourceNumber idSourceNumber;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes all the mandatory values.
     */
    private IDSourceInformation() {}

    /**
     * Constructor.
     *
     * <p>The ID Quality Number describes the quality of an ID Source Result.
     *
     * <p>The source declaration binary identifies whether a source has a positive result (e.g. IFF
     * match to IFF evaluated response).
     *
     * <p>The source declaration extension provides the encoding of the precise ID Source
     * Information, if the ID Source has more than "match" or "no match" value (e.g. IFF Code).
     *
     * <p>Relative time of creation captures the time stamp of source declaration creation as number
     * of time increments since the baseTime in the TrackMessage.
     *
     * <p>Relative time of exchange captures the time stamp of source declaration transmission by
     * the message sender as number of time increments since the baseTime in the TrackMessage
     *
     * <p>For each source instance the ID Source number comprises the information about the type of
     * the ID Source.
     *
     * @param idQualityNumber the ID quality number.
     * @param sourceDeclarationBinary the source declaration
     * @param sourceDeclarationExtension the source declaration extension
     * @param relTimeCreation relative time of creation
     * @param relTimeExchange relative time of exchange
     * @param idSourceNumber the ID source number.
     */
    public IDSourceInformation(
            String idQualityNumber,
            int sourceDeclarationBinary,
            int sourceDeclarationExtension,
            long relTimeCreation,
            long relTimeExchange,
            IDSourceNumber idSourceNumber) {
        this.idQualityNumber = idQualityNumber;
        this.sourceDeclarationBinary = sourceDeclarationBinary;
        this.sourceDeclarationExtension = sourceDeclarationExtension;
        this.relTimeCreation = relTimeCreation;
        this.relTimeExchange = relTimeExchange;
        this.idSourceNumber = idSourceNumber;
    }

    /**
     * ID quality number.
     *
     * <p>The ID Quality Number describes the quality of an ID Source Result.
     *
     * @return the ID quality number.
     */
    public String getIdQualityNumber() {
        return idQualityNumber;
    }

    /**
     * Source declaration.
     *
     * <p>Whether a source has a positive result (e.g. IFF match to IFF evaluated response).
     *
     * @return the source declaration.
     */
    public int getSourceDeclarationBinary() {
        return sourceDeclarationBinary;
    }

    /**
     * Source declaration extension.
     *
     * <p>Encoding of the precise ID Source Information, if the ID Source has more than "match" or
     * "no match" value (e.g. IFF Code).
     *
     * @return the source declaration extension
     */
    public int getSourceDeclarationExtension() {
        return sourceDeclarationExtension;
    }

    /**
     * Relative time of creation.
     *
     * <p>Captures the time stamp of source declaration creation as number of time increments since
     * the baseTime in the TrackMessage.
     *
     * @return the relative time
     */
    public long getRelTimeCreation() {
        return relTimeCreation;
    }

    /**
     * Relative time of exchange.
     *
     * <p>Captures the time stamp of source declaration transmission by the message sender as number
     * of time increments since the baseTime in the TrackMessage.
     *
     * @return the relative time
     */
    public long getRelTimeExchange() {
        return relTimeExchange;
    }

    /**
     * ID source number.
     *
     * <p>For each source instance the ID Source number comprises the information about the type of
     * the ID Source.
     *
     * @return the ID source number
     */
    public IDSourceNumber getIdSourceNumber() {
        return idSourceNumber;
    }
}
