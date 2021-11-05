package net.frogmouth.rnd.jim.npif.tables;

import java.text.DecimalFormat;

public class Position {
    private double latitudeRadians;
    private double longitudeRadians;

    public Position() {}

    public Position(Position other) {
        latitudeRadians = other.getLatitudeRadians();
        longitudeRadians = other.getLongitudeRadians();
    }

    public double getLatitudeRadians() {
        return latitudeRadians;
    }

    public double getLatitudeDegrees() {
        return latitudeRadians * 180.0 / Math.PI;
    }

    public void setLatitudeRadians(double latitudeRadians) {
        this.latitudeRadians = latitudeRadians;
    }

    public double getLongitudeRadians() {
        return longitudeRadians;
    }

    public double getLongitudeDegrees() {
        return longitudeRadians * 180.0 / Math.PI;
    }

    public void setLongitudeRadians(double longitudeRadians) {
        this.longitudeRadians = longitudeRadians;
    }

    public String asText() {
        DecimalFormat format = new DecimalFormat("0.#####");
        return format.format(getLatitudeDegrees()) + "," + format.format(getLongitudeDegrees());
    }
}
