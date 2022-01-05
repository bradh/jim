package net.frogmouth.rnd.jim.s4607;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SerialisationContext {
    private static final byte SPACE = 0x20;
    private boolean useSAProfileForEmptyDwellTargetMask;

    public boolean isUseSAProfileForEmptyDwellTargetMask() {
        return useSAProfileForEmptyDwellTargetMask;
    }

    public void setUseSAProfileForEmptyDwellTargetMask(
            boolean useSAProfileForEmptyDwellTargetMask) {
        this.useSAProfileForEmptyDwellTargetMask = useSAProfileForEmptyDwellTargetMask;
    }

    public byte[] padString(String s, int length) {
        byte[] stringBytes = s.trim().getBytes(StandardCharsets.US_ASCII);
        // TODO: check length
        byte[] stringBytesPadded = new byte[length];
        Arrays.fill(stringBytesPadded, SPACE);
        System.arraycopy(stringBytes, 0, stringBytesPadded, 0, stringBytes.length);
        return stringBytesPadded;
    }
}
