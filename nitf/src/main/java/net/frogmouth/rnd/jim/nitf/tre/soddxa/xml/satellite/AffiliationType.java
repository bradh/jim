package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

public class AffiliationType {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "countryName")
    private Country countryName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgName")
    private String organisationName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgType")
    private OrganisationType organisationType;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orgRole")
    private List<OrganisationRole> organisationRoles;

    public Country getCountryName() {
        return countryName;
    }

    public void setCountryName(Country countryName) {
        this.countryName = countryName;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public OrganisationType getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(OrganisationType organisationType) {
        this.organisationType = organisationType;
    }

    public List<OrganisationRole> getOrganisationRoles() {
        return new ArrayList<>(organisationRoles);
    }

    public void setOrganisationRoles(List<OrganisationRole> organisationRoles) {
        this.organisationRoles = new ArrayList<>(organisationRoles);
    }
}
