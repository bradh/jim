package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class ReferenceTrackDataTableParserTest extends TestSupport {

    public ReferenceTrackDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0014.7023");
        assertTrue(dataTable instanceof ReferenceTrackDataTable);
        ReferenceTrackDataTable table = (ReferenceTrackDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0014_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validatePositionValue(table.getSensorVirtualPositionGeoLocation(), otherLines, 1);
        validateDoubleValue(table.getSensorVirtualPositionMSLAltitude(), otherLines, 2);
        validateDoubleValue(table.getSensorVirtualPositionAGLAltitude(), otherLines, 3);
        validateDoubleValue(table.getSensorVirtualPositionGPSAltitude(), otherLines, 4);
        validateDoubleValue(table.getReferenceTrackNorth(), otherLines, 5);
        validateDoubleValue(table.getReferenceTrackEast(), otherLines, 6);
        validateDoubleValue(table.getReferenceTrackDown(), otherLines, 7);
        validateDoubleValue(table.getReferenceTrackSpeed(), otherLines, 8);
        assertEquals(otherLines.size(), 9);
    }
}
