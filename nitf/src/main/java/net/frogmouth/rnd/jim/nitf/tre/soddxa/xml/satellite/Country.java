package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Country {
    @JacksonXmlProperty(isAttribute = true, localName = "cc")
    private String countryCode;

    @JacksonXmlText private String name;

    private Country() {}

    public Country(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public Country(Country other) {
        this.countryCode = other.countryCode;
        this.name = other.name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }
}
