package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Piece type.
 *
 * <p>A descriptive term identifying a satellite component. This value is conditionally present
 * dependent on the population of its {@code internationalDesignator} parent element, as provided by
 * the catalogue specified in the {@code sourceCatalog} element.
 */
public enum PieceType {
    /**
     * Debris.
     *
     * <p>The defunct artificial objects in Earth's orbit which no longer serve a useful function.
     */
    @JsonProperty("debris")
    DEBRIS,

    /**
     * Payload.
     *
     * <p>The satellite or entity which is being carried by an aircraft or launch vehicle.
     */
    @JsonProperty("payload")
    PAYLOAD,

    /**
     * Platform.
     *
     * <p>The structure on which a particular sensor(s) is mounted and housed.
     */
    @JsonProperty("platform")
    PLATFORM,

    /**
     * Rocket body.
     *
     * <p>A cylinder that holds the propellant and rocket engine, and usually includes the attached
     * fins.
     */
    @JsonProperty("rocketBody")
    ROCKET_BODY,

    /**
     * Shroud.
     *
     * <p>The payload fairing equipment, which is typically composed of two parts, houses and
     * protects the payload during launch and ascent through the atmosphere.
     */
    @JsonProperty("shroud")
    SHROUD,

    /**
     * Sub-orbital payload.
     *
     * <p>A rocket payload that travels to the outer-edge of Earth's atmosphere but does not reach a
     * sufficient speed or the orbital velocity required to enter orbit and therefore will not
     * complete one orbital revolution and returns to Earth's surface in a suborbital trajectory.
     */
    @JsonProperty("subOrbitalPayload")
    SUBORBITAL_PAYLOAD
}
