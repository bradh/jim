package net.frogmouth.rnd.jim.s4676.message.processedtrack;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for IMotionEventType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * IProcessedTrackType, which is ProcessedTrackType.
 */
public class ProcessedTrackTypeDeserialiser extends StdDeserializer<IProcessedTrackType> {

    /** Constructor. */
    public ProcessedTrackTypeDeserialiser() {
        super(IProcessedTrackType.class);
    }

    @Override
    public IProcessedTrackType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, ProcessedTrackType.class);
    }
}
