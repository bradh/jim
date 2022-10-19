package net.frogmouth.rnd.jim.s4676.serde;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.s4676.message.detection.PixelPolygon;

/** Deserialisation support for Pixel Polygon values. */
public class PixelPolygonDeserialiser extends StdDeserializer<PixelPolygon>
        implements ContextualDeserializer {
    private String elementName;

    /** Constructor. */
    public PixelPolygonDeserialiser() {
        this((String) null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public PixelPolygonDeserialiser(Class<PixelPolygon> t) {
        super(t);
    }

    /**
     * Constructor.
     *
     * @param elementName the element name to deserialise from.
     */
    private PixelPolygonDeserialiser(String elementName) {
        super(List.class);
        this.elementName = elementName;
    }

    @Override
    public PixelPolygon deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        PixelPolygon polygon = new PixelPolygon();
        TreeNode tree = jp.readValueAsTree();
        TreeNode pointsNode;
        if ((tree != null) && (tree instanceof TextNode)) {
            pointsNode = tree;
        } else {
            pointsNode = tree.get("");
        }
        if ((pointsNode != null)
                && (pointsNode.isValueNode())
                && (pointsNode instanceof TextNode)) {
            String value = ((TextNode) pointsNode).textValue();
            String[] parts = value.split(" ");
            for (String part : parts) {
                polygon.addCoordinateValue(Integer.valueOf(part));
            }
        }
        TreeNode numRingsNode = tree.get("nRings");
        if ((numRingsNode != null)
                && (numRingsNode.isValueNode())
                && (numRingsNode instanceof TextNode)) {
            String numRingsAsText = ((TextNode) numRingsNode).textValue();
            polygon.setNumRings(Integer.valueOf(numRingsAsText));
        }
        return polygon;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext dc, BeanProperty bp)
            throws JsonMappingException {
        SupplementalDeserialisationInfo info =
                bp.getAnnotation(SupplementalDeserialisationInfo.class);
        if (info != null) {
            String elName = info.elementName();
            return new PixelPolygonDeserialiser(elName);
        }
        return this;
    }
}
