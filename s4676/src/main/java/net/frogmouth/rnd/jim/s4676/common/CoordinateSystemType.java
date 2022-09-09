package net.frogmouth.rnd.jim.s4676.common;

/** Coordinate system type. */
public enum CoordinateSystemType implements ICoordinateSystemType {
    /**
     * WGS 84 Geodetic coordinates.
     *
     * <p>When using this coordinate system, the third axis of the position, velocity, and
     * acceleration vectors (related to elevation) are optional (but must either be reported for all
     * three vectors, or not reported for any of the three vectors). Similarly, the covariance
     * matrix elements related to elevation do not need to be reported if the elevation is not
     * reported in the position, velocity, and acceleration vectors.
     *
     * <ul>
     *   <li>Position [units]: latitude [decimal degrees], longitude [decimal degrees], ellipsoid
     *       height [meters]
     *   <li>velocity: latitude speed [degrees/second], longitude speed [degrees/second], elevation
     *       speed [meters/second]
     *   <li>acceleration: latitude acceleration [degrees/s<sup>2</sup>], longitude acceleration
     *       [degrees/s<sup>2</sup>], elevation acceleration [m/s<sup>2</sup>]
     *   <li>covariance: PosLatLat, PosLatLon, [PosLatEle], PosLonLon, [PosLonEle, PosEleEle],
     *       [VelLatLat, ...]
     * </ul>
     *
     * <p>A reminder that all blocks must have self-consistent units. If the data producer wishes to
     * specify velocities and accelerations with reference to a local Cartesian coordinate system,
     * he or she must declare a second Dynamics block (with the CoordinateSystemType {@code
     * LOCAL_CARTESIAN}).
     */
    WGS_84,

    /**
     * WGS 84 ECEF coordinates.
     *
     * <p>In this absolute coordinate system, the origin is the center of mass of the Earth, and the
     * x, y, and z axes (respectively) are defined by lines that pass between the center of mass of
     * the Earth and:
     *
     * <ul>
     *   <li>(x-axis) the intersection of the Equator and the Prime Meridian
     *   <li>(y-axis) the intersection of the Equator and +90&deg; longitude
     *   <li>(z-axis) true north
     * </ul>
     *
     * <p>Positions are specified in meters, velocities are specified in meters/second, and
     * accelerations are specified in meters/second<sup>2</sup>.
     */
    ECEF,

    /**
     * ECI coordinates (J2000).
     *
     * <p>In this absolute coordinate system, the origin is the center of mass of the Earth, and the
     * x, y, and z axes (respectively) are defined by lines that pass from the origin and:
     *
     * <ul>
     *   <li>(x-axis) the intersection of the Equator and the Prime Meridian at 12:00 Terrestrial
     *       Time on 1 January 2000.
     *   <li>(y-axis) the intersection of the Equator and +90&deg; longitude at 12:00 Terrestrial
     *       Time on 1 January 2000.
     *   <li>(z-axis) true north at 12:00 Terrestrial Time on 1 January 2000.
     * </ul>
     *
     * <p>Positions are specified in meters, velocities are specified in meters/second, and
     * accelerations are specified in meters/second<sup>2</sup>.
     */
    ECI_J2K,

    /**
     * Local Cartesian coordinates.
     *
     * <p>When using this coordinate system, the third axis of the position, velocity, and
     * acceleration vectors (related to z) are optional (but must either be reported for all three
     * vectors, or not reported for any of the three vectors). Similarly, the covariance matrix
     * elements related to z do not need to be reported if the elevation is not reported in the
     * position, velocity, and acceleration vectors.
     *
     * <ul>
     *   <li>Position: x [meters], y [meters], z [meters]
     *   <li>velocity: x speed [m/s], y speed [m/s], z speed [m/s]
     *   <li>acceleration: x acceleration [m/s<sup>2</sup>], y acceleration [m/s<sup>2</sup>], z
     *       acceleration [m/s<sup>2</sup>]
     *   <li>covariance: PosXX, PosXY, [PosXZ], PosYY, [PosYZ, PosZZ], [VelXX, ...]
     * </ul>
     *
     * <p>In most cases, using this coordinate system will require stating a coordinate system
     * transformation (referenced via cftUID or cftLID). The only case in which a coordinate system
     * transformation is not required is when the data producer cannot associate the local Cartesian
     * coordinate system to an absolute reference system.
     */
    LOCAL_CARTESIAN,

    /**
     * Local spherical coordinates.
     *
     * <p>When using this coordinate system, the azimuthal axis of the position, velocity, and
     * acceleration vectors are optional (but must either be reported for all three vectors, or not
     * reported for any of the three vectors). Similarly, the covariance matrix elements related to
     * the azimuth do not need to be reported if it is not reported in the position, velocity, and
     * acceleration vectors.
     *
     * <ul>
     *   <li>Position: radial [meters], polar [degrees], azimuthal [degrees]
     *   <li>velocity: radial speed [m/s], polar speed [deg/s], azimuthal speed [deg/s]
     *   <li>acceleration: radial acceleration [m/s<sup>2</sup>], polar acceleration
     *       [deg/s<sup>2</sup>], azimuthal acceleration [deg/s<sup>2</sup>]
     *   <li>covariance: PosRR, PosRP, [PosRA], PosPP, [PosPA, PosAA], [VelRR, ...]
     * </ul>
     *
     * <p>In most cases, using this coordinate system will require stating a coordinate system
     * transformation (referenced via cftUID or cftLID). The only case in which a coordinate system
     * transformation is not required is when the data producer cannot associate the local spherical
     * or polar coordinate system to an absolute reference system.
     */
    LOCAL_SPHERICAL,

    /**
     * Pixel coordinates.
     *
     * <p>This coordinate system only has two axes: x and y. As with every coordinate system, the
     * velocity and acceleration are optional, and the covariance should have a number of elements
     * appropriate for the position, velocity, and acceleration values in this dynamics block.
     *
     * <ul>
     *   <li>Position: x [pixels], y [pixels]
     *   <li>velocity: x speed [pixels/second], y speed [pixels/second]
     *   <li>acceleration: x acceleration [pixels/s<sup>2</sup>], y acceleration
     *       [pixels/s<sup>2</sup>]
     *   <li>covariance: PosXX, PosXY, PosYY, [VelXX, VelXY, VelYY, AccXX, AccXY, AccYY]
     * </ul>
     */
    PIXELS
}
