package net.frogmouth.rnd.jim.s4676.message.trackpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.CoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.common.CovarianceMatrix;
import net.frogmouth.rnd.jim.s4676.common.DoubleArrayDeserializer;
import net.frogmouth.rnd.jim.s4676.common.DoubleArraySerialiser;
import net.frogmouth.rnd.jim.s4676.common.ICoordinateSystemType;
import net.frogmouth.rnd.jim.s4676.common.SupplementalDeserialisationInfo;
import net.frogmouth.rnd.jim.s4676.common.UniqueID;

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
    private ICoordinateSystemType coordinateSystem;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "pos")
    @JsonSerialize(using = DoubleArraySerialiser.class)
    @JsonDeserialize(using = DoubleArrayDeserializer.class)
    @SupplementalDeserialisationInfo(elementName = "pos")
    private Double[] position;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "vel")
    @JsonSerialize(using = DoubleArraySerialiser.class)
    @JsonDeserialize(using = DoubleArrayDeserializer.class)
    @SupplementalDeserialisationInfo(elementName = "vel")
    private double[] velocity;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "acc")
    @JsonSerialize(using = DoubleArraySerialiser.class)
    @JsonDeserialize(using = DoubleArrayDeserializer.class)
    @SupplementalDeserialisationInfo(elementName = "acc")
    private double[] acceleration;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private CovarianceMatrix covariance;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private UniqueID cftUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long cftLID;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that specifies the coordinate system and
     * position.
     */
    private Dynamics() {}

    /**
     * Constructor.
     *
     * @param coordinateSystem coordinate system of the data within this Dynamics object.
     * @param position the centroid position of the track point.
     */
    public Dynamics(CoordinateSystemType coordinateSystem, Double[] position) {
        this.coordinateSystem = coordinateSystem;
        this.position = position;
    }

    /**
     * Coordinate System.
     *
     * <p>The coordinate system of the data within this Dynamics object. Unless extended, this will
     * be an enumeration value from {@link CoordinateSystemType}.
     *
     * @return the coordinate system.
     */
    public ICoordinateSystemType getCoordinateSystem() {
        return coordinateSystem;
    }

    /**
     * Set the Coordinate System.
     *
     * <p>The coordinate system of the data within this Dynamics object. Unless extended, this will
     * be an enumeration value from {@link CoordinateSystemType}.
     *
     * @param coordinateSystem the coordinate system
     */
    public void setCoordinateSystem(ICoordinateSystemType coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    /**
     * Position.
     *
     * <p>The centroid position of the track point.
     *
     * @return the position
     */
    public Double[] getPosition() {
        return position;
    }

    /**
     * Set the position.
     *
     * <p>The centroid position of the track point.
     *
     * @param position the position
     */
    public void setPosition(Double[] position) {
        this.position = position;
    }

    /**
     * Velocity.
     *
     * <p>The velocity of the track point.
     *
     * @return the velocity
     */
    public double[] getVelocity() {
        return velocity;
    }

    /**
     * Set the velocity.
     *
     * <p>The velocity of the track point.
     *
     * @param velocity the velocity
     */
    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    /**
     * Acceleration.
     *
     * <p>The acceleration of the track point.
     *
     * @return the acceleration
     */
    public double[] getAcceleration() {
        return acceleration;
    }

    /**
     * Set the acceleration.
     *
     * <p>The acceleration of the track point.
     *
     * @param acceleration the acceleration
     */
    public void setAcceleration(double[] acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Covariance matrix.
     *
     * <p>The covariance matrix of the position, or (position and velocity), or (position and
     * velocity and acceleration). The producer must specify the contents of the CovarianceMatrix
     * via CovarianceMatrix.covarianceType.
     *
     * @return the covariance matrix, or null if not set.
     */
    public CovarianceMatrix getCovariance() {
        return covariance;
    }

    /**
     * Set the covariance matrix.
     *
     * <p>The covariance matrix of the position, or (position and velocity), or (position and
     * velocity and acceleration). The producer must specify the contents of the CovarianceMatrix
     * via CovarianceMatrix.covarianceType.
     *
     * @param covariance the covariance matrix.
     */
    public void setCovariance(CovarianceMatrix covariance) {
        this.covariance = covariance;
    }

    /**
     * Coordinate frame transformation unique identifier (UID).
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
     * Set the coordinate frame transformation unique identifier (UID).
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
     * Coordinate frame transformation local identifier (LID).
     *
     * <p>A local ID reference to the coordinate system transformation (see DynamicCFT) between a
     * local coordinate system and an absolute coordinate system. Only applicable if the dynamics
     * information (position, velocity, acceleration, and covariance matrix) is specified in a local
     * coordinate system.
     *
     * @return the local identifier
     */
    public Long getCftLID() {
        return cftLID;
    }

    /**
     * Set the coordinate frame transformation local identifier (LID).
     *
     * <p>A local ID reference to the coordinate system transformation (see DynamicCFT) between a
     * local coordinate system and an absolute coordinate system. Only applicable if the dynamics
     * information (position, velocity, acceleration, and covariance matrix) is specified in a local
     * coordinate system.
     *
     * @param cftLID the local identifier
     */
    public void setCftLID(Long cftLID) {
        this.cftLID = cftLID;
    }
}
