package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SourceCatalogName {
    @JsonProperty("CelesTrak")
    CELESTRAK,
    @JsonProperty("LeoLabs")
    LEOLABS,
    @JsonProperty("Space-Track")
    SPACE_TRACK
}
