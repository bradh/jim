package net.frogmouth.rnd.jim.s4607.testandstatus;

import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Test and Status Segment.
 *
 * <p>The Test and Status Segment provides information pertaining to the health of the sensor. It is
 * related to a particular job, revisit, and dwell of the sensor, and shall be sent as required or
 * as requested in the Job Request Segment.
 *
 * <p>All fields in the Test and Status Segment are mandatory.
 */
public class TestAndStatusSegment extends Segment {

    private long jobId;
    private int revisitIndex;
    private int dwellIndex;
    private long dwellTime;
    private HardwareStatus hardwareStatus;
    private ModeStatus modeStatus;

    /** Constructor. */
    public TestAndStatusSegment() {}

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.TestAndStatusSegment;
    }

    /**
     * Job ID (T1).
     *
     * <p>A platform assigned number identifying the specific request or task to which the dwell
     * pertains.
     *
     * @return the job identifier as a long integer.
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * Set the Job ID (T1).
     *
     * <p>A platform assigned number identifying the specific request or task to which the dwell
     * pertains.
     *
     * @param jobId the job identifier as an integer, in the range 0 to 4294967295.
     */
    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    /**
     * Revisit Index (T2).
     *
     * <p>The sequential count of a revisit of the bounding area for a given job ID.
     *
     * @return the revisit index as an integer
     */
    public int getRevisitIndex() {
        return revisitIndex;
    }

    /**
     * Revisit Index (T2).
     *
     * <p>The sequential count of a revisit of the bounding area for a given job ID.
     *
     * @param revisitIndex revisit index as an integer, in the range 1 to 65535.
     */
    public void setRevisitIndex(int revisitIndex) {
        this.revisitIndex = revisitIndex;
    }

    /**
     * Dwell Index (T3).
     *
     * <p>The sequential count of a dwell within the revisit of a particular bounding area for a
     * given job ID.
     *
     * @return the dwell index count as an integer.
     */
    public int getDwellIndex() {
        return dwellIndex;
    }

    /**
     * Set the Dwell Index (T3).
     *
     * <p>The sequential count of a dwell within the revisit of a particular bounding area for a
     * given job ID.
     *
     * @param dwellIndex the dwell index count as an integer, in the range 1 to 65535.
     */
    public void setDwellIndex(int dwellIndex) {
        this.dwellIndex = dwellIndex;
    }

    /**
     * Dwell Time (T4).
     *
     * <p>The elapsed time, expressed in milliseconds, from midnight at the beginning of the day
     * specified in the Reference Time fields of the Mission Segment to the temporal centre of the
     * dwell specified in this segment.
     *
     * @return the dwell time in milliseconds
     */
    public long getDwellTime() {
        return dwellTime;
    }

    /**
     * Set the Dwell Time (T4).
     *
     * <p>The elapsed time, expressed in milliseconds, from midnight at the beginning of the day
     * specified in the Reference Time fields of the Mission Segment to the temporal centre of the
     * dwell specified in this segment.
     *
     * @param dwellTime the dwell time in milliseconds, in the range 0 to 4 x 10<sup>9</sup>.
     */
    public void setDwellTime(long dwellTime) {
        this.dwellTime = dwellTime;
    }

    /**
     * Hardware Status (T5).
     *
     * <p>A one-byte flag, where each flag bit indicates the status of a particular hardware
     * parameter.
     *
     * @return the hardware status
     */
    public HardwareStatus getHardwareStatus() {
        return hardwareStatus;
    }

    /**
     * Set the Hardware Status (T5).
     *
     * <p>A one-byte flag, where each flag bit indicates the status of a particular hardware
     * parameter.
     *
     * @param hardwareStatus the hardware status
     */
    public void setHardwareStatus(HardwareStatus hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }

    /**
     * Mode Status (T6).
     *
     * <p>A one-byte flag, where each flag bit indicates the status of a particular sensor
     * parameter, and where a binary 0 indicates the parameter is inside the operational limit tests
     * and a binary 1 indicates the parameter is outside the operational limit tests. Unused or
     * spare bits shall be set to binary 0.
     *
     * @return the mode status
     */
    public ModeStatus getModeStatus() {
        return modeStatus;
    }

    /**
     * Set the Mode Status (T6).
     *
     * <p>A one-byte flag, where each flag bit indicates the status of a particular sensor
     * parameter, and where a binary 0 indicates the parameter is inside the operational limit tests
     * and a binary 1 indicates the parameter is outside the operational limit tests. Unused or
     * spare bits shall be set to binary 0.
     *
     * @param modeStatus the mode status
     */
    public void setModeStatus(ModeStatus modeStatus) {
        this.modeStatus = modeStatus;
    }
}
