package net.frogmouth.rnd.jim.s4607.processinghistory;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ProcessingPerformedFlagTest {

    public ProcessingPerformedFlagTest() {}

    @Test
    public void checkAntennaStatus() {
        ProcessingPerformedFlag uut = ProcessingPerformedFlag.AreaFiltering;
        assertEquals(uut.getFlagValue(), 0x0001);
        assertEquals(uut.getLabel(), "Area Filtering");
        assertEquals(
                uut.getDescription(),
                "Elimination of target reports that are outside an area of interest or to delete targets within an area of exclusion.");
    }

    @Test
    public void checkLookup() {
        ProcessingPerformedFlag uut = ProcessingPerformedFlag.lookupValue(0x2000);
        assertEquals(uut, ProcessingPerformedFlag.TargetCoordinateConversion);
        assertEquals(uut.getFlagValue(), 0x2000);
        assertEquals(uut.getLabel(), "Target Coordinate Conversion");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkLookupBad() {
        ProcessingPerformedFlag.lookupValue(0x0003);
    }
}
