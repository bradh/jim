package net.frogmouth.rnd.jim.s4607.DwellSegment;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.Segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;

public class DwellSegmentSerialiser extends AbstractSegmentSerialiser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.DwellSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationText) {
        DwellSegment dwell = (DwellSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(getExistenceMask(dwell));
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
        if (dwell.getSensorVerticalVelocityUncertainty() != null) {
            baos.writeBytes(writeI8(dwell.getSensorVerticalVelocityUncertainty()));
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
        if (dwell.getMinimumDetectableVelocity() != null) {
            baos.writeBytes(writeI8(dwell.getMinimumDetectableVelocity()));
        }
        for (Target target : dwell.getTargets()) {
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

    private static byte[] getExistenceMask(DwellSegment dwell) {
        // TODO: build properly
        return new byte[] {
            (byte) 0xFF, 0x00, 0x03, (byte) 0xC3, (byte) 0x9f, (byte) 0xFF, 0x00, 0x00
        };
    }
}
