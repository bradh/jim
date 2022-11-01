package net.frogmouth.rnd.jim.nitf.image.geolo;

import static org.testng.Assert.*;

import java.nio.charset.StandardCharsets;
import org.testng.annotations.Test;

public class ImageCoordinatesDecimalDegreesTest {

    public ImageCoordinatesDecimalDegreesTest() {}

    @Test
    public void serialisation() {
        ImageCoordinatesDecimalDegrees uut =
                new ImageCoordinatesDecimalDegrees(
                        new LatitudeLongitude(-30.000, 150.0000),
                        new LatitudeLongitude(-30.000, 151.0000),
                        new LatitudeLongitude(-31.000, 151.0000),
                        new LatitudeLongitude(-31.000, 150.0000));
        assertNotNull(uut);
        assertEquals(uut.getCoordinateRepresentation(), CoordinateRepresentation.DecimalDegrees);
        assertEquals(uut.toBytes().length, 61);
        assertEquals(
                uut.toBytes(),
                "D-30.000+150.000-30.000+151.000-31.000+151.000-31.000+150.000"
                        .getBytes(StandardCharsets.US_ASCII));
    }
}
