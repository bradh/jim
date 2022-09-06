package net.frogmouth.rnd.jim.s4676.tracker;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for ITrackerType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of ITrackerType,
 * which is TrackerType.
 */
public class TrackerTypeDeserialiser extends StdDeserializer<ITrackerType> {

    /** Constructor. */
    public TrackerTypeDeserialiser() {
        super(ITrackerType.class);
    }

    @Override
    public ITrackerType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, TrackerType.class);
    }
}
