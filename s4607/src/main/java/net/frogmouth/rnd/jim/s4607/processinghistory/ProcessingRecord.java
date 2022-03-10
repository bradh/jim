package net.frogmouth.rnd.jim.s4607.processinghistory;

/**
 * Processing Record.
 *
 * <p>One Processing Record shall be sent for each system that provides processing or modification
 * of the radar data.
 *
 * <p>All fields in the processing record are mandatory.
 */
public class ProcessingRecord {
    private int processingHistorySequenceNumber;
    private String nationalityIdOfModifyingSystem;
    private String platformIdOfModifyingSystem;
    private long missionIdOfModifyingSystem;
    private long jobIdOfModifyingSystem;
    private ProcessingPerformed processingPerformed;

    /**
     * Processing History Sequence Number (C6.1).
     *
     * <p>The sequential count of this Processing Record within the Processing Segment.
     *
     * @return processing history sequence number
     */
    public int getProcessingHistorySequenceNumber() {
        return processingHistorySequenceNumber;
    }

    /**
     * Set the Processing History Sequence Number (C6.1).
     *
     * <p>The sequential count of this Processing Record within the Processing Segment.
     *
     * @param sequenceNumber processing history sequence number in the range 1 to 255.
     */
    public void setProcessingHistorySequenceNumber(int sequenceNumber) {
        this.processingHistorySequenceNumber = sequenceNumber;
    }

    /**
     * Nationality Of Modifying System (C6.2).
     *
     * <p>A reference to the Nationality for the modifying system job, as defined in field P3 of the
     * Packet Header.
     *
     * @return the nationality identifier (2 character string).
     */
    public String getNationalityIdOfModifyingSystem() {
        return nationalityIdOfModifyingSystem;
    }

    /**
     * Set the Nationality Of Modifying System (C6.2).
     *
     * <p>A reference to the Nationality for the modifying system job, as defined in field P3 of the
     * Packet Header.
     *
     * @param nationality the nationality identifier (2 character string).
     */
    public void setNationalityIdOfModifyingSystem(String nationality) {
        this.nationalityIdOfModifyingSystem = nationality;
    }

    /**
     * Platform ID Of Modifying System (C6.3).
     *
     * <p>A reference to the Platform ID for the modifying system job, as defined in field P8 of the
     * Packet Header.
     *
     * @return platform identifier
     */
    public String getPlatformIdOfModifyingSystem() {
        return platformIdOfModifyingSystem;
    }

    /**
     * Set the Platform ID Of Modifying System (C6.3).
     *
     * <p>A reference to the Platform ID for the modifying system job, as defined in field P8 of the
     * Packet Header.
     *
     * @param platformId platform identifier, 10 characters maximum
     */
    public void setPlatformIdOfModifyingSystem(String platformId) {
        this.platformIdOfModifyingSystem = platformId;
    }

    /**
     * Mission ID Of Modifying System (C6.4).
     *
     * <p>A reference to the Mission ID for the modifying system job, as defined in field P9 of the
     * Packet Header.
     *
     * @return mission identifier as an integer value (valid range 0 to 4294967295)
     */
    public long getMissionIdOfModifyingSystem() {
        return missionIdOfModifyingSystem;
    }

    /**
     * Set the Mission ID Of Modifying System (C6.4).
     *
     * <p>A reference to the Mission ID for the modifying system job, as defined in field P9 of the
     * Packet Header.
     *
     * @param missionId mission identifier as an integer value (valid range 0 to 4294967295)
     */
    public void setMissionIdOfModifyingSystem(long missionId) {
        this.missionIdOfModifyingSystem = missionId;
    }

    /**
     * Job ID Of Modifying System (C6.5).
     *
     * <p>A reference to the Job ID for the modifying system job, as defined in field P10 of the
     * Packet Header.
     *
     * @return the job identifier as an integer value (valid range 1 to 4294967295)
     */
    public long getJobIdOfModifyingSystem() {
        return jobIdOfModifyingSystem;
    }

    /**
     * Set the Job ID Of Modifying System (C6.5).
     *
     * <p>A reference to the Job ID for the modifying system job, as defined in field P10 of the
     * Packet Header.
     *
     * @param jobId the job identifier as an integer value (valid range 1 to 4294967295)
     */
    public void setJobIdOfModifyingSystem(long jobId) {
        this.jobIdOfModifyingSystem = jobId;
    }

    /**
     * Processing Performed (C6.6).
     *
     * <p>A two-byte flag field that indicates the additional processing performed on the radar
     * data. A value of 0 (hex 0x0000) indicates no additional processing has been performed. Each
     * bit, when set to a binary “1”, indicates that the corresponding processing function has been
     * performed. The bit settings shall only represent the modifications done by the system
     * identified in this processing record. If a system performs more than one processing
     * operation, this shall be indicated by setting multiple bits in this flag, with one bit set
     * for each processing operation performed.
     *
     * @return processing performed as a wrapped set.
     */
    public ProcessingPerformed getProcessingPerformed() {
        return processingPerformed;
    }

    /**
     * Set the Processing Performed (C6.6).
     *
     * <p>A two-byte flag field that indicates the additional processing performed on the radar
     * data. A value of 0 (hex 0x0000) indicates no additional processing has been performed. Each
     * bit, when set to a binary “1”, indicates that the corresponding processing function has been
     * performed. The bit settings shall only represent the modifications done by the system
     * identified in this processing record. If a system performs more than one processing
     * operation, this shall be indicated by setting multiple bits in this flag, with one bit set
     * for each processing operation performed.
     *
     * @param processing processing performed as a wrapped set.
     */
    public void setProcessingPerformed(ProcessingPerformed processing) {
        this.processingPerformed = processing;
    }
}
