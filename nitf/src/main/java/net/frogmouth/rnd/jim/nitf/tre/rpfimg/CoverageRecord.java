package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

public class CoverageRecord {
    private double upperLeftLatitude;
    private double upperLeftLongitude;
    private double lowerLeftLatitude;
    private double lowerLeftLongitude;
    private double upperRightLatitude;
    private double upperRightLongitude;
    private double lowerRightLatitude;
    private double lowerRightLongitude;
    private double verticalResolution;
    private double horizontalResolution;
    private double verticalInterval;
    private double horizontalInterval;

    public CoverageRecord() {}

    public CoverageRecord(final CoverageRecord other) {
        this.upperLeftLatitude = other.upperLeftLatitude;
        this.upperLeftLongitude = other.upperLeftLongitude;
        this.lowerLeftLatitude = other.lowerLeftLatitude;
        this.lowerLeftLongitude = other.lowerLeftLongitude;
        this.upperRightLatitude = other.upperRightLatitude;
        this.upperRightLongitude = other.upperRightLongitude;
        this.lowerRightLatitude = other.lowerRightLatitude;
        this.lowerRightLongitude = other.lowerRightLongitude;
        this.verticalResolution = other.verticalResolution;
        this.horizontalResolution = other.horizontalResolution;
        this.verticalInterval = other.verticalInterval;
        this.horizontalInterval = other.horizontalInterval;
    }

    public double getUpperLeftLatitude() {
        return upperLeftLatitude;
    }

    public void setUpperLeftLatitude(double upperLeftLatitude) {
        this.upperLeftLatitude = upperLeftLatitude;
    }

    public double getUpperLeftLongitude() {
        return upperLeftLongitude;
    }

    public void setUpperLeftLongitude(double upperLeftLongitude) {
        this.upperLeftLongitude = upperLeftLongitude;
    }

    public double getLowerLeftLatitude() {
        return lowerLeftLatitude;
    }

    public void setLowerLeftLatitude(double lowerLeftLatitude) {
        this.lowerLeftLatitude = lowerLeftLatitude;
    }

    public double getLowerLeftLongitude() {
        return lowerLeftLongitude;
    }

    public void setLowerLeftLongitude(double lowerLeftLongitude) {
        this.lowerLeftLongitude = lowerLeftLongitude;
    }

    public double getUpperRightLatitude() {
        return upperRightLatitude;
    }

    public void setUpperRightLatitude(double upperRightLatitude) {
        this.upperRightLatitude = upperRightLatitude;
    }

    public double getUpperRightLongitude() {
        return upperRightLongitude;
    }

    public void setUpperRightLongitude(double upperRightLongitude) {
        this.upperRightLongitude = upperRightLongitude;
    }

    public double getLowerRightLatitude() {
        return lowerRightLatitude;
    }

    public void setLowerRightLatitude(double lowerRightLatitude) {
        this.lowerRightLatitude = lowerRightLatitude;
    }

    public double getLowerRightLongitude() {
        return lowerRightLongitude;
    }

    public void setLowerRightLongitude(double lowerRightLongitude) {
        this.lowerRightLongitude = lowerRightLongitude;
    }

    public double getVerticalResolution() {
        return verticalResolution;
    }

    public void setVerticalResolution(double verticalResolution) {
        this.verticalResolution = verticalResolution;
    }

    public double getHorizontalResolution() {
        return horizontalResolution;
    }

    public void setHorizontalResolution(double horizontalResolution) {
        this.horizontalResolution = horizontalResolution;
    }

    public double getVerticalInterval() {
        return verticalInterval;
    }

    public void setVerticalInterval(double verticalInterval) {
        this.verticalInterval = verticalInterval;
    }

    public double getHorizontalInterval() {
        return horizontalInterval;
    }

    public void setHorizontalInterval(double horizontalInterval) {
        this.horizontalInterval = horizontalInterval;
    }
}
