package net.frogmouth.rnd.jim.npif.tables.platform;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class ComprehensiveDynamicPlatformDataTableParserTest extends PlatformTestSupport {

    public ComprehensiveDynamicPlatformDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0000.7023");
        assertTrue(dataTable instanceof ComprehensiveDynamicPlatformDataTable);
        ComprehensiveDynamicPlatformDataTable table =
                (ComprehensiveDynamicPlatformDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0000_tables.csv");
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
        validateDoubleValueIgnoringConfidence(table.getPlatformVelocityNorth(), otherLines, 13);
        validateDoubleValueIgnoringConfidence(table.getPlatformVelocityEast(), otherLines, 14);
        validateDoubleValueIgnoringConfidence(table.getPlatformVelocityDown(), otherLines, 15);
        validateDoubleValueIgnoringConfidence(table.getPlatformAccelerationNorth(), otherLines, 16);
        validateDoubleValueIgnoringConfidence(table.getPlatformAccelerationEast(), otherLines, 17);
        validateDoubleValueIgnoringConfidence(table.getPlatformAccelerationDown(), otherLines, 18);
        validateDoubleValueIgnoringConfidence(
                table.getPlatformHeadingRateDegrees(), otherLines, 19);
        validateDoubleValueIgnoringConfidence(table.getPlatformPitchRateDegrees(), otherLines, 20);
        validateDoubleValueIgnoringConfidence(table.getPlatformRollRateDegrees(), otherLines, 21);
        validateDoubleValueIgnoringConfidence(table.getPlatformYawRateDegrees(), otherLines, 22);
        validateDoubleValueIgnoringConfidence(
                table.getPlatformHeadingAngularAccelerationDegrees(), otherLines, 23);
        validateDoubleValueIgnoringConfidence(
                table.getPlatformPitchAngularAccelerationDegrees(), otherLines, 24);
        validateDoubleValueIgnoringConfidence(
                table.getPlatformRollAngularAccelerationDegrees(), otherLines, 25);
        validateDoubleValueIgnoringConfidence(
                table.getPlatformYawAngularAccelerationDegrees(), otherLines, 26);
        validateDoubleValueIgnoringConfidence(table.getVelocityToHeightRatio(), otherLines, 27);
        // TODO: get and process navigation confidence
        assertEquals(otherLines.size(), 28);
    }
}
