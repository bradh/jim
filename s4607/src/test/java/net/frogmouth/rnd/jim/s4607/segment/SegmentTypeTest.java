package net.frogmouth.rnd.jim.s4607.segment;

import static org.testng.Assert.*;

import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import org.testng.annotations.Test;

/** Unit tests for {@link SegmentType}. */
public class SegmentTypeTest {

    public SegmentTypeTest() {}

    @Test
    public void checkMissionSegment() {
        SegmentType uut = SegmentType.MissionSegment;
        assertEquals(uut.getTag(), 1);
        assertEquals(uut.getDisplayLabel(), "Mission Segment");
    }

    @Test
    public void lookupMissionSegment() {
        SegmentType uut = SegmentType.lookupByIdent(1);
        assertEquals(uut, SegmentType.MissionSegment);
    }

    @Test
    public void lookupJobRequestSegment() {
        SegmentType uut = SegmentType.lookupByIdent(101);
        assertEquals(uut, SegmentType.JobRequestSegment);
        assertEquals(uut.getTag(), 101);
        assertEquals(uut.getDisplayLabel(), "Job Request Segment");
    }

    @Test
    public void lookupJobAcknowledgementSegment() {
        SegmentType uut = SegmentType.lookupByIdent(102);
        assertEquals(uut, SegmentType.JobAcknowledgementSegment);
        assertEquals(uut.getTag(), 102);
        assertEquals(uut.getDisplayLabel(), "Job Acknowledge Segment");
    }

    @Test
    public void lookupReservedForNewSegments14() {
        SegmentType uut = SegmentType.lookupByIdent(14);
        assertEquals(uut, SegmentType.ReservedForNewSegments);
        assertEquals(uut.getTag(), 100);
        assertEquals(uut.getDisplayLabel(), "Reserved for new Segments");
    }

    @Test
    public void lookupReservedForNewSegments88() {
        SegmentType uut = SegmentType.lookupByIdent(88);
        assertEquals(uut, SegmentType.ReservedForNewSegments);
        assertEquals(uut.getTag(), 100);
        assertEquals(uut.getDisplayLabel(), "Reserved for new Segments");
    }

    @Test
    public void lookupReservedForNewSegments100() {
        SegmentType uut = SegmentType.lookupByIdent(100);
        assertEquals(uut, SegmentType.ReservedForNewSegments);
        assertEquals(uut.getTag(), 100);
        assertEquals(uut.getDisplayLabel(), "Reserved for new Segments");
    }

    @Test
    public void lookupReservedForFutureUse103() {
        SegmentType uut = SegmentType.lookupByIdent(103);
        assertEquals(uut, SegmentType.ReservedForFutureUse);
        assertEquals(uut.getTag(), 127);
        assertEquals(uut.getDisplayLabel(), "Reserved for future use");
    }

    @Test
    public void lookupReservedForFutureUse120() {
        SegmentType uut = SegmentType.lookupByIdent(120);
        assertEquals(uut, SegmentType.ReservedForFutureUse);
        assertEquals(uut.getTag(), 127);
        assertEquals(uut.getDisplayLabel(), "Reserved for future use");
    }

    @Test
    public void lookupReservedForFutureUse127() {
        SegmentType uut = SegmentType.lookupByIdent(127);
        assertEquals(uut, SegmentType.ReservedForFutureUse);
        assertEquals(uut.getTag(), 127);
        assertEquals(uut.getDisplayLabel(), "Reserved for future use");
    }

    @Test
    public void lookupReservedForExtensions128() {
        SegmentType uut = SegmentType.lookupByIdent(128);
        assertEquals(uut, SegmentType.ReservedForExtensions);
        assertEquals(uut.getTag(), 255);
        assertEquals(uut.getDisplayLabel(), "Reserved for extensions");
    }

    @Test
    public void lookupReservedForExtensions200() {
        SegmentType uut = SegmentType.lookupByIdent(200);
        assertEquals(uut, SegmentType.ReservedForExtensions);
        assertEquals(uut.getTag(), 255);
        assertEquals(uut.getDisplayLabel(), "Reserved for extensions");
    }

    @Test
    public void lookupReservedForExtensions255() {
        SegmentType uut = SegmentType.lookupByIdent(255);
        assertEquals(uut, SegmentType.ReservedForExtensions);
        assertEquals(uut.getTag(), 255);
        assertEquals(uut.getDisplayLabel(), "Reserved for extensions");
    }

    @Test
    public void lookupUnknown0() {
        SegmentType uut = SegmentType.lookupByIdent(0);
        assertEquals(uut, SegmentType.Unknown);
        assertEquals(uut.getTag(), 0);
        assertEquals(uut.getDisplayLabel(), "Unknown");
    }

    @Test
    public void lookupUnknown256() {
        SegmentType uut = SegmentType.lookupByIdent(256);
        assertEquals(uut, SegmentType.Unknown);
        assertEquals(uut.getTag(), 0);
        assertEquals(uut.getDisplayLabel(), "Unknown");
    }

    @Test
    public void lookupUnknownNegative() {
        SegmentType uut = SegmentType.lookupByIdent(-1);
        assertEquals(uut, SegmentType.Unknown);
        assertEquals(uut.getTag(), 0);
        assertEquals(uut.getDisplayLabel(), "Unknown");
    }
}
