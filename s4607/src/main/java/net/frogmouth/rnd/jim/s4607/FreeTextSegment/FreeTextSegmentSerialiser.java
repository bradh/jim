package net.frogmouth.rnd.jim.s4607.FreeTextSegment;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/**
 * Serialiser for {@link FreeTextSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class FreeTextSegmentSerialiser extends AbstractSegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.FreeTextSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        FreeTextSegment freeTextSegment = (FreeTextSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(padString(freeTextSegment.getOriginatorId(), 10));
        baos.writeBytes(padString(freeTextSegment.getRecipientId(), 10));
        baos.writeBytes(freeTextSegment.getFreeText().trim().getBytes(StandardCharsets.US_ASCII));
        return baos.toByteArray();
    }
}
