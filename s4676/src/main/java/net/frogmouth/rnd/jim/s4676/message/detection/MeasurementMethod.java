package net.frogmouth.rnd.jim.s4676.message.detection;

/**
 * Measurement Method.
 *
 * <p>The method by which the reported value was calculated. For example, common choices include
 * "MEAN" and "MAX".
 */
public enum MeasurementMethod implements IMeasurementMethod {
    /**
     * Mean.
     *
     * <p>Designation of standard mean as the computational method by which the value is calculated.
     */
    MEAN,
    /**
     * Maximum.
     *
     * <p>Designation of maximum as the computational method by which the value is calculated.
     */
    MAX
}
