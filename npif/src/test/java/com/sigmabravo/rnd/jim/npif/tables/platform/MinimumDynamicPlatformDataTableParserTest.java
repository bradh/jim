package com.sigmabravo.rnd.jim.npif.tables.platform;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.testng.annotations.Test;

public class MinimumDynamicPlatformDataTableParserTest extends TestSupport {

    public MinimumDynamicPlatformDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0052.7023");
        assertTrue(dataTable instanceof MinimumDynamicPlatformDataTable);
        MinimumDynamicPlatformDataTable table = (MinimumDynamicPlatformDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0052_tables.csv");
        // TODO: parse and verify platform ID
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

    protected void validatePositionIgnoringConfidence(
            Position position, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = getExpectedValueClean(lineParts);
        String[] valueParts = valueAsString.split(",");
        double expectedLatitudeInDegrees = Double.parseDouble(valueParts[0]);
        double expectedLongitudeInDegrees = Double.parseDouble(valueParts[1]);
        assertEquals(position.getLatitudeDegrees(), expectedLatitudeInDegrees, 0.000001);
        assertEquals(position.getLongitudeDegrees(), expectedLongitudeInDegrees, 0.000001);
    }

    protected void validateASCIIValueIgnoringConfidence(
            String asciiValue, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = getExpectedValueClean(lineParts);
        if (asciiValue.isBlank()) {
            asciiValue = "<NULL>";
        }
        assertEquals(asciiValue, valueAsString, "Mismatch at " + label);
    }

    private String getExpectedValueClean(String[] lineParts) {
        String valueAsString = lineParts[2].trim();
        for (String suffix :
                new String[] {",FULL SPECIFICATION", ",POSSIBLE FAILURE", ",DE-RATED", ",FAIL"}) {
            if (valueAsString.endsWith(suffix)) {
                valueAsString =
                        valueAsString.substring(0, valueAsString.length() - suffix.length());
                break;
            }
        }
        return valueAsString;
    }

    private void validateDTGValueIgnoringConfidence(
            ZonedDateTime zdtValue, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2].trim();
        System.out.println(valueAsString);
        if (valueAsString.equals("<NULL>")) {
            assertNull(zdtValue);
        } else if (valueAsString.endsWith(",FULL SPECIFICATION")) {
            valueAsString =
                    valueAsString.substring(
                            0, valueAsString.length() - ",FULL SPECIFICATION".length());
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("uuuu-MM-dd, HH:mm:ss.SSSSSS")
                            .withZone(ZoneOffset.UTC);
            ZonedDateTime expectedZdt = ZonedDateTime.parse(valueAsString, formatter);
            System.out.println(expectedZdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
            assertEquals(zdtValue, expectedZdt, "Mismatch at " + label);
        } else {
            fail();
        }
    }

    protected void validateDoubleValueIgnoringConfidence(
            double value, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = getExpectedValueClean(lineParts);
        if (valueAsString.equals("<NULL>")) {
            assertTrue(Double.isNaN(value));
        } else {
            double expectedDouble = Double.parseDouble(valueAsString);
            assertEquals(value, expectedDouble, 0.00000001, "Mismatch at " + label);
        }
    }
}
