package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrganisationRole {
    /**
     * Financier.
     *
     * <p>The organization invested with at least a minority interest in the space object.
     */
    @JsonProperty("financier")
    FINANCIER,

    /**
     * Manufacturer.
     *
     * <p>The organization is a manufacturer of at least a portion of the space object.
     */
    @JsonProperty("manufacturer")
    MANUFACTURER,

    /**
     * Owner.
     *
     * <p>The organization is at least a part owner of the space object.
     */
    @JsonProperty("owner")
    OWNER,

    /**
     * Operator.
     *
     * <p>The organization is an operator of the space object.
     */
    @JsonProperty("operator")
    OPERATOR
}
