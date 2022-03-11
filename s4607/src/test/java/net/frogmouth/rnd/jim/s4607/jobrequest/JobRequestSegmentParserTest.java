package net.frogmouth.rnd.jim.s4607.jobrequest;

import static org.testng.Assert.assertEquals;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class JobRequestSegmentParserTest extends JobRequestSegmentTestSupport {

    public JobRequestSegmentParserTest() {}

    @Test
    public void checkParse() {
        JobRequestSegment jobRequestSegment = doParse();
        assertEquals(jobRequestSegment.getSegmentType(), SegmentType.JobRequestSegment);
        assertEquals(jobRequestSegment.getRequestorID(), "Brad      ");
        assertEquals(jobRequestSegment.getRequestorTaskId(), "Task 4C   ");
        assertEquals(jobRequestSegment.getPriority(), 50);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointA().getLatitude(),
                -34.2000000,
                0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointA().getLongitude(), 125.8, 0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointB().getLatitude(),
                -34.2000000,
                0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointB().getLongitude(), 126.1, 0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointC().getLatitude(),
                -34.3500000,
                0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointC().getLongitude(), 126.1, 0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointD().getLatitude(),
                -34.3500000,
                0.0000001);
        assertEquals(
                jobRequestSegment.getBoundingArea().getPointD().getLongitude(), 125.8, 0.0000001);
        assertEquals(jobRequestSegment.getRadarMode(), 1);
        assertEquals(jobRequestSegment.getRadarResolutionRange(), 2000);
        assertEquals(jobRequestSegment.getRadarResolutionCrossRange(), 500);
        assertEquals(
                jobRequestSegment.getEarliestStartTime(),
                ZonedDateTime.of(2022, 3, 13, 9, 12, 38, 0, ZoneOffset.UTC));
        assertEquals(jobRequestSegment.getStartTimeAllowedDelay(), 1800);
        assertEquals(jobRequestSegment.getDuration(), 1200);
        assertEquals(jobRequestSegment.getRevisitInterval(), 100);
        assertEquals(jobRequestSegment.getSensorIdType(), 255);
        assertEquals(jobRequestSegment.getSensorIdModel(), "None  ");
        assertEquals(jobRequestSegment.getRequestType(), 0);
    }
}
