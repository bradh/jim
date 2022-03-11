package net.frogmouth.rnd.jim.s4607.impl;

import net.frogmouth.rnd.jim.s4607.BoundingArea;
import net.frogmouth.rnd.jim.s4607.IParseContext;
import net.frogmouth.rnd.jim.s4607.Point;

/**
 * Parser for {@link BoundingArea}.
 *
 * <p>This is not usually required from user code. It exists to support parsing of segments that use
 * bounding areas.
 */
public class BoundingAreaParser {

    private BoundingAreaParser() {}

    /**
     * Parse a bounding area from a given context.
     *
     * @param context the context to parse from
     * @return the corresponding bounding area.
     */
    public static BoundingArea parseBoundingArea(IParseContext context) {
        BoundingArea boundingArea = new BoundingArea();
        boundingArea.setPointA(readPoint(context));
        boundingArea.setPointB(readPoint(context));
        boundingArea.setPointC(readPoint(context));
        boundingArea.setPointD(readPoint(context));
        return boundingArea;
    }

    private static Point readPoint(IParseContext context) {
        Point point = new Point();
        point.setLatitude(context.readSA32());
        point.setLongitude(context.readBA32());
        return point;
    }
}
