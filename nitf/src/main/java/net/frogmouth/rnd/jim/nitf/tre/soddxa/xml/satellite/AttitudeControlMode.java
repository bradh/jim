package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Attitude control mode.
 *
 * <p>The satellite's primary mode of attitude control.
 */
public enum AttitudeControlMode {

    /**
     * Three axis.
     *
     * <p>Three-axis stabilization.
     */
    @JsonProperty("threeAxis")
    THREE_AXIS,

    /**
     * Spin.
     *
     * <p>Spin stabilization.
     */
    @JsonProperty("spin")
    SPIN,

    /** Tumbling. */
    @JsonProperty("tumbling")
    TUMBLING,

    /**
     * Gravity gradient.
     *
     * <p>Gravity gradient stabilization.
     */
    @JsonProperty("gravityGradient")
    GRAVITY_GRADIENT
}
