package net.frogmouth.rnd.jim.s4676.common;

/**
 * Covariance type.
 *
 * <p>The covariance matrix type.
 */
public enum CovarianceType {
    /**
     * Position, three dimensional.
     *
     * <p>The covariance matrix includes 6 elements.
     */
    POS3D,
    /**
     * Position and velocity, three dimensional.
     *
     * <p>The covariance matrix includes 21 elements.
     */
    VEL3D,
    /**
     * Position, velocity and acceleration, three dimensional.
     *
     * <p>The covariance matrix includes 45 elements.
     */
    ACC3D,
    /**
     * Position, two dimensional.
     *
     * <p>The covariance matrix includes 3 elements.
     */
    POS2D,
    /**
     * Position and velocity, two dimensional.
     *
     * <p>The covariance matrix includes 10 elements.
     */
    VEL2D,
    /**
     * Position, velocity and acceleration, two dimensional.
     *
     * <p>The covariance matrix includes 21 elements.
     */
    ACC2D
}
