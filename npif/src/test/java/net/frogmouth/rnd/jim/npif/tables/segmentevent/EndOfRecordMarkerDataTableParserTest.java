package net.frogmouth.rnd.jim.npif.tables.segmentevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class EndOfRecordMarkerDataTableParserTest extends TestSupport {

    public EndOfRecordMarkerDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0056.7023");
        assertTrue(dataTable instanceof EndOfRecordMarkerDataTable);
        EndOfRecordMarkerDataTable table = (EndOfRecordMarkerDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0056_tables.csv");
        validateLongValue(table.getSizeOfRecord(), otherLines, 0);
        assertEquals(otherLines.size(), 1);
    }
}
