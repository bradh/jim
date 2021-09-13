package com.sigmabravo.rnd.jim.nitf.tre.mtimfa;

import com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;

/** MTIMFA TRE Parser. */
public class MTIMFAParser extends AbstractTREParser {

    private static final int LAYER_ID_LEN = 36;
    private static final int CAMERA_SET_INDEX_LEN = 3;
    // TODO: rest of code

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
        return tre;
    }
}
