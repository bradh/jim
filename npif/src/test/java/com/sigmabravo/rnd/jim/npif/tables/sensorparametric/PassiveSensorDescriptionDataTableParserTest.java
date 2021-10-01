package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class PassiveSensorDescriptionDataTableParserTest extends TestSupport {

    public PassiveSensorDescriptionDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0044.7023");
        assertTrue(dataTable instanceof PassiveSensorDescriptionDataTable);
        PassiveSensorDescriptionDataTable table = (PassiveSensorDescriptionDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0044_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getFrameOrSwathSize(), otherLines, 1);
        validateDoubleValue(table.getActiveLineTime(), otherLines, 2);
        validateIntegerValue(table.getLineSizeOfActiveData(), otherLines, 3);
        validateIntegerValue(table.getPacketsPerFrameOrSwath(), otherLines, 4);
        validateIntegerValue(
                table.getSizeOfTileInTheHighFrequencyScanningDirection(), otherLines, 5);
        validateIntegerValue(
                table.getSizeOfTileInTheLowFrequencyScanningDirection(), otherLines, 6);
        validateIntegerValue(table.getNumberOfTilesAcrossALine(), otherLines, 7);
        validateIntegerValue(table.getNumberOfSwathsPerFrame(), otherLines, 8);
        validateASCIIValue(table.getSensorModeAsText(), otherLines, 9);
        validateIntegerValue(table.getPixelSize(), otherLines, 10);
        validateIntegerValue(table.getElementsPerPixel(), otherLines, 11);
        validateASCIIValue(table.getDataOrderingAsText(), otherLines, 12);
        validateDoubleValue(table.getLineFOVDegrees(), otherLines, 13);
        validateDoubleValue(table.getFrameOrSwathFOVDegrees(), otherLines, 14);
        validateASCIIValue(table.getNumberOfFieldsAsText(), otherLines, 15);
        validateASCIIValue(table.getHighFrequencyScanningDirectionAsText(), otherLines, 16);
        validateASCIIValue(table.getLowFrequencyScanningDirectionAsText(), otherLines, 17);
        assertEquals(otherLines.size(), 18);
    }
}
