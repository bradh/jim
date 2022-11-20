package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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

    public LaunchSite getLaunchSiteId() {
        return launchSiteId;
    }

    public void setLaunchSiteId(LaunchSite launchSiteId) {
        this.launchSiteId = launchSiteId;
    }

    public String getLaunchOrg() {
        return launchOrg;
    }

    public void setLaunchOrg(String launchOrg) {
        this.launchOrg = launchOrg;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getLaunchVehicle() {
        return launchVehicle;
    }

    public void setLaunchVehicle(String launchVehicle) {
        this.launchVehicle = launchVehicle;
    }
}
