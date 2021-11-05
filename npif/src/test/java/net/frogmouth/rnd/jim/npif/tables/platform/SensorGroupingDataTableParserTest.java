package net.frogmouth.rnd.jim.npif.tables.platform;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SensorGroupingDataTableParserTest extends TestSupport {

    public SensorGroupingDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0005.7023");
        assertTrue(dataTable instanceof SensorGroupingDataTable);
        SensorGroupingDataTable table = (SensorGroupingDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0005_tables.csv");
        validateASCIIValue(table.getGroupTypeAsText(), otherLines, 1);
        validateIntegerValue(table.getNumberOfSensorNumbersWithinTheGroup(), otherLines, 2);
        validateASCIIValue(table.getCoverageRelationshipAsText(), otherLines, 3);
        validateASCIIValue(table.getTimingRelationshipAsText(), otherLines, 4);
        validateIntegerValue(table.getSensorNumbers().size(), otherLines, 5);
        validateASCIIValue(
                String.format("[%d],%d", 0, table.getSensorNumbers().get(0)), otherLines, 6);
        validateASCIIValue(
                String.format("[%d],%d", 1, table.getSensorNumbers().get(1)), otherLines, 7);
        assertEquals(otherLines.size(), 8);
    }
}
