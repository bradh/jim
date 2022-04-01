package net.frogmouth.rnd.jim.s4607.hrr;

import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link HighRangeResolutionSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class HighRangeResolutionSegmentParser extends AbstractSegmentParser {

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.HRRSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        HighRangeResolutionSegment hrrSegment = new HighRangeResolutionSegment();
        byte[] existenceMaskBytes = context.getBytes(5);
        ExistenceMask existence = ExistenceMask.fromBytes(existenceMaskBytes);
        if (existence.isSet(ExistenceMask.H2_EXISTENCE)) {
            hrrSegment.setRevisitIndex(context.readI16());
        }
        if (existence.isSet(ExistenceMask.H3_EXISTENCE)) {
            hrrSegment.setDwellIndex(context.readI16());
        }
        if (existence.isSet(ExistenceMask.H4_EXISTENCE)) {
            // TODO: setter that takes the FL8 output
            hrrSegment.setLastDwellOfRevisit(context.readFL8() == 0x01);
        }
        if (existence.isSet(ExistenceMask.H5_EXISTENCE)) {
            hrrSegment.setMtiReportIndex(context.readI16());
        }
        if (existence.isSet(ExistenceMask.H6_EXISTENCE)) {
            hrrSegment.setNumberOfTargetScatterers(context.readI16());
        }
        if (existence.isSet(ExistenceMask.H7_EXISTENCE)) {
            hrrSegment.setNumberOfRangeSamplesOrTotalScatterers(context.readI16());
        }
        if (existence.isSet(ExistenceMask.H8_EXISTENCE)) {
            hrrSegment.setNumberOfDopplerSamples(context.readI16());
        }
        if (existence.isSet(ExistenceMask.H9_EXISTENCE)) {
            hrrSegment.setMeanClutterPower(context.readI8());
        }
        if (existence.isSet(ExistenceMask.H10_EXISTENCE)) {
            hrrSegment.setDetectionThreshold(context.readI8());
        }
        if (existence.isSet(ExistenceMask.H11_EXISTENCE)) {
            hrrSegment.setRangeResolution(context.readB16());
        }
        if (existence.isSet(ExistenceMask.H12_EXISTENCE)) {
            hrrSegment.setRangeBinSpacing(context.readB16());
        }
        if (existence.isSet(ExistenceMask.H13_EXISTENCE)) {
            hrrSegment.setDopplerResolution(context.readH32());
        }
        if (existence.isSet(ExistenceMask.H14_EXISTENCE)) {
            hrrSegment.setDopplerBinSpacing(context.readH32());
        }
        if (existence.isSet(ExistenceMask.H15_EXISTENCE)) {
            hrrSegment.setCentreFrequency(context.readB32());
        }
        if (existence.isSet(ExistenceMask.H16_EXISTENCE)) {
            hrrSegment.setCompressionType(context.readE8());
        }
        if (existence.isSet(ExistenceMask.H17_EXISTENCE)) {
            hrrSegment.setRangeWeightingFunctionType(context.readE8());
        }
        if (existence.isSet(ExistenceMask.H18_EXISTENCE)) {
            hrrSegment.setDopplerWeightingFunctionType(context.readE8());
        }
        if (existence.isSet(ExistenceMask.H19_EXISTENCE)) {
            hrrSegment.setMaximumPixelPower(context.readB16());
        }
        if (existence.isSet(ExistenceMask.H20_EXISTENCE)) {
            hrrSegment.setMaximumRadarCrossSection(context.readS8());
        }
        if (existence.isSet(ExistenceMask.H21_EXISTENCE)) {
            hrrSegment.setRangeOfOrigin(context.readS16());
        }
        if (existence.isSet(ExistenceMask.H22_EXISTENCE)) {
            hrrSegment.setDopplerOfOrigin(context.readH32());
        }
        if (existence.isSet(ExistenceMask.H23_EXISTENCE)) {
            int value = context.readE8();
            TypeOfHrrRdm type = TypeOfHrrRdm.lookupByIdent(value);
            hrrSegment.setTypeOfHrrRdm(type);
        }
        if (existence.isSet(ExistenceMask.H24_EXISTENCE)) {
            byte b = (byte) context.readFL8();
            ProcessingMask mask = ProcessingMask.fromByte(b);
            hrrSegment.setProcessingMask(mask);
        }
        if (existence.isSet(ExistenceMask.H25_EXISTENCE)) {
            hrrSegment.setNumBytesMagnititude(context.readI8());
        }
        if (existence.isSet(ExistenceMask.H26_EXISTENCE)) {
            hrrSegment.setNumBytesPhase(context.readI8());
        }
        if (existence.isSet(ExistenceMask.H27_EXISTENCE)) {
            hrrSegment.setRangeExtentInPixels(context.readI8());
        }
        if (existence.isSet(ExistenceMask.H28_EXISTENCE)) {
            hrrSegment.setRangeToNearestEdgeInChip(context.readI32());
        }
        if (existence.isSet(ExistenceMask.H29_EXISTENCE)) {
            hrrSegment.setIndexOfZeroVelocityBin(context.readI8());
        }
        if (existence.isSet(ExistenceMask.H30_EXISTENCE)) {
            hrrSegment.setTargetRadialElectricalLength(context.readB32());
        }
        if (existence.isSet(ExistenceMask.H31_EXISTENCE)) {
            hrrSegment.setElectricalLengthUncertainty(context.readB32());
        }
        for (int i = 0; i < hrrSegment.getNumberOfTargetScatterers(); i++) {
            ScattererRecord scatterer = new ScattererRecord();
            if (existence.isSet(ExistenceMask.H32_1_EXISTENCE)) {
                switch (hrrSegment.getNumBytesMagnititude()) {
                    case 1:
                        scatterer.setMagnitude(context.readI8());
                        break;
                    case 2:
                        scatterer.setMagnitude(context.readI16());
                        break;

                    default:
                        // LOG this - can only be 1 or 2.
                        break;
                }
            }
            if (existence.isSet(ExistenceMask.H32_2_EXISTENCE)) {
                switch (hrrSegment.getNumBytesPhase()) {
                    case 1:
                        scatterer.setPhase(context.readI8());
                        break;
                    case 2:
                        scatterer.setPhase(context.readI16());
                        break;

                    default:
                        // LOG this - can only be 1 or 2.
                        break;
                }
            }
            if (existence.isSet(ExistenceMask.H32_3_EXISTENCE)) {
                scatterer.setRangeIndex(context.readI16());
            }
            if (existence.isSet(ExistenceMask.H32_4_EXISTENCE)) {
                scatterer.setDopplerIndex(context.readI16());
            }
            hrrSegment.addScattererRecord(scatterer);
        }
        return hrrSegment;
    }
}
