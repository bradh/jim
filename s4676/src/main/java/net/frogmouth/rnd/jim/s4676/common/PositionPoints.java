package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Position Points.
 *
 * <p>A list of position points, which can be specified in any of the six available coordinate
 * systems and can be specified in 2 or 3 dimensions (in most cases). For example, the
 * PositionPoints might describe the vertices of a tripwire. Unlike polygon vertices, the points in
 * Position Points do not (by default) form a closed shape.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"points", "cftUID", "cftLID"})
public class PositionPoints {
    @JacksonXmlProperty(isAttribute = true)
    private Dimensionality dims;

    @JacksonXmlProperty(isAttribute = true)
    private ICoordinateSystemType cs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonSerialize(using = DoubleListSerialiser.class)
    @JsonDeserialize(using = PointsListDeserialiser.class)
    private List<Double> points;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private UniqueID cftUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long cftLID;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that includes the required instance values.
     */
    private PositionPoints() {}

    /**
     * Constructor.
     *
     * @param dims the dimensionality of the points
     * @param cs the coordinate system that the points are specified in
     * @param points the values that make up the vertices of the position points
     */
    public PositionPoints(Dimensionality dims, ICoordinateSystemType cs, Double[] points) {
        this.dims = dims;
        this.cs = cs;
        this.points = List.of(points);
    }

    // TODO: cftUID getters and setters

    /**
     * Dimensionality.
     *
     * <p>The dimensionality of the position points (either 2 or 3).
     *
     * @return dimensionality value as an enumerated type
     */
    public Dimensionality getDims() {
        return dims;
    }

    /**
     * Set the dimensionality.
     *
     * <p>The dimensionality of the position points (either 2 or 3).
     *
     * @param dims dimensionality value as an enumerated type
     */
    public void setDims(Dimensionality dims) {
        this.dims = dims;
    }

    /**
     * Coordinate system type.
     *
     * <p>The coordinate system common to all position points.
     *
     * @return coordinate system type.
     */
    @JsonIgnore
    public ICoordinateSystemType getCoordinateSystemType() {
        return cs;
    }

    /**
     * Set the coordinate system type.
     *
     * <p>The coordinate system common to all position points.
     *
     * @param cs coordinate system type.
     */
    public void setCoordinateSystemType(ICoordinateSystemType cs) {
        this.cs = cs;
    }

    /**
     * Add point.
     *
     * <p>A vertex point. These vertices are listed in the order in which they should be drawn.
     * Refer to the specific class utilizing the element..
     *
     * @param point the point value to add
     */
    public void addPoint(double point) {
        if (this.points == null) {
            this.points = new ArrayList<>();
        }
        this.points.add(point);
    }

    /**
     * Points.
     *
     * <p>A list of vertices. These vertices are listed in the order in which they should be drawn.
     * Refer to the specific class utilizing the element.
     *
     * <p>The interpretation of the values in the list depends on the coordinate system type and
     * dimensionality.
     *
     * @return list of point values.
     */
    public List<Double> getPoints() {
        return this.points;
    }

    /**
     * Coordinate frame transformation unique identifier.
     *
     * <p>A UUID reference to the coordinate system transformation (see DynamicCFT) between a local
     * coordinate system and an absolute coordinate system. Only applicable if the dynamics
     * information (position, velocity, acceleration, and covariance matrix) are specified in a
     * local coordinate system.
     *
     * @return the unique identifier.
     */
    public UniqueID getCftUID() {
        return cftUID;
    }

    /**
     * Set the coordinate frame transformation unique identifier.
     *
     * <p>A UUID reference to the coordinate system transformation (see DynamicCFT) between a local
     * coordinate system and an absolute coordinate system. Only applicable if the dynamics
     * information (position, velocity, acceleration, and covariance matrix) are specified in a
     * local coordinate system.
     *
     * @param cftUID the unique identifier.
     */
    public void setCftUID(UniqueID cftUID) {
        this.cftUID = cftUID;
    }

    /**
     * Coordinate frame transformation local identifier.
     *
     * <p>A local ID reference to the coordinate system transformation that describes how to convert
     * from local coordinates to an absolute coordinate system. If the points are specified in a
     * local coordinate system, then either the cftLID or cftUID is required.
     *
     * @return the local identifier.
     */
    public Long getCftLID() {
        return cftLID;
    }

    /**
     * Set the coordinate frame transformation local identifier.
     *
     * <p>A local ID reference to the coordinate system transformation that describes how to convert
     * from local coordinates to an absolute coordinate system. If the points are specified in a
     * local coordinate system, then either the cftLID or cftUID is required.
     *
     * @param cftLID the local identifier.
     */
    public void setCftLID(Long cftLID) {
        this.cftLID = cftLID;
    }
}
