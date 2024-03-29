package net.frogmouth.rnd.jim.s4676.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serialisation support for Double List values.
 *
 * <p>This serialises the List as a space-separated body text.
 */
public class DoubleListSerialiser extends StdSerializer<List<Double>> {
    /** Constructor. */
    public DoubleListSerialiser() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public DoubleListSerialiser(Class<List<Double>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Double> values, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        String valuesAsString =
                values.stream().map(String::valueOf).collect(Collectors.joining(" "));
        jgen.writeString(valuesAsString);
    }
}
