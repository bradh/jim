package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.UUID;

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
public class TrackPoint {
    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "uid")
    @JsonInclude(Include.NON_NULL)
    UUID uid;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "lid")
    @JsonInclude(Include.NON_NULL)
    Long lid;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "relTime")
    long relTime;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcUID")
    @JsonInclude(Include.NON_NULL)
    UUID dynamicSourceUID;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynSrcLID")
    @JsonInclude(Include.NON_NULL)
    Long dynamicSourceLID;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "associatedDetection")
    @JsonInclude(Include.NON_NULL)
    Boolean associatedDetection;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "processType")
    @JsonInclude(Include.NON_NULL)
    ProcessType processType;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "dynamics")
    // TODO: this needs to be a list
    Dynamics dynamics;
}
