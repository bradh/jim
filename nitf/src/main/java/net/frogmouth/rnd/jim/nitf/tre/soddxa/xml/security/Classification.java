package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Classification {
    @JacksonXmlProperty(namespace = "urn:us:gov:ic:arh", localName = "ExternalSecurity")
    private ARHContainer externalSecurity;

    public ARHContainer getExternalSecurity() {
        return externalSecurity;
    }

    public void setExternalSecurity(ARHContainer externalSecurity) {
        this.externalSecurity = externalSecurity;
    }
}
