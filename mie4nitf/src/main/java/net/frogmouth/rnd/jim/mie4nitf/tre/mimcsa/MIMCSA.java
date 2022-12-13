package net.frogmouth.rnd.jim.mie4nitf.tre.mimcsa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class MIMCSA extends TaggedRecordExtension {

    private static final String TRE_TAG = "MIMCSA";

    private String layer_id;
    private Double nominal_frame_rate;
    private Double min_frame_rate;
    private Double max_frame_rate;
    private int t_rset;
    private String mi_req_decoder;
    private String mi_req_profile;
    private String mi_req_level;

    public MIMCSA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "LAYER_ID")
    public String getLayer_id() {
        return layer_id;
    }

    public void setLayer_id(String layer_id) {
        this.layer_id = layer_id;
    }

    @TREOrder(order = 2)
    @TREField(label = "NOMINAL_FRAME_RATE")
    public Double getNominal_frame_rate() {
        return nominal_frame_rate;
    }

    public void setNominal_frame_rate(Double nominal_frame_rate) {
        this.nominal_frame_rate = nominal_frame_rate;
    }

    @TREOrder(order = 3)
    @TREField(label = "MIN_FRAME_RATE")
    public Double getMin_frame_rate() {
        return min_frame_rate;
    }

    public void setMin_frame_rate(Double min_frame_rate) {
        this.min_frame_rate = min_frame_rate;
    }

    @TREOrder(order = 4)
    @TREField(label = "MAX_FRAME_RATE")
    public Double getMax_frame_rate() {
        return max_frame_rate;
    }

    public void setMax_frame_rate(Double max_frame_rate) {
        this.max_frame_rate = max_frame_rate;
    }

    @TREOrder(order = 5)
    @TREField(label = "T_RSET")
    public int getT_rset() {
        return t_rset;
    }

    public void setT_rset(int t_rset) {
        this.t_rset = t_rset;
    }

    @TREOrder(order = 6)
    @TREField(label = "MI_REQ_DECODER")
    public String getMi_req_decoder() {
        return mi_req_decoder;
    }

    public void setMi_req_decoder(String mi_req_decoder) {
        this.mi_req_decoder = mi_req_decoder;
    }

    @TREOrder(order = 7)
    @TREField(label = "MI_REQ_PROFILE")
    public String getMi_req_profile() {
        return mi_req_profile;
    }

    public void setMi_req_profile(String mi_req_profile) {
        this.mi_req_profile = mi_req_profile;
    }

    @TREOrder(order = 8)
    @TREField(label = "MI_REQ_LEVEL")
    public String getMi_req_level() {
        return mi_req_level;
    }

    public void setMi_req_level(String mi_req_level) {
        this.mi_req_level = mi_req_level;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
