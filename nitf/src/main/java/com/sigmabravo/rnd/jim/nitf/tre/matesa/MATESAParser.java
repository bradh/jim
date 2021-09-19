package com.sigmabravo.rnd.jim.nitf.tre.matesa;

import com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;

/** MATESA TRE Parser. */
public class MATESAParser extends AbstractTREParser {

    private static final int CUR_SOURCE_LEN = 42;
    private static final int CUR_MATE_TYPE_LEN = 16;
    private static final int CUR_FILE_ID_LEN_LEN = 4;
    private static final int NUM_GROUPS_LEN = 4;
    private static final int RELATIONSHIP_LEN = 24;
    private static final int NUM_MATES_LEN = 4;
    private static final int SOURCE_LEN = 42;
    private static final int MATE_TYPE_LEN = 16;
    private static final int MATE_ID_LEN_LEN = 4;

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "MATESA";
    }

    @Override
    public MATESA parse(String tag, byte[] bytes) {
        MATESA tre = new MATESA();
        int offset = 0;
        tre.setCur_source(readECSA(bytes, offset, CUR_SOURCE_LEN));
        offset += CUR_SOURCE_LEN;
        tre.setCur_mate_type(readECSA(bytes, offset, CUR_MATE_TYPE_LEN));
        offset += CUR_MATE_TYPE_LEN;
        int cur_file_id_len = readBCSNPI(bytes, offset, CUR_FILE_ID_LEN_LEN);
        offset += CUR_FILE_ID_LEN_LEN;
        tre.setCur_file_id(readECSA(bytes, offset, cur_file_id_len));
        offset += cur_file_id_len;
        int num_groups = readBCSNPI(bytes, offset, NUM_GROUPS_LEN);
        offset += NUM_GROUPS_LEN;
        for (int n = 0; n < num_groups; n++) {
            Group group = new Group();
            group.setRelationship(readECSA(bytes, offset, RELATIONSHIP_LEN));
            offset += RELATIONSHIP_LEN;
            int num_mates = readBCSNPI(bytes, offset, NUM_MATES_LEN);
            offset += NUM_MATES_LEN;
            for (int m = 0; m < num_mates; m++) {
                Mate mate = new Mate();
                mate.setSource(readECSA(bytes, offset, SOURCE_LEN));
                offset += SOURCE_LEN;
                mate.setMate_type(readECSA(bytes, offset, MATE_TYPE_LEN));
                offset += MATE_TYPE_LEN;
                int mate_id_len = readBCSNPI(bytes, offset, MATE_ID_LEN_LEN);
                offset += MATE_ID_LEN_LEN;
                mate.setMate_id(readECSA(bytes, offset, mate_id_len));
                offset += mate_id_len;
                group.addMate(mate);
            }
            tre.addGroup(group);
        }
        assert offset == bytes.length;
        return tre;
    }
}
