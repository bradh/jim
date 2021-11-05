package net.frogmouth.rnd.jim.npif.tables.missiondata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class CollectionPlatformIdentificationDataTableTest extends TestSupport {

    public CollectionPlatformIdentificationDataTableTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0037.7023");
        assertTrue(dataTable instanceof CollectionPlatformIdentificationDataTable);
        CollectionPlatformIdentificationDataTable table =
                (CollectionPlatformIdentificationDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0037_tables.csv");
        validateASCIIValue(table.getSquadron(), otherLines, 0);
        validateASCIIValue(table.getWing(), otherLines, 1);
        validateASCIIValue(table.getAircraftType(), otherLines, 2);
        validateASCIIValue(table.getAircraftTailNumber(), otherLines, 3);
        validateIntegerValue(table.getSortieNumber(), otherLines, 4);
        validateASCIIValue(table.getPilotID(), otherLines, 5);
        assertEquals(otherLines.size(), 6);
    }
}
