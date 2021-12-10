package net.frogmouth.rnd.jim.s4607.Segment;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class SegmentSerialiserManager {

    private final ServiceLoader<AbstractSegmentSerialiser> loader;
    protected final Map<SegmentType, AbstractSegmentSerialiser> parsers = new HashMap<>();

    private SegmentSerialiserManager() {
        loader = ServiceLoader.load(AbstractSegmentSerialiser.class);
        for (AbstractSegmentSerialiser factory : loader) {
            parsers.put(factory.getSegmentType(), factory);
        }
    }

    public static SegmentSerialiserManager getInstance() {
        return SegmentSerialiserManagerHolder.INSTANCE;
    }

    public AbstractSegmentSerialiser getParser(SegmentType segmentType) {
        AbstractSegmentSerialiser serialiser =
                parsers.getOrDefault(segmentType, new FallbackSegmentSerialiser());
        return serialiser;
    }

    private static class SegmentSerialiserManagerHolder {

        private static final SegmentSerialiserManager INSTANCE = new SegmentSerialiserManager();
    }
}
