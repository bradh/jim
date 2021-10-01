package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class SensorCalibrationDataTableParserTest extends TestSupport {

    public SensorCalibrationDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0046.7023");
        assertTrue(dataTable instanceof SensorCalibrationDataTable);
        SensorCalibrationDataTable table = (SensorCalibrationDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0046_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDTGValue(table.getCalibrationDate(), otherLines, 1);
        validateASCIIValue(table.getCalibrationAgency(), otherLines, 2);
        assertEquals(otherLines.size(), 3);
    }
}
