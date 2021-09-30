package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class ISARTrackDataTableParserTest extends TestSupport {

    public ISARTrackDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0018.7023");
        assertTrue(dataTable instanceof ISARTrackDataTable);
        ISARTrackDataTable table = (ISARTrackDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0018_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getRoadCurvature(), otherLines, 1);
        validateDoubleValue(table.getRadialSpeedOfVehicle(), otherLines, 2);
        validateIntegerValue(table.getTrackID(), otherLines, 3);
        validateASCIIValue(table.getTrackTypeAsText(), otherLines, 4);
        validateASCIIValue(table.getDirectionOfRoadCurvatureAsText(), otherLines, 5);
        validateASCIIValue(table.getDirectionOfVehicleRadialVelocityAsText(), otherLines, 6);
        assertEquals(otherLines.size(), 7);
    }
}
