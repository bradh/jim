package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class S4607GMTIDataTableParserTest extends TestSupport {

    public S4607GMTIDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0024.7023");
        assertTrue(dataTable instanceof S4607GMTIDataTable);
        S4607GMTIDataTable table = (S4607GMTIDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0024_tables.csv");
        // TODO: extract sensor id
        byte[] expectedBytes = new byte[table.getHeader().getDataFileSize()];
        assertEquals(table.getData(), expectedBytes);
        assertEquals(otherLines.size(), 2);
    }
}
