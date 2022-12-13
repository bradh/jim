package net.frogmouth.rnd.jim.mie4nitf.tre.fsynwa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class FSYNWA extends TaggedRecordExtension {

    private static final String TRE_TAG = "FSYNWA";
    private int start_frame_number;
    private int end_frame_number;
    private final List<TaggedRecordExtension> tres = new ArrayList<>();

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
    public List<TaggedRecordExtension> getTres() {
        return new ArrayList<>(tres);
    }

    public void addTRE(TaggedRecordExtension tre) {
        tres.add(tre);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
