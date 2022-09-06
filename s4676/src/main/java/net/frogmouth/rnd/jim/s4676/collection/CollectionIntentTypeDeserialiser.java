package net.frogmouth.rnd.jim.s4676.collection;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for ICollectionEssenceType.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of
 * ICollectionIntentType, which is CollectionIntentType.
 */
public class CollectionIntentTypeDeserialiser extends StdDeserializer<ICollectionIntentType> {

    /** Constructor. */
    public CollectionIntentTypeDeserialiser() {
        super(ICollectionEssenceType.class);
    }

    @Override
    public ICollectionIntentType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, CollectionIntentType.class);
    }
}
