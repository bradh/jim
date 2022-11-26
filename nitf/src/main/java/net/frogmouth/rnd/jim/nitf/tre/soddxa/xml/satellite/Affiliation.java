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
    private Country country;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgName")
    private String organisationName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgType")
    private OrganisationType organisationType;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgRole")
    private List<OrganisationRole> organisationRoles;

    /**
     * Country.
     *
     * <p>The country or other geopolitical entity (or administrative subdivision of an entity) that
     * is affiliated with the space object and associated with its affiliation parent element.
     *
     * @return the country name and country code.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Set the country.
     *
     * <p>The country or other geopolitical entity (or administrative subdivision of an entity) that
     * is affiliated with the space object and associated with its affiliation parent element.
     *
     * @param country the country name and country code.
     */
    public void setCountry(final Country country) {
        this.country = country;
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

    /**
     * Set the organisation name.
     *
     * <p>The name of the organization or consortium that is affiliated with the space object in
     * whole or in part. If the space object is affiliated with a consortium, then the consortium
     * name is preferred over listing multiple affiliated elements.
     *
     * @param organisationName the organisation name, as a free-form string.
     */
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

    /**
     * Set the organisation type.
     *
     * <p>The type of organisation associated with this affiliation element.
     *
     * @param organisationType organisation type as an enumerated value.
     */
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

    /**
     * Set the organisation roles.
     *
     * <p>The organisation's affiliation with the space object.
     *
     * @param organisationRoles the list of organisation roles.
     */
    public void setOrganisationRoles(List<OrganisationRole> organisationRoles) {
        this.organisationRoles = new ArrayList<>(organisationRoles);
    }
}
