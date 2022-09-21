package net.frogmouth.rnd.jim.s4676.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serialisation support for List of Integer array values.
 *
 * <p>This serialises each array in the List as a space-separated body text.
 */
public class ListIntegerArraySerialiser extends StdSerializer<List<Integer[]>> {
    /** Constructor. */
    public ListIntegerArraySerialiser() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public ListIntegerArraySerialiser(Class<List<Integer[]>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Integer[]> values, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        jgen.writeStartArray();
        for (Integer[] item : values) {
            String itemAsString =
                    Arrays.stream(item).map(String::valueOf).collect(Collectors.joining(" "));
            jgen.writeString(itemAsString);
        }
        jgen.writeEndArray();
    }
}
