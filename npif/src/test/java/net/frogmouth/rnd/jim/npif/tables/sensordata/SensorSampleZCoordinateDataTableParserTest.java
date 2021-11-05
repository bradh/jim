package net.frogmouth.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SensorSampleZCoordinateDataTableParserTest extends TestSupport {

    public SensorSampleZCoordinateDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0022.7023");
        assertTrue(dataTable instanceof SensorSampleZCoordinateDataTable);
        SensorSampleZCoordinateDataTable table = (SensorSampleZCoordinateDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0022_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        byte[] expectedBytes = new byte[table.getHeader().getDataFileSize()];
        assertEquals(table.getSampleZCoordinate(), expectedBytes);
        assertEquals(otherLines.size(), 2);
    }
}
