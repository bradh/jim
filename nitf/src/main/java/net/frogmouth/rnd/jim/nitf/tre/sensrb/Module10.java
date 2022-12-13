package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.io.ByteArrayOutputStream;

public class Module10 {
    private double velocityNorthOrX;
    private double velocityEastOrY;
    private double velocityDownOrZ;

    public Module10() {}

    public Module10(Module10 other) {
        this.velocityNorthOrX = other.velocityNorthOrX;
        this.velocityEastOrY = other.velocityEastOrY;
        this.velocityDownOrZ = other.velocityDownOrZ;
    }

    public double getVelocityNorthOrX() {
        return velocityNorthOrX;
    }

    public void setVelocityNorthOrX(double velocityNorthOrX) {
        this.velocityNorthOrX = velocityNorthOrX;
    }

    public double getVelocityEastOrY() {
        return velocityEastOrY;
    }

    public void setVelocityEastOrY(double velocityEastOrY) {
        this.velocityEastOrY = velocityEastOrY;
    }

    public double getVelocityDownOrZ() {
        return velocityDownOrZ;
    }

    public void setVelocityDownOrZ(double velocityDownOrZ) {
        this.velocityDownOrZ = velocityDownOrZ;
    }

    void appendBytes(ByteArrayOutputStream baos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
