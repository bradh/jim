package net.frogmouth.rnd.jim.s4607.testandstatus;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Serialiser for {@link TestAndStatusSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class TestAndStatusSegmentSerialiser extends AbstractSegmentSerialiser
        implements ISegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.TestAndStatusSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        TestAndStatusSegment testAndStatusSegment = (TestAndStatusSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(writeI32(testAndStatusSegment.getJobId()));
        baos.writeBytes(writeI16(testAndStatusSegment.getRevisitIndex()));
        baos.writeBytes(writeI16(testAndStatusSegment.getDwellIndex()));
        baos.writeBytes(writeI32(testAndStatusSegment.getDwellTime()));
        baos.write(testAndStatusSegment.getHardwareStatus().toByte());
        baos.write(testAndStatusSegment.getModeStatus().toByte());
        return baos.toByteArray();
    }
}
