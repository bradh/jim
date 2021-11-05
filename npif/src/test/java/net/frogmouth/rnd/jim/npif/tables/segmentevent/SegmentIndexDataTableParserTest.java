package net.frogmouth.rnd.jim.npif.tables.segmentevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SegmentIndexDataTableParserTest extends TestSupport {

    public SegmentIndexDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0054.7023");
        assertTrue(dataTable instanceof SegmentIndexDataTable);
        SegmentIndexDataTable table = (SegmentIndexDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0054_tables.csv");
        validateIntegerValue(table.getSegmentNumber(), otherLines, 0);
        validateLongValue(table.getStartOfDataSegment(), otherLines, 1);
        validateLongValue(table.getEndOfDataSegment(), otherLines, 2);
        validateDTGValue(table.getStartTimeOfRecording(), otherLines, 3);
        validateDTGValue(table.getStopTimeOfRecording(), otherLines, 4);
        validateLongValue(table.getStartOfHeaderTimeTag(), otherLines, 5);
        validateLongValue(table.getEndOfHeaderTimeTag(), otherLines, 6);
        validatePositionValue(
                table.getAircraftLocationAtTheStartOfRecordingOfTheSegment(), otherLines, 7);
        validatePositionValue(
                table.getAircraftLocationAtTheEndOfRecordingOfTheSegment(), otherLines, 8);
        assertEquals(otherLines.size(), 9);
    }
}
