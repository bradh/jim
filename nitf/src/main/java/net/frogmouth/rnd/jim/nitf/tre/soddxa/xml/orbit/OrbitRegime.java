package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Orbit regime.
 *
 * <p>The region in space associated with a system’s dominant gravitational attraction capable of
 * capturing the orbit of other space objects.
 *
 * <p>The orbit regime identifies the general kind of orbit (e.g. LEO or HEO), and optionally allows
 * further specification (e.g. Tundra or Molniya).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"type", "regime"})
public class OrbitRegime {

    @JacksonXmlProperty(isAttribute = true)
    private OrbitRegimeType type;

    @JacksonXmlText private OrbitRegimeRegion regime;

    /**
     * Constructor.
     *
     * <p>This is only for the deserialisation implementation. Use the version that specifies the
     * orbit regime region, or both regime and type.
     */
    private OrbitRegime() {}

    /**
     * Constructor.
     *
     * @param regime the orbit regime region.
     */
    public OrbitRegime(OrbitRegimeRegion regime) {
        this.regime = regime;
        this.type = null;
    }

    /**
     * Constructor.
     *
     * @param regime the value of regime
     * @param type the value of type
     */
    public OrbitRegime(OrbitRegimeRegion regime, OrbitRegimeType type) {
        this.type = type;
        this.regime = regime;
    }

    /**
     * Orbit regime type.
     *
     * @return the orbit regime type as an enumerated value
     */
    public OrbitRegimeType getType() {
        return type;
    }

    /**
     * Orbit regime region.
     *
     * @return the orbit regime region as an enumerated value.
     */
    public OrbitRegimeRegion getRegime() {
        return regime;
    }
}
