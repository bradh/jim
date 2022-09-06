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
 * ICollectionEssenceType, which is CollectionEssenceType.
 */
public class CollectionEssenceTypeDeserialiser extends StdDeserializer<ICollectionEssenceType> {

    /** Constructor. */
    public CollectionEssenceTypeDeserialiser() {
        super(ICollectionEssenceType.class);
    }

    @Override
    public ICollectionEssenceType deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, CollectionEssenceType.class);
    }
}
