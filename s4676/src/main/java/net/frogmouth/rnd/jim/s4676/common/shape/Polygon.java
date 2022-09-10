package net.frogmouth.rnd.jim.s4676.common.shape;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.common.Dimensionality;
import net.frogmouth.rnd.jim.s4676.common.DoubleListSerialiser;
import net.frogmouth.rnd.jim.s4676.common.ICoordinateSystemType;

/**
 * Polygon shape.
 *
 * <p>The Polygon class specifies a shape using a list of polygon vertices that outline the area or
 * volume. The polygon described by this list of vertices is always a closed polygon, and therefore
 * the first point is assumed to also be the last point (in other words, there is no need to
 * explicitly state the last point of the polygon).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "nRings",
    "vertices",
})
public class Polygon extends Shape {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Integer nRings;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonSerialize(using = DoubleListSerialiser.class)
    // TODO: custom deserialiser
    // @JsonDeserialize(using = PointsListDeserialiser.class)
    private List<Double> vertices;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the dimensionality and coordinate
     * system.
     */
    private Polygon() {
        type = "Polygon";
    }

    /**
     * Constructor.
     *
     * @param dims dimensionality of the shape
     * @param cs coordinate system of the shape
     */
    // TODO: add vertices?
    public Polygon(Dimensionality dims, ICoordinateSystemType cs) {
        super(dims, cs);
        type = "Polygon";
    }

    /**
     * Number of rings.
     *
     * <p>The number of rings in the polygon as specified by the vertices attribute. One or more
     * linear rings, which when properly combined, specify a 2D or 3D region. That region can
     * consist of both multiple disjoint rings (e.g., a set of islands) and complex rings with holes
     * e.g., an island in a lake on an island). If the number of rings in the polygon is not 1, then
     * this attribute shall not be omitted.
     *
     * @return the number of rings, or null
     */
    public Integer getNumberOfRings() {
        return nRings;
    }

    /**
     * Set the number of rings.
     *
     * <p>The number of rings in the polygon as specified by the vertices attribute. One or more
     * linear rings, which when properly combined, specify a 2D or 3D region. That region can
     * consist of both multiple disjoint rings (e.g., a set of islands) and complex rings with holes
     * e.g., an island in a lake on an island). If the number of rings in the polygon is not 1, then
     * this attribute shall not be omitted.
     *
     * @param nRings the number of rings, or null
     */
    public void setNumberOfRings(Integer nRings) {
        this.nRings = nRings;
    }

    /**
     * Add vertex value.
     *
     * <p>A vertex value. These vertices are listed in the order in which they should be drawn.
     * Refer to the specific class utilizing the element..
     *
     * @param point the point value to add
     */
    public void addVertex(double point) {
        if (this.vertices == null) {
            this.vertices = new ArrayList<>();
        }
        this.vertices.add(point);
    }

    /**
     * Vertices.
     *
     * <p>A list of tuples, formatted as a single 1D array, where each tuple is one point on a ring.
     * The number of values in each tuple is equal to the number of dimensions of the polygon.
     *
     * <p>The order of the coordinates in each point is specified by the coordinate system of those
     * points.
     *
     * <p>Polygons are formed by combining one or more rings. If a ring specifies an area to be
     * contained in the region, the points shall be ordered in a clockwise direction.
     *
     * <p>If a ring specifies an area to be excluded from the region, the points shall be ordered in
     * a counter-clockwise direction.
     *
     * <p>Rings are separated by a “null point”. That point includes the same number of values as
     * the dimensionality of the polygon (e.g., 2 values for a 2D polygon). The value of each
     * coordinate in a null point shall be NaN.
     *
     * @return list of point values.
     */
    public List<Double> getVertices() {
        return this.vertices;
    }
}
