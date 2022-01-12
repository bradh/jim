/**
 * Job Definition Segment.
 *
 * <p>The Job Definition Segment provides the means for the platform to pass information pertaining
 * to the sensor job that will be performed and details of the location parameters (terrain
 * elevation model and geoid model) used in the measurement. It includes a definition of the
 * geographic area for sensor service, the Bounding Area, which is defined as a four-corner polygon,
 * with the four points of the polygon chosen to define a convex quadrilateral. The Job Definition
 * Segment shall be sent before the first visit of a job with the bounding area representing the
 * tasked area, and shall be updated and resent with the bounding area set to represent the actual
 * scanned area when the scanned area differs from the area sent in the previous Job Definition
 * Segment. The Job Definition Segment shall be sent periodically at least once every 30 seconds
 * thereafter.
 *
 * <p>The data model is provided by {@link JobDefinitionSegment}. Parsing and serialisation of that
 * data model into the AEDP-7 binary format is provided by {@link JobDefinitionSegmentParser} and
 * {@link JobDefinitionSegmentSerialiser}, however this is normally handled indirectly via {@link
 * net.frogmouth.rnd.jim.s4607.Reader} and {@link net.frogmouth.rnd.jim.s4607.Writer}. That is, the
 * Job Definition Segment is handled as for any other Segment within the Packet structure.
 *
 * <p>The Sensor Type (field J2) within the Job Definition Segment is an enumerated value. That is
 * supported via the {@link SensorTypeLookupTable} enumeration.
 */
package net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;
