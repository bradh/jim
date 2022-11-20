package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class LaunchSite {

    @JacksonXmlProperty(isAttribute = true)
    private String facilityName;

    @JacksonXmlText private String value;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
