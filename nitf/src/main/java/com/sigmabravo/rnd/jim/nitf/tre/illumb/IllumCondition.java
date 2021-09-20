package com.sigmabravo.rnd.jim.nitf.tre.illumb;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;
import java.util.ArrayList;
import java.util.List;

public class IllumCondition extends TreePart {
    private String datetime;
    private double target_lat;
    private double target_lon;
    private String target_hgt;
    private Double sun_azimuth;
    private Double sun_elev;
    private Double moon_azimuth;
    private Double moon_elev;
    private Double moon_phase_angle;
    private Integer moon_illum_percent;
    private final List<OtherNaturalIllumSourceAzEl> otherSources = new ArrayList<>();
    private Double sensor_azimuth;
    private Double sensor_elev;
    private Double cats_angle;
    private Double sun_glint_lat;
    private Double sun_glint_lon;
    private Double catm_angle;
    private Double moon_glint_lat;
    private Double moon_glint_lon;
    private Double sol_lun_dist_adjust;
    private final List<BandIllum> bands = new ArrayList<>();

    @TREOrder(order = 1)
    @TREField(label = "DATETIME")
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @TREOrder(order = 2)
    @TREField(label = "TARGET_LAT")
    public double getTarget_lat() {
        return target_lat;
    }

    public void setTarget_lat(double target_lat) {
        this.target_lat = target_lat;
    }

    @TREOrder(order = 3)
    @TREField(label = "TARGET_LON")
    public double getTarget_lon() {
        return target_lon;
    }

    public void setTarget_lon(double target_lon) {
        this.target_lon = target_lon;
    }

    @TREOrder(order = 4)
    @TREField(label = "TARGET_HGT")
    public String getTarget_hgt() {
        return target_hgt;
    }

    public void setTarget_hgt(String target_hgt) {
        this.target_hgt = target_hgt;
    }

    @TREOrder(order = 5)
    @TREField(label = "SUN_AZIMUTH")
    public Double getSun_azimuth() {
        return sun_azimuth;
    }

    public void setSun_azimuth(Double sun_azimuth) {
        this.sun_azimuth = sun_azimuth;
    }

    @TREOrder(order = 6)
    @TREField(label = "SUN_ELEV")
    public Double getSun_elev() {
        return sun_elev;
    }

    public void setSun_elev(Double sun_elev) {
        this.sun_elev = sun_elev;
    }

    @TREOrder(order = 7)
    @TREField(label = "MOON_AZIMUTH")
    public Double getMoon_azimuth() {
        return moon_azimuth;
    }

    public void setMoon_azimuth(Double moon_azimuth) {
        this.moon_azimuth = moon_azimuth;
    }

    @TREOrder(order = 8)
    @TREField(label = "MOON_ELEV")
    public Double getMoon_elev() {
        return moon_elev;
    }

    public void setMoon_elev(Double moon_elev) {
        this.moon_elev = moon_elev;
    }

    @TREOrder(order = 9)
    @TREField(label = "MOON_PHASE_ANGLE")
    public Double getMoon_phase_angle() {
        return moon_phase_angle;
    }

    public void setMoon_phase_angle(Double moon_phase_angle) {
        this.moon_phase_angle = moon_phase_angle;
    }

    @TREOrder(order = 10)
    @TREField(label = "MOON_ILLUM_PERCENT")
    public Integer getMoon_illum_percent() {
        return moon_illum_percent;
    }

    public void setMoon_illum_percent(Integer moon_illum_percent) {
        this.moon_illum_percent = moon_illum_percent;
    }

    @TREOrder(order = 11)
    @TREGroup
    public List<OtherNaturalIllumSourceAzEl> getOtherSources() {
        return new ArrayList<>(otherSources);
    }

    public void addOtherSource(final OtherNaturalIllumSourceAzEl source) {
        otherSources.add(source);
    }

    @TREOrder(order = 12)
    @TREField(label = "SENSOR_AZIMUTH")
    public Double getSensor_azimuth() {
        return sensor_azimuth;
    }

    public void setSensor_azimuth(Double sensor_azimuth) {
        this.sensor_azimuth = sensor_azimuth;
    }

    @TREOrder(order = 13)
    @TREField(label = "SENSOR_ELEV")
    public Double getSensor_elev() {
        return sensor_elev;
    }

    public void setSensor_elev(Double sensor_elevation) {
        this.sensor_elev = sensor_elevation;
    }

    @TREOrder(order = 15)
    @TREField(label = "CATS_ANGLE")
    public Double getCats_angle() {
        return cats_angle;
    }

    public void setCats_angle(Double cats_angle) {
        this.cats_angle = cats_angle;
    }

    @TREOrder(order = 16)
    @TREField(label = "SUN_GLINT_LAT")
    public Double getSun_glint_lat() {
        return sun_glint_lat;
    }

    public void setSun_glint_lat(Double sun_glint_lat) {
        this.sun_glint_lat = sun_glint_lat;
    }

    @TREOrder(order = 17)
    @TREField(label = "SUN_GLINT_LON")
    public Double getSun_glint_lon() {
        return sun_glint_lon;
    }

    public void setSun_glint_lon(Double sun_glint_lon) {
        this.sun_glint_lon = sun_glint_lon;
    }

    @TREOrder(order = 18)
    @TREField(label = "CATM_ANGLE")
    public Double getCatm_angle() {
        return catm_angle;
    }

    public void setCatm_angle(Double catm_angle) {
        this.catm_angle = catm_angle;
    }

    @TREOrder(order = 19)
    @TREField(label = "MOON_GLINT_LAT")
    public Double getMoon_glint_lat() {
        return moon_glint_lat;
    }

    public void setMoon_glint_lat(Double moon_glint_lat) {
        this.moon_glint_lat = moon_glint_lat;
    }

    @TREOrder(order = 20)
    @TREField(label = "MOON_GLINT_LON")
    public Double getMoon_glint_lon() {
        return moon_glint_lon;
    }

    public void setMoon_glint_lon(Double moon_glint_lon) {
        this.moon_glint_lon = moon_glint_lon;
    }

    @TREOrder(order = 21)
    @TREField(label = "SOL_LUN_DIST_ADJUST")
    public Double getSol_lun_dist_adjust() {
        return sol_lun_dist_adjust;
    }

    public void setSol_lun_dist_adjust(Double sol_lun_dist_adjust) {
        this.sol_lun_dist_adjust = sol_lun_dist_adjust;
    }

    @TREOrder(order = 22)
    @TREGroup
    public List<BandIllum> getBands() {
        return new ArrayList<>(bands);
    }

    public void addBand(final BandIllum band) {
        bands.add(band);
    }

    @Override
    public String getTreeItemLabel() {
        return "Illumination Condition";
    }
}
