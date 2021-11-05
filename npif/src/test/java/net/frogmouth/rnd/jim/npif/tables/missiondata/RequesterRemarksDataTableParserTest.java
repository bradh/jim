package net.frogmouth.rnd.jim.npif.tables.missiondata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class RequesterRemarksDataTableParserTest extends TestSupport {

    public RequesterRemarksDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0039.7023");
        assertTrue(dataTable instanceof RequesterRemarksDataTable);
        RequesterRemarksDataTable table = (RequesterRemarksDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0039_tables.csv");
        validateIntegerValue(table.getRequesterId(), otherLines, 0);
        validateASCIIValue(table.getRemarks(), otherLines, 1);
        assertEquals(otherLines.size(), 2);
    }
}
