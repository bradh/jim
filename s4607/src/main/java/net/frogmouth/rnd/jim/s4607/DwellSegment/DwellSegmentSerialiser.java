package net.frogmouth.rnd.jim.s4607.DwellSegment;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

/**
 * Serialiser for {@link DwellSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class DwellSegmentSerialiser extends AbstractSegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.DwellSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationText) {
        DwellSegment dwell = (DwellSegment) segment;
        dwell.setTargetReportCount(dwell.getTargets().size());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(getExistenceMask(dwell, serialisationText));
        if (dwell.getRevisitIndex() != null) {
            baos.writeBytes(writeI16(dwell.getRevisitIndex()));
        }
        if (dwell.getDwellIndex() != null) {
            baos.writeBytes(writeI16(dwell.getDwellIndex()));
        }
        if (dwell.getLastDwellOfRevisit() != null) {
            baos.writeBytes(writeFL8(dwell.getLastDwellOfRevisit()));
        }
        if (dwell.getTargetReportCount() != null) {
            baos.writeBytes(writeI16(dwell.getTargetReportCount()));
        }
        if (dwell.getDwellTime() != null) {
            baos.writeBytes(writeI32(dwell.getDwellTime()));
        }
        baos.writeBytes(writeSA32(dwell.getSensorLatitude()));
        baos.writeBytes(writeBA32(dwell.getSensorLongitude()));
        baos.writeBytes(writeS32(dwell.getSensorAltitude()));
        if (dwell.getScaleFactorLatScale() != null) {
            baos.writeBytes(writeSA32(dwell.getScaleFactorLatScale()));
        }
        if (dwell.getScaleFactorLonScale() != null) {
            baos.writeBytes(writeBA32(dwell.getScaleFactorLonScale()));
        }
        if (dwell.getSensorPositionUncertaintyAlongTrack() != null) {
            baos.writeBytes(writeI32(dwell.getSensorPositionUncertaintyAlongTrack()));
        }
        if (dwell.getSensorPositionUncertaintyCrossTrack() != null) {
            baos.writeBytes(writeI32(dwell.getSensorPositionUncertaintyCrossTrack()));
        }
        if (dwell.getSensorPositionUncertaintyAltitude() != null) {
            baos.writeBytes(writeI16(dwell.getSensorPositionUncertaintyAltitude()));
        }
        if (dwell.getSensorTrack() != null) {
            baos.writeBytes(writeBA16(dwell.getSensorTrack()));
        }
        if (dwell.getSensorSpeed() != null) {
            baos.writeBytes(writeI32(dwell.getSensorSpeed()));
        }
        if (dwell.getSensorVerticalVelocity() != null) {
            baos.writeBytes(writeS8(dwell.getSensorVerticalVelocity()));
        }
        if (dwell.getSensorTrackUncertainty() != null) {
            baos.writeBytes(writeI8(dwell.getSensorTrackUncertainty()));
        }
        if (dwell.getSensorSpeedUncertainty() != null) {
            baos.writeBytes(writeI16(dwell.getSensorSpeedUncertainty()));
        }
        if (dwell.getSensorVerticalVelocityUncertainty() != null) {
            baos.writeBytes(writeI16(dwell.getSensorVerticalVelocityUncertainty()));
        }
        if (dwell.getPlatformOrientationHeading() != null) {
            baos.writeBytes(writeBA16(dwell.getPlatformOrientationHeading()));
        }
        if (dwell.getPlatformOrientationPitch() != null) {
            baos.writeBytes(writeSA16(dwell.getPlatformOrientationPitch()));
        }
        if (dwell.getPlatformOrientationRoll() != null) {
            baos.writeBytes(writeSA16(dwell.getPlatformOrientationRoll()));
        }
        baos.writeBytes(writeSA32(dwell.getDwellCentreLatitude()));
        baos.writeBytes(writeBA32(dwell.getDwellCentreLongitude()));
        baos.writeBytes(writeB16(dwell.getDwellAreaRangeHalfExtent()));
        baos.writeBytes(writeBA16(dwell.getDwellAreaDwellAngleHalfExtent()));
        if (dwell.getSensorOrientationHeading() != null) {
            baos.writeBytes(writeBA16(dwell.getSensorOrientationHeading()));
        }
        if (dwell.getSensorOrientationPitch() != null) {
            baos.writeBytes(writeSA16(dwell.getSensorOrientationPitch()));
        }
        if (dwell.getSensorOrientationRoll() != null) {
            baos.writeBytes(writeSA16(dwell.getSensorOrientationRoll()));
        }
        if (dwell.getMinimumDetectableVelocity() != null) {
            baos.writeBytes(writeI8(dwell.getMinimumDetectableVelocity()));
        }
        for (TargetReport target : dwell.getTargets()) {
            if (target.getMtiReportIndex() != null) {
                baos.writeBytes(writeI16(target.getMtiReportIndex()));
            }
            if (target.getTargetLocationLatitude() != null) {
                baos.writeBytes(writeSA32(target.getTargetLocationLatitude()));
            }
            if (target.getTargetLocationLongitude() != null) {
                baos.writeBytes(writeBA32(target.getTargetLocationLongitude()));
            }
            if (target.getTargetLocationDeltaLatitude() != null) {
                baos.writeBytes(writeS16(target.getTargetLocationDeltaLatitude()));
            }
            if (target.getTargetLocationDeltaLongitude() != null) {
                baos.writeBytes(writeS16(target.getTargetLocationDeltaLongitude()));
            }
            if (target.getTargetLocationGeodeticHeight() != null) {
                baos.writeBytes(writeS16(target.getTargetLocationGeodeticHeight()));
            }
            if (target.getTargetVelocityLineOfSightComponent() != null) {
                baos.writeBytes(writeS16(target.getTargetVelocityLineOfSightComponent()));
            }
            if (target.getTargetWrapVelocity() != null) {
                baos.writeBytes(writeI16(target.getTargetWrapVelocity()));
            }
            if (target.getTargetSNR() != null) {
                baos.writeBytes(writeS8(target.getTargetSNR()));
            }
            if (target.getTargetClassification() != null) {
                baos.writeBytes(writeE8(target.getTargetClassification()));
            }
            if (target.getTargetClassificationProbability() != null) {
                baos.writeBytes(writeI8(target.getTargetClassificationProbability()));
            }
            if (target.getTargetMeasurementUncertaintySlantRange() != null) {
                baos.writeBytes(writeI16(target.getTargetMeasurementUncertaintySlantRange()));
            }
            if (target.getTargetMeasurementUncertaintyCrossRange() != null) {
                baos.writeBytes(writeI16(target.getTargetMeasurementUncertaintyCrossRange()));
            }
            if (target.getTargetMeasurementUncertaintyHeight() != null) {
                baos.writeBytes(writeI8(target.getTargetMeasurementUncertaintyHeight()));
            }
            if (target.getTargetMeasurementUncertaintyRadialVelocity() != null) {
                baos.writeBytes(writeI16(target.getTargetMeasurementUncertaintyRadialVelocity()));
            }
            if (target.getTruthTagApplication() != null) {
                baos.writeBytes(writeI8(target.getTruthTagApplication()));
            }
            if (target.getTruthTagEntity() != null) {
                baos.writeBytes(writeI32(target.getTruthTagEntity()));
            }
            if (target.getTargetRadarCrossSection() != null) {
                baos.writeBytes(writeS8(target.getTargetRadarCrossSection()));
            }
        }
        return baos.toByteArray();
    }

    private static byte[] getExistenceMask(
            DwellSegment dwell, SerialisationContext serialisationContext) {
        long mask = 0;
        if (dwell.getRevisitIndex() != null) {
            mask |= DwellSegmentConstants.D2_EXISTENCE_MASK;
        }
        if (dwell.getDwellIndex() != null) {
            mask |= DwellSegmentConstants.D3_EXISTENCE_MASK;
        }
        if (dwell.getLastDwellOfRevisit() != null) {
            mask |= DwellSegmentConstants.D4_EXISTENCE_MASK;
        }
        if (dwell.getTargetReportCount() != null) {
            mask |= DwellSegmentConstants.D5_EXISTENCE_MASK;
        }
        if (dwell.getDwellTime() != null) {
            mask |= DwellSegmentConstants.D6_EXISTENCE_MASK;
        }
        // Sensor position latitude, longitude, altitude - mandatory
        mask |= DwellSegmentConstants.D7_EXISTENCE_MASK;
        mask |= DwellSegmentConstants.D8_EXISTENCE_MASK;
        mask |= DwellSegmentConstants.D9_EXISTENCE_MASK;
        if (dwell.getScaleFactorLatScale() != null) {
            mask |= DwellSegmentConstants.D10_EXISTENCE_MASK;
        }
        if (dwell.getScaleFactorLonScale() != null) {
            mask |= DwellSegmentConstants.D11_EXISTENCE_MASK;
        }
        if (dwell.getSensorPositionUncertaintyAlongTrack() != null) {
            mask |= DwellSegmentConstants.D12_EXISTENCE_MASK;
        }
        if (dwell.getSensorPositionUncertaintyCrossTrack() != null) {
            mask |= DwellSegmentConstants.D13_EXISTENCE_MASK;
        }
        if (dwell.getSensorPositionUncertaintyAltitude() != null) {
            mask |= DwellSegmentConstants.D14_EXISTENCE_MASK;
        }
        if (dwell.getSensorTrack() != null) {
            mask |= DwellSegmentConstants.D15_EXISTENCE_MASK;
        }
        if (dwell.getSensorSpeed() != null) {
            mask |= DwellSegmentConstants.D16_EXISTENCE_MASK;
        }
        if (dwell.getSensorVerticalVelocity() != null) {
            mask |= DwellSegmentConstants.D17_EXISTENCE_MASK;
        }
        if (dwell.getSensorTrackUncertainty() != null) {
            mask |= DwellSegmentConstants.D18_EXISTENCE_MASK;
        }
        if (dwell.getSensorSpeedUncertainty() != null) {
            mask |= DwellSegmentConstants.D19_EXISTENCE_MASK;
        }
        if (dwell.getSensorVerticalVelocityUncertainty() != null) {
            mask |= DwellSegmentConstants.D20_EXISTENCE_MASK;
        }
        if (dwell.getPlatformOrientationHeading() != null) {
            mask |= DwellSegmentConstants.D21_EXISTENCE_MASK;
        }
        if (dwell.getPlatformOrientationPitch() != null) {
            mask |= DwellSegmentConstants.D22_EXISTENCE_MASK;
        }
        if (dwell.getPlatformOrientationRoll() != null) {
            mask |= DwellSegmentConstants.D23_EXISTENCE_MASK;
        }
        // Dwell area centre lat / centre lon, range half-extent, angle half-extent
        mask |= DwellSegmentConstants.D24_EXISTENCE_MASK;
        mask |= DwellSegmentConstants.D25_EXISTENCE_MASK;
        mask |= DwellSegmentConstants.D26_EXISTENCE_MASK;
        mask |= DwellSegmentConstants.D27_EXISTENCE_MASK;
        if (dwell.getSensorOrientationHeading() != null) {
            mask |= DwellSegmentConstants.D28_EXISTENCE_MASK;
        }
        if (dwell.getSensorOrientationPitch() != null) {
            mask |= DwellSegmentConstants.D29_EXISTENCE_MASK;
        }
        if (dwell.getSensorOrientationRoll() != null) {
            mask |= DwellSegmentConstants.D30_EXISTENCE_MASK;
        }
        if (dwell.getMinimumDetectableVelocity() != null) {
            mask |= DwellSegmentConstants.D31_EXISTENCE_MASK;
        }
        if (!dwell.getTargets().isEmpty()) {
            TargetReport target = dwell.getTargets().get(0);
            if (target.getMtiReportIndex() != null) {
                mask |= DwellSegmentConstants.D32_1_EXISTENCE_MASK;
            }
            if (target.getTargetLocationLatitude() != null) {
                mask |= DwellSegmentConstants.D32_2_EXISTENCE_MASK;
            }
            if (target.getTargetLocationLongitude() != null) {
                mask |= DwellSegmentConstants.D32_3_EXISTENCE_MASK;
            }
            if (target.getTargetLocationDeltaLatitude() != null) {
                mask |= DwellSegmentConstants.D32_4_EXISTENCE_MASK;
            }
            if (target.getTargetLocationDeltaLongitude() != null) {
                mask |= DwellSegmentConstants.D32_5_EXISTENCE_MASK;
            }
            if (target.getTargetLocationGeodeticHeight() != null) {
                mask |= DwellSegmentConstants.D32_6_EXISTENCE_MASK;
            }
            if (target.getTargetVelocityLineOfSightComponent() != null) {
                mask |= DwellSegmentConstants.D32_7_EXISTENCE_MASK;
            }
            if (target.getTargetWrapVelocity() != null) {
                mask |= DwellSegmentConstants.D32_8_EXISTENCE_MASK;
            }
            if (target.getTargetSNR() != null) {
                mask |= DwellSegmentConstants.D32_9_EXISTENCE_MASK;
            }
            if (target.getTargetClassification() != null) {
                mask |= DwellSegmentConstants.D32_10_EXISTENCE_MASK;
            }
            if (target.getTargetClassificationProbability() != null) {
                mask |= DwellSegmentConstants.D32_11_EXISTENCE_MASK;
            }
            if (target.getTargetMeasurementUncertaintySlantRange() != null) {
                mask |= DwellSegmentConstants.D32_12_EXISTENCE_MASK;
            }
            if (target.getTargetMeasurementUncertaintyCrossRange() != null) {
                mask |= DwellSegmentConstants.D32_13_EXISTENCE_MASK;
            }
            if (target.getTargetMeasurementUncertaintyHeight() != null) {
                mask |= DwellSegmentConstants.D32_14_EXISTENCE_MASK;
            }
            if (target.getTargetMeasurementUncertaintyRadialVelocity() != null) {
                mask |= DwellSegmentConstants.D32_15_EXISTENCE_MASK;
            }
            if (target.getTruthTagApplication() != null) {
                mask |= DwellSegmentConstants.D32_16_EXISTENCE_MASK;
            }
            if (target.getTruthTagEntity() != null) {
                mask |= DwellSegmentConstants.D32_17_EXISTENCE_MASK;
            }
            if (target.getTargetRadarCrossSection() != null) {
                mask |= DwellSegmentConstants.D32_18_EXISTENCE_MASK;
            }
        } else {
            // These apparently random selections are chosen to match the AFRL test data.
            if (serialisationContext.isUseSAProfileForEmptyDwellTargetMask()) {
                mask |= DwellSegmentConstants.D32_1_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_4_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_5_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_16_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_17_EXISTENCE_MASK;
            } else {
                mask |= DwellSegmentConstants.D32_1_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_2_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_3_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_6_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_7_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_8_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_9_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_10_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_11_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_12_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_13_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_14_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_15_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_16_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_17_EXISTENCE_MASK;
                mask |= DwellSegmentConstants.D32_18_EXISTENCE_MASK;
            }
        }
        ByteBuffer bb = ByteBuffer.allocate(Long.BYTES);
        bb.putLong(mask);

        return bb.array();
    }
}
