package net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

/**
 * Job Definition Segment.
 *
 * <p>The Job Definition Segment provides the means for the platform to pass information pertaining
 * to the sensor job that will be performed and details of the location parameters (terrain
 * elevation model and geoid model) used in the measurement.
 *
 * <p>It includes a definition of the geographic area for sensor service, the Bounding Area, which
 * is defined as a four-corner polygon, with the four points of the polygon chosen to define a
 * convex quadrilateral. The Job Definition Segment is sent before the first visit of a job with the
 * bounding area representing the tasked area, and is updated and resent with the bounding area set
 * to represent the actual scanned area when the scanned area differs from the area sent in the
 * previous Job Definition Segment. The Job Definition Segment is sent periodically at least once
 * every 30 seconds thereafter.
 *
 * <p>All fields in the Job Definition Segment are mandatory.
 */
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

    /**
     * Job Definition Segment.
     *
     * <p>The Job Definition Segment provides the means for the platform to pass information
     * pertaining to the sensor job that will be performed and details of the location parameters
     * (terrain elevation model and geoid model) used in the measurement. It includes a definition
     * of the geographic area for sensor service, the Bounding Area, which is defined as a
     * four-corner polygon, with the four points of the polygon chosen to define a convex
     * quadrilateral. The Job Definition Segment shall be sent before the first visit of a job with
     * the bounding area representing the tasked area, and shall be updated and resent with the
     * bounding area set to represent the actual scanned area when the scanned area differs from the
     * area sent in the previous Job Definition Segment. The Job Definition Segment shall be sent
     * periodically at least once every 30 seconds thereafter.
     *
     * <p>All elements of the Job Definition Segment are mandatory.
     */
    public JobDefinitionSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobDefinitionSegment;
    }

    /**
     * Job ID (J1).
     *
     * <p>A platform assigned number identifying the specific request or task to which the dwell
     * pertains.
     *
     * @return job number, in the range 1 to 4294967295
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * Set the Job ID (J1).
     *
     * <p>Set the platform assigned number identifying the specific request or task to which the
     * dwell pertains.
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

    /**
     * Sensor ID – Type (J2).
     *
     * <p>An enumeration denoting the type of sensor or the platform. A Sensor ID - Type value of
     * {@code 255} indicates that it is a No Statement and no sensor type is specified. New sensor
     * types can be registered with the Custodian.
     *
     * @return sensor type as an integer value.
     */
    public int getSensorIdType() {
        return sensorIdType;
    }

    /**
     * Set the Sensor ID – Type (J2).
     *
     * <p>An enumeration denoting the type of sensor or the platform. A Sensor ID - Type value of
     * {@code 255} indicates that it is a No Statement and no sensor type is specified. New sensor
     * types can be registered with the Custodian.
     *
     * @param sensorIdType sensor type as an integer value.
     */
    public void setSensorIdType(int sensorIdType) {
        this.sensorIdType = sensorIdType;
    }

    /**
     * Sensor ID – Model (J3).
     *
     * <p>An alphanumeric field identifying the particular variant of the sensor type.
     *
     * @return the sensor identification model as a String.
     */
    public String getSensorIdModel() {
        return sensorIdModel;
    }

    /**
     * Set the Sensor ID – Model (J3).
     *
     * <p>An alphanumeric field identifying the particular variant of the sensor type.
     *
     * @param sensorIdModel the sensor identification model (BCS characters, 6 maximum).
     */
    public void setSensorIdModel(String sensorIdModel) {
        this.validateBCS(sensorIdModel, 6);
        this.sensorIdModel = sensorIdModel;
    }

    /**
     * Target Filtering Flag (J4).
     *
     * <p>A flag field indicating whether or not filtering has been applied to the targets detected
     * within the dwell area and the type of filtering, if any, that has been applied. A Target
     * Filtering Flag of zero (hex 0x00) indicates that no filtering has been applied to the
     * targets.
     *
     * <p>If bit 0, the least significant bit, is set to a binary “one”, this indicates that area
     * filtering within the intersection of the Dwell Area and the Bounding Area has been performed.
     *
     * <p>If bit 1 is set to a binary “one”, this indicates that Area Blanking has been applied.
     * However, the format does not currently specify the area over which blanking has been applied.
     *
     * <p>If bit 2 is set to a binary “one”, this indicates that Sector Blanking has been applied.
     * However, the format does not currently specify the sector over which blanking has been
     * applied.
     *
     * <p>Bits number 3-7 are reserved for future growth.
     *
     * @return the target filtering flags
     */
    public int getTargetFilteringFlag() {
        return targetFilteringFlag;
    }

    /**
     * Set the Target Filtering Flag (J4).
     *
     * <p>A flag field indicating whether or not filtering has been applied to the targets detected
     * within the dwell area and the type of filtering, if any, that has been applied. A Target
     * Filtering Flag of zero (hex 0x00) indicates that no filtering has been applied to the
     * targets.
     *
     * <p>If bit 0, the least significant bit, is set to a binary “one”, this indicates that area
     * filtering within the intersection of the Dwell Area and the Bounding Area has been performed.
     *
     * <p>If bit 1 is set to a binary “one”, this indicates that Area Blanking has been applied.
     * However, the format does not currently specify the area over which blanking has been applied.
     *
     * <p>If bit 2 is set to a binary “one”, this indicates that Sector Blanking has been applied.
     * However, the format does not currently specify the sector over which blanking has been
     * applied.
     *
     * <p>Bits number 3-7 are reserved for future growth.
     *
     * @param targetFilteringFlag the target filtering flags.
     */
    public void setTargetFilteringFlag(int targetFilteringFlag) {
        this.targetFilteringFlag = targetFilteringFlag;
    }

    /**
     * Priority (Radar Priority) (J5).
     *
     * <p>Specifies the priority of this tasking request relative to all other active tasking
     * requests scheduled for execution on the specified platform. A value of 255 indicates the Job
     * is ended.
     *
     * @return the priority as an integer value.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the Priority (Radar Priority) (J5).
     *
     * <p>Specifies the priority of this tasking request relative to all other active tasking
     * requests scheduled for execution on the specified platform. A value of 255 indicates the Job
     * is ended.
     *
     * @param priority the radar priority as an integer value.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Bounding area (J6 through J13).
     *
     * <p>Bounding box for the the area for sensor service, expressed as. The four corners (J6
     * through J13) of the bounding area, expressed as lat/long for each corner, are given in
     * clockwise order (Points A, B, C, and D) and must form a convex quadrilateral.
     *
     * @return the bounding area.
     */
    public BoundingArea getBoundingArea() {
        return new BoundingArea(boundingArea);
    }

    /**
     * Set the Bounding area (J6 through J13).
     *
     * <p>Bounding box for the the area for sensor service, expressed as. The four corners (J6
     * through J13) of the bounding area, expressed as lat/long for each corner, are given in
     * clockwise order (Points A, B, C, and D) and must form a convex quadrilateral.
     *
     * @param boundingArea the boounding area.
     */
    public void setBoundingArea(BoundingArea boundingArea) {
        this.boundingArea = new BoundingArea(boundingArea);
    }

    /**
     * Radar Mode (J14).
     *
     * <p>An enumeration value that identifies the mode in which the radar will operate for the
     * given job ID. The Job ID must be associated with exactly one radar operating mode. Thus, when
     * the system changes radar modes, a new Job ID must be assigned.
     *
     * <p>Radar operating modes are system-specific and shall be determined for each system. Note
     * that radar modes 0-5 are generic modes that will be used in non-platform-specific job
     * requests.
     *
     * @return the radar mode as an enumerated integer value.
     */
    public int getRadarMode() {
        return radarMode;
    }

    /**
     * Radar Mode (J14).
     *
     * <p>A text representation of the enumeration value that identifies the mode in which the radar
     * will operate for the given job ID.
     *
     * @return the radar mode as a text value.
     */
    public String getRadarModeAsText() {
        return RadarModeLookupTable.getValue(radarMode);
    }

    /**
     * Set the Radar Mode (J14).
     *
     * <p>An enumeration value that identifies the mode in which the radar will operate for the
     * given job ID. The Job ID must be associated with exactly one radar operating mode. Thus, when
     * the system changes radar modes, a new Job ID must be assigned.
     *
     * <p>Radar operating modes are system-specific and shall be determined for each system. Note
     * that radar modes 0-5 are generic modes that will be used in non-platform-specific job
     * requests.
     *
     * @param radarMode the radar mode as an enumerated integer value.
     */
    public void setRadarMode(int radarMode) {
        this.radarMode = radarMode;
    }

    /**
     * Nominal Revisit Interval (J15).
     *
     * <p>Specifies the nominal revisit interval for the job ID, expressed in deciseconds (tenths of
     * seconds). If the sensor is not revisiting the previous area, the interval shall be reset to
     * 0.
     *
     * @return the revisit interval in deciseconds.
     */
    public int getNominalRevisitInterval() {
        return nominalRevisitInterval;
    }

    /**
     * Set the Nominal Revisit Interval (J15).
     *
     * <p>Specifies the nominal revisit interval for the job ID, expressed in deciseconds (tenths of
     * seconds). If the sensor is not revisiting the previous area, the interval shall be reset to
     * 0.
     *
     * @param nominalRevisitInterval the revisit interval in deciseconds.
     */
    public void setNominalRevisitInterval(int nominalRevisitInterval) {
        this.nominalRevisitInterval = nominalRevisitInterval;
    }

    /**
     * Nominal Sensor Position Uncertainty - Along Track (J16).
     *
     * <p>Nominal estimate of the standard deviation in the estimated horizontal sensor location,
     * expressed in decimeters. It is measured along the sensor track direction defined in field D15
     * of the Dwell segment. The No-Statement value is sent when the sensor is unable or unwilling
     * to provide a value. (NOTE: The Nominal fields in the Job Definition Segment provide a means
     * for reporting nominal standard deviations and uncertainty values, and are to be used when
     * values are not received from the sensor. More precise values of these or related estimates
     * may be reported in the appropriate fields in either the Dwell Segment or the Target Report
     * Sub-Segment, when the sensor computes them and the communication bandwidth permits the more
     * frequent reporting.)
     *
     * @return the nominal position uncertainty in decimeters.
     */
    public int getAlongTrackUncertainty() {
        return alongTrackUncertainty;
    }

    /**
     * Set the Nominal Sensor Position Uncertainty - Along Track (J16).
     *
     * <p>Nominal estimate of the standard deviation in the estimated horizontal sensor location,
     * expressed in decimeters. It is measured along the sensor track direction defined in field D15
     * of the Dwell segment. The No-Statement value is sent when the sensor is unable or unwilling
     * to provide a value. (NOTE: The Nominal fields in the Job Definition Segment provide a means
     * for reporting nominal standard deviations and uncertainty values, and are to be used when
     * values are not received from the sensor. More precise values of these or related estimates
     * may be reported in the appropriate fields in either the Dwell Segment or the Target Report
     * Sub-Segment, when the sensor computes them and the communication bandwidth permits the more
     * frequent reporting.)
     *
     * @param alongTrackUncertainty the nominal position uncertainty in decimeters.
     */
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
