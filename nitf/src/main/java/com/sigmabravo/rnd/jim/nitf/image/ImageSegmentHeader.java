package com.sigmabravo.rnd.jim.nitf.image;

import com.sigmabravo.rnd.jim.nitf.utils.ReaderUtils;

public class ImageSegmentHeader {

    private final int IM_OFFSET = 0;
    private final int IM_LEN = 2;
    private final int IID1_OFFSET = IM_OFFSET + IM_LEN;
    private final int IID1_LEN = 10;
    private final int IDATIM_OFFSET = IID1_OFFSET + IID1_LEN;
    private final int TGTID_OFFSET = IDATIM_OFFSET + ReaderUtils.DATE_TIME_LEN;
    private final int TGTID_LEN = 17;
    private final int IID2_OFFSET = TGTID_OFFSET + TGTID_LEN;
    private final int IID2_LEN = 80;
    private final int IMAGE_SECURITY_FIELDS_OFFSET = IID2_OFFSET + IID2_LEN;
    private final int ENCRYP_OFFSET =
            IMAGE_SECURITY_FIELDS_OFFSET + ReaderUtils.SECURITY_FIELDS_LEN;
    private final int ISORCE_OFFSET = ENCRYP_OFFSET + ReaderUtils.ENCRYP_LEN;
    private final int ISORCE_LEN = 42;
    // TODO: NROWS onwards

    private String iid1;
    private String imageDateTime;
    private String tgtid;
    private String iid2;
    private String isource;

    public ImageSegmentHeader(byte[] subheaderBytes) {
        String im = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, IM_OFFSET, IM_LEN);
        assert im.equals("IM");
        iid1 = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, IID1_OFFSET, IID1_LEN);
        imageDateTime = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, IID1_OFFSET, IID1_LEN);
        tgtid = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, TGTID_OFFSET, TGTID_LEN);
        iid2 = ReaderUtils.convertByteArrayToECSA(subheaderBytes, IID2_OFFSET, IID2_LEN);
        isource = ReaderUtils.convertByteArrayToECSA(subheaderBytes, ISORCE_OFFSET, ISORCE_LEN);
    }

    public String getIid1() {
        return iid1;
    }

    public String getImageDateTime() {
        return imageDateTime;
    }

    public String getTgtid() {
        return tgtid;
    }

    public String getIid2() {
        return iid2;
    }

    public String getIsource() {
        return isource;
    }
}
