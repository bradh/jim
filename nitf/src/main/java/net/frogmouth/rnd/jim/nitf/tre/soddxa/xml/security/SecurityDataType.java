package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "Security",
    "soClassification",
    "soSIC",
    "orconOrganization",
    "smClassification",
    "smRestrictedCollection",
    "accmClassification",
    "accmImageHold"
})
public class SecurityDataType {
    /*
    <xs:complexType name="SecurityDataType">
    <xs:sequence>
    <xs:element ref="arh:Security" minOccurs="0"/>
    <xs:element name="soClassification" type="ARHContainer" minOccurs="0"/>
    <xs:element name="soSIC" type="String" minOccurs="0"/>
    <xs:element name="orconOrganization" type="String" minOccurs="0"/>
    <xs:element name="smClassification" type="ARHContainer" minOccurs="0"/>
    <xs:element name="smRestrictedCollection" type="xs:boolean" minOccurs="0"/>
    <xs:element name="accmClassification" type="ARHContainer" minOccurs="0"/>
    <xs:element name="accmImageHold" type="xs:boolean" minOccurs="0"/>
    </xs:sequence>
    </xs:complexType>
    */

    @JacksonXmlProperty(namespace = "urn:us:gov:ic:arh", localName = "Security")
    private ARHSecurity arhSecurity;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Classification soClassification;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String soSIC;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String orconOrganization;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Classification smClassification;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Boolean smRestrictedCollection;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Classification accmClassification;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Boolean accmImageHold;

    public ARHSecurity getArhSecurity() {
        return arhSecurity;
    }

    public void setArhSecurity(ARHSecurity arhSecurity) {
        this.arhSecurity = arhSecurity;
    }

    public Classification getSoClassification() {
        return soClassification;
    }

    public void setSoClassification(Classification soClassification) {
        this.soClassification = soClassification;
    }

    public String getSoSIC() {
        return soSIC;
    }

    public void setSoSIC(String soSIC) {
        this.soSIC = soSIC;
    }

    public String getOrconOrganization() {
        return orconOrganization;
    }

    public void setOrconOrganization(String orconOrganization) {
        this.orconOrganization = orconOrganization;
    }

    public Classification getSmClassification() {
        return smClassification;
    }

    public void setSmClassification(Classification smClassification) {
        this.smClassification = smClassification;
    }

    public Boolean getSmRestrictedCollection() {
        return smRestrictedCollection;
    }

    public void setSmRestrictedCollection(Boolean smRestrictedCollection) {
        this.smRestrictedCollection = smRestrictedCollection;
    }

    public Classification getAccmClassification() {
        return accmClassification;
    }

    public void setAccmClassification(Classification accmClassification) {
        this.accmClassification = accmClassification;
    }

    public Boolean getAccmImageHold() {
        return accmImageHold;
    }

    public void setAccmImageHold(Boolean accmImageHold) {
        this.accmImageHold = accmImageHold;
    }
}
