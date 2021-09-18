package com.sigmabravo.rnd.jim.ccinfa.tre;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;

public class Code extends TreePart {

    private String code;
    private String eqtype;
    private String esurn;
    private String detail;

    @TREField(label = "CODE")
    @TREOrder(order = 1)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @TREField(label = "EQTYPE")
    @TREOrder(order = 2)
    public String getEqtype() {
        return eqtype;
    }

    public void setEqtype(String eqtype) {
        this.eqtype = eqtype;
    }

    @TREField(label = "ESURN")
    @TREOrder(order = 3)
    public String getEsurn() {
        return esurn;
    }

    public void setEsurn(String esurn) {
        this.esurn = esurn;
    }

    @TREField(label = "DETAIL")
    @TREOrder(order = 4)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Defined Code";
    }

}
