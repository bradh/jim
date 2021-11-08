package net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;

public class Point {
    private double latitude;
    private double longitude;

    public Point() {}

    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Point(Point other) {
        this.latitude = other.getLatitude();
        this.longitude = other.getLongitude();
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
