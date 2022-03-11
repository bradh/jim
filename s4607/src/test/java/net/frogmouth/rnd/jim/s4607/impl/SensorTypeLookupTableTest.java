package net.frogmouth.rnd.jim.s4607.impl;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/** Unit tests for SesnorTypeLookupTable. */
public class SensorTypeLookupTableTest {

    @Test
    public void check0() {
        assertNotNull(SensorTypeLookupTable.getInstance());
        assertEquals(SensorTypeLookupTable.getValue(0), "Unidentified");
    }

    @Test
    public void check1() {
        assertNotNull(SensorTypeLookupTable.getInstance());
        assertEquals(SensorTypeLookupTable.getValue(1), "Other");
    }

    @Test
    public void check5() {
        assertEquals(SensorTypeLookupTable.getValue(5), "Global Hawk Sensor");
    }

    @Test
    public void check27() {
        assertEquals(SensorTypeLookupTable.getValue(27), "VADER");
    }

    @Test
    public void check34() {
        assertEquals(SensorTypeLookupTable.getValue(34), "PicoSAR");
    }

    @Test
    public void check35() {
        assertEquals(SensorTypeLookupTable.getValue(35), "Available for Future Use");
    }

    @Test
    public void check254() {
        assertEquals(SensorTypeLookupTable.getValue(254), "Available for Future Use");
    }

    @Test
    public void check255() {
        assertEquals(SensorTypeLookupTable.getValue(255), "No Statement");
    }
}
