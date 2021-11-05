package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class SyncHierarchyAndImageBuildDataTableParserTest extends TestSupport {

    public SyncHierarchyAndImageBuildDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0049.7023");
        assertTrue(dataTable instanceof SyncHierarchyAndImageBuildDataTable);
        SyncHierarchyAndImageBuildDataTable table = (SyncHierarchyAndImageBuildDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0049_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getSuperFrameHierarchy(), otherLines, 1);
        validateIntegerValue(table.getFrameHierarchy(), otherLines, 2);
        validateIntegerValue(table.getFieldHierarchy(), otherLines, 3);
        validateIntegerValue(table.getSwathHierarchy(), otherLines, 4);
        validateIntegerValue(table.getTileHierarchy(), otherLines, 5);
        validateIntegerValue(table.getLineHierarchy(), otherLines, 6);
        validateASCIIValue(table.getBuildDirectionOfTileImageComponentsAsText(), otherLines, 7);
        validateASCIIValue(table.getFrameCoverageRelationshipAsText(), otherLines, 8);
        assertEquals(otherLines.size(), 9);
    }
}
