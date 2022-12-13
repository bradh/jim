package net.frogmouth.rnd.jim.mie4nitf.tre.fsynwa;

import net.frogmouth.rnd.jim.nitf.tre.TREParserManager;
import java.util.Arrays;
import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/** FSYNWA TRE Parser. */
public class FSYNWAParser extends AbstractTaggedRecordExtensionParser {

    private static final int START_FRAME_NUMBER_LEN = 9;
    private static final int END_FRAME_NUMBER_LEN = 9;

    @Override
    public String getTag() {
        return "FSYNWA";
    }

    @Override
    public TaggedRecordExtension parse(String tag, byte[] bytes) {
        FSYNWA tre = new FSYNWA();
        int offset = 0;
        tre.setStart_frame_number(readBCSNPI(bytes, offset, START_FRAME_NUMBER_LEN));
        offset += START_FRAME_NUMBER_LEN;
        tre.setStart_frame_number(readBCSNPI(bytes, offset, END_FRAME_NUMBER_LEN));
        offset += END_FRAME_NUMBER_LEN;
        while (offset < bytes.length) {
            String cetag = readBCSA(bytes, offset, CETAG_LEN);
            offset += CETAG_LEN;
            int cel = readBCSNPI(bytes, offset, CEL_LEN);
            offset += CEL_LEN;
            byte[] bytesForNestedTRE = Arrays.copyOfRange(bytes, offset, offset + cel);
            AbstractTaggedRecordExtensionParser subParser = TREParserManager.getInstance().getParser(cetag);
            if (subParser == null) {
                System.out.println("Need to implement " + cetag);
            } else {
                tre.addTRE(subParser.parse(cetag, bytesForNestedTRE));
            }
            offset += cel;
        }

        return tre;
    }
}
