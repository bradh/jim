package net.frogmouth.rnd.jim.s4676.message.trackpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import java.util.UUID;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.common.shape.Shape;
import net.frogmouth.rnd.jim.s4676.message.sensormeasurement.SensorMeasurement;

/**
 * Track Point.
 *
 * <p>The TrackPoint class specifies the position and movement of the tracked object for a single
 * point in time. The values contained in the contents of this TrackPoint are valid for this and
 * only for this TrackPoint, even if those values are provided only in a subset of the TrackPoints.
 * For example, if the objects velocity is omitted from a TrackPoint, the data consumer shall not
 * infer that the object is travelling at the same speed as it was at a previous point in time.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "dynSrcUID",
    "dynSrcLID",
    "associatedDetection",
    "processType",
    "confidence",
    "comment",
    "outline",
    "outlineObscured",
    "nearestConfuser",
    "nearestConfuserConfidence",
    "dynamics",
    "evidence",
    "sm"
})
public class TrackPoint extends IdentifiedElement {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long relTime;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcUID")
    private UUID dynamicSourceUID;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcLID")
    private Long dynamicSourceLID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Boolean associatedDetection;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IProcessType processType;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String comment;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Shape outline;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Shape outlineObscured;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double nearestConfuser;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence nearestConfuserConfidence;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynamics")
    private List<Dynamics> dynamics;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "evidence")
    private List<Evidence> evidences;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "sm")
    private SensorMeasurement sensorMeasurements;

    // TODO: constructors

    // TODO: getters and setters
}
