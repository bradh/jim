package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class RadarSensorDescriptionDataTableParserTest extends TestSupport {

    public RadarSensorDescriptionDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0012.7023");
        assertTrue(dataTable instanceof RadarSensorDescriptionDataTable);
        RadarSensorDescriptionDataTable table = (RadarSensorDescriptionDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0012_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getImageLength(), otherLines, 1);
        validateIntegerValue(table.getImageWidth(), otherLines, 2);
        validateIntegerValue(table.getPacketsPerImage(), otherLines, 3);
        validateIntegerValue(table.getTileLength(), otherLines, 4);
        validateIntegerValue(table.getTileWidth(), otherLines, 5);
        validateASCIIValue(table.getPhysicalCoordinateSystemAsText(), otherLines, 6);
        validateASCIIValue(table.getCoordinateSystemOrientationAsText(), otherLines, 7);
        validateASCIIValue(table.getSensorModeAsText(), otherLines, 8);
        validateIntegerValue(table.getPixelSize(), otherLines, 9);
        validateIntegerValue(table.getElementsPerPixel(), otherLines, 10);
        validateASCIIValue(table.getDataOrderingAsText(), otherLines, 11);
        validateASCIIValue(table.getVldOrientationAsText(), otherLines, 12);
        assertEquals(otherLines.size(), 13);
    }
}
