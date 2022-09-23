package net.frogmouth.rnd.jim.s4676.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.stream.Collectors;
import net.frogmouth.rnd.jim.s4676.message.detection.PixelPolygon;

/** Serialisation support for Pixel Polygon values. */
public class PixelPolygonSerialiser extends StdSerializer<PixelPolygon> {
    /** Constructor. */
    public PixelPolygonSerialiser() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type
     */
    public PixelPolygonSerialiser(Class<PixelPolygon> t) {
        super(t);
    }

    @Override
    public void serialize(PixelPolygon polygon, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        jgen.writeFieldName("numRings");
        jgen.writeNumber(polygon.getNumRings());
        String valuesAsString =
                polygon.getIntegerArray().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
        jgen.writeString(valuesAsString);
    }
}
