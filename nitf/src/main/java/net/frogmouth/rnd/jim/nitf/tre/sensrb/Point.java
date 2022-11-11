package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Point {
    private int row;
    private int column;
    private String latitude;
    private String longitude;
    private String elevation;
    private String range;

    public Point() {}

    public Point(Point other) {
        this.row = other.row;
        this.column = other.column;
        this.latitude = other.latitude;
        this.longitude = other.longitude;
        this.elevation = other.elevation;
        this.range = other.range;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
