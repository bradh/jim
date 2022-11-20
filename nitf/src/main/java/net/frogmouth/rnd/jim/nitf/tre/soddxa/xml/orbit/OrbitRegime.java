package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"type", "regime"})
public class OrbitRegime {

    @JacksonXmlProperty(isAttribute = true)
    private OrbitRegimeType type;

    @JacksonXmlText private Regime regime;

    public OrbitRegime() {}

    public OrbitRegime(OrbitRegime other) {
        this.type = other.type;
        this.regime = other.regime;
    }

    public OrbitRegimeType getType() {
        return type;
    }

    public void setType(OrbitRegimeType type) {
        this.type = type;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }
}
