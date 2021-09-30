package com.sigmabravo.rnd.jim.npif.tables.platform;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class MinimumDynamicPlatformDataTableParserTest extends PlatformTestSupport {

    public MinimumDynamicPlatformDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0052.7023");
        assertTrue(dataTable instanceof MinimumDynamicPlatformDataTable);
        MinimumDynamicPlatformDataTable table = (MinimumDynamicPlatformDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0052_tables.csv");
        this.validateIntegerValue(table.getPlatformId(), otherLines, 0);
        validateDTGValueIgnoringConfidence(table.getPlatformTime(), otherLines, 1);
        validatePositionIgnoringConfidence(table.getPlatformGeoLocation(), otherLines, 2);
        validateDoubleValueIgnoringConfidence(table.getMslAltitude(), otherLines, 3);
        validateDoubleValueIgnoringConfidence(table.getAglAltitude(), otherLines, 4);
        validateDoubleValueIgnoringConfidence(table.getGpsAltitude(), otherLines, 5);
        validateDoubleValueIgnoringConfidence(table.getPlatformTrueAirspeed(), otherLines, 6);
        validateDoubleValueIgnoringConfidence(table.getPlatformGroundSpeed(), otherLines, 7);
        validateDoubleValueIgnoringConfidence(table.getPlatformTrueCourseDegrees(), otherLines, 8);
        validateDoubleValueIgnoringConfidence(table.getPlatformTrueHeadingDegrees(), otherLines, 9);
        validateDoubleValueIgnoringConfidence(table.getPlatformPitchDegrees(), otherLines, 10);
        validateDoubleValueIgnoringConfidence(table.getPlatformRollDegrees(), otherLines, 11);
        validateDoubleValueIgnoringConfidence(table.getPlatformYawDegrees(), otherLines, 12);
        // TODO: get and process navigation confidence
        assertEquals(otherLines.size(), 13);
    }
}
