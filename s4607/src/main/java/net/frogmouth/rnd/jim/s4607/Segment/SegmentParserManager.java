package net.frogmouth.rnd.jim.s4607.Segment;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class SegmentParserManager {

    private final ServiceLoader<SegmentParser> loader;
    protected final Map<SegmentType, SegmentParser> parsers = new HashMap<>();

    private SegmentParserManager() {
        loader = ServiceLoader.load(SegmentParser.class);
        for (SegmentParser factory : loader) {
            parsers.put(factory.getSegmentType(), factory);
        }
    }

    public static SegmentParserManager getInstance() {
        return SegmentParserManagerHolder.INSTANCE;
    }

    public SegmentParser getParser(SegmentType segmentType) {
        // TODO: default parser
        SegmentParser segmentParser = parsers.getOrDefault(segmentType, null);
        return segmentParser;
    }

    private static class SegmentParserManagerHolder {

        private static final SegmentParserManager INSTANCE = new SegmentParserManager();
    }
}
