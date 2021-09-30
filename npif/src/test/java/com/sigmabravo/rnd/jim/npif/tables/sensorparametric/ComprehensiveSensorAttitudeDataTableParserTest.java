package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class ComprehensiveSensorAttitudeDataTableParserTest extends TestSupport {

    public ComprehensiveSensorAttitudeDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0007.7023");
        assertTrue(dataTable instanceof ComprehensiveSensorAttitudeDataTable);
        ComprehensiveSensorAttitudeDataTable table =
                (ComprehensiveSensorAttitudeDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0007_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getRotationAboutZAxisDegrees(), otherLines, 1);
        validateDoubleValue(table.getRotationAboutYAxisDegrees(), otherLines, 2);
        validateDoubleValue(table.getRotationAboutXAxisDegrees(), otherLines, 3);
        validateDoubleValue(table.getRotationRateAboutZAxisDegrees(), otherLines, 4);
        validateDoubleValue(table.getRotationRateAboutYAxisDegrees(), otherLines, 5);
        validateDoubleValue(table.getRotationRateAboutXAxisDegrees(), otherLines, 6);
        validateDoubleValue(table.getRotationAccelerationAboutZAxisDegrees(), otherLines, 7);
        validateDoubleValue(table.getRotationAccelerationAboutYAxisDegrees(), otherLines, 8);
        validateDoubleValue(table.getRotationAccelerationAboutXAxisDegrees(), otherLines, 9);
        assertEquals(otherLines.size(), 10);
    }
}
