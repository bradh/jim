package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Module5 {

    // TODO: possibly these should be Double
    private Integer referenceTime;
    private Integer referenceRow;
    private Integer referenceColumn;

    public Module5() {}

    public Module5(Module5 other) {
        this.referenceTime = other.referenceTime;
        this.referenceRow = other.referenceRow;
        this.referenceColumn = other.referenceColumn;
    }

    public Integer getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(Integer referenceTime) {
        this.referenceTime = referenceTime;
    }

    public Integer getReferenceRow() {
        return referenceRow;
    }

    public void setReferenceRow(Integer referenceRow) {
        this.referenceRow = referenceRow;
    }

    public Integer getReferenceColumn() {
        return referenceColumn;
    }

    public void setReferenceColumn(Integer referenceColumn) {
        this.referenceColumn = referenceColumn;
    }
}
