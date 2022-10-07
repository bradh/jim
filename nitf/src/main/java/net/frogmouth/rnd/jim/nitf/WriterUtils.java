package net.frogmouth.rnd.jim.nitf;

import java.nio.charset.StandardCharsets;

public class WriterUtils {
    public static byte[] toBCS_NPI(int value, int numCharacters) {
        String s = String.format("%0" + numCharacters + "d", value);
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length != numCharacters) {
            // TODO: throw
        }
        return bytes;
    }

    public static byte[] toBCS_A(String value, int numCharacters) {
        String s = String.format("%1$-" + numCharacters + "s", value);
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length != numCharacters) {
            // TODO: throw
        }
        return bytes;
    }

    public static byte[] toECS_A(String value, int numCharacters) {
        String s = String.format("%1$-" + numCharacters + "s", value);
        // TODO: proper ECS-A translation
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length != numCharacters) {
            // TODO: throw
        }
        return bytes;
    }
}
