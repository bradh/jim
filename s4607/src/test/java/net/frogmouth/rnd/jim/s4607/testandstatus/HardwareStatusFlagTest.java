package net.frogmouth.rnd.jim.s4607.testandstatus;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class HardwareStatusFlagTest {

    public HardwareStatusFlagTest() {}

    @Test
    public void checkAntennaStatus() {
        HardwareStatusFlag uut = HardwareStatusFlag.AntennaStatus;
        assertEquals(uut.getFlagValue(), 0x80);
        assertEquals(uut.getLabel(), "Antenna Status");
    }

    @Test
    public void checkLookup() {
        HardwareStatusFlag uut = HardwareStatusFlag.lookupValue(0x20);
        assertEquals(uut, HardwareStatusFlag.ProcessorStatus);
        assertEquals(uut.getFlagValue(), 0x20);
        assertEquals(uut.getLabel(), "Processor Status");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkLookupBad() {
        HardwareStatusFlag.lookupValue(0x03);
    }
}
