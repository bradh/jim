package net.frogmouth.rnd.jim.charsets;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/** Character set encoder for ECS-A. */
public class ECS_A_CharsetDecoder extends CharsetDecoder {

    /**
     * Constructor.
     *
     * @param cs the character set.
     */
    public ECS_A_CharsetDecoder(Charset cs) {
        super(cs, 1.0f, 1.0f);
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer src, CharBuffer dst) {
        int mark = src.position();
        try {
            while (src.hasRemaining()) {
                byte b = src.get();
                if (!dst.hasRemaining()) return CoderResult.OVERFLOW;
                dst.put((char) (b & 0xff));
                mark++;
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(mark);
        }
    }
}
