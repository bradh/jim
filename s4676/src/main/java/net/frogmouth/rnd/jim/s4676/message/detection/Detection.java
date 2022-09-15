package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.PositionPoints;
import net.frogmouth.rnd.jim.s4676.common.shape.Shape;
import net.frogmouth.rnd.jim.s4676.message.sensormeasurement.SensorMeasurement;
import net.frogmouth.rnd.jim.s4676.message.tracksource.TrackSource;

/**
 * Detection.
 *
 * <p>The Detection class specifies a single instance of sensed information, which if hypothesized
 * to be part of a tracked object, serves as evidence of the tracked object. The detections can be
 * reported independent of whether or not they are eventually associated with a track point.
 *
 * <p>To explicitly associate detections with track points, the data producer populates one of the
 * ID attributes of the Detection object, and then refers back to that ID from the Evidence object
 * contained within the track point(s) derived from that detection.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "centroid",
    "outline",
    "sensorUID",
    "sensorLID",
    "dynSrcUID",
    "dynSrcLID",
    "confidence",
    "source",
    "im",
    "esm",
    "radar",
    "sm"
})
public class Detection extends IdentifiedElement {
    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "relTime")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long relativeTime;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "centroid")
    private List<PositionPoints> centroids;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "outline")
    private List<Shape> outlines;

    // TODO: sensorUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long sensorLID;

    // TODO: "dynSrcUID",

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long dynSrcLID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private TrackSource source;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Image im;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ESM esm;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Radar4607 radar;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "sm")
    private List<SensorMeasurement> sensorMeasurements;

    /**
     * Constructor.
     *
     * <p>No part of the Detection is mandatory, although that may not be a very useful element.
     */
    public Detection() {}

    /**
     * Relative time.
     *
     * <p>The number of time increments since the baseTime in the TrackMessage. If relTime is not
     * defined, it is assumed to be zero (i.e., this block of Detection information occurred at the
     * same time as the baseTime).
     *
     * @return the relative time.
     */
    public long getRelativeTime() {
        return relativeTime;
    }

    /**
     * Set the relative time.
     *
     * <p>The number of time increments since the baseTime in the TrackMessage. If relTime is not
     * defined, it is assumed to be zero (i.e., this block of Detection information occurred at the
     * same time as the baseTime).
     *
     * @param relativeTime the relative time.
     */
    public void setRelativeTime(long relativeTime) {
        this.relativeTime = relativeTime;
    }

    /**
     * Centroids.
     *
     * <p>The centroid of this specific detection, declared as a single PositionPoints. The
     * multiplicity of this attribute is unbounded to allow the centroid to be described in any of
     * the available coordinate systems and dimensionalities (both of which are set by
     * PositionPoints). Each instance of the Detection class refers to a unique detection (that is,
     * the multiplicity of this attribute does not allow the data producer to put multiple
     * detections into a single Detection class).
     *
     * @return list of centroid points
     */
    public List<PositionPoints> getCentroids() {
        return centroids;
    }

    /**
     * Add a centroid.
     *
     * <p>The centroid of this specific detection, declared as a single PositionPoints. The
     * multiplicity of this attribute is unbounded to allow the centroid to be described in any of
     * the available coordinate systems and dimensionalities (both of which are set by
     * PositionPoints). Each instance of the Detection class refers to a unique detection (that is,
     * the multiplicity of this attribute does not allow the data producer to put multiple
     * detections into a single Detection class).
     *
     * @param centroid the centroid
     */
    public void addCentroid(PositionPoints centroid) {
        if (this.centroids == null) {
            this.centroids = new ArrayList<>();
        }
        this.centroids.add(centroid);
    }

    /**
     * Outlines.
     *
     * <p>The outline of the detection. For ground truth, this should represent whatever portion of
     * the detection is visible to the sensor. The multiplicity of this attribute is unbounded to
     * allow the outline to be defined in multiple coordinate systems. The coordinate system of a
     * given outline is set by Shape. Each instance of the Detection class refers to a unique
     * detection (that is, the multiplicity of this attribute does not allow the data producer to
     * put multiple detections into a single Detection class).
     *
     * @return list of outline shapes
     */
    public List<Shape> getOutlines() {
        return outlines;
    }

    /**
     * Outline.
     *
     * <p>The outline of the detection. For ground truth, this should represent whatever portion of
     * the detection is visible to the sensor. The multiplicity of this attribute is unbounded to
     * allow the outline to be defined in multiple coordinate systems. The coordinate system of a
     * given outline is set by Shape. Each instance of the Detection class refers to a unique
     * detection (that is, the multiplicity of this attribute does not allow the data producer to
     * put multiple detections into a single Detection class).
     *
     * @param outline the outline shape
     */
    public void addOutline(Shape outline) {
        if (this.outlines == null) {
            this.outlines = new ArrayList<>();
        }
        this.outlines.add(outline);
    }

    // TODO: getter and setter for sensorUID

    /**
     * Sensor local ID (LID).
     *
     * <p>An optional reference to the block of sensor information associated with this detection.
     *
     * @return the local identifier for the sensor information, or null if not set.
     */
    public Long getSensorLID() {
        return sensorLID;
    }

    /**
     * Set the sensor local ID (LID).
     *
     * <p>An optional reference to the block of sensor information associated with this detection.
     *
     * @param sensorLID the local identifier for the sensor information
     */
    public void setSensorLID(Long sensorLID) {
        this.sensorLID = sensorLID;
    }

    // TODO: getter and setter for dynSrcUID

    /**
     * Dynamic source local ID (LID).
     *
     * <p>An optional reference to the block of dynamic source information associated with this
     * detection.
     *
     * @return the local identifier for the dynamic source information, or null if not set.
     */
    public Long getDynSrcLID() {
        return dynSrcLID;
    }

    /**
     * Set the dynamic source local ID (LID).
     *
     * <p>An optional reference to the block of dynamic source information associated with this
     * detection.
     *
     * @param dynSrcLID the local identifier for the dynamic source information.
     */
    public void setDynSrcLID(Long dynSrcLID) {
        this.dynSrcLID = dynSrcLID;
    }

    /**
     * Confidence.
     *
     * <p>An optional confidence assessment by the data producer. This could be used to provide an
     * estimate of the significance of the detection, for example.
     *
     * @return confidence value, or null if not set.
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /**
     * Confidence.
     *
     * <p>An optional confidence assessment by the data producer. This could be used to provide an
     * estimate of the significance of the detection, for example.
     *
     * @param confidence confidence value.
     */
    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    /**
     * Track source.
     *
     * <p>An optional instance of the TrackSource class, specifying the source of this specific
     * detection.
     *
     * @return track source, or null if not set
     */
    public TrackSource getSource() {
        return source;
    }

    /**
     * Set the track source.
     *
     * <p>An optional instance of the TrackSource class, specifying the source of this specific
     * detection.
     *
     * @param source the track source
     */
    public void setSource(TrackSource source) {
        this.source = source;
    }

    /**
     * Image.
     *
     * <p>Provides electro-optical feature-related detection pertinent to a single detection.
     *
     * @return image information, or null if not set
     */
    public Image getImage() {
        return im;
    }

    /**
     * Set image.
     *
     * <p>Provides electro-optical feature-related detection pertinent to a single detection.
     *
     * @param im image information
     */
    public void setImage(Image im) {
        this.im = im;
    }

    /**
     * Electronic support measures (ESM).
     *
     * <p>Provides Electronic Support Measures (ESM) detection pertinent to a single detection.
     *
     * @return ESM information, or null if not set.
     */
    public ESM getEsm() {
        return esm;
    }

    /**
     * Set the electronic support measures (ESM).
     *
     * <p>Provides Electronic Support Measures (ESM) detection pertinent to a single detection.
     *
     * @param esm the ESM information
     */
    public void setEsm(ESM esm) {
        this.esm = esm;
    }

    /**
     * Radar (GMTI) information.
     *
     * <p>Provides Radar feature-related detection pertinent to a single detection.
     *
     * @return radar information, or null if not set.
     */
    public Radar4607 getRadar() {
        return radar;
    }

    /**
     * Set the radar (GMTI) information.
     *
     * <p>Provides Radar feature-related detection pertinent to a single detection.
     *
     * @param radar radar information.
     */
    public void setRadar(Radar4607 radar) {
        this.radar = radar;
    }

    /**
     * Sensor measurements.
     *
     * <p>Provides one or more quantities associated with a detection.
     *
     * @return sensor measurements
     */
    public List<SensorMeasurement> getSensorMeasurements() {
        return sensorMeasurements;
    }

    /**
     * Add a sensor measurement.
     *
     * <p>Provides a quantity associated with a detection.
     *
     * @param sm sensor measurement
     */
    public void addSensorMeasurement(SensorMeasurement sm) {
        if (this.sensorMeasurements == null) {
            this.sensorMeasurements = new ArrayList<>();
        }
        this.sensorMeasurements.add(sm);
    }
}
