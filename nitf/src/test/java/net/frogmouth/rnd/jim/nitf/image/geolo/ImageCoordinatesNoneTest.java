package net.frogmouth.rnd.jim.nitf.image.geolo;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class ImageCoordinatesNoneTest {

    public ImageCoordinatesNoneTest() {}

    @Test
    public void serialisation() {
        ImageCoordinates uut = new ImageCoordinatesNone();
        assertNotNull(uut);
        assertEquals(uut.getCoordinateRepresentation(), CoordinateRepresentation.None);
        assertEquals(uut.toBytes(), new byte[] {0x20});
    }
}
