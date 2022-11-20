package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusType {
    /** Active – Fully Mission Capable. */
    @JsonProperty("afmc")
    AFMC,

    /** Active – Partially Mission Capable. */
    @JsonProperty("apmc")
    APMC,

    /** Active – Unknown Mission Capable. */
    @JsonProperty("aumc")
    AUMC,

    /**
     * Deorbited.
     *
     * <p>The satellite was intentionally reentered into the Earth's atmosphere and is subsequently
     * decaying or decayed.
     */
    @JsonProperty("deorbited")
    DEORBITED,

    /**
     * Destroyed.
     *
     * <p>The orbiting satellite was intentionally or unintentionally destroyed, which may have
     * created debris.
     */
    @JsonProperty("destroyed")
    DESTROYED,

    /**
     * Docked.
     *
     * <p>The space object is currently physically tethered or fastened to an independent space
     * object.
     */
    @JsonProperty("docked")
    DOCKED,

    /**
     * Engineering checkout.
     *
     * <p>The satellite is currently experiencing on-orbit systems testing, verification and
     * validation.
     */
    @JsonProperty("engineeringCheckout")
    ENGINEERING_CHECKOUT,

    /**
     * Failed.
     *
     * <p>The satellite payload failed to achieve its planned orbit due to a failed launch or
     * insertion.
     */
    @JsonProperty("failed")
    FAILED,

    /** Inactive – Fully Mission Capable. */
    @JsonProperty("ifmc")
    IFMC,

    /** Inactive – Partially Mission Capable. */
    @JsonProperty("ipmc")
    IPMC,

    /** Inactive – Unknown Mission Capable. */
    @JsonProperty("iumc")
    IUMC
}
