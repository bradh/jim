package net.frogmouth.rnd.jim.s4607.impl;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/** Unit tests for RadarModeLookupTable. */
public class RadarModeLookupTableTest {

    @Test
    public void check0() {
        assertNotNull(RadarModeLookupTable.getInstance());
        assertEquals(RadarModeLookupTable.getValue(0), "Unspecified Mode [Generic]");
    }

    @Test
    public void check1() {
        assertNotNull(RadarModeLookupTable.getInstance());
        assertEquals(RadarModeLookupTable.getValue(1), "MTI (Moving target Indicator) [Generic]");
    }

    @Test
    public void check6() {
        assertEquals(RadarModeLookupTable.getValue(6), "Available for Future Use [Reserved]");
    }

    @Test
    public void check102() {
        assertEquals(RadarModeLookupTable.getValue(102), "MTI Arc Scan [Lynx I/II]");
    }

    @Test
    public void check144() {
        assertEquals(RadarModeLookupTable.getValue(144), "MTI SS [Seaspray]");
    }

    @Test
    public void check145() {
        assertEquals(RadarModeLookupTable.getValue(145), "Available for Future Use [Reserved]");
    }
}
