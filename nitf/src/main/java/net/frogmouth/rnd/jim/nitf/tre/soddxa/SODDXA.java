package net.frogmouth.rnd.jim.nitf.tre.soddxa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class SODDXA extends TaggedRecordExtension {

    private static final String TRE_TAG = "SODDXA";
    private String cedata;

    public SODDXA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "CEDATA")
    public String getData() {
        return cedata;
    }

    public void setData(String cedata) {
        this.cedata = cedata;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
