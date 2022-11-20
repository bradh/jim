package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Regime {
    @JsonProperty("deepSpace")
    DEEP_SPACE,
    @JsonProperty("leo")
    LEO,
    @JsonProperty("meo")
    MEO,
    @JsonProperty("geo")
    GEO,
    @JsonProperty("heo")
    HEO,
    @JsonProperty("heliocentric")
    HELIOCENTRIC,
    @JsonProperty("interPlanetary")
    INTERPLANETARY,
    @JsonProperty("lunar")
    LUNAR,
    @JsonProperty("suborbital")
    SUB_ORBITAL
}
