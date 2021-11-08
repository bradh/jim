package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.DwellSegment.DwellSegment;
import net.frogmouth.rnd.jim.s4607.DwellSegment.Target;
import net.frogmouth.rnd.jim.s4607.FreeTextSegment.FreeTextSegment;
import net.frogmouth.rnd.jim.s4607.MissionSegment.MissionSegment;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import org.testng.annotations.Test;

public class TenTargetsPrecisionTargetingTest extends TestSupport {

    public TenTargetsPrecisionTargetingTest() {}

    @Test
    public void instantiate() {
        PacketHeader packetHeader = new PacketHeader();
        assertNotNull(packetHeader);
    }

    @Test
    public void read() throws IOException {
        Reader reader = new Reader(get10TargetsPrecisionTargeting());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 194);
        checkPacket0(packets.get(0));
        checkPacket193(packets.get(193));
    }

    private void checkPacket0(Packet packet) {
        PacketHeader packetHeader = packet.getPacketHeader();
        assertEquals(packetHeader.getVersionId(), "30");
        assertEquals(packetHeader.getPacketSize(), 127);
        assertEquals(packetHeader.getNationality(), "US");
        assertEquals(packetHeader.getClassification(), 5);
        assertEquals(packetHeader.getClassificationAsText(), "UNCLASSIFIED");
        assertEquals(packetHeader.getClassificationSystem(), "US");
        assertEquals(packetHeader.getClassificationCodeFlags(), 0);
        assertEquals(packetHeader.getExerciseIndicator(), 129);
        assertEquals(packetHeader.getExerciseIndicatorAsText(), "Exercise, Simulated Data");
        assertEquals(packetHeader.getPlatformId(), "Test Data ");
        assertEquals(packetHeader.getPlatformId().trim(), "Test Data");
        assertEquals(packetHeader.getMissionId(), 1);
        assertEquals(packetHeader.getJobId(), 1);
        List<Segment> segments = packet.getSegments();
        assertEquals(segments.size(), 2);
        Segment segment0 = segments.get(0);
        assertTrue(segment0 instanceof MissionSegment);
        MissionSegment missionSegment = (MissionSegment) segment0;
        assertEquals(missionSegment.getMissionPlan(), "            ");
        assertEquals(missionSegment.getMissionPlan().trim(), "");
        assertEquals(missionSegment.getFlightPlan(), "test.nav    ");
        assertEquals(missionSegment.getFlightPlan().trim(), "test.nav");
        assertEquals(missionSegment.getPlatformType(), 0);
        assertEquals(missionSegment.getPlatformTypeAsText(), "Unidentified");
        assertEquals(missionSegment.getPlatformConfiguration(), "Test      ");
        assertEquals(missionSegment.getPlatformConfiguration().trim(), "Test");
        assertEquals(missionSegment.getYear(), 2010);
        assertEquals(missionSegment.getMonth(), 11);
        assertEquals(missionSegment.getDay(), 30);
        Segment segment1 = segments.get(1);
        assertTrue(segment1 instanceof FreeTextSegment);
        FreeTextSegment freeTextSegment = (FreeTextSegment) segment1;
        assertEquals(freeTextSegment.getOriginatorId(), "Test Data ");
        assertEquals(freeTextSegment.getRecipientId(), "Test Data ");
        assertEquals(freeTextSegment.getFreeText(), "Example free-text message.");
    }

    private void checkPacket193(Packet packet) {
        PacketHeader packetHeader = packet.getPacketHeader();
        assertEquals(packetHeader.getVersionId(), "30");
        assertEquals(packetHeader.getPacketSize(), 211);
        assertEquals(packetHeader.getNationality(), "US");
        assertEquals(packetHeader.getClassification(), 5);
        assertEquals(packetHeader.getClassificationAsText(), "UNCLASSIFIED");
        assertEquals(packetHeader.getClassificationSystem(), "US");
        assertEquals(packetHeader.getClassificationCodeFlags(), 0);
        assertEquals(packetHeader.getExerciseIndicator(), 129);
        assertEquals(packetHeader.getExerciseIndicatorAsText(), "Exercise, Simulated Data");
        assertEquals(packetHeader.getPlatformId(), "Test Data ");
        assertEquals(packetHeader.getPlatformId().trim(), "Test Data");
        assertEquals(packetHeader.getMissionId(), 1);
        assertEquals(packetHeader.getJobId(), 1);
        List<Segment> segments = packet.getSegments();
        assertEquals(segments.size(), 1);
        Segment segment0 = segments.get(0);
        assertTrue(segment0 instanceof DwellSegment);
        DwellSegment dwellSegment = (DwellSegment) segment0;
        assertEquals((int) dwellSegment.getRevisitIndex(), 19);
        assertEquals((int) dwellSegment.getDwellIndex(), 6);
        assertTrue(dwellSegment.getLastDwellOfRevisit());
        assertEquals((int) dwellSegment.getTargetReportCount(), 3);
        assertEquals((long) dwellSegment.getDwellTime(), 29393229);
        assertEquals((double) dwellSegment.getSensorLatitude(), 40.49005958251655, 0.00000000001);
        assertEquals((double) dwellSegment.getSensorLongitude(), 245.52190052345395, 0.00000000001);
        assertEquals(dwellSegment.getSensorAltitude(), 427076);
        assertNull(dwellSegment.getScaleFactorLatScale());
        assertNull(dwellSegment.getScaleFactorLonScale());
        assertEquals((int) dwellSegment.getSensorPositionUncertaintyAlongTrack(), 0);
        assertEquals((int) dwellSegment.getSensorPositionUncertaintyCrossTrack(), 0);
        assertEquals((int) dwellSegment.getSensorPositionUncertaintyAltitude(), 0);
        assertEquals(dwellSegment.getSensorTrack(), 317.3291015625, 0.0000001);
        assertEquals((int) dwellSegment.getSensorSpeed(), 72021);
        assertEquals((int) dwellSegment.getSensorVerticalVelocity(), -2);
        assertEquals((int) dwellSegment.getSensorTrackUncertainty(), 0);
        assertEquals((int) dwellSegment.getSensorSpeedUncertainty(), 0);
        assertEquals((int) dwellSegment.getSensorVerticalVelocityUncertainty(), 0);
        assertEquals(
                (double) dwellSegment.getPlatformOrientationHeading(), 317.3291015625, 0.00000001);
        assertEquals((double) dwellSegment.getPlatformOrientationPitch(), 0.0, 0.00000000001);
        assertEquals((double) dwellSegment.getPlatformOrientationRoll(), 0.0, 0.00000000001);
        assertEquals(
                (double) dwellSegment.getDwellCentreLatitude(), 40.659381612204015, 0.00000000001);
        assertEquals(
                (double) dwellSegment.getDwellCentreLongitude(), 246.15377473644912, 0.00000000001);
        assertEquals(dwellSegment.getDwellAreaRangeHalfExtent(), 6.65625, 0.000001);
        assertEquals(dwellSegment.getDwellAreaDwellAngleHalfExtent(), 0.999755859375, 0.000001);
        assertEquals(dwellSegment.getSensorOrientationHeading(), 293.3734130859375, 0.00000000001);
        assertEquals(dwellSegment.getSensorOrientationPitch(), 0.0, 0.00000001);
        assertEquals(dwellSegment.getSensorOrientationRoll(), 0.0, 0.00000001);
        assertEquals((int) dwellSegment.getMinimumDetectableVelocity(), 10);
        assertEquals(dwellSegment.getTargets().size(), 3);
        Target target1 = dwellSegment.getTargets().get(0);
        assertEquals((int) target1.getMtiReportIndex(), 0);
        assertEquals(target1.getTargetLocationLatitude(), 40.66204060334712, 0.000000000001);
        assertEquals(target1.getTargetLocationLongitude(), 246.16688629612327, 0.00000000001);
        assertNull(target1.getTargetLocationDeltaLatitude());
        assertNull(target1.getTargetLocationDeltaLongitude());
        assertEquals((int) target1.getTargetLocationGeodeticHeight(), -2);
        assertEquals((int) target1.getTargetVelocityLineOfSightComponent(), 760);
        assertEquals((int) target1.getTargetWrapVelocity(), 0);
        assertEquals((int) target1.getTargetSNR(), 12);
        assertEquals((int) target1.getTargetClassification(), 255);
        assertEquals(target1.getTargetClassificationAsText(), "Unknown, Simulated Target");
        assertEquals((int) target1.getTargetClassificationProbability(), 0);
        assertEquals((int) target1.getTargetMeasurementUncertaintySlantRange(), 1000);
        assertEquals((int) target1.getTargetMeasurementUncertaintyCrossRange(), 580);
        assertEquals((int) target1.getTargetMeasurementUncertaintyHeight(), 0);
        assertEquals((int) target1.getTargetMeasurementUncertaintyRadialVelocity(), 200);
        assertEquals((int) target1.getTruthTagApplication(), 1);
        assertEquals((long) target1.getTruthTagEntity(), 1);
        assertEquals((int) target1.getTargetRadarCrossSection(), 10);
        Target target2 = dwellSegment.getTargets().get(1);
        assertEquals((int) target2.getMtiReportIndex(), 1);
        assertEquals(target2.getTargetLocationLatitude(), 40.67227038089186, 0.000000000001);
        assertEquals(target2.getTargetLocationLongitude(), 246.167107578367, 0.00000000001);
        assertNull(target2.getTargetLocationDeltaLatitude());
        assertNull(target2.getTargetLocationDeltaLongitude());
        assertEquals((int) target2.getTargetLocationGeodeticHeight(), -1);
        assertEquals((int) target2.getTargetVelocityLineOfSightComponent(), 660);
        assertEquals((int) target2.getTargetWrapVelocity(), 0);
        assertEquals((int) target2.getTargetSNR(), 12);
        assertEquals((int) target2.getTargetClassification(), 255);
        assertEquals(target2.getTargetClassificationAsText(), "Unknown, Simulated Target");
        assertEquals((int) target2.getTargetClassificationProbability(), 0);
        assertEquals((int) target2.getTargetMeasurementUncertaintySlantRange(), 1000);
        assertEquals((int) target2.getTargetMeasurementUncertaintyCrossRange(), 584);
        assertEquals((int) target2.getTargetMeasurementUncertaintyHeight(), 0);
        assertEquals((int) target2.getTargetMeasurementUncertaintyRadialVelocity(), 200);
        assertEquals((int) target2.getTruthTagApplication(), 1);
        assertEquals((long) target2.getTruthTagEntity(), 4);
        assertEquals((int) target2.getTargetRadarCrossSection(), 10);
        Target target3 = dwellSegment.getTargets().get(2);
        assertEquals((int) target3.getMtiReportIndex(), 2);
        assertEquals(target3.getTargetLocationLatitude(), 40.65702189691365, 0.000000000001);
        assertEquals(target3.getTargetLocationLongitude(), 246.16688671521842, 0.00000000001);
        assertNull(target3.getTargetLocationDeltaLatitude());
        assertNull(target3.getTargetLocationDeltaLongitude());
        assertEquals((int) target3.getTargetLocationGeodeticHeight(), 0);
        assertEquals((int) target3.getTargetVelocityLineOfSightComponent(), -434);
        assertEquals((int) target3.getTargetWrapVelocity(), 0);
        assertEquals((int) target3.getTargetSNR(), 12);
        assertEquals((int) target3.getTargetClassification(), 255);
        assertEquals(target3.getTargetClassificationAsText(), "Unknown, Simulated Target");
        assertEquals((int) target3.getTargetClassificationProbability(), 0);
        assertEquals((int) target3.getTargetMeasurementUncertaintySlantRange(), 1000);
        assertEquals((int) target3.getTargetMeasurementUncertaintyCrossRange(), 578);
        assertEquals((int) target3.getTargetMeasurementUncertaintyHeight(), 0);
        assertEquals((int) target3.getTargetMeasurementUncertaintyRadialVelocity(), 200);
        assertEquals((int) target3.getTruthTagApplication(), 1);
        assertEquals((long) target3.getTruthTagEntity(), 10);
        assertEquals((int) target3.getTargetRadarCrossSection(), 10);
    }
}
