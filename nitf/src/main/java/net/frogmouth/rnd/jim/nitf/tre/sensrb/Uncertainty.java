package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Uncertainty {
    private String firstType;
    private String secondType;
    private double value;

    public Uncertainty() {}

    public Uncertainty(Uncertainty other) {
        this.firstType = other.firstType;
        this.secondType = other.secondType;
        this.value = other.value;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
