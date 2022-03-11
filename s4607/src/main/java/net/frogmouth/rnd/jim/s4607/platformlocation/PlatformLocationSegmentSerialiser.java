package net.frogmouth.rnd.jim.s4607.platformlocation;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;
import net.frogmouth.rnd.jim.s4607.impl.SerialisationUtils;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Serialiser for {@link PlatformLocationSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class PlatformLocationSegmentSerialiser extends AbstractSegmentSerialiser
        implements ISegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.PlatformLocationSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        PlatformLocationSegment platformLocationSegment = (PlatformLocationSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(writeI32(platformLocationSegment.getLocationTime()));
        baos.writeBytes(
                SerialisationUtils.writeSA32(
                        platformLocationSegment.getPlatformPositionLatitude()));
        baos.writeBytes(
                SerialisationUtils.writeBA32(
                        platformLocationSegment.getPlatformPositionLongitude()));
        baos.writeBytes(
                SerialisationUtils.writeS32(platformLocationSegment.getPlatformPositionAltitude()));
        baos.writeBytes(writeBA16(platformLocationSegment.getPlatformTrack()));
        baos.writeBytes(writeI32(platformLocationSegment.getPlatformSpeed()));
        baos.writeBytes(writeS8(platformLocationSegment.getPlatformVerticalVelocity()));
        return baos.toByteArray();
    }
}
