package net.frogmouth.rnd.jim.s4607.processinghistory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import net.frogmouth.rnd.jim.s4607.segment.SegmentType;
import org.testng.annotations.Test;

public class ProcessingHistorySegmentParserTest extends ProcessingHistorySegmentTestSupport {

    public ProcessingHistorySegmentParserTest() {}

    @Test
    public void checkParse() {
        ProcessingHistorySegment processingHistorySegment = doParse();
        assertEquals(
                processingHistorySegment.getSegmentType(), SegmentType.ProcessingHistorySegment);
        assertEquals(processingHistorySegment.getBasedOnNationalityID(), "AS");
        assertEquals(processingHistorySegment.getBasedOnPlatformID(), "A47-012   ");
        assertEquals(processingHistorySegment.getBasedOnPlatformID().trim(), "A47-012");
        assertEquals(processingHistorySegment.getBasedOnMissionId(), 258);
        assertEquals(processingHistorySegment.getBasedOnJobID(), 7);
        assertEquals(processingHistorySegment.getProcessingRecords().size(), 2);
        ProcessingRecord record0 = processingHistorySegment.getProcessingRecords().get(0);
        assertEquals(record0.getProcessingHistorySequenceNumber(), 1);
        assertEquals(record0.getNationalityIdOfModifyingSystem(), "AS");
        assertEquals(record0.getPlatformIdOfModifyingSystem(), "DGS-AUS   ");
        assertEquals(record0.getPlatformIdOfModifyingSystem().trim(), "DGS-AUS");
        assertEquals(record0.getMissionIdOfModifyingSystem(), 515);
        assertEquals(record0.getJobIdOfModifyingSystem(), 2);
        assertEquals(record0.getProcessingPerformed().getFlags().size(), 3);
        assertTrue(
                record0.getProcessingPerformed()
                        .getFlags()
                        .contains(ProcessingPerformedFlag.LocationRegistration));
        assertTrue(
                record0.getProcessingPerformed()
                        .getFlags()
                        .contains(ProcessingPerformedFlag.LocationAdjustment));
        assertTrue(
                record0.getProcessingPerformed()
                        .getFlags()
                        .contains(ProcessingPerformedFlag.AreaFiltering));
        ProcessingRecord record1 = processingHistorySegment.getProcessingRecords().get(1);
        assertEquals(record1.getProcessingHistorySequenceNumber(), 2);
        assertEquals(record1.getNationalityIdOfModifyingSystem(), "UK");
        assertEquals(record1.getPlatformIdOfModifyingSystem(), "Abbey Road");
        assertEquals(record1.getPlatformIdOfModifyingSystem().trim(), "Abbey Road");
        assertEquals(record1.getMissionIdOfModifyingSystem(), 524808);
        assertEquals(record1.getJobIdOfModifyingSystem(), 197637);
        assertEquals(record1.getProcessingPerformed().getFlags().size(), 3);
        assertTrue(
                record1.getProcessingPerformed()
                        .getFlags()
                        .contains(ProcessingPerformedFlag.SecurityFiltering));
        assertTrue(
                record1.getProcessingPerformed()
                        .getFlags()
                        .contains(ProcessingPerformedFlag.GeoidAdjustment));
        assertTrue(
                record1.getProcessingPerformed()
                        .getFlags()
                        .contains(ProcessingPerformedFlag.BandwidthFiltering));
    }
}
