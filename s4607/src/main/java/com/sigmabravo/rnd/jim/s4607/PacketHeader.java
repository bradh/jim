package com.sigmabravo.rnd.jim.s4607;

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

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public long getPacketSize() {
        return packetSize;
    }

    public void setPacketSize(long packetSize) {
        this.packetSize = packetSize;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getClassification() {
        return classification;
    }

    public String getClassificationAsText() {
        return ClassificationLookupTable.getValue(classification);
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getClassificationSystem() {
        return classificationSystem;
    }

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

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }
}
