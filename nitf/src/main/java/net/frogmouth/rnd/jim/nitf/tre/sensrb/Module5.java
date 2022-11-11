package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Module5 {

    private int referenceTime;
    private int referenceRow;
    private int referenceColumn;

    public int getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(int referenceTime) {
        this.referenceTime = referenceTime;
    }

    public int getReferenceRow() {
        return referenceRow;
    }

    public void setReferenceRow(int referenceRow) {
        this.referenceRow = referenceRow;
    }

    public int getReferenceColumn() {
        return referenceColumn;
    }

    public void setReferenceColumn(int referenceColumn) {
        this.referenceColumn = referenceColumn;
    }

    public Module5() {}

    public Module5(Module5 other) {
        this.referenceTime = other.referenceTime;
        this.referenceRow = other.referenceRow;
        this.referenceColumn = other.referenceColumn;
    }
}
