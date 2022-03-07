package net.frogmouth.rnd.jim.s4607;

import java.nio.ByteBuffer;

/**
 * Parsing context.
 *
 * <p>This is used to provide state between parsing stages.
 *
 * <p>Concrete implementations of this class need to set the {@code buffer} appropriately.
 */
public abstract class AbstractByteBufferParseContext extends AbstractParseContext {

    /**
     * The buffer to read from.
     *
     * <p>Implementations must set this prior to parsing.
     */
    protected ByteBuffer buffer;

    @Override
    public boolean hasRemaining() {
        return buffer.hasRemaining();
    }

    @Override
    public long position() {
        return buffer.position();
    }

    @Override
    void get(byte[] dest) {
        buffer.get(dest);
    }

    @Override
    byte get() {
        return buffer.get();
    }

    @Override
    int getShort() {
        return buffer.getShort();
    }

    @Override
    int getInt() {
        return buffer.getInt();
    }

    @Override
    long getLong() {
        return buffer.getLong();
    }

    @Override
    public void skipBytes(long bytesToSkip) {
        long currentPosition = buffer.position();
        buffer.position((int) (currentPosition + bytesToSkip));
    }
}
