package net.frogmouth.rnd.jim.s4607.jobacknowledge;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.BoundingArea;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Job Acknowledge Segment.
 *
 * <p>The Job Acknowledge Segment provides the means for the requestor to receive an acknowledgement
 * from the platform concerning the status of their request.
 *
 * <p>It shall be sent once to acknowledge the status of a particular job request.
 *
 * <p>All fields in the Job Definition Segment are mandatory.
 */
public class JobAcknowledgeSegment extends Segment {

    private long jobId;
    private String requestorID;
    private String requestorTaskId;
    private int sensorIdType;
    private String sensorIdModel;
    private int priority;
    private BoundingArea boundingArea;
    private int radarMode;
    private int duration;
    private int revisitInterval;
    private int requestStatus;
    private ZonedDateTime radarJobStartTime;
    private String requestorNationalityId;

    /**
     * Constructor.
     *
     * <p>Note that all elements of the Job Acknowledgement Segment are mandatory.
     */
    public JobAcknowledgeSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobAcknowledgeSegment;
    }

    /**
     * Job ID (A1).
     *
     * <p>A platform assigned number identifying the specific request or task to all Dwell, HRR, and
     * Range-Doppler segments in the packet. The Job ID shall be unique within a mission. If the
     * Packet contains no Dwell, HRR, or Range-Doppler segments, then the Job ID in the Packet
     * Header shall be 0 (hex 0x00). If the Packet contains Dwell, HRR, or Range-Doppler segments,
     * then the Job ID in the Packet Header shall be the non-zero Job ID corresponding to those
     * segments.
     *
     * @return the job identifier
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * Set the Job ID (A1).
     *
     * <p>A platform assigned number identifying the specific request or task to all Dwell, HRR, and
     * Range-Doppler segments in the packet. The Job ID shall be unique within a mission. If the
     * Packet contains no Dwell, HRR, or Range-Doppler segments, then the Job ID in the Packet
     * Header shall be 0 (hex 0x00). If the Packet contains Dwell, HRR, or Range-Doppler segments,
     * then the Job ID in the Packet Header shall be the non-zero Job ID corresponding to those
     * segments.
     *
     * @param jobId the job identifier as an integer (valid range 1 to 4294967295)
     */
    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    /**
     * Requestor ID (A2).
     *
     * <p>An alphanumeric field that identifies the requestor of the sensor service.
     *
     * @return the requestor identification as a string (10 characters maximum, space padded)
     */
    public String getRequestorID() {
        return requestorID;
    }

    /**
     * Set the Requestor ID (A2).
     *
     * <p>An alphanumeric field that identifies the requestor of the sensor service.
     *
     * @param requestorID the requestor identification as a string (10 characters maximum).
     */
    public void setRequestorID(String requestorID) {
        this.requestorID = requestorID;
    }

    /**
     * Requestor Task ID (A3).
     *
     * <p>An identifier for the tasking message sent by the requesting station.
     *
     * @return the requestor task identifier as a string (10 characters maximum, space padded).
     */
    public String getRequestorTaskId() {
        return requestorTaskId;
    }

    /**
     * Set the Requestor Task ID (A3).
     *
     * <p>An identifier for the tasking message sent by the requesting station.
     *
     * @param taskId the requestor task identifier as a string (10 characters maximum)
     */
    public void setRequestorTaskId(String taskId) {
        this.requestorTaskId = taskId;
    }

    /**
     * Sensor ID – Type (A4).
     *
     * <p>An enumeration table denoting the type of sensor or the platform providing the service.
     *
     * @return the sensor identifier as an enumerated value.
     */
    public int getSensorIdType() {
        return sensorIdType;
    }

    /**
     * Set the Sensor ID – Type (A4).
     *
     * <p>An enumeration table denoting the type of sensor or the platform providing the service.
     *
     * @param sensorIdType the sensor identifier as an enumerated value.
     */
    public void setSensorIdType(int sensorIdType) {
        this.sensorIdType = sensorIdType;
    }

    /**
     * Sensor ID – Model (A5).
     *
     * <p>An alphanumeric field identifying the particular variant of the sensor type providing the
     * service.
     *
     * @return the sensor model identifier (6 characters, space padded)
     */
    public String getSensorIdModel() {
        return sensorIdModel;
    }

    /**
     * Set the Sensor ID – Model (A5).
     *
     * <p>An alphanumeric field identifying the particular variant of the sensor type providing the
     * service.
     *
     * @param sensorIdModel the sensor model identifier (6 characters maximum)
     */
    public void setSensorIdModel(String sensorIdModel) {
        this.sensorIdModel = sensorIdModel;
    }

    /**
     * Priority (Radar Priority) (A6).
     *
     * <p>Specifies the priority of this tasking request relative to all other active tasking
     * requests scheduled for execution on the specified platform.
     *
     * @return tasking priority as an integer (range 1 to 99, 1 is highest, 99 is lowest)
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the Priority (Radar Priority) (A6).
     *
     * <p>Specifies the priority of this tasking request relative to all other active tasking
     * requests scheduled for execution on the specified platform.
     *
     * @param priority tasking priority as an integer (range 1 to 99, 1 is highest, 99 is lowest)
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Bounding area (A7 through A14).
     *
     * <p>Bounding box for the area for sensor service. The four corners (R4 through J11) of the
     * bounding area, expressed as lat/long for each corner, are given in clockwise order (Points A,
     * B, C, and D) and must form a convex quadrilateral.
     *
     * @return the sensor service area bounding box
     */
    public BoundingArea getBoundingArea() {
        return new BoundingArea(boundingArea);
    }

    /**
     * Bounding area (A7 through A14).
     *
     * <p>Bounding box for the area for sensor service. The four corners (R4 through J11) of the
     * bounding area, expressed as lat/long for each corner, are given in clockwise order (Points A,
     * B, C, and D) and must form a convex quadrilateral.
     *
     * @param area the sensor service area bounding box
     */
    public void setBoundingArea(BoundingArea area) {
        this.boundingArea = new BoundingArea(area);
    }

    /**
     * Radar Mode (A15).
     *
     * <p>An enumeration table that identifies the mode in which the radar will operate for the
     * given job ID. Radar operating modes are system-specific and shall be determined for each
     * system. Note that radar modes 0-5 are generic modes that will be used in non-platform-
     * specific job requests.
     *
     * @return the radar mode as an enumerated value
     */
    public int getRadarMode() {
        return radarMode;
    }

    /**
     * Set the Radar Mode (A15).
     *
     * <p>An enumeration table that identifies the mode in which the radar will operate for the
     * given job ID. Radar operating modes are system-specific and shall be determined for each
     * system. Note that radar modes 0-5 are generic modes that will be used in non-platform-
     * specific job requests.
     *
     * @param mode the radar mode as an enumerated value
     */
    public void setRadarMode(int mode) {
        this.radarMode = mode;
    }

    /**
     * Duration (A16). Specifies the time duration for the radar job, measured from the actual start
     * of the radar job, expressed in seconds.
     *
     * @return the radar job duration in seconds (valid range 1 to 65535) or 0 for continuous
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set the Duration (A16).
     *
     * <p>Specifies the time duration for the radar job, measured from the actual start of the radar
     * job, expressed in seconds.
     *
     * @param duration the radar job duration in seconds (valid range 1 to 65535) or 0 for
     *     continuous
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Revisit Interval (A17).
     *
     * <p>Specifies the revisit interval for the radar job, expressed in deciseconds (tenths of
     * seconds).
     *
     * @return the revisit interval in deciseconds (valid range 1 to 65535) or 0 for default
     *     interval
     */
    public int getRevisitInterval() {
        return revisitInterval;
    }

    /**
     * Set the Revisit Interval (A17).
     *
     * <p>Specifies the revisit interval for the radar job, expressed in deciseconds (tenths of
     * seconds).
     *
     * @param interval the revisit interval in deciseconds (valid range 1 to 65535) or 0 for default
     *     interval
     */
    public void setRevisitInterval(int interval) {
        this.revisitInterval = interval;
    }

    /**
     * Request Status (A18).
     *
     * <p>An enumerated value specifying the reason for rejection (or acceptance) of the requested
     * service. If the request is "Approved, With Modifications", it shall be the responsibility of
     * the requestor to examine the Job Acknowledge segment and determine the changes that were made
     * to the request.
     *
     * @return the request status as an enumerated value
     */
    public int getRequestStatus() {
        return requestStatus;
    }

    /**
     * Set the Request Status (A18).
     *
     * <p>An enumerated value specifying the reason for rejection (or acceptance) of the requested
     * service. If the request is "Approved, With Modifications", it shall be the responsibility of
     * the requestor to examine the Job Acknowledge segment and determine the changes that were made
     * to the request.
     *
     * @param status the request status as an enumerated value
     */
    public void setRequestStatus(int status) {
        this.requestStatus = status;
    }

    /**
     * Radar Job Start Time (A19 through A24).
     *
     * <p>Specifies when the radar job will start.
     *
     * @return the start time, in UTC
     */
    public ZonedDateTime getRadarJobStartTime() {
        return radarJobStartTime;
    }

    /**
     * Set the Radar Job Start Time (A19 through A24).
     *
     * <p>Specifies when the radar job will start.
     *
     * @param startTime the start time, in UTC
     */
    public void setRadarJobStartTime(ZonedDateTime startTime) {
        this.radarJobStartTime = startTime;
    }

    /**
     * Requestor Nationality ID (A25).
     *
     * <p>A digraph which identifies the nationality of the requestor of the radar job. NATO
     * requestors shall use the digraph XN.
     *
     * @return the requestor nationality identifier
     */
    public String getRequestorNationalityId() {
        return requestorNationalityId;
    }

    /**
     * Set the Requestor Nationality ID (A25).
     *
     * <p>A digraph which identifies the nationality of the requestor of the radar job. NATO
     * requestors shall use the digraph XN.
     *
     * @param nationality the requestor nationality identifier
     */
    public void setRequestorNationalityId(String nationality) {
        this.requestorNationalityId = nationality;
    }
}
