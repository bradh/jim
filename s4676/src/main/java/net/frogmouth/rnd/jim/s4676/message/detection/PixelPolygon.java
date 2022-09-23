package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.frogmouth.rnd.jim.s4676.serde.PixelPolygonDeserialiser;

/**
 * Pixel polygon.
 *
 * <p>A list of pixels that specify the vertices of a polygon (in pixel space). The polygon is
 * traced by the centres of the pixels, which are assumed to be integer values, with the top-left
 * pixel corresponding to row 0, column 0. There is no explicit need to close the polygon – that is,
 * the first pixel is assumed to also be the last pixel in the polygon trace.
 *
 * <p>A simple example is shown in the figure below. In this case, the vertices that describe the
 * polygon outline in pixels are (listed with parentheses around each row, column pair for
 * readability):{@code (3, 1), (3, 3), (2, 3), (3, 3), (3, 6), (3, 5), (4, 5), (4, 3), (6, 3), (3,
 * 3)}
 *
 * <p><img src="../../../../../../../../resources/pixelmask.png" alt="">
 *
 * <p>NOTE: If converting data from a ST0903 data source into STANAG 4676, pixel coordinates must be
 * translated from 1-based to 0-based coordinates.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(using = PixelPolygonDeserialiser.class)
public class PixelPolygon {
    @JacksonXmlProperty(isAttribute = true)
    private Integer numRings;

    @JsonIgnore private List<Integer> integerArray;

    /**
     * Constructor.
     *
     * <p>Note that at least some coordinate points are required.
     */
    public PixelPolygon() {}

    /**
     * Number of rings.
     *
     * <p>The number of rings in the polygon as specified by the inherited integerArray attribute.
     * One or more linear rings, which when properly combined, specify a complex 2D region. That
     * region can consist of both multiple disjoint rings (e.g., a set of islands) and complex rings
     * with holes e.g., an island in a lake on an island). If the number of rings in the polygon is
     * not 1, then this attribute shall not be omitted.
     *
     * @return number of rings.
     */
    public Integer getNumRings() {
        return numRings;
    }

    /**
     * Set the number of rings.
     *
     * <p>The number of rings in the polygon as specified by the inherited integerArray attribute.
     * One or more linear rings, which when properly combined, specify a complex 2D region. That
     * region can consist of both multiple disjoint rings (e.g., a set of islands) and complex rings
     * with holes e.g., an island in a lake on an island). If the number of rings in the polygon is
     * not 1, then this attribute shall not be omitted.
     *
     * @param numRings the number of rings
     */
    public void setNumRings(Integer numRings) {
        this.numRings = numRings;
    }

    /**
     * Get the coordinate points.
     *
     * <p>A list of integers that specifies pairs of row, columns values from the image. This list
     * can contain any even number of elements. The order of these elements for a single ring is:
     * [row_1, col_1, row_2, col_2, ... row_n, col_n]. The ordering of points within a ring
     * (controlling whether the ring is included or excluded area) and the syntax for delimiting
     * rings is specified in AEDP-12 Section 2.1.1.9. The coordinate values in a null point
     * delimiting the rings in the polygon shall be all set to -1.
     *
     * <p>Note that the order of coordinates for an individual point is the opposite of the order
     * for the PIXELS coordinate space for generic shapes and points.
     *
     * @return row / column coordinates list
     */
    @JsonIgnore
    public List<Integer> getIntegerArray() {
        return integerArray;
    }

    /**
     * Get the coordinate points as a String.
     *
     * <p>A list of integers that specifies pairs of row, columns values from the image. This list
     * can contain any even number of elements. The order of these elements for a single ring is:
     * [row_1, col_1, row_2, col_2, ... row_n, col_n]. The ordering of points within a ring
     * (controlling whether the ring is included or excluded area) and the syntax for delimiting
     * rings is specified in AEDP-12 Section 2.1.1.9. The coordinate values in a null point
     * delimiting the rings in the polygon shall be all set to -1.
     *
     * <p>Note that the order of coordinates for an individual point is the opposite of the order
     * for the PIXELS coordinate space for generic shapes and points.
     *
     * <p>This is mainly intended for serialisation.
     *
     * @return row / column coordinates flattened into a String
     */
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonValue
    public String getIntegerArrayAsString() {
        return integerArray.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    /**
     * Add a coordinate value to the coordinate points.
     *
     * @param integer the value to add
     */
    public void addCoordinateValue(Integer integer) {
        if (this.integerArray == null) {
            this.integerArray = new ArrayList<>();
        }
        this.integerArray.add(integer);
    }

    /**
     * Add a coordinate pair to the coordinate points.
     *
     * @param row the row value to add
     * @param col the column value to add
     */
    public void addCoordinate(int row, int col) {
        addCoordinateValue(row);
        addCoordinateValue(col);
    }
}
