package net.frogmouth.rnd.jim.nitf.tre.soddxa;

import static net.frogmouth.rnd.jim.nitf.tre.soddxa.Constants.TRE_TAG;

import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

/** SODDXA TRE Parser. */
public class SODDXAParser extends AbstractTaggedRecordExtensionParser {

    @Override
    public String getTag() {
        return TRE_TAG;
    }

    @Override
    public SODDXA parse(String tag, byte[] bytes) {
        SODDXA tre = new SODDXA();
        tre.setData(new String(bytes, StandardCharsets.UTF_8));
        return tre;
    }
}
