package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SensorIdentificationDataTableParserTest extends TestSupport {

    public SensorIdentificationDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0045.7023");
        assertTrue(dataTable instanceof SensorIdentificationDataTable);
        SensorIdentificationDataTable table = (SensorIdentificationDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0045_tables.csv");
        validateIntegerValue(table.getPlatformId(), otherLines, 0);
        validateIntegerValue(table.getSensorId(), otherLines, 1);
        validateASCIIValue(table.getSensorTypeAsText(), otherLines, 2);
        validateASCIIValue(table.getSensorSerialNumber(), otherLines, 3);
        validateASCIIValue(table.getSensorModelNumber(), otherLines, 4);
        validateASCIIValue(table.getSensorModellingMethodAsText(), otherLines, 5);
        validateIntegerValue(table.getNumberOfGimbals(), otherLines, 6);
        assertEquals(otherLines.size(), 7);
    }
}
