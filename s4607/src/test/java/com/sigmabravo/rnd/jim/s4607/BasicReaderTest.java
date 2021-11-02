package com.sigmabravo.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class BasicReaderTest extends TestSupport {

    public BasicReaderTest() {}

    @Test
    public void instantiate() {
        PacketHeader packetHeader = new PacketHeader();
        assertNotNull(packetHeader);
    }

    @Test
    public void read() throws IOException {
        Reader reader = new Reader(getList1());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 2);
        Packet packet0 = packets.get(0);
        PacketHeader packetHeader = packet0.getPacketHeader();
        assertEquals(packetHeader.getVersionId(), "31");
        assertEquals(packetHeader.getPacketSize(), 76);
        assertEquals(packetHeader.getNationality(), "UK");
        // Only for test purposes. Actual is unclassified.
        assertEquals(packetHeader.getClassification(), 1);
        assertEquals(packetHeader.getClassificationAsText(), "TOP SECRET");
        assertEquals(packetHeader.getClassificationSystem(), "UK");
        assertEquals(packetHeader.getClassificationCodeFlags(), 0);
        assertEquals(packetHeader.getExerciseIndicator(), 128);
        assertEquals(packetHeader.getExerciseIndicatorAsText(), "Exercise, Real Data");
        assertEquals(packetHeader.getPlatformId(), "Pico1     ");
        assertEquals(packetHeader.getPlatformId().trim(), "Pico1");
        assertEquals(packetHeader.getMissionId(), 287454020);
        assertEquals(packetHeader.getJobId(), 1432778632);
        List<Segment> segments = packet0.getSegments();
        assertEquals(segments.size(), 1);
        Segment segment0 = segments.get(0);
        assertTrue(segment0 instanceof MissionSegment);
        MissionSegment missionSegment = (MissionSegment) segment0;
        assertEquals(missionSegment.getMissionPlan(), "Drifter 1   ");
        assertEquals(missionSegment.getMissionPlan().trim(), "Drifter 1");
        assertEquals(missionSegment.getFlightPlan(), "A1234       ");
        assertEquals(missionSegment.getFlightPlan().trim(), "A1234");
        assertEquals(missionSegment.getPlatformType(), 255);
        assertEquals(missionSegment.getPlatformTypeAsText(), "Other");
        assertEquals(missionSegment.getPlatformConfiguration(), "Build 1   ");
        assertEquals(missionSegment.getPlatformConfiguration().trim(), "Build 1");
        assertEquals(missionSegment.getYear(), 2016);
        assertEquals(missionSegment.getMonth(), 7);
        assertEquals(missionSegment.getDay(), 28);

        Packet packet1 = packets.get(1);
        PacketHeader packetHeader1 = packet1.getPacketHeader();
        assertEquals(packetHeader1.getVersionId(), "31");
        assertEquals(packetHeader1.getPacketSize(), 112);
        assertEquals(packetHeader1.getNationality(), "UK");
        // Only for test purposes. Actual is unclassified.
        assertEquals(packetHeader1.getClassification(), 1);
        assertEquals(packetHeader1.getClassificationAsText(), "TOP SECRET");
        assertEquals(packetHeader1.getClassificationSystem(), "UK");
        assertEquals(packetHeader1.getClassificationCodeFlags(), 0);
        assertEquals(packetHeader1.getExerciseIndicator(), 128);
        assertEquals(packetHeader1.getExerciseIndicatorAsText(), "Exercise, Real Data");
        assertEquals(packetHeader1.getPlatformId(), "Pico1     ");
        assertEquals(packetHeader1.getPlatformId().trim(), "Pico1");
        assertEquals(packetHeader1.getMissionId(), 287454020);
        assertEquals(packetHeader1.getJobId(), 1432778632);
        List<Segment> segments1 = packet1.getSegments();
        assertEquals(segments1.size(), 1);
        Segment segment1 = segments1.get(0);
        assertTrue(segment1 instanceof DwellSegment);
        DwellSegment dwellSegment = (DwellSegment) segment1;
        assertEquals((int) dwellSegment.getRevisitIndex(), 100);
        assertEquals((int) dwellSegment.getDwellIndex(), 20000);
        assertTrue(dwellSegment.getLastDwellOfRevisit());
        assertEquals((int) dwellSegment.getTargetReportCount(), 1);
        assertEquals((long) dwellSegment.getDwellTime(), 1000000);
        assertEquals((double) dwellSegment.getSensorLatitude(), 55.92861298006028, 0.00000000001);
        assertEquals((double) dwellSegment.getSensorLongitude(), 357.33884003944695, 0.00000000001);
        assertEquals(dwellSegment.getSensorAltitude(), 100000);
        assertEquals(
                (double) dwellSegment.getDwellCentreLatitude(), 55.999591019935906, 0.00000000001);
        assertEquals(
                (double) dwellSegment.getDwellCentreLongitude(), 354.5635919831693, 0.00000000001);
        assertEquals(dwellSegment.getDwellAreaRangeHalfExtent(), 2.5, 0.0001);
        assertEquals(dwellSegment.getDwellAreaDwellAngleHalfExtent(), 22.5, 0.0001);
        assertEquals(dwellSegment.getTargets().size(), 1);
        Target target = dwellSegment.getTargets().get(0);
        assertEquals((int) target.getMtiReportIndex(), 34);
        assertEquals(target.getTargetLocationLatitude(), 55.998699981719255, 0.00000000001);
        assertEquals(target.getTargetLocationLongitude(), 357.2900000307709, 0.00000000001);
        assertEquals((int) target.getTargetLocationGeodeticHeight(), 100);
        assertEquals((int) target.getTargetVelocityLineOfSightComponent(), 530);
        assertEquals((int) target.getTargetWrapVelocity(), 40000);
        assertEquals((int) target.getTargetSNR(), -128);
        assertEquals((int) target.getTargetClassification(), 10);
        assertEquals(target.getTargetClassificationAsText(), "Vehicle, Live Target");
        assertEquals((int) target.getTargetClassificationProbability(), 90);
        assertEquals((int) target.getTargetMeasurementUncertaintySlantRange(), 1000);
        assertEquals((int) target.getTargetMeasurementUncertaintyCrossRange(), 2000);
        assertEquals((int) target.getTargetMeasurementUncertaintyHeight(), 200);
        assertEquals((int) target.getTargetMeasurementUncertaintyRadialVelocity(), 5000);
        assertEquals((int) target.getTruthTagApplication(), 200);
        assertEquals((long) target.getTruthTagEntity(), 10000);
        assertEquals((int) target.getTargetRadarCrossSection(), 10);
    }
}
