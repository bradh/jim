package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Dynamic Source Information.
 *
 * <p>The DynamicSourceInformation class contains information describing a single piece of source
 * data. For example, for a motion imagery input, one DynamicSourceInformation object might describe
 * a single frame of source imagery.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "relTime",
    "sensorUID",
    "sensorLID",
    "sensorLocation",
    "groupID",
    "numDetections",
    "numReportedDetections",
    "dynCFT",
    "sourceMI",
    "sourceRadar",
    "sourceESM"
})
public class DynamicSourceInformation extends IdentifiedElement {
    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "relTime")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long relativeTime;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private byte[] sensorUID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long sensorLID;

    // TODO: sensor location

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String groupID;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Integer numDetections;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Integer numReportedDetections;

    // TODO:     "dynCFT",
    // TODO: "sourceMI",
    // TODO: "sourceRadar",
    // TODO: "sourceESM"
}
