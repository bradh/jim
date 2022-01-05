/**
 * Mission Segment.
 *
 * <p>The Mission Segment provides information concerning the mission and shall be sent periodically
 * at least once every two minutes. It includes information on the mission and flight plans, the
 * type and configuration of the platform, and the reference time.
 *
 * <p>The data model is provided by {@link MissionSegment}. Parsing and serialisation of that data
 * model into the AEDP-7 binary format is provided by {@link MissionSegmentParser} and {@link
 * MissionSegmentSerialiser}, however this is normally handled indirectly via {@link
 * net.frogmouth.rnd.jim.s4607.Reader} and {@link net.frogmouth.rnd.jim.s4607.Writer}. That is, the
 * Mission Segment Segment is handled as for any other Segment within the Packet structure.
 *
 * <p>One element within the Mission Segment (the Platform Type - field M3) is an enumerated value.
 * That is supported via the {@link PlatformTypeLookupTable} enumeration.
 */
package net.frogmouth.rnd.jim.s4607.MissionSegment;
