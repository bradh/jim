package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class SensorIndexDataTableParserTest extends TestSupport {

    public SensorIndexDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0055.7023");
        assertTrue(dataTable instanceof SensorIndexDataTable);
        SensorIndexDataTable table = (SensorIndexDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0055_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getSegmentNumber(), otherLines, 1);
        validateIntegerValue(table.getEntries().size(), otherLines, 2);
        int i = 3;
        for (int entryNumber = 0; entryNumber < table.getEntries().size(); entryNumber++) {
            SensorIndexDataTableEntry entry = table.getEntries().get(entryNumber);
            validateDTGValueWithIndex(entry.getCollectionStartTime(), entryNumber, otherLines, i);
            i += 1;
            validateDTGValueWithIndex(entry.getCollectionStopTime(), entryNumber, otherLines, i);
            i += 1;
            validateLongValueWithIndex(entry.getStartHeaderTimeTag(), entryNumber, otherLines, i);
            i += 1;
            validateLongValueWithIndex(entry.getEndHeaderTimeTag(), entryNumber, otherLines, i);
            i += 1;
            validatePositionValueWithIndex(
                    entry.getAircraftLocationAtCollectionStartTime(), entryNumber, otherLines, i);
            i += 1;
            validatePositionValueWithIndex(
                    entry.getAircraftLocationAtCollectionEndTime(), entryNumber, otherLines, i);
            i += 1;
            validateLongValueWithIndex(entry.getSensorStartPosition(), entryNumber, otherLines, i);
            i += 1;
            validateLongValueWithIndex(entry.getSensorEndPosition(), entryNumber, otherLines, i);
            i += 1;
        }
        assertEquals(otherLines.size(), 3 + 8 * table.getEntries().size());
    }
}
