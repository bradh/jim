package net.frogmouth.rnd.jim.s4607.DwellSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class DwellSegmentParser extends SegmentParser {

    private static final long D2_EXISTENCE_MASK = 0x8000000000000000L;
    private static final long D3_EXISTENCE_MASK = 0x4000000000000000L;
    private static final long D4_EXISTENCE_MASK = 0x2000000000000000L;
    private static final long D5_EXISTENCE_MASK = 0x1000000000000000L;
    private static final long D6_EXISTENCE_MASK = 0x800000000000000L;
    private static final long D7_EXISTENCE_MASK = 0x400000000000000L;
    private static final long D8_EXISTENCE_MASK = 0x200000000000000L;
    private static final long D9_EXISTENCE_MASK = 0x100000000000000L;
    private static final long D10_EXISTENCE_MASK = 0x80000000000000L;
    private static final long D11_EXISTENCE_MASK = 0x40000000000000L;
    private static final long D12_EXISTENCE_MASK = 0x20000000000000L;
    private static final long D13_EXISTENCE_MASK = 0x10000000000000L;
    private static final long D14_EXISTENCE_MASK = 0x8000000000000L;
    private static final long D15_EXISTENCE_MASK = 0x4000000000000L;
    private static final long D16_EXISTENCE_MASK = 0x2000000000000L;
    private static final long D17_EXISTENCE_MASK = 0x1000000000000L;
    private static final long D18_EXISTENCE_MASK = 0x800000000000L;
    private static final long D19_EXISTENCE_MASK = 0x400000000000L;
    private static final long D20_EXISTENCE_MASK = 0x200000000000L;
    private static final long D21_EXISTENCE_MASK = 0x100000000000L;
    private static final long D22_EXISTENCE_MASK = 0x80000000000L;
    private static final long D23_EXISTENCE_MASK = 0x40000000000L;
    private static final long D24_EXISTENCE_MASK = 0x20000000000L;
    private static final long D25_EXISTENCE_MASK = 0x10000000000L;
    private static final long D26_EXISTENCE_MASK = 0x8000000000L;
    private static final long D27_EXISTENCE_MASK = 0x4000000000L;
    private static final long D28_EXISTENCE_MASK = 0x2000000000L;
    private static final long D29_EXISTENCE_MASK = 0x1000000000L;
    private static final long D30_EXISTENCE_MASK = 0x800000000L;
    private static final long D31_EXISTENCE_MASK = 0x400000000L;
    private static final long D32_1_EXISTENCE_MASK = 0x200000000L;
    private static final long D32_2_EXISTENCE_MASK = 0x100000000L;
    private static final long D32_3_EXISTENCE_MASK = 0x80000000L;
    private static final long D32_4_EXISTENCE_MASK = 0x40000000L;
    private static final long D32_5_EXISTENCE_MASK = 0x20000000L;
    private static final long D32_6_EXISTENCE_MASK = 0x10000000L;
    private static final long D32_7_EXISTENCE_MASK = 0x8000000L;
    private static final long D32_8_EXISTENCE_MASK = 0x4000000L;
    private static final long D32_9_EXISTENCE_MASK = 0x2000000L;
    private static final long D32_10_EXISTENCE_MASK = 0x1000000L;
    private static final long D32_11_EXISTENCE_MASK = 0x800000L;
    private static final long D32_12_EXISTENCE_MASK = 0x400000L;
    private static final long D32_13_EXISTENCE_MASK = 0x200000L;
    private static final long D32_14_EXISTENCE_MASK = 0x100000L;
    private static final long D32_15_EXISTENCE_MASK = 0x80000L;
    private static final long D32_16_EXISTENCE_MASK = 0x40000L;
    private static final long D32_17_EXISTENCE_MASK = 0x20000L;
    private static final long D32_18_EXISTENCE_MASK = 0x10000L;

    public DwellSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.DwellSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        DwellSegment dwellSegment = new DwellSegment(segmentHeader);
        long existenceMask = context.readFL64();
        if ((existenceMask & D2_EXISTENCE_MASK) == D2_EXISTENCE_MASK) {
            dwellSegment.setRevisitIndex(context.readI16());
        }
        if ((existenceMask & D3_EXISTENCE_MASK) == D3_EXISTENCE_MASK) {
            dwellSegment.setDwellIndex(context.readI16());
        }
        if ((existenceMask & D4_EXISTENCE_MASK) == D4_EXISTENCE_MASK) {
            dwellSegment.setLastDwellOfRevisit(context.readFL8() == 0x01);
        }
        if ((existenceMask & D5_EXISTENCE_MASK) == D5_EXISTENCE_MASK) {
            dwellSegment.setTargetReportCount(context.readI16());
        }
        if ((existenceMask & D6_EXISTENCE_MASK) == D6_EXISTENCE_MASK) {
            dwellSegment.setDwellTime(context.readI32());
        }
        if ((existenceMask & D7_EXISTENCE_MASK) == D7_EXISTENCE_MASK) {
            dwellSegment.setSensorLatitude(context.readSA32());
        }
        if ((existenceMask & D8_EXISTENCE_MASK) == D8_EXISTENCE_MASK) {
            dwellSegment.setSensorLongitude(context.readBA32());
        }
        if ((existenceMask & D9_EXISTENCE_MASK) == D9_EXISTENCE_MASK) {
            dwellSegment.setSensorAltitude(context.readS32());
        }
        if ((existenceMask & D10_EXISTENCE_MASK) == D10_EXISTENCE_MASK) {
            dwellSegment.setScaleFactorLatScale(context.readSA32());
        }
        if ((existenceMask & D11_EXISTENCE_MASK) == D11_EXISTENCE_MASK) {
            dwellSegment.setScaleFactorLonScale(context.readBA32());
        }
        if ((existenceMask & D12_EXISTENCE_MASK) == D12_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyAlongTrack((int) context.readI32());
        }
        if ((existenceMask & D13_EXISTENCE_MASK) == D13_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyCrossTrack((int) context.readI32());
        }
        if ((existenceMask & D14_EXISTENCE_MASK) == D14_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyAltitude(context.readI16());
        }
        if ((existenceMask & D15_EXISTENCE_MASK) == D15_EXISTENCE_MASK) {
            dwellSegment.setSensorTrack(context.readBA16());
        }
        if ((existenceMask & D16_EXISTENCE_MASK) == D16_EXISTENCE_MASK) {
            dwellSegment.setSensorSpeed((int) context.readI32());
        }
        if ((existenceMask & D17_EXISTENCE_MASK) == D17_EXISTENCE_MASK) {
            dwellSegment.setSensorVerticalVelocity(context.readS8());
        }
        if ((existenceMask & D18_EXISTENCE_MASK) == D18_EXISTENCE_MASK) {
            dwellSegment.setSensorTrackUncertainty(context.readI8());
        }
        if ((existenceMask & D19_EXISTENCE_MASK) == D19_EXISTENCE_MASK) {
            dwellSegment.setSensorSpeedUncertainty(context.readI16());
        }
        if ((existenceMask & D20_EXISTENCE_MASK) == D20_EXISTENCE_MASK) {
            dwellSegment.setSensorVerticalVelocityUncertainty(context.readI16());
        }
        if ((existenceMask & D21_EXISTENCE_MASK) == D21_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationHeading(context.readBA16());
        }
        if ((existenceMask & D22_EXISTENCE_MASK) == D22_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationPitch(context.readSA16());
        }
        if ((existenceMask & D23_EXISTENCE_MASK) == D23_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationRoll(context.readSA16());
        }
        if ((existenceMask & D24_EXISTENCE_MASK) == D24_EXISTENCE_MASK) {
            dwellSegment.setDwellCentreLatitude(context.readSA32());
        }
        if ((existenceMask & D25_EXISTENCE_MASK) == D25_EXISTENCE_MASK) {
            dwellSegment.setDwellCentreLongitude(context.readBA32());
        }
        if ((existenceMask & D26_EXISTENCE_MASK) == D26_EXISTENCE_MASK) {
            dwellSegment.setDwellAreaRangeHalfExtent(context.readB16());
        }
        if ((existenceMask & D27_EXISTENCE_MASK) == D27_EXISTENCE_MASK) {
            dwellSegment.setDwellAreaDwellAngleHalfExtent(context.readBA16());
        }
        if ((existenceMask & D28_EXISTENCE_MASK) == D28_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationHeading(context.readBA16());
        }
        if ((existenceMask & D29_EXISTENCE_MASK) == D29_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationPitch(context.readSA16());
        }
        if ((existenceMask & D30_EXISTENCE_MASK) == D30_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationRoll(context.readSA16());
        }
        if ((existenceMask & D31_EXISTENCE_MASK) == D31_EXISTENCE_MASK) {
            dwellSegment.setMinimumDetectableVelocity(context.readI8());
        }
        for (int i = 0; i < dwellSegment.getTargetReportCount(); i++) {
            Target target = new Target();
            if ((existenceMask & D32_1_EXISTENCE_MASK) == D32_1_EXISTENCE_MASK) {
                target.setMtiReportIndex(context.readI16());
            }
            if ((existenceMask & D32_2_EXISTENCE_MASK) == D32_2_EXISTENCE_MASK) {
                target.setTargetLocationLatitude(context.readSA32());
            }
            if ((existenceMask & D32_3_EXISTENCE_MASK) == D32_3_EXISTENCE_MASK) {
                target.setTargetLocationLongitude(context.readBA32());
            }
            if ((existenceMask & D32_4_EXISTENCE_MASK) == D32_4_EXISTENCE_MASK) {
                target.setTargetLocationDeltaLatitude(context.readS16());
            }
            if ((existenceMask & D32_5_EXISTENCE_MASK) == D32_5_EXISTENCE_MASK) {
                target.setTargetLocationDeltaLongitude(context.readS16());
            }
            if ((existenceMask & D32_6_EXISTENCE_MASK) == D32_6_EXISTENCE_MASK) {
                target.setTargetLocationGeodeticHeight(context.readS16());
            }
            if ((existenceMask & D32_7_EXISTENCE_MASK) == D32_7_EXISTENCE_MASK) {
                target.setTargetVelocityLineOfSightComponent(context.readS16());
            }
            if ((existenceMask & D32_8_EXISTENCE_MASK) == D32_8_EXISTENCE_MASK) {
                target.setTargetWrapVelocity(context.readI16());
            }
            if ((existenceMask & D32_9_EXISTENCE_MASK) == D32_9_EXISTENCE_MASK) {
                target.setTargetSNR(context.readS8());
            }
            if ((existenceMask & D32_10_EXISTENCE_MASK) == D32_10_EXISTENCE_MASK) {
                target.setTargetClassification(context.readE8());
            }
            if ((existenceMask & D32_11_EXISTENCE_MASK) == D32_11_EXISTENCE_MASK) {
                target.setTargetClassificationProbability(context.readI8());
            }
            if ((existenceMask & D32_12_EXISTENCE_MASK) == D32_12_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintySlantRange(context.readI16());
            }
            if ((existenceMask & D32_13_EXISTENCE_MASK) == D32_13_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyCrossRange(context.readI16());
            }
            if ((existenceMask & D32_14_EXISTENCE_MASK) == D32_14_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyHeight(context.readI8());
            }
            if ((existenceMask & D32_15_EXISTENCE_MASK) == D32_15_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyRadialVelocity(context.readI16());
            }
            if ((existenceMask & D32_16_EXISTENCE_MASK) == D32_16_EXISTENCE_MASK) {
                target.setTruthTagApplication(context.readI8());
            }
            if ((existenceMask & D32_17_EXISTENCE_MASK) == D32_17_EXISTENCE_MASK) {
                target.setTruthTagEntity(context.readI32());
            }
            if ((existenceMask & D32_18_EXISTENCE_MASK) == D32_18_EXISTENCE_MASK) {
                target.setTargetRadarCrossSection(context.readS8());
            }
            dwellSegment.addTarget(target);
        }
        return dwellSegment;
    }
}
