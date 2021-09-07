package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

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
    public int getNumCameraSets() {
        return numCameraSets;
    }

    public void setNumCameraSets(int numCameraSets) {
        this.numCameraSets = numCameraSets;
    }

    public List<CameraSet> getCameraSets() {
        return new ArrayList<>(cameraSets);
    }

    public void addCameraSet(CameraSet cameraSet) {
        cameraSets.add(cameraSet);
    }

    @Override
    public TreeItem<String> toTreeItem() {
        TreeItem<String> treeItem = new TreeItem<>();
        treeItem.setValue("CAMSDA");
        treeItem.getChildren()
                .add(new TreeItem<String>("Number of camera sets (total): " + this.numCameraSets));
        for (CameraSet cameraSet : getCameraSets()) {
            treeItem.getChildren().add(cameraSet.toTreeItem());
        }
        return treeItem;
    }
}
