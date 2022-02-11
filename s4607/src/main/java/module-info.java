/**
 * STANAG 4607 Binary Radar Information Analyser and Navigator (BRIAN).
 *
 * <p>This module provide parsing and serialisation for AEDP-07 / AEDP-4607 formatted files.
 *
 * <p>It primarily aims at version 4, although there is some backwards compatibility.
 */
module net.frogmouth.rnd.jim.brian {
    requires org.slf4j;

    exports net.frogmouth.rnd.jim.s4607;
    exports net.frogmouth.rnd.jim.s4607.DwellSegment;
    exports net.frogmouth.rnd.jim.s4607.FreeTextSegment;
    exports net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;
    exports net.frogmouth.rnd.jim.s4607.MissionSegment;
    exports net.frogmouth.rnd.jim.s4607.Packet;
    exports net.frogmouth.rnd.jim.s4607.Segment;

    uses net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;

    provides net.frogmouth.rnd.jim.s4607.Segment.SegmentParser with
            net.frogmouth.rnd.jim.s4607.DwellSegment.DwellSegmentParser,
            net.frogmouth.rnd.jim.s4607.FreeTextSegment.FreeTextSegmentParser,
            net.frogmouth.rnd.jim.s4607.JobDefinitionSegment.JobDefinitionSegmentParser,
            net.frogmouth.rnd.jim.s4607.MissionSegment.MissionSegmentParser;

    uses net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;

    provides net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser with
            net.frogmouth.rnd.jim.s4607.DwellSegment.DwellSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.FreeTextSegment.FreeTextSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.JobDefinitionSegment.JobDefinitionSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.MissionSegment.MissionSegmentSerialiser;
}
