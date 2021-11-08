package net.frogmouth.rnd.jim.s4607;

import static net.frogmouth.rnd.jim.s4607.SegmentType.DwellSegment;
import static net.frogmouth.rnd.jim.s4607.SegmentType.MissionSegment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/** STANAG 4607 / AEDP-7 GMTI Reader. */
public class Reader {

    private ParseContext context;
    private List<Packet> packets = new ArrayList<>();
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

    public Reader(String filename) throws IOException {
        this(Paths.get(filename));
    }

    public Reader(Path path) throws IOException {
        context = new ParseContext(path);
        int packetStartOffset = 0;

        while (context.hasRemaining()) {
            Packet packet = new Packet();
            PacketHeader packetHeader = readPacketHeader();
            packet.setPacketHeader(packetHeader);
            while (context.position() < (packetStartOffset + packetHeader.getPacketSize())) {
                packet.addSegment(readSegment());
            }
            packets.add(packet);
            packetStartOffset += packetHeader.getPacketSize();
        }
    }

    public List<Packet> getPackets() {
        return new ArrayList<>(packets);
    }

    private byte[] getBytes(int len) {
        byte[] dest = new byte[len];
        context.get(dest);
        return dest;
    }

    private String readASCII(int numBytes) {
        byte[] bytes = getBytes(numBytes);
        int indexOfLastValidByte = 0;
        for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] == 0x00) {
                break;
            }
            indexOfLastValidByte = i;
        }
        String cleanString =
                new String(bytes, 0, indexOfLastValidByte + 1, StandardCharsets.US_ASCII);
        return String.format("%-" + numBytes + "s", cleanString);
    }

    private long readI32() {
        long i32 = context.getInt() & 0x00FFFFFFFFl;
        return i32;
    }

    private int readS32() {
        int s32 = context.getInt();
        return s32;
    }

    private int readI16() {
        int i16 = context.getShort() & 0x0000FFFF;
        return i16;
    }

    private int readS16() {
        int s16 = context.getShort();
        return s16;
    }

    private int readI8() {
        int i8 = context.get() & 0x00FF;
        return i8;
    }

    private int readS8() {
        int s8 = context.get();
        return s8;
    }

    private int readE8() {
        int e8 = context.get() & 0x00FF;
        return e8;
    }

    private long readFL64() {
        return context.getLong();
    }

    private int readFL16() {
        return context.getShort() & 0x0000FFFF;
    }

    private int readFL8() {
        return context.get() & 0x00FF;
    }

    private double readBA32() {
        long i = readI32();
        double d = i * 1.40625 / Math.pow(2, 32 - 8);
        return d;
    }

    private double readBA16() {
        long i = readI16();
        double d = i * 1.40625 / Math.pow(2, 16 - 8);
        return d;
    }

    private double readB16() {
        int i = readI16();
        boolean negative = (i & 0x8000) == 0x8000;
        int magnitude = (i & 0x7F80) >> 7;
        int fraction = (i & 0x7F);
        double d = magnitude + (fraction / 128.0);
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    private double readSA32() {
        long i = readI32();
        boolean negative = (i & 0x80000000) == 0x80000000;
        int magnitude = (int) (i & 0x7FFFFFFF);
        double d = magnitude * 1.40625 / Math.pow(2, 32 - 7);
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    private double readSA16() {
        long i = readI16();
        boolean negative = (i & 0x8000) == 0x8000;
        int magnitude = (int) (i & 0x7FFF);
        double d = magnitude * 1.40625 / Math.pow(2, 16 - 7);
        if (negative) {
            return d * -1.0;
        } else {
            return d;
        }
    }

    private PacketHeader readPacketHeader() {
        PacketHeader ph = new PacketHeader();
        ph.setVersionId(readASCII(2));
        ph.setPacketSize(readI32());
        ph.setNationality(readASCII(2));
        ph.setClassification(readE8());
        ph.setClassificationSystem(readASCII(2));
        ph.setClassificationCodeFlags(readFL16());
        ph.setExerciseIndicator(readE8());
        ph.setPlatformId(readASCII(10));
        ph.setMissionId(readI32());
        ph.setJobId(readI32());
        return ph;
    }

    private Segment readSegment() {

        SegmentType segmentType = SegmentType.lookupByIdent(readE8());
        long segmentSize = readI32();
        SegmentHeader segmentHeader = new SegmentHeader(segmentType, segmentSize);
        // TODO: switch this to a loader + factory
        switch (segmentHeader.getSegmentType()) {
            case MissionSegment:
                return parseMissionSegment(segmentHeader);
            case DwellSegment:
                return parseDwellSegment(segmentHeader);
            case FreeTextSegment:
                return parseFreeTextSegment(segmentHeader);
            case JobDefinitionSegment:
                return parseJobDefinitionSegment(segmentHeader);
            default:
                throw new IllegalArgumentException("TODO");
        }
    }

    private Segment parseMissionSegment(SegmentHeader segmentHeader) {
        MissionSegment missionSegment = new MissionSegment(segmentHeader);
        missionSegment.setMissionPlan(readASCII(12));
        missionSegment.setFlightPlan(readASCII(12));
        missionSegment.setPlatformType(readE8());
        missionSegment.setPlatformConfiguration(readASCII(10));
        missionSegment.setYear(readI16());
        missionSegment.setMonth(readI8());
        missionSegment.setDay(readI8());
        return missionSegment;
    }

    private Segment parseDwellSegment(SegmentHeader segmentHeader) {
        DwellSegment dwellSegment = new DwellSegment(segmentHeader);
        long existenceMask = readFL64();
        if ((existenceMask & D2_EXISTENCE_MASK) == D2_EXISTENCE_MASK) {
            dwellSegment.setRevisitIndex(readI16());
        }
        if ((existenceMask & D3_EXISTENCE_MASK) == D3_EXISTENCE_MASK) {
            dwellSegment.setDwellIndex(readI16());
        }
        if ((existenceMask & D4_EXISTENCE_MASK) == D4_EXISTENCE_MASK) {
            dwellSegment.setLastDwellOfRevisit(readFL8() == 0x01);
        }
        if ((existenceMask & D5_EXISTENCE_MASK) == D5_EXISTENCE_MASK) {
            dwellSegment.setTargetReportCount(readI16());
        }
        if ((existenceMask & D6_EXISTENCE_MASK) == D6_EXISTENCE_MASK) {
            dwellSegment.setDwellTime(readI32());
        }
        if ((existenceMask & D7_EXISTENCE_MASK) == D7_EXISTENCE_MASK) {
            dwellSegment.setSensorLatitude(readSA32());
        }
        if ((existenceMask & D8_EXISTENCE_MASK) == D8_EXISTENCE_MASK) {
            dwellSegment.setSensorLongitude(readBA32());
        }
        if ((existenceMask & D9_EXISTENCE_MASK) == D9_EXISTENCE_MASK) {
            dwellSegment.setSensorAltitude(readS32());
        }
        if ((existenceMask & D10_EXISTENCE_MASK) == D10_EXISTENCE_MASK) {
            dwellSegment.setScaleFactorLatScale(readSA32());
        }
        if ((existenceMask & D11_EXISTENCE_MASK) == D11_EXISTENCE_MASK) {
            dwellSegment.setScaleFactorLonScale(readBA32());
        }
        if ((existenceMask & D12_EXISTENCE_MASK) == D12_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyAlongTrack((int) readI32());
        }
        if ((existenceMask & D13_EXISTENCE_MASK) == D13_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyCrossTrack((int) readI32());
        }
        if ((existenceMask & D14_EXISTENCE_MASK) == D14_EXISTENCE_MASK) {
            dwellSegment.setSensorPositionUncertaintyAltitude(readI16());
        }
        if ((existenceMask & D15_EXISTENCE_MASK) == D15_EXISTENCE_MASK) {
            dwellSegment.setSensorTrack(readBA16());
        }
        if ((existenceMask & D16_EXISTENCE_MASK) == D16_EXISTENCE_MASK) {
            dwellSegment.setSensorSpeed((int) readI32());
        }
        if ((existenceMask & D17_EXISTENCE_MASK) == D17_EXISTENCE_MASK) {
            dwellSegment.setSensorVerticalVelocity(readS8());
        }
        if ((existenceMask & D18_EXISTENCE_MASK) == D18_EXISTENCE_MASK) {
            dwellSegment.setSensorTrackUncertainty(readI8());
        }
        if ((existenceMask & D19_EXISTENCE_MASK) == D19_EXISTENCE_MASK) {
            dwellSegment.setSensorSpeedUncertainty(readI16());
        }
        if ((existenceMask & D20_EXISTENCE_MASK) == D20_EXISTENCE_MASK) {
            dwellSegment.setSensorVerticalVelocityUncertainty(readI16());
        }
        if ((existenceMask & D21_EXISTENCE_MASK) == D21_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationHeading(readBA16());
        }
        if ((existenceMask & D22_EXISTENCE_MASK) == D22_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationPitch(readSA16());
        }
        if ((existenceMask & D23_EXISTENCE_MASK) == D23_EXISTENCE_MASK) {
            dwellSegment.setPlatformOrientationRoll(readSA16());
        }
        if ((existenceMask & D24_EXISTENCE_MASK) == D24_EXISTENCE_MASK) {
            dwellSegment.setDwellCentreLatitude(readSA32());
        }
        if ((existenceMask & D25_EXISTENCE_MASK) == D25_EXISTENCE_MASK) {
            dwellSegment.setDwellCentreLongitude(readBA32());
        }
        if ((existenceMask & D26_EXISTENCE_MASK) == D26_EXISTENCE_MASK) {
            dwellSegment.setDwellAreaRangeHalfExtent(readB16());
        }
        if ((existenceMask & D27_EXISTENCE_MASK) == D27_EXISTENCE_MASK) {
            dwellSegment.setDwellAreaDwellAngleHalfExtent(readBA16());
        }
        if ((existenceMask & D28_EXISTENCE_MASK) == D28_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationHeading(readBA16());
        }
        if ((existenceMask & D29_EXISTENCE_MASK) == D29_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationPitch(readSA16());
        }
        if ((existenceMask & D30_EXISTENCE_MASK) == D30_EXISTENCE_MASK) {
            dwellSegment.setSensorOrientationRoll(readSA16());
        }
        if ((existenceMask & D31_EXISTENCE_MASK) == D31_EXISTENCE_MASK) {
            dwellSegment.setMinimumDetectableVelocity(readI8());
        }
        for (int i = 0; i < dwellSegment.getTargetReportCount(); i++) {
            Target target = new Target();
            if ((existenceMask & D32_1_EXISTENCE_MASK) == D32_1_EXISTENCE_MASK) {
                target.setMtiReportIndex(readI16());
            }
            if ((existenceMask & D32_2_EXISTENCE_MASK) == D32_2_EXISTENCE_MASK) {
                target.setTargetLocationLatitude(readSA32());
            }
            if ((existenceMask & D32_3_EXISTENCE_MASK) == D32_3_EXISTENCE_MASK) {
                target.setTargetLocationLongitude(readBA32());
            }
            if ((existenceMask & D32_4_EXISTENCE_MASK) == D32_4_EXISTENCE_MASK) {
                target.setTargetLocationDeltaLatitude(readS16());
            }
            if ((existenceMask & D32_5_EXISTENCE_MASK) == D32_5_EXISTENCE_MASK) {
                target.setTargetLocationDeltaLongitude(readS16());
            }
            if ((existenceMask & D32_6_EXISTENCE_MASK) == D32_6_EXISTENCE_MASK) {
                target.setTargetLocationGeodeticHeight(readS16());
            }
            if ((existenceMask & D32_7_EXISTENCE_MASK) == D32_7_EXISTENCE_MASK) {
                target.setTargetVelocityLineOfSightComponent(readS16());
            }
            if ((existenceMask & D32_8_EXISTENCE_MASK) == D32_8_EXISTENCE_MASK) {
                target.setTargetWrapVelocity(readI16());
            }
            if ((existenceMask & D32_9_EXISTENCE_MASK) == D32_9_EXISTENCE_MASK) {
                target.setTargetSNR(readS8());
            }
            if ((existenceMask & D32_10_EXISTENCE_MASK) == D32_10_EXISTENCE_MASK) {
                target.setTargetClassification(readE8());
            }
            if ((existenceMask & D32_11_EXISTENCE_MASK) == D32_11_EXISTENCE_MASK) {
                target.setTargetClassificationProbability(readI8());
            }
            if ((existenceMask & D32_12_EXISTENCE_MASK) == D32_12_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintySlantRange(readI16());
            }
            if ((existenceMask & D32_13_EXISTENCE_MASK) == D32_13_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyCrossRange(readI16());
            }
            if ((existenceMask & D32_14_EXISTENCE_MASK) == D32_14_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyHeight(readI8());
            }
            if ((existenceMask & D32_15_EXISTENCE_MASK) == D32_15_EXISTENCE_MASK) {
                target.setTargetMeasurementUncertaintyRadialVelocity(readI16());
            }
            if ((existenceMask & D32_16_EXISTENCE_MASK) == D32_16_EXISTENCE_MASK) {
                target.setTruthTagApplication(readI8());
            }
            if ((existenceMask & D32_17_EXISTENCE_MASK) == D32_17_EXISTENCE_MASK) {
                target.setTruthTagEntity(readI32());
            }
            if ((existenceMask & D32_18_EXISTENCE_MASK) == D32_18_EXISTENCE_MASK) {
                target.setTargetRadarCrossSection(readS8());
            }
            dwellSegment.addTarget(target);
        }
        return dwellSegment;
    }

    private Segment parseFreeTextSegment(SegmentHeader segmentHeader) {
        FreeTextSegment freeTextSegment = new FreeTextSegment(segmentHeader);
        freeTextSegment.setOriginatorId(readASCII(10));
        freeTextSegment.setRecipientId(readASCII(10));
        int remainingBytes = (int) (segmentHeader.getSegmentSize() - 25);
        freeTextSegment.setFreeText(readASCII(remainingBytes));
        return freeTextSegment;
    }

    private Segment parseJobDefinitionSegment(SegmentHeader segmentHeader) {
        JobDefinitionSegment jobSegment = new JobDefinitionSegment(segmentHeader);
        jobSegment.setJobId(readI32());
        jobSegment.setSensorIdType(readE8());
        jobSegment.setSensorIdModel(readASCII(6));
        jobSegment.setTargetFilteringFlag(readFL8());
        jobSegment.setPriority(readI8());
        jobSegment.setBoundingArea(parseBoundingArea());
        jobSegment.setRadarMode(readE8());
        jobSegment.setNominalRevisitInterval(readI16());
        jobSegment.setAlongTrackUncertainty(readI16());
        jobSegment.setCrossTrackUncertainty(readI16());
        jobSegment.setAltitudeUncertainty(readI16());
        jobSegment.setTrackHeadingUncertainty(readI8());
        jobSegment.setSensorSpeedUncertainty(readI16());
        jobSegment.setSlantRangeStandardDeviation(readI16());
        jobSegment.setCrossRangeStandardDeviation(readBA16());
        jobSegment.setTargetVelocityLineOfSightStandardDeviation(readI16());
        jobSegment.setMdv(readI8());
        jobSegment.setDetectionProbability(readI8());
        jobSegment.setFalseAlarmDensity(readI8());
        jobSegment.setTerrainElevationModelUsed(readE8());
        jobSegment.setGeoidModelUsed(readE8());

        return jobSegment;
    }

    private BoundingArea parseBoundingArea() {
        BoundingArea boundingArea = new BoundingArea();
        boundingArea.setPointA(readPoint());
        boundingArea.setPointB(readPoint());
        boundingArea.setPointC(readPoint());
        boundingArea.setPointD(readPoint());
        return boundingArea;
    }

    private Point readPoint() {
        Point point = new Point();
        point.setLatitude(readSA32());
        point.setLongitude(readBA32());
        return point;
    }
}
