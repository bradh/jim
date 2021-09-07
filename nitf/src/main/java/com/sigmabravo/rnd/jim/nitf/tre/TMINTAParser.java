package com.sigmabravo.rnd.jim.nitf.tre;

import javafx.scene.control.TreeItem;

/** TMINTA TRE Parser. */
public class TMINTAParser implements ITREParser {

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "TMINTA";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        return new TRE(tag) {
            @Override
            public TreeItem<String> toTreeItem() {
                TreeItem<String> treeItem = new TreeItem<>();
                treeItem.setValue(tag);
                return treeItem;
            }
        };
    }
}
