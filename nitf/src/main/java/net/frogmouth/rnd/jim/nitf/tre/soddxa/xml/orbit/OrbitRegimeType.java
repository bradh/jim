package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Orbit regime type.
 *
 * <p>The type of the orbit regime of the space object.
 *
 * <p>This could be considered a refinement or specialisation of the related {@link
 * OrbitRegimeRegion}.
 */
public enum OrbitRegimeType {

    /**
     * Earth escape orbit.
     *
     * <p>An outward trajectory with sufficient velocity taken by a space object to escape from the
     * gravitational influence of a massive body, thus reaching an infinite distance from it. Also
     * known as Hyperbolic Orbit.
     *
     * <p>Associated with {@link OrbitRegimeRegion#DEEP_SPACE} and {@link
     * OrbitRegimeRegion#INTERPLANETARY}.
     */
    @JsonProperty("earthEscapeOrbit")
    EARTH_ESCAPE_ORBIT,

    /**
     * Earth impact orbit.
     *
     * <p>An intentional suborbital spaceflight in which the spacecraft returns to Earth’s surface
     * from which it was launched.
     *
     * <p>Associated with {@link OrbitRegimeRegion#SUB_ORBITAL}.
     */
    @JsonProperty("earthImpactOrbit")
    EARTH_IMACT_ORBIT,

    /**
     * Geosynchronous orbit.
     *
     * <p>A High Earth Orbit (HEO) with an orbital period equal to Earth’s rotational period
     * (approximately 24 hours). For a nearly circular orbit, this implies an altitude of
     * approximately 35,786 kilometres. The satellite’s orbit will not necessarily be in the same
     * direction as the rotation of the Earth, not always above the equator (zero inclination), and
     * eccentricity may not necessarily be zero. Also known as GSO.
     *
     * <p>Associated with {@link OrbitRegimeRegion#HEO}.
     */
    @JsonProperty("geosynchronousOrbit")
    GEOSYNCHRONOUS_ORBIT,

    /**
     * Molniya orbit.
     *
     * <p>An extremely elliptical (high eccentricity) Medium Earth Orbit (MEO), typically inclined
     * about 63.4° with an orbital period of about 12 hours, but the satellite spends about two-
     * thirds of that time over one hemisphere for two designated areas of the planet. The satellite
     * crosses over the same two locations at the Earth’s equator and follows the same passes every
     * 24 hours.
     *
     * <p>Associated with {@link OrbitRegimeRegion#MEO}.
     */
    @JsonProperty("molniyaOrbit")
    MOLNIYA_ORBIT,

    /**
     * Semi-synchronous orbit.
     *
     * <p>A near-circular (low eccentricity) Medium Earth Orbit (MEO) at an altitude of
     * approximately 20,200 kilometres, an orbital period of about 12 hours, and the satellite is
     * travelling in the same direction of Earth’s rotation. The satellite crosses over the same two
     * locations at the Earth’s equator every day.
     *
     * <p>Associated with {@link OrbitRegimeRegion#MEO}.
     */
    @JsonProperty("semiSynchronousOrbit")
    SEMI_SYNCHRONOUS_ORBIT,

    /**
     * Space impact orbit.
     *
     * <p>A suborbital spaceflight in which the spacecraft intentionally detonates midair.
     *
     * <p>Associated with {@link OrbitRegimeRegion#SUB_ORBITAL}.
     */
    @JsonProperty("spaceImpactOrbit")
    SPACE_IMPACT_ORBIT,

    /**
     * Super synchronous orbit.
     *
     * <p>Any High Earth Orbit (HEO) in which the orbit altitude is ≥ 35,780 km and the orbital
     * period of the satellite is greater than the Earth’s rotational period (approximately 24
     * hours).
     *
     * <p>Associated with {@link OrbitRegimeRegion#HEO}.
     */
    @JsonProperty("superSynchronousOrbit")
    SUPER_SYNCHRONOUS_ORBIT,

    /**
     * Sun synchronous orbit.
     *
     * <p>A near-circular and highly inclined (30° to 90°) Low Earth Orbit (LEO) at altitudes of
     * approximately 180 to 2,000 kilometers with an orbital period in the order of 90 minutes in
     * which the satellite travels over the polar regions. The satellite always passes over the
     * equator at the same local solar time. Also known as SSO.
     *
     * <p>Associated with {@link OrbitRegimeRegion#LEO}.
     */
    @JsonProperty("sunSynchronousOrbit")
    SUN_SYNCHRONOUS_ORBIT,

    /**
     * Transfer orbit.
     *
     * <p>An intermediate elliptical orbit that is used to transfer a satellite from one circular or
     * near- circular orbit to another in the same orbital plane, but of a different radii and
     * altitude. The orbit is typically used soon after launch and insertion as an orbital manoeuvre
     * to move a satellite from one orbit to another.
     *
     * <p>Associated with {@link OrbitRegimeRegion#LEO}.
     */
    @JsonProperty("transferOrbit")
    TRANSFER_ORBIT,

    /**
     * Tundra orbit.
     *
     * <p>An extremely elliptical (high eccentricity) geosynchronous orbit with a high inclination
     * (usually near 63.4°) and an orbital period of about 24 hours. A satellite placed in this
     * orbit spends most of its time over a chosen area of the Earth, a phenomenon known as apogee
     * dwell. The ground track of a satellite in a Tundra orbit is a closed "figure-eight"
     * lemniscate. These are conceptually similar to Molniya orbits which have the same inclination
     * but half the period (about 12 hours).
     *
     * <p>Associated with {#link OrbitRegimeRegion#MEO}.
     */
    @JsonProperty("tundraOrbit")
    TUNDRA_ORBIT
}
