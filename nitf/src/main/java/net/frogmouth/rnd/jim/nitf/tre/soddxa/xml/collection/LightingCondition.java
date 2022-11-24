package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Lighting condition.
 *
 * <p>Identifies the natural illumination source of the space object.
 */
public enum LightingCondition {
    /**
     * Earth shine.
     *
     * <p>The space object is indirectly illuminated by light reflected off the Earth and its
     * atmosphere.
     */
    @JsonProperty("earthshine")
    EARTH_SHINE,

    /**
     * Moon glow.
     *
     * <p>The space object is indirectly illuminated by light reflected off the Moon.
     */
    @JsonProperty("moonGlow")
    MOON_GLOW,

    /**
     * Sunlit.
     *
     * <p>The space object is in full sunlight (daytime).
     */
    @JsonProperty("sunlit")
    SUNLIT,

    /**
     * Penumbra.
     *
     * <p>The space object is in Earth's penumbra (twilight).
     */
    @JsonProperty("penumbra")
    PENUMBRA,

    /**
     * Umbra.
     *
     * <p>The space object is in Earth's umbra (nighttime).
     */
    @JsonProperty("umbra")
    UMBRA,

    /**
     * Eclipse.
     *
     * <p>The space object is in the shadow of an eclipse.
     */
    @JsonProperty("eclipse")
    ECLIPSE
}
