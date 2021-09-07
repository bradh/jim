package com.sigmabravo.rnd.jim.nitf.tre;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** TRE Parser. */
public class TREParser {

    private static final int TRETAG_LEN = 6;
    private static final int TREL_LEN = 5;

    public TREParser() {}

    public List<TRE> parse(byte[] bytes) {
        List<TRE> tres = new ArrayList<>();
        int offset = 0;
        while (offset < bytes.length) {
            String tag =
                    new String(
                            Arrays.copyOfRange(bytes, offset, offset + TRETAG_LEN),
                            StandardCharsets.US_ASCII);
            System.out.println(tag);
            offset += TRETAG_LEN;
            byte[] lengthBytes = Arrays.copyOfRange(bytes, offset, offset + TREL_LEN);
            String lengthString = new String(lengthBytes, StandardCharsets.US_ASCII);
            int length = Integer.parseInt(lengthString);
            offset += TREL_LEN;
            ITREParser parser = TREParserManager.getInstance().getParser(tag);
            if (parser != null) {
                TRE tre = parser.parse(tag, Arrays.copyOfRange(bytes, offset, offset + length));
                tres.add(tre);
            }
            offset += length;
        }
        return tres;
    }
}
