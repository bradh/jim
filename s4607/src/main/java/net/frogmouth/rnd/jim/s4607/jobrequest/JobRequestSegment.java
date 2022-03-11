package net.frogmouth.rnd.jim.s4607.jobrequest;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.s4607.BoundingArea;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Job Request Segment.
 *
 * <p>The Job Request Segment provides the means to pass tasking information, such as a Radar or
 * Sensor Service Request (RSR or SSR) or a request for Test / Status of the sensor, to the
 * platform. It shall be sent as required.
 *
 * <p>All fields in the Job Request Segment are mandatory.
 */
public class JobRequestSegment extends Segment {

    private String requestorID;
    private String requestorTaskId;
    private int priority;
    private BoundingArea boundingArea;
    private int radarMode;
    private int radarResolutionRange;
    private int radarResolutionCrossRange;
    private ZonedDateTime earliestStartTime;
    private int startTimeAllowedDelay;
    private int duration;
    private int revisitInterval;
    private int sensorIdType;
    private String sensorIdModel;
    private int requestType;

    /**
     * Constructor.
     *
     * <p>Note that all elements of the Job Request Segment are mandatory.
     */
    public JobRequestSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.JobRequestSegment;
    }

    /**
     * Requestor ID (R1).
     *
     * <p>An alphanumeric field that identifies the requestor of the sensor service.
     *
     * @return the requestor identification as a string (10 characters maximum, space padded)
     */
    public String getRequestorID() {
        return requestorID;
    }

    /**
     * Set the Requestor ID (R1).
     *
     * <p>An alphanumeric field that identifies the requestor of the sensor service.
     *
     * @param requestorID the requestor identification as a string (10 characters maximum).
     */
    public void setRequestorID(String requestorID) {
        this.requestorID = requestorID;
    }

    /**
     * Requestor Task ID (R2).
     *
     * <p>An identifier for the tasking message sent by the requesting station.
     *
     * @return the requestor task identifier as a string (10 characters maximum, space padded).
     */
    public String getRequestorTaskId() {
        return requestorTaskId;
    }

    /**
     * Set the Requestor Task ID (R2).
     *
     * <p>An identifier for the tasking message sent by the requesting station.
     *
     * @param taskId the requestor task identifier as a string (10 characters maximum)
     */
    public void setRequestorTaskId(String taskId) {
        this.requestorTaskId = taskId;
    }

    /**
     * Priority (Requestor Priority) (R3).
     *
     * <p>Specifies the priority of the request relative to other requests originated by the
     * requesting station.
     *
     * <p>1 is highest, 99 is lowest, and 0 is "default priority".
     *
     * @return requestor priority as an integer.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the Priority (Requestor Priority) (R3).
     *
     * <p>Specifies the priority of the request relative to other requests originated by the
     * requesting station.
     *
     * <p>1 is highest, 99 is lowest, and 0 is "default priority".
     *
     * @param priority requestor priority as an integer.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Bounding area (R4 through R11).
     *
     * <p>Bounding box for the requested area for sensor service. The four corners (R4 through J11)
     * of the bounding area, expressed as lat/long for each corner, are given in clockwise order
     * (Points A, B, C, and D) and must form a convex quadrilateral.
     *
     * @return the bounding area.
     */
    public BoundingArea getBoundingArea() {
        return new BoundingArea(boundingArea);
    }

    /**
     * Set the Bounding area (R4 through R11).
     *
     * <p>Bounding box for the requested area for sensor service. The four corners (R4 through J11)
     * of the bounding area, expressed as lat/long for each corner, are given in clockwise order
     * (Points A, B, C, and D) and must form a convex quadrilateral.
     *
     * @param area the bounding area
     */
    public void setBoundingArea(BoundingArea area) {
        this.boundingArea = new BoundingArea(area);
    }

    /**
     * Radar Mode (R12).
     *
     * <p>An enumeration that identifies the radar mode requested by the requestor. Note that radar
     * modes are system-specific and shall be determined for each system.
     *
     * <p>Note that radar modes 0-5 are generic modes that will be used in non-platform-specific job
     * requests. The remaining radar modes are a sampling of platform-specific modes. They are not
     * comprehensive and shall be expanded as necessary.
     *
     * @return the requested radar mode.
     */
    public int getRadarMode() {
        return radarMode;
    }

    /**
     * Set the Radar Mode (R12).
     *
     * <p>An enumeration that identifies the radar mode requested by the requestor. Note that radar
     * modes are system-specific and shall be determined for each system.
     *
     * <p>Note that radar modes 0-5 are generic modes that will be used in non-platform-specific job
     * requests. The remaining radar modes are a sampling of platform-specific modes. They are not
     * comprehensive and shall be expanded as necessary.
     *
     * @param mode the requested radar mode.
     */
    public void setRadarMode(int mode) {
        this.radarMode = mode;
    }

    /**
     * Radar Resolution – Range (R13).
     *
     * <p>Specifies the radar range resolution requested by the requestor, expressed in centimetres.
     *
     * @return the requested radar range resolution in centimetres.
     */
    public int getRadarResolutionRange() {
        return radarResolutionRange;
    }

    /**
     * Set the Radar Resolution – Range (R13).
     *
     * <p>Specifies the radar range resolution requested by the requestor, expressed in centimetres.
     *
     * @param rangeResolution the requested radar range resolution in centimetres.
     */
    public void setRadarResolutionRange(int rangeResolution) {
        this.radarResolutionRange = rangeResolution;
    }

    /**
     * Radar Resolution – Cross-Range (R14).
     *
     * <p>Specifies the radar cross-range resolution requested by the requestor, expressed in
     * decimetres (tenths of metres).
     *
     * @return the requested radar cross-range resolution in decimetres.
     */
    public int getRadarResolutionCrossRange() {
        return radarResolutionCrossRange;
    }

    /**
     * Set the Radar Resolution – Cross-Range (R14).
     *
     * <p>Specifies the radar cross-range resolution requested by the requestor, expressed in
     * decimetres (tenths of metres).
     *
     * @param crossRangeResolution the requested radar cross-range resolution in decimetres.
     */
    public void setRadarResolutionCrossRange(int crossRangeResolution) {
        this.radarResolutionCrossRange = crossRangeResolution;
    }

    /**
     * Earliest start time (R15 through R20).
     *
     * <p>The earliest start time for which the service is requested.
     *
     * @return the earliest start time (UTC)
     */
    public ZonedDateTime getEarliestStartTime() {
        return earliestStartTime;
    }

    /**
     * Set the earliest start time (R15 through R20).
     *
     * <p>The earliest start time for which the service is requested.
     *
     * @param earliestStartTime the earliest start time (UTC)
     */
    public void setEarliestStartTime(ZonedDateTime earliestStartTime) {
        this.earliestStartTime = earliestStartTime;
    }

    /**
     * Earliest Start Time – Allowed Delay (R21).
     *
     * <p>Specifies the maximum time from the requested start time after which the request is to be
     * abandoned, expressed in seconds.
     *
     * @return the allowable delay after the earliest start time, in seconds (valid range 0 to
     *     65535)
     */
    public int getStartTimeAllowedDelay() {
        return startTimeAllowedDelay;
    }

    /**
     * Set the earliest Start Time – Allowed Delay (R21).
     *
     * <p>Specifies the maximum time from the requested start time after which the request is to be
     * abandoned, expressed in seconds.
     *
     * @param delay the allowable delay after the earliest start time, in seconds (valid range 0 to
     *     65535)
     */
    public void setStartTimeAllowedDelay(int delay) {
        this.startTimeAllowedDelay = delay;
    }

    /**
     * Duration (R22).
     *
     * <p>Specifies the time duration for the radar job, measured from the actual start of the job,
     * expressed in seconds.
     *
     * @return the duration in seconds (1 to 65535, 0 indicates continuous)
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set the Duration (R22).
     *
     * <p>Specifies the time duration for the radar job, measured from the actual start of the job,
     * expressed in seconds.
     *
     * @param duration duration in seconds (valid range 1 to 65535, or 0 for continuous)
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Revisit Interval (R23).
     *
     * <p>Specifies the revisit interval for the radar job, expressed in deciseconds (tenths of
     * seconds).
     *
     * @return revisit interval in deciseconds (1 to 65535), or 0 for default interval
     */
    public int getRevisitInterval() {
        return revisitInterval;
    }

    /**
     * Set the Revisit Interval (R23).
     *
     * <p>Specifies the revisit interval for the radar job, expressed in deciseconds (tenths of
     * seconds).
     *
     * @param interval revisit interval in deciseconds (1 to 65535), or 0 for default interval
     */
    public void setRevisitInterval(int interval) {
        this.revisitInterval = interval;
    }

    /**
     * Sensor ID – Type (R24).
     *
     * <p>An enumeration denoting the type of sensor or the platform. A Sensor ID - Type value of
     * {@code 255} indicates that it is a No Statement and no sensor type is specified.
     *
     * @return sensor or platform identifier as an enumerated value, or 255 for no statement
     */
    public int getSensorIdType() {
        return sensorIdType;
    }

    /**
     * Set the Sensor ID – Type (R24).
     *
     * <p>An enumeration denoting the type of sensor or the platform. A Sensor ID - Type value of
     * {@code 255} indicates that it is a No Statement and no sensor type is specified.
     *
     * @param id sensor or platform identifier as an enumerated value, or 255 for no statement
     */
    public void setSensorIdType(int id) {
        this.sensorIdType = id;
    }

    /**
     * Sensor ID – Model (R25).
     *
     * <p>An alphanumeric field identifying the particular variant of the sensor type. A Sensor ID –
     * Model value of {@code None} indicates that it is a No Statement and no sensor model is
     * specified.
     *
     * @return the sensor model, or None for no statement (6 characters maximum, space padded)
     */
    public String getSensorIdModel() {
        return sensorIdModel;
    }

    /**
     * Set the Sensor ID – Model (R25).
     *
     * <p>An alphanumeric field identifying the particular variant of the sensor type. A Sensor ID –
     * Model value of {@code None} indicates that it is a No Statement and no sensor model is
     * specified.
     *
     * @param model the sensor model, or None for no statement (6 characters maximum)
     */
    public void setSensorIdModel(String model) {
        this.sensorIdModel = model;
    }

    /**
     * Request Type (R26).
     *
     * <p>A flag field indicating that it is an initial request (flag = 0) or the desire of the
     * requestor to cancel (flag = 1) the requested job.
     *
     * @return 0 to create the job, or 1 to cancel the job
     */
    public int getRequestType() {
        return requestType;
    }

    /**
     * Set the Request Type (R26).
     *
     * <p>A flag field indicating that it is an initial request (flag = 0) or the desire of the
     * requestor to cancel (flag = 1) the requested job.
     *
     * @param requestType 0 to create the job, or 1 to cancel the job
     */
    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }
}
