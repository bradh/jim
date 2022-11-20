package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"maneuverableVehicleFlag", "maneuverEpoch", "maneuverPurpose"})
public class ManeuverDataType {

    @JacksonXmlProperty(
            localName = "maneuverableVehicleFlag",
            namespace = "urn:us:mil:nga:ntb:soddxa")
    private Boolean maneuverableVehicle;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    // TODO: DateWithOptionalUTCTime
    private String maneuverEpoch;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String maneuverPurpose;

    public Boolean isManeuverableVehicle() {
        return maneuverableVehicle;
    }

    public void setManeuverableVehicle(Boolean maneuverableVehicle) {
        this.maneuverableVehicle = maneuverableVehicle;
    }

    public String getManeuverEpoch() {
        return maneuverEpoch;
    }

    public void setManeuverEpoch(String maneuverEpoch) {
        this.maneuverEpoch = maneuverEpoch;
    }

    public String getManeuverPurpose() {
        return maneuverPurpose;
    }

    public void setManeuverPurpose(String maneuverPurpose) {
        this.maneuverPurpose = maneuverPurpose;
    }
}
