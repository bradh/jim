package net.frogmouth.rnd.jim.charsets;

import static org.testng.Assert.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.SortedMap;
import org.testng.annotations.Test;

public class ECS_A_ProviderTest {

    public ECS_A_ProviderTest() {}

    @Test
    public void checkByName() {
        Charset c = Charset.forName("ECS-A");
        assertNotNull(c);
        assertTrue(c instanceof ECS_A);
    }

    @Test
    public void checkAvailable() {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        assertTrue(charsets.containsKey("ECS-A"));
    }

    @Test
    public void simpleDecodeByName() throws UnsupportedEncodingException {
        byte[] bytes = new byte[] {0x30, 0x31, 0x32, 0x33, 0x41, 0x5a, 0x61, 0x7a};
        String s = new String(bytes, "ECS-A");
        assertEquals(s, "0123AZaz");
    }
}
