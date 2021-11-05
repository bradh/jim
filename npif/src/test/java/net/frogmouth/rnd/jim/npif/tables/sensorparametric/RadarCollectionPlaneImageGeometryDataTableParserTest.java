package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class RadarCollectionPlaneImageGeometryDataTableParserTest extends TestSupport {

    public RadarCollectionPlaneImageGeometryDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0013.7023");
        assertTrue(dataTable instanceof RadarCollectionPlaneImageGeometryDataTable);
        RadarCollectionPlaneImageGeometryDataTable table =
                (RadarCollectionPlaneImageGeometryDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0013_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getAlphaDegrees(), otherLines, 1);
        validateDoubleValue(table.getVirtualDistanceToTheFirstPixelInTheImage(), otherLines, 2);
        validateDoubleValue(table.getPixelIntervalInTheVirtualLookDirection(), otherLines, 3);
        validateDoubleValue(table.getPixelIntervalInTheCrossVirtualLookDirection(), otherLines, 4);
        validateASCIIValue(
                table.getUnitsOfMeasurementForCrossVirtualLookDirectionAsText(), otherLines, 5);
        assertEquals(otherLines.size(), 6);
    }
}
