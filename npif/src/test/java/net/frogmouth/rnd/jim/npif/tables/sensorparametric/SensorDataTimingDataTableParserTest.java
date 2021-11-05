package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SensorDataTimingDataTableParserTest extends TestSupport {

    public SensorDataTimingDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0050.7023");
        assertTrue(dataTable instanceof SensorDataTimingDataTable);
        SensorDataTimingDataTable table = (SensorDataTimingDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0050_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getFramePeriod(), otherLines, 1);
        validateDoubleValue(table.getIntraFrameTime(), otherLines, 2);
        validateDoubleValue(table.getLinePeriod(), otherLines, 3);
        validateDoubleValue(table.getIntraLineTime(), otherLines, 4);
        assertEquals(otherLines.size(), 5);
    }
}
