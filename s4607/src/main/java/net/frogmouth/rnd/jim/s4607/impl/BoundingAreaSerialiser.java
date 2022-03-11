package net.frogmouth.rnd.jim.s4607.impl;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.BoundingArea;
import net.frogmouth.rnd.jim.s4607.Point;

/**
 * Serialisation support for {@link BoundingArea}.
 *
 * <p>This supports serialisation of segments that use {@code BoundingArea}.
 */
public class BoundingAreaSerialiser {

    private BoundingAreaSerialiser() {}

    /**
     * Serialise a bounding area to a byte array output stream.
     *
     * @param boundingArea the bounding area to serialise
     * @param baos the stream to write to
     */
    public static void writeBoundingArea(BoundingArea boundingArea, ByteArrayOutputStream baos) {
        writePoint(boundingArea.getPointA(), baos);
        writePoint(boundingArea.getPointB(), baos);
        writePoint(boundingArea.getPointC(), baos);
        writePoint(boundingArea.getPointD(), baos);
    }

    private static void writePoint(Point point, ByteArrayOutputStream baos) {
        baos.writeBytes(SerialisationUtils.writeSA32(point.getLatitude()));
        baos.writeBytes(SerialisationUtils.writeBA32(point.getLongitude()));
    }
}
