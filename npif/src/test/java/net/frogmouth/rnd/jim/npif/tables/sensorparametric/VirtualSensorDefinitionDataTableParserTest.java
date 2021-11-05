package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class VirtualSensorDefinitionDataTableParserTest extends TestSupport {

    public VirtualSensorDefinitionDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0016.7023");
        assertTrue(dataTable instanceof VirtualSensorDefinitionDataTable);
        VirtualSensorDefinitionDataTable table = (VirtualSensorDefinitionDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0016_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getTransmitPhaseDifference(), otherLines, 1);
        validateDoubleValue(table.getReceivePhaseDifference(), otherLines, 2);
        validateASCIIValue(table.getTransmitAntenna1SensorNumberAsText(), otherLines, 3);
        validateASCIIValue(table.getTransmitAntenna2SensorNumberAsText(), otherLines, 4);
        validateASCIIValue(table.getReceiveAntenna1SensorNumberAsText(), otherLines, 5);
        validateASCIIValue(table.getReceiveAntenna2SensorNumberAsText(), otherLines, 6);
        validateASCIIValue(table.getCombinationOperationAsText(), otherLines, 7);
        assertEquals(otherLines.size(), 8);
    }
}
