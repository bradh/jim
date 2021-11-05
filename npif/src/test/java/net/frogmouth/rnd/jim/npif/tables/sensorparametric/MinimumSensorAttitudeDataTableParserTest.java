package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class MinimumSensorAttitudeDataTableParserTest extends TestSupport {

    public MinimumSensorAttitudeDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0042.7023");
        assertTrue(dataTable instanceof MinimumSensorAttitudeDataTable);
        MinimumSensorAttitudeDataTable table = (MinimumSensorAttitudeDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0042_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getRotationAboutZAxisDegrees(), otherLines, 1);
        validateDoubleValue(table.getRotationAboutYAxisDegrees(), otherLines, 2);
        validateDoubleValue(table.getRotationAboutXAxisDegrees(), otherLines, 3);
        assertEquals(otherLines.size(), 4);
    }
}
