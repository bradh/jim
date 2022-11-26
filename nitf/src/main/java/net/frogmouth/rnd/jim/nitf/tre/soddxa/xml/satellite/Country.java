package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Affiliation country.
 *
 * <p>The name of the country or other geopolitical entity (or administrative subdivision of an
 * entity) that is affiliated with the space object and associated with its country affiliation
 * element. The textual value is correlated to the country code..
 */
public class Country {
    @JacksonXmlProperty(isAttribute = true, localName = "cc")
    private String countryCode;

    @JacksonXmlText private String name;

    /**
     * Constructor.
     *
     * <p>This is only for deserialisation support. Use the version that takes the country code and
     * name.
     */
    private Country() {}

    /**
     * Constructor.
     *
     * @param countryCode the country code in valid GENC Short URN-based format.
     * @param name the country name
     */
    public Country(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    /**
     * Country code.
     *
     * <p>The code representing the country specified by the countryName, formatted as a Short
     * URN-based individual item identifier (e.g., {@code ge:GENC:2:ed1:CN} representing China). The
     * Short URN-based individual item identifier format is specified in version 3.0.1 of the GENC
     * standard.
     *
     * @return the country code as a string.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Country name.
     *
     * <p>The name of the country or other geopolitical entity (or administrative subdivision of an
     * entity) that is affiliated with the space object and associated with its country parent
     * element. This textual value is correlated to its country code.
     *
     * @return country name as text
     */
    public String getName() {
        return name;
    }
}
