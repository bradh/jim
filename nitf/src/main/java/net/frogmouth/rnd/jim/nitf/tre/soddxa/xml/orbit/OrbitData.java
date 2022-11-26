package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.DateWithOptionalUTCTime;
import net.frogmouth.rnd.jim.nitf.validation.ValidationResult;

/**
 * Orbit data.
 *
 * <p>The orbitData container specifies information about the nominal orbit of the space object.
 */
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
    private DateWithOptionalUTCTime epochDate;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private OrbitRegime orbitRegime;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "orbitCenter")
    private OrbitCentre orbitCentre;

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

    /**
     * Constructor.
     *
     * <p>This is only for the deserialisation implementation. Use the version that specifies the
     * orbit epoch.
     */
    private OrbitData() {}

    /**
     * Constructor.
     *
     * <p>The epoch date is the UTC date and time or just UTC date (only when time is not available
     * to the data provider) that the most current space object orbital attributes were published or
     * updated and used to populate many elements within this instance.
     *
     * <p>While no other orbit data elements are required, this object is not meaningful with at
     * least some other fields set.
     *
     * @param epochDate the epoch date.
     */
    public OrbitData(DateWithOptionalUTCTime epochDate) {
        this.epochDate = epochDate;
    }

    /**
     * Copy constructor.
     *
     * @param other the source object to copy from.
     */
    public OrbitData(OrbitData other) {
        this.epochDate = other.epochDate;
        this.orbitRegime = other.orbitRegime;
        this.orbitCentre = other.orbitCentre;
        this.meanMotion = other.meanMotion;
        this.orbitalPeriod = other.orbitalPeriod;
        this.inclination = other.inclination;
        this.eccentricity = other.eccentricity;
        this.apogeeAltitude = other.apogeeAltitude;
        this.perigeeAltitude = other.perigeeAltitude;
    }

    /**
     * Epoch date.
     *
     * <p>The UTC date and time or just UTC date (only when time is not available to the data
     * provider) the most current space object orbital attributes were published or updated and used
     * to populate many elements within the orbitData container.
     *
     * <p>This field is required.
     *
     * @return the orbit epoch date/time.
     */
    public DateWithOptionalUTCTime getEpochDate() {
        return epochDate;
    }

    /**
     * Orbit regime.
     *
     * <p>The region in space associated with a system’s dominant gravitational attraction capable
     * of capturing the orbit of other space objects. The orbit regime identifies the general kind
     * of orbit (e.g. LEO or HEO), and optionally allows further specification (e.g. Tundra or
     * Molniya).
     *
     * <p>This field is optional.
     *
     * @return the orbit regime
     */
    public OrbitRegime getOrbitRegime() {
        return this.orbitRegime;
    }

    /**
     * Set the orbit regime.
     *
     * <p>The region in space associated with a system’s dominant gravitational attraction capable
     * of capturing the orbit of other space objects.
     *
     * <p>This field is optional.
     *
     * @param orbitRegime the orbit regime.
     */
    public void setOrbitRegime(OrbitRegime orbitRegime) {
        this.orbitRegime = orbitRegime;
    }

    /**
     * Orbit centre.
     *
     * <p>The name of the celestial body at the origin or barycentre of the space object’s orbit and
     * reference frame.
     *
     * <p>This field is optional.
     *
     * @return the orbit centre as an enumerated value.
     */
    public OrbitCentre getOrbitCentre() {
        return orbitCentre;
    }

    /**
     * Set the orbit centre.
     *
     * <p>The name of the celestial body at the origin or barycentre of the space object’s orbit and
     * reference frame.
     *
     * <p>This field is optional.
     *
     * @param orbitCentre the orbit centre as an enumerated value.
     */
    public void setOrbitCenter(OrbitCentre orbitCentre) {
        this.orbitCentre = orbitCentre;
    }

    /**
     * Mean motion.
     *
     * <p>The measure of how fast a space object progresses in its orbit, specified in the average
     * number of revolutions per day.
     *
     * <p>This field is optional.
     *
     * @return the mean motion in orbit revolutions per day, or null if not specified.
     */
    public Double getMeanMotion() {
        return meanMotion;
    }

    /**
     * Set the mean motion.
     *
     * <p>The measure of how fast a space object progresses in its orbit, specified in the average
     * number of revolutions per day.
     *
     * <p>This field is optional.
     *
     * @param meanMotion the mean motion in orbit revolutions per day.
     */
    public void setMeanMotion(Double meanMotion) {
        this.meanMotion = meanMotion;
    }

    /**
     * Orbital period.
     *
     * <p>The time it takes a space object to complete one revolution or orbit around a celestial
     * body, as provided by the catalogue specified in the {@code sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @return the orbital period in minutes, or null if not specified.
     */
    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    /**
     * Set the orbital period.
     *
     * <p>The time it takes a space object to complete one revolution or orbit around a celestial
     * body, as provided by the catalogue specified in the {@code sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @param orbitalPeriod the orbital period in minutes.
     */
    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    /**
     * Inclination.
     *
     * <p>The angle formed by the Earth equatorial plane and the satellite orbit plane, measured
     * counter-clockwise from the equatorial plane at the ascending node, as provided by the
     * catalogue specified in the {@code sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @return the inclination in units of degrees.
     */
    public Double getInclination() {
        return inclination;
    }

    /**
     * Set the inclination.
     *
     * <p>The angle formed by the Earth equatorial plane and the satellite orbit plane, measured
     * counter-clockwise from the equatorial plane at the ascending node, as provided by the
     * catalogue specified in the {@code sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @param inclination the inclination in units of degrees.
     */
    public void setInclination(Double inclination) {
        this.inclination = inclination;
    }

    /**
     * Eccentricity.
     *
     * <p>A measure of the deviation of the elliptical path of an orbiting satellite from a circular
     * orbit (0=circular, less than 1=elliptical).
     *
     * <p>This field is optional.
     *
     * @return orbital eccentricity, or null if not specified.
     */
    public Double getEccentricity() {
        return eccentricity;
    }

    /**
     * Set the eccentricity.
     *
     * <p>A measure of the deviation of the elliptical path of an orbiting satellite from a circular
     * orbit (0=circular, less than 1=elliptical).
     *
     * <p>This field is optional.
     *
     * @param eccentricity orbital eccentricity.
     */
    public void setEccentricity(Double eccentricity) {
        this.eccentricity = eccentricity;
    }

    /**
     * Apogee altitude.
     *
     * <p>The altitudinal node in a space object’s orbit farthest from the primary body's geocentre
     * (the point with the minimum velocity), as provided by the catalogue specified in the {@code
     * sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @return the apogee altitude in kilometres
     */
    public Double getApogeeAltitude() {
        return apogeeAltitude;
    }

    /**
     * Set the apogee altitude.
     *
     * <p>The altitudinal node in a space object’s orbit farthest from the primary body's geocentre
     * (the point with the minimum velocity), as provided by the catalogue specified in the {@code
     * sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @param apogeeAltitude the apogee altitude in kilometres
     */
    public void setApogeeAltitude(Double apogeeAltitude) {
        this.apogeeAltitude = apogeeAltitude;
    }

    /**
     * Perigee altitude.
     *
     * <p>The altitudinal node in a space object’s orbit closest to the primary body’s geocenter
     * (point of maximum velocity), as provided by the catalogue specified in the {@code
     * sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @return the perigee altitude in kilometres
     */
    public Double getPerigeeAltitude() {
        return perigeeAltitude;
    }

    /**
     * Set the perigee altitude.
     *
     * <p>The altitudinal node in a space object’s orbit closest to the primary body’s geocenter
     * (point of maximum velocity), as provided by the catalogue specified in the {@code
     * sourceCatalog} element.
     *
     * <p>This field is optional.
     *
     * @param perigeeAltitude the perigee altitude in kilometres
     */
    public void setPerigeeAltitude(Double perigeeAltitude) {
        this.perigeeAltitude = perigeeAltitude;
    }

    public List<ValidationResult> checkValidity() {
        List<ValidationResult> results = new ArrayList<>();
        // TODO: check epoch date
        // TODO: check value ranges
        return results;
    }
}
