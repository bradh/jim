package net.frogmouth.rnd.jim.s4676.message.detection;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * Deserialiser for IImageFormat.
 *
 * <p>This just defers to the internal deserialiser for the common implementation of IImageFormat,
 * which is ImageFormat.
 */
public class ImageFormatDeserialiser extends StdDeserializer<IImageFormat> {

    /** Constructor. */
    public ImageFormatDeserialiser() {
        super(IImageFormat.class);
    }

    @Override
    public IImageFormat deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        return jp.getCodec().readValue(jp, ImageFormat.class);
    }
}
