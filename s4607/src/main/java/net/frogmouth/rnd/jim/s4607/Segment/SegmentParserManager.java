package net.frogmouth.rnd.jim.s4607.Segment;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Singleton manager for Segment parsing.
 *
 * <p>All Segment parsers are registered with this manager, and can be looked up by segment type.
 *
 * <p>This is normally only used by the parsing code, and should not be necessary to directly use
 * this code.
 */
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
        SegmentParser segmentParser =
                parsers.getOrDefault(segmentType, new FallbackSegmentParser());
        return segmentParser;
    }

    private static class SegmentParserManagerHolder {

        private static final SegmentParserManager INSTANCE = new SegmentParserManager();
    }
}
