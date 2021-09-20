package com.sigmabravo.rnd.jim.nitf.tre.illumb;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;

public class OtherIllumSource extends TreePart {
    private String name;

    @TREOrder(order = 1)
    @TREField(label = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Other Natural Light Source";
    }
}
