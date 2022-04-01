package net.frogmouth.rnd.jim.s4607.hrr;

import static org.testng.Assert.assertEquals;

import java.util.EnumSet;
import org.testng.annotations.Test;

public class ProcessingMaskTest {

    public ProcessingMaskTest() {}

    @Test
    public void emptyFlags() {
        ProcessingMask uut = ProcessingMask.fromByte((byte) 0x00);
        assertEquals(uut.getFlags(), EnumSet.noneOf(ProcessingMaskFlag.class));
        assertEquals(uut.toByte(), (byte) 0x00);
    }

    @Test
    public void flags80() {
        ProcessingMask uut = ProcessingMask.fromByte((byte) 0x80);
        assertEquals(uut.getFlags(), EnumSet.of(ProcessingMaskFlag.ClutterCancellation));
        assertEquals(uut.toByte(), (byte) 0x80);
    }

    @Test
    public void flags10() {
        ProcessingMask uut = ProcessingMask.fromByte((byte) 0x10);
        assertEquals(uut.getFlags(), EnumSet.of(ProcessingMaskFlag.Spare4));
        assertEquals(uut.toByte(), (byte) 0x10);
    }

    @Test
    public void flagsAll() {
        ProcessingMask uut = ProcessingMask.fromByte((byte) 0xE1);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ProcessingMaskFlag.ClutterCancellation,
                        ProcessingMaskFlag.SingleAmbiguityKeystoning,
                        ProcessingMaskFlag.MultiAmbiguityKeystoning,
                        ProcessingMaskFlag.Unknown));
        assertEquals(uut.toByte(), (byte) 0xE1);
    }

    @Test
    public void flagsSome() {
        ProcessingMask uut = ProcessingMask.fromByte((byte) 0x60);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ProcessingMaskFlag.MultiAmbiguityKeystoning,
                        ProcessingMaskFlag.SingleAmbiguityKeystoning));
        assertEquals(uut.toByte(), (byte) 0x60);
    }

    @Test
    public void fromFlagsSome() {
        ProcessingMask uut =
                ProcessingMask.fromFlags(
                        EnumSet.of(
                                ProcessingMaskFlag.MultiAmbiguityKeystoning,
                                ProcessingMaskFlag.SingleAmbiguityKeystoning));
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ProcessingMaskFlag.MultiAmbiguityKeystoning,
                        ProcessingMaskFlag.SingleAmbiguityKeystoning));
        assertEquals(uut.toByte(), (byte) 0x60);
    }
}
