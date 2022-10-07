package net.frogmouth.rnd.jim.nitf;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/** Unit tests for JBPDateTime. */
public class JBPDateTimeTest {

    public JBPDateTimeTest() {}

    @Test
    public void checkDefaults() {
        JBPDateTime uut = new JBPDateTime();
        assertNull(uut.getCenturies());
        assertNull(uut.getYears());
        assertNull(uut.getMonths());
        assertNull(uut.getDays());
        assertNull(uut.getHours());
        assertNull(uut.getMinutes());
        assertNull(uut.getSeconds());
        assertEquals(
                uut.asBytes(),
                new byte[] {
                    0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d, 0x2d,
                    0x2d
                });
    }

    @Test
    public void checkValues() {
        JBPDateTime uut = new JBPDateTime(20, 22, 10, 11, 14, 54, 38);
        assertEquals(uut.getCenturies(), 20);
        assertEquals(uut.getYears(), 22);
        assertEquals(uut.getMonths(), 10);
        assertEquals(uut.getDays(), 11);
        assertEquals(uut.getHours(), 14);
        assertEquals(uut.getMinutes(), 54);
        assertEquals(uut.getSeconds(), 38);
        assertEquals(
                uut.asBytes(),
                new byte[] {
                    0x32, 0x30, 0x32, 0x32, 0x31, 0x30, 0x31, 0x31, 0x31, 0x34, 0x35, 0x34, 0x33,
                    0x38
                });
    }
}
