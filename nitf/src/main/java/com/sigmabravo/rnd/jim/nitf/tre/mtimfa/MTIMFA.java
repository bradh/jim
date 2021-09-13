package com.sigmabravo.rnd.jim.nitf.tre.mtimfa;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;

public class MTIMFA extends TRE {

    private static final String TRE_TAG = "MTIMFA";

    private String layer_id;
    private int camera_set_index;

    public MTIMFA() {
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
    @TREField(label = "CAMERA_SET_INDEX")
    public int getCamera_set_index() {
        return camera_set_index;
    }

    public void setCamera_set_index(int camera_set_index) {
        this.camera_set_index = camera_set_index;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
