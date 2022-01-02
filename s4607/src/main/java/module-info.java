module net.frogmouth.rnd.jim.brian {
    requires org.slf4j;

    exports net.frogmouth.rnd.jim.s4607.Segment;
    exports net.frogmouth.rnd.jim.s4607.DwellSegment;
    exports net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;
    exports net.frogmouth.rnd.jim.s4607.MissionSegment;

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
