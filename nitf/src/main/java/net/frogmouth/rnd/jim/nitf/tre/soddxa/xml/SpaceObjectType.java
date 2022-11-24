package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Space object type.
 *
 * <p>This enumeration identifies the subject of the space object description (i.e. the thing being
 * imaged). The key distinction is between {@code satellite} and other objects types.
 */
public enum SpaceObjectType {

    /**
     * Earth.
     *
     * <p>The planet Earth.
     *
     * <p>While the SODDXA TRE is focused on imagery of space objects, it is possible to collect an
     * image of a space object that includes the Earth in the background (e.g., an image collected
     * from the International Space Station of a resupply ship on approach).
     */
    @JsonProperty("earth")
    EARTH,

    /**
     * Meteor.
     *
     * <p>A natural transitory entity (e.g., asteroid, comet).
     */
    @JsonProperty("meteor")
    METEOR,

    /**
     * Moon.
     *
     * <p>Earth's Moon.
     */
    @JsonProperty("moon")
    MOON,

    /**
     * Non-earth moon.
     *
     * <p>A moon that orbits a planet other than Earth.
     */
    @JsonProperty("nonEarthMoon")
    NON_EARTH_MOON,

    /**
     * Planet.
     *
     * <p>A planet other than Earth.
     */
    @JsonProperty("planet")
    PLANET,

    /**
     * Satellite.
     *
     * <p>An artificial or man-made satellite, including debris originating from a satellite.
     */
    @JsonProperty("satellite")
    SATELLITE,

    /**
     * Space.
     *
     * <p>Deep space (dark matter).
     */
    @JsonProperty("space")
    SPACE,

    /**
     * Spacecraft.
     *
     * <p>A manned spacecraft.
     */
    @JsonProperty("spacecraft")
    SPACECRAFT,

    /**
     * Star.
     *
     * <p>Stellar or star.
     */
    @JsonProperty("star")
    STAR,

    /**
     * Sun.
     *
     * <p>Earth's Sun
     */
    @JsonProperty("sun")
    SUN,

    /**
     * Transient object.
     *
     * <p>An unmanned, artificial or man-made transitory entity (e.g., weather balloon).
     */
    @JsonProperty("transient")
    TRANSIENT
}
