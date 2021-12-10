package net.frogmouth.rnd.jim.s4607.MissionSegment;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class MissionSegmentSerialiser extends AbstractSegmentSerialiser {
    public MissionSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.MissionSegment;
    }

    @Override
    public byte[] serialise(Segment segment) {
        MissionSegment missionSegment = (MissionSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(missionSegment.getMissionPlan().getBytes(StandardCharsets.US_ASCII));
        baos.writeBytes(missionSegment.getFlightPlan().getBytes(StandardCharsets.US_ASCII));
        baos.writeBytes(writeE8(missionSegment.getPlatformType()));
        baos.writeBytes(
                missionSegment.getPlatformConfiguration().getBytes(StandardCharsets.US_ASCII));
        baos.writeBytes(writeI16(missionSegment.getYear()));
        baos.writeBytes(writeI8(missionSegment.getMonth()));
        baos.writeBytes(writeI8(missionSegment.getDay()));
        return baos.toByteArray();
    }
}
