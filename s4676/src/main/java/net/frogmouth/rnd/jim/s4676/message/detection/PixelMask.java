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
}
