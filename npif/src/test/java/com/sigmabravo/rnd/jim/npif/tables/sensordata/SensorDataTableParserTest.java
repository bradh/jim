package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class SensorDataTableParserTest extends TestSupport {

    public SensorDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0053.7023");
        assertTrue(dataTable instanceof SensorDataTable);
        SensorDataTable table = (SensorDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0053_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        byte[] expectedBytes = new byte[table.getHeader().getDataFileSize()];
        int offset = 64;
        for (int i = 0x17; i >= 0; i--) {
            expectedBytes[offset] = (byte) i;
            offset += 1;
        }
        for (int i = 0xFF; i >= 0; i--) {
            expectedBytes[offset] = (byte) i;
            offset += 1;
        }
        for (int i = 0xFF; i >= 4; i--) {
            expectedBytes[offset] = (byte) i;
            offset += 1;
        }
        offset += 8;
        for (int i = 0x04; i <= 0xFF; i++) {
            expectedBytes[offset] = (byte) i;
            offset += 1;
        }
        for (int i = 0x00; i <= 0xFF; i++) {
            expectedBytes[offset] = (byte) i;
            offset += 1;
        }
        for (int i = 0x00; i <= 0x57; i++) {
            expectedBytes[offset] = (byte) i;
            offset += 1;
        }
        assertEquals(table.getSensorData(), expectedBytes);
        assertEquals(otherLines.size(), 2);
    }
}
