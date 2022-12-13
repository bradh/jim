package net.frogmouth.rnd.jim.ccinfa.tre;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/** CCINFA TRE Parser. */
public class CCINFAParser extends AbstractTaggedRecordExtensionParser {

    private static final int NUM_CODE_LEN = 3;
    private static final int CODE_LEN = 1;
    private static final int EQTYPE_LEN = 1;
    private static final int ESURN_LEN_LEN = 2;
    private static final int DETAIL_LEN_LEN = 5;
    private static final int DETAIL_CMPR_LEN = 1;

    @Override
    public String getTag() {
        return "CCINFA";
    }

    @Override
    public TaggedRecordExtension parse(String tag, byte[] bytes) {
        CCINFA tre = new CCINFA();
        int offset = 0;
        int numcode = readBCSNPI(bytes, offset, NUM_CODE_LEN);
        offset += NUM_CODE_LEN;
        for (int n = 0; n < numcode; n++) {
            Code code = new Code();
            int code_len = readBCSNPI(bytes, offset, CODE_LEN);
            offset += CODE_LEN;
            code.setCode(readBCSA(bytes, offset, code_len));
            offset += code_len;
            code.setEqtype(readBCSA(bytes, offset, EQTYPE_LEN));
            offset += EQTYPE_LEN;
            int esurn_len = readBCSNPI(bytes, offset, ESURN_LEN_LEN);
            offset += ESURN_LEN_LEN;
            code.setEsurn(readBCSA(bytes, offset, esurn_len));
            offset += esurn_len;
            int detail_len = readBCSNPI(bytes, offset, DETAIL_LEN_LEN);
            offset += DETAIL_LEN_LEN;
            if (detail_len > 0) {
                String detail_compr = readBCSA(bytes, offset, DETAIL_CMPR_LEN);
                if (detail_compr.equals("G")) {
                    // TODO: read as bytes and decompress
                } else {
                    code.setDetail(readUTF8(bytes, offset, detail_len));
                }
            }
            tre.addCode(code);
        }
        assert offset == bytes.length;
        return tre;
    }
}
