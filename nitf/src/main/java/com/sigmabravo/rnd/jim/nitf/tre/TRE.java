package com.sigmabravo.rnd.jim.nitf.tre;

import javafx.scene.control.TreeItem;

/** @author bradh */
public abstract class TRE {
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

    public abstract TreeItem<String> toTreeItem();
}
