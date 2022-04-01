package net.frogmouth.rnd.jim.s4607.hrr;

/**
 * Existence Mask for HRR Segment fields.
 *
 * <p>The Existence Mask, the first field of the HRR Segment, is an encoded five-byte field that
 * immediately follows the Segment Header fields and precedes all other HRR Segment fields. Each
 * field of the HRR Segment, with the exception of the Existence Mask itself, is represented by a
 * reserved bit within the Existence Mask. Each bit of the Existence Mask indicates whether or not
 * the corresponding field of the HRR Segment is present in the data stream. The most-significant
 * bit (bit 7) of the high- order byte (byte 4) corresponds to the first field (H2) following the
 * Existence Mask of the HRR Segment, where the high-order byte shall be transmitted first.
 */
class ExistenceMask {

    private final long mask;
    static final long H2_EXISTENCE = 0x8000000000L;
    static final long H3_EXISTENCE = 0x4000000000L;
    static final long H4_EXISTENCE = 0x2000000000L;
    static final long H5_EXISTENCE = 0x1000000000L;
    static final long H6_EXISTENCE = 0x0800000000L;
    static final long H7_EXISTENCE = 0x0400000000L;
    static final long H8_EXISTENCE = 0x0200000000L;
    static final long H9_EXISTENCE = 0x0100000000L;
    static final long H10_EXISTENCE = 0x0080000000L;
    static final long H11_EXISTENCE = 0x0040000000L;
    static final long H12_EXISTENCE = 0x0020000000L;
    static final long H13_EXISTENCE = 0x0010000000L;
    static final long H14_EXISTENCE = 0x0008000000L;
    static final long H15_EXISTENCE = 0x0004000000L;
    static final long H16_EXISTENCE = 0x0002000000L;
    static final long H17_EXISTENCE = 0x0001000000L;
    static final long H18_EXISTENCE = 0x0000800000L;
    static final long H19_EXISTENCE = 0x0000400000L;
    static final long H20_EXISTENCE = 0x0000200000L;
    static final long H21_EXISTENCE = 0x0000100000L;
    static final long H22_EXISTENCE = 0x0000080000L;
    static final long H23_EXISTENCE = 0x0000040000L;
    static final long H24_EXISTENCE = 0x0000020000L;
    static final long H25_EXISTENCE = 0x0000010000L;
    static final long H26_EXISTENCE = 0x0000008000L;
    static final long H27_EXISTENCE = 0x0000004000L;
    static final long H28_EXISTENCE = 0x0000002000L;
    static final long H29_EXISTENCE = 0x0000001000L;
    static final long H30_EXISTENCE = 0x0000000800L;
    static final long H31_EXISTENCE = 0x0000000400L;
    static final long H32_1_EXISTENCE = 0x0000000200L;
    static final long H32_2_EXISTENCE = 0x0000000100L;
    static final long H32_3_EXISTENCE = 0x0000000080L;
    static final long H32_4_EXISTENCE = 0x0000000040L;

    /**
     * Constructor.
     *
     * @param mask the mask values
     */
    private ExistenceMask(long mask) {
        this.mask = mask;
    }

    /**
     * Create an existence mask from byte array.
     *
     * @param bytes byte array of length 5
     * @return corresponding existence mask
     */
    public static ExistenceMask fromBytes(byte[] bytes) {
        long l =
                (((long) (bytes[0] & 0xFF)) << (4 * Byte.SIZE))
                        + (((long) (bytes[1] & 0xFF)) << (3 * Byte.SIZE))
                        + (((long) (bytes[2] & 0xFF)) << (2 * Byte.SIZE))
                        + (((long) (bytes[3] & 0xFF)) << (1 * Byte.SIZE))
                        + (bytes[4] & 0xFF);
        return new ExistenceMask(l);
    }

    public boolean isSet(final long existence) {
        return ((this.mask & existence) == existence);
    }
}
