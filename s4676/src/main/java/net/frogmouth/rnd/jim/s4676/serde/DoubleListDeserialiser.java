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
 * Deserialisation support for List of Double values.
 *
 * <p>Uses of this require the {code SupplementalDeserialisationInfo} annotation to identify the
 * wrapper element name.
 */
public class DoubleListDeserialiser extends StdDeserializer<List<Double>>
        implements ContextualDeserializer {
    private String elementName;

    /** Constructor. */
    public DoubleListDeserialiser() {
        this((String) null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public DoubleListDeserialiser(Class<List<Double>> t) {
        super(t);
    }

    /**
     * Constructor.
     *
     * @param elementName the element name to deserialise from.
     */
    private DoubleListDeserialiser(String elementName) {
        super(List.class);
        this.elementName = elementName;
    }

    @Override
    public List<Double> deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        List<Double> points = new ArrayList<>();
        TreeNode tree = jp.readValueAsTree();
        if (elementName != null) {
            tree = tree.get(elementName);
        }
        if ((tree != null) && (tree.isValueNode()) && (tree instanceof TextNode)) {
            String value = ((TextNode) tree).textValue();
            String[] parts = value.split(" ");
            for (String part : parts) {
                points.add(Double.valueOf(part));
            }
        }
        return points;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext dc, BeanProperty bp)
            throws JsonMappingException {
        SupplementalDeserialisationInfo info =
                bp.getAnnotation(SupplementalDeserialisationInfo.class);
        if (info != null) {
            String elName = info.elementName();
            return new DoubleListDeserialiser(elName);
        }
        return this;
    }
}
