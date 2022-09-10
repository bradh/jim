package net.frogmouth.rnd.jim.s4676.message.trackpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import java.util.UUID;
import net.frogmouth.rnd.jim.s4676.Dynamics;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.trackpoint.IProcessType;

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
    "dynamicSourceUID",
    "dynamicSourceLID",
    "associatedDetection",
    "processType",
    "dynamics"
})
public class TrackPoint extends IdentifiedElement {
    // TODO: missing sm, evidence, probably more

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "relTime")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    long relTime;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcUID")
    UUID dynamicSourceUID;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcLID")
    Long dynamicSourceLID;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "associatedDetection")
    Boolean associatedDetection;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "processType")
    IProcessType processType;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynamics")
    List<Dynamics> dynamics;

    // TODO: constructors

    // TODO: getters and setters
}
