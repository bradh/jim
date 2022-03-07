package net.frogmouth.rnd.jim.s4607.testandstatus;

import static org.testng.Assert.*;

import java.util.EnumSet;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentSerialiserManager;
import org.testng.annotations.Test;

public class TestAndStatusSegmentSerialiserTest {

    @Test
    public void simpleSerialise() {
        byte[] expectedBytes =
                new byte[] {
                    0x00, 0x00, 0x00, 0x03, 0x00, 0x05, 0x00, 0x07, 0x02, 0x04, 0x08, 0x0F, 0x10,
                    0x20
                };
        TestAndStatusSegment testAndStatusSegment = new TestAndStatusSegment();
        testAndStatusSegment.setJobId(3);
        testAndStatusSegment.setRevisitIndex(5);
        testAndStatusSegment.setDwellIndex(7);
        testAndStatusSegment.setDwellTime(33818639);
        testAndStatusSegment.setHardwareStatus(
                HardwareStatus.fromFlags(EnumSet.of(HardwareStatusFlag.DatalinkStatus)));
        testAndStatusSegment.setModeStatus(
                ModeStatus.fromFlags(EnumSet.of(ModeStatusFlag.ElevationLimitExceeded)));
        AbstractSegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance()
                        .getSerialiser(testAndStatusSegment.getSegmentType());
        byte[] bytes = serialiser.serialise(testAndStatusSegment);
        assertEquals(bytes, expectedBytes);
    }
}
