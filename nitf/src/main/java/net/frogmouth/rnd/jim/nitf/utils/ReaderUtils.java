package net.frogmouth.rnd.jim.nitf.utils;

import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.charsets.ECS_A;

public class ReaderUtils {

    public static final int DATE_TIME_LEN = 14;
    public static final int ENCRYP_LEN = 1;
    public static final int SECURITY_FIELDS_LEN = 167;

    public static int convertByteArrayToBCS_NPI(byte[] dest) {
        String s = new String(dest, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            // This shouldn't happen.
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static int convertByteArrayToBCS_NPI(byte[] dest, int offset, int len) {
        String s = new String(dest, offset, len, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            // This shouldn't happen.
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static double convertByteArrayToBCS_NPI_Double(byte[] bytes, int offset, int len) {
        return convertByteArrayToBCS_N_Double(bytes, offset, len);
    }

    public static double convertByteArrayToBCS_N_Double(byte[] bytes, int offset, int len) {
        String s = new String(bytes, offset, len, StandardCharsets.US_ASCII);
        if (s.isBlank()) {
            // This shouldn't happen.
            return 0;
        }
        if (s.startsWith("/")) {
            s = s.substring("/".length()).strip();
            return 1.0 / Integer.parseInt(s);
        }
        return Double.parseDouble(s);
    }

    public static String convertByteArrayToBCSA(byte[] bytes) {
        return new String(bytes, StandardCharsets.US_ASCII);
    }

    public static String convertByteArrayToBCSA(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, StandardCharsets.US_ASCII);
    }

    public static String convertByteArrayToECSA(byte[] bytes) {
        return new String(bytes, new ECS_A());
    }

    public static String convertByteArrayToECSA(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len, new ECS_A());
    }
}
