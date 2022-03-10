package net.frogmouth.rnd.jim.s4607.processinghistory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.SegmentSerialiserManager;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class ProcessingHistorySegmentSerialiserTest extends ProcessingHistorySegmentTestSupport {

    @Test
    public void checkSerialisation() {
        ProcessingHistorySegment platformLocationSegment = doParse();
        ISegmentSerialiser serialiser = new ProcessingHistorySegmentSerialiser();
        byte[] bytes = serialiser.serialise(platformLocationSegment);
        assertEquals(bytes, getTestBytes());
    }

    @Test
    public void checkSerialisationViaFactory() {
        ProcessingHistorySegment processingHistorySegment = doParse();
        ISegmentSerialiser serialiser =
                SegmentSerialiserManager.getInstance()
                        .getSerialiser(SegmentType.ProcessingHistorySegment);
        assertTrue(serialiser instanceof ProcessingHistorySegmentSerialiser);
        byte[] bytes = serialiser.serialise(processingHistorySegment);
        assertEquals(bytes, getTestBytes());
    }
}
