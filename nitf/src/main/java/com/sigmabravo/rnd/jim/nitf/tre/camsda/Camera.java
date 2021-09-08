package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;
import java.util.UUID;

/** Camera, part of Camera Set within CAMSDA TRE. */
public class Camera extends TreePart {
    private UUID camera_id;
    private String camera_desc;
    private String layer_id;
    private int idlvl;
    private int ialvl;
    private int iloc_row;
    private int iloc_col;
    private int nrows;
    private int ncols;

    @TREField(label = "CAMERA_ID")
    @TREOrder(order = 1)
    public UUID getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(UUID camera_id) {
        this.camera_id = camera_id;
    }

    @TREField(label = "CAMERA_DESC")
    @TREOrder(order = 2)
    public String getCamera_desc() {
        return camera_desc;
    }

    public void setCamera_desc(String camera_desc) {
        this.camera_desc = camera_desc;
    }

    @TREField(label = "LAYER_ID")
    @TREOrder(order = 3)
    public String getLayer_id() {
        return layer_id;
    }

    public void setLayer_id(String layer_id) {
        this.layer_id = layer_id;
    }

    @TREField(label = "IDLVL")
    @TREOrder(order = 4)
    public int getIdlvl() {
        return idlvl;
    }

    public void setIdlvl(int idlvl) {
        this.idlvl = idlvl;
    }

    @TREField(label = "IALVL")
    @TREOrder(order = 5)
    public int getIalvl() {
        return ialvl;
    }

    public void setIalvl(int ialvl) {
        this.ialvl = ialvl;
    }

    @TREField(label = "ILOC(ROW)")
    @TREOrder(order = 6)
    public int getIloc_row() {
        return iloc_row;
    }

    public void setIloc_row(int iloc_row) {
        this.iloc_row = iloc_row;
    }

    @TREField(label = "ILOC(COL)")
    @TREOrder(order = 7)
    public int getIloc_col() {
        return iloc_col;
    }

    public void setIloc_col(int iloc_col) {
        this.iloc_col = iloc_col;
    }

    @TREField(label = "NROWS")
    @TREOrder(order = 8)
    public int getNrows() {
        return nrows;
    }

    public void setNrows(int nrows) {
        this.nrows = nrows;
    }

    @TREField(label = "NCOLS")
    @TREOrder(order = 9)
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

    @Override
    public String getTreeItemLabel() {
        return "Camera";
    }
}
