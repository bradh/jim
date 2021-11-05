package net.frogmouth.rnd.jim.npif.tables.segmentevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class EndOfSegmentMarkerDataTableParserTest extends TestSupport {

    public EndOfSegmentMarkerDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0051.7023");
        assertTrue(dataTable instanceof EndOfSegmentMarkerDataTable);
        EndOfSegmentMarkerDataTable table = (EndOfSegmentMarkerDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0051_tables.csv");
        validateLongValue(table.getSizeOfSegment(), otherLines, 0);
        assertEquals(otherLines.size(), 1);
    }
}
