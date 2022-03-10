package net.frogmouth.rnd.jim.s4607.processinghistory;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * Processing History Segment.
 *
 * <p>The Processing History Segment provides information concerning changes or modifications made
 * to the original or modified sensor data. It references the Nationality, Platform, Mission, and
 * Job ID values of the original radar job and describes subsequent processing operations performed
 * on the data from that radar job. It provides notification that the original data values may have
 * been altered and provides a record of one or more processing operations performed on the original
 * radar data by one or more systems. If the processing performed by a system is based on data which
 * has been previously processed or modified, the system shall be responsible for maintaining the
 * previous processing history and for adding information pertaining to the current processing which
 * it has applied. Within the Processing History Segment, the system providing the additional
 * processing shall develop a new Processing Record to provide information pertaining to the
 * processed data which it is sending. The Processing Record shall include Nationality, Platform,
 * Mission, and Job ID information that identifies the processing system as the originator of the
 * processed data. The systems shall also provide a record of the processing which has been
 * performed and shall define a new radar job with which the modified data is associated. The
 * Processing History Segment shall be transmitted every 3 minutes.
 *
 * <p>All fields within the Processing History Segment are mandatory.
 */
public class ProcessingHistorySegment extends Segment {

    private String basedOnNationalityID;
    private String basedOnPlatformID;
    private long basedOnMissionId;
    private long basedOnJobID;
    private final List<ProcessingRecord> processingRecords = new ArrayList<>();

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.ProcessingHistorySegment;
    }

    /**
     * Based On Nationality (C2).
     *
     * <p>A reference to the Nationality for the original radar job, as defined in field P3 of the
     * Packet Header.
     *
     * @return the nationality as a two character string.
     */
    public String getBasedOnNationalityID() {
        return basedOnNationalityID;
    }

    /**
     * Set the Based On Nationality (C2).
     *
     * <p>A reference to the Nationality for the original radar job, as defined in field P3 of the
     * Packet Header.
     *
     * @param nationality the nationality as a two character string.
     */
    public void setBasedOnNationalityID(String nationality) {
        this.basedOnNationalityID = nationality;
    }

    /**
     * Based On Platform ID (C3).
     *
     * <p>A reference to the Platform ID for the original radar job, as defined in field P8 of the
     * Packet Header.
     *
     * @return the platform ID as a string.
     */
    public String getBasedOnPlatformID() {
        return basedOnPlatformID;
    }

    /**
     * Set the Based On Platform ID (C3).
     *
     * <p>A reference to the Platform ID for the original radar job, as defined in field P8 of the
     * Packet Header.
     *
     * @param platformID the platform ID as a string.
     */
    public void setBasedOnPlatformID(String platformID) {
        this.basedOnPlatformID = platformID;
    }

    /**
     * Based On Mission ID (C4).
     *
     * <p>A reference to the Mission ID for the original radar job, as defined in field P9 of the
     * Packet Header.
     *
     * @return the mission identifier as an integer value.
     */
    public long getBasedOnMissionId() {
        return basedOnMissionId;
    }

    /**
     * Set the Based On Mission ID (C4).
     *
     * <p>A reference to the Mission ID for the original radar job, as defined in field P9 of the
     * Packet Header,
     *
     * @param missionId the mission identifier as an integer value
     */
    public void setBasedOnMissionId(long missionId) {
        this.basedOnMissionId = missionId;
    }

    /**
     * Based On Job ID (C5).
     *
     * <p>A reference to the Job ID for the original radar job, as defined in field P10 of the
     * Packet Header.
     *
     * @return the job identifier as an integer value.
     */
    public long getBasedOnJobID() {
        return basedOnJobID;
    }

    /**
     * Set the Based On Job ID (C5).
     *
     * <p>A reference to the Job ID for the original radar job, as defined in field P10 of the
     * Packet Header.
     *
     * @param jobId the job identifier as an integer value.
     */
    public void setBasedOnJobID(long jobId) {
        this.basedOnJobID = jobId;
    }

    /**
     * Get the processing records.
     *
     * <p>One Processing Record shall be sent for each system that provides processing or
     * modification of the radar data.
     *
     * <p>At least one processing record is required.
     *
     * @return the list of processing records
     */
    public List<ProcessingRecord> getProcessingRecords() {
        return new ArrayList<>(processingRecords);
    }

    /**
     * Add a processing record.
     *
     * <p>One Processing Record shall be sent for each system that provides processing or
     * modification of the radar data.
     *
     * <p>At least one processing record is required.
     *
     * @param processingRecord the processing record to add.
     */
    public void addProcessingRecord(ProcessingRecord processingRecord) {
        processingRecords.add(processingRecord);
    }
}
