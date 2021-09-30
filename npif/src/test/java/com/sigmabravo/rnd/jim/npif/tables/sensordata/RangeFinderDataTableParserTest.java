package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class RangeFinderDataTableParserTest extends TestSupport {

    public RangeFinderDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0026.7023");
        assertTrue(dataTable instanceof RangeFinderDataTable);
        RangeFinderDataTable table = (RangeFinderDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0026_tables.csv");
        // TODO: extract sensor id
        validateDoubleValue(table.getRange(), otherLines, 1);
        assertEquals(otherLines.size(), 2);
    }
}
