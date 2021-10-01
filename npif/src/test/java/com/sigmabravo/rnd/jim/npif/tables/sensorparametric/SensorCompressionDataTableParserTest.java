package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class SensorCompressionDataTableParserTest extends TestSupport {

    public SensorCompressionDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0002.7023");
        assertTrue(dataTable instanceof SensorCompressionDataTable);
        SensorCompressionDataTable table = (SensorCompressionDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0002_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateASCIIValue(table.getCompressionAlgorithmAsText(), otherLines, 1);
        assertEquals(otherLines.size(), 2);
    }
}
