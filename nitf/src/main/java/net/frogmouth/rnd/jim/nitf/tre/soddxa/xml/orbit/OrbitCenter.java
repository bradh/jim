package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrbitCenter {
    @JsonProperty("earth")
    EARTH,
    @JsonProperty("moon")
    MOON,
    @JsonProperty("solarSystem")
    SOLAR_SYSTEM,
    @JsonProperty("sun")
    SUN
}
