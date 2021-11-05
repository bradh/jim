package net.frogmouth.rnd.jim.mie4nitf.tre.mtimsa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class DeltaTime extends TreePart {

    private long dt;

    @TREField(label = "DT")
    @TREOrder(order = 1)
    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Delta Time";
    }
}
