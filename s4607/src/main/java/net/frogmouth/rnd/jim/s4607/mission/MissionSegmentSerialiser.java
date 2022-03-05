package net.frogmouth.rnd.jim.s4607.mission;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Serialiser for {@link MissionSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class MissionSegmentSerialiser extends AbstractSegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.MissionSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        MissionSegment missionSegment = (MissionSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(padString(missionSegment.getMissionPlan(), 12));
        baos.writeBytes(padString(missionSegment.getFlightPlan(), 12));
        baos.writeBytes(writeE8(missionSegment.getPlatformType()));
        baos.writeBytes(padString(missionSegment.getPlatformConfiguration(), 10));
        baos.writeBytes(writeI16(missionSegment.getYear()));
        baos.writeBytes(writeI8(missionSegment.getMonth()));
        baos.writeBytes(writeI8(missionSegment.getDay()));
        return baos.toByteArray();
    }
}
