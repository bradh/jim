package net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentParser;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

public class JobDefinitionSegmentParser extends SegmentParser {

    public JobDefinitionSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobDefinitionSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        JobDefinitionSegment jobSegment = new JobDefinitionSegment(segmentHeader);
        jobSegment.setJobId(context.readI32());
        jobSegment.setSensorIdType(context.readE8());
        jobSegment.setSensorIdModel(context.readASCII(6));
        jobSegment.setTargetFilteringFlag(context.readFL8());
        jobSegment.setPriority(context.readI8());
        jobSegment.setBoundingArea(parseBoundingArea());
        jobSegment.setRadarMode(context.readE8());
        jobSegment.setNominalRevisitInterval(context.readI16());
        jobSegment.setAlongTrackUncertainty(context.readI16());
        jobSegment.setCrossTrackUncertainty(context.readI16());
        jobSegment.setAltitudeUncertainty(context.readI16());
        jobSegment.setTrackHeadingUncertainty(context.readI8());
        jobSegment.setSensorSpeedUncertainty(context.readI16());
        jobSegment.setSlantRangeStandardDeviation(context.readI16());
        jobSegment.setCrossRangeStandardDeviation(context.readBA16());
        jobSegment.setTargetVelocityLineOfSightStandardDeviation(context.readI16());
        jobSegment.setMdv(context.readI8());
        jobSegment.setDetectionProbability(context.readI8());
        jobSegment.setFalseAlarmDensity(context.readI8());
        jobSegment.setTerrainElevationModelUsed(context.readE8());
        jobSegment.setGeoidModelUsed(context.readE8());

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
        point.setLatitude(context.readSA32());
        point.setLongitude(context.readBA32());
        return point;
    }
}