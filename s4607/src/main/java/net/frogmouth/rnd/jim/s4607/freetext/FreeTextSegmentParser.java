package net.frogmouth.rnd.jim.s4607.freetext;

import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link FreeTextSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class FreeTextSegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.FreeTextSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        FreeTextSegment freeTextSegment = new FreeTextSegment();
        freeTextSegment.setOriginatorId(context.readASCII(10));
        freeTextSegment.setRecipientId(context.readASCII(10));
        int remainingBytes = (int) (segmentHeader.getSegmentSize() - 25);
        freeTextSegment.setFreeText(context.readASCII(remainingBytes));
        return freeTextSegment;
    }
}
