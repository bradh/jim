package com.sigmabravo.rnd.jim.nitf.tre.camsda;

import com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;

/** CAMSDA TRE Parser. */
public class CAMSDAParser extends AbstractTREParser {

    private static final int NUM_CAMERA_SETS_LEN = 3;
    private static final int NUM_CAMERA_SETS_IN_TRE_LEN = 3;
    private static final int FIRST_CAMERA_SET_IN_TRE_LEN = 3;
    private static final int NUM_CAMERAS_IN_SET_LEN = 3;
    private static final int CAMERA_ID_LEN = UUID_LEN;
    private static final int CAMERA_DESC_LEN = 80;
    private static final int LAYER_ID_LEN = 36;
    private static final int IDLVL_LEN = 3;
    private static final int IALVL_LEN = 3;
    private static final int ILOC_ROW_LEN = 5;
    private static final int ILOC_COL_LEN = 5;
    private static final int NROWS_LEN = 8;
    private static final int NCOLS_LEN = 8;

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "CAMSDA";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        CAMSDA tre = new CAMSDA();
        int offset = 0;
        int num_camera_sets = readBCSN(bytes, offset, NUM_CAMERA_SETS_LEN);
        tre.setNumCameraSets(num_camera_sets);
        offset += NUM_CAMERA_SETS_LEN;
        int num_camera_sets_in_tre = readBCSN(bytes, offset, NUM_CAMERA_SETS_IN_TRE_LEN);
        offset += NUM_CAMERA_SETS_IN_TRE_LEN;
        offset += FIRST_CAMERA_SET_IN_TRE_LEN;
        for (int n = 0; n < num_camera_sets_in_tre; n++) {
            CameraSet cameraSet = new CameraSet();
            int num_cameras_in_set = readBCSN(bytes, offset, NUM_CAMERAS_IN_SET_LEN);
            offset += NUM_CAMERAS_IN_SET_LEN;
            for (int m = 0; m < num_cameras_in_set; m++) {
                Camera camera = new Camera();
                camera.setCamera_id(readUUIDAsString(bytes, offset));
                offset += CAMERA_ID_LEN;
                camera.setCamera_desc(readBCSA(bytes, offset, CAMERA_DESC_LEN));
                offset += CAMERA_DESC_LEN;
                camera.setLayer_id(readBCSA(bytes, offset, LAYER_ID_LEN));
                offset += LAYER_ID_LEN;
                camera.setIdlvl(readBCSNPI(bytes, offset, IDLVL_LEN));
                offset += IDLVL_LEN;
                camera.setIalvl(readBCSNPI(bytes, offset, IALVL_LEN));
                offset += IALVL_LEN;
                camera.setIloc_row(readBCSN(bytes, offset, ILOC_ROW_LEN));
                offset += ILOC_ROW_LEN;
                camera.setIloc_col(readBCSN(bytes, offset, ILOC_COL_LEN));
                offset += ILOC_COL_LEN;
                camera.setNrows(readBCSNPI(bytes, offset, NROWS_LEN));
                offset += NROWS_LEN;
                camera.setNcols(readBCSNPI(bytes, offset, NCOLS_LEN));
                offset += NCOLS_LEN;
                cameraSet.addCamera(camera);
            }
            tre.addCameraSet(cameraSet);
        }
        assert offset == bytes.length;
        return tre;
    }
}
