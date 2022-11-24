package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/** DateWithOptionalUTCTime serialiser. */
public class DateWithOptionalUTCTimeSerializer extends StdSerializer<DateWithOptionalUTCTime> {

    /** Constructor. */
    public DateWithOptionalUTCTimeSerializer() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param t type to serialise
     */
    public DateWithOptionalUTCTimeSerializer(Class<DateWithOptionalUTCTime> t) {
        super(t);
    }

    @Override
    public void serialize(
            DateWithOptionalUTCTime value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeString(value.toString());
    }
}
