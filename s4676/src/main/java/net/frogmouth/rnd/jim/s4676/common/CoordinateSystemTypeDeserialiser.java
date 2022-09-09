package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for ICoordinateSystemType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * ICoordinateSystemType, which is CoordinateSystemType.
 */
public class CoordinateSystemTypeDeserialiser extends StdDeserializer<ICoordinateSystemType> {

    /** Constructor. */
    public CoordinateSystemTypeDeserialiser() {
        super(ICoordinateSystemType.class);
    }

    @Override
    public ICoordinateSystemType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, CoordinateSystemType.class);
    }
}
