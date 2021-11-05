package net.frogmouth.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class RangeFinderDataTableParserTest extends TestSupport {

    public RangeFinderDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0026.7023");
        assertTrue(dataTable instanceof RangeFinderDataTable);
        RangeFinderDataTable table = (RangeFinderDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0026_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getRange(), otherLines, 1);
        assertEquals(otherLines.size(), 2);
    }
}
