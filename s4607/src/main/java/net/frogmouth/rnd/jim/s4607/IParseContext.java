package net.frogmouth.rnd.jim.s4607;

/**
 * Parsing context.
 *
 * <p>This is used to maintain state between parsing stages.
 */
public interface IParseContext {

    /**
     * Read a specified number of bytes.
     *
     * @param len the number of bytes to read.
     * @return byte array corresponding to the bytes read.
     */
    byte[] getBytes(int len);

    /**
     * Read a specified number of bytes as an ASCII string.
     *
     * <p>If there is an embedded null (0x00), the reading stops, and the remaining bytes are space
     * filled. This is to tolerate files that contain C-style strings.
     *
     * @param numBytes the number of bytes (or characters) to read.
     * @return String equivalent to the specified number of bytes
     */
    String readASCII(int numBytes);

    /**
     * Read a B16 encoded value from the parse context.
     *
     * <p>B16 is a 16 bit binary value.
     *
     * @return the decoded value
     */
    double readB16();

    /**
     * Read a B32 encoded value from the parse context.
     *
     * <p>B32 is a 32 bit binary value (1 bit sign, 8 bit integer + 23 bit fraction)
     *
     * @return the decoded value
     */
    double readB32();

    /**
     * Read a H32 encoded value from the parse context.
     *
     * <p>H32 is a 32 bit binary value (1 bit sign, 15 bit integer + 16 bit fraction). This is only
     * used for Doppler frequencies (hence "H" for Hertz).
     *
     * @return the decoded value
     */
    double readH32();

    /**
     * Read a BA16 encoded value from the parse context.
     *
     * <p>BA16 is a 16 bit binary angle value.
     *
     * @return the decoded binary angle value
     */
    double readBA16();

    /**
     * Read a BA32 encoded value from the parse context.
     *
     * <p>BA32 is a 32 bit binary angle value.
     *
     * @return the decoded binary angle value
     */
    double readBA32();

    /**
     * Read an enumerated 8 bit (E8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readE8();

    /**
     * Read a 16 bit flags (FL16) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readFL16();

    /**
     * Read a 64 bit flags (FL64) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    long readFL64();

    /**
     * Read an 8 bit flags (FL8) value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readFL8();

    /**
     * Read a 16 bit (I16) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readI16();

    /**
     * Read a 32 bit (S32) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    long readI32();

    /**
     * Read an 8 bit (I8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readI8();

    /**
     * Read a signed 16 bit (S16) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readS16();

    /**
     * Read a signed 32 bit (S32) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readS32();

    /**
     * Read a signed 8 bit (S8) encoded value from the parse context.
     *
     * @return the integer equivalent of the read value.
     */
    int readS8();

    /**
     * Read a SA16 encoded value from the parse context.
     *
     * <p>SA16 is a 16 bit binary signed angle value.
     *
     * @return the decoded value
     */
    double readSA16();

    /**
     * Read a SA32 encoded value from the parse context.
     *
     * <p>SA32 is a 32 bit binary signed angle value.
     *
     * @return the decoded value
     */
    double readSA32();

    /**
     * Get the current offset into the file.
     *
     * @return the current index position in bytes.
     */
    abstract long position();

    /**
     * Test if the parse context has any bytes remaining.
     *
     * @return true if there is any bytes remaining, otherwise false.
     */
    abstract boolean hasRemaining();

    /**
     * Skip over a specified number of bytes.
     *
     * <p>The intermediate bytes are ignored.
     *
     * @param bytesToSkip the number of bytes to skip over.
     */
    void skipBytes(long bytesToSkip);
}
