package net.frogmouth.rnd.jim.nitf.tre.illumb;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class Band extends TreePart {
    private String lbound;
    private String ubound;

    @TREOrder(order = 1)
    @TREField(label = "LBOUND")
    public String getLowerBound() {
        return lbound;
    }

    public void setLowerBound(final String lowerBound) {
        this.lbound = lowerBound;
    }

    @TREOrder(order = 2)
    @TREField(label = "UBOUND")
    public String getUpperBound() {
        return ubound;
    }

    public void setUpperBound(final String upperBound) {
        this.ubound = upperBound;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Band";
    }
}
