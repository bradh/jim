package net.frogmouth.rnd.jim.nitf.tre.xmldca;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class XMLDCATest {

    public XMLDCATest() {}

    @Test
    public void withoutCRC() {
        XMLDCA uut = new XMLDCA();
        assertFalse(uut.isCrcEnabled());
        uut.setBody("<p/>");
        assertEquals(uut.getBody(), "<p/>");
        assertEquals(
                uut.toBytes(),
                new byte[] {
                    0x58, 0x4d, 0x4c, 0x44, 0x43, 0x41, 0x30, 0x30, 0x30, 0x30, 0x38, 0x30, 0x30,
                    0x30, 0x30, 0x3c, 0x70, 0x2f, 0x3e
                });
    }

    @Test
    public void withCRC() {
        XMLDCA uut = new XMLDCA();
        uut.setCrcEnabled(true);
        assertTrue(uut.isCrcEnabled());
        uut.setBody("<p/>");
        assertEquals(uut.getBody(), "<p/>");
        assertEquals(
                uut.toBytes(),
                new byte[] {
                    0x58, 0x4d, 0x4c, 0x44, 0x43, 0x41, 0x30, 0x30, 0x30, 0x31, 0x33, 0x30, 0x30,
                    0x30, 0x35, 0x32, 0x37, 0x35, 0x33, 0x36, 0x3c, 0x70, 0x2f, 0x3e
                });
    }
}
