package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Affiliation.
 *
 * <p>The affiliation container specifies information about an organization affiliated with the
 * space object and its role or association with the space object and may be repeated to support
 * multiple instances. If multiple affiliation elements are provided, the space object is jointly
 * affiliated by the entities specified by those multiple affiliation elements. If responsibility
 * for any roles is not equally divided, then entities with larger responsibility or affiliation
 * should be given before entities with lesser responsibility or affiliation.
 */
public class Affiliation {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "countryName")
    private Country countryName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgName")
    private String organisationName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgType")
    private OrganisationType organisationType;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgRole")
    private List<OrganisationRole> organisationRoles;

    /**
     * Country name.
     *
     * <p>The name of the country or other geopolitical entity (or administrative subdivision of an
     * entity) that is affiliated with the space object and associated with its country parent
     * element. This textual value is correlated to its country code. If multiple countryName
     * elements are provided, then the space object is jointly affiliated with the entities
     * specified by those multiple countryName elements. If responsibility or affiliation with the
     * space object is not equally divided, then entities with larger responsibility should be given
     * before entities with lesser responsibility.
     *
     * @return the country name and country code.
     */
    public Country getCountryName() {
        return countryName;
    }

    public void setCountryName(final Country countryName) {
        this.countryName = countryName;
    }

    /**
     * Organisation name.
     *
     * <p>The name of the organization or consortium that is affiliated with the space object in
     * whole or in part. If the space object is affiliated with a consortium, then the consortium
     * name is preferred over listing multiple affiliated elements.
     *
     * @return the organisation name, as a free-form string.
     */
    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    /**
     * Organisation type.
     *
     * <p>The type of organisation associated with this affiliation element.
     *
     * @return organisation type as an enumerated value.
     */
    public OrganisationType getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(OrganisationType organisationType) {
        this.organisationType = organisationType;
    }

    /**
     * Organisation roles.
     *
     * <p>The organisation's affiliation with the space object.
     *
     * @return the list of organisation roles.
     */
    public List<OrganisationRole> getOrganisationRoles() {
        return new ArrayList<>(organisationRoles);
    }

    public void setOrganisationRoles(List<OrganisationRole> organisationRoles) {
        this.organisationRoles = new ArrayList<>(organisationRoles);
    }
}
