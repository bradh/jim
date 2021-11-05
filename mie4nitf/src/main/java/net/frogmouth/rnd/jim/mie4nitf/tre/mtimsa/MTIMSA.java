package net.frogmouth.rnd.jim.mie4nitf.tre.mtimsa;

import net.frogmouth.rnd.jim.nitf.tre.TRE;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MTIMSA extends TRE {

    private static final String TRE_TAG = "MTIMSA";

    private int image_seg_index;
    private int geocoords_static;
    private String layer_id;
    private int camera_set_index;
    private UUID camera_id;
    private int time_interval_index;
    private int temp_block_index;
    private double nominal_frame_rate;
    private String reference_frame_number;
    private String base_timestamp;
    private long dt_multiplier;
    private long number_frames;
    private final List<DeltaTime> dts = new ArrayList<>();

    public MTIMSA() {
        super(TRE_TAG);
    }

    @TREField(label = "IMAGE_SEG_INDEX")
    @TREOrder(order = 1)
    public int getImage_seg_index() {
        return image_seg_index;
    }

    public void setImage_seg_index(int image_seg_index) {
        this.image_seg_index = image_seg_index;
    }

    @TREField(label = "GEOCOORDS_STATIC")
    @TREOrder(order = 2)
    public int getGeocoords_static() {
        return geocoords_static;
    }

    public void setGeocoords_static(int geocoords_static) {
        this.geocoords_static = geocoords_static;
    }

    @TREField(label = "LAYER_ID")
    @TREOrder(order = 3)
    public String getLayer_id() {
        return layer_id;
    }

    public void setLayer_id(String layer_id) {
        this.layer_id = layer_id;
    }

    @TREField(label = "CAMERA_SET_INDEX")
    @TREOrder(order = 4)
    public int getCamera_set_index() {
        return camera_set_index;
    }

    public void setCamera_set_index(int camera_set_index) {
        this.camera_set_index = camera_set_index;
    }

    @TREField(label = "CAMERA_ID")
    @TREOrder(order = 5)
    public UUID getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(UUID camera_id) {
        this.camera_id = camera_id;
    }

    @TREField(label = "TIME_INTERVAL_INDEX")
    @TREOrder(order = 6)
    public int getTime_interval_index() {
        return time_interval_index;
    }

    public void setTime_interval_index(int time_interval_index) {
        this.time_interval_index = time_interval_index;
    }

    @TREField(label = "TEMP_BLOCK_INDEX")
    @TREOrder(order = 7)
    public int getTemp_block_index() {
        return temp_block_index;
    }

    public void setTemp_block_index(int temp_block_index) {
        this.temp_block_index = temp_block_index;
    }

    @TREField(label = "NOMINAL_FRAME_RATE")
    @TREOrder(order = 8)
    public double getNominal_frame_rate() {
        return nominal_frame_rate;
    }

    public void setNominal_frame_rate(double nominal_frame_rate) {
        this.nominal_frame_rate = nominal_frame_rate;
    }

    @TREField(label = "REFERENCE_FRAME_NUM")
    @TREOrder(order = 9)
    public String getReference_frame_number() {
        return reference_frame_number;
    }

    public void setReference_frame_number(String reference_frame_number) {
        this.reference_frame_number = reference_frame_number;
    }

    @TREField(label = "BASE_TIMESTAMP")
    @TREOrder(order = 10)
    public String getBase_timestamp() {
        return base_timestamp;
    }

    public void setBase_timestamp(String base_timestamp) {
        this.base_timestamp = base_timestamp;
    }

    @TREField(label = "DT_MULTIPLIER")
    @TREOrder(order = 11)
    public long getDt_multiplier() {
        return dt_multiplier;
    }

    public void setDt_multiplier(long dt_multiplier) {
        this.dt_multiplier = dt_multiplier;
    }

    @TREField(label = "NUMBER_FRAMES")
    @TREOrder(order = 12)
    public long getNumber_frames() {
        return number_frames;
    }

    public void setNumber_frames(long number_frames) {
        this.number_frames = number_frames;
    }

    @TREOrder(order = 13)
    @TREGroup()
    public List<DeltaTime> getDts() {
        return new ArrayList<>(dts);
    }

    public void addDt(DeltaTime dt) {
        dts.add(dt);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
