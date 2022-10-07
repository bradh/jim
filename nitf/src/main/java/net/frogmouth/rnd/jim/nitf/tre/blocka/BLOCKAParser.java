package net.frogmouth.rnd.jim.nitf.tre.blocka;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/** BLOCKA TaggedRecordExtension Parser. */
public class BLOCKAParser extends AbstractTaggedRecordExtensionParser {

    private static final int BLOCK_INSTANCE_LEN = 2;
    private static final int N_GRAY_LEN = 5;
    private static final int L_LINES_LEN = 5;
    private static final int LAYOVER_ANGLE_LEN = 3;
    private static final int SHADOW_ANGLE_LEN = 3;
    private static final int RESERVED_001_LEN = 16;
    private static final int FRLC_LOC_LEN = 21;
    private static final int LRLC_LOC_LEN = 21;
    private static final int LRFC_LOC_LEN = 21;
    private static final int FRFC_LOC_LEN = 21;
    private static final int RESERVED_002_LEN = 5;

    @Override
    public String getTag() {
        return "BLOCKA";
    }

    @Override
    public TaggedRecordExtension parse(String tag, byte[] bytes) {
        BLOCKA tre = new BLOCKA();
        int offset = 0;
        tre.setBlock_instance(readBCSNPI(bytes, offset, BLOCK_INSTANCE_LEN));
        offset += BLOCK_INSTANCE_LEN;
        tre.setN_gray(readBCSNPI(bytes, offset, N_GRAY_LEN));
        offset += N_GRAY_LEN;
        tre.setL_lines(readBCSNPI(bytes, offset, L_LINES_LEN));
        offset += L_LINES_LEN;
        tre.setLayover_angle(readBCSA(bytes, offset, LAYOVER_ANGLE_LEN));
        offset += LAYOVER_ANGLE_LEN;
        tre.setShadow_angle(readBCSA(bytes, offset, SHADOW_ANGLE_LEN));
        offset += SHADOW_ANGLE_LEN;
        offset += RESERVED_001_LEN;
        tre.setFrlc_loc(readBCSA(bytes, offset, FRLC_LOC_LEN));
        offset += FRLC_LOC_LEN;
        tre.setLrlc_loc(readBCSA(bytes, offset, LRLC_LOC_LEN));
        offset += LRLC_LOC_LEN;
        tre.setLrfc_loc(readBCSA(bytes, offset, LRFC_LOC_LEN));
        offset += LRFC_LOC_LEN;
        tre.setFrfc_loc(readBCSA(bytes, offset, FRFC_LOC_LEN));
        offset += FRFC_LOC_LEN;
        offset += RESERVED_002_LEN;
        assert offset == bytes.length;
        return tre;
    }
}
