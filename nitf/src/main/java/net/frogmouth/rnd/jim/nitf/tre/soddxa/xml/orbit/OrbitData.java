package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "epochDate",
    "orbitRegime",
    "orbitCenter",
    "meanMotion",
    "orbitalPeriod",
    "inclination",
    "eccentricity",
    "apogeeAltitude",
    "perigeeAltitude"
})
public class OrbitData {
    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    // TODO: should be DateWithOptionalUTCTime
    private String epochDate;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private OrbitRegime orbitRegime;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private OrbitCenter orbitCenter;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double meanMotion;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double orbitalPeriod;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double inclination;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double eccentricity;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double apogeeAltitude;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double perigeeAltitude;

    /** Constructor. */
    public OrbitData() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy from.
     */
    public OrbitData(OrbitData other) {
        this.epochDate = other.epochDate;
        this.orbitRegime = other.orbitRegime;
        this.orbitCenter = other.orbitCenter;
        this.meanMotion = other.meanMotion;
        this.orbitalPeriod = other.orbitalPeriod;
        this.inclination = other.inclination;
        this.eccentricity = other.eccentricity;
        this.apogeeAltitude = other.apogeeAltitude;
        this.perigeeAltitude = other.perigeeAltitude;
    }

    public String getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(String epochDate) {
        this.epochDate = epochDate;
    }

    public OrbitRegime getOrbitRegime() {
        return new OrbitRegime(orbitRegime);
    }

    public void setOrbitRegime(OrbitRegime orbitRegime) {
        this.orbitRegime = new OrbitRegime(orbitRegime);
    }

    public OrbitCenter getOrbitCenter() {
        return orbitCenter;
    }

    public void setOrbitCenter(OrbitCenter orbitCenter) {
        this.orbitCenter = orbitCenter;
    }

    public Double getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Double meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Double getInclination() {
        return inclination;
    }

    public void setInclination(Double inclination) {
        this.inclination = inclination;
    }

    public Double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Double getApogeeAltitude() {
        return apogeeAltitude;
    }

    public void setApogeeAltitude(Double apogeeAltitude) {
        this.apogeeAltitude = apogeeAltitude;
    }

    public Double getPerigeeAltitude() {
        return perigeeAltitude;
    }

    public void setPerigeeAltitude(Double perigeeAltitude) {
        this.perigeeAltitude = perigeeAltitude;
    }
}
