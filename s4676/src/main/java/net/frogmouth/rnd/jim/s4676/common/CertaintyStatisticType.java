package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Certainty statistic type.
 *
 * <p>Extends means to determine value of Confidence beyond percentage certainty to include P-Values
 * and T-Statistical tests.
 */
public enum CertaintyStatisticType implements ICertaintyStatisticType {
    /**
     * Human Instinct.
     *
     * <p>Indicates that the confidence value is estimated by one or more humans (rather than
     * through an algorithm).
     */
    HUMAN_INSTINCT,

    /**
     * P-Value.
     *
     * <p>Indicates that the confidence value is a p-value, used to evaluate significance of results
     * in hypothesis testing. The p-value should be interpreted as a percentage: 0% - 100%, in
     * integer increments.
     *
     * <p>A small p-value (typically ≤ 0.05) indicates strong evidence against the null hypothesis,
     * so you reject the null hypothesis.
     *
     * <p>A large p-value (> 0.05) indicates weak evidence against the null hypothesis, so you fail
     * to reject the null hypothesis.
     */
    @JsonProperty("P-VALUE")
    P_VALUE,

    /**
     * Probability.
     *
     * <p>Indicates that the confidence value is a probability, which is the likelihood that an
     * event will occur. Is quantified as a number between 0 and 100, where 0 is impossibility and
     * 100 indicates certainty.
     */
    PROBABILITY,

    /**
     * T-Statistic.
     *
     * <p>Indicates that the confidence value is a t-statistic (result of a statistical tool called
     * a T-Test), which is used to determine how significant the difference is between two values,
     * i.e. whether the difference could happen by chance. The t-statistic should be interpreted as
     * a percentage: 0% - 100%, in integer increments.
     */
    @JsonProperty("T-STATISTIC")
    T_STATISTIC
}
