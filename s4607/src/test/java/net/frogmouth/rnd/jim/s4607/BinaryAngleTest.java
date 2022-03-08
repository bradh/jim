package net.frogmouth.rnd.jim.s4607;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class BinaryAngleTest {

    public BinaryAngleTest() {}

    @Test
    public void checkBA16() {
        byte[] bytes = new byte[] {(byte) 0b01011001, (byte) 0b00011100};
        ByteArrayParseContext parseContext = new ByteArrayParseContext(bytes);
        double d = parseContext.readBA16();
        assertEquals(d, 125.31006, 0.00001);
    }

    @Test
    public void checkBA32() {
        byte[] bytes = new byte[] {(byte) 0b01011001, (byte) 0b00011100, 0x00, 0x00};
        ByteArrayParseContext parseContext = new ByteArrayParseContext(bytes);
        double d = parseContext.readBA32();
        assertEquals(d, 125.31006, 0.00001);
    }

    @Test
    public void checkSA16() {
        byte[] bytes = new byte[] {(byte) 0xCE, (byte) 0x66};
        ByteArrayParseContext parseContext = new ByteArrayParseContext(bytes);
        double d = parseContext.readSA16();
        assertEquals(d, -34.876099, 0.000001);
    }

    @Test
    public void checkSA32() {
        byte[] bytes = new byte[] {(byte) 0xCE, (byte) 0x66, (byte) 0x00, (byte) 0x00};
        ByteArrayParseContext parseContext = new ByteArrayParseContext(bytes);
        double d = parseContext.readSA32();
        assertEquals(d, -34.876099, 0.000001);
    }
}
