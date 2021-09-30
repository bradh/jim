package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class EventIndexDataTableParserTest extends TestSupport {

    public EventIndexDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0004.7023");
        assertTrue(dataTable instanceof EventIndexDataTable);
        EventIndexDataTable table = (EventIndexDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0004_tables.csv");
        validateIntegerValue(table.getSegmentNumber(), otherLines, 0);
        validateIntegerValue(table.getEventNumber(), otherLines, 1);
        validateASCIIValue(table.getEventTypeAsText(), otherLines, 2);
        validateIntegerValue(table.getTargetNumber(), otherLines, 3);
        validateIntegerValue(table.getTargetSubSection(), otherLines, 4);
        validateLongValue(table.getTimeTag(), otherLines, 5);
        validateDTGValue(table.getEventTime(), otherLines, 6);
        validatePositionValue(table.getAircraftGeoLocation(), otherLines, 7);
        validateIntegerValue(table.getPrimarySensorNumber(), otherLines, 8);
        validateIntegerValue(table.getSecondarySensorNumber(), otherLines, 9);
        validateIntegerValue(table.getThirdSensorNumber(), otherLines, 10);
        validateLongValue(table.getEventPositionInTheRecord(), otherLines, 11);
        validateASCIIValue(table.getEventName(), otherLines, 12);
        assertEquals(otherLines.size(), 13);
    }
}
