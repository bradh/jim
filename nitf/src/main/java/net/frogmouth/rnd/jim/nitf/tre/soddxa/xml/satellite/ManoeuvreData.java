package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Manoeuvre data.
 *
 * <p>A container that specifies information about the satellite’s commanded and controlled
 * movement.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"maneuverableVehicleFlag", "maneuverEpoch", "maneuverPurpose"})
public class ManoeuvreData {

    @JacksonXmlProperty(
            localName = "maneuverableVehicleFlag",
            namespace = "urn:us:mil:nga:ntb:soddxa")
    private Boolean manoeuvrableVehicle;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "maneuverEpoch")
    // TODO: DateWithOptionalUTCTime
    private String manoeuvreEpoch;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "maneuverPurpose")
    private String manoeuvrePurpose;

    /** Constructor. */
    public ManoeuvreData() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy values from
     */
    public ManoeuvreData(ManoeuvreData other) {
        this.manoeuvrableVehicle = other.manoeuvrableVehicle;
        this.manoeuvreEpoch = other.manoeuvreEpoch;
        this.manoeuvrePurpose = other.manoeuvrePurpose;
    }

    /**
     * Manoeuvrable vehicle flag.
     *
     * <p>A boolean value indicating if the space object can perform manoeuvres (true) or not
     * (false).
     *
     * @return true for a manoeuvrable vehicle, false for a non-manoeuvrable vehicle, or null if not
     *     specified.
     */
    public Boolean isManoeuvrableVehicle() {
        return manoeuvrableVehicle;
    }

    public void setManoeuvrableVehicle(Boolean manoeuvrableVehicle) {
        this.manoeuvrableVehicle = manoeuvrableVehicle;
    }

    /**
     * Manoeuvre epoch.
     *
     * <p>The UTC date and time or just the date (only when time is not available to the data
     * provider) the satellite performed its most current known manoeuvre.
     *
     * @return the manoeuvre date / time.
     */
    public String getManoeuvreEpoch() {
        return manoeuvreEpoch;
    }

    public void setManoeuvreEpoch(String maneuverEpoch) {
        this.manoeuvreEpoch = maneuverEpoch;
    }

    /**
     * Manoeuvre purpose.
     *
     * <p>An element that specifies the intention of the manoeuvre performed at the date and time
     * specified in the manoeuvreEpoch element.
     *
     * @return text describing the purpose of the manoeuvre.
     */
    public String getManoeuvrePurpose() {
        return manoeuvrePurpose;
    }

    public void setManoeuvrePurpose(String maneuverPurpose) {
        this.manoeuvrePurpose = maneuverPurpose;
    }
}
