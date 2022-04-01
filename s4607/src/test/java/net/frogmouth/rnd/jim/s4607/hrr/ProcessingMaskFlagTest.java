package net.frogmouth.rnd.jim.s4607.hrr;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ProcessingMaskFlagTest {

    public ProcessingMaskFlagTest() {}

    @Test
    public void checkClutterCancellation() {
        ProcessingMaskFlag uut = ProcessingMaskFlag.ClutterCancellation;
        assertEquals(uut.getFlagValue(), 0x80);
        assertEquals(uut.getLabel(), "Clutter Cancellation");
    }

    @Test
    public void checkUnknown() {
        ProcessingMaskFlag uut = ProcessingMaskFlag.Unknown;
        assertEquals(uut.getFlagValue(), 0x01);
        assertEquals(uut.getLabel(), "Unknown");
    }

    @Test
    public void checkLookup() {
        ProcessingMaskFlag uut = ProcessingMaskFlag.lookupValue(0x20);
        assertEquals(uut, ProcessingMaskFlag.MultiAmbiguityKeystoning);
        assertEquals(uut.getFlagValue(), 0x20);
        assertEquals(uut.getLabel(), "Multi-Ambiguity Keystoning");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkLookupBad() {
        ProcessingMaskFlag.lookupValue(0x03);
    }
}
