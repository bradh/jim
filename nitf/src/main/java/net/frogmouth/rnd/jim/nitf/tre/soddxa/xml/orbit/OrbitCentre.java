package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Orbit centre.
 *
 * <p>The name of the celestial body at the origin or barycentre of the space object’s orbit and
 * reference frame.
 */
public enum OrbitCentre {

    /**
     * Earth.
     *
     * <p>The planet Earth.
     */
    @JsonProperty("earth")
    EARTH,

    /**
     * Moon.
     *
     * <p>Earth's Moon.
     */
    @JsonProperty("moon")
    MOON,

    /**
     * Solar system.
     *
     * <p>The solar system.
     */
    @JsonProperty("solarSystem")
    SOLAR_SYSTEM,

    /**
     * Sun.
     *
     * <p>Earth's Sun.
     */
    @JsonProperty("sun")
    SUN
}
