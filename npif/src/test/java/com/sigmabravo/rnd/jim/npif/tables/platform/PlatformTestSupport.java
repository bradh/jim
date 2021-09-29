package com.sigmabravo.rnd.jim.npif.tables.platform;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PlatformTestSupport extends TestSupport {

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

    protected String getExpectedValueClean(String[] lineParts) {
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

    protected void validateDTGValueIgnoringConfidence(
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
