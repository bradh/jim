package net.frogmouth.rnd.jim.s4676.message.tracklinkage;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for ITrackLinkageType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * ITrackLinkageType, which is TrackLinkageType.
 */
public class TrackLinkageTypeDeserialiser extends StdDeserializer<ITrackLinkageType> {

    /** Constructor. */
    public TrackLinkageTypeDeserialiser() {
        super(ITrackLinkageType.class);
    }

    @Override
    public ITrackLinkageType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, TrackLinkageType.class);
    }
}
