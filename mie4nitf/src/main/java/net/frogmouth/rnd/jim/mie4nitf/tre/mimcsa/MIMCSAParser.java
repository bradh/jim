package net.frogmouth.rnd.jim.mie4nitf.tre.mimcsa;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/** MIMCSA TRE Parser. */
public class MIMCSAParser extends AbstractTaggedRecordExtensionParser {

    private static final int LAYER_ID_LEN = 36;
    private static final int T_RSET_LEN = 2;
    private static final int MI_REQ_DECODER_LEN = 2;
    private static final int MI_REQ_PROFILE_LEN = 36;
    private static final int MI_REQ_LEVEL_LEN = 6;

    @Override
    public String getTag() {
        return "MIMCSA";
    }

    @Override
    public TaggedRecordExtension parse(String tag, byte[] bytes) {
        MIMCSA tre = new MIMCSA();
        int offset = 0;
        tre.setLayer_id(readBCSA(bytes, offset, LAYER_ID_LEN));
        offset += LAYER_ID_LEN;
        tre.setNominal_frame_rate(readUE13(bytes, offset));
        offset += UE13_LEN;
        tre.setMin_frame_rate(readUE13(bytes, offset));
        offset += UE13_LEN;
        tre.setMax_frame_rate(readUE13(bytes, offset));
        offset += UE13_LEN;
        tre.setT_rset(readBCSNPI(bytes, offset, T_RSET_LEN));
        offset += T_RSET_LEN;
        tre.setMi_req_decoder(readBCSA(bytes, offset, MI_REQ_DECODER_LEN));
        offset += MI_REQ_DECODER_LEN;
        tre.setMi_req_profile(readBCSA(bytes, offset, MI_REQ_PROFILE_LEN));
        offset += MI_REQ_PROFILE_LEN;
        tre.setMi_req_level(readBCSA(bytes, offset, MI_REQ_LEVEL_LEN));
        return tre;
    }
}
