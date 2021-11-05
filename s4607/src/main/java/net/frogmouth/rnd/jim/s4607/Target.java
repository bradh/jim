package net.frogmouth.rnd.jim.s4607;

public class Target {
    private Integer mtiReportIndex;
    private Double targetLocationLatitude;
    private Double targetLocationLongitude;
    private Integer targetLocationDeltaLatitude;
    private Integer targetLocationDeltaLongitude;
    private Integer targetLocationGeodeticHeight;
    private Integer targetVelocityLineOfSightComponent;
    private Integer targetWrapVelocity;
    private Integer targetSNR;
    private Integer targetClassification;
    private Integer targetClassificationProbability;
    private Integer targetMeasurementUncertaintySlantRange;
    private Integer targetMeasurementUncertaintyCrossRange;
    private Integer targetMeasurementUncertaintyHeight;
    private Integer targetMeasurementUncertaintyRadialVelocity;
    private Integer truthTagApplication;
    private Long truthTagEntity;
    private Integer targetRadarCrossSection;

    public Integer getMtiReportIndex() {
        return mtiReportIndex;
    }

    public void setMtiReportIndex(Integer mtiReportIndex) {
        this.mtiReportIndex = mtiReportIndex;
    }

    public Double getTargetLocationLatitude() {
        return targetLocationLatitude;
    }

    public void setTargetLocationLatitude(Double targetLocationLatitude) {
        this.targetLocationLatitude = targetLocationLatitude;
    }

    public Double getTargetLocationLongitude() {
        return targetLocationLongitude;
    }

    public void setTargetLocationLongitude(Double targetLocationLongitude) {
        this.targetLocationLongitude = targetLocationLongitude;
    }

    public Integer getTargetLocationDeltaLatitude() {
        return targetLocationDeltaLatitude;
    }

    public void setTargetLocationDeltaLatitude(Integer targetLocationDeltaLatitude) {
        this.targetLocationDeltaLatitude = targetLocationDeltaLatitude;
    }

    public Integer getTargetLocationDeltaLongitude() {
        return targetLocationDeltaLongitude;
    }

    public void setTargetLocationDeltaLongitude(Integer targetLocationDeltaLongitude) {
        this.targetLocationDeltaLongitude = targetLocationDeltaLongitude;
    }

    public Integer getTargetLocationGeodeticHeight() {
        return targetLocationGeodeticHeight;
    }

    public void setTargetLocationGeodeticHeight(Integer targetLocationGeodeticHeight) {
        this.targetLocationGeodeticHeight = targetLocationGeodeticHeight;
    }

    public Integer getTargetVelocityLineOfSightComponent() {
        return targetVelocityLineOfSightComponent;
    }

    public void setTargetVelocityLineOfSightComponent(Integer targetVelocityLineOfSightComponent) {
        this.targetVelocityLineOfSightComponent = targetVelocityLineOfSightComponent;
    }

    public Integer getTargetSNR() {
        return targetSNR;
    }

    public void setTargetSNR(Integer targetSNR) {
        this.targetSNR = targetSNR;
    }

    public Integer getTargetWrapVelocity() {
        return targetWrapVelocity;
    }

    public void setTargetWrapVelocity(Integer targetWrapVelocity) {
        this.targetWrapVelocity = targetWrapVelocity;
    }

    public Integer getTargetClassification() {
        return targetClassification;
    }

    public String getTargetClassificationAsText() {
        return TargetClassificationLookupTable.getValue(targetClassification);
    }

    public void setTargetClassification(Integer targetClassification) {
        this.targetClassification = targetClassification;
    }

    public Integer getTargetClassificationProbability() {
        return targetClassificationProbability;
    }

    public void setTargetClassificationProbability(Integer targetClassificationProbability) {
        this.targetClassificationProbability = targetClassificationProbability;
    }

    public Integer getTargetMeasurementUncertaintySlantRange() {
        return targetMeasurementUncertaintySlantRange;
    }

    public void setTargetMeasurementUncertaintySlantRange(
            Integer targetMeasurementUncertaintySlantRange) {
        this.targetMeasurementUncertaintySlantRange = targetMeasurementUncertaintySlantRange;
    }

    public Integer getTargetMeasurementUncertaintyCrossRange() {
        return targetMeasurementUncertaintyCrossRange;
    }

    public void setTargetMeasurementUncertaintyCrossRange(
            Integer targetMeasurementUncertaintyCrossRange) {
        this.targetMeasurementUncertaintyCrossRange = targetMeasurementUncertaintyCrossRange;
    }

    public Integer getTargetMeasurementUncertaintyHeight() {
        return targetMeasurementUncertaintyHeight;
    }

    public void setTargetMeasurementUncertaintyHeight(Integer targetMeasurementUncertaintyHeight) {
        this.targetMeasurementUncertaintyHeight = targetMeasurementUncertaintyHeight;
    }

    public Integer getTargetMeasurementUncertaintyRadialVelocity() {
        return targetMeasurementUncertaintyRadialVelocity;
    }

    public void setTargetMeasurementUncertaintyRadialVelocity(
            Integer targetMeasurementUncertaintyRadialVelocity) {
        this.targetMeasurementUncertaintyRadialVelocity =
                targetMeasurementUncertaintyRadialVelocity;
    }

    public Integer getTruthTagApplication() {
        return truthTagApplication;
    }

    public void setTruthTagApplication(Integer truthTagApplication) {
        this.truthTagApplication = truthTagApplication;
    }

    public Long getTruthTagEntity() {
        return truthTagEntity;
    }

    public void setTruthTagEntity(long truthTagEntity) {
        this.truthTagEntity = truthTagEntity;
    }

    public Integer getTargetRadarCrossSection() {
        return targetRadarCrossSection;
    }

    public void setTargetRadarCrossSection(Integer targetRadarCrossSection) {
        this.targetRadarCrossSection = targetRadarCrossSection;
    }
}
