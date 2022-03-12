package net.frogmouth.rnd.jim.s4607.jobacknowledge;

import static org.testng.Assert.assertEquals;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class JobAcknowledgeSegmentParserTest extends JobAcknowledgeSegmentTestSupport {

    public JobAcknowledgeSegmentParserTest() {}

    @Test
    public void checkParse() {
        JobAcknowledgeSegment jobAcknowledgeSegment = doParse();
        assertEquals(jobAcknowledgeSegment.getSegmentType(), SegmentType.JobAcknowledgeSegment);
        assertEquals(jobAcknowledgeSegment.getJobId(), 33752072);
        assertEquals(jobAcknowledgeSegment.getRequestorID(), "Brad      ");
        assertEquals(jobAcknowledgeSegment.getRequestorTaskId(), "Task 4C   ");
        assertEquals(jobAcknowledgeSegment.getSensorIdType(), 18);
        assertEquals(jobAcknowledgeSegment.getSensorIdModel(), "A     ");
        assertEquals(jobAcknowledgeSegment.getPriority(), 8);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointA().getLatitude(),
                -34.2000000,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointA().getLongitude(),
                125.8,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointB().getLatitude(),
                -34.2000000,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointB().getLongitude(),
                126.1,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointC().getLatitude(),
                -34.3500000,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointC().getLongitude(),
                126.1,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointD().getLatitude(),
                -34.3500000,
                0.0000001);
        assertEquals(
                jobAcknowledgeSegment.getBoundingArea().getPointD().getLongitude(),
                125.8,
                0.0000001);
        assertEquals(jobAcknowledgeSegment.getRadarMode(), 102);
        assertEquals(jobAcknowledgeSegment.getDuration(), 2400);
        assertEquals(jobAcknowledgeSegment.getRevisitInterval(), 100);
        assertEquals(jobAcknowledgeSegment.getRequestStatus(), 2);
        assertEquals(
                jobAcknowledgeSegment.getRadarJobStartTime(),
                ZonedDateTime.of(2022, 3, 13, 9, 12, 38, 0, ZoneOffset.UTC));
        assertEquals(jobAcknowledgeSegment.getRequestorNationalityId(), "AS");
    }
}
