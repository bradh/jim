package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class MinimumGimbalsAttitudeDataTableParserTest extends TestSupport {

    public MinimumGimbalsAttitudeDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0001.7023");
        assertTrue(dataTable instanceof MinimumGimbalsAttitudeDataTable);
        MinimumGimbalsAttitudeDataTable table = (MinimumGimbalsAttitudeDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0001_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getGimbalId(), otherLines, 1);
        validateDoubleValue(table.getRotationAboutZAxisDegrees(), otherLines, 2);
        validateDoubleValue(table.getRotationAboutYAxisDegrees(), otherLines, 3);
        validateDoubleValue(table.getRotationAboutXAxisDegrees(), otherLines, 4);
        assertEquals(otherLines.size(), 5);
    }
}
