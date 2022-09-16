package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * IFF Code.
 *
 * <p>Provides Identification Friend or Foe (IFF) mode and value.
 */
public class IFFCode {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String value;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private IFFMode mode;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a value and mode.
     */
    private IFFCode() {}

    /**
     * Constructor.
     *
     * @param value the code value transmitted by an IFF system.
     * @param mode the mode of operation for an IFF system.
     */
    public IFFCode(String value, IFFMode mode) {
        this.value = value;
        this.mode = mode;
    }

    /**
     * Code value.
     *
     * <p>Provides the code value transmitted by an IFF system.
     *
     * @return the code value as a string.
     */
    public String getValue() {
        return value;
    }

    /**
     * Mode.
     *
     * <p>Provides the mode of operation for an IFF system.
     *
     * @return the mode as an enumerated value.
     */
    public IFFMode getMode() {
        return mode;
    }
}
