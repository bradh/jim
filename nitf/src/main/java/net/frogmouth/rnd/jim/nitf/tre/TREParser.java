package net.frogmouth.rnd.jim.nitf.tre;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** TaggedRecordExtension Parser. */
public class TREParser {

    private static final int TRETAG_LEN = 6;
    private static final int TREL_LEN = 5;

    public TREParser() {}

    public List<TaggedRecordExtension> parse(byte[] bytes) {
        List<TaggedRecordExtension> tres = new ArrayList<>();
        int offset = 0;
        while (offset < bytes.length) {
            String tag =
                    new String(
                            Arrays.copyOfRange(bytes, offset, offset + TRETAG_LEN),
                            StandardCharsets.US_ASCII);
            // System.out.println(tag);
            offset += TRETAG_LEN;
            byte[] lengthBytes = Arrays.copyOfRange(bytes, offset, offset + TREL_LEN);
            String lengthString = new String(lengthBytes, StandardCharsets.US_ASCII);
            int length = Integer.parseInt(lengthString);
            offset += TREL_LEN;
            AbstractTaggedRecordExtensionParser parser =
                    TREParserManager.getInstance().getParser(tag);
            if (parser != null) {
                TaggedRecordExtension tre =
                        parser.parse(tag, Arrays.copyOfRange(bytes, offset, offset + length));
                tres.add(tre);
            } else {
                System.out.println("No support for " + tag);
            }
            offset += length;
        }
        return tres;
    }
}
