package net.frogmouth.rnd.jim.s4607;

import java.util.ArrayList;
import java.util.List;

public class DwellSegment extends Segment {

    private Integer revisitIndex;
    private Integer dwellIndex;
    private Boolean lastDwellOfRevisit;
    private Integer targetReportCount;
    private Long dwellTime;
    private double sensorLatitude;
    private double sensorLongitude;
    private int sensorAltitude;
    private Double scaleFactorLatScale;
    private Double scaleFactorLonScale;
    private Integer sensorPositionUncertaintyAlongTrack;
    private Integer sensorPositionUncertaintyCrossTrack;
    private Integer sensorPositionUncertaintyAltitude;
    private Double sensorTrack;
    private Integer sensorSpeed;
    private Integer sensorVerticalVelocity;
    private Integer sensorTrackUncertainty;
    private Integer sensorSpeedUncertainty;
    private Integer sensorVerticalVelocityUncertainty;
    private Double platformOrientationHeading;
    private Double platformOrientationPitch;
    private Double platformOrientationRoll;
    private double dwellCentreLatitude;
    private double dwellCentreLongitude;
    private double dwellAreaRangeHalfExtent;
    private double dwellAreaDwellAngleHalfExtent;
    private Double sensorOrientationHeading;
    private Double sensorOrientationPitch;
    private Double sensorOrientationRoll;
    private Integer minimumDetectableVelocity;
    private final List<Target> targets = new ArrayList<>();

    DwellSegment(SegmentHeader segmentHeader) {
        super(segmentHeader);
    }

    public Integer getRevisitIndex() {
        return revisitIndex;
    }

    public void setRevisitIndex(Integer revisitIndex) {
        this.revisitIndex = revisitIndex;
    }

    public Integer getDwellIndex() {
        return dwellIndex;
    }

    public void setDwellIndex(Integer dwellIndex) {
        this.dwellIndex = dwellIndex;
    }

    public Boolean getLastDwellOfRevisit() {
        return lastDwellOfRevisit;
    }

    public void setLastDwellOfRevisit(Boolean lastDwellOfRevisit) {
        this.lastDwellOfRevisit = lastDwellOfRevisit;
    }

    public Integer getTargetReportCount() {
        return targetReportCount;
    }

    public void setTargetReportCount(Integer targetReportCount) {
        this.targetReportCount = targetReportCount;
    }

    public Long getDwellTime() {
        return dwellTime;
    }

    public void setDwellTime(Long dwellTime) {
        this.dwellTime = dwellTime;
    }

    public double getSensorLatitude() {
        return sensorLatitude;
    }

    public void setSensorLatitude(double sensorLatitude) {
        this.sensorLatitude = sensorLatitude;
    }

    public double getSensorLongitude() {
        return sensorLongitude;
    }

    public void setSensorLongitude(double sensorLongitude) {
        this.sensorLongitude = sensorLongitude;
    }

    public int getSensorAltitude() {
        return sensorAltitude;
    }

    public void setSensorAltitude(int sensorAltitude) {
        this.sensorAltitude = sensorAltitude;
    }

    public Double getScaleFactorLatScale() {
        return scaleFactorLatScale;
    }

    public void setScaleFactorLatScale(Double scaleFactorLatScale) {
        this.scaleFactorLatScale = scaleFactorLatScale;
    }

    public Double getScaleFactorLonScale() {
        return scaleFactorLonScale;
    }

    public void setScaleFactorLonScale(Double scaleFactorLonScale) {
        this.scaleFactorLonScale = scaleFactorLonScale;
    }

    public Integer getSensorPositionUncertaintyAlongTrack() {
        return sensorPositionUncertaintyAlongTrack;
    }

    public void setSensorPositionUncertaintyAlongTrack(
            Integer sensorPositionUncertaintyAlongTrack) {
        this.sensorPositionUncertaintyAlongTrack = sensorPositionUncertaintyAlongTrack;
    }

    public Integer getSensorPositionUncertaintyCrossTrack() {
        return sensorPositionUncertaintyCrossTrack;
    }

    public void setSensorPositionUncertaintyCrossTrack(Integer sensorPositionUncertaintyCrossrack) {
        this.sensorPositionUncertaintyCrossTrack = sensorPositionUncertaintyCrossrack;
    }

    public Integer getSensorPositionUncertaintyAltitude() {
        return sensorPositionUncertaintyAltitude;
    }

    public void setSensorPositionUncertaintyAltitude(Integer sensorPositionUncertaintyAltitude) {
        this.sensorPositionUncertaintyAltitude = sensorPositionUncertaintyAltitude;
    }

    public Double getSensorTrack() {
        return sensorTrack;
    }

    public void setSensorTrack(Double sensorTrack) {
        this.sensorTrack = sensorTrack;
    }

    public Integer getSensorSpeed() {
        return sensorSpeed;
    }

    public void setSensorSpeed(Integer sensorSpeed) {
        this.sensorSpeed = sensorSpeed;
    }

    public Integer getSensorVerticalVelocity() {
        return sensorVerticalVelocity;
    }

    public void setSensorVerticalVelocity(Integer sensorVerticalVelocity) {
        this.sensorVerticalVelocity = sensorVerticalVelocity;
    }

    public Integer getSensorTrackUncertainty() {
        return sensorTrackUncertainty;
    }

    public void setSensorTrackUncertainty(Integer sensorTrackUncertainty) {
        this.sensorTrackUncertainty = sensorTrackUncertainty;
    }

    public Integer getSensorSpeedUncertainty() {
        return sensorSpeedUncertainty;
    }

    public void setSensorSpeedUncertainty(Integer sensorSpeedUncertainty) {
        this.sensorSpeedUncertainty = sensorSpeedUncertainty;
    }

    public Integer getSensorVerticalVelocityUncertainty() {
        return sensorVerticalVelocityUncertainty;
    }

    public void setSensorVerticalVelocityUncertainty(Integer sensorVerticalVelocityUncertainty) {
        this.sensorVerticalVelocityUncertainty = sensorVerticalVelocityUncertainty;
    }

    public Double getPlatformOrientationHeading() {
        return platformOrientationHeading;
    }

    public void setPlatformOrientationHeading(Double platformOrientationHeading) {
        this.platformOrientationHeading = platformOrientationHeading;
    }

    public Double getPlatformOrientationPitch() {
        return platformOrientationPitch;
    }

    public void setPlatformOrientationPitch(Double platformOrientationPitch) {
        this.platformOrientationPitch = platformOrientationPitch;
    }

    public Double getPlatformOrientationRoll() {
        return platformOrientationRoll;
    }

    public void setPlatformOrientationRoll(Double platformOrientationRoll) {
        this.platformOrientationRoll = platformOrientationRoll;
    }

    public double getDwellCentreLatitude() {
        return dwellCentreLatitude;
    }

    public void setDwellCentreLatitude(double dwellCentreLatitude) {
        this.dwellCentreLatitude = dwellCentreLatitude;
    }

    public double getDwellCentreLongitude() {
        return dwellCentreLongitude;
    }

    public void setDwellCentreLongitude(double dwellCentreLongitude) {
        this.dwellCentreLongitude = dwellCentreLongitude;
    }

    public double getDwellAreaRangeHalfExtent() {
        return dwellAreaRangeHalfExtent;
    }

    public void setDwellAreaRangeHalfExtent(double dwellAreaRangeHalfExtent) {
        this.dwellAreaRangeHalfExtent = dwellAreaRangeHalfExtent;
    }

    public double getDwellAreaDwellAngleHalfExtent() {
        return dwellAreaDwellAngleHalfExtent;
    }

    public void setDwellAreaDwellAngleHalfExtent(double dwellAreaDwellAngleHalfExtent) {
        this.dwellAreaDwellAngleHalfExtent = dwellAreaDwellAngleHalfExtent;
    }

    public Double getSensorOrientationHeading() {
        return sensorOrientationHeading;
    }

    public void setSensorOrientationHeading(Double sensorOrientationHeading) {
        this.sensorOrientationHeading = sensorOrientationHeading;
    }

    public Double getSensorOrientationPitch() {
        return sensorOrientationPitch;
    }

    public void setSensorOrientationPitch(Double sensorOrientationPitch) {
        this.sensorOrientationPitch = sensorOrientationPitch;
    }

    public Double getSensorOrientationRoll() {
        return sensorOrientationRoll;
    }

    public void setSensorOrientationRoll(Double sensorOrientationRoll) {
        this.sensorOrientationRoll = sensorOrientationRoll;
    }

    public Integer getMinimumDetectableVelocity() {
        return minimumDetectableVelocity;
    }

    public void setMinimumDetectableVelocity(Integer minimumDetectableVelocity) {
        this.minimumDetectableVelocity = minimumDetectableVelocity;
    }

    public List<Target> getTargets() {
        return new ArrayList<>(targets);
    }

    public void addTarget(Target target) {
        // TODO: probably needs to copy
        this.targets.add(target);
    }
}
