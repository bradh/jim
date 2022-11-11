package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.util.ArrayList;
import java.util.List;

public class PointSet {
    private String pointSetType;
    private List<Point> points = new ArrayList<>();

    public PointSet() {}

    public String getPointSetType() {
        return pointSetType;
    }

    public void setPointSetType(String pointSetType) {
        this.pointSetType = pointSetType;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }
}
