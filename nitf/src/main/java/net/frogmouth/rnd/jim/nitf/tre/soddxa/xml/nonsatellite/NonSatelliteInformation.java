package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.nonsatellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Non-satellite information.
 *
 * <p>The nonSatelliteInformation container specifies information about the non-satellite type of
 * space object.
 *
 * <p>All fields in this class are optional, but at least one would need to be filled in for an
 * instance to be meaningful.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"name", "identifier", "description"})
public class NonSatelliteInformation {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String name;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String identifier;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String description;

    public NonSatelliteInformation() {}

    public NonSatelliteInformation(NonSatelliteInformation other) {
        this.name = other.name;
        this.identifier = other.identifier;
        this.description = other.description;
    }

    /**
     * Name of the space object.
     *
     * <p>The name of the imaged space object. If the element is omitted, the value is unknown to
     * the data provider.
     *
     * @return the name, or null if the value was not specified.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Identifier of the space object.
     *
     * <p>A sequence of characters derived from a catalogue or other authoritative source that
     * identifies a space object that is not characterized as a satellite. If the element is
     * omitted, the value is unknown to the data provider.
     *
     * @return the identifier, or null if the value was not specified.
     */
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Description of the space object.
     *
     * <p>A free-text description of the imaged space object.
     *
     * @return the description, or null if the value was not specified.
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
