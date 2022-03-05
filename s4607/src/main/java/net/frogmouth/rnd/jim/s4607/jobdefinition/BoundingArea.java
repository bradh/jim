package net.frogmouth.rnd.jim.s4607.jobdefinition;

/**
 * Bounding area.
 *
 * <p>Bounding box for the the area for sensor service, expressed as. The four corners (J6 through
 * J13) of the bounding area, expressed as lat/long for each corner, are given in clockwise order
 * (Points A, B, C, and D) and must form a convex quadrilateral.
 */
public class BoundingArea {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    /** Constructor. */
    public BoundingArea() {}

    /**
     * Copy constructor.
     *
     * @param other the bounding area to copy values from.
     */
    public BoundingArea(BoundingArea other) {
        this.pointA = other.getPointA();
        this.pointB = other.getPointB();
        this.pointC = other.getPointC();
        this.pointD = other.getPointD();
    }

    /**
     * Get the Point A value.
     *
     * @return the point value.
     */
    public Point getPointA() {
        return new Point(pointA);
    }

    /**
     * Set the Point A value.
     *
     * @param pointA the point value
     */
    public void setPointA(Point pointA) {
        this.pointA = new Point(pointA);
    }

    /**
     * Get the Point B value.
     *
     * @return the point value.
     */
    public Point getPointB() {
        return new Point(pointB);
    }

    /**
     * Set the Point B value.
     *
     * @param pointB the point value
     */
    public void setPointB(Point pointB) {
        this.pointB = new Point(pointB);
    }

    /**
     * Get the Point C value.
     *
     * @return the point value.
     */
    public Point getPointC() {
        return new Point(pointC);
    }

    /**
     * Set the Point C value.
     *
     * @param pointC the point value
     */
    public void setPointC(Point pointC) {
        this.pointC = new Point(pointC);
    }

    /**
     * Get the Point D value.
     *
     * @return the point value.
     */
    public Point getPointD() {
        return new Point(pointD);
    }

    /**
     * Set the Point D value.
     *
     * @param pointD the point value
     */
    public void setPointD(Point pointD) {
        this.pointD = new Point(pointD);
    }
}
