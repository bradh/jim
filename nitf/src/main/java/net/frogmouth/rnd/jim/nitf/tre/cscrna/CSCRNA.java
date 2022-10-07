package net.frogmouth.rnd.jim.nitf.tre.cscrna;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class CSCRNA extends TaggedRecordExtension {

    private static final String TRE_TAG = "CSCRNA";
    private String predictCorners;
    private double ulcnr_lat;
    private double ulcnr_lon;
    private double ulcnr_ht;
    private double urcnr_lat;
    private double urcnr_lon;
    private double urcnr_ht;
    private double lrcnr_lat;
    private double lrcnr_lon;
    private double lrcnr_ht;
    private double llcnr_lat;
    private double llcnr_lon;
    private double llcnr_ht;

    public CSCRNA() {
        super(TRE_TAG);
    }
    /*
        @TREOrder(order = 1)
        @TREField(label = "DAY")
        public int getDay() {
            return day;
        }
    */

    @TREOrder(order = 1)
    @TREField(label = "PREDICT_CORNERS")
    public String getPredictCorners() {
        return predictCorners;
    }

    public void setPredictCorners(String predictCorners) {
        this.predictCorners = predictCorners;
    }

    @TREOrder(order = 2)
    @TREField(label = "ULCNR_LAT")
    public double getUlcnr_lat() {
        return ulcnr_lat;
    }

    public void setUlcnr_lat(double ulcnr_lat) {
        this.ulcnr_lat = ulcnr_lat;
    }

    @TREOrder(order = 2)
    @TREField(label = "ULCNR_LONG")
    public double getUlcnr_lon() {
        return ulcnr_lon;
    }

    public void setUlcnr_lon(double ulcnr_lon) {
        this.ulcnr_lon = ulcnr_lon;
    }

    @TREOrder(order = 3)
    @TREField(label = "ULCNR_HT")
    public double getUlcnr_ht() {
        return ulcnr_ht;
    }

    public void setUlcnr_ht(double ulcnr_ht) {
        this.ulcnr_ht = ulcnr_ht;
    }

    @TREOrder(order = 4)
    @TREField(label = "URCNR_LAT")
    public double getUrcnr_lat() {
        return urcnr_lat;
    }

    public void setUrcnr_lat(double urcnr_lat) {
        this.urcnr_lat = urcnr_lat;
    }

    @TREOrder(order = 5)
    @TREField(label = "URCNR_LONG")
    public double getUrcnr_lon() {
        return urcnr_lon;
    }

    public void setUrcnr_lon(double urcnr_lon) {
        this.urcnr_lon = urcnr_lon;
    }

    @TREOrder(order = 6)
    @TREField(label = "URCNR_HT")
    public double getUrcnr_ht() {
        return urcnr_ht;
    }

    public void setUrcnr_ht(double urcnr_ht) {
        this.urcnr_ht = urcnr_ht;
    }

    @TREOrder(order = 7)
    @TREField(label = "LRCNR_LAT")
    public double getLrcnr_lat() {
        return lrcnr_lat;
    }

    public void setLrcnr_lat(double lrcnr_lat) {
        this.lrcnr_lat = lrcnr_lat;
    }

    @TREOrder(order = 8)
    @TREField(label = "LRCNR_LONG")
    public double getLrcnr_lon() {
        return lrcnr_lon;
    }

    public void setLrcnr_lon(double lrcnr_lon) {
        this.lrcnr_lon = lrcnr_lon;
    }

    @TREOrder(order = 9)
    @TREField(label = "LRCNR_HT")
    public double getLrcnr_ht() {
        return lrcnr_ht;
    }

    public void setLrcnr_ht(double lrcnr_ht) {
        this.lrcnr_ht = lrcnr_ht;
    }

    @TREOrder(order = 10)
    @TREField(label = "LLCNR_LAT")
    public double getLlcnr_lat() {
        return llcnr_lat;
    }

    public void setLlcnr_lat(double llcnr_lat) {
        this.llcnr_lat = llcnr_lat;
    }

    @TREOrder(order = 11)
    @TREField(label = "LLCNR_LONG")
    public double getLlcnr_lon() {
        return llcnr_lon;
    }

    public void setLlcnr_lon(double llcnr_lon) {
        this.llcnr_lon = llcnr_lon;
    }

    @TREOrder(order = 12)
    @TREField(label = "LLCNR_HT")
    public double getLlcnr_ht() {
        return llcnr_ht;
    }

    public void setLlcnr_ht(double llcnr_ht) {
        this.llcnr_ht = llcnr_ht;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
