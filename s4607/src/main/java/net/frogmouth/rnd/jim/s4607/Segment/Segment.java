package net.frogmouth.rnd.jim.s4607.Segment;

import java.nio.charset.StandardCharsets;

/**
 * Abstract segment representation.
 *
 * <p>Segments are a core concept in STANAG 4607. This is the base representation of a single
 * segment.
 */
public abstract class Segment {
    /**
     * Get the type of segment.
     *
     * @return the SegmentType for this segment.
     */
    public abstract SegmentType getSegmentType();

    /**
     * Validate a Basic Character Set (BCS) string.
     *
     * <p>The Basic Character Set (BCS) is used for text encoding in STANAG 4607. BCS is defined in
     * the Joint BIIF Profile (i.e. the shared base for NSIF and NITF). Valid BCS character codes
     * range from 0x20 to 0x7E, plus Line Feed (0x0A), Form Feed (0x0C), and Carriage Return (0x0D).
     * It is essentially a subset of US ASCII (and hence a subset of UTF-8). Some of the standard
     * uses character limits, and some of it uses byte limits. Those are equivalent for BCS - every
     * valid character is represented by a single byte.
     *
     * @param stringToValidate the string to validate
     * @param maxLength the maximum number of characters allowed.
     */
    public void validateBCS(String stringToValidate, int maxLength) {
        byte[] bytes = stringToValidate.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length > maxLength) {
            throw new IllegalArgumentException(
                    String.format(
                            "String is too long for specified field. Max is %d, got %d",
                            maxLength, bytes.length));
        }
        for (int i = 0; i < bytes.length; i++) {
            byte charval = bytes[i];
            if (charval < 0x0A) {
                throw new IllegalArgumentException(
                        "Only BCS characters are allowed, got " + stringToValidate);
            }
            if ((charval > 0x0D) && (charval < 0x20)) {
                throw new IllegalArgumentException(
                        "Only BCS characters are allowed, got " + stringToValidate);
            }
        }
    }
}
