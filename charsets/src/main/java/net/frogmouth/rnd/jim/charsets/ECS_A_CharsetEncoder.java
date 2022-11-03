package net.frogmouth.rnd.jim.charsets;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/** Character set encoder for ECS-A. */
public class ECS_A_CharsetEncoder extends CharsetEncoder {
    /**
     * Constructor.
     *
     * @param cs the character set.
     */
    public ECS_A_CharsetEncoder(Charset cs) {
        super(cs, 1.0f, 1.0f);
    }

    @Override
    public CoderResult encodeLoop(CharBuffer src, ByteBuffer dst) {
        int mark = src.position();
        try {
            while (src.hasRemaining()) {
                char c = src.get();
                if (c <= 0xff) {
                    if (!dst.hasRemaining()) {
                        return CoderResult.OVERFLOW;
                    }
                    dst.put((byte) c);
                    mark++;
                    continue;
                }
                return CoderResult.unmappableForLength(1);
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(mark);
        }
    }
}
