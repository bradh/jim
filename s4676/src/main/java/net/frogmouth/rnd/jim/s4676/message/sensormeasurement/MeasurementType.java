package net.frogmouth.rnd.jim.s4676.message.sensormeasurement;

/**
 * Measurement Type.
 *
 * <p>The specific quantity being reported.
 */
public enum MeasurementType implements IMeasurementType {

    /**
     * Signal to Noise Ratio.
     *
     * <p>The Signal-to-Noise Ratio. This quantity is unitless.
     */
    SNR,
    /**
     * Radiant intensity.
     *
     * <p>The radiant flux received per unit solid angle. This quantity has units of W sr -1 Hz-1
     */
    RADIANT_INTENSITY,
    /**
     * Radiance.
     *
     * <p>The radiant flux reflected by a surface, per unit solid angle per unit projected area.
     * This quantity has units of W sr-1 m-2.
     */
    RADIANCE,
    /**
     * Directional reflectance.
     *
     * <p>Radiance reflected by a surface, divided by the radiance received by that surface. This
     * quantity is unitless.
     */
    DIRECTIONAL_REFLECTANCE
}
