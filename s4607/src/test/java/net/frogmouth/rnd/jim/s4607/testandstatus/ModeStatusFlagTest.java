package net.frogmouth.rnd.jim.s4607.testandstatus;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ModeStatusFlagTest {

    public ModeStatusFlagTest() {}

    @Test
    public void checkRangeLimitExceeded() {
        ModeStatusFlag uut = ModeStatusFlag.RangeLimitExceeded;
        assertEquals(uut.getFlagValue(), 0x80);
        assertEquals(uut.getLabel(), "Range Limit Exceeded");
    }

    @Test
    public void checkLookup() {
        ModeStatusFlag uut = ModeStatusFlag.lookupValue(0x20);
        assertEquals(uut, ModeStatusFlag.ElevationLimitExceeded);
        assertEquals(uut.getFlagValue(), 0x20);
        assertEquals(uut.getLabel(), "Elevation Limit Exceeded");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkLookupBad() {
        ModeStatusFlag.lookupValue(0x03);
    }
}
