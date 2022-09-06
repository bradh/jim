package net.frogmouth.rnd.jim.s4676.tracker;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for ISupplementaryDataType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of IModalityType,
 * which is ModalityType.
 */
public class SupplementaryDataTypeDeserialiser extends StdDeserializer<ISupplementaryDataType> {

    /** Constructor. */
    public SupplementaryDataTypeDeserialiser() {
        super(ISupplementaryDataType.class);
    }

    @Override
    public ISupplementaryDataType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, SupplementaryDataType.class);
    }
}
