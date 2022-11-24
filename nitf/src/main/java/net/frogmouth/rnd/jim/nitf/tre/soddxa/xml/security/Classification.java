package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Security classification.
 *
 * <p>This is a simple container class, used in multiple places.
 */
public class Classification {
    @JacksonXmlProperty(namespace = "urn:us:gov:ic:arh", localName = "ExternalSecurity")
    private ARHContainer externalSecurity;

    /**
     * External security.
     *
     * <p>An element of type {@code arh:ExternalSecurityType} specifying the security marking
     * metadata.
     *
     * @return security metadata
     */
    public ARHContainer getExternalSecurity() {
        return externalSecurity;
    }

    /**
     * External security.
     *
     * <p>An element of type {@code arh:ExternalSecurityType} specifying the security marking
     * metadata.
     *
     * @param externalSecurity security metadata
     */
    public void setExternalSecurity(ARHContainer externalSecurity) {
        this.externalSecurity = externalSecurity;
    }
}
