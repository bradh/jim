package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;
import java.util.ArrayList;
import java.util.List;

/** Camera Set, part of CAMSDA. */
public class CameraSet extends TreePart {
    private final List<Camera> cameras = new ArrayList<>();

    @TREOrder(order = 1)
    @TREGroup()
    public List<Camera> getCameras() {
        return new ArrayList<>(cameras);
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    @Override
    public String getTreeItemLabel() {
        return "Camera Set";
    }
}
