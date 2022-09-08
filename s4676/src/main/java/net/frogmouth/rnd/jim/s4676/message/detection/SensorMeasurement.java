package net.frogmouth.rnd.jim.s4676.message.detection;

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

    // TODO: constructor. quantity, method and value are required

    // TODO: getters and setters.
}
