package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Deserialisation support for Position Points value. */
public class PointsListDeserialiser extends StdDeserializer<List<Double>> {
    /** Constructor. */
    public PointsListDeserialiser() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public PointsListDeserialiser(Class<List<Double>> t) {
        super(t);
    }

    @Override
    public List<Double> deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JacksonException {
        List<Double> points = new ArrayList<>();
        TreeNode tree = jp.readValueAsTree();
        TreeNode pointsNode = tree.get("points");
        if ((pointsNode != null)
                && (pointsNode.isValueNode())
                && (pointsNode instanceof TextNode)) {
            String value = ((TextNode) pointsNode).textValue();
            String[] parts = value.split(" ");
            for (String part : parts) {
                points.add(Double.valueOf(part));
            }
        }
        return points;
    }
}
