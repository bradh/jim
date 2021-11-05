package net.frogmouth.rnd.jim.nitf.tre.blocka;

import net.frogmouth.rnd.jim.nitf.tre.TRE;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;

public class BLOCKA extends TRE {

    private static final String TRE_TAG = "BLOCKA";
    private int block_instance;
    private int n_gray;
    private int l_lines;
    private String layover_angle;
    private String shadow_angle;
    private String frlc_loc;
    private String lrlc_loc;
    private String lrfc_loc;
    private String frfc_loc;

    public BLOCKA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "BLOCK_INSTANCE")
    public int getBlock_instance() {
        return block_instance;
    }

    public void setBlock_instance(int block_instance) {
        this.block_instance = block_instance;
    }

    @TREOrder(order = 2)
    @TREField(label = "N_GRAY")
    public int getN_gray() {
        return n_gray;
    }

    public void setN_gray(int n_gray) {
        this.n_gray = n_gray;
    }

    @TREOrder(order = 3)
    @TREField(label = "L_LINES")
    public int getL_lines() {
        return l_lines;
    }

    public void setL_lines(int l_lines) {
        this.l_lines = l_lines;
    }

    @TREOrder(order = 4)
    @TREField(label = "LAYOVER_ANGLE")
    public String getLayover_angle() {
        return layover_angle;
    }

    public void setLayover_angle(String layover_angle) {
        this.layover_angle = layover_angle;
    }

    @TREOrder(order = 5)
    @TREField(label = "SHADOW_ANGLE")
    public String getShadow_angle() {
        return shadow_angle;
    }

    public void setShadow_angle(String shadow_angle) {
        this.shadow_angle = shadow_angle;
    }

    @TREOrder(order = 6)
    @TREField(label = "FRLC_LOC")
    public String getFrlc_loc() {
        return frlc_loc;
    }

    public void setFrlc_loc(String frlc_loc) {
        this.frlc_loc = frlc_loc;
    }

    @TREOrder(order = 7)
    @TREField(label = "LRLC_LOC")
    public String getLrlc_loc() {
        return lrlc_loc;
    }

    public void setLrlc_loc(String lrlc_loc) {
        this.lrlc_loc = lrlc_loc;
    }

    @TREOrder(order = 8)
    @TREField(label = "LRLC_LOC")
    public String getLrfc_loc() {
        return lrfc_loc;
    }

    public void setLrfc_loc(String lrfc_loc) {
        this.lrfc_loc = lrfc_loc;
    }

    @TREOrder(order = 9)
    @TREField(label = "FRFC_LOC")
    public String getFrfc_loc() {
        return frfc_loc;
    }

    public void setFrfc_loc(String frfc_loc) {
        this.frfc_loc = frfc_loc;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
