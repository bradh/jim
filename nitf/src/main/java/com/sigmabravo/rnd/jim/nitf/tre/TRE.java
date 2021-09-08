package com.sigmabravo.rnd.jim.nitf.tre;

/** @author bradh */
public abstract class TRE extends TreePart {
    private String tag;

    public TRE(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
