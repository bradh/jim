package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Orbit regime region.
 *
 * <p>The region in space associated with a system’s dominant gravitational attraction capable of
 * capturing the orbit of other space objects.
 */
public enum OrbitRegimeRegion {

    /**
     * Deep space.
     *
     * <p>An orbital trajectory designed to travel through space that may include a rendezvous with
     * a non-planetary space object.
     */
    @JsonProperty("deepSpace")
    DEEP_SPACE,

    /**
     * Low earth orbit (LEO).
     *
     * <p>A geocentric or Low Earth Orbit (LEO), generally ranging from 180 to 2,000 kilometres
     * above the Earth’s surface.
     */
    @JsonProperty("leo")
    LEO,

    /**
     * Medium earth orbit (MEO).
     *
     * <p>A geocentric or Medium Earth Orbit (MEO), generally ranging from 2,000 to just below
     * 35,786 kilometres above the Earth’s surface
     */
    @JsonProperty("meo")
    MEO,

    /**
     * Geostationary orbit (GEO).
     *
     * <p>A geocentric or Geostationary Orbit (GEO) is generally a circular High Earth Orbit (HEO)
     * with zero inclination, at an altitude of approximately 35,786 kilometres, and with an orbital
     * period equal to Earth’s rotational period (approximately 24 hours). The space object is
     * stationary (at a single longitude) relative to the Earth’s surface and directly over the
     * equator.
     */
    @JsonProperty("geo")
    GEO,

    /**
     * High earth orbit (HEO).
     *
     * <p>A geocentric or High Earth Orbit (HEO), generally at an altitude at and greater than
     * 35,786 kilometres above the Earth’s surface
     */
    @JsonProperty("heo")
    HEO,

    /**
     * Heliocentric orbit.
     *
     * <p>Any orbit around Earth’s Sun.
     */
    @JsonProperty("heliocentric")
    HELIOCENTRIC,

    /**
     * Interplanetary orbit.
     *
     * <p>An orbital trajectory to a distant planet.
     */
    @JsonProperty("interPlanetary")
    INTERPLANETARY,

    /**
     * Lunar.
     *
     * <p>Any orbit around Earth’s Moon. Also known as a Selenocentric or Cislunar Orbit.
     */
    @JsonProperty("lunar")
    LUNAR,

    /**
     * Sub-orbital.
     *
     * <p>A spaceflight in which the spacecraft may reach Earth’s atmosphere and outer space but
     * intentionally doesn’t complete one orbital revolution (it does not become an orbiting space
     * object) or reach escape velocity.
     */
    @JsonProperty("suborbital")
    SUB_ORBITAL
}
