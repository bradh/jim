package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class RadarParametersDataTableParserTest extends TestSupport {

    public RadarParametersDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0017.7023");
        assertTrue(dataTable instanceof RadarParametersDataTable);
        RadarParametersDataTable table = (RadarParametersDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0017_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getProcessedResolutionInVld(), otherLines, 1);
        validateDoubleValue(table.getProcessedResolutionInCvld(), otherLines, 2);
        validateDoubleValue(table.getWavelength(), otherLines, 3);
        validateDoubleValue(table.getAveragePower(), otherLines, 4);
        validateDoubleValue(table.getAntennaGain(), otherLines, 5);
        validateDoubleValue(table.getPrf(), otherLines, 6);
        validateDoubleValue(table.getRadiometricScaleFactor(), otherLines, 7);
        validateDoubleValue(table.getApertureTime(), otherLines, 8);
        validateDoubleValue(table.getPulseCompressionRatio(), otherLines, 9);
        validateDoubleValue(table.getAzimuthBeamwidthDegrees(), otherLines, 10);
        validateDoubleValue(table.getInterpulseTransmitBandwidth(), otherLines, 11);
        validateDoubleValue(table.getInstantaneousReceiverBandwidth(), otherLines, 12);
        validateDoubleValue(table.getaToDConverterSampleRate(), otherLines, 13);
        validateASCIIValue(table.getRadarModeAsText(), otherLines, 14);
        validateIntegerValue(table.getProcessedNumberOfLooks(), otherLines, 15);
        validateIntegerValue(table.getPreSummingInRange(), otherLines, 16);
        validateIntegerValue(table.getPreSummingInAzimuth(), otherLines, 17);
        validateIntegerValue(table.getNumberOfAToDConverterBits(), otherLines, 18);
        validateASCIIValue(table.getInterpulseModulationTypeAsText(), otherLines, 19);
        validateASCIIValue(table.getPulseToPulseModulationTypeAsText(), otherLines, 20);
        validateASCIIValue(table.getRangeCompressionProcessingAlgorithmAsText(), otherLines, 21);
        validateASCIIValue(table.getAzimuthCompressionProcessingAlgorithmAsText(), otherLines, 22);
        validateASCIIValue(table.getAutofocusProcessingAlgorithmsAsText(), otherLines, 23);
        validateASCIIValue(table.getRangeProcessingWeightingAsText(), otherLines, 24);
        validateASCIIValue(table.getAzimuthProcessingWeightingAsText(), otherLines, 25);
        validateASCIIValue(table.getAntennaAzimuthWeightingAsText(), otherLines, 26);
        validateASCIIValue(table.getAntennaElevationWeightingAsText(), otherLines, 27);
        assertEquals(otherLines.size(), 28);
    }
}
