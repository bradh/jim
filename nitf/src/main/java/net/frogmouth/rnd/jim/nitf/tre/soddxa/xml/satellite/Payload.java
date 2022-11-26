package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Payload.
 *
 * <p>The payload container specifies information about the platform's sensors and equipment
 * necessary to perform specific tasks, excluding the instrumentation necessary for the platform to
 * operate. A platform may include zero or more payloads.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"payloadName", "payloadId", "payloadDescription", "sensor"})
public class Payload {
    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String payloadName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String payloadId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String payloadDescription;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "sensor")
    private List<Sensor> sensors;

    /**
     * Payload name.
     *
     * <p>The common name of the payload or sensor suite carried or mounted to the satellite
     * platform.
     *
     * @return the payload name, or null if not specified.
     */
    public String getPayloadName() {
        return payloadName;
    }

    /**
     * Set the payload name.
     *
     * <p>The common name of the payload or sensor suite carried or mounted to the satellite
     * platform.
     *
     * @param payloadName the payload name.
     */
    public void setPayloadName(String payloadName) {
        this.payloadName = payloadName;
    }

    /**
     * Payload identifier.
     *
     * <p>A sequence of characters derived from a catalogue or other authoritative source that
     * uniquely identifies a payload or sensor suite.
     *
     * @return the payload identifier, or null if not specified.
     */
    public String getPayloadId() {
        return payloadId;
    }

    /**
     * Set the payload identifier.
     *
     * <p>A sequence of characters derived from a catalogue or other authoritative source that
     * uniquely identifies a payload or sensor suite.
     *
     * @param payloadId the payload identifier.
     */
    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    /**
     * Payload description.
     *
     * <p>A free-text description of the imaged satellite's payload.
     *
     * @return the payload description, or null if not specified.
     */
    public String getPayloadDescription() {
        return payloadDescription;
    }

    /**
     * Set the payload description.
     *
     * <p>A free-text description of the imaged satellite's payload.
     *
     * @param payloadDescription the payload description.
     */
    public void setPayloadDescription(String payloadDescription) {
        this.payloadDescription = payloadDescription;
    }

    /**
     * Sensors.
     *
     * <p>List of sensors. Each sensor instance provides information about a sensor on the space
     * object. This element may be repeated to support multiple sensors on the space object.
     *
     * @return the list of sensors, may be empty.
     */
    public List<Sensor> getSensors() {
        return new ArrayList<>(sensors);
    }

    /**
     * Set the sensors.
     *
     * <p>List of sensors. Each sensor instance provides information about a sensor on the space
     * object. This element may be repeated to support multiple sensors on the space object.
     *
     * @param sensors the list of sensors, may be empty.
     */
    public void setSensors(List<Sensor> sensors) {
        this.sensors = new ArrayList<>(sensors);
    }
}
