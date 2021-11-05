package net.frogmouth.rnd.jim.nitf.tre.engrda;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TRE;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;

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
