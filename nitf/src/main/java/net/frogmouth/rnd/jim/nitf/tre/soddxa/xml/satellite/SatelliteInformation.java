package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "satNo",
    "targetId",
    "satelliteName",
    "platformId",
    "satelliteCategory",
    "satelliteDescription",
    "internationalDesignator",
    "constellationFlag",
    "closelySpacedObject",
    "threatCategory",
    "status",
    "flightOrientation",
    "attitudeControlMode",
    "attitudeActuatorType",
    "maneuverData",
    "payload",
    "launch",
    "affiliation"
})
public class SatelliteInformation {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private int satNo;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String targetId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String satelliteName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String platformId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "satelliteCategory")
    private List<SatelliteCategory> satelliteCategories;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String satelliteDescription;

    @JacksonXmlProperty(
            localName = "internationalDesignator",
            namespace = "urn:us:mil:nga:ntb:soddxa")
    private List<InternationalDesignator> internationalDesignators;

    @JacksonXmlProperty(localName = "constellationFlag", namespace = "urn:us:mil:nga:ntb:soddxa")
    private boolean constellation;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private boolean closelySpacedObject;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private ThreatCategory threatCategory;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Status status;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private FlightOrientation flightOrientation;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private AttitudeControlMode attitudeControlMode;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private AttitudeActuatorType attitudeActuatorType;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private ManoeuvreData maneuverData;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "payload")
    private List<Payload> payloads;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Launch launch;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "affiliation")
    private List<Affiliation> affiliations;

    private SatelliteInformation() {}

    public SatelliteInformation(int satNo, String satelliteName) {
        this.satNo = satNo;
        this.satelliteName = satelliteName;
    }

    public SatelliteInformation(SatelliteInformation other) {
        this.satNo = other.satNo;
        this.targetId = other.targetId;
        this.satelliteName = other.satelliteName;
        this.platformId = other.platformId;
        this.satelliteCategories = other.satelliteCategories;
        this.satelliteDescription = other.satelliteDescription;
        this.internationalDesignators = other.internationalDesignators;
        this.constellation = other.constellation;
        this.closelySpacedObject = other.closelySpacedObject;
        this.threatCategory = other.threatCategory;
        this.status = other.status;
        this.flightOrientation = other.flightOrientation;
        this.attitudeControlMode = other.attitudeControlMode;
        this.attitudeActuatorType = other.attitudeActuatorType;
        this.maneuverData = other.maneuverData;
        this.payloads = other.payloads;
        this.launch = other.launch;
        this.affiliations = other.affiliations;
    }

    public int getSatNo() {
        return satNo;
    }

    public void setSatNo(int satNo) {
        this.satNo = satNo;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public List<SatelliteCategory> getSatelliteCategories() {
        return new ArrayList<>(satelliteCategories);
    }

    public void setSatelliteCategories(List<SatelliteCategory> satelliteCategories) {
        this.satelliteCategories = new ArrayList<>(satelliteCategories);
    }

    public String getSatelliteDescription() {
        return satelliteDescription;
    }

    public void setSatelliteDescription(String satelliteDescription) {
        this.satelliteDescription = satelliteDescription;
    }

    /**
     * International designators.
     *
     * <p>The USSF standard format International Designator(s) and piece types as provided by the
     * catalogue specified in the {@code sourceCatalog} element.
     *
     * <p>This field is allowed to contain any number (including zero) designators.
     *
     * @return list of designators
     */
    public List<InternationalDesignator> getInternationalDesignators() {
        return new ArrayList<>(internationalDesignators);
    }

    /**
     * Set the international designators.
     *
     * <p>The USSF standard format International Designator(s) and piece types as provided by the
     * catalogue specified in the {@code sourceCatalog} element.
     *
     * <p>This field is allowed to contain any number (including zero) designators.
     *
     * @param internationalDesignators list of designators
     */
    public void setInternationalDesignators(
            List<InternationalDesignator> internationalDesignators) {
        this.internationalDesignators = new ArrayList<>(internationalDesignators);
    }

    public boolean isConstellation() {
        return constellation;
    }

    public void setConstellation(boolean constellation) {
        this.constellation = constellation;
    }

    public boolean isCloselySpacedObject() {
        return closelySpacedObject;
    }

    public void setCloselySpacedObject(boolean closelySpacedObject) {
        this.closelySpacedObject = closelySpacedObject;
    }

    public ThreatCategory getThreatCategory() {
        return threatCategory;
    }

    public void setThreatCategory(ThreatCategory threatCategory) {
        this.threatCategory = threatCategory;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public FlightOrientation getFlightOrientation() {
        return flightOrientation;
    }

    public void setFlightOrientation(FlightOrientation flightOrientation) {
        this.flightOrientation = flightOrientation;
    }

    public AttitudeControlMode getAttitudeControlMode() {
        return attitudeControlMode;
    }

    public void setAttitudeControlMode(AttitudeControlMode attitudeControlMode) {
        this.attitudeControlMode = attitudeControlMode;
    }

    public AttitudeActuatorType getAttitudeActuatorType() {
        return attitudeActuatorType;
    }

    public void setAttitudeActuatorType(AttitudeActuatorType attitudeActuatorType) {
        this.attitudeActuatorType = attitudeActuatorType;
    }

    public ManoeuvreData getManeuverData() {
        if (maneuverData == null) {
            return null;
        } else {
            return new ManoeuvreData(maneuverData);
        }
    }

    public void setManeuverData(ManoeuvreData maneuverData) {
        if (maneuverData == null) {
            this.maneuverData = null;
        } else {
            this.maneuverData = new ManoeuvreData(maneuverData);
        }
    }

    public List<Payload> getPayloads() {
        return new ArrayList<>(payloads);
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = new ArrayList<>(payloads);
    }

    public Launch getLaunch() {
        if (launch == null) {
            return null;
        } else {
            return new Launch(launch);
        }
    }

    public void setLaunch(Launch launch) {
        if (launch == null) {
            this.launch = null;
        } else {
            this.launch = new Launch(launch);
        }
    }

    public List<Affiliation> getAffiliations() {
        return new ArrayList<>(affiliations);
    }

    public void setAffiliations(List<Affiliation> affiliations) {
        this.affiliations = new ArrayList<>(affiliations);
    }
}
