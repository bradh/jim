package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Identification Data.
 *
 * <p>Provides identification information for a given STANAG 4676-capable system.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "stationID",
    "nationalityTrigraph",
})
public class IDData {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String stationID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String nationalityTrigraph;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the station ID and nationality.
     */
    private IDData() {}

    /**
     * Constructor.
     *
     * @param stationID the station identification
     * @param nationalityTrigraph the nationality trigraph
     */
    public IDData(String stationID, String nationalityTrigraph) {
        this.stationID = stationID;
        this.nationalityTrigraph = nationalityTrigraph;
    }

    /**
     * Get the station identification.
     *
     * <p>The originating station identification, from STANAG 4545. A “station” in this context
     * refers to the algorithm that produced the tracks. A sequence of 10 alphanumeric characters,
     * the last 2 of which must be spaces.
     *
     * @return the station identification
     */
    public String getStationID() {
        return stationID;
    }

    /**
     * Set the station identification.
     *
     * <p>The originating station identification, from STANAG 4545. A “station” in this context
     * refers to the algorithm that produced the tracks. A sequence of 10 alphanumeric characters,
     * the last 2 of which must be spaces.
     *
     * @param stationID the station identification
     */
    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    /**
     * Get the nationality trigraph.
     *
     * <p>Provides the nationality of a STANAG 4676-capable system. The combination of ‘stationID’
     * and ‘nationality’ elements provides unique identification of any given STANAG 4676-capable
     * system. String of alphanumeric characters denoting 3-letter country codes, in accordance with
     * current NATO practice, e.g. APP-11(D), Annex A, Appendix 1, FFI, Geographical Entity.
     *
     * <p>In the case of a fused track, the nationality shall be that of the nation fusing the
     * tracks.
     *
     * @return the nationality trigraph
     */
    public String getNationalityTrigraph() {
        return nationalityTrigraph;
    }

    /**
     * Set the nationality trigraph.
     *
     * <p>Provides the nationality of a STANAG 4676-capable system. The combination of ‘stationID’
     * and ‘nationality’ elements provides unique identification of any given STANAG 4676-capable
     * system. String of alphanumeric characters denoting 3-letter country codes, in accordance with
     * current NATO practice, e.g. APP-11(D), Annex A, Appendix 1, FFI, Geographical Entity.
     *
     * <p>In the case of a fused track, the nationality shall be that of the nation fusing the
     * tracks.
     *
     * @param nationalityTrigraph the nationality trigraph
     */
    public void setNationalityTrigraph(String nationalityTrigraph) {
        this.nationalityTrigraph = nationalityTrigraph;
    }
}
