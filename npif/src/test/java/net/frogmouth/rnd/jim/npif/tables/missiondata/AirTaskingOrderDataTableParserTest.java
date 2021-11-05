package net.frogmouth.rnd.jim.npif.tables.missiondata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class AirTaskingOrderDataTableParserTest extends TestSupport {

    public AirTaskingOrderDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0036.7023");
        assertTrue(dataTable instanceof AirTaskingOrderDataTable);
        AirTaskingOrderDataTable table = (AirTaskingOrderDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0036_tables.csv");
        validateASCIIValue(table.getAirTaskingOrderTitle(), otherLines, 0);
        validateASCIIValue(table.getAirTaskingOrderOriginator(), otherLines, 1);
        validateASCIIValue(table.getAirTaskingOrderSerial(), otherLines, 2);
        validateDTGValue(table.getDateTimeGroup(), otherLines, 3);
        validateASCIIValue(table.getQualifier(), otherLines, 4);
        validateIntegerValue(table.getQualifierSerialNumber(), otherLines, 5);
        assertEquals(otherLines.size(), 6);
    }
}
