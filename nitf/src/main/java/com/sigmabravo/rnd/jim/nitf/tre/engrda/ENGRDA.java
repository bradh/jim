package com.sigmabravo.rnd.jim.nitf.tre.engrda;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;

public class ENGRDA extends TRE {

    private static final String TRE_TAG = "ENGRDA";
    private String resrc;
    private final List<Record> records = new ArrayList<>();

    public ENGRDA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "RESRC")
    public String getResrc() {
        return resrc;
    }

    public void setResrc(final String resrc) {
        this.resrc = resrc;
    }

    @TREOrder(order = 2)
    @TREGroup
    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    public void addRecord(final Record record) {
        records.add(record);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
