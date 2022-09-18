package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Serialisation support for Double array values.
 *
 * <p>This serialises the array as a space-separated body text.
 */
public class DoubleArraySerialiser extends StdSerializer<Double[]> {
    /** Constructor. */
    public DoubleArraySerialiser() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public DoubleArraySerialiser(Class<Double[]> t) {
        super(t);
    }

    @Override
    public void serialize(Double[] values, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        String valuesAsString =
                Arrays.stream(values).map(String::valueOf).collect(Collectors.joining(" "));
        jgen.writeString(valuesAsString);
    }
}
