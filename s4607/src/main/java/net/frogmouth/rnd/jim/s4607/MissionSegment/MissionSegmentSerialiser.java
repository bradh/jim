package net.frogmouth.rnd.jim.s4607.MissionSegment;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

public class MissionSegmentSerialiser extends AbstractSegmentSerialiser {
    public MissionSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.MissionSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationContext) {
        MissionSegment missionSegment = (MissionSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(serialisationContext.padString(missionSegment.getMissionPlan(), 12));
        baos.writeBytes(serialisationContext.padString(missionSegment.getFlightPlan(), 12));
        baos.writeBytes(writeE8(missionSegment.getPlatformType()));
        baos.writeBytes(
                serialisationContext.padString(missionSegment.getPlatformConfiguration(), 10));
        baos.writeBytes(writeI16(missionSegment.getYear()));
        baos.writeBytes(writeI8(missionSegment.getMonth()));
        baos.writeBytes(writeI8(missionSegment.getDay()));
        return baos.toByteArray();
    }
}
