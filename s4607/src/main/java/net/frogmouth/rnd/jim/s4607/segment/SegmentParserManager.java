package net.frogmouth.rnd.jim.s4607.segment;

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
    private final Map<SegmentType, SegmentParser> parsers = new HashMap<>();

    private SegmentParserManager() {
        loader = ServiceLoader.load(SegmentParser.class);
        for (SegmentParser factory : loader) {
            parsers.put(factory.getSegmentType(), factory);
        }
    }

    /**
     * Get singleton instance.
     *
     * @return the singleton instance of this parser manager.
     */
    public static SegmentParserManager getInstance() {
        return SegmentParserManagerHolder.INSTANCE;
    }

    /**
     * Get a parser for the specified segment type.
     *
     * @param segmentType the segment type
     * @return the corresponding parser, or a fallback parser if no match.
     */
    public SegmentParser getParser(SegmentType segmentType) {
        SegmentParser segmentParser =
                parsers.getOrDefault(segmentType, new FallbackSegmentParser());
        return segmentParser;
    }

    private static class SegmentParserManagerHolder {

        private static final SegmentParserManager INSTANCE = new SegmentParserManager();
    }
}
