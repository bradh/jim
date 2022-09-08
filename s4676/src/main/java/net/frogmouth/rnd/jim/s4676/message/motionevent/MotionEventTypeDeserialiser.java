package net.frogmouth.rnd.jim.s4676.message.motionevent;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for IMotionEventType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * IMotionEventType, which is MotionEventType.
 */
public class MotionEventTypeDeserialiser extends StdDeserializer<IMotionEventType> {

    /** Constructor. */
    public MotionEventTypeDeserialiser() {
        super(IMotionEventType.class);
    }

    @Override
    public IMotionEventType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, MotionEventType.class);
    }
}
