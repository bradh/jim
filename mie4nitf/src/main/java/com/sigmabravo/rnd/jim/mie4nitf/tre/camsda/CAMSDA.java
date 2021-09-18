package com.sigmabravo.rnd.jim.mie4nitf.tre.camsda;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREGroup;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;

/** CAMSDA TRE. */
public class CAMSDA extends TRE {

    private int numCameraSets;
    private final List<CameraSet> cameraSets = new ArrayList<>();

    public CAMSDA() {
        super("CAMSDA");
    }

    /**
     * This is the total number of Camera Sets in the collection.
     *
     * <p>It can be more than the number in this TRE instance.
     *
     * @return number of camera sets in collection.
     */
    @TREField(label = "NUM_CAMERA_SETS")
    @TREOrder(order = 1)
    public int getNumCameraSets() {
        return numCameraSets;
    }

    public void setNumCameraSets(int numCameraSets) {
        this.numCameraSets = numCameraSets;
    }

    @TREOrder(order = 2)
    @TREGroup()
    public List<CameraSet> getCameraSets() {
        return new ArrayList<>(cameraSets);
    }

    public void addCameraSet(CameraSet cameraSet) {
        cameraSets.add(cameraSet);
    }

    public String getTreeItemLabel() {
        return "CAMSDA";
    }
}
