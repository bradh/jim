package net.frogmouth.rnd.jim.s4607.segment;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Singleton manager for Segment serialisation.
 *
 * <p>All Segment serialisers are registered with this manager, and can be looked up by segment
 * type.
 *
 * <p>This is normally only used by the serialisation code, and should not be necessary to directly
 * use this code.
 */
public class SegmentSerialiserManager {

    private final ServiceLoader<ISegmentSerialiser> loader;
    private final Map<SegmentType, ISegmentSerialiser> serialisers = new HashMap<>();

    private SegmentSerialiserManager() {
        loader = ServiceLoader.load(ISegmentSerialiser.class);
        for (ISegmentSerialiser factory : loader) {
            serialisers.put(factory.getSegmentType(), factory);
        }
    }

    /**
     * Get singleton instance.
     *
     * @return the singleton instance of this serialiser manager.
     */
    public static SegmentSerialiserManager getInstance() {
        return SegmentSerialiserManagerHolder.INSTANCE;
    }

    /**
     * Get a serialiser for the specified segment type.
     *
     * @param segmentType the segment type
     * @return the corresponding serialiser, or a fallback (no nothing) serialiser if no match.
     */
    public ISegmentSerialiser getSerialiser(SegmentType segmentType) {
        ISegmentSerialiser serialiser =
                serialisers.getOrDefault(segmentType, new FallbackSegmentSerialiser());
        return serialiser;
    }

    private static class SegmentSerialiserManagerHolder {

        private static final SegmentSerialiserManager INSTANCE = new SegmentSerialiserManager();
    }
}
