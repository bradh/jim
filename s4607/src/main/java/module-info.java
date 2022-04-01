/**
 * STANAG 4607 Binary Radar Information Analyser and Navigator (BRIAN).
 *
 * <p>This module provide parsing and serialisation for AEDP-07 / AEDP-4607 formatted files.
 *
 * <p>It primarily aims at version 4, although there is some backwards compatibility.
 */
@SuppressWarnings("module") // That is not a version number - its a document number.
module net.frogmouth.rnd.jim.s4607 {
    requires org.slf4j;

    exports net.frogmouth.rnd.jim.s4607;
    exports net.frogmouth.rnd.jim.s4607.dwell;
    exports net.frogmouth.rnd.jim.s4607.freetext;
    exports net.frogmouth.rnd.jim.s4607.hrr;
    exports net.frogmouth.rnd.jim.s4607.jobacknowledge;
    exports net.frogmouth.rnd.jim.s4607.jobdefinition;
    exports net.frogmouth.rnd.jim.s4607.jobrequest;
    exports net.frogmouth.rnd.jim.s4607.mission;
    exports net.frogmouth.rnd.jim.s4607.packet;
    exports net.frogmouth.rnd.jim.s4607.platformlocation;
    exports net.frogmouth.rnd.jim.s4607.processinghistory;
    exports net.frogmouth.rnd.jim.s4607.segment;
    exports net.frogmouth.rnd.jim.s4607.testandstatus;

    uses net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;

    provides net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser with
            net.frogmouth.rnd.jim.s4607.dwell.DwellSegmentParser,
            net.frogmouth.rnd.jim.s4607.freetext.FreeTextSegmentParser,
            net.frogmouth.rnd.jim.s4607.jobacknowledge.JobAcknowledgeSegmentParser,
            net.frogmouth.rnd.jim.s4607.jobdefinition.JobDefinitionSegmentParser,
            net.frogmouth.rnd.jim.s4607.jobrequest.JobRequestSegmentParser,
            net.frogmouth.rnd.jim.s4607.mission.MissionSegmentParser,
            net.frogmouth.rnd.jim.s4607.platformlocation.PlatformLocationSegmentParser,
            net.frogmouth.rnd.jim.s4607.processinghistory.ProcessingHistorySegmentParser,
            net.frogmouth.rnd.jim.s4607.testandstatus.TestAndStatusSegmentParser;

    uses net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;

    provides net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser with
            net.frogmouth.rnd.jim.s4607.dwell.DwellSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.freetext.FreeTextSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.jobacknowledge.JobAcknowledgeSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.jobdefinition.JobDefinitionSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.jobrequest.JobRequestSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.mission.MissionSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.platformlocation.PlatformLocationSegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.processinghistory.ProcessingHistorySegmentSerialiser,
            net.frogmouth.rnd.jim.s4607.testandstatus.TestAndStatusSegmentSerialiser;
}
