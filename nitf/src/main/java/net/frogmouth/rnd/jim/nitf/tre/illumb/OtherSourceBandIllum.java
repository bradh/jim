package net.frogmouth.rnd.jim.nitf.tre.illumb;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class OtherSourceBandIllum extends TreePart {

    private String other_illum_method;
    private String other_illum;

    @TREOrder(order = 1)
    @TREField(label = "OTHER_ILLUM_METHOD")
    public String getOther_illum_method() {
        return other_illum_method;
    }

    public void setOther_illum_method(String other_illum_method) {
        this.other_illum_method = other_illum_method;
    }

    @TREOrder(order = 2)
    @TREField(label = "OTHER_ILLUM")
    public String getOther_illum() {
        return other_illum;
    }

    public void setOther_illum(String other_illum) {
        this.other_illum = other_illum;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Other Light Source";
    }
}
