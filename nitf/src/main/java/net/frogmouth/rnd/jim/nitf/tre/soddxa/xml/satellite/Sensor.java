package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Sensor.
 *
 * <p>The sensor container specifies information about the satellite’s sensor and may be repeated
 * within the payload element to support multiple sensors.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"missionId", "sensorName", "sensorId", "modality", "sensorDescription"})
public class Sensor {
    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String missionId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String sensorName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String sensorId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Modality modality;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String sensorDescription;

    /** Constructor. */
    public Sensor() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy values from.
     */
    public Sensor(Sensor other) {
        this.missionId = other.missionId;
        this.sensorName = other.sensorName;
        this.sensorId = other.sensorId;
        this.modality = other.modality;
        this.sensorDescription = other.sensorDescription;
    }

    /**
     * Mission identification.
     *
     * @return the mission identification, or null if not specified.
     */
    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    /**
     * Sensor name.
     *
     * <p>The common name of the sensor mounted to the satellite platform.
     *
     * @return the sensor name as a free-text string, or null if not specified.
     */
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * Sensor identifier.
     *
     * <p>The unique identifier assigned to the sensor mounted to the imaged satellite.
     *
     * @return the sensor identifier as a free-text string, or null if not specified.
     */
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * Sensor modality.
     *
     * <p>The phenomenology of the sensor payload included on the imaged satellite, or null if not
     * specified.
     *
     * @return the sensor modality as an enumerated value.
     */
    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    /**
     * Sensor description.
     *
     * <p>A free-text description of the sensor payload on the imaged satellite, or null if not
     * specified.
     *
     * @return the sensor description.
     */
    public String getSensorDescription() {
        return sensorDescription;
    }

    public void setSensorDescription(String sensorDescription) {
        this.sensorDescription = sensorDescription;
    }
}
