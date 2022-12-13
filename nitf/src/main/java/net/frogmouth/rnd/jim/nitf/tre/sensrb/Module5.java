package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.COLUMN_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.REFERENCE_TIME_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.ROW_LEN;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

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

    void appendBytes(ByteArrayOutputStream baos) {
        baos.writeBytes(WriterUtils.toBCS_NPI(referenceTime, REFERENCE_TIME_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(referenceRow, ROW_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(referenceColumn, COLUMN_LEN));
    }
}
