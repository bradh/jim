package net.frogmouth.rnd.jim.s4607.Packet;

/**
 * Packet Header.
 *
 * <p>The packet header provides packet-level shared metadata. An instance of this class models that
 * information for a single packet.
 */
public class PacketHeader {

    private String versionId;
    private long packetSize;
    private String nationality;
    private int classification;
    private String classificationSystem;
    private int classificationCodeFlags;
    private int exerciseIndicator;
    private String platformId;
    private long missionId;
    private long jobId;

    public PacketHeader() {}

    PacketHeader(PacketHeader other) {
        this.versionId = other.getVersionId();
        this.packetSize = other.getPacketSize();
        this.nationality = other.getNationality();
        this.classification = other.getClassification();
        this.classificationSystem = other.getClassificationSystem();
        this.classificationCodeFlags = other.getClassificationCodeFlags();
        this.exerciseIndicator = other.getExerciseIndicator();
        this.platformId = other.getPlatformId();
        this.missionId = other.getMissionId();
        this.jobId = other.getJobId();
    }

    /**
     * Get the version identifier for this packet (P1).
     *
     * <p>The version identifier two-character alphanumeric code indicating the version of STANAG
     * 4607 to which the packet conforms. It shall be of the form “mn”, where “m” indicates the
     * edition number and “n” indicates the amendment number of that edition. For example, a value
     * of “10” indicates that it is edition 1 without any amendments. A value of “11” indicates that
     * it is the edition 1 with amendment number 1 incorporated.
     *
     * @return the packet version identifier as a String.
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * Set the version identifier for this packet (P1).
     *
     * <p>The version identifier two-character alphanumeric code indicating the version of STANAG
     * 4607 to which the packet conforms. It shall be of the form “mn”, where “m” indicates the
     * edition number and “n” indicates the amendment number of that edition. For example, a value
     * of “10” indicates that it is edition 1 without any amendments. A value of “11” indicates that
     * it is the edition 1 with amendment number 1 incorporated.
     *
     * @param versionId the packet version identifier as a two-character string.
     */
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    /**
     * Get the packet size (P2).
     *
     * <p>Number of bytes in the entire packet, including this header. The minimum packet size shall
     * be the number of bytes in the Packet Header.
     *
     * @return the packet size in bytes.
     */
    public long getPacketSize() {
        return packetSize;
    }

    /**
     * Set the packet size (P2).
     *
     * <p>Number of bytes in the entire packet, including this header. The minimum packet size shall
     * be the number of bytes in the Packet Header.
     *
     * <p>Packet size will be calculated during serialisation, and this value will be ignored.
     *
     * @param packetSize the packet size in bytes.
     */
    public void setPacketSize(long packetSize) {
        this.packetSize = packetSize;
    }

    /**
     * Get the nationality of the platform (P3).
     *
     * <p>A digraph, in accordance with FIPS Publication 10-4, which identifies the nationality of
     * the platform providing the GMTI data. NATO platforms providing GMTI data shall use the
     * digraph XN.
     *
     * <p>FIPS 10-4 is cancelled, GEC is the closest current equivalent.
     *
     * @return the nationality as a String.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Set the nationality of the platform (P3).
     *
     * <p>A digraph, in accordance with FIPS Publication 10-4, which identifies the nationality of
     * the platform providing the GMTI data. NATO platforms providing GMTI data shall use the
     * digraph XN.
     *
     * <p>FIPS 10-4 is cancelled, GEC is the closest current equivalent.
     *
     * @param nationality the nationality as a String, two characters only.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Get the classification (P4).
     *
     * <p>The classification is encoded as an integer value.
     *
     * <table border="1">
     * <caption>Packet Security Classification</caption>
     * <thead>
     * <tr><td>VALUE</td><td>CLASSIFICATION</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>1</td><td>TOP SECRET</td></tr>
     * <tr><td>2</td><td>SECRET</td></tr>
     * <tr><td>3</td><td>CONFIDENTIAL</td></tr>
     * <tr><td>4</td><td>RESTRICTED</td></tr>
     * <tr><td>5</td><td>UNCLASSIFIED</td></tr>
     * </tbody>
     * </table>
     *
     * @return the classification as an encoded integer value.
     */
    public int getClassification() {
        return classification;
    }

    /**
     * Get the classification as a String value.
     *
     * <p>This looks up the integer value to provide a human-readable equivalent.
     *
     * @return String form of the classification value.
     */
    public String getClassificationAsText() {
        return SecurityClassificationLookupTable.getValue(classification);
    }
    /**
     * Set the classification (P4).
     *
     * <p>The classification is encoded as an integer value.
     *
     * <table border="1">
     * <caption>Packet Security Classification</caption>
     * <thead>
     * <tr><td>VALUE</td><td>CLASSIFICATION</td></tr>
     * </thead>
     * <tbody>
     * <tr><td>1</td><td>TOP SECRET</td></tr>
     * <tr><td>2</td><td>SECRET</td></tr>
     * <tr><td>3</td><td>CONFIDENTIAL</td></tr>
     * <tr><td>4</td><td>RESTRICTED</td></tr>
     * <tr><td>5</td><td>UNCLASSIFIED</td></tr>
     * </tbody>
     * </table>
     *
     * @param classification the classification as an encoded integer value.
     */
    public void setClassification(int classification) {
        this.classification = classification;
    }

    /**
     * Get the classification system (P5).
     *
     * <p>A digraph indicating the national or multinational security system to which the security
     * classification in field P4 conforms. Country codes for national security systems are in
     * accordance with FIPS Publication 10-4. NATO classification uses XN. If this field is all BCS
     * spaces (hexadecimal 0x20), it indicates that no Security Classification System applies to the
     * file.
     *
     * @return the classification system.
     */
    public String getClassificationSystem() {
        return classificationSystem;
    }

    /**
     * Set the classification system (P5).
     *
     * <p>A digraph indicating the national or multinational security system to which the security
     * classification in field P4 conforms. Country codes for national security systems are in
     * accordance with FIPS Publication 10-4. NATO classification uses XN. If this field is all BCS
     * spaces (hexadecimal 0x20), it indicates that no Security Classification System applies to the
     * file.
     *
     * @param classificationSystem the classification system.
     */
    public void setClassificationSystem(String classificationSystem) {
        this.classificationSystem = classificationSystem;
    }

    public int getClassificationCodeFlags() {
        return classificationCodeFlags;
    }

    public void setClassificationCodeFlags(int classificationCodeFlags) {
        this.classificationCodeFlags = classificationCodeFlags;
    }

    public int getExerciseIndicator() {
        return exerciseIndicator;
    }

    public String getExerciseIndicatorAsText() {
        return ExerciseIndicatorLookupTable.getValue(exerciseIndicator);
    }

    public void setExerciseIndicator(int exerciseIndicator) {
        this.exerciseIndicator = exerciseIndicator;
    }

    /**
     * Get the platform identifier (P8).
     *
     * <p>An alphanumeric field that identifies the platform. For aircraft the platform ID shall be
     * the tail number. For a space-based platform the platform ID shall be the satellite name with
     * an appropriate numerical designator. For other systems, an appropriate unique designator
     * shall be used. Unused bytes shall be filled with the BCS space character (hex 0x20). In all
     * cases, the platform ID is determined by the nation owning the platform, whose responsibility
     * it is to ensure that all its platforms are uniquely identified within the set of platforms it
     * owns.
     *
     * @return the platform identifier
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Set the platform identifier (P8).
     *
     * <p>An alphanumeric field that identifies the platform. For aircraft the platform ID shall be
     * the tail number. For a space-based platform the platform ID shall be the satellite name with
     * an appropriate numerical designator. For other systems, an appropriate unique designator
     * shall be used. Unused bytes shall be filled with the BCS space character (hex 0x20). In all
     * cases, the platform ID is determined by the nation owning the platform, whose responsibility
     * it is to ensure that all its platforms are uniquely identified within the set of platforms it
     * owns.
     *
     * @param id the platform identifier, 10 characters maximum
     */
    public void setPlatformId(String id) {
        // Some data has embedded nulls at the end (instead of BCS spaces).
        this.platformId = String.format("%-10s", id.trim());
    }

    /**
     * Get the Mission ID (P9).
     *
     * <p>The mission identifier is an integer field, assigned by the platform identified in Field
     * P8, that uniquely identifies the mission for the platform.
     *
     * @return the mission identifier as an integer.
     */
    public long getMissionId() {
        return missionId;
    }

    /**
     * Set the Mission ID (P9).
     *
     * <p>The mission identifier is an integer field, assigned by the platform identified in Field
     * P8, that uniquely identifies the mission for the platform.
     *
     * @param missionId the mission identifier as an integer.
     */
    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    /**
     * Get the Job ID (P10).
     *
     * <p>The Job identifier is a platform-assigned number identifying the specific request or task
     * that pertains to all Dwell, HRR, and Range-Doppler segments in the packet. The Job ID shall
     * be unique within a mission. If the Packet contains no Dwell, HRR, or Range-Doppler segments,
     * then the Job ID in the Packet Header shall be 0 (hex 0x00). If the Packet contains Dwell,
     * HRR, or Range-Doppler segments, then the Job ID in the Packet Header shall be the non-zero
     * Job ID corresponding to those segments.
     *
     * @return the job identifier as an integer.
     */
    public long getJobId() {
        return jobId;
    }

    /**
     * Set the Job ID (P10).
     *
     * <p>The Job identifier is a platform-assigned number identifying the specific request or task
     * that pertains to all Dwell, HRR, and Range-Doppler segments in the packet. The Job ID shall
     * be unique within a mission. If the Packet contains no Dwell, HRR, or Range-Doppler segments,
     * then the Job ID in the Packet Header shall be 0 (hex 0x00). If the Packet contains Dwell,
     * HRR, or Range-Doppler segments, then the Job ID in the Packet Header shall be the non-zero
     * Job ID corresponding to those segments.
     *
     * @param jobId the job identifier as an integer.
     */
    public void setJobId(long jobId) {
        this.jobId = jobId;
    }
}
