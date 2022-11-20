package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "collectionReqId",
    "priority",
    "revNumber",
    "passNumber",
    "background",
    "lightingCondition",
    "appVisualMagnitude",
    "reflectance",
    "snr"
})
public class CollectionData {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String collectionReqId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer priority;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer revNumber;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer passNumber;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Background background;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "lightingCondition")
    private List<LightingCondition> lightingConditions;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double appVisualMagnitude;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Integer reflectance;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double snr;

    public CollectionData() {}

    public CollectionData(CollectionData other) {
        this.collectionReqId = other.collectionReqId;
        this.priority = other.priority;
        this.revNumber = other.revNumber;
        this.passNumber = other.passNumber;
        this.background = other.background;
        this.lightingConditions = other.lightingConditions;
        this.appVisualMagnitude = other.appVisualMagnitude;
        this.reflectance = other.reflectance;
        this.snr = other.snr;
    }

    public String getCollectionReqId() {
        return collectionReqId;
    }

    public void setCollectionReqId(String collectionReqId) {
        this.collectionReqId = collectionReqId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRevNumber() {
        return revNumber;
    }

    public void setRevNumber(Integer revNumber) {
        this.revNumber = revNumber;
    }

    public Integer getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(Integer passNumber) {
        this.passNumber = passNumber;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public List<LightingCondition> getLightingConditions() {
        return new ArrayList<>(lightingConditions);
    }

    public void setLightingConditions(List<LightingCondition> lightingConditions) {
        this.lightingConditions = new ArrayList<>(lightingConditions);
    }

    public Double getAppVisualMagnitude() {
        return appVisualMagnitude;
    }

    public void setAppVisualMagnitude(Double appVisualMagnitude) {
        this.appVisualMagnitude = appVisualMagnitude;
    }

    public Integer getReflectance() {
        return reflectance;
    }

    public void setReflectance(Integer reflectance) {
        this.reflectance = reflectance;
    }

    public Double getSnr() {
        return snr;
    }

    public void setSnr(Double snr) {
        this.snr = snr;
    }
}
