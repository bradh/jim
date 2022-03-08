package net.frogmouth.rnd.jim.s4607.platformlocation;

import static org.testng.Assert.assertEquals;

import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class PlatformLocationSegmentParserTest extends PlatformLocationSegmentTestSupport {

    public PlatformLocationSegmentParserTest() {}

    @Test
    public void checkParse() {
        PlatformLocationSegment platformLocationSegment = doParse();
        assertEquals(platformLocationSegment.getSegmentType(), SegmentType.PlatformLocationSegment);
        assertEquals(platformLocationSegment.getLocationTime(), 3);
        assertEquals(platformLocationSegment.getPlatformPositionLatitude(), -11.612527, 0.000001);
        assertEquals(platformLocationSegment.getPlatformPositionLongitude(), 139.600916, 0.000001);
        assertEquals(platformLocationSegment.getPlatformPositionAltitude(), 1_200_000);
        assertEquals(platformLocationSegment.getPlatformTrack(), 22.763671, 0.000001);
        assertEquals(platformLocationSegment.getPlatformSpeed(), 205);
        assertEquals(platformLocationSegment.getPlatformVerticalVelocity(), 20);
    }
}
