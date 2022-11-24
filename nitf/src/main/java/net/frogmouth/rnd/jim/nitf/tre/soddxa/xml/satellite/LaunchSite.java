package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Launch site.
 *
 * <p>The satellite launch site unique identifier as provided by the catalogue specified in the
 * {@code sourceCatalog} element.
 *
 * <p>The launch site definition comprises the identifier and the name. The identifier is the short
 * code used in the catalog (e.g. {@code AFWTR} is used in the Space-Track catalogue). The name is
 * the equivalent name (e.g. {@code Air Force Western Test Range} or {@code Vandenberg Space Force
 * Base}. Both are required.
 */
public class LaunchSite {

    @JacksonXmlProperty(isAttribute = true)
    private String facilityName;

    @JacksonXmlText private String identifier;

    /**
     * Constructor.
     *
     * <p>This is only for the deserialisation code. Use the version that specifies the launch site
     * identifier and name.
     */
    private LaunchSite() {}

    /**
     * Constructor.
     *
     * @param identifier the facility identifier.
     * @param name the facility name.
     */
    public LaunchSite(String identifier, String name) {
        this.identifier = identifier;
        this.facilityName = name;
    }

    /**
     * Facility name.
     *
     * <p>The satellite launch site common name as provided by the catalogue specified in the {@code
     * sourceCatalog} element.
     *
     * @return the facility name as a String
     */
    public String getFacilityName() {
        return facilityName;
    }

    /**
     * Facility identifier.
     *
     * <p>The satellite launch site unique identifier as provided by the catalogue specified in the
     * {@code sourceCatalog} element.
     *
     * @return the facility identifier as a String.
     */
    public String getIdentifier() {
        return identifier;
    }
}
