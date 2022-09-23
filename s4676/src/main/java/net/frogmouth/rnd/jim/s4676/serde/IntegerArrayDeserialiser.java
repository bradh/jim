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
import java.util.ArrayList;
import java.util.List;

/**
 * Deserialisation support for Integer array values.
 *
 * <p>Uses of this require the {code SupplementalDeserialisationInfo} annotation to identify the
 * wrapper element name.
 */
public class IntegerArrayDeserialiser extends StdDeserializer<Integer[]>
        implements ContextualDeserializer {

    /**
     * Element name.
     *
     * <p>The element to deserialise from.
     */
    private String elementName;

    private IntegerArrayDeserialiser() {
        this((String) null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public IntegerArrayDeserialiser(Class<Integer[]> t) {
        super(t);
    }

    /**
     * Constructor.
     *
     * @param elementName the element name to deserialise from.
     */
    private IntegerArrayDeserialiser(String elementName) {
        super(Integer[].class);
        this.elementName = elementName;
    }

    @Override
    public Integer[] deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        List<Integer> points = new ArrayList<>();
        TreeNode tree = jp.readValueAsTree();
        TreeNode pointsNode = tree.get(elementName);
        if ((pointsNode != null)
                && (pointsNode.isValueNode())
                && (pointsNode instanceof TextNode)) {
            String value = ((TextNode) pointsNode).textValue();
            String[] parts = value.split(" ");
            for (String part : parts) {
                points.add(Integer.valueOf(part));
            }
        }
        Integer[] arr = new Integer[points.size()];
        for (int i = 0; i < points.size(); i++) {
            arr[i] = points.get(i);
        }
        return arr;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext dc, BeanProperty bp)
            throws JsonMappingException {
        SupplementalDeserialisationInfo info =
                bp.getAnnotation(SupplementalDeserialisationInfo.class);
        if (info != null) {
            String elName = info.elementName();
            return new IntegerArrayDeserialiser(elName);
        }
        return this;
    }
}
