package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Status {
    @JacksonXmlProperty(isAttribute = true)
    // TODO: DateWithOptionalUTCTime
    private String statusDate;

    @JacksonXmlText private StatusType value;

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public StatusType getValue() {
        return value;
    }

    public void setValue(StatusType value) {
        this.value = value;
    }
}
