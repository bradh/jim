package net.frogmouth.rnd.jim.s4607.processinghistory;

import static org.testng.Assert.assertEquals;

import java.util.EnumSet;
import org.testng.annotations.Test;

public class ProcessingPerformedTest {

    public ProcessingPerformedTest() {}

    @Test
    public void emptyFlags() {
        ProcessingPerformed uut = ProcessingPerformed.fromInteger(0x0000);
        assertEquals(uut.getFlags(), EnumSet.noneOf(ProcessingPerformedFlag.class));
        assertEquals(uut.toInteger(), 0x0000);
    }

    @Test
    public void flags80() {
        ProcessingPerformed uut = ProcessingPerformed.fromInteger(0x0080);
        assertEquals(uut.getFlags(), EnumSet.of(ProcessingPerformedFlag.LocationAdjustment));
        assertEquals(uut.toInteger(), 0x0080);
    }

    @Test
    public void flags0800() {
        ProcessingPerformed uut = ProcessingPerformed.fromInteger(0x0800);
        assertEquals(uut.getFlags(), EnumSet.of(ProcessingPerformedFlag.SecurityFiltering));
        assertEquals(uut.toInteger(), 0x0800);
    }

    @Test
    public void flagsAll() {
        ProcessingPerformed uut = ProcessingPerformed.fromInteger(0x3FFF);
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ProcessingPerformedFlag.AreaFiltering,
                        ProcessingPerformedFlag.TargetClassificationFiltering,
                        ProcessingPerformedFlag.LOSVelocityFiltering,
                        ProcessingPerformedFlag.SNRFiltering,
                        ProcessingPerformedFlag.DeclutterFiltering,
                        ProcessingPerformedFlag.BandwidthFiltering,
                        ProcessingPerformedFlag.RevisitFiltering,
                        ProcessingPerformedFlag.LocationAdjustment,
                        ProcessingPerformedFlag.GeoidAdjustment,
                        ProcessingPerformedFlag.LocationRegistration,
                        ProcessingPerformedFlag.TimeFiltering,
                        ProcessingPerformedFlag.SecurityFiltering,
                        ProcessingPerformedFlag.DataAugmentation,
                        ProcessingPerformedFlag.TargetCoordinateConversion));
        assertEquals(uut.toInteger(), 0x3FFF);
    }

    @Test
    public void fromFlags() {
        ProcessingPerformed uut =
                ProcessingPerformed.fromFlags(
                        EnumSet.of(ProcessingPerformedFlag.SecurityFiltering));
        assertEquals(uut.getFlags(), EnumSet.of(ProcessingPerformedFlag.SecurityFiltering));
        assertEquals(uut.toInteger(), 0x0800);
    }

    @Test
    public void fromFlagsAll() {
        ProcessingPerformed uut =
                ProcessingPerformed.fromFlags(
                        EnumSet.of(
                                ProcessingPerformedFlag.AreaFiltering,
                                ProcessingPerformedFlag.TargetClassificationFiltering,
                                ProcessingPerformedFlag.LOSVelocityFiltering,
                                ProcessingPerformedFlag.SNRFiltering,
                                ProcessingPerformedFlag.DeclutterFiltering,
                                ProcessingPerformedFlag.BandwidthFiltering,
                                ProcessingPerformedFlag.RevisitFiltering,
                                ProcessingPerformedFlag.LocationAdjustment,
                                ProcessingPerformedFlag.GeoidAdjustment,
                                ProcessingPerformedFlag.LocationRegistration,
                                ProcessingPerformedFlag.TimeFiltering,
                                ProcessingPerformedFlag.SecurityFiltering,
                                ProcessingPerformedFlag.DataAugmentation,
                                ProcessingPerformedFlag.TargetCoordinateConversion));
        assertEquals(
                uut.getFlags(),
                EnumSet.of(
                        ProcessingPerformedFlag.AreaFiltering,
                        ProcessingPerformedFlag.TargetClassificationFiltering,
                        ProcessingPerformedFlag.LOSVelocityFiltering,
                        ProcessingPerformedFlag.SNRFiltering,
                        ProcessingPerformedFlag.DeclutterFiltering,
                        ProcessingPerformedFlag.BandwidthFiltering,
                        ProcessingPerformedFlag.RevisitFiltering,
                        ProcessingPerformedFlag.LocationAdjustment,
                        ProcessingPerformedFlag.GeoidAdjustment,
                        ProcessingPerformedFlag.LocationRegistration,
                        ProcessingPerformedFlag.TimeFiltering,
                        ProcessingPerformedFlag.SecurityFiltering,
                        ProcessingPerformedFlag.DataAugmentation,
                        ProcessingPerformedFlag.TargetCoordinateConversion));
        assertEquals(uut.toInteger(), 0x3FFF);
    }
}
