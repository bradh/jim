package net.frogmouth.rnd.jim.s4607.platformlocation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentSerialiserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class PlatformLocationSegmentSerialiserTest extends PlatformLocationSegmentTestSupport {

    @Test
    public void checkSerialisation() {
        PlatformLocationSegment platformLocationSegment = doParse();
        ISegmentSerialiser serialiser = new PlatformLocationSegmentSerialiser();
        byte[] bytes = serialiser.serialise(platformLocationSegment);
        assertEquals(bytes, getTestBytes());
    }

    @Test
    public void checkSerialisationViaFactory() {
        PlatformLocationSegment platformLocationSegment = doParse();
        ISegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance()
                        .getSerialiser(SegmentType.PlatformLocationSegment);
        assertTrue(serialiser instanceof PlatformLocationSegmentSerialiser);
        byte[] bytes = serialiser.serialise(platformLocationSegment);
        assertEquals(bytes, getTestBytes());
    }
}
