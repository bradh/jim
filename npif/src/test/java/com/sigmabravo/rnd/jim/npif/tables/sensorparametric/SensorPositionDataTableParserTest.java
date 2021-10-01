package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class SensorPositionDataTableParserTest extends TestSupport {

    public SensorPositionDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0041.7023");
        assertTrue(dataTable instanceof SensorPositionDataTable);
        SensorPositionDataTable table = (SensorPositionDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0041_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getxVectorComponent(), otherLines, 1);
        validateDoubleValue(table.getyVectorComponent(), otherLines, 2);
        validateDoubleValue(table.getzVectorComponent(), otherLines, 3);
        assertEquals(otherLines.size(), 4);
    }
}
