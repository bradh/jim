package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Organisation type.
 *
 * <p>The type of organization associated with this affiliation element.
 */
public enum OrganisationType {
    /**
     * Civil.
     *
     * <p>The organization is a government civil agency (e.g., NASA, NOAA, USGS or non-US
     * equivalent).
     */
    @JsonProperty("civil")
    CIVIL,

    /**
     * Commercial.
     *
     * <p>The organization is a commercial non-state entity.
     */
    @JsonProperty("commercial")
    COMMERCIAL,

    /**
     * Non-commercial.
     *
     * <p>The organization is a non-commercial non-state entity (e.g., AMSAT).
     */
    @JsonProperty("non-commercial")
    NON_COMMERCIAL,

    /**
     * Military.
     *
     * <p>The organization is a military (DoD or non-US equivalent) organization.
     */
    @JsonProperty("military")
    MILITARY,

    /**
     * Intelligence community.
     *
     * <p>The organization is an intelligence community (IC) entity.
     */
    @JsonProperty("ic")
    INTELLIGENCE_COMMUNITY,

    /**
     * Consortium.
     *
     * <p>The organization is a consortium or group of entities.
     */
    @JsonProperty("consortium")
    CONSORTIUM
}
