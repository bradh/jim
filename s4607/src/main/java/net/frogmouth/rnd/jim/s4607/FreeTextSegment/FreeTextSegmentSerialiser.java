package net.frogmouth.rnd.jim.s4607.FreeTextSegment;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

public class FreeTextSegmentSerialiser extends AbstractSegmentSerialiser {
    public FreeTextSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.FreeTextSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        FreeTextSegment freeTextSegment = (FreeTextSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(serialisationContext.padString(freeTextSegment.getOriginatorId(), 10));
        baos.writeBytes(serialisationContext.padString(freeTextSegment.getRecipientId(), 10));
        baos.writeBytes(freeTextSegment.getFreeText().trim().getBytes(StandardCharsets.US_ASCII));
        return baos.toByteArray();
    }
}
