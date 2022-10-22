package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;

/**
 * Deserialiser for Shape.
 *
 * <p>Works for Ellipsoid and Polygon.
 */
public class ShapeDeserialiser extends StdDeserializer<Shape> {

    /** Constructor. */
    public ShapeDeserialiser() {
        super(ICoordinateSystemType.class);
    }

    @Override
    public Shape deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        JsonNode node = jp.readValueAsTree();
        String xsiType = node.get("type").asText();
        switch (xsiType) {
            case "Ellipsoid" -> {
                Ellipsoid value =
                        jp.getCodec()
                                .readValue(
                                        new TreeTraversingParser(node, jp.getCodec()),
                                        Ellipsoid.class);
                return value;
            }
            case "Polygon" -> {
                Polygon value =
                        jp.getCodec()
                                .readValue(
                                        new TreeTraversingParser(node, jp.getCodec()),
                                        Polygon.class);
                return value;
            }
            default -> {
                return null;
            }
        }
    }
}
