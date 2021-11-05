package net.frogmouth.rnd.jim.nitf.tre.illumb;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class BandIllum extends TreePart {

    private String sun_illum_method;
    private String sun_illum;
    private String moon_illum_method;
    private String moon_illum;
    private String total_sun_moon_illum;
    private final List<OtherSourceBandIllum> otherSources = new ArrayList<>();
    private String art_illum_method;
    private String art_illum_min;
    private String art_illum_max;

    @TREOrder(order = 1)
    @TREField(label = "SUN_ILLUM_METHOD")
    public String getSun_illum_method() {
        return sun_illum_method;
    }

    public void setSun_illum_method(String sun_illum_method) {
        this.sun_illum_method = sun_illum_method;
    }

    @TREOrder(order = 2)
    @TREField(label = "SUN_ILLUM")
    public String getSun_illum() {
        return sun_illum;
    }

    public void setSun_illum(String sun_illum) {
        this.sun_illum = sun_illum;
    }

    @TREOrder(order = 3)
    @TREField(label = "MOON_ILLUM_METHOD")
    public String getMoon_illum_method() {
        return moon_illum_method;
    }

    public void setMoon_illum_method(String moon_illum_method) {
        this.moon_illum_method = moon_illum_method;
    }

    @TREOrder(order = 4)
    @TREField(label = "SUN_ILLUM")
    public String getMoon_illum() {
        return moon_illum;
    }

    public void setMoon_illum(String moon_illum) {
        this.moon_illum = moon_illum;
    }

    @TREOrder(order = 5)
    @TREField(label = "TOT_SUNMOON_ILLUM")
    public String getTotal_sun_moon_illum() {
        return total_sun_moon_illum;
    }

    public void setTotal_sun_moon_illum(String total_sun_moon_illum) {
        this.total_sun_moon_illum = total_sun_moon_illum;
    }

    @TREOrder(order = 6)
    @TREGroup
    public List<OtherSourceBandIllum> getOtherSources() {
        return new ArrayList<>(otherSources);
    }

    public void addOtherSource(final OtherSourceBandIllum source) {
        otherSources.add(source);
    }

    @TREOrder(order = 7)
    @TREField(label = "ART_ILLUM_METHOD")
    public String getArt_illum_method() {
        return art_illum_method;
    }

    public void setArt_illum_method(String art_illum_method) {
        this.art_illum_method = art_illum_method;
    }

    @TREOrder(order = 8)
    @TREField(label = "ART_ILLUM_MIN")
    public String getArt_illum_min() {
        return art_illum_min;
    }

    public void setArt_illum_min(String art_illum_min) {
        this.art_illum_min = art_illum_min;
    }

    @TREOrder(order = 9)
    @TREField(label = "ART_ILLUM_MAX")
    public String getArt_illum_max() {
        return art_illum_max;
    }

    public void setArt_illum_max(String art_illum_max) {
        this.art_illum_max = art_illum_max;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Band Illumination";
    }
}
