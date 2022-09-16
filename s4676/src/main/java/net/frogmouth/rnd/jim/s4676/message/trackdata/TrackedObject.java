package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;
import net.frogmouth.rnd.jim.s4676.common.Confidence;
import net.frogmouth.rnd.jim.s4676.message.trackdata.id1241.ID1241;

/**
 * Tracked object.
 *
 * <p>The TrackedObject class specifies time-invariant information about the tracked object, such as
 * the type of object (e.g., an Automobile or an Open-bed truck), its colour, and its identity
 * (“FRIEND”, “HOSTILE”).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "uid",
    "lid",
    "description",
    "numberOfObjects",
    "objectColor",
    "confidence",
    "dims",
    "priority",
    "iffCode",
    "objectClass",
    "idSourceInformation",
    "id1241",
    "exampleDetectionUID",
    "exampleDetectionLID"
})
public class TrackedObject extends IdentifiedElement {

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String description;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Long numberOfObjects;

    // TODO: <xs:element name="objectColor" type="UnsignedByteArray" minOccurs="0"
    // maxOccurs="unbounded"/>

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Confidence confidence;

    // TODO: <xs:element name="dims" type="DoubleArray" minOccurs="0" maxOccurs="1"/>

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Short priority;

    // TODO: <xs:element name="iffCode" type="IFFCode" minOccurs="0" maxOccurs="unbounded"/>

    // TODO: <xs:element name="objectClass" type="ObjectClass" minOccurs="0" maxOccurs="unbounded"/>

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IDSourceInformation idSourceInformation;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private ID1241 id1241;

    // TODO: multiple exampleDetectionUID
    // TODO: multiple exampleDetectionLID

    // TODO: constructors

    // TODO: missing getters and setters/adders
}
