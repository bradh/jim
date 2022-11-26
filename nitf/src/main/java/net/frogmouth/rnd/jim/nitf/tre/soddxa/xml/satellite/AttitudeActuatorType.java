package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Attitude actuator type.
 *
 * <p>The satellite's type of actuator used for attitude control.
 */
public enum AttitudeActuatorType {

    /** Active magnetic torque. */
    @JsonProperty("activeMagTorque")
    ACTIVE_MAG_TORQUE,

    /** Attitude thrusters. */
    @JsonProperty("attitudeThrusters")
    ATTITUDE_THRUSTERS,

    /** Control moment gyroscopes (CMGs). */
    @JsonProperty("controlMomentGyros")
    CONTROL_MOMENT_GYROS,

    /** Momentum wheels. */
    @JsonProperty("momentumWheels")
    MOMENTUM_WHEELS,

    /** Passive magnetic torque */
    @JsonProperty("passiveMagTorque")
    PASSIVE_MAG_TORQUE,

    /** Reaction wheels. */
    @JsonProperty("reactionWheels")
    REACTION_WHEELS,

    /** Solar sail. */
    @JsonProperty("solarSail")
    SOLAR_SAIL
}
