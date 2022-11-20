package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Country {
    @JacksonXmlProperty(isAttribute = true, localName = "cc")
    private String countryCode;

    @JacksonXmlText private String name;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
