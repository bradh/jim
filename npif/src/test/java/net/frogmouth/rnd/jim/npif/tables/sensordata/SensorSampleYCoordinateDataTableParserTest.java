package net.frogmouth.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SensorSampleYCoordinateDataTableParserTest extends TestSupport {

    public SensorSampleYCoordinateDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0021.7023");
        assertTrue(dataTable instanceof SensorSampleYCoordinateDataTable);
        SensorSampleYCoordinateDataTable table = (SensorSampleYCoordinateDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0021_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        byte[] expectedBytes = new byte[table.getHeader().getDataFileSize()];
        assertEquals(table.getSampleYCoordinate(), expectedBytes);
        assertEquals(otherLines.size(), 2);
    }
}
