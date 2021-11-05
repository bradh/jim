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

    private Double sensorTrack;
    private Integer sensorSpeed;
    private int sensorVerticalVelocity;

    private double platformOrientationHeading;
    private double platformOrientationPitch;
    private double platformOrientationRoll;

    private double dwellCentreLatitude;
    private double dwellCentreLongitude;
    private double dwellAreaRangeHalfExtent;
    private double dwellAreaDwellAngleHalfExtent;
    private List<Target> targets = new ArrayList<>();

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

    public Double getSensorTrack() {
        return sensorTrack;
    }

    public void setSensorTrack(double sensorTrack) {
        this.sensorTrack = sensorTrack;
    }

    public Integer getSensorSpeed() {
        return sensorSpeed;
    }

    public void setSensorSpeed(Integer sensorSpeed) {
        this.sensorSpeed = sensorSpeed;
    }

    public int getSensorVerticalVelocity() {
        return sensorVerticalVelocity;
    }

    public void setSensorVerticalVelocity(int sensorVerticalVelocity) {
        this.sensorVerticalVelocity = sensorVerticalVelocity;
    }

    public double getPlatformOrientationHeading() {
        return platformOrientationHeading;
    }

    public void setPlatformOrientationHeading(double platformOrientationHeading) {
        this.platformOrientationHeading = platformOrientationHeading;
    }

    public double getPlatformOrientationPitch() {
        return platformOrientationPitch;
    }

    public void setPlatformOrientationPitch(double platformOrientationPitch) {
        this.platformOrientationPitch = platformOrientationPitch;
    }

    public double getPlatformOrientationRoll() {
        return platformOrientationRoll;
    }

    public void setPlatformOrientationRoll(double platformOrientationRoll) {
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

    public List<Target> getTargets() {
        return new ArrayList<>(targets);
    }

    public void addTarget(Target target) {
        // TODO: probably needs to copy
        this.targets.add(target);
    }
}
