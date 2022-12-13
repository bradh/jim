package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.io.ByteArrayOutputStream;

public class Module9 {

    private double attitudeQ1;
    private double attitudeQ2;
    private double attitudeQ3;
    private double attitudeQ4;

    public Module9() {}

    public Module9(Module9 other) {
        this.attitudeQ1 = other.attitudeQ1;
        this.attitudeQ2 = other.attitudeQ2;
        this.attitudeQ3 = other.attitudeQ3;
        this.attitudeQ4 = other.attitudeQ4;
    }

    public double getAttitudeQ1() {
        return attitudeQ1;
    }

    public void setAttitudeQ1(double attitudeQ1) {
        this.attitudeQ1 = attitudeQ1;
    }

    public double getAttitudeQ2() {
        return attitudeQ2;
    }

    public void setAttitudeQ2(double attitudeQ2) {
        this.attitudeQ2 = attitudeQ2;
    }

    public double getAttitudeQ3() {
        return attitudeQ3;
    }

    public void setAttitudeQ3(double attitudeQ3) {
        this.attitudeQ3 = attitudeQ3;
    }

    public double getAttitudeQ4() {
        return attitudeQ4;
    }

    public void setAttitudeQ4(double attitudeQ4) {
        this.attitudeQ4 = attitudeQ4;
    }

    void appendBytes(ByteArrayOutputStream baos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
