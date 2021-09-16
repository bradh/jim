package com.sigmabravo.rnd.jim.nitf.tre.mtimfa;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;

public class TemporalBlock extends TreePart {
    private String start_timestamp;
    private String end_timestamp;
    private int image_seg_index;

    @TREField(label = "START_TIMESTAMP")
    @TREOrder(order = 1)
    public String getStart_timestamp() {
        return start_timestamp;
    }

    public void setStart_timestamp(String start_timestamp) {
        this.start_timestamp = start_timestamp;
    }

    @TREField(label = "END_TIMESTAMP")
    @TREOrder(order = 2)
    public String getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(String end_timestamp) {
        this.end_timestamp = end_timestamp;
    }

    @TREField(label = "IMAGE_SEG_INDEX")
    @TREOrder(order = 3)
    public int getImage_seg_index() {
        return image_seg_index;
    }

    public void setImage_seg_index(int image_seg_index) {
        this.image_seg_index = image_seg_index;
    }

    @Override
    public String getTreeItemLabel() {
        return "Temporal Block";
    }
}
