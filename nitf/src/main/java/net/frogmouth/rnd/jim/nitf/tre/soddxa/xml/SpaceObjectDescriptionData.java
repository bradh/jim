package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.UUID;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog.SourceCatalog;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection.CollectionData;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.nonsatellite.NonSatelliteInformation;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit.OrbitData;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.SatelliteInformation;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security.SecurityDataType;

@JacksonXmlRootElement(
        namespace = "urn:us:mil:nga:ntb:soddxa",
        localName = "spaceObjectDescriptionData")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "securityData",
    "sourceCatalog",
    "absVisualMagnitude",
    "radarCrossSection",
    "length",
    "width",
    "height",
    "diameter",
    "mass",
    "soUid",
    "soType",
    "nonSatelliteInformation",
    "satelliteInformation",
    "collectionData",
    "orbitData"
})
public class SpaceObjectDescriptionData {

    public SpaceObjectDescriptionData() {}

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SecurityDataType securityData;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SourceCatalog sourceCatalog;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double absVisualMagnitude;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double radarCrossSection;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double length;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double width;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double height;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double diameter;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double mass;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private UUID soUid;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SpaceObjectType soType;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private NonSatelliteInformation nonSatelliteInformation;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SatelliteInformation satelliteInformation;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private CollectionData collectionData;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private OrbitData orbitData;

    public SecurityDataType getSecurityData() {
        return securityData;
    }

    public void setSecurityData(SecurityDataType securityData) {
        this.securityData = securityData;
    }

    public SourceCatalog getSourceCatalog() {
        if (sourceCatalog == null) {
            return null;
        } else {
            return new SourceCatalog(sourceCatalog);
        }
    }

    public void setSourceCatalog(SourceCatalog sourceCatalog) {
        if (sourceCatalog == null) {
            this.sourceCatalog = null;
        } else {
            this.sourceCatalog = new SourceCatalog(sourceCatalog);
        }
    }

    public Double getAbsVisualMagnitude() {
        return absVisualMagnitude;
    }

    public void setAbsVisualMagnitude(Double absVisualMagnitude) {
        this.absVisualMagnitude = absVisualMagnitude;
    }

    public Double getRadarCrossSection() {
        return radarCrossSection;
    }

    public void setRadarCrossSection(Double radarCrossSection) {
        this.radarCrossSection = radarCrossSection;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public UUID getSoUid() {
        return soUid;
    }

    public void setSoUid(UUID soUid) {
        this.soUid = soUid;
    }

    public SpaceObjectType getSoType() {
        return soType;
    }

    public void setSoType(SpaceObjectType soType) {
        this.soType = soType;
    }

    public NonSatelliteInformation getNonSatelliteInformation() {
        if (nonSatelliteInformation == null) {
            return null;
        } else {
            return new NonSatelliteInformation(nonSatelliteInformation);
        }
    }

    public void setNonSatelliteInformation(NonSatelliteInformation nonSatelliteInformation) {
        if (nonSatelliteInformation == null) {
            this.nonSatelliteInformation = null;
        } else {
            this.nonSatelliteInformation = new NonSatelliteInformation(nonSatelliteInformation);
        }
    }

    public SatelliteInformation getSatelliteInformation() {
        return satelliteInformation;
    }

    public void setSatelliteInformation(SatelliteInformation satelliteInformation) {
        this.satelliteInformation = satelliteInformation;
    }

    public CollectionData getCollectionData() {
        return new CollectionData(collectionData);
    }

    public void setCollectionData(CollectionData collectionData) {
        this.collectionData = new CollectionData(collectionData);
    }

    public OrbitData getOrbitData() {
        if (orbitData == null) {
            return null;
        } else {
            return new OrbitData(orbitData);
        }
    }

    public void setOrbitData(OrbitData orbitData) {
        if (orbitData == null) {
            this.orbitData = null;
        } else {
            this.orbitData = new OrbitData(orbitData);
        }
    }
}
