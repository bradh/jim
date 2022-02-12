package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.DwellSegment.DwellSegment;
import net.frogmouth.rnd.jim.s4607.DwellSegment.TargetReport;
import net.frogmouth.rnd.jim.s4607.FreeTextSegment.FreeTextSegment;
import net.frogmouth.rnd.jim.s4607.JobDefinitionSegment.JobDefinitionSegment;
import net.frogmouth.rnd.jim.s4607.MissionSegment.MissionSegment;
import net.frogmouth.rnd.jim.s4607.Packet.Packet;
import net.frogmouth.rnd.jim.s4607.Packet.PacketHeader;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import org.testng.annotations.Test;

public class TenTargetsSATest extends TestSupport {

    public TenTargetsSATest() {}

    @Test
    public void instantiate() {
        PacketHeader packetHeader = new PacketHeader();
        assertNotNull(packetHeader);
    }

    @Test
    public void read() throws IOException {
        Reader reader = new Reader(get10TargetsSA());
        List<Packet> packets = reader.getPackets();
        assertEquals(packets.size(), 194);
        checkPacket0(packets.get(0));
        checkPacket1(packets.get(1));
        checkPacket2(packets.get(2));
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

    private void checkPacket1(Packet packet) {
        PacketHeader packetHeader = packet.getPacketHeader();
        assertEquals(packetHeader.getVersionId(), "30");
        assertEquals(packetHeader.getPacketSize(), 105);
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
        assertTrue(segment0 instanceof JobDefinitionSegment);
        JobDefinitionSegment jobDefinitionSegment = (JobDefinitionSegment) segment0;
        assertEquals(jobDefinitionSegment.getJobId(), 1);
        assertEquals(jobDefinitionSegment.getSensorIdType(), 255);
        assertEquals(jobDefinitionSegment.getSensorIdModel(), "NORMAL");
        assertEquals(jobDefinitionSegment.getTargetFilteringFlag(), 0);
        assertEquals(jobDefinitionSegment.getPriority(), 1);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointA().getLatitude(),
                40.7425354141742,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointA().getLongitude(),
                246.0727079026401,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointB().getLatitude(),
                40.74239652603865,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointB().getLongitude(),
                246.19107336737216,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointC().getLatitude(),
                40.65235870890319,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointC().getLongitude(),
                246.19082333520055,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointD().getLatitude(),
                40.65249768085778,
                0.00000000001);
        assertEquals(
                jobDefinitionSegment.getBoundingArea().getPointD().getLongitude(),
                246.07259684242308,
                0.00000000001);
        assertEquals(jobDefinitionSegment.getRadarMode(), 1);
        assertEquals(jobDefinitionSegment.getNominalRevisitInterval(), 300);
        assertEquals(jobDefinitionSegment.getAlongTrackUncertainty(), 65535);
        assertEquals(jobDefinitionSegment.getCrossTrackUncertainty(), 65535);
        assertEquals(jobDefinitionSegment.getAltitudeUncertainty(), 65535);
        assertEquals(jobDefinitionSegment.getTrackHeadingUncertainty(), 255);
        assertEquals(jobDefinitionSegment.getSensorSpeedUncertainty(), 65535);
        assertEquals(jobDefinitionSegment.getSlantRangeStandardDeviation(), 65535);
        assertEquals(jobDefinitionSegment.getCrossRangeStandardDeviation(), 180.0);
        assertEquals(jobDefinitionSegment.getTargetVelocityLineOfSightStandardDeviation(), 0);
        assertEquals(jobDefinitionSegment.getMdv(), 255);
        assertEquals(jobDefinitionSegment.getDetectionProbability(), 0);
        assertEquals(jobDefinitionSegment.getFalseAlarmDensity(), 255);
        assertEquals(jobDefinitionSegment.getTerrainElevationModelUsed(), 2);
        assertEquals(jobDefinitionSegment.getGeoidModelUsed(), 0);
    }

    private void checkPacket2(Packet packet) {
        PacketHeader packetHeader = packet.getPacketHeader();
        assertEquals(packetHeader.getVersionId(), "30");
        assertEquals(packetHeader.getPacketSize(), 101);
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
        assertEquals((int) dwellSegment.getRevisitIndex(), 0);
        assertEquals((int) dwellSegment.getDwellIndex(), 0);
        assertFalse(dwellSegment.getLastDwellOfRevisit());
        assertEquals((int) dwellSegment.getTargetReportCount(), 0);
        assertEquals((long) dwellSegment.getDwellTime(), 28802150);
        assertEquals((double) dwellSegment.getSensorLatitude(), 40.21105238702148, 0.00000000001);
        assertEquals((double) dwellSegment.getSensorLongitude(), 245.86506988853216, 0.00000000001);
        assertEquals(dwellSegment.getSensorAltitude(), 426688);
        assertEquals(
                (double) dwellSegment.getScaleFactorLatScale(), 4.882458597421646e-5, 0.0000001);
        assertEquals(
                (double) dwellSegment.getScaleFactorLonScale(), 4.886649549007416e-5, 0.0000001);
        assertNull(dwellSegment.getSensorPositionUncertaintyAlongTrack());
        assertNull(dwellSegment.getSensorPositionUncertaintyCrossTrack());
        assertNull(dwellSegment.getSensorPositionUncertaintyAltitude());
        assertEquals(dwellSegment.getSensorTrack(), 315.3515625, 0.0000001);
        assertEquals((int) dwellSegment.getSensorSpeed(), 72021);
        assertEquals((int) dwellSegment.getSensorVerticalVelocity(), 0);
        assertNull(dwellSegment.getSensorTrackUncertainty());
        assertNull(dwellSegment.getSensorSpeedUncertainty());
        assertNull(dwellSegment.getSensorVerticalVelocityUncertainty());
        assertEquals(
                (double) dwellSegment.getPlatformOrientationHeading(),
                315.5877685546875,
                0.00000001);
        assertEquals((double) dwellSegment.getPlatformOrientationPitch(), 0.0, 0.00000000001);
        assertEquals((double) dwellSegment.getPlatformOrientationRoll(), 0.0, 0.00000000001);
        assertEquals(
                (double) dwellSegment.getDwellCentreLatitude(), 40.714164935052395, 0.00000000001);
        assertEquals(
                (double) dwellSegment.getDwellCentreLongitude(), 246.07425411231816, 0.00000000001);
        assertEquals(dwellSegment.getDwellAreaRangeHalfExtent(), 6.53125, 0.000001);
        assertEquals(dwellSegment.getDwellAreaDwellAngleHalfExtent(), 0.999755859375, 0.000001);
        assertNull(dwellSegment.getSensorOrientationHeading());
        assertNull(dwellSegment.getSensorOrientationPitch());
        assertNull(dwellSegment.getSensorOrientationRoll());
        assertNull(dwellSegment.getMinimumDetectableVelocity());
        assertEquals(dwellSegment.getTargets().size(), 0);
    }

    private void checkPacket193(Packet packet) {
        PacketHeader packetHeader = packet.getPacketHeader();
        assertEquals(packetHeader.getVersionId(), "30");
        assertEquals(packetHeader.getPacketSize(), 134);
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
        assertEquals(
                (double) dwellSegment.getScaleFactorLatScale(), 4.882458597421646e-5, 0.0000001);
        assertEquals(
                (double) dwellSegment.getScaleFactorLonScale(), 4.886649549007416e-5, 0.0000001);
        assertNull(dwellSegment.getSensorPositionUncertaintyAlongTrack());
        assertNull(dwellSegment.getSensorPositionUncertaintyCrossTrack());
        assertNull(dwellSegment.getSensorPositionUncertaintyAltitude());
        assertEquals(dwellSegment.getSensorTrack(), 317.3291015625, 0.0000001);
        assertEquals((int) dwellSegment.getSensorSpeed(), 72021);
        assertEquals((int) dwellSegment.getSensorVerticalVelocity(), -2);
        assertNull(dwellSegment.getSensorTrackUncertainty());
        assertNull(dwellSegment.getSensorSpeedUncertainty());
        assertNull(dwellSegment.getSensorVerticalVelocityUncertainty());
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
        assertNull(dwellSegment.getSensorOrientationHeading());
        assertNull(dwellSegment.getSensorOrientationPitch());
        assertNull(dwellSegment.getSensorOrientationRoll());
        assertNull(dwellSegment.getMinimumDetectableVelocity());
        assertEquals(dwellSegment.getTargets().size(), 3);
        TargetReport target1 = dwellSegment.getTargets().get(0);
        assertEquals((int) target1.getMtiReportIndex(), 0);
        assertNull(target1.getTargetLocationLatitude());
        assertNull(target1.getTargetLocationLongitude());
        assertEquals((int) target1.getTargetLocationDeltaLatitude(), 54);
        assertEquals((int) target1.getTargetLocationDeltaLongitude(), 268);
        assertNull(target1.getTargetLocationGeodeticHeight());
        assertNull(target1.getTargetVelocityLineOfSightComponent());
        assertNull(target1.getTargetWrapVelocity());
        assertNull(target1.getTargetSNR());
        assertNull(target1.getTargetClassification());
        assertEquals(target1.getTargetClassificationAsText(), "[Not Provided]");
        assertNull(target1.getTargetClassificationProbability());
        assertNull(target1.getTargetMeasurementUncertaintySlantRange());
        assertNull(target1.getTargetMeasurementUncertaintyCrossRange());
        assertNull(target1.getTargetMeasurementUncertaintyHeight());
        assertNull(target1.getTargetMeasurementUncertaintyRadialVelocity());
        assertEquals((int) target1.getTruthTagApplication(), 1);
        assertEquals((long) target1.getTruthTagEntity(), 1);
        assertNull(target1.getTargetRadarCrossSection());
        TargetReport target2 = dwellSegment.getTargets().get(1);
        assertEquals((int) target2.getMtiReportIndex(), 1);
        assertNull(target2.getTargetLocationLatitude());
        assertNull(target2.getTargetLocationLongitude());
        assertEquals((int) target2.getTargetLocationDeltaLatitude(), 263);
        assertEquals((int) target2.getTargetLocationDeltaLongitude(), 273);
        assertNull(target2.getTargetLocationGeodeticHeight());
        assertNull(target2.getTargetVelocityLineOfSightComponent());
        assertNull(target2.getTargetWrapVelocity());
        assertNull(target2.getTargetSNR());
        assertNull(target2.getTargetClassification());
        assertEquals(target2.getTargetClassificationAsText(), "[Not Provided]");
        assertNull(target2.getTargetClassificationProbability());
        assertNull(target2.getTargetMeasurementUncertaintySlantRange());
        assertNull(target2.getTargetMeasurementUncertaintyCrossRange());
        assertNull(target2.getTargetMeasurementUncertaintyHeight());
        assertNull(target2.getTargetMeasurementUncertaintyRadialVelocity());
        assertEquals((int) target2.getTruthTagApplication(), 1);
        assertEquals((long) target2.getTruthTagEntity(), 4);
        assertNull(target2.getTargetRadarCrossSection());
        TargetReport target3 = dwellSegment.getTargets().get(2);
        assertEquals((int) target3.getMtiReportIndex(), 2);
        assertNull(target3.getTargetLocationLatitude());
        assertNull(target3.getTargetLocationLongitude());
        assertEquals((int) target3.getTargetLocationDeltaLatitude(), -48);
        assertEquals((int) target3.getTargetLocationDeltaLongitude(), 268);
        assertNull(target3.getTargetLocationGeodeticHeight());
        assertNull(target3.getTargetVelocityLineOfSightComponent());
        assertNull(target3.getTargetWrapVelocity());
        assertNull(target3.getTargetSNR());
        assertNull(target3.getTargetClassification());
        assertEquals(target3.getTargetClassificationAsText(), "[Not Provided]");
        assertNull(target3.getTargetClassificationProbability());
        assertNull(target3.getTargetMeasurementUncertaintySlantRange());
        assertNull(target3.getTargetMeasurementUncertaintyCrossRange());
        assertNull(target3.getTargetMeasurementUncertaintyHeight());
        assertNull(target3.getTargetMeasurementUncertaintyRadialVelocity());
        assertEquals((int) target3.getTruthTagApplication(), 1);
        assertEquals((long) target3.getTruthTagEntity(), 10);
        assertNull(target3.getTargetRadarCrossSection());
    }
}
