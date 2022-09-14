package net.frogmouth.rnd.jim.s4676.message.trackpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemType;

/**
 * Dynamics.
 *
 * <p>The Dynamics class specifies position, velocity, acceleration, and covariance matrix data, as
 * estimated by the data producer. All four attributes must be in the same coordinate system
 * (specified in the “pos” attribute). Note that the producer can specify multiple dynamics blocks
 * in different units. For example, the producer could specify a dynamics block with just a position
 * in WGS 84, as well as a second dynamics block with position, velocity, acceleration, and
 * covariance in a local coordinate system.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"cs", "pos", "vel", "acc", "cov", "cftUID", "cftLID"})
public class Dynamics {

    @JacksonXmlProperty(localName = "cs", isAttribute = true)
    private CoordinateSystemType coordinateSystem;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "pos")
    // TODO: this should be a Position and have custom serde.
    private String position;

    /**
     * Coordinate System.
     *
     * <p>The coordinate system of the data within this Dynamics object.
     *
     * @return the coordinate system.
     */
    public CoordinateSystemType getCoordinateSystem() {
        return coordinateSystem;
    }

    /**
     * Set the Coordinate System.
     *
     * <p>The coordinate system of the data within this Dynamics object.
     *
     * @param coordinateSystem the coordinate system
     */
    public void setCoordinateSystem(CoordinateSystemType coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    /**
     * Position.
     *
     * <p>The centroid position of the track point.
     *
     * @return the position.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the Position.
     *
     * <p>The centroid position of the track point.
     *
     * @param position the position.
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
