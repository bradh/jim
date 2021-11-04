package com.sigmabravo.rnd.jim.s4676;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Dynamics {
    @JacksonXmlProperty(localName = "cs", isAttribute = true)
    private String coordinateSystem;

    @JacksonXmlProperty(
            namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1",
            localName = "pos")
    // TODO: this should be a Position and have custom serde.
    private String position;

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
