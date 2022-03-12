package net.frogmouth.rnd.jim.s4607.jobacknowledge;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentSerialiserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class JobAcknowledgeSegmentSerialiserTest extends JobAcknowledgeSegmentTestSupport {

    @Test
    public void checkSerialisation() {
        JobAcknowledgeSegment jobRequestSegment = doParse();
        ISegmentSerialiser serialiser = new JobAcknowledgeSegmentSerialiser();
        byte[] bytes = serialiser.serialise(jobRequestSegment);
        assertEquals(bytes, getTestBytes());
    }

    @Test
    public void checkSerialisationViaFactory() {
        JobAcknowledgeSegment jobAcknowledgeSegment = doFactoryParse();
        ISegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance()
                        .getSerialiser(SegmentType.JobAcknowledgeSegment);
        assertTrue(serialiser instanceof JobAcknowledgeSegmentSerialiser);
        byte[] bytes = serialiser.serialise(jobAcknowledgeSegment);
        assertEquals(bytes, getTestBytes());
    }
}
