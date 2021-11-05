package net.frogmouth.rnd.jim.npif.tables.formatdescription;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class FormatTimeTagDataTableParserTest extends TestSupport {

    public FormatTimeTagDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0029.7023");
        assertTrue(dataTable instanceof FormatTimeTagDataTable);
        FormatTimeTagDataTable table = (FormatTimeTagDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0029_tables.csv");
        validateDoubleValue(table.getTimeTagIncrements(), otherLines, 0);
        assertEquals(otherLines.size(), 1);
    }
}
