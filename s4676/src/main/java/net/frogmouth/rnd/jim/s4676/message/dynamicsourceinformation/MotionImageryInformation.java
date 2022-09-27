package net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.common.Polygon;

/**
 * Motion Imagery (MI) Information.
 *
 * <p>The MotionImageryInformation class describes the motion imagery specific attributes related to
 * one instance of DynamicSourceInformation, for a single frame of source imagery.
 *
 * <p>The spatial resolution of a sensor is defined by two measures - ground sampling distance (GSD)
 * and ground resolved distance (GRD). The ground sampling distance is the distance, in field units,
 * between the centres of two neighbouring detectors (i.e. two neighbouring pixels on the image).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "frameBoundingBox",
    "frameNumber",
    "niirs",
    "vniirs",
    "sea",
    "tea",
    "gsd",
    "grd",
    "useableFOV",
    "processedFOV"
})
public class MotionImageryInformation {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Polygon frameBoundingBox;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long frameNumber;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Float niirs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Float vniirs;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double sea;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double tea;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double[] gsd;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double[] grd;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Polygon useableFOV;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Polygon processedFOV;

    /**
     * Constructor.
     *
     * <p>All parts of the motion imagery information are optional, although that may not be a very
     * useful element.
     */
    public MotionImageryInformation() {}

    /**
     * Frame bounding box.
     *
     * <p>The bounding box (recorded as a polygon) of the frame field of view. As usual, the polygon
     * can have any number of vertices.
     *
     * @return the frame bounding box, or null if not set
     */
    public Polygon getFrameBoundingBox() {
        return frameBoundingBox;
    }

    /**
     * Set the frame bounding box.
     *
     * <p>The bounding box (recorded as a polygon) of the frame field of view. As usual, the polygon
     * can have any number of vertices.
     *
     * @param frameBoundingBox the frame bounding box.
     */
    public void setFrameBoundingBox(Polygon frameBoundingBox) {
        this.frameBoundingBox = frameBoundingBox;
    }

    /**
     * Frame number.
     *
     * <p>The frame number (an arbitrary value assigned to a single frame). Consumers may use this
     * information for relating information between multiple track datasets (for example, a ground
     * truth data set and a hypothesized track data set), but there's nothing to guarantee that all
     * frame numbers from different sources are synchronized with each other. The consumer is
     * strongly encouraged to use the time stamps instead of frame number.
     *
     * @return frame number, or null if not set
     */
    public Long getFrameNumber() {
        return frameNumber;
    }

    /**
     * Set the frame number.
     *
     * <p>The frame number (an arbitrary value assigned to a single frame). Consumers may use this
     * information for relating information between multiple track datasets (for example, a ground
     * truth data set and a hypothesized track data set), but there's nothing to guarantee that all
     * frame numbers from different sources are synchronized with each other. The consumer is
     * strongly encouraged to use the time stamps instead of frame number.
     *
     * @param frameNumber frame number, or null if not set
     */
    public void setFrameNumber(Long frameNumber) {
        this.frameNumber = frameNumber;
    }

    /**
     * NATO Imagery Interpretability Rating Scale (NIIRS) value.
     *
     * <p>The producer's estimate of the NIIRS at the centre of the image.
     *
     * <p>In US operations, NIIRS can stand for National Imagery Interpretability Rating Scale. The
     * scales are harmonised.
     *
     * <p>Reference: STANAG 7194, Edition 1.
     *
     * @return NIIRS value
     */
    public Float getNiirs() {
        return niirs;
    }

    /**
     * Set the NATO Imagery Interpretability Rating Scale (NIIRS) value.
     *
     * <p>The producer's estimate of the NIIRS at the centre of the image.
     *
     * <p>In US operations, NIIRS can stand for National Imagery Interpretability Rating Scale. The
     * scales are harmonised.
     *
     * <p>Reference: STANAG 7194, Edition 1.
     *
     * @param niirs NNIRS value.
     */
    public void setNiirs(Float niirs) {
        this.niirs = niirs;
    }

    /**
     * Video National Imagery Interpretability Rating Scale (VNIIRS) value.
     *
     * <p>The producer's estimate of the VNIIRS of the motion imagery stream.
     *
     * <p>Reference: NNSTD MISP-2015.1 (covered by STANAG 4609, Edition 5). Alternatively, see ST
     * 0901.3.
     *
     * @return the VNIIRS value.
     */
    public Float getVniirs() {
        return vniirs;
    }

    /**
     * Set the Video National Imagery Interpretability Rating Scale (VNIIRS) value.
     *
     * <p>The producer's estimate of the VNIIRS of the motion imagery stream.
     *
     * <p>Reference: NNSTD MISP-2015.1 (covered by STANAG 4609, Edition 5). Alternatively, see ST
     * 0901.3.
     *
     * @param vniirs the VNIIRS value
     */
    public void setVniirs(Float vniirs) {
        this.vniirs = vniirs;
    }

    /**
     * Solar Elevation Angle.
     *
     * <p>The acute angle, in degrees, between the target plane at the target and the line of sight
     * between the centre of the sun’s disc and the target.
     *
     * <p><img src="../../../../../../../../resources/sea_tea.png" alt="">
     *
     * @return the solar elevation angle in degrees.
     */
    public Double getSea() {
        return sea;
    }

    /**
     * Set the Solar Elevation Angle.
     *
     * <p>The acute angle, in degrees, between the target plane at the target and the line of sight
     * between the centre of the sun’s disc and the target.
     *
     * <p><img src="../../../../../../../../resources/sea_tea.png" alt="">
     *
     * @param sea the solar elevation angle in degrees.
     */
    public void setSea(Double sea) {
        this.sea = sea;
    }

    /**
     * Target Elevation Angle.
     *
     * <p>The acute angle, in degrees, between the target plane at the target and the line of sight
     * between the sensor and the target.
     *
     * <p><img src="../../../../../../../../resources/sea_tea.png" alt="">
     *
     * @return the target elevation angle in degrees.
     */
    public Double getTea() {
        return tea;
    }

    /**
     * Set the Target Elevation Angle.
     *
     * <p>The acute angle, in degrees, between the target plane at the target and the line of sight
     * between the sensor and the target.
     *
     * <p><img src="../../../../../../../../resources/sea_tea.png" alt="">
     *
     * @param tea the target elevation angle in degrees.
     */
    public void setTea(Double tea) {
        this.tea = tea;
    }

    /**
     * Ground sample distance (GSD).
     *
     * <p>Ground Sampling Distance (GSD), in meters, at the centre of the field-of- view. The array,
     * if provided, contains between one and three values. If only one value is provided, the value
     * represents the geometric mean of the GSD in all known dimensions. If two values are provided,
     * they represent the GSD in the x and y dimensions, in that order. If three values are
     * provided, they represent the GSD in the x, y and z dimensions, in that order.
     *
     * @return ground sample distance array, in metres.
     */
    public Double[] getGsd() {
        return gsd;
    }

    /**
     * Set the ground sample distance (GSD).
     *
     * <p>Ground Sampling Distance (GSD), in meters, at the centre of the field-of- view. The array,
     * if provided, contains between one and three values. If only one value is provided, the value
     * represents the geometric mean of the GSD in all known dimensions. If two values are provided,
     * they represent the GSD in the x and y dimensions, in that order. If three values are
     * provided, they represent the GSD in the x, y and z dimensions, in that order.
     *
     * @param gsd ground sample distance array, in metres.
     */
    public void setGsd(Double[] gsd) {
        this.gsd = gsd;
    }

    /**
     * Ground resolved distance (GRD).
     *
     * <p>Ground Resolved Distance (GRD). When used in the context of an imaging sensor, the size of
     * the smallest element distinguishable on acquired imagery. The array, if provided, contains
     * between one and three values. If only one value is provided, the value represents the
     * geometric mean of the GRD in all known dimensions. If two values are provided, they represent
     * the GRD in the x and y dimensions, in that order. If three values are provided, they
     * represent the GRD in the x, y and z dimensions, in that order.
     *
     * @return the ground resolved distance array, in metres
     */
    public Double[] getGrd() {
        return grd;
    }

    /**
     * Set the ground resolved distance (GRD).
     *
     * <p>Ground Resolved Distance (GRD). When used in the context of an imaging sensor, the size of
     * the smallest element distinguishable on acquired imagery. The array, if provided, contains
     * between one and three values. If only one value is provided, the value represents the
     * geometric mean of the GRD in all known dimensions. If two values are provided, they represent
     * the GRD in the x and y dimensions, in that order. If three values are provided, they
     * represent the GRD in the x, y and z dimensions, in that order.
     *
     * @param grd the ground resolved distance array, in metres
     */
    public void setGrd(Double[] grd) {
        this.grd = grd;
    }

    /**
     * Useable field of view (FOV).
     *
     * <p>A polygon outline of the portion of the field-of-view (FOV) that was deemed useable by the
     * data producer (for example, a FOV that excludes an area of uncorrectable detectors). Either
     * pixel or real-world coordinates are permitted. The Polygon class contains an attribute
     * specifying the coordinate system type used.
     *
     * @return the field of view.
     */
    public Polygon getUseableFOV() {
        return useableFOV;
    }

    /**
     * Set the useable field of view (FOV).
     *
     * <p>A polygon outline of the portion of the field-of-view (FOV) that was deemed useable by the
     * data producer (for example, a FOV that excludes an area of uncorrectable detectors). Either
     * pixel or real-world coordinates are permitted. The Polygon class contains an attribute
     * specifying the coordinate system type used.
     *
     * @param useableFOV the field of view.
     */
    public void setUseableFOV(Polygon useableFOV) {
        this.useableFOV = useableFOV;
    }

    /**
     * Processed field of view (FOV).
     *
     * <p>A polygon outline of the portion of the field-of-view (FOV) that the data producer ran
     * algorithms on (for example, detection and tracking algorithms). Either pixel or real-world
     * coordinates are permitted. The Polygon class contains an attribute specifying the coordinate
     * system type used.
     *
     * @return the field of view.
     */
    public Polygon getProcessedFOV() {
        return processedFOV;
    }

    /**
     * Set the processed field of view (FOV).
     *
     * <p>A polygon outline of the portion of the field-of-view (FOV) that the data producer ran
     * algorithms on (for example, detection and tracking algorithms). Either pixel or real-world
     * coordinates are permitted. The Polygon class contains an attribute specifying the coordinate
     * system type used.
     *
     * @param processedFOV the field of view.
     */
    public void setProcessedFOV(Polygon processedFOV) {
        this.processedFOV = processedFOV;
    }
}
