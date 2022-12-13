package net.frogmouth.rnd.jim.mie4nitf.tre.mtimfa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class MTIMFA extends TaggedRecordExtension {

    private static final String TRE_TAG = "MTIMFA";

    private String layer_id;
    private int camera_set_index;
    private int time_interval_index;
    private List<Camera> cameras = new ArrayList<>();

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

    /**
     * Get the camera set index.
     * 
     * <p>This corresponds to CAMERA_SET_INDEX in the TRE definition.
     * @return camera set index as an integer value.
     */
    @TREOrder(order = 2)
    @TREField(label = "CAMERA_SET_INDEX")
    public int getCamera_set_index() {
        return camera_set_index;
    }

    /**
     * Set the camera set index.
     * 
     * <p>This corresponds to CAMERA_SET_INDEX in the TRE definition.
     * @param camera_set_index camera set index as an integer value.
     */
    public void setCamera_set_index(int camera_set_index) {
        this.camera_set_index = camera_set_index;
    }

    @TREOrder(order = 3)
    @TREField(label = "TIME_INTERVAL_INDEX")
    public int getTime_interval_index() {
        return time_interval_index;
    }

    public void setTime_interval_index(int time_interval_index) {
        this.time_interval_index = time_interval_index;
    }

    @TREOrder(order = 4)
    @TREGroup()
    public List<Camera> getCameras() {
        return new ArrayList<>(cameras);
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
