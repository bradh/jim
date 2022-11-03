package net.frogmouth.rnd.jim.charsets;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Extended Character Set - Alphanumeric (ECS-A) character set.
 *
 * <p>This implements the {@link Charset} interface for the ECS-A encoding specified in STANAG 4607
 * (GMTI) and the Joint BIIF Profile (JBP, also known as National Imagery Transfer File Standard,
 * NITF, STANAG 4545, NATO Secondary Imagery Format and NSIF).
 */
public class ECS_A extends Charset {

    /** Constructor. */
    public ECS_A() {
        this("ECS-A", null);
    }

    /**
     * Constructor
     *
     * @param canonicalName the canonical name for this encoding.
     * @param aliases any aliases for this encoding.
     */
    protected ECS_A(String canonicalName, String[] aliases) {
        super(canonicalName, aliases);
    }

    @Override
    public boolean contains(Charset chrst) {
        // TODO: we can do better
        return false;
    }

    @Override
    public CharsetDecoder newDecoder() {
        return new ECS_A_CharsetDecoder(this);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return new ECS_A_CharsetEncoder(this);
    }
}
