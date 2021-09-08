package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.SortedMap;
import java.util.TreeMap;
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

    @TREField(label = "CAMERA_ID", order = 1)
    public UUID getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(UUID camera_id) {
        this.camera_id = camera_id;
    }

    @TREField(label = "CAMERA_DESC", order = 2)
    public String getCamera_desc() {
        return camera_desc;
    }

    public void setCamera_desc(String camera_desc) {
        this.camera_desc = camera_desc;
    }

    @TREField(label = "LAYER_ID", order = 3)
    public String getLayer_id() {
        return layer_id;
    }

    public void setLayer_id(String layer_id) {
        this.layer_id = layer_id;
    }

    @TREField(label = "IDLVL", order = 4)
    public int getIdlvl() {
        return idlvl;
    }

    public void setIdlvl(int idlvl) {
        this.idlvl = idlvl;
    }

    @TREField(label = "IALVL", order = 5)
    public int getIalvl() {
        return ialvl;
    }

    public void setIalvl(int ialvl) {
        this.ialvl = ialvl;
    }

    @TREField(label = "ILOC(ROW)", order = 6)
    public int getIloc_row() {
        return iloc_row;
    }

    public void setIloc_row(int iloc_row) {
        this.iloc_row = iloc_row;
    }

    @TREField(label = "ILOC(COL)", order = 7)
    public int getIloc_col() {
        return iloc_col;
    }

    public void setIloc_col(int iloc_col) {
        this.iloc_col = iloc_col;
    }

    @TREField(label = "NROWS", order = 8)
    public int getNrows() {
        return nrows;
    }

    public void setNrows(int nrows) {
        this.nrows = nrows;
    }

    @TREField(label = "NCOLS", order = 9)
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

    public String getTreeItemLabel() {
        return "Camera";
    }

    public TreeItem<String> toTreeItem() {
        TreeItem<String> treeItem = new TreeItem<>(getTreeItemLabel());
        Method[] methods = this.getClass().getDeclaredMethods();
        SortedMap<Integer, Method> treeGetterMethods = new TreeMap<>();
        try {
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof TREField) {
                        treeGetterMethods.put(((TREField) annotation).order(), method);
                    }
                }
            }
            for (Method method : treeGetterMethods.values()) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof TREField) {
                        TREField treField = (TREField) annotation;
                        treeItem.getChildren()
                                .add(
                                        new TreTreeItem(
                                                treField.label(), method.invoke(this).toString()));
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return treeItem;
    }
}
