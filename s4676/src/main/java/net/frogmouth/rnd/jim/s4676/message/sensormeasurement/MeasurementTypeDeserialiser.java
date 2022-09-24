package net.frogmouth.rnd.jim.s4676.message.sensormeasurement;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for IMeasurementType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * IMeasurementType, which is MeasurementType.
 */
public class MeasurementTypeDeserialiser extends StdDeserializer<IMeasurementType> {

    /** Constructor. */
    public MeasurementTypeDeserialiser() {
        super(IMeasurementType.class);
    }

    @Override
    public IMeasurementType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, MeasurementType.class);
    }
}
