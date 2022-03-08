package net.frogmouth.rnd.jim.s4607.platformlocation;

import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link PlatformLocationSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class PlatformLocationSegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.PlatformLocationSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        PlatformLocationSegment segment = new PlatformLocationSegment();
        segment.setLocationTime(context.readI32());
        segment.setPlatformPositionLatitude(context.readSA32());
        segment.setPlatformPositionLongitude(context.readBA32());
        segment.setPlatformPositionAltitude(context.readS32());
        segment.setPlatformTrack(context.readBA16());
        segment.setPlatformSpeed(context.readI32());
        segment.setPlatformVerticalVelocity(context.readS8());
        return segment;
    }
}
