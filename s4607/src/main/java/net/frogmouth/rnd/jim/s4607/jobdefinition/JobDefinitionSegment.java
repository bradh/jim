package net.frogmouth.rnd.jim.s4607.jobdefinition;

import net.frogmouth.rnd.jim.s4607.BoundingArea;
import net.frogmouth.rnd.jim.s4607.impl.RadarModeLookupTable;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

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
     * Constructor.
     *
     * <p>Note that all elements of the Job Definition Segment are mandatory.
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
     * <p>Bounding box for the area for sensor service. The four corners (J6 through J13) of the
     * bounding area, expressed as lat/long for each corner, are given in clockwise order (Points A,
     * B, C, and D) and must form a convex quadrilateral.
     *
     * @return the bounding area.
     */
    public BoundingArea getBoundingArea() {
        return new BoundingArea(boundingArea);
    }

    /**
     * Set the Bounding area (J6 through J13).
     *
     * <p>Bounding box for the area for sensor service. The four corners (J6 through J13) of the
     * bounding area, expressed as lat/long for each corner, are given in clockwise order (Points A,
     * B, C, and D) and must form a convex quadrilateral.
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
     * @return the nominal position uncertainty in decimeters (or 65535 for no-statement).
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
     * @param alongTrackUncertainty the nominal position uncertainty in decimeters, in the range [0,
     *     10000], or 65535 for no-statement.
     */
    public void setAlongTrackUncertainty(int alongTrackUncertainty) {
        this.alongTrackUncertainty = alongTrackUncertainty;
    }

    /**
     * Nominal Sensor Position Uncertainty - Cross Track (J17).
     *
     * <p>Nominal estimate of the standard deviation in the estimated horizontal sensor location,
     * measured orthogonal to the track direction, expressed in decimeters. The No-Statement value
     * is sent when the sensor is unable or unwilling to provide a value. (NOTE: The Nominal fields
     * in the Job Definition Segment provide a means for reporting nominal standard deviations and
     * uncertainty values, and are to be used when values are not received from the sensor. More
     * precise values of these or related estimates may be reported in the appropriate fields in
     * either the Dwell Segment or the Target Report Sub-Segment, when the sensor computes them and
     * the communication bandwidth permits the more frequent reporting.)
     *
     * @return the nominal position uncertainty in decimeters (or 65535 for no-statement).
     */
    public int getCrossTrackUncertainty() {
        return crossTrackUncertainty;
    }

    /**
     * Set the Nominal Sensor Position Uncertainty - Cross Track (J17).
     *
     * <p>Nominal estimate of the standard deviation in the estimated horizontal sensor location,
     * measured orthogonal to the track direction, expressed in decimeters. The No-Statement value
     * is sent when the sensor is unable or unwilling to provide a value. (NOTE: The Nominal fields
     * in the Job Definition Segment provide a means for reporting nominal standard deviations and
     * uncertainty values, and are to be used when values are not received from the sensor. More
     * precise values of these or related estimates may be reported in the appropriate fields in
     * either the Dwell Segment or the Target Report Sub-Segment, when the sensor computes them and
     * the communication bandwidth permits the more frequent reporting.)
     *
     * @param crossTrackUncertainty the nominal position uncertainty in decimeters, in the range [0,
     *     10000], or 65535 for no-statement.
     */
    public void setCrossTrackUncertainty(int crossTrackUncertainty) {
        this.crossTrackUncertainty = crossTrackUncertainty;
    }

    /**
     * Nominal Sensor Position Uncertainty – Altitude (J18).
     *
     * <p>Nominal estimate of the standard deviation of the measured sensor altitude (field D11),
     * expressed in decimeters. The No-Statement value is sent when the sensor is unable or
     * unwilling to provide a value. (NOTE: The Nominal fields in the Job Definition Segment provide
     * a means for reporting nominal standard deviations and uncertainty values, and are to be used
     * when values are not received from the sensor. More precise values of these or related
     * estimates may be reported in the appropriate fields in either the Dwell Segment or the Target
     * Report Sub-Segment, when the sensor computes them and the communication bandwidth permits the
     * more frequent reporting.)
     *
     * @return the nominal altitude uncertainty in decimeters (or 65535 for no-statement).
     */
    public int getAltitudeUncertainty() {
        return altitudeUncertainty;
    }

    /**
     * Set the Nominal Sensor Position Uncertainty – Altitude (J18).
     *
     * <p>Nominal estimate of the standard deviation of the measured sensor altitude (field D11),
     * expressed in decimeters. The No-Statement value is sent when the sensor is unable or
     * unwilling to provide a value. (NOTE: The Nominal fields in the Job Definition Segment provide
     * a means for reporting nominal standard deviations and uncertainty values, and are to be used
     * when values are not received from the sensor. More precise values of these or related
     * estimates may be reported in the appropriate fields in either the Dwell Segment or the Target
     * Report Sub-Segment, when the sensor computes them and the communication bandwidth permits the
     * more frequent reporting.)
     *
     * @param altitudeUncertainty the nominal position uncertainty in decimeters, in the range [0,
     *     20000], or 65535 for no-statement.
     */
    public void setAltitudeUncertainty(int altitudeUncertainty) {
        this.altitudeUncertainty = altitudeUncertainty;
    }

    /**
     * Nominal Sensor Position Uncertainty – Track Heading (J19).
     *
     * <p>Nominal standard deviation of the estimate of sensor track heading, expressed in degrees.
     * The No-Statement value is sent when the sensor is unable or unwilling to provide a value.
     * (NOTE: The Nominal fields in the Job Definition Segment provide a means for reporting nominal
     * standard deviations and uncertainty values, and are to be used when values are not received
     * from the sensor. More precise values of these or related estimates may be reported in the
     * appropriate fields in either the Dwell Segment or the Target Report Sub-Segment, when the
     * sensor computes them and the communication bandwidth permits the more frequent reporting.)
     *
     * @return the sensor track uncertainty, in degrees (255 for no-statement).
     */
    public int getTrackHeadingUncertainty() {
        return trackHeadingUncertainty;
    }

    /**
     * Set the Nominal Sensor Position Uncertainty – Track Heading (J19).
     *
     * <p>Nominal standard deviation of the estimate of sensor track heading, expressed in degrees.
     * The No-Statement value is sent when the sensor is unable or unwilling to provide a value.
     * (NOTE: The Nominal fields in the Job Definition Segment provide a means for reporting nominal
     * standard deviations and uncertainty values, and are to be used when values are not received
     * from the sensor. More precise values of these or related estimates may be reported in the
     * appropriate fields in either the Dwell Segment or the Target Report Sub-Segment, when the
     * sensor computes them and the communication bandwidth permits the more frequent reporting.)
     *
     * @param trackHeadingUncertainty the sensor track uncertainty, in degrees with a valid range of
     *     [0, 45] or 255 for no-statement.
     */
    public void setTrackHeadingUncertainty(int trackHeadingUncertainty) {
        this.trackHeadingUncertainty = trackHeadingUncertainty;
    }

    /**
     * Nominal Sensor Position Uncertainty – Sensor Speed (J20).
     *
     * <p>Nominal standard deviation of the estimate of sensor speed, expressed in millimeters per
     * second. The No-Statement value is sent when the sensor is unable or unwilling to provide a
     * value.(NOTE: The Nominal fields in the Job Definition Segment provide a means for reporting
     * nominal standard deviations and uncertainty values, and are to be used when values are not
     * received from the sensor. More precise values of these or related estimates may be reported
     * in the appropriate fields in either the Dwell Segment or the Target Report Sub-Segment, when
     * the sensor computes them and the communication bandwidth permits the more frequent
     * reporting.)
     *
     * @return the sensor speed uncertainty in millimeters per second (65535 for no-statement)
     */
    public int getSensorSpeedUncertainty() {
        return sensorSpeedUncertainty;
    }

    /**
     * Set the Nominal Sensor Position Uncertainty – Sensor Speed (J20).
     *
     * <p>Nominal standard deviation of the estimate of sensor speed, expressed in millimeters per
     * second. The No-Statement value is sent when the sensor is unable or unwilling to provide a
     * value.(NOTE: The Nominal fields in the Job Definition Segment provide a means for reporting
     * nominal standard deviations and uncertainty values, and are to be used when values are not
     * received from the sensor. More precise values of these or related estimates may be reported
     * in the appropriate fields in either the Dwell Segment or the Target Report Sub-Segment, when
     * the sensor computes them and the communication bandwidth permits the more frequent
     * reporting.)
     *
     * @param sensorSpeedUncertainty the sensor speed uncertainty in millimetres per second (65535
     *     for no-statement)
     */
    public void setSensorSpeedUncertainty(int sensorSpeedUncertainty) {
        this.sensorSpeedUncertainty = sensorSpeedUncertainty;
    }

    /**
     * Get the Nominal Sensor Value – Slant Range Standard Deviation (J21).
     *
     * <p>Nominal standard deviation of the slant range of the reported detection, expressed in
     * centimetres. The No-Statement value is sent when the sensor is unable or unwilling to provide
     * a value.
     *
     * @return slant range standard deviation in centimetres (65535 for no-statement).
     */
    public int getSlantRangeStandardDeviation() {
        return slantRangeStandardDeviation;
    }

    /**
     * Set the Nominal Sensor Value – Slant Range Standard Deviation (J21).
     *
     * <p>Nominal standard deviation of the slant range of the reported detection, expressed in
     * centimetres. The No-Statement value is sent when the sensor is unable or unwilling to provide
     * a value.
     *
     * @param slantRangeStandardDeviation slant range standard deviation in centimetres (65535 for
     *     no-statement).
     */
    public void setSlantRangeStandardDeviation(int slantRangeStandardDeviation) {
        this.slantRangeStandardDeviation = slantRangeStandardDeviation;
    }

    /**
     * Get the Nominal Sensor Value – Cross Range Standard Deviation (J22).
     *
     * <p>Nominal standard deviation of the measured cross angle to the reported detection,
     * expressed in degrees as a 16-bit unsigned binary angle. A No-Statement value is sent when the
     * sensor is unable or unwilling to provide a value.
     *
     * @return cross range standard deviation in degrees (&ge; 180.0 for no-statement).
     */
    public double getCrossRangeStandardDeviation() {
        return crossRangeStandardDeviation;
    }

    /**
     * Set the Nominal Sensor Value – Cross Range Standard Deviation (J22).
     *
     * <p>Nominal standard deviation of the measured cross angle to the reported detection,
     * expressed in degrees as a 16-bit unsigned binary angle. A No-Statement value is sent when the
     * sensor is unable or unwilling to provide a value.
     *
     * @param crossRangeStandardDeviation cross range standard deviation in degrees (&ge; 180.0 for
     *     no-statement).
     */
    public void setCrossRangeStandardDeviation(double crossRangeStandardDeviation) {
        this.crossRangeStandardDeviation = crossRangeStandardDeviation;
    }

    /**
     * Get the Nominal Sensor Value – Target Velocity Line-of-Sight Component Standard Deviation
     * (J23).
     *
     * <p>Nominal standard deviation of the velocity line-of-sight component reported in field
     * D32.7, expressed in centimetres per second. The No-Statement value is sent when the sensor is
     * unable or unwilling to provide a value.
     *
     * @return targe velocity line of sight standard deviation in cm/s (65535 for no-statement).
     */
    public int getTargetVelocityLineOfSightStandardDeviation() {
        return targetVelocityLineOfSightStandardDeviation;
    }

    /**
     * Set the Nominal Sensor Value – Target Velocity Line-of-Sight Component Standard Deviation
     * (J23).
     *
     * <p>Nominal standard deviation of the velocity line-of-sight component reported in field
     * D32.7, expressed in centimetres per second. The No-Statement value is sent when the sensor is
     * unable or unwilling to provide a value.
     *
     * @param targetVelocityLineOfSightStandardDeviation target velocity line of sight standard
     *     deviation in cm/s (65535 for no-statement).
     */
    public void setTargetVelocityLineOfSightStandardDeviation(
            int targetVelocityLineOfSightStandardDeviation) {
        this.targetVelocityLineOfSightStandardDeviation =
                targetVelocityLineOfSightStandardDeviation;
    }

    /**
     * Nominal Sensor Value – MDV (J24).
     *
     * <p>Nominal minimum velocity component along the line of sight, which can be detected by the
     * sensor, expressed in decimeters per second. The No-Statement value is sent when the sensor is
     * unable or unwilling to provide a value. (NOTE: The Nominal fields in the Job Definition
     * Segment provide a means for reporting nominal sensor values, and are to be used when values
     * are not received from the sensor. More precise values of these or related estimates may be
     * reported in the appropriate fields in either the Dwell Segment or the Target Report
     * Sub-Segment, when the sensor computes them and the communication bandwidth permits the more
     * frequent reporting.)
     *
     * @return the nominal minimum detectable velocity in decimeters per second (or 255 for
     *     no-statement).
     */
    public int getMdv() {
        return mdv;
    }

    /**
     * Set the Nominal Sensor Value – MDV (J24).
     *
     * <p>Nominal minimum velocity component along the line of sight, which can be detected by the
     * sensor, expressed in decimeters per second. The No-Statement value is sent when the sensor is
     * unable or unwilling to provide a value. (NOTE: The Nominal fields in the Job Definition
     * Segment provide a means for reporting nominal sensor values, and are to be used when values
     * are not received from the sensor. More precise values of these or related estimates may be
     * reported in the appropriate fields in either the Dwell Segment or the Target Report
     * Sub-Segment, when the sensor computes them and the communication bandwidth permits the more
     * frequent reporting.)
     *
     * @param mdv the nominal minimum detectable velocity in decimeters per second with a valid
     *     range of [0,254] or 255 for no-statement.
     */
    public void setMdv(int mdv) {
        this.mdv = mdv;
    }

    /**
     * Nominal Sensor Value – Detection Probability (J25).
     *
     * <p>Nominal probability that an unobscured ten square-meter target will be detected within the
     * given area of surveillance, assuming the Swerling model appropriate for the particular radar
     * target. The No-Statement value is sent when the sensor is unable or unwilling to provide a
     * value. (NOTE: The Nominal fields in the Job Definition Segment provide a means for reporting
     * nominal sensor values, and are to be used when values are not received from the sensor. More
     * precise values of these or related estimates may be reported in the appropriate fields in
     * either the Dwell Segment or the Target Report Sub-Segment, when the sensor computes them and
     * the communication bandwidth permits the more frequent reporting.)
     *
     * @return the detection probability as a percentage, or 255 for no-statement
     */
    public int getDetectionProbability() {
        return detectionProbability;
    }

    /**
     * Set the Nominal Sensor Value – Detection Probability (J25).
     *
     * <p>Nominal probability that an unobscured ten square-meter target will be detected within the
     * given area of surveillance, assuming the Swerling model appropriate for the particular radar
     * target. The No-Statement value is sent when the sensor is unable or unwilling to provide a
     * value. (NOTE: The Nominal fields in the Job Definition Segment provide a means for reporting
     * nominal sensor values, and are to be used when values are not received from the sensor. More
     * precise values of these or related estimates may be reported in the appropriate fields in
     * either the Dwell Segment or the Target Report Sub-Segment, when the sensor computes them and
     * the communication bandwidth permits the more frequent reporting.)
     *
     * @param detectionProbability the detection probability as a percentage in the valid range
     *     [0,100], or 255 for no-statement.
     */
    public void setDetectionProbability(int detectionProbability) {
        this.detectionProbability = detectionProbability;
    }

    /**
     * Nominal Sensor Value – False Alarm Density (J26).
     *
     * <p>The expected density of False Alarms (FA), expressed as the negative of the decibel value
     * ( 10 log<sub>10</sub> d, where d is in FA per square meter). Zero decibels (0 dB) represents
     * 1 FA/m<sup>2</sup> and 60 dB represents 10<sup>-6</sup> FA/m<sup>2</sup> (i.e. 1
     * FA/km<sup>2</sup>). GMTI data with a False Alarm Density greater than one (FA/m<sup>2</sup>
     * &gt; 1) is of no operational value and is range limited to 0 dB.(NOTE: The Nominal fields in
     * the Job Definition Segment provide a means for reporting nominal sensor values, and are to be
     * used when values are not received from the sensor. More precise values of these or related
     * estimates may be reported in the appropriate fields in either the Dwell Segment or the Target
     * Report Sub-Segment, when the sensor computes them and the communication bandwidth permits the
     * more frequent reporting.)
     *
     * @return the nominal false alarm density in (negative) dB, or 255 for no-statement.
     */
    public int getFalseAlarmDensity() {
        return falseAlarmDensity;
    }

    /**
     * Set the Nominal Sensor Value – False Alarm Density (J26).
     *
     * <p>The expected density of False Alarms (FA), expressed as the negative of the decibel value
     * ( 10 log<sub>10</sub> d, where d is in FA per square meter). Zero decibels (0 dB) represents
     * 1 FA/m<sup>2</sup> and 60 dB represents 10<sup>-6</sup> FA/m<sup>2</sup> (i.e. 1
     * FA/km<sup>2</sup>). GMTI data with a False Alarm Density greater than one (FA/m<sup>2</sup>
     * &gt; 1) is of no operational value and is range limited to 0 dB.(NOTE: The Nominal fields in
     * the Job Definition Segment provide a means for reporting nominal sensor values, and are to be
     * used when values are not received from the sensor. More precise values of these or related
     * estimates may be reported in the appropriate fields in either the Dwell Segment or the Target
     * Report Sub-Segment, when the sensor computes them and the communication bandwidth permits the
     * more frequent reporting.)
     *
     * @param falseAlarmDensity the nominal false alarm density in (negative) dB (valid range 0 to
     *     254), or 255 for no-statement.
     */
    public void setFalseAlarmDensity(int falseAlarmDensity) {
        this.falseAlarmDensity = falseAlarmDensity;
    }

    /**
     * Terrain Elevation Model Used (J27).
     *
     * <p>An enumeration field indicating the terrain elevation model used for developing the target
     * reports.
     *
     * <table border="1">
     * <caption>Terrain Elevation Model</caption>
     * <thead>
     * <tr><td>Value</td><td>Terrain Elevation Model</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>0</td><td>None Specified</td></tr>
     * <tr><td>1</td><td>DTED0 (Digital Terrain Elevation Data, Level 0)</td></tr>
     * <tr><td>2</td><td>DTED1 (Digital Terrain Elevation Data, Level 1)</td></tr>
     * <tr><td>3</td><td>DTED2 (Digital Terrain Elevation Data, Level 2)</td></tr>
     * <tr><td>4</td><td>DTED3 (Digital Terrain Elevation Data, Level 3)</td></tr>
     * <tr><td>5</td><td>DTED4 (Digital Terrain Elevation Data, Level 4)</td></tr>
     * <tr><td>6</td><td>DTED5 (Digital Terrain Elevation Data, Level 5)</td></tr>
     * <tr><td>7</td><td>SRTM1 (Shuttle Radar Topography Mission, Level 1)</td></tr>
     * <tr><td>8</td><td>SRTM2 (Shuttle Radar Topography Mission, Level 2)</td></tr>
     * <tr><td>9</td><td>DGM50 M745 (Digitales Gelandemodell 1:50 000)</td></tr>
     * <tr><td>10</td><td>DGM250 (Digitales Gelandemodell 1:250 000)</td></tr>
     * <tr><td>11</td><td>ITHD (Interferometric Terrain Data Height)</td></tr>
     * <tr><td>12</td><td>STHD (Stereometric Terrain Data Height)</td></tr>
     * <tr><td>13</td><td>SEDRIS (SEDRIS Reference Model, ISO/IEC 18026</td></tr>
     * <tr><td>14-255</td><td>Reserved</td></tr>
     * </tbody>
     * </table>
     *
     * @return the terrain elevation model as an integer value
     */
    public int getTerrainElevationModelUsed() {
        return terrainElevationModelUsed;
    }

    /**
     * Set the Terrain Elevation Model Used (J27).
     *
     * <p>An enumeration field indicating the terrain elevation model used for developing the target
     * reports.
     *
     * <table border="1">
     * <caption>Terrain Elevation Model</caption>
     * <thead>
     * <tr><td>Value</td><td>Terrain Elevation Model</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>0</td><td>None Specified</td></tr>
     * <tr><td>1</td><td>DTED0 (Digital Terrain Elevation Data, Level 0)</td></tr>
     * <tr><td>2</td><td>DTED1 (Digital Terrain Elevation Data, Level 1)</td></tr>
     * <tr><td>3</td><td>DTED2 (Digital Terrain Elevation Data, Level 2)</td></tr>
     * <tr><td>4</td><td>DTED3 (Digital Terrain Elevation Data, Level 3)</td></tr>
     * <tr><td>5</td><td>DTED4 (Digital Terrain Elevation Data, Level 4)</td></tr>
     * <tr><td>6</td><td>DTED5 (Digital Terrain Elevation Data, Level 5)</td></tr>
     * <tr><td>7</td><td>SRTM1 (Shuttle Radar Topography Mission, Level 1)</td></tr>
     * <tr><td>8</td><td>SRTM2 (Shuttle Radar Topography Mission, Level 2)</td></tr>
     * <tr><td>9</td><td>DGM50 M745 (Digitales Gelandemodell 1:50 000)</td></tr>
     * <tr><td>10</td><td>DGM250 (Digitales Gelandemodell 1:250 000)</td></tr>
     * <tr><td>11</td><td>ITHD (Interferometric Terrain Data Height)</td></tr>
     * <tr><td>12</td><td>STHD (Stereometric Terrain Data Height)</td></tr>
     * <tr><td>13</td><td>SEDRIS (SEDRIS Reference Model, ISO/IEC 18026</td></tr>
     * <tr><td>14-255</td><td>Reserved</td></tr>
     * </tbody>
     * </table>
     *
     * @param terrainElevationModelUsed the terrain elevation model as an integer value
     */
    public void setTerrainElevationModelUsed(int terrainElevationModelUsed) {
        this.terrainElevationModelUsed = terrainElevationModelUsed;
    }

    /**
     * Geoid Model Used (J28).
     *
     * <p>An enumeration field indicating the geoid model used for developing the target reports.
     * The geoid model gives an estimate of mean sea level via a model for the difference between
     * the earth's zero-altitude gravity potential and the WGS 84 ellipsoid. Note that no DTED earth
     * model will be specified in Field J27 when the Geoid Model Used in field J28 is selected to be
     * Flat Earth. Refer to Para. 4.0 of Annex B to STANAG 4607 for further details of Geoid Models
     * and Coordinate Systems.
     *
     * <table border="1">
     * <caption>Geoid Models</caption>
     * <thead>
     * <tr><td>Value</td><td>Terrain Elevation Model</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>0</td><td>None Specified</td></tr>
     * <tr><td>1</td><td>EGM96 (Earth Gravitational Model, Version 1996)</td></tr>
     * <tr><td>2</td><td>GEO96 (Geoid Gravitational Model, Version 1996)</td></tr>
     * <tr><td>3</td><td>Flat Earth</td></tr>
     * <tr><td>4-255</td><td>Reserved</td></tr>
     * </tbody>
     * </table>
     *
     * @return the geoid model used as an integer
     */
    public int getGeoidModelUsed() {
        return geoidModelUsed;
    }

    /**
     * Geoid Model Used (J28).
     *
     * <p>An enumeration field indicating the geoid model used for developing the target reports.
     * The geoid model gives an estimate of mean sea level via a model for the difference between
     * the earth's zero-altitude gravity potential and the WGS 84 ellipsoid. Note that no DTED earth
     * model will be specified in Field J27 when the Geoid Model Used in field J28 is selected to be
     * Flat Earth. Refer to Para. 4.0 of Annex B to STANAG 4607 for further details of Geoid Models
     * and Coordinate Systems.
     *
     * <table border="1">
     * <caption>Geoid Models</caption>
     * <thead>
     * <tr><td>Value</td><td>Terrain Elevation Model</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>0</td><td>None Specified</td></tr>
     * <tr><td>1</td><td>EGM96 (Earth Gravitational Model, Version 1996)</td></tr>
     * <tr><td>2</td><td>GEO96 (Geoid Gravitational Model, Version 1996)</td></tr>
     * <tr><td>3</td><td>Flat Earth</td></tr>
     * <tr><td>4-255</td><td>Reserved</td></tr>
     * </tbody>
     * </table>
     *
     * @param geoidModelUsed the geoid model value as an integer
     */
    public void setGeoidModelUsed(int geoidModelUsed) {
        this.geoidModelUsed = geoidModelUsed;
    }
}
