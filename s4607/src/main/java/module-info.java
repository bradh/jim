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
    exports net.frogmouth.rnd.jim.s4607.dwellsegment;
    exports net.frogmouth.rnd.jim.s4607.freetext;
    exports net.frogmouth.rnd.jim.s4607.jobdefinition;
    exports net.frogmouth.rnd.jim.s4607.mission;
    exports net.frogmouth.rnd.jim.s4607.packet;
    exports net.frogmouth.rnd.jim.s4607.segment;

    uses net.frogmouth.rnd.jim.s4607.segment.SegmentParser;

    provides net.frogmouth.rnd.jim.s4607.segment.SegmentParser with
            net.frogmouth.rnd.jim.s4607.dwellsegment.DwellSegmentParser,
            net.frogmouth.rnd.jim.s4607.freetext.FreeTextSegmentParser,
            net.frogmouth.rnd.jim.s4607.jobdefinition.JobDefinitionSegmentParser,
            net.frogmouth.rnd.jim.s4607.mission.MissionSegmentParser;

    uses net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;

    provides net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser with
            net.frogmouth.rnd.jim.s4607.dwellsegment.DwellSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.freetext.FreeTextSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.jobdefinition.JobDefinitionSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.mission.MissionSegmentSerialiser;
}
