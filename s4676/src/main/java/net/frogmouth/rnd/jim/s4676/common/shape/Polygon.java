package net.frogmouth.rnd.jim.s4676.common.shape;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.Dimensionality;
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

    // TODO: vertices

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
    // TODO: add vertices
    public Polygon(Dimensionality dims, ICoordinateSystemType cs) {
        super(dims, cs);
        type = "Polygon";
    }

    // TODO: getters and setters / adder
}
