package net.frogmouth.rnd.jim.s4607.testandstatus;

import static org.testng.Assert.assertEquals;

import java.util.EnumSet;
import org.testng.annotations.Test;

public class ModeStatusTest {

    public ModeStatusTest() {}

    @Test
    public void emptyFlags() {
        ModeStatus uut = ModeStatus.fromByte((byte) 0x00);
        assertEquals(uut.getFlags(), EnumSet.noneOf(ModeStatusFlag.class));
        assertEquals(uut.toByte(), (byte) 0x00);
    }

    @Test
    public void flags80() {
        ModeStatus uut = ModeStatus.fromByte((byte) 0x80);
        assertEquals(uut.getFlags(), EnumSet.of(ModeStatusFlag.RangeLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0x80);
    }

    @Test
    public void flags10() {
        ModeStatus uut = ModeStatus.fromByte((byte) 0x10);
        assertEquals(uut.getFlags(), EnumSet.of(ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0x10);
    }

    @Test
    public void flagsAll() {
        ModeStatus uut = ModeStatus.fromByte((byte) 0xF0);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ModeStatusFlag.RangeLimitExceeded,
                        ModeStatusFlag.AzimuthLimitExceeded,
                        ModeStatusFlag.ElevationLimitExceeded,
                        ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0xF0);
    }

    @Test
    public void flagsSome() {
        ModeStatus uut = ModeStatus.fromByte((byte) 0xD0);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ModeStatusFlag.RangeLimitExceeded,
                        ModeStatusFlag.AzimuthLimitExceeded,
                        ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0xD0);
    }

    @Test
    public void fromFlagRange() {
        ModeStatus uut = ModeStatus.fromFlags(EnumSet.of(ModeStatusFlag.RangeLimitExceeded));
        assertEquals(uut.getFlags(), EnumSet.of(ModeStatusFlag.RangeLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0x80);
    }

    @Test
    public void fromFlagTemperature() {
        ModeStatus uut = ModeStatus.fromFlags(EnumSet.of(ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.getFlags(), EnumSet.of(ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0x10);
    }

    @Test
    public void fromFlagsSome() {
        ModeStatus uut =
                ModeStatus.fromFlags(
                        EnumSet.of(
                                ModeStatusFlag.RangeLimitExceeded,
                                ModeStatusFlag.ElevationLimitExceeded,
                                ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ModeStatusFlag.RangeLimitExceeded,
                        ModeStatusFlag.ElevationLimitExceeded,
                        ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0xB0);
    }

    @Test
    public void fromFlagsAll() {
        ModeStatus uut =
                ModeStatus.fromFlags(
                        EnumSet.of(
                                ModeStatusFlag.RangeLimitExceeded,
                                ModeStatusFlag.AzimuthLimitExceeded,
                                ModeStatusFlag.ElevationLimitExceeded,
                                ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ModeStatusFlag.RangeLimitExceeded,
                        ModeStatusFlag.AzimuthLimitExceeded,
                        ModeStatusFlag.ElevationLimitExceeded,
                        ModeStatusFlag.TemperatureLimitExceeded));
        assertEquals(uut.toByte(), (byte) 0xF0);
    }
}
