package net.frogmouth.rnd.jim.nitf.tre.csexrb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class CSEXRB extends TaggedRecordExtension {
    private static final String TRE_TAG = "CSEXRB";

    private UUID imageUUID;
    private final List<UUID> associatedDESUUIDs = new ArrayList<>();
    private String platformId;
    private String payloadId;
    private String sensorId;
    private String sensorType;
    private Double groundRefPointX;
    private Double groundRefPointY;
    private Double groundRefPointZ;
    private String dayfirstLineImage;
    private double timeFirstLineImage;
    private double timeImageDuration;
    private String timeStampLoc;
    private Long referenceFrameNumber;
    private String baseTimeStamp;
    private Long dtMultiplier;
    private Integer dtSize;
    private final List<Long> deltaTimes = new ArrayList<>();
    private Double maxGSD;
    private Double alongScanGSD;
    private Double crossScanGSD;
    private Double geoMeanGSD;
    private Double alongScanVerticalGSD;
    private Double crossScanVerticalGSD;
    private Double geoMeanVerticalGSD;
    private Double gsdBetaAngle;
    private Integer dynamicRange;
    private int numLines;
    private int numSamples;
    private Double angleToTrueNorth;
    private Double obliquityAngle;
    private Double azimuthOfObliquity;
    private String atmosphericRefractionFlag;
    private String velocityAberrationFlag;
    private String groundCoverFlag;
    private String snowDepthCategory;
    private Double sunAzimuthAngle;
    private Double sunElevationAngle;
    private Double predictedNIIRS;
    private Double circularError;
    private Double linearError;
    private Integer cloudCover;
    private String rollingShutterFlag;
    private String timeUnmodeledErrorFlag;

    public CSEXRB() {
        super(TRE_TAG);
    }

    public UUID getImageUUID() {
        return imageUUID;
    }

    public void setImageUUID(UUID imageUUID) {
        this.imageUUID = imageUUID;
    }

    public List<UUID> getAssociatedDESUUIDs() {
        return new ArrayList<>(associatedDESUUIDs);
    }

    public void addAssociatedDESUUID(UUID uuid) {
        this.associatedDESUUIDs.add(uuid);
    }

    public List<Long> getDeltaTimes() {
        return new ArrayList<>(deltaTimes);
    }

    public void addDeltaTime(Long dt) {
        this.deltaTimes.add(dt);
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Double getGroundRefPointX() {
        return groundRefPointX;
    }

    public void setGroundRefPointX(Double groundRefPointX) {
        this.groundRefPointX = groundRefPointX;
    }

    public Double getGroundRefPointY() {
        return groundRefPointY;
    }

    public void setGroundRefPointY(Double groundRefPointY) {
        this.groundRefPointY = groundRefPointY;
    }

    public Double getGroundRefPointZ() {
        return groundRefPointZ;
    }

    public void setGroundRefPointZ(Double groundRefPointZ) {
        this.groundRefPointZ = groundRefPointZ;
    }

    public String getDayfirstLineImage() {
        return dayfirstLineImage;
    }

    public void setDayfirstLineImage(String dayfirstLineImage) {
        this.dayfirstLineImage = dayfirstLineImage;
    }

    public double getTimeFirstLineImage() {
        return timeFirstLineImage;
    }

    public void setTimeFirstLineImage(double timeFirstLineImage) {
        this.timeFirstLineImage = timeFirstLineImage;
    }

    public double getTimeImageDuration() {
        return timeImageDuration;
    }

    public void setTimeImageDuration(double timeImageDuration) {
        this.timeImageDuration = timeImageDuration;
    }

    public String getTimeStampLoc() {
        return timeStampLoc;
    }

    public void setTimeStampLoc(String timeStampLoc) {
        this.timeStampLoc = timeStampLoc;
    }

    public Long getReferenceFrameNumber() {
        return referenceFrameNumber;
    }

    public void setReferenceFrameNumber(Long referenceFrameNumber) {
        this.referenceFrameNumber = referenceFrameNumber;
    }

    public String getBaseTimeStamp() {
        return baseTimeStamp;
    }

    public void setBaseTimeStamp(String baseTimeStamp) {
        this.baseTimeStamp = baseTimeStamp;
    }

    public Long getDtMultiplier() {
        return dtMultiplier;
    }

    public void setDtMultiplier(Long dtMultiplier) {
        this.dtMultiplier = dtMultiplier;
    }

    public Integer getDtSize() {
        return dtSize;
    }

    public void setDtSize(Integer dtSize) {
        this.dtSize = dtSize;
    }

    public Double getMaxGSD() {
        return maxGSD;
    }

    public void setMaxGSD(Double maxGSD) {
        this.maxGSD = maxGSD;
    }

    public Double getAlongScanGSD() {
        return alongScanGSD;
    }

    public void setAlongScanGSD(Double alongScanGSD) {
        this.alongScanGSD = alongScanGSD;
    }

    public Double getCrossScanGSD() {
        return crossScanGSD;
    }

    public void setCrossScanGSD(Double crossScanGSD) {
        this.crossScanGSD = crossScanGSD;
    }

    public Double getGeoMeanGSD() {
        return geoMeanGSD;
    }

    public void setGeoMeanGSD(Double geoMeanGSD) {
        this.geoMeanGSD = geoMeanGSD;
    }

    public Double getAlongScanVerticalGSD() {
        return alongScanVerticalGSD;
    }

    public void setAlongScanVerticalGSD(Double alongScanVerticalGSD) {
        this.alongScanVerticalGSD = alongScanVerticalGSD;
    }

    public Double getCrossScanVerticalGSD() {
        return crossScanVerticalGSD;
    }

    public void setCrossScanVerticalGSD(Double crossScanVerticalGSD) {
        this.crossScanVerticalGSD = crossScanVerticalGSD;
    }

    public Double getGeoMeanVerticalGSD() {
        return geoMeanVerticalGSD;
    }

    public void setGeoMeanVerticalGSD(Double geoMeanVerticalGSD) {
        this.geoMeanVerticalGSD = geoMeanVerticalGSD;
    }

    public Double getGsdBetaAngle() {
        return gsdBetaAngle;
    }

    public void setGsdBetaAngle(Double gsdBetaAngle) {
        this.gsdBetaAngle = gsdBetaAngle;
    }

    public Integer getDynamicRange() {
        return dynamicRange;
    }

    public void setDynamicRange(Integer dynamicRange) {
        this.dynamicRange = dynamicRange;
    }

    public int getNumLines() {
        return numLines;
    }

    public void setNumLines(int numLines) {
        this.numLines = numLines;
    }

    public int getNumSamples() {
        return numSamples;
    }

    public void setNumSamples(int numSamples) {
        this.numSamples = numSamples;
    }

    public Double getAngleToTrueNorth() {
        return angleToTrueNorth;
    }

    public void setAngleToTrueNorth(Double angleToTrueNorth) {
        this.angleToTrueNorth = angleToTrueNorth;
    }

    public Double getObliquityAngle() {
        return obliquityAngle;
    }

    public void setObliquityAngle(Double obliquityAngle) {
        this.obliquityAngle = obliquityAngle;
    }

    public Double getAzimuthOfObliquity() {
        return azimuthOfObliquity;
    }

    public void setAzimuthOfObliquity(Double azimuthOfObliquity) {
        this.azimuthOfObliquity = azimuthOfObliquity;
    }

    public String getAtmosphericRefractionFlag() {
        return atmosphericRefractionFlag;
    }

    public void setAtmosphericRefractionFlag(String atmosphericRefractionFlag) {
        this.atmosphericRefractionFlag = atmosphericRefractionFlag;
    }

    public String getVelocityAberrationFlag() {
        return velocityAberrationFlag;
    }

    public void setVelocityAberrationFlag(String velocityAberrationFlag) {
        this.velocityAberrationFlag = velocityAberrationFlag;
    }

    public String getGroundCoverFlag() {
        return groundCoverFlag;
    }

    public void setGroundCoverFlag(String groundCoverFlag) {
        this.groundCoverFlag = groundCoverFlag;
    }

    public String getSnowDepthCategory() {
        return snowDepthCategory;
    }

    public void setSnowDepthCategory(String snowDepthCategory) {
        this.snowDepthCategory = snowDepthCategory;
    }

    public Double getSunAzimuthAngle() {
        return sunAzimuthAngle;
    }

    public void setSunAzimuthAngle(Double sunAzimuthAngle) {
        this.sunAzimuthAngle = sunAzimuthAngle;
    }

    public Double getSunElevationAngle() {
        return sunElevationAngle;
    }

    public void setSunElevationAngle(Double sunElevationAngle) {
        this.sunElevationAngle = sunElevationAngle;
    }

    public Double getPredictedNIIRS() {
        return predictedNIIRS;
    }

    public void setPredictedNIIRS(Double predictedNIIRS) {
        this.predictedNIIRS = predictedNIIRS;
    }

    public Double getCircularError() {
        return circularError;
    }

    public void setCircularError(Double circularError) {
        this.circularError = circularError;
    }

    public Double getLinearError() {
        return linearError;
    }

    public void setLinearError(Double linearError) {
        this.linearError = linearError;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }

    public String getRollingShutterFlag() {
        return rollingShutterFlag;
    }

    public void setRollingShutterFlag(String rollingShutterFlag) {
        this.rollingShutterFlag = rollingShutterFlag;
    }

    public String getTimeUnmodeledErrorFlag() {
        return timeUnmodeledErrorFlag;
    }

    /*
    @TREOrder(order = 1)
    @TREField(label = "DAY")
    public int getDay() {
    return day;
    }
     */
    public void setTimeUnmodeledErrorFlag(String timeUnmodeledErrorFlag) {
        this.timeUnmodeledErrorFlag = timeUnmodeledErrorFlag;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
