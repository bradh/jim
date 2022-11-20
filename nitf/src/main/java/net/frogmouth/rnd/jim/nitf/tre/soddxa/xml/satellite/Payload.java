package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

// TODO: we should be specifying order
public class Payload {
    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String payloadName;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String payloadId;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private String payloadDescription;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "sensor")
    private List<Sensor> sensors;

    public String getPayloadName() {
        return payloadName;
    }

    public void setPayloadName(String payloadName) {
        this.payloadName = payloadName;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public String getPayloadDescription() {
        return payloadDescription;
    }

    public void setPayloadDescription(String payloadDescription) {
        this.payloadDescription = payloadDescription;
    }

    public List<Sensor> getSensors() {
        return new ArrayList<>(sensors);
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = new ArrayList<>(sensors);
    }
}
