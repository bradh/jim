package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Image background.
 *
 * <p>The primary or most prominent celestial body and its illumination state present in the space
 * object look background.
 */
public enum Background {
    /** Deep space. */
    @JsonProperty("deepSpace")
    DEEP_SPACE,

    /** Dark earth. */
    @JsonProperty("darkEarth")
    DARK_EARTH,

    /** Dark moon. */
    @JsonProperty("darkMoon")
    DARK_MOON,

    /** Lighted earth. */
    @JsonProperty("lightedEarth")
    LIGHTED_EARTH,

    /** Lighted moon. */
    @JsonProperty("lightedMoon")
    LIGHTED_MOON,

    /**
     * Penumbra earth.
     *
     * <p>The shadow cast by the Earth over an area experiencing a partial eclipse.
     */
    @JsonProperty("penumbraEarth")
    PENUMBRA_EARTH,

    /**
     * Penumbra moon.
     *
     * <p>The shadow cast by the Moon over an area experiencing a partial eclipse.
     */
    @JsonProperty("penumbraMoon")
    PENUMBRA_MOON,

    /**
     * Sun.
     *
     * <p>Earth's sun.
     */
    @JsonProperty("sun")
    SUN
}
