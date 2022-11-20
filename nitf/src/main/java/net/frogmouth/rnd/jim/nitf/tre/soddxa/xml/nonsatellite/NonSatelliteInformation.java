package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.nonsatellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
