package net.frogmouth.rnd.jim.s4676.common.shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.Dimensionality;
import net.frogmouth.rnd.jim.s4676.common.ICoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

/**
 * Abstract Shape.
 *
 * <p>The Shape class provides parameters of a bounded region on a surface or a volume. Shape itself
 * is an abstract class and will never be found directly in the data stream. Any instance where a
 * Shape is contained in an object must be satisfied by using a defined specialization of the Shape
 * class.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "cftUID", "cftLID",
})
public abstract class Shape {
    // TODO: Ellipsoid subclass.

    /**
     * XSI type.
     *
     * <p>The name of the concrete instance of Shape, such as "Polygon" or "Ellipsoid".
     */
    @JacksonXmlProperty(namespace = "http://www.w3.org/2001/XMLSchema-instance", isAttribute = true)
    protected String type;

    @JacksonXmlProperty(isAttribute = true)
    private Dimensionality dims;

    @JacksonXmlProperty(isAttribute = true)
    private ICoordinateSystemType cs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private UniqueID cftUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long cftLID;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the dimensionality and coordinate
     * system.
     */
    protected Shape() {}

    /**
     * Constructor.
     *
     * @param dims dimensionality of the shape
     * @param cs coordinate system of the shape
     */
    protected Shape(Dimensionality dims, ICoordinateSystemType cs) {
        this.dims = dims;
        this.cs = cs;
    }

    /**
     * Dimensionality.
     *
     * <p>A flag to indicate whether the shape is 2-dimensional or 3-dimensional.
     *
     * @return dimensionality value as an enumerated type
     */
    public Dimensionality getDims() {
        return dims;
    }

    /**
     * Set the dimensionality.
     *
     * <p>A flag to indicate whether the shape is 2-dimensional or 3-dimensional.
     *
     * @param dims dimensionality value as an enumerated type
     */
    public void setDims(Dimensionality dims) {
        this.dims = dims;
    }

    /**
     * Coordinate system type.
     *
     * <p>The coordinate system that applies to all of the vertices of the polygon, or all the
     * parameters of the ellipse.
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
     * <p>The coordinate system that applies to all of the vertices of the polygon, or all the
     * parameters of the ellipse.
     *
     * @param cs coordinate system type.
     */
    public void setCoordinateSystemType(ICoordinateSystemType cs) {
        this.cs = cs;
    }

    /**
     * Coordinate frame transformation unique identifier.
     *
     * <p>A UUID reference to the coordinate system transformation that describes how to convert
     * from local coordinates to an absolute coordinate system. If the points are specified in a
     * local coordinate system, then either the cftLID or cftUID is required.
     *
     * @return the unique identifier
     */
    public UniqueID getCftUID() {
        return cftUID;
    }

    /**
     * Set the coordinate frame transformation unique identifier.
     *
     * <p>A UUID reference to the coordinate system transformation that describes how to convert
     * from local coordinates to an absolute coordinate system. If the points are specified in a
     * local coordinate system, then either the cftLID or cftUID is required.
     *
     * @param cftUID the unique identifier
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
