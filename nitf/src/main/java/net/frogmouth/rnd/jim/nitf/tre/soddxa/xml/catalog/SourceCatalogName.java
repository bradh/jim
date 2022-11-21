package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Source catalogue name. */
public enum SourceCatalogName {
    /**
     * CelesTrak.
     *
     * <p>Satellite data maintained by the commercial company CelesTrak and hosted on a privately
     * owned website at <a href="https://celestrak.com">https://celestrak.com</a>.
     */
    @JsonProperty("CelesTrak")
    CELESTRAK,

    /**
     * LeoLabs.
     *
     * <p>Satellite data maintained by the commercial company LeoLabs and hosted on a privately
     * owned website at <a href="https://www.leolabs.space">https://www.leolabs.space</a>.
     */
    @JsonProperty("LeoLabs")
    LEOLABS,

    /**
     * Space-Track.
     *
     * <p>The UNCLASSIFIED Satellite Catalog (SATCAT) managed and populated by the 18th Space
     * Defense Squadron (18 SPDS) of the Combined Force Space Component Command (CFSCC) and hosted
     * on the public website <a href="https://www.space-track.org">https://www.space-track.org</a>.
     */
    @JsonProperty("Space-Track")
    SPACE_TRACK
}
