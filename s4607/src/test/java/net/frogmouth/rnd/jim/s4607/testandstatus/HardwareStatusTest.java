package net.frogmouth.rnd.jim.s4607.testandstatus;

import static org.testng.Assert.assertEquals;

import java.util.EnumSet;
import org.testng.annotations.Test;

public class HardwareStatusTest {

    public HardwareStatusTest() {}

    @Test
    public void emptyFlags() {
        HardwareStatus uut = HardwareStatus.fromByte((byte) 0x00);
        assertEquals(uut.getFlags(), EnumSet.noneOf(HardwareStatusFlag.class));
        assertEquals(uut.toByte(), (byte) 0x00);
    }

    @Test
    public void flags80() {
        HardwareStatus uut = HardwareStatus.fromByte((byte) 0x80);
        assertEquals(uut.getFlags(), EnumSet.of(HardwareStatusFlag.AntennaStatus));
        assertEquals(uut.toByte(), (byte) 0x80);
    }

    @Test
    public void flags08() {
        HardwareStatus uut = HardwareStatus.fromByte((byte) 0x08);
        assertEquals(uut.getFlags(), EnumSet.of(HardwareStatusFlag.CalibrationModeStatus));
        assertEquals(uut.toByte(), (byte) 0x08);
    }

    @Test
    public void flagsAll() {
        HardwareStatus uut = HardwareStatus.fromByte((byte) 0xF8);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        HardwareStatusFlag.AntennaStatus,
                        HardwareStatusFlag.RfElectronicsStatus,
                        HardwareStatusFlag.CalibrationModeStatus,
                        HardwareStatusFlag.ProcessorStatus,
                        HardwareStatusFlag.DatalinkStatus));
        assertEquals(uut.toByte(), (byte) 0xF8);
    }

    @Test
    public void flagsSome() {
        HardwareStatus uut = HardwareStatus.fromByte((byte) 0xD8);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        HardwareStatusFlag.AntennaStatus,
                        HardwareStatusFlag.RfElectronicsStatus,
                        HardwareStatusFlag.CalibrationModeStatus,
                        HardwareStatusFlag.DatalinkStatus));
        assertEquals(uut.toByte(), (byte) 0xD8);
    }

    @Test
    public void fromFlagAntenna() {
        HardwareStatus uut = HardwareStatus.fromFlags(EnumSet.of(HardwareStatusFlag.AntennaStatus));
        assertEquals(uut.getFlags(), EnumSet.of(HardwareStatusFlag.AntennaStatus));
        assertEquals(uut.toByte(), (byte) 0x80);
    }

    @Test
    public void fromFlagCalibrationModeStatus() {
        HardwareStatus uut =
                HardwareStatus.fromFlags(EnumSet.of(HardwareStatusFlag.CalibrationModeStatus));
        assertEquals(uut.getFlags(), EnumSet.of(HardwareStatusFlag.CalibrationModeStatus));
        assertEquals(uut.toByte(), (byte) 0x08);
    }

    @Test
    public void fromFlagsSome() {
        HardwareStatus uut =
                HardwareStatus.fromFlags(
                        EnumSet.of(
                                HardwareStatusFlag.AntennaStatus,
                                HardwareStatusFlag.RfElectronicsStatus,
                                HardwareStatusFlag.CalibrationModeStatus,
                                HardwareStatusFlag.DatalinkStatus));
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        HardwareStatusFlag.AntennaStatus,
                        HardwareStatusFlag.RfElectronicsStatus,
                        HardwareStatusFlag.CalibrationModeStatus,
                        HardwareStatusFlag.DatalinkStatus));
        assertEquals(uut.toByte(), (byte) 0xD8);
    }

    @Test
    public void fromFlagsAll() {
        HardwareStatus uut =
                HardwareStatus.fromFlags(
                        EnumSet.of(
                                HardwareStatusFlag.AntennaStatus,
                                HardwareStatusFlag.RfElectronicsStatus,
                                HardwareStatusFlag.CalibrationModeStatus,
                                HardwareStatusFlag.ProcessorStatus,
                                HardwareStatusFlag.DatalinkStatus));
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        HardwareStatusFlag.AntennaStatus,
                        HardwareStatusFlag.RfElectronicsStatus,
                        HardwareStatusFlag.CalibrationModeStatus,
                        HardwareStatusFlag.ProcessorStatus,
                        HardwareStatusFlag.DatalinkStatus));
        assertEquals(uut.toByte(), (byte) 0xF8);
    }
}
