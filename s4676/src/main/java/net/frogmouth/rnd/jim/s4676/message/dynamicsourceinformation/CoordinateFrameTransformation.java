package net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;

/**
 * Coordinate frame transformation.
 *
 * <p>The CoordinateFrameTransformation class specifies the transformation from coordinates in an
 * absolute Cartesian coordinate system (e.g., ECEF or ECI_J2K) to a local Cartesian coordinate
 * system through a translation vector and rotation matrix.
 *
 * <p>Whenever a class (such as track point or tracked object outlines) utilizes a specific local
 * coordinate system, data producers shall include the transformation of that local coordinate
 * system back to absolute coordinates, as long as that transformation is known at the time of
 * generation of the STANAG 4676 data. In cases where the tracker does not know the absolute
 * location or orientation of the data, data consumers must be able to handle the case where local
 * coordinates cannot be mapped back to absolute coordinates without combining the STANAG 4676 data
 * file with other data sources.
 *
 * <p>While the name of the “from” attribute of the CoordinateFrameTransformation implies a specific
 * transformation in one direction, the translation vector and rotation matrix can easily be used to
 * convert from either absolute coordinates to local coordinates or from local coordinates to
 * absolute coordinates.
 */
public class CoordinateFrameTransformation {
    // TODO: members
    // TODO: constructors
    // TODO: getters and setters
}
