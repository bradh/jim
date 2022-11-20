package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SatelliteCategory {
    /** Amateur radio. */
    @JsonProperty("amateurRadio")
    AMATEUR_RADIO,

    /** Calibrations. */
    @JsonProperty("calibrations")
    CALIBRATIONS,

    /** Communications. */
    @JsonProperty("communications")
    COMMUNICATIONS,

    /** Electronic Reconnaissance. */
    @JsonProperty("electronicReconnaissance")
    ELECTRONIC_RECONNAISSANCE,

    /** Environmental. */
    @JsonProperty("environmental")
    ENVIRONMENTAL,

    /** Geodetic. */
    @JsonProperty("geodetic")
    GEODETIC,

    /** Imagery Reconnaissance. */
    @JsonProperty("imageryReconnaissance")
    IMAGERY_RECONNAISSANCE,

    /** Inter-Planetary mission. */
    @JsonProperty("interPlanetaryMission")
    INTER_PLANETARY_MISSION,

    /** Launch. */
    @JsonProperty("launch")
    LAUNCH,

    /** Manned. */
    @JsonProperty("manned")
    MANNED,

    /** Meteorology. */
    @JsonProperty("meteorology")
    METEOROLOGY,

    /** Miscellaneous or undefined. */
    @JsonProperty("miscUndefined")
    MISCELLANEOUS_OR_UNDEFINED,

    /** Navigation. */
    @JsonProperty("navigation")
    NAVIGATION,

    /** Radar Reconnaissance. */
    @JsonProperty("radarReconnaissance")
    RADAR_RECONNAISSANCE,

    /** Resupply. */
    @JsonProperty("resupply")
    RESUPPLY,

    /** Scientific. */
    @JsonProperty("scientific")
    SCIENTIFIC,

    /** Search and Rescue. */
    @JsonProperty("searchRescue")
    SEARCH_AND_RESCUE,

    /** Signals Intelligence. */
    @JsonProperty("sigInt")
    SIGNALS_INTELLIGENCE,

    /** Test or Engineering. */
    @JsonProperty("testEngineering")
    TEST_OR_ENGINEERING,

    /** Tracking or Data Relay. */
    @JsonProperty("trackingDataRelay")
    TRACKING_OR_DATA_RELAY
}
