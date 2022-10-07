package net.frogmouth.rnd.jim.nitf;

import java.util.Arrays;

public class SecurityMetadata {

    private static final byte SPACE_FILL = (byte) 0x20;

    public byte[] asBytes() {
        // TODO: build properly
        byte[] bytes = new byte[167];
        Arrays.fill(bytes, SPACE_FILL);
        bytes[0] = 0x55; // U
        return bytes;
    }
}
