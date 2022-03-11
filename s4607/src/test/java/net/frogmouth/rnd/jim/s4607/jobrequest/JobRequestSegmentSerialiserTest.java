package net.frogmouth.rnd.jim.s4607.jobrequest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentSerialiserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class JobRequestSegmentSerialiserTest extends JobRequestSegmentTestSupport {

    @Test
    public void checkSerialisation() {
        JobRequestSegment jobRequestSegment = doParse();
        ISegmentSerialiser serialiser = new JobRequestSegmentSerialiser();
        byte[] bytes = serialiser.serialise(jobRequestSegment);
        assertEquals(bytes, getTestBytes());
    }

    @Test
    public void checkSerialisationViaFactory() {
        JobRequestSegment jobRequestSegment = doFactoryParse();
        ISegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance().getSerialiser(SegmentType.JobRequestSegment);
        assertTrue(serialiser instanceof JobRequestSegmentSerialiser);
        byte[] bytes = serialiser.serialise(jobRequestSegment);
        assertEquals(bytes, getTestBytes());
    }
}
