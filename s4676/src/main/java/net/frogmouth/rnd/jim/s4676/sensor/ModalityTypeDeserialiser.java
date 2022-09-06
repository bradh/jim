package net.frogmouth.rnd.jim.s4676.sensor;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for IModalityType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of IModalityType,
 * which is ModalityType.
 */
public class ModalityTypeDeserialiser extends StdDeserializer<IModalityType> {

    /** Constructor. */
    public ModalityTypeDeserialiser() {
        super(IModalityType.class);
    }

    @Override
    public IModalityType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, ModalityType.class);
    }
}
