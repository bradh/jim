package net.frogmouth.rnd.jim.nitf;

import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.charsets.ECS_A;

public class WriterUtils {
    public static byte[] toBCS_NPI(int value, int numCharacters) {
        String s = String.format("%0" + numCharacters + "d", value);
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length != numCharacters) {
            // TODO: throw
        }
        return bytes;
    }

    public static byte[] toBCS_NPI(double value, int numCharacters) {
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
        byte[] bytes = s.getBytes(new ECS_A());
        if (bytes.length != numCharacters) {
            // TODO: throw
        }
        return bytes;
    }

    public static byte[] toBCS_N(int value, int numCharacters) {
        // TODO: check works for negative values
        String s = String.format("%0" + numCharacters + "d", value);
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length != numCharacters) {
            // TODO: throw
        }
        return bytes;
    }
}
