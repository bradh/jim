package net.frogmouth.rnd.jim.nitf.tre.engrda;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;
import net.frogmouth.rnd.jim.nitf.tre.TRE;

/** ENGRDA TRE Parser. */
public class ENGRDAParser extends AbstractTREParser {

    private static final int RESRC_LEN = 20;
    private static final int RECNT_LEN = 3;
    private static final int ENGLN_LEN = 2;
    private static final int ENGMTXC_LEN = 4;
    private static final int ENGMTXR_LEN = 4;
    private static final int ENGTYP_LEN = 1;
    private static final int ENGDTS_LEN = 1;
    private static final int ENGDATU_LEN = 2;
    private static final int ENGDATC_LEN = 8;

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "ENGRDA";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        ENGRDA tre = new ENGRDA();
        int offset = 0;
        tre.setResrc(readBCSA(bytes, offset, RESRC_LEN));
        offset += RESRC_LEN;
        int recnt = readBCSNPI(bytes, offset, RECNT_LEN);
        offset += RECNT_LEN;
        for (int n = 0; n < recnt; n++) {
            Record record = new Record();
            int engln = readBCSNPI(bytes, offset, ENGLN_LEN);
            record.setEngln(engln);
            offset += ENGLN_LEN;
            record.setEnglbl(readBCSA(bytes, offset, engln));
            offset += engln;
            record.setEngmtxc(readBCSNPI(bytes, offset, ENGMTXC_LEN));
            offset += ENGMTXC_LEN;
            record.setEngmtxr(readBCSNPI(bytes, offset, ENGMTXR_LEN));
            offset += ENGMTXR_LEN;
            String engtyp = readBCSA(bytes, offset, ENGTYP_LEN);
            record.setEngtyp(engtyp);
            offset += ENGTYP_LEN;
            int engdts = readBCSNPI(bytes, offset, ENGDTS_LEN);
            record.setEngdts(engdts);
            offset += ENGDTS_LEN;
            record.setEngdatu(readBCSA(bytes, offset, ENGDATU_LEN));
            offset += ENGDATU_LEN;
            int engdatc = readBCSNPI(bytes, offset, ENGDATC_LEN);
            record.setEngdatc(engdatc);
            offset += ENGDATC_LEN;
            // TODO: handle ENGDATA
            if (engtyp.equals("A")) {
                AlphaNumericEngData engdata = new AlphaNumericEngData();
                String s = readBCSA(bytes, offset, engdatc);
                engdata.setData(s);
                record.setEngdata(engdata);
                offset += engdatc;
            } else {
                System.out.println("Unsupported type, skipping data:" + engtyp);
                offset += engdatc * engdts;
            }
            tre.addRecord(record);
        }
        assert offset == bytes.length;
        return tre;
    }
}
