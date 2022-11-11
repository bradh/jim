package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Module3 {
    private String calibrationUnit;
    private String principalPointOffsetX;
    private String principalPointOffsetY;
    private String radialDistortion1;
    private String radialDistortion2;
    private String radialDistortion3;
    private String radialDistortLimit;
    private String decentDistort1;
    private String decentDistort2;
    private String affinityDistort1;
    private String affinityDistort2;
    private String calibrationDate;

    public Module3() {}

    public Module3(Module3 other) {
        this.calibrationUnit = other.calibrationUnit;
        this.principalPointOffsetX = other.principalPointOffsetX;
        this.principalPointOffsetY = other.principalPointOffsetY;
        this.radialDistortion1 = other.radialDistortion1;
        this.radialDistortion2 = other.radialDistortion2;
        this.radialDistortion3 = other.radialDistortion3;
        this.radialDistortLimit = other.radialDistortLimit;
        this.decentDistort1 = other.decentDistort1;
        this.decentDistort2 = other.decentDistort2;
        this.affinityDistort1 = other.affinityDistort1;
        this.affinityDistort2 = other.affinityDistort2;
        this.calibrationDate = other.calibrationDate;
    }

    public String getCalibrationUnit() {
        return calibrationUnit;
    }

    public void setCalibrationUnit(String calibrationUnit) {
        this.calibrationUnit = calibrationUnit;
    }

    public String getPrincipalPointOffsetX() {
        return principalPointOffsetX;
    }

    public void setPrincipalPointOffsetX(String principalPointOffsetX) {
        this.principalPointOffsetX = principalPointOffsetX;
    }

    public String getPrincipalPointOffsetY() {
        return principalPointOffsetY;
    }

    public void setPrincipalPointOffsetY(String principalPointOffsetY) {
        this.principalPointOffsetY = principalPointOffsetY;
    }

    public String getRadialDistortion1() {
        return radialDistortion1;
    }

    public void setRadialDistortion1(String radialDistortion1) {
        this.radialDistortion1 = radialDistortion1;
    }

    public String getRadialDistortion2() {
        return radialDistortion2;
    }

    public void setRadialDistortion2(String radialDistortion2) {
        this.radialDistortion2 = radialDistortion2;
    }

    public String getRadialDistortion3() {
        return radialDistortion3;
    }

    public void setRadialDistortion3(String radialDistortion3) {
        this.radialDistortion3 = radialDistortion3;
    }

    public String getRadialDistortLimit() {
        return radialDistortLimit;
    }

    public void setRadialDistortLimit(String radialDistortLimit) {
        this.radialDistortLimit = radialDistortLimit;
    }

    public String getDecentDistort1() {
        return decentDistort1;
    }

    public void setDecentDistort1(String decentDistort1) {
        this.decentDistort1 = decentDistort1;
    }

    public String getDecentDistort2() {
        return decentDistort2;
    }

    public void setDecentDistort2(String decentDistort2) {
        this.decentDistort2 = decentDistort2;
    }

    public String getAffinityDistort1() {
        return affinityDistort1;
    }

    public void setAffinityDistort1(String affinityDistort1) {
        this.affinityDistort1 = affinityDistort1;
    }

    public String getAffinityDistort2() {
        return affinityDistort2;
    }

    public void setAffinityDistort2(String affinityDistort2) {
        this.affinityDistort2 = affinityDistort2;
    }

    public String getCalibrationDate() {
        return calibrationDate;
    }

    public void setCalibrationDate(String calibrationDate) {
        this.calibrationDate = calibrationDate;
    }
}
