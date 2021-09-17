package com.sigmabravo.rnd.jim.nitf.tre.fsynwa;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;

public class FSYNWA extends TRE {

    private static final String TRE_TAG = "FSYNWA";
    private int start_frame_number;
    private int end_frame_number;
    private final List<TRE> tres = new ArrayList<>();

    public FSYNWA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "START_FRAME_NUMBER")
    public int getStart_frame_number() {
        return start_frame_number;
    }

    public void setStart_frame_number(int start_frame_number) {
        this.start_frame_number = start_frame_number;
    }

    @TREOrder(order = 2)
    @TREField(label = "END_FRAME_NUMBER")
    public int getEnd_frame_number() {
        return end_frame_number;
    }

    public void setEnd_frame_number(int end_frame_number) {
        this.end_frame_number = end_frame_number;
    }

    @TREOrder(order = 3)
    @TREGroup()
    public List<TRE> getTres() {
        return new ArrayList<>(tres);
    }

    public void addTRE(TRE tre) {
        tres.add(tre);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
