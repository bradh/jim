package net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;

public class BoundingArea {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public BoundingArea() {}

    public BoundingArea(BoundingArea other) {
        this.pointA = other.getPointA();
        this.pointB = other.getPointB();
        this.pointC = other.getPointC();
        this.pointD = other.getPointD();
    }

    public Point getPointA() {
        return new Point(pointA);
    }

    public void setPointA(Point pointA) {
        this.pointA = new Point(pointA);
    }

    public Point getPointB() {
        return new Point(pointB);
    }

    public void setPointB(Point pointB) {
        this.pointB = new Point(pointB);
    }

    public Point getPointC() {
        return new Point(pointC);
    }

    public void setPointC(Point pointC) {
        this.pointC = new Point(pointC);
    }

    public Point getPointD() {
        return new Point(pointD);
    }

    public void setPointD(Point poindD) {
        this.pointD = new Point(poindD);
    }
}
