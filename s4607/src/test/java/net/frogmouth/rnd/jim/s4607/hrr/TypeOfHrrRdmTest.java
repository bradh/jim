package net.frogmouth.rnd.jim.s4607.hrr;

import static org.testng.Assert.*;

import net.frogmouth.rnd.jim.s4607.segment.*;
import org.testng.annotations.Test;

/** Unit tests for {@link TypeOfHrrRdm}. */
public class TypeOfHrrRdmTest {

    public TypeOfHrrRdmTest() {}

    @Test
    public void check1() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.HrrProfile1D;
        assertEquals(uut.getTag(), 1);
        assertEquals(uut.getDisplayLabel(), "1-D HRR Profile");
    }

    @Test
    public void check0() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.Other;
        assertEquals(uut.getTag(), 0);
        assertEquals(uut.getDisplayLabel(), "Other");
    }

    @Test
    public void check7() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.PulseDataFullRange;
        assertEquals(uut.getTag(), 7);
        assertEquals(uut.getDisplayLabel(), "Full Range Pulse Data");
    }

    @Test
    public void lookup2() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.lookupByIdent(2);
        assertEquals(uut.getTag(), 2);
        assertEquals(uut.getDisplayLabel(), "2-D HRR Chip");
    }

    @Test
    public void lookup255() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.lookupByIdent(255);
        assertEquals(uut, TypeOfHrrRdm.Reserved);
        assertEquals(uut.getTag(), 255);
        assertEquals(uut.getDisplayLabel(), "Reserved");
    }

    @Test
    public void lookup8() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.lookupByIdent(8);
        assertEquals(uut, TypeOfHrrRdm.Reserved);
        assertEquals(uut.getTag(), 255);
        assertEquals(uut.getDisplayLabel(), "Reserved");
    }

    @Test
    public void lookup256() {
        TypeOfHrrRdm uut = TypeOfHrrRdm.lookupByIdent(256);
        assertEquals(uut, TypeOfHrrRdm.Unknown);
        assertEquals(uut.getTag(), -1);
        assertEquals(uut.getDisplayLabel(), "Unknown / Invalid");
    }
}
