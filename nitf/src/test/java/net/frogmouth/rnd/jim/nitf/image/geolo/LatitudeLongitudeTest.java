package net.frogmouth.rnd.jim.nitf.image.geolo;

import static org.testng.Assert.*;

import java.nio.charset.StandardCharsets;
import org.testng.annotations.Test;

public class LatitudeLongitudeTest {

    public LatitudeLongitudeTest() {}

    @Test
    public void checkPositiveValues() {
        LatitudeLongitude uut = new LatitudeLongitude(40.0, 120.0);
        assertEquals(uut.asBytes(), "+40.000+120.000".getBytes(StandardCharsets.US_ASCII));
    }

    @Test
    public void checkNegativeValues() {
        LatitudeLongitude uut = new LatitudeLongitude(-40.0, -120.0);
        assertEquals(uut.asBytes(), "-40.000-120.000".getBytes(StandardCharsets.US_ASCII));
    }

    @Test
    public void checkNegativeLatitudeValues() {
        LatitudeLongitude uut = new LatitudeLongitude(-40.0, 120.0);
        assertEquals(uut.asBytes(), "-40.000+120.000".getBytes(StandardCharsets.US_ASCII));
    }

    @Test
    public void checkShortValues() {
        LatitudeLongitude uut = new LatitudeLongitude(1.0, 2.0);
        assertEquals(uut.asBytes(), "+01.000+002.000".getBytes(StandardCharsets.US_ASCII));
    }
}
