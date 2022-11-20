package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public String getSensorDescription() {
        return sensorDescription;
    }

    public void setSensorDescription(String sensorDescription) {
        this.sensorDescription = sensorDescription;
    }
}
