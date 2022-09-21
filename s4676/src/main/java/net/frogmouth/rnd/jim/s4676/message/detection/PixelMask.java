package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Pixel mask.
 *
 * <p>A description of the pixels within a motion imagery frame that are subtended by an object, as
 * distinct from the background.
 *
 * <p>PixelMask can be specified by either (1) a series of three or more pixel numbers that
 * represents the vertices of a polygon that encompasses the object, or (2) a set of pixel “runs”
 * that defines a “bit mask” to specify the pixels subtended by the object.
 *
 * <p>Reference: VMask Local Set in MISB ST 0903.4.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"pixelPolygon", "pixelRun"})
public class PixelMask {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private PixelPolygon pixelPolygon;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private PixelRun pixelRun;

    /** Constructor. */
    public PixelMask() {}

    /**
     * Pixel polygon.
     *
     * <p>A list of pixels that specifies the vertices of a polygon (in pixel space).
     *
     * @return the pixel polygon.
     */
    public PixelPolygon getPixelPolygon() {
        return pixelPolygon;
    }

    /**
     * Set the pixel polygon.
     *
     * <p>A list of pixels that specifies the vertices of a polygon (in pixel space).
     *
     * @param pixelPolygon the pixel polygon.
     */
    public void setPixelPolygon(PixelPolygon pixelPolygon) {
        this.pixelPolygon = pixelPolygon;
    }

    /**
     * Pixel run.
     *
     * <p>A list of pixel runs that specifies a collection of pixels (for example, a detection in
     * image space). The pixel runs can be specified as runs in the row direction (rs) and/or in the
     * column direction (cs). If the runs are specified in both directions, they can overlap.
     *
     * @return pixel run
     */
    public PixelRun getPixelRun() {
        return pixelRun;
    }

    /**
     * Set the pixel run.
     *
     * <p>A list of pixel runs that specifies a collection of pixels (for example, a detection in
     * image space). The pixel runs can be specified as runs in the row direction (rs) and/or in the
     * column direction (cs). If the runs are specified in both directions, they can overlap.
     *
     * @param pixelRun pixel run
     */
    public void setPixelRun(PixelRun pixelRun) {
        this.pixelRun = pixelRun;
    }
}
