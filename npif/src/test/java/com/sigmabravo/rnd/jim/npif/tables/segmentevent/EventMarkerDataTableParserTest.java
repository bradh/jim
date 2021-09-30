package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class EventMarkerDataTableParserTest extends TestSupport {

    public EventMarkerDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0003.7023");
        assertTrue(dataTable instanceof EventMarkerDataTable);
        EventMarkerDataTable table = (EventMarkerDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0003_tables.csv");
        validateIntegerValue(table.getEventNumber(), otherLines, 0);
        validateASCIIValue(table.getEventTypeAsText(), otherLines, 1);
        validateIntegerValue(table.getPrimarySensorNumber(), otherLines, 2);
        validateIntegerValue(table.getSecondarySensorNumber(), otherLines, 3);
        validateIntegerValue(table.getThirdSensorNumber(), otherLines, 4);
        validateIntegerValue(table.getTargetNumber(), otherLines, 5);
        assertEquals(otherLines.size(), 6);
    }
}
