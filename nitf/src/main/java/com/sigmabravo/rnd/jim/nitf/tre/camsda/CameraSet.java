package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

/** Camera Set, part of CAMSDA. */
public class CameraSet {
    private final List<Camera> cameras = new ArrayList<>();

    public List<Camera> getCameras() {
        return new ArrayList<>(cameras);
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    public String getTreeItemLabel() {
        return "Camera Set";
    }

    public TreeItem<String> toTreeItem() {
        TreeItem<String> treeItem = new TreeItem<>(getTreeItemLabel());
        for (Camera camera : getCameras()) {
            treeItem.getChildren().add(camera.toTreeItem());
        }
        return treeItem;
    }
}
