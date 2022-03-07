package net.frogmouth.rnd.jim.s4607;

import java.nio.ByteBuffer;

/**
 * Byte array backed parsing context.
 *
 * <p>This is used to provide state between parsing stages, implemented in terms of an in-memory
 * byte array.
 */
public class ByteArrayParseContext extends AbstractByteBufferParseContext {

    /**
     * Constructor.
     *
     * @param bytes the byte array to parse from.
     */
    public ByteArrayParseContext(byte[] bytes) {
        this.buffer = ByteBuffer.wrap(bytes);
    }
}
