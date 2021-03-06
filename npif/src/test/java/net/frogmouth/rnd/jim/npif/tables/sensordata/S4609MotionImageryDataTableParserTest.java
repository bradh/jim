package net.frogmouth.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class S4609MotionImageryDataTableParserTest extends TestSupport {

    public S4609MotionImageryDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0025.7023");
        assertTrue(dataTable instanceof S4609MotionImageryDataTable);
        S4609MotionImageryDataTable table = (S4609MotionImageryDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0025_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        byte[] expectedBytes = new byte[table.getHeader().getDataFileSize()];
        assertEquals(table.getData(), expectedBytes);
        assertEquals(otherLines.size(), 2);
    }
}
