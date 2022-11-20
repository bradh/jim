package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ARHContainer {
    @JacksonXmlProperty(
            namespace = "urn:us:gov:ic:ism",
            localName = "classification",
            isAttribute = true)
    private String classification;

    @JacksonXmlProperty(
            namespace = "urn:us:gov:ic:ism",
            localName = "ownerProducer",
            isAttribute = true)
    private String ownerProducer;

    @JacksonXmlProperty(
            namespace = "urn:us:gov:ic:ism",
            localName = "excludeFromRollup",
            isAttribute = true)
    private boolean excludeFromRollup;

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getOwnerProducer() {
        return ownerProducer;
    }

    public void setOwnerProducer(String ownerProducer) {
        this.ownerProducer = ownerProducer;
    }

    public boolean isExcludeFromRollup() {
        return excludeFromRollup;
    }

    public void setExcludeFromRollup(boolean excludeFromRollup) {
        this.excludeFromRollup = excludeFromRollup;
    }
}
