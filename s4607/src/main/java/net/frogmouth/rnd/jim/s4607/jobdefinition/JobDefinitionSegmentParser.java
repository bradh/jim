package net.frogmouth.rnd.jim.s4607.jobdefinition;

import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentParser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentHeader;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Parser for {@link JobDefinitionSegment}.
 *
 * <p>This is normally invoked by the parent parsing code (e.g. from a packet parser), and is not
 * typically created directly.
 */
public class JobDefinitionSegmentParser extends AbstractSegmentParser {

    /** Constructor. */
    public JobDefinitionSegmentParser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobDefinitionSegment;
    }

    @Override
    public Segment parse(SegmentHeader segmentHeader) {
        JobDefinitionSegment jobSegment = new JobDefinitionSegment();
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
