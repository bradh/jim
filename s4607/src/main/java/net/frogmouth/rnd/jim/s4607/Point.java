package net.frogmouth.rnd.jim.s4607;

/**
 * Point location.
 *
 * <p>This conceptually represents a point expressed as a two-dimensional latitude-longitude pair.
 */
public class Point {
    private double latitude;
    private double longitude;

    /** Constructor. */
    public Point() {}

    /**
     * Constructor.
     *
     * @param latitude latitude as a floating point value (decimal degrees) - north positive.
     * @param longitude longitude as a floating point value (decimal degrees) - east positive.
     */
    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Copy constructor.
     *
     * @param other the point to copy values from.
     */
    public Point(Point other) {
        this.latitude = other.getLatitude();
        this.longitude = other.getLongitude();
    }

    /**
     * Get the latitude value.
     *
     * @return latitude as a floating point value (decimal degrees) - north positive.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Set the latitude value.
     *
     * @param latitude latitude as a floating point value (decimal degrees) - north positive.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Get the longitude value.
     *
     * <p>Longitude values are in the range 0 to 360.0, degrees east of the prime meridian.
     *
     * @return longitude as a floating point value (decimal degrees).
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Set the longitude value.
     *
     * <p>Longitude values are in the range 0 to 360.0, degrees east of the prime meridian.
     *
     * @param longitude longitude as a floating point value (decimal degrees)
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
