package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Security data.
 *
 * <p>The SODDXA TRE XSD explicitly includes the capability for information security marking
 * metadata to be included within the SODDXA XML instance document, through the [@code arh:Security}
 * and {@code arh:ExternalSecurity} elements as defined by the Intelligence Community – Information
 * Security Marking Metadata for XML (ISM.XML) standard. The meaning of each individual marking and
 * the rules for including those markings in combination are defined in the ISM.XML Data Encoding
 * Specification. In addition to compliance with the ISM.XML reference XML schema (checking whether
 * each XML attribute is valid independently), the data encoding specification also requires that
 * data validate according to its Schematron validation tests, which look across the entire set of
 * markings to ensure that they are valid in combination. Note, however, that because the SODDXA TRE
 * is just one “portion” within the full NITF file, not every rule pertains to this fragment of XML
 * data. In particular, data providers are not required to include two sets of ISM.XML markings
 * within the SODDXA TRE data (one representing the document banner and one representing a portion
 * mark); validation of the ISM.XML markings within the {@code arh:Security} as a valid portion mark
 * is sufficient for conformance to the SODDXA TRE specification from a security marking
 * perspective.
 */
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
public class SecurityData {

    @JacksonXmlProperty(namespace = "urn:us:gov:ic:arh", localName = "Security")
    private ARHSecurity security;

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

    /**
     * Constructor.
     *
     * <p>This will create an empty security description, which is interpreted as fully unclassified
     * SODDXA content.
     */
    public SecurityData() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy values from.
     */
    public SecurityData(SecurityData other) {
        this.security = other.security;
        this.soClassification = other.soClassification;
        this.soSIC = other.soSIC;
        this.orconOrganization = other.orconOrganization;
        this.smClassification = other.smClassification;
        this.smRestrictedCollection = other.smRestrictedCollection;
        this.accmClassification = other.accmClassification;
        this.accmImageHold = other.accmImageHold;
    }

    /**
     * Security.
     *
     * <p>An element containing all security marking metadata necessary to describe the contents of
     * the SODDXA TRE itself, when that data contained directly within SODDXA is restricted or
     * classified higher than UNCLASSIFIED. Information about the space object not directly included
     * within SODDXA is not considered when specifying the security marking metadata. The {@code
     * arh:Security} element is defined within the ISM.XML standard. Since this instance of {@code
     * arh:Security} specifies the overall classification and security marking metadata for the
     * entire SODDXA XML instance document, the {@code ism:resourceElement} shall be included within
     * {@code arh:Security}'s attribute list and the value of that attribute shall be set to {@code
     * true}.
     *
     * @return the security markings, or null if not specified (implicitly UNCLASSIFIED).
     */
    public ARHSecurity getSecurity() {
        return security;
    }

    /**
     * Set security.
     *
     * <p>An element containing all security marking metadata necessary to describe the contents of
     * the SODDXA TRE itself, when that data contained directly within SODDXA is restricted or
     * classified higher than UNCLASSIFIED. Information about the space object not directly included
     * within SODDXA is not considered when specifying the security marking metadata. The {@code
     * arh:Security} element is defined within the ISM.XML standard. Since this instance of {@code
     * arh:Security} specifies the overall classification and security marking metadata for the
     * entire SODDXA XML instance document, the {@code ism:resourceElement} shall be included within
     * {@code arh:Security}'s attribute list and the value of that attribute shall be set to {@code
     * true}.
     *
     * @param security the security markings.
     */
    public void setSecurity(ARHSecurity security) {
        this.security = security;
    }

    public Classification getSoClassification() {
        return soClassification;
    }

    public void setSoClassification(Classification soClassification) {
        this.soClassification = soClassification;
    }

    /**
     * Security Indicator Code (SIC).
     *
     * <p>The Security Indicator Code (SIC) alphanumeric character that controls the distribution of
     * imagery and associated metadata to pre-arranged users as defined by NGA Source.
     *
     * <p>This field is optional.
     *
     * @return the SIC as text ( 0 to 9, A to F as defined by NGA Source)
     */
    public String getSoSIC() {
        return soSIC;
    }

    /**
     * Set the Security Indicator Code (SIC).
     *
     * <p>The Security Indicator Code (SIC) alphanumeric character that controls the distribution of
     * imagery and associated metadata to pre-arranged users as defined by NGA Source.
     *
     * <p>This field is optional.
     *
     * @param soSIC the SIC as text ( 0 to 9, A to F as defined by NGA Source)
     */
    public void setSoSIC(String soSIC) {
        this.soSIC = soSIC;
    }

    /**
     * Originator control (ORCON) organisation.
     *
     * <p>The name of the originating organization or entity that controls dissemination, enabling
     * the originator to maintain knowledge, supervision, and control of the distribution of
     * Originator Controlled (ORCON) information beyond its original dissemination.
     *
     * @return the originator control organisation, or null if not specified.
     */
    public String getOrconOrganization() {
        return orconOrganization;
    }

    /**
     * Set the originator control (ORCON) organisation.
     *
     * <p>The name of the originating organization or entity that controls dissemination, enabling
     * the originator to maintain knowledge, supervision, and control of the distribution of
     * Originator Controlled (ORCON) information beyond its original dissemination.
     *
     * @param organisation the originator control organisation.
     */
    public void setOrconOrganization(String organisation) {
        this.orconOrganization = organisation;
    }

    /**
     * Sources and methods classification.
     *
     * <p>An element of type {@code arh:ExternalSecurityType} specifying the security marking
     * metadata of the body of sources and methods applicable to the space object. This field must
     * not contain an {@code ism:resourceElement} attribute with the value of "true" anywhere within
     * its contents.
     *
     * @return sources and methods classification, or null if not specified (implicitly
     *     unclassified).
     */
    public Classification getSmClassification() {
        return smClassification;
    }

    /**
     * Set the sources and methods classification.
     *
     * <p>An element of type {@code arh:ExternalSecurityType} specifying the security marking
     * metadata of the body of sources and methods applicable to the space object. This field must
     * not contain an {@code ism:resourceElement} attribute with the value of "true" anywhere within
     * its contents.
     *
     * @param classification sources and methods classification.
     */
    public void setSmClassification(Classification classification) {
        this.smClassification = classification;
    }

    /**
     * Restricted collection indicator.
     *
     * <p>The Restricted Collection Indicator (RCI) indicates that the image was collected using
     * methods that result in imagery that cannot be released to foreign partners, even when
     * standard redaction and release processes are followed. If the boolean value is set to true,
     * the image of the space object was collected in a restricted collection mode and the collected
     * data is not releasable to foreign partners, even if fact-of NOFORN space objects are redacted
     * from or chipped out of the image or other standard release procedures are followed. If set to
     * false, then standard release procedures based on all available security metadata apply.
     *
     * @return true to indicate restricted collection, false to indicate not restricted collection,
     *     or null if not specified.
     */
    public Boolean getSmRestrictedCollection() {
        return smRestrictedCollection;
    }

    /**
     * Set the restricted collection indicator.
     *
     * <p>The Restricted Collection Indicator (RCI) indicates that the image was collected using
     * methods that result in imagery that cannot be released to foreign partners, even when
     * standard redaction and release processes are followed. If the boolean value is set to true,
     * the image of the space object was collected in a restricted collection mode and the collected
     * data is not releasable to foreign partners, even if fact-of NOFORN space objects are redacted
     * from or chipped out of the image or other standard release procedures are followed. If set to
     * false, then standard release procedures based on all available security metadata apply.
     *
     * @param smRestrictedCollection true to indicate restricted collection, otherwise false.
     */
    public void setSmRestrictedCollection(boolean smRestrictedCollection) {
        this.smRestrictedCollection = smRestrictedCollection;
    }

    /**
     * Alternative Compensatory Control Measures (ACCMs).
     *
     * <p>An element of type {@code arh:ExternalSecurityType} specifying the security marking
     * metadata of Alternative Compensatory Control Measure(s) (ACCMs) associated with the space
     * object. ACCMs are security measures used to safeguard classified information or operations
     * when normal measures are insufficient to achieve strict need-to-know controls and where other
     * controls are not required. The there must not contain an ism:resourceElement attribute with
     * the value of "true" anywhere within its contents.
     *
     * @return the alternative compensatory control measures, or null if not specified.
     */
    public Classification getAccmClassification() {
        return accmClassification;
    }

    /**
     * Set alternative Compensatory Control Measures (ACCMs).
     *
     * <p>An element of type {@code arh:ExternalSecurityType} specifying the security marking
     * metadata of Alternative Compensatory Control Measure(s) (ACCMs) associated with the space
     * object. ACCMs are security measures used to safeguard classified information or operations
     * when normal measures are insufficient to achieve strict need-to-know controls and where other
     * controls are not required. The there must not contain an ism:resourceElement attribute with
     * the value of "true" anywhere within its contents.
     *
     * @param accmClassification the alternative compensatory control measures, or null if not
     *     specified.
     */
    public void setAccmClassification(Classification accmClassification) {
        this.accmClassification = accmClassification;
    }

    /**
     * Alternative Compensatory Control Measures (ACCM) image hold.
     *
     * <p>A boolean true or false value indicating if an image meets more restrictive data hold
     * operations criteria upon user review of the image and associated metadata (true) or if the
     * image is to follow standard access and handling operations (false). Data consumers must
     * consult with the data provider to interpret specific Image Hold criteria and values.
     *
     * @return true to indicate ACCM hold, or false for standard handling, or null if not specified.
     */
    public Boolean getAccmImageHold() {
        return accmImageHold;
    }

    /**
     * Set the Alternative Compensatory Control Measures (ACCM) image hold flag.
     *
     * <p>A boolean true or false value indicating if an image meets more restrictive data hold
     * operations criteria upon user review of the image and associated metadata (true) or if the
     * image is to follow standard access and handling operations (false). Data consumers must
     * consult with the data provider to interpret specific Image Hold criteria and values.
     *
     * @param accmImageHold true to indicate ACCM hold, or false for standard handling.
     */
    public void setAccmImageHold(boolean accmImageHold) {
        this.accmImageHold = accmImageHold;
    }
}
