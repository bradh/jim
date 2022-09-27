package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Ellipsoid shape.
 *
 * <p>The Ellipsoid class specifies a Shape using a 2-D ellipse or 3-D ellipsoid, defined based on a
 * centre, the lengths of the axes (not the semi-axes), and the orientation of the axes with respect
 * to the coordinate system.
 *
 * <p>To specify a circle/sphere in ECEF or Local Cartesian coordinates, set all of the diagonal
 * elements of the ellipsoidParameters to the square of the radius of the circle/sphere, and set the
 * off-diagonal elements to zero.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"cftUID", "cftLID", "center", "ellipsoidParameters"})
public class Ellipsoid extends Shape {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private double[] center;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private CovarianceMatrix ellipsoidParameters;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the centre and ellipsoid
     * parameters.
     */
    private Ellipsoid() {
        type = "Ellipsoid";
    }

    /**
     * Constructor.
     *
     * <p>*
     *
     * <p>The coordinates of the centre of the ellipse or ellipsoid defined as a 9- element array of
     * doubles. These coordinates are: {@code x y z [covXX covXY covXZ covYY covYZ covZZ]}.
     *
     * <p>If defining an ellipse (rather than an ellipsoid), set z and covZZ to -1 and set covXZ and
     * covYZ to 0.
     *
     * <p>Similarly, if the uncertainty on the centre of the ellipse/ellipsoid is unknown, set the
     * diagonal covariance matrix elements (covXX, covYY, and covZZ) to -1, and the off-diagonal
     * elements (covXY, covXZ, and covYZ) to 0.
     *
     * <p>The units of the ellipse/ellipsoid centre depend upon the coordinate system defined by the
     * Shape class:
     *
     * <ul>
     *   <li>WGS 84: latitude [degrees], longitude [degrees], elevation [meters]
     *   <li>ECEF: x [meters], y [meters], z [meters]
     *   <li>ECI_J2K: x [meters], y [meters], z [meters]
     *   <li>Local Cartesian: x [meters], y [meters], z [meters]
     *   <li>Local Spherical: radial [meters], polar [degrees], azimuthal [degrees]
     *   <li>Pixel: x [pixels], y [pixels]
     * </ul>
     *
     * <p>Ellipsoid parameters is the covariance matrix that describes the shape (axis lengths and
     * orientation) of the ellipse/ellipsoid. The components of this covariance matrix are {@code
     * covXX, covXY, covXZ, covYY, covYZ, covZZ} for the 3D case or {@code covXX, covXY, covYY} for
     * the 2D case.
     *
     * <p>To make a circle/sphere using ECEF or Local Cartesian coordinates, set the off-diagonal
     * elements of the covariance matrix (covXY, covXZ, and covYZ) to 0, and set the diagonal
     * elements (covXX, covYY, covZZ) to the radius of the circle squared.
     *
     * <p>For example, a circle with a radius of 4 would be declared as: {@code <ellipsoidParameters
     * covarianceType="POS2D">16 0 16</ellipsoidParameters>}.
     *
     * @param center the centre
     * @param ellipsoidParameters the ellipsoid parameters
     */
    public Ellipsoid(double[] center, CovarianceMatrix ellipsoidParameters) {
        type = "Ellipsoid";
        this.center = center;
        this.ellipsoidParameters = ellipsoidParameters;
    }

    /**
     * Centre.
     *
     * <p>The coordinates of the centre of the ellipse or ellipsoid defined as a 9- element array of
     * doubles. These coordinates are: {@code x y z [covXX covXY covXZ covYY covYZ covZZ]}.
     *
     * <p>If defining an ellipse (rather than an ellipsoid), set z and covZZ to -1 and set covXZ and
     * covYZ to 0.
     *
     * <p>Similarly, if the uncertainty on the centre of the ellipse/ellipsoid is unknown, set the
     * diagonal covariance matrix elements (covXX, covYY, and covZZ) to -1, and the off-diagonal
     * elements (covXY, covXZ, and covYZ) to 0.
     *
     * <p>The units of the ellipse/ellipsoid centre depend upon the coordinate system defined by the
     * Shape class:
     *
     * <ul>
     *   <li>WGS 84: latitude [degrees], longitude [degrees], elevation [meters]
     *   <li>ECEF: x [meters], y [meters], z [meters]
     *   <li>ECI_J2K: x [meters], y [meters], z [meters]
     *   <li>Local Cartesian: x [meters], y [meters], z [meters]
     *   <li>Local Spherical: radial [meters], polar [degrees], azimuthal [degrees]
     *   <li>Pixel: x [pixels], y [pixels]
     * </ul>
     *
     * @return array of position and position covariance information
     */
    public double[] getCenter() {
        return center;
    }

    /**
     * Ellipsoid parameters.
     *
     * <p>The covariance matrix that describes the shape (axis lengths and orientation) of the
     * ellipse/ellipsoid. The components of this covariance matrix are {@code covXX, covXY, covXZ,
     * covYY, covYZ, covZZ} for the 3D case or {@code covXX, covXY, covYY} for the 2D case.
     *
     * <p>To make a circle/sphere using ECEF or Local Cartesian coordinates, set the off-diagonal
     * elements of the covariance matrix (covXY, covXZ, and covYZ) to 0, and set the diagonal
     * elements (covXX, covYY, covZZ) to the radius of the circle squared.
     *
     * <p>For example, a circle with a radius of 4 would be declared as: {@code <ellipsoidParameters
     * covarianceType="POS2D">16 0 16</ellipsoidParameters>}.
     *
     * @return the covariance matrix.
     */
    public CovarianceMatrix getEllipsoidParameters() {
        return ellipsoidParameters;
    }
}
