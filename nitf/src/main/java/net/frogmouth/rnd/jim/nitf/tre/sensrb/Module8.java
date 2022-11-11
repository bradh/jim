package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Module8 {
    private double icxNorthOrX;
    private double icxEastOrY;
    private double icxDownOrZ;
    private double icyNorthOrX;
    private double icyEastOrY;
    private double icyDownOrZ;
    private double iczNorthOrX;
    private double iczEastOrY;
    private double iczDownOrZ;

    public Module8() {}

    public Module8(Module8 other) {
        this.icxNorthOrX = other.icxNorthOrX;
        this.icxEastOrY = other.icxEastOrY;
        this.icxDownOrZ = other.icxDownOrZ;
        this.icyNorthOrX = other.icyNorthOrX;
        this.icyEastOrY = other.icyEastOrY;
        this.icyDownOrZ = other.icyDownOrZ;
        this.iczNorthOrX = other.iczNorthOrX;
        this.iczEastOrY = other.iczEastOrY;
        this.iczDownOrZ = other.iczDownOrZ;
    }

    public double getIcxNorthOrX() {
        return icxNorthOrX;
    }

    public void setIcxNorthOrX(double icxNorthOrX) {
        this.icxNorthOrX = icxNorthOrX;
    }

    public double getIcxEastOrY() {
        return icxEastOrY;
    }

    public void setIcxEastOrY(double icxEastOrY) {
        this.icxEastOrY = icxEastOrY;
    }

    public double getIcxDownOrZ() {
        return icxDownOrZ;
    }

    public void setIcxDownOrZ(double icxDownOrZ) {
        this.icxDownOrZ = icxDownOrZ;
    }

    public double getIcyNorthOrX() {
        return icyNorthOrX;
    }

    public void setIcyNorthOrX(double icyNorthOrX) {
        this.icyNorthOrX = icyNorthOrX;
    }

    public double getIcyEastOrY() {
        return icyEastOrY;
    }

    public void setIcyEastOrY(double icyEastOrY) {
        this.icyEastOrY = icyEastOrY;
    }

    public double getIcyDownOrZ() {
        return icyDownOrZ;
    }

    public void setIcyDownOrZ(double icyDownOrZ) {
        this.icyDownOrZ = icyDownOrZ;
    }

    public double getIczNorthOrX() {
        return iczNorthOrX;
    }

    public void setIczNorthOrX(double iczNorthOrX) {
        this.iczNorthOrX = iczNorthOrX;
    }

    public double getIczEastOrY() {
        return iczEastOrY;
    }

    public void setIczEastOrY(double iczEastOrY) {
        this.iczEastOrY = iczEastOrY;
    }

    public double getIczDownOrZ() {
        return iczDownOrZ;
    }

    public void setIczDownOrZ(double iczDownOrZ) {
        this.iczDownOrZ = iczDownOrZ;
    }
}
