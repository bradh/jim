package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Launch information.
 *
 * <p>The launch container specifies information about the satellite launch or insertion.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"launchSiteId", "launchOrg", "launchDate", "launchVehicle"})
public class LaunchType {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private LaunchSite launchSiteId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String launchOrg;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    // TODO: DateWithOptionalUTCTime
    private String launchDate;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String launchVehicle;

    /** Constructor. */
    public LaunchType() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy values from.
     */
    public LaunchType(LaunchType other) {
        this.launchSiteId = other.launchSiteId;
        this.launchOrg = other.launchOrg;
        this.launchDate = other.launchDate;
        this.launchVehicle = other.launchVehicle;
    }

    /**
     * Launch site identification.
     *
     * <p>The satellite launch site unique identifier as provided by the catalog specified in the
     * sourceCatalog element.
     *
     * @return the launch site identification.
     */
    public LaunchSite getLaunchSiteId() {
        if (launchSiteId == null) {
            return null;
        } else {
            return new LaunchSite(launchSiteId);
        }
    }

    public void setLaunchSiteId(LaunchSite launchSiteId) {
        if (launchSiteId == null) {
            this.launchSiteId = null;
        } else {
            this.launchSiteId = new LaunchSite(launchSiteId);
        }
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

    public void setLaunchOrg(String launchOrg) {
        this.launchOrg = launchOrg;
    }

    /**
     * Launch date.
     *
     * <p>The UTC date and UTC time or just the UTC date (only when time is not available to the
     * data provider) on which the satellite was launched as provided by the catalog specified in
     * the sourceCatalog element.
     *
     * @return launch date / time.
     */
    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
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
