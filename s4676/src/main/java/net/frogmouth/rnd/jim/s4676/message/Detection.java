package net.frogmouth.rnd.jim.s4676.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;

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

    // TODO: centroid",
    // TODO: "outline",
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private byte[] sensorUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long sensorLID;

    // TODO: "dynSrcUID",
    // TODO: "dynSrcLID",
    // TODO: "confidence",
    // TODO: "source",
    // TODO: "im",
    // TODO: "esm",
    // TODO: "radar",
    // TODO: "sm"

}
