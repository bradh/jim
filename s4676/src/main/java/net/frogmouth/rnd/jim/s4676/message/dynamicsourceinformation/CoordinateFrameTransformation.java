package net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemType;

/**
 * Coordinate frame transformation.
 *
 * <p>The CoordinateFrameTransformation class specifies the transformation from coordinates in an
 * absolute Cartesian coordinate system (e.g., {@code ECEF} or {@code ECI_J2K}) to a local Cartesian
 * coordinate system through a translation vector and rotation matrix.
 *
 * <p>Whenever a class (such as track point or tracked object outlines) utilizes a specific local
 * coordinate system, data producers shall include the transformation of that local coordinate
 * system back to absolute coordinates, as long as that transformation is known at the time of
 * generation of the STANAG 4676 data. In cases where the tracker does not know the absolute
 * location or orientation of the data, data consumers must be able to handle the case where local
 * coordinates cannot be mapped back to absolute coordinates without combining the STANAG 4676 data
 * file with other data sources.
 *
 * <p>While the name of the {@code from} attribute of the CoordinateFrameTransformation implies a
 * specific transformation in one direction, the translation vector and rotation matrix can easily
 * be used to convert from either absolute coordinates to local coordinates or from local
 * coordinates to absolute coordinates.
 */
public class CoordinateFrameTransformation {
    @JacksonXmlProperty(isAttribute = true)
    private final CoordinateSystemType from;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private final Double[] translation;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private final Double[] rotation;

    /**
     * Constructor.
     *
     * <p>{@code from} specifies the absolute Cartesian coordinate system from which local
     * coordinates are referenced. Values are restricted to ECEF and ECI_J2K, as well as any
     * additional absolute Cartesian coordinate systems registered with the custodial support team.
     * This field shall not be set to local, spherical or geodetic coordinate systems.
     *
     * <p>{@code translation} specifies the translation between the CoordinateSystemType specified
     * by the “from” attribute and the origin of the local coordinate system. The translation
     * attribute shall contain a list of three double values in the order T<sub>1</sub>,
     * T<sub>2</sub>, T<sub>3</sub>.
     *
     * <p>{@code rotation} specifies the rotation and scaling factors between the
     * CoordinateSystemType specified by the {@code from} attribute and the local coordinate system.
     * The rotation attribute shall contain a list of nine double values in the order R<sub>1</sub>,
     * R<sub>2</sub>, R<sub>3</sub>, R<sub>4</sub>, R<sub>5</sub>, R<sub>6</sub>, R<sub>7</sub>,
     * R<sub>8</sub>, R<sub>9</sub>.
     *
     * @param from the source coordinate reference system
     * @param translation the three element translation vector
     * @param rotation the nine element rotation vector
     */
    public CoordinateFrameTransformation(
            CoordinateSystemType from, Double[] translation, Double[] rotation) {
        this.from = from;
        this.translation = translation;
        this.rotation = rotation;
    }

    /**
     * Source coordinate reference system.
     *
     * <p>The absolute Cartesian coordinate system from which local coordinates are referenced.
     * Values are restricted to ECEF and ECI_J2K, as well as any additional absolute Cartesian
     * coordinate systems registered with the custodial support team. This field shall not be set to
     * local, spherical or geodetic coordinate systems.
     *
     * @return the coordinate reference system
     */
    public CoordinateSystemType getFrom() {
        return from;
    }

    /**
     * Translation part of the transformation.
     *
     * <p>The translation between the CoordinateSystemType specified by the “from” attribute and the
     * origin of the local coordinate system. The translation attribute shall contain a list of
     * three double values in the order T<sub>1</sub>, T<sub>2</sub>, T<sub>3</sub>.
     *
     * @return array of three translation values.
     */
    public Double[] getTranslation() {
        return translation;
    }

    /**
     * Rotation part of the transformation.
     *
     * <p>The rotation and scaling factors between the CoordinateSystemType specified by the {@code
     * from} attribute and the local coordinate system. The rotation attribute shall contain a list
     * of nine double values in the order R<sub>1</sub>, R<sub>2</sub>, R<sub>3</sub>,
     * R<sub>4</sub>, R<sub>5</sub>, R<sub>6</sub>, R<sub>7</sub>, R<sub>8</sub>, R<sub>9</sub>.
     *
     * @return array of nine rotation values.
     */
    public Double[] getRotation() {
        return rotation;
    }
}
