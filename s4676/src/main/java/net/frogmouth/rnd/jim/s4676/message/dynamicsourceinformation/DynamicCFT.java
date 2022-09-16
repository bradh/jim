package net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;

/**
 * Dynamic coordinate frame transformation.
 *
 * <p>The DynamicCFT class specifies a coordinate frame transformation (CFT) that applies to data
 * taken at a particular instance in time.
 *
 * <p>The {@code uid} or {@code lid} is required.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "cft"})
public class DynamicCFT extends IdentifiedElement {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private CoordinateFrameTransformation cft;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Please use the version that takes the
     * CoordinateFrameTransformation argument.
     */
    private DynamicCFT() {}

    /**
     * Constructor.
     *
     * <p>The coordinate frame transformation is a required value.
     *
     * @param cft the coordinate frame transformation
     */
    public DynamicCFT(CoordinateFrameTransformation cft) {
        this.cft = cft;
    }

    /**
     * Coordinate frame transformation.
     *
     * <p>The coordinate frame transformation (CFT) from a local coordinate system to an absolute
     * coordinate system.
     *
     * @return the coordinate frame transformation
     */
    public CoordinateFrameTransformation getCft() {
        return cft;
    }
}
