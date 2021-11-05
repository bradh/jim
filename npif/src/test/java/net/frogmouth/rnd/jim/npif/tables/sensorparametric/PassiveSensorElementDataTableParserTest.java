package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class PassiveSensorElementDataTableParserTest extends TestSupport {

    public PassiveSensorElementDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0040.7023");
        assertTrue(dataTable instanceof PassiveSensorElementDataTable);
        PassiveSensorElementDataTable table = (PassiveSensorElementDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0040_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getEntries().size(), otherLines, 1);
        int i = 2;
        for (int entryNumber = 0; entryNumber < table.getEntries().size(); entryNumber++) {
            PassiveSensorElementDataTableEntry entry = table.getEntries().get(entryNumber);
            validateIntegerValueWithIndex(entry.getElementSize(), entryNumber, otherLines, i);
            i += 1;
            validateIntegerValueWithIndex(entry.getElementBitOffset(), entryNumber, otherLines, i);
            i += 1;
            validateIntegerValueWithIndex(entry.getSensorElementID(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(entry.getMinimumWavelength(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(entry.getMaximumWavelength(), entryNumber, otherLines, i);
            i += 1;
        }
        assertEquals(otherLines.size(), 2 + table.getEntries().size() * 5);
    }
}
