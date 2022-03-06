package net.frogmouth.rnd.jim.s4607.segment;

import org.testng.annotations.Test;

/** Unit tests for the (abstract) Segment class. */
public class SegmentTest {

    private final Segment s =
            new Segment() {
                @Override
                public SegmentType getSegmentType() {
                    // Doesn't matter
                    return SegmentType.SystemSpecificSegment;
                }
            };

    @Test
    public void validateBCSGood() {
        s.validateBCS("Something", 10);
    }

    @Test
    public void validateBCSJustGood() {
        s.validateBCS("Something0", 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void validateBCSTooLong() {
        s.validateBCS("Something01", 10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void validateBCSBadChar() {
        s.validateBCS("Sométhing", 10);
    }
}
