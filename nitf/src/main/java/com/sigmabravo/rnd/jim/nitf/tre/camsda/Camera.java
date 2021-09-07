package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import java.util.UUID;
import javafx.scene.control.TreeItem;

/** Camera, part of Camera Set within CAMSDA TRE. */
class Camera {
    private UUID camera_id;
    private String camera_desc;
    private String layer_id;
    private int idlvl;
    private int ialvl;
    private int iloc_row;
    private int iloc_col;
    private int nrows;
    private int ncols;

    public UUID getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(UUID camera_id) {
        this.camera_id = camera_id;
    }

    public String getCamera_desc() {
        return camera_desc;
    }

    public void setCamera_desc(String camera_desc) {
        this.camera_desc = camera_desc;
    }

    public String getLayer_id() {
        return layer_id;
    }

    public void setLayer_id(String layer_id) {
        this.layer_id = layer_id;
    }

    public int getIdlvl() {
        return idlvl;
    }

    public void setIdlvl(int idlvl) {
        this.idlvl = idlvl;
    }

    public int getIalvl() {
        return ialvl;
    }

    public void setIalvl(int ialvl) {
        this.ialvl = ialvl;
    }

    public int getIloc_row() {
        return iloc_row;
    }

    public void setIloc_row(int iloc_row) {
        this.iloc_row = iloc_row;
    }

    public int getIloc_col() {
        return iloc_col;
    }

    public void setIloc_col(int iloc_col) {
        this.iloc_col = iloc_col;
    }

    public int getNrows() {
        return nrows;
    }

    public void setNrows(int nrows) {
        this.nrows = nrows;
    }

    public int getNcols() {
        return ncols;
    }

    public void setNcols(int ncols) {
        this.ncols = ncols;
    }

    @Override
    public String toString() {
        return "Camera{"
                + "camera_id="
                + camera_id
                + ", camera_desc="
                + camera_desc
                + ", layer_id="
                + layer_id
                + ", idlvl="
                + idlvl
                + ", ialvl="
                + ialvl
                + ", iloc_row="
                + iloc_row
                + ", iloc_col="
                + iloc_col
                + ", nrows="
                + nrows
                + ", ncols="
                + ncols
                + '}';
    }

    public TreeItem<String> toTreeItem() {
        TreeItem<String> treeItem = new TreeItem<>("Camera");
        treeItem.getChildren().add(new TreeItem<>("CAMERA_ID: " + camera_id));
        treeItem.getChildren().add(new TreeItem<>("CAMERA_DESC: " + camera_desc));
        treeItem.getChildren().add(new TreeItem<>("LAYER_ID: " + layer_id));
        treeItem.getChildren().add(new TreeItem<>("IDLVL: " + idlvl));
        treeItem.getChildren().add(new TreeItem<>("IALVL: " + ialvl));
        treeItem.getChildren().add(new TreeItem<>("ILOC: " + iloc_row + iloc_col));
        treeItem.getChildren().add(new TreeItem<>("NROWS: " + nrows));
        treeItem.getChildren().add(new TreeItem<>("NCOLS: " + ncols));
        return treeItem;
    }
}
