package net.frogmouth.rnd.jim.s4676.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Serialisation support for Integer array values.
 *
 * <p>This serialises the array as a space-separated body text.
 */
public class IntegerArraySerialiser extends StdSerializer<Integer[]> {
    /** Constructor. */
    public IntegerArraySerialiser() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public IntegerArraySerialiser(Class<Integer[]> t) {
        super(t);
    }

    @Override
    public void serialize(Integer[] values, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        String valuesAsString =
                Arrays.stream(values).map(String::valueOf).collect(Collectors.joining(" "));
        jgen.writeString(valuesAsString);
    }
}
