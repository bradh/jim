package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class SensorOperatingStatusDataTableParserTest extends TestSupport {

    public SensorOperatingStatusDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0043.7023");
        assertTrue(dataTable instanceof SensorOperatingStatusDataTable);
        SensorOperatingStatusDataTable table = (SensorOperatingStatusDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0043_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateASCIIValue(table.getStatus(), otherLines, 1);
        assertEquals(otherLines.size(), 2);
    }
}
