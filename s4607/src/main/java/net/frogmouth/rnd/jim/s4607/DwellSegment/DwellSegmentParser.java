package net.frogmouth.rnd.jim.s4607.DwellSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class DwellSegmentParser extends SegmentParser {

    public DwellSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.DwellSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        DwellSegment dwellSegment = new DwellSegment();
        long existenceMask = context.readFL64();
        if ((existenceMask & DwellSegmentConstants.D2_EXISTENCE_MASK)
                == DwellSegmentConstants.D2_EXISTENCE_MASK) {
            dwellSegment.setRevisitIndex(context.readI16());
        }
        if ((existenceMask & DwellSegmentConstants.D3_EXISTENCE_MASK)
                == DwellSegmentConstants.D3_EXISTENCE_MASK) {
            dwellSegment.setDwellIndex(context.readI16());
        }
        if ((existenceMask & DwellSegmentConstants.D4_EXISTENCE_MASK)
                == DwellSegmentConstants.D4_EXISTENCE_MASK) {
            dwellSegment.setLastDwellOfRevisit(context.readFL8() == 0x01);
        }
        if ((existenceMask & DwellSegmentConstants.D5_EXISTENCE_MASK)
                == DwellSegmentConstants.D5_EXISTENCE_MASK) {
            dwellSegment.setTargetReportCount(context.readI16());
        }
        if ((existenceMask & DwellSegmentConstants.D6_EXISTENCE_MASK)
                == DwellSegmentConstants.D6_EXISTENCE_MASK) {
            dwellSegment.setDwellTime(context.readI32());
        }
        if ((existenceMask & DwellSegmentConstants.D7_EXISTENCE_MASK)
                == DwellSegmentConstants.D7_EXISTENCE_MASK) {
            dwellSegment.setSensorLatitude(context.readSA32());
        }
        if ((existenceMask & DwellSegmentConstants.D8_EXISTENCE_MASK)
                == DwellSegmentConstants.D8_EXISTENCE_MASK) {
            dwellSegment.setSensorLongitude(context.readBA32());
        }
        if ((existenceMask & DwellSegmentConstants.D9_EXISTENCE_MASK)
                == DwellSegmentConstants.D9_EXISTENCE_MASK) {
            dwellSegment.setSensorAltitude(context.readS32());
        }
        if ((existenceMask & DwellSegmentConstants.D10_EXISTENCE_MASK)
                == DwellSegmentConstants.D10_EXISTENCE_MASK) {
            dwellSegment.setScaleFactorLatScale(context.readSA32());
        }
        if ((existenceMask & DwellSegmentConstants.D11_EXISTENCE_MASK)
                == DwellSegmentConstants.D11_EXISTENCE_MASK) {
            dwellSegment.setScaleFactorLonScale(context.readBA32());
        }
        if ((existenceMask & DwellSegmentConstants.D12_EXISTENCE_MASK)
                == DwellSegmentConstants.D12_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyAlongTrack((int) context.readI32());
        }
        if ((existenceMask & DwellSegmentConstants.D13_EXISTENCE_MASK)
                == DwellSegmentConstants.D13_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyCrossTrack((int) context.readI32());
        }
        if ((existenceMask & DwellSegmentConstants.D14_EXISTENCE_MASK)
                == DwellSegmentConstants.D14_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyAltitude(context.readI16());
        }
        if ((existenceMask & DwellSegmentConstants.D15_EXISTENCE_MASK)
                == DwellSegmentConstants.D15_EXISTENCE_MASK) {
            dwellSegment.setSensorTrack(context.readBA16());
        }
        if ((existenceMask & DwellSegmentConstants.D16_EXISTENCE_MASK)
                == DwellSegmentConstants.D16_EXISTENCE_MASK) {
            dwellSegment.setSensorSpeed((int) context.readI32());
        }
        if ((existenceMask & DwellSegmentConstants.D17_EXISTENCE_MASK)
                == DwellSegmentConstants.D17_EXISTENCE_MASK) {
            dwellSegment.setSensorVerticalVelocity(context.readS8());
        }
        if ((existenceMask & DwellSegmentConstants.D18_EXISTENCE_MASK)
                == DwellSegmentConstants.D18_EXISTENCE_MASK) {
            dwellSegment.setSensorTrackUncertainty(context.readI8());
        }
        if ((existenceMask & DwellSegmentConstants.D19_EXISTENCE_MASK)
                == DwellSegmentConstants.D19_EXISTENCE_MASK) {
            dwellSegment.setSensorSpeedUncertainty(context.readI16());
        }
        if ((existenceMask & DwellSegmentConstants.D20_EXISTENCE_MASK)
                == DwellSegmentConstants.D20_EXISTENCE_MASK) {
            dwellSegment.setSensorVerticalVelocityUncertainty(context.readI16());
        }
        if ((existenceMask & DwellSegmentConstants.D21_EXISTENCE_MASK)
                == DwellSegmentConstants.D21_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationHeading(context.readBA16());
        }
        if ((existenceMask & DwellSegmentConstants.D22_EXISTENCE_MASK)
                == DwellSegmentConstants.D22_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationPitch(context.readSA16());
        }
        if ((existenceMask & DwellSegmentConstants.D23_EXISTENCE_MASK)
                == DwellSegmentConstants.D23_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationRoll(context.readSA16());
        }
        if ((existenceMask & DwellSegmentConstants.D24_EXISTENCE_MASK)
                == DwellSegmentConstants.D24_EXISTENCE_MASK) {
            dwellSegment.setDwellCentreLatitude(context.readSA32());
        }
        if ((existenceMask & DwellSegmentConstants.D25_EXISTENCE_MASK)
                == DwellSegmentConstants.D25_EXISTENCE_MASK) {
            dwellSegment.setDwellCentreLongitude(context.readBA32());
        }
        if ((existenceMask & DwellSegmentConstants.D26_EXISTENCE_MASK)
                == DwellSegmentConstants.D26_EXISTENCE_MASK) {
            dwellSegment.setDwellAreaRangeHalfExtent(context.readB16());
        }
        if ((existenceMask & DwellSegmentConstants.D27_EXISTENCE_MASK)
                == DwellSegmentConstants.D27_EXISTENCE_MASK) {
            dwellSegment.setDwellAreaDwellAngleHalfExtent(context.readBA16());
        }
        if ((existenceMask & DwellSegmentConstants.D28_EXISTENCE_MASK)
                == DwellSegmentConstants.D28_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationHeading(context.readBA16());
        }
        if ((existenceMask & DwellSegmentConstants.D29_EXISTENCE_MASK)
                == DwellSegmentConstants.D29_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationPitch(context.readSA16());
        }
        if ((existenceMask & DwellSegmentConstants.D30_EXISTENCE_MASK)
                == DwellSegmentConstants.D30_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationRoll(context.readSA16());
        }
        if ((existenceMask & DwellSegmentConstants.D31_EXISTENCE_MASK)
                == DwellSegmentConstants.D31_EXISTENCE_MASK) {
            dwellSegment.setMinimumDetectableVelocity(context.readI8());
        }
        for (int i = 0; i < dwellSegment.getTargetReportCount(); i++) {
            Target target = new Target();
            if ((existenceMask & DwellSegmentConstants.D32_1_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_1_EXISTENCE_MASK) {
                target.setMtiReportIndex(context.readI16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_2_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_2_EXISTENCE_MASK) {
                target.setTargetLocationLatitude(context.readSA32());
            }
            if ((existenceMask & DwellSegmentConstants.D32_3_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_3_EXISTENCE_MASK) {
                target.setTargetLocationLongitude(context.readBA32());
            }
            if ((existenceMask & DwellSegmentConstants.D32_4_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_4_EXISTENCE_MASK) {
                target.setTargetLocationDeltaLatitude(context.readS16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_5_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_5_EXISTENCE_MASK) {
                target.setTargetLocationDeltaLongitude(context.readS16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_6_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_6_EXISTENCE_MASK) {
                target.setTargetLocationGeodeticHeight(context.readS16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_7_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_7_EXISTENCE_MASK) {
                target.setTargetVelocityLineOfSightComponent(context.readS16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_8_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_8_EXISTENCE_MASK) {
                target.setTargetWrapVelocity(context.readI16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_9_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_9_EXISTENCE_MASK) {
                target.setTargetSNR(context.readS8());
            }
            if ((existenceMask & DwellSegmentConstants.D32_10_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_10_EXISTENCE_MASK) {
                target.setTargetClassification(context.readE8());
            }
            if ((existenceMask & DwellSegmentConstants.D32_11_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_11_EXISTENCE_MASK) {
                target.setTargetClassificationProbability(context.readI8());
            }
            if ((existenceMask & DwellSegmentConstants.D32_12_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_12_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintySlantRange(context.readI16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_13_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_13_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyCrossRange(context.readI16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_14_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_14_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyHeight(context.readI8());
            }
            if ((existenceMask & DwellSegmentConstants.D32_15_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_15_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyRadialVelocity(context.readI16());
            }
            if ((existenceMask & DwellSegmentConstants.D32_16_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_16_EXISTENCE_MASK) {
                target.setTruthTagApplication(context.readI8());
            }
            if ((existenceMask & DwellSegmentConstants.D32_17_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_17_EXISTENCE_MASK) {
                target.setTruthTagEntity(context.readI32());
            }
            if ((existenceMask & DwellSegmentConstants.D32_18_EXISTENCE_MASK)
                    == DwellSegmentConstants.D32_18_EXISTENCE_MASK) {
                target.setTargetRadarCrossSection(context.readS8());
            }
            dwellSegment.addTarget(target);
        }
        return dwellSegment;
    }
}
