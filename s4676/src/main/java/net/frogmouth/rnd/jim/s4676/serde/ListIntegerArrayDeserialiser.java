package net.frogmouth.rnd.jim.s4676.serde;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Deserialisation support for List of Integer array values.
 *
 * <p>Uses of this require the {code SupplementalDeserialisationInfo} annotation to identify the
 * wrapper element name.
 */
public class ListIntegerArrayDeserialiser extends StdDeserializer<List<Integer[]>>
        implements ContextualDeserializer {
    private String elementName;

    /** Constructor. */
    public ListIntegerArrayDeserialiser() {
        this((String) null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public ListIntegerArrayDeserialiser(Class<List<Double>> t) {
        super(t);
    }

    /**
     * Constructor.
     *
     * @param elementName the element name to deserialise from.
     */
    private ListIntegerArrayDeserialiser(String elementName) {
        super(List.class);
        this.elementName = elementName;
    }

    @Override
    public List<Integer[]> deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        List<Integer[]> points = new ArrayList<>();
        TreeNode tree = jp.readValueAsTree();
        TreeNode pointsNode = tree.get(elementName);
        if (pointsNode instanceof ArrayNode arrayNode) {
            for (JsonNode el : arrayNode) {
                if (el instanceof TextNode textNode) {
                    points.add(parseTextNode(textNode));
                }
            }
        }
        if (pointsNode instanceof TextNode textNode) {
            points.add(parseTextNode(textNode));
        }
        return points;
    }

    private Integer[] parseTextNode(TextNode textNode) throws NumberFormatException {
        String value = textNode.textValue();
        String[] parts = value.split(" ");
        Integer[] integerArray = new Integer[parts.length];
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = Integer.valueOf(parts[i]);
        }
        return integerArray;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext dc, BeanProperty bp)
            throws JsonMappingException {
        SupplementalDeserialisationInfo info =
                bp.getAnnotation(SupplementalDeserialisationInfo.class);
        if (info != null) {
            String elName = info.elementName();
            return new ListIntegerArrayDeserialiser(elName);
        }
        return this;
    }
}
