package net.frogmouth.rnd.jim.s4607.TestAndStatusSegment;

import net.frogmouth.rnd.jim.s4607.Segment.Segment;
import net.frogmouth.rnd.jim.s4607.Segment.SegmentType;

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
}
