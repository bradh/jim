package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Dimensionality */
public enum Dimensionality {
    /**
     * Two dimensional.
     *
     * <p>The shape has two dimensions.
     */
    @JsonProperty("2")
    TWO_D,

    /**
     * Three dimensional.
     *
     * <p>The shape has three dimensions.
     */
    @JsonProperty("3")
    THREE_D
}
