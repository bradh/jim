package net.frogmouth.rnd.jim.s4676.message.sensormeasurement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Sensor Measurement.
 *
 * <p>The SensorMeasurement class provides a single measurement, accompanied by its units, method,
 * and uncertainty. This class is intended to accommodate various measurements from the sensor; for
 * example, specifying the radiance of a detection would fall within this definition, whereas
 * calculating the length of an object would not.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"value", "uncertainty"})
public class SensorMeasurement {
    @JacksonXmlProperty(isAttribute = true)
    private IMeasurementType quantity;

    @JacksonXmlProperty(isAttribute = true)
    private IMeasurementMethod method;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private double value;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private Double uncertainty;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes quantity, method and value
     * instead.
     */
    private SensorMeasurement() {}

    /**
     * Constructor.
     *
     * <p>A sensor measurement requires a quantity, method and value.
     *
     * <p>Quantity is the specific quantity being reported. This sets the units of the reported
     * value. Unless extended, this will be one of the enumerated values in {@link MeasurementType}.
     *
     * <p>Method is the method by which the reported value was calculated. For example, common
     * choices include “MEAN” or “MAX". Unless extended, this will be one of the enumerated values
     * in {@link MeasurementMethod}.
     *
     * <p>Value is the reported measurement value.
     *
     * @param quantity the quantity
     * @param method the measurement method
     * @param value the value of the measurement
     */
    public SensorMeasurement(IMeasurementType quantity, IMeasurementMethod method, double value) {
        this.quantity = quantity;
        this.method = method;
        this.value = value;
    }

    /**
     * Quantity.
     *
     * <p>The specific quantity being reported. This sets the units of the reported value. Unless
     * extended, this will be one of the enumerated values in {@link MeasurementType}.
     *
     * @return the quantity.
     */
    public IMeasurementType getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity.
     *
     * <p>The specific quantity being reported. This sets the units of the reported value. Unless
     * extended, this will be one of the enumerated values in {@link MeasurementType}.
     *
     * @param quantity the quantity.
     */
    public void setQuantity(IMeasurementType quantity) {
        this.quantity = quantity;
    }

    /**
     * Method.
     *
     * <p>The method by which the reported value was calculated. For example, common choices include
     * “MEAN” or “MAX". Unless extended, this will be one of the enumerated values in {@link
     * MeasurementMethod}.
     *
     * @return the measurement method.
     */
    public IMeasurementMethod getMethod() {
        return method;
    }

    /**
     * Set the method.
     *
     * <p>The method by which the reported value was calculated. For example, common choices include
     * “MEAN” or “MAX". Unless extended, this will be one of the enumerated values in {@link
     * MeasurementMethod}.
     *
     * @param method the measurement method.
     */
    public void setMethod(IMeasurementMethod method) {
        this.method = method;
    }

    /**
     * Value.
     *
     * <p>The data producer’s reported value of the sensor measurement of interest.
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Value.
     *
     * <p>The data producer’s reported value of the sensor measurement of interest.
     *
     * @param value the value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Uncertainty.
     *
     * <p>The data producer’s 1-sigma uncertainty in the reported sensor measurement value.
     *
     * @return the uncertainty
     */
    public Double getUncertainty() {
        return uncertainty;
    }

    /**
     * Set the uncertainty.
     *
     * <p>The data producer’s 1-sigma uncertainty in the reported sensor measurement value.
     *
     * @param uncertainty the uncertainty
     */
    public void setUncertainty(Double uncertainty) {
        this.uncertainty = uncertainty;
    }
}
