package com.sigmabravo.rnd.jim.nitf.tre;

import java.util.UUID;
import javafx.scene.control.TreeItem;

/** Convenience wrapper for a TRE TreeItem. */
public class TreTreeItem extends TreeItem<String> {
    public TreTreeItem(String label, String value) {
        super(label + ": " + value);
    }

    TreTreeItem(String label, UUID uuid) {
        super(label + ": " + uuid.toString());
    }
}
