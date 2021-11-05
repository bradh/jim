package net.frogmouth.rnd.jim.nitf.tre.engrda;

import javafx.scene.control.TreeItem;
import net.frogmouth.rnd.jim.nitf.tre.TreTreeItem;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class Record extends TreePart {
    private int engln;
    private String englbl;
    private int engmtxc;
    private int engmtxr;
    private String engtyp;
    private int engdts;
    private String engdatu;
    private int engdatc;
    private EngData engdata;

    public int getEngln() {
        return engln;
    }

    public void setEngln(int engln) {
        this.engln = engln;
    }

    public String getEnglbl() {
        return englbl;
    }

    public void setEnglbl(String englbl) {
        this.englbl = englbl;
    }

    public int getEngmtxc() {
        return engmtxc;
    }

    public void setEngmtxc(int engmtxc) {
        this.engmtxc = engmtxc;
    }

    public int getEngmtxr() {
        return engmtxr;
    }

    public void setEngmtxr(int engmtxr) {
        this.engmtxr = engmtxr;
    }

    public String getEngtyp() {
        return engtyp;
    }

    public void setEngtyp(String engtyp) {
        this.engtyp = engtyp;
    }

    public int getEngdts() {
        return engdts;
    }

    public void setEngdts(int engdts) {
        this.engdts = engdts;
    }

    public String getEngdatu() {
        return engdatu;
    }

    public void setEngdatu(String engdatu) {
        this.engdatu = engdatu;
    }

    public int getEngdatc() {
        return engdatc;
    }

    public void setEngdatc(int engdatc) {
        this.engdatc = engdatc;
    }

    public EngData getEngdata() {
        return engdata;
    }

    public void setEngdata(EngData engdata) {
        this.engdata = engdata;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Record";
    }

    @Override
    public TreeItem<String> toTreeItem() {
        TreeItem<String> treeItem = new TreeItem<>(getTreeItemLabel());
        treeItem.getChildren().add(new TreTreeItem("ENGLN: ", getEngln()));
        treeItem.getChildren().add(new TreTreeItem("ENGLBL", getEnglbl()));
        treeItem.getChildren().add(new TreTreeItem("ENGMTXC", getEngmtxc()));
        treeItem.getChildren().add(new TreTreeItem("ENGMTXR", getEngmtxr()));
        treeItem.getChildren().add(new TreTreeItem("ENGTYP", getEngtyp()));
        treeItem.getChildren().add(new TreTreeItem("ENGDTS", getEngdts()));
        treeItem.getChildren().add(new TreTreeItem("ENGDATU", getEngdatu()));
        treeItem.getChildren().add(new TreTreeItem("ENGDATC", getEngdatc()));
        if (getEngdata() != null) {
            treeItem.getChildren().add(new TreTreeItem("ENGDATA", getEngdata().toString()));
        }

        return treeItem;
    }
}
