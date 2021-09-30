package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class ComprehensiveGimbalsAttitudeDataTableParserTest extends TestSupport {

    public ComprehensiveGimbalsAttitudeDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0009.7023");
        assertTrue(dataTable instanceof ComprehensiveGimbalsAttitudeDataTable);
        ComprehensiveGimbalsAttitudeDataTable table =
                (ComprehensiveGimbalsAttitudeDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0009_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getGimbalId(), otherLines, 1);
        validateDoubleValue(table.getRotationAboutZAxisDegrees(), otherLines, 2);
        validateDoubleValue(table.getRotationAboutYAxisDegrees(), otherLines, 3);
        validateDoubleValue(table.getRotationAboutXAxisDegrees(), otherLines, 4);
        validateDoubleValue(table.getRotationRateAboutZAxisDegrees(), otherLines, 5);
        validateDoubleValue(table.getRotationRateAboutYAxisDegrees(), otherLines, 6);
        validateDoubleValue(table.getRotationRateAboutXAxisDegrees(), otherLines, 7);
        validateDoubleValue(table.getRotationAccelerationAboutZAxisDegrees(), otherLines, 8);
        validateDoubleValue(table.getRotationAccelerationAboutYAxisDegrees(), otherLines, 9);
        validateDoubleValue(table.getRotationAccelerationAboutXAxisDegrees(), otherLines, 10);
        assertEquals(otherLines.size(), 11);
    }
}
