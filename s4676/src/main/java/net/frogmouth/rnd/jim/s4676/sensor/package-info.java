/**
 * Sensor related information.
 *
 * <p>The primary class is {@link SensorInformation}, which is mostly self-explanatory. There is an
 * extensible enumeration, which is modelled as {@link IModalityType}. The standard values for that
 * are provided in {@link ModalityType}.
 *
 * <p>The {@code SensorInformation} class contains high-level information for a sensor used to
 * collect data on which tracking is performed. If a system has multiple sensors that are used to
 * produce detections, each sensor's information must be recorded as a separate instance of this
 * class. Information specified through the SensorInformation class is static throughout the entire
 * collection. Attributes of the sensor or how it is being operated that change over the course of
 * the collection are specified using instances of the {@link
 * net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation.DynamicSourceInformation} class,
 * contained within the {@link net.frogmouth.rnd.jim.s4676.message.TrackMessage} class.
 */
package net.frogmouth.rnd.jim.s4676.sensor;
