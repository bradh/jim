package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FlightOrientation {
    /** Earth centre stable. */
    @JsonProperty("earthCenterStable")
    EARTH_CENTER_STABLE,

    /** Horizon stable. */
    @JsonProperty("horizonStable")
    HORIZON_STABLE,

    /**
     * Rotating.
     *
     * <p>Known motion of the satellite that could potentially be compensated for during ground
     * processing
     */
    @JsonProperty("rotating")
    ROTATING,

    /**
     * Tumbling.
     *
     * <p>Unknown or complex motion of the satellite.
     */
    @JsonProperty("tumbling")
    TUMBLING
}
