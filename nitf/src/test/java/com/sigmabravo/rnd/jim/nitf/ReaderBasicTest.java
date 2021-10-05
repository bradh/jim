package com.sigmabravo.rnd.jim.nitf;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

/** Basic tests for Reader. */
public class ReaderBasicTest extends TestSupport {

    public ReaderBasicTest() {}

    @Test
    public void bib() throws IOException {
        Reader reader = new Reader(getHyperionBIBTestData());
        assertTrue(reader.isNITF());
        assertEquals(reader.getCLEVEL(), 5);
        assertEquals(reader.getOSTAID(), "L3Harris  ");
        assertEquals(reader.getONAME(), "Dr. Barbara Eckstein    ");
        assertEquals(reader.getOPHONE(), "571-557-5526      ");
        assertEquals(reader.getNumberOfImageSegments(), 9);
        assertEquals(reader.getNumberOfGraphicSegments(), 0);
        assertEquals(reader.getNumberOfDES(), 4);
        // assertEquals(reader.getUserDefinedHeaderData().length, 0);
    }
}
