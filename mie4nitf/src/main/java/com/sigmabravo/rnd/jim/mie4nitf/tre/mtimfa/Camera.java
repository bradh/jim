package com.sigmabravo.rnd.jim.mie4nitf.tre.mtimfa;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Camera extends TreePart {
    private UUID camera_id;
    private List<TemporalBlock> temporalBlocks = new ArrayList<>();

    @TREField(label = "CAMERA_ID")
    @TREOrder(order = 1)
    public UUID getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(UUID camera_id) {
        this.camera_id = camera_id;
    }

    @TREOrder(order = 2)
    @TREGroup()
    public List<TemporalBlock> getTemporalBlocks() {
        return new ArrayList<>(temporalBlocks);
    }

    public void addTemporalBlock(TemporalBlock temporalBlock) {
        temporalBlocks.add(temporalBlock);
    }

    @Override
    public String getTreeItemLabel() {
        return "Camera";
    }
}
