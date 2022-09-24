package net.frogmouth.rnd.jim.s4676.message.sensormeasurement;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for IMeasurementMethod.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * IMeasurementMethod, which is MeasurementMethod.
 */
public class MeasurementMethodDeserialiser extends StdDeserializer<IMeasurementMethod> {

    /** Constructor. */
    public MeasurementMethodDeserialiser() {
        super(IMeasurementMethod.class);
    }

    @Override
    public IMeasurementMethod deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, MeasurementMethod.class);
    }
}
