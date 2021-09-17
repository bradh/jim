package com.sigmabravo.rnd.jim.nitf.tre.mtimfa;

import com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;

/** MTIMFA TRE Parser. */
public class MTIMFAParser extends AbstractTREParser {

    private static final int LAYER_ID_LEN = 36;
    private static final int CAMERA_SET_INDEX_LEN = 3;
    private static final int TIME_INTERVAL_INDEX_LEN = 6;
    private static final int NUM_CAMERAS_DEFINED_LEN = 3;
    private static final int NUM_TEMP_BLOCKS_LEN = 3;
    private static final int IMAGE_SEG_INDEX_LEN = 3;
    public static final int IMAGE_SEG_INDEX_UNUSED = -1;

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "MTIMFA";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        MTIMFA tre = new MTIMFA();
        int offset = 0;
        tre.setLayer_id(readBCSA(bytes, offset, LAYER_ID_LEN));
        offset += LAYER_ID_LEN;
        tre.setCamera_set_index(readBCSNPI(bytes, offset, CAMERA_SET_INDEX_LEN));
        offset += CAMERA_SET_INDEX_LEN;
        tre.setTime_interval_index(readBCSNPI(bytes, offset, TIME_INTERVAL_INDEX_LEN));
        offset += TIME_INTERVAL_INDEX_LEN;
        int num_cameras_defined = readBCSNPI(bytes, offset, NUM_CAMERAS_DEFINED_LEN);
        offset += NUM_CAMERAS_DEFINED_LEN;
        for (int n = 0; n < num_cameras_defined; n++) {
            Camera camera = new Camera();
            camera.setCamera_id(readUUIDAsString(bytes, offset));
            offset += UUID_LEN;
            int num_temp_blocks = readBCSNPI(bytes, offset, NUM_TEMP_BLOCKS_LEN);
            offset += NUM_TEMP_BLOCKS_LEN;
            for (int m = 0; m < num_temp_blocks; m++) {
                TemporalBlock temporalBlock = new TemporalBlock();
                temporalBlock.setStart_timestamp(readTimeStampAsString(bytes, offset));
                offset += TIMESTAMP_LEN;
                temporalBlock.setEnd_timestamp(readTimeStampAsString(bytes, offset));
                offset += TIMESTAMP_LEN;
                String imageSegIndexAsString = readBCSA(bytes, offset, IMAGE_SEG_INDEX_LEN);

                if (imageSegIndexAsString.trim().length() == 0) {
                    temporalBlock.setImage_seg_index(IMAGE_SEG_INDEX_UNUSED);
                } else {
                    temporalBlock.setImage_seg_index(
                            readBCSNPI(bytes, offset, IMAGE_SEG_INDEX_LEN));
                }
                offset += IMAGE_SEG_INDEX_LEN;

                camera.addTemporalBlock(temporalBlock);
            }
            tre.addCamera(camera);
        }
        return tre;
    }
}
