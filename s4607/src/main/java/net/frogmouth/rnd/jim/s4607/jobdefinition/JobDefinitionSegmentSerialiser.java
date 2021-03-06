package net.frogmouth.rnd.jim.s4607.jobdefinition;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.s4607.SerialisationContext;
import net.frogmouth.rnd.jim.s4607.impl.BoundingAreaSerialiser;
import net.frogmouth.rnd.jim.s4607.impl.SerialisationUtils;
import net.frogmouth.rnd.jim.s4607.segment.AbstractSegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.ISegmentSerialiser;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Serialiser for {@link JobDefinitionSegment}.
 *
 * <p>This is normally invoked by the parent serialisation code (e.g. from a packet serialiser), and
 * is not typically created directly.
 */
public class JobDefinitionSegmentSerialiser extends AbstractSegmentSerialiser
        implements ISegmentSerialiser {

    /** Constructor. */
    public JobDefinitionSegmentSerialiser() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobDefinitionSegment;
    }

    @Override
    public byte[] serialise(Segment segment, SerialisationContext serialisationText) {
        JobDefinitionSegment jobDefinitionSegment = (JobDefinitionSegment) segment;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(writeI32(jobDefinitionSegment.getJobId()));
        baos.writeBytes(writeE8(jobDefinitionSegment.getSensorIdType()));
        baos.writeBytes(SerialisationUtils.padString(jobDefinitionSegment.getSensorIdModel(), 6));
        baos.writeBytes(writeFL8(jobDefinitionSegment.getTargetFilteringFlag()));
        baos.writeBytes(writeI8(jobDefinitionSegment.getPriority()));
        BoundingAreaSerialiser.writeBoundingArea(jobDefinitionSegment.getBoundingArea(), baos);
        baos.writeBytes(writeE8(jobDefinitionSegment.getRadarMode()));
        baos.writeBytes(writeI16(jobDefinitionSegment.getNominalRevisitInterval()));
        baos.writeBytes(writeI16(jobDefinitionSegment.getAlongTrackUncertainty()));
        baos.writeBytes(writeI16(jobDefinitionSegment.getCrossTrackUncertainty()));
        baos.writeBytes(writeI16(jobDefinitionSegment.getAltitudeUncertainty()));
        baos.writeBytes(writeI8(jobDefinitionSegment.getTrackHeadingUncertainty()));
        baos.writeBytes(writeI16(jobDefinitionSegment.getSensorSpeedUncertainty()));
        baos.writeBytes(writeI16(jobDefinitionSegment.getSlantRangeStandardDeviation()));
        baos.writeBytes(writeBA16(jobDefinitionSegment.getCrossRangeStandardDeviation()));
        baos.writeBytes(
                writeI16(jobDefinitionSegment.getTargetVelocityLineOfSightStandardDeviation()));
        baos.writeBytes(writeI8(jobDefinitionSegment.getMdv()));
        baos.writeBytes(writeI8(jobDefinitionSegment.getDetectionProbability()));
        baos.writeBytes(writeI8(jobDefinitionSegment.getFalseAlarmDensity()));
        baos.writeBytes(writeE8(jobDefinitionSegment.getTerrainElevationModelUsed()));
        baos.writeBytes(writeE8(jobDefinitionSegment.getGeoidModelUsed()));
        return baos.toByteArray();
    }
}
