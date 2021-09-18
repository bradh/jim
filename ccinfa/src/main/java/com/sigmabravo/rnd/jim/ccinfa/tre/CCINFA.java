package com.sigmabravo.rnd.jim.ccinfa.tre;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;

public class CCINFA extends TRE {

    private static final String TRE_TAG = "CCINFA";
    private final List<Code> codes = new ArrayList<>();;
    
    public CCINFA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREGroup
    public List<Code> getCodes() {
        return new ArrayList<>(codes);
    }

    public void addCode(final Code code) {
        codes.add(code);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
