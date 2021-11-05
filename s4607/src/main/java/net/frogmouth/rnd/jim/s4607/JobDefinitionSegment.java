package net.frogmouth.rnd.jim.s4607;

public class JobDefinitionSegment extends Segment {

    private long jobId;
    private int sensorIdType;
    private String sensorIdModel;
    private int targetFilteringFlag;
    private int priority;
    private BoundingArea boundingArea;
    private int radarMode;
    private int nominalRevisitInterval;
    private int alongTrackUncertainty;
    private int crossTrackUncertainty;
    private int altitudeUncertainty;
    private int trackHeadingUncertainty;
    private int sensorSpeedUncertainty;
    private int slantRangeStandardDeviation;
    private double crossRangeStandardDeviation;
    private int targetVelocityLineOfSightStandardDeviation;
    private int mdv;
    private int detectionProbability;
    private int falseAlarmDensity;
    private int terrainElevationModelUsed;
    private int geoidModelUsed;

    JobDefinitionSegment(SegmentHeader segmentHeader) {
        super(segmentHeader);
    }

    /**
     * A platform assigned number identifying the specific request or task to which the dwell
     * pertains.
     *
     * @return job number, in the range 1 to 4294967295
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * Set the platform assigned number identifying the specific request or task to which the dwell
     * pertains.
     *
     * @param jobId job number, in the range 1 to 4294967295
     */
    public void setJobId(long jobId) {
        if ((jobId < 1) || (jobId > 4294967295L)) {
            throw new IllegalArgumentException(
                    "Job ID must be in the range 1 to 4294967295, got " + jobId);
        }
        this.jobId = jobId;
    }

    public int getSensorIdType() {
        return sensorIdType;
    }

    public void setSensorIdType(int sensorIdType) {
        this.sensorIdType = sensorIdType;
    }

    public String getSensorIdModel() {
        return sensorIdModel;
    }

    public void setSensorIdModel(String sensorIdModel) {
        this.sensorIdModel = sensorIdModel;
    }

    public int getTargetFilteringFlag() {
        return targetFilteringFlag;
    }

    public void setTargetFilteringFlag(int targetFilteringFlag) {
        this.targetFilteringFlag = targetFilteringFlag;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public BoundingArea getBoundingArea() {
        return boundingArea;
    }

    public void setBoundingArea(BoundingArea boundingArea) {
        this.boundingArea = boundingArea;
    }

    public int getRadarMode() {
        return radarMode;
    }

    public void setRadarMode(int radarMode) {
        this.radarMode = radarMode;
    }

    public int getNominalRevisitInterval() {
        return nominalRevisitInterval;
    }

    public void setNominalRevisitInterval(int nominalRevisitInterval) {
        this.nominalRevisitInterval = nominalRevisitInterval;
    }

    public int getAlongTrackUncertainty() {
        return alongTrackUncertainty;
    }

    public void setAlongTrackUncertainty(int alongTrackUncertainty) {
        this.alongTrackUncertainty = alongTrackUncertainty;
    }

    public int getCrossTrackUncertainty() {
        return crossTrackUncertainty;
    }

    public void setCrossTrackUncertainty(int crossTrackUncertainty) {
        this.crossTrackUncertainty = crossTrackUncertainty;
    }

    public int getAltitudeUncertainty() {
        return altitudeUncertainty;
    }

    public void setAltitudeUncertainty(int altitudeUncertainty) {
        this.altitudeUncertainty = altitudeUncertainty;
    }

    public int getTrackHeadingUncertainty() {
        return trackHeadingUncertainty;
    }

    public void setTrackHeadingUncertainty(int trackHeadingUncertainty) {
        this.trackHeadingUncertainty = trackHeadingUncertainty;
    }

    public int getSensorSpeedUncertainty() {
        return sensorSpeedUncertainty;
    }

    public void setSensorSpeedUncertainty(int sensorSpeedUncertainty) {
        this.sensorSpeedUncertainty = sensorSpeedUncertainty;
    }

    public int getSlantRangeStandardDeviation() {
        return slantRangeStandardDeviation;
    }

    public void setSlantRangeStandardDeviation(int slantRangeStandardDeviation) {
        this.slantRangeStandardDeviation = slantRangeStandardDeviation;
    }

    public double getCrossRangeStandardDeviation() {
        return crossRangeStandardDeviation;
    }

    public void setCrossRangeStandardDeviation(double crossRangeStandardDeviation) {
        this.crossRangeStandardDeviation = crossRangeStandardDeviation;
    }

    public int getTargetVelocityLineOfSightStandardDeviation() {
        return targetVelocityLineOfSightStandardDeviation;
    }

    public void setTargetVelocityLineOfSightStandardDeviation(
            int targetVelocityLineOfSightStandardDeviation) {
        this.targetVelocityLineOfSightStandardDeviation =
                targetVelocityLineOfSightStandardDeviation;
    }

    public int getMdv() {
        return mdv;
    }

    public void setMdv(int mdv) {
        this.mdv = mdv;
    }

    public int getDetectionProbability() {
        return detectionProbability;
    }

    public void setDetectionProbability(int detectionProbability) {
        this.detectionProbability = detectionProbability;
    }

    public int getFalseAlarmDensity() {
        return falseAlarmDensity;
    }

    public void setFalseAlarmDensity(int falseAlarmDensity) {
        this.falseAlarmDensity = falseAlarmDensity;
    }

    public int getTerrainElevationModelUsed() {
        return terrainElevationModelUsed;
    }

    public void setTerrainElevationModelUsed(int terrainElevationModelUsed) {
        this.terrainElevationModelUsed = terrainElevationModelUsed;
    }

    public int getGeoidModelUsed() {
        return geoidModelUsed;
    }

    public void setGeoidModelUsed(int geoidModelUsed) {
        this.geoidModelUsed = geoidModelUsed;
    }
}
