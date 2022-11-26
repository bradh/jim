package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.DateWithOptionalUTCTime;

/**
 * Launch information.
 *
 * <p>The launch container specifies information about the satellite launch or insertion.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"launchSiteId", "launchOrg", "launchDate", "launchVehicle"})
public class Launch {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private LaunchSite launchSiteId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String launchOrg;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private DateWithOptionalUTCTime launchDate;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String launchVehicle;

    /** Constructor. */
    public Launch() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy values from.
     */
    public Launch(Launch other) {
        this.launchSiteId = other.launchSiteId;
        this.launchOrg = other.launchOrg;
        this.launchDate = other.launchDate;
        this.launchVehicle = other.launchVehicle;
    }

    /**
     * Launch site identification.
     *
     * <p>The satellite launch site unique identifier and name as provided by the catalogue
     * specified in the {@code sourceCatalog} element.
     *
     * @return the launch site identification.
     */
    public LaunchSite getLaunchSiteId() {
        return this.launchSiteId;
    }

    public void setLaunchSiteId(LaunchSite launchSiteId) {
        this.launchSiteId = launchSiteId;
    }

    /**
     * Launch organisation.
     *
     * <p>The name of the organisation charged with the launch operation that includes the satellite
     * payload.
     *
     * @return the launch organisation.
     */
    public String getLaunchOrg() {
        return launchOrg;
    }

    /**
     * Set the launch organisation.
     *
     * <p>The name of the organisation charged with the launch operation that includes the satellite
     * payload.
     *
     * @param launchOrg the launch organisation.
     */
    public void setLaunchOrg(String launchOrg) {
        this.launchOrg = launchOrg;
    }

    /**
     * Launch date.
     *
     * <p>The UTC date and UTC time or just the UTC date (only when time is not available to the
     * data provider) on which the satellite was launched as provided by the catalogue specified in
     * the sourceCatalog element.
     *
     * @return launch date / time.
     */
    public DateWithOptionalUTCTime getLaunchDate() {
        return launchDate;
    }

    /**
     * Set the launch date.
     *
     * <p>The UTC date and UTC time or just the UTC date (only when time is not available to the
     * data provider) on which the satellite was launched as provided by the catalogue specified in
     * the sourceCatalog element.
     *
     * @param launchDate launch date / time.
     */
    public void setLaunchDate(DateWithOptionalUTCTime launchDate) {
        this.launchDate = launchDate;
    }

    /**
     * Launch vehicle.
     *
     * <p>The name of the system that hosted the satellite payload during launch or insertion in
     * space.
     *
     * @return launch vehicle or system.
     */
    public String getLaunchVehicle() {
        return launchVehicle;
    }

    public void setLaunchVehicle(String launchVehicle) {
        this.launchVehicle = launchVehicle;
    }
}
