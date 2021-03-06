package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class GeneralTargetLocationDataTableParserTest extends TestSupport {

    public GeneralTargetLocationDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0032.7023");
        assertTrue(dataTable instanceof GeneralTargetLocationDataTable);
        GeneralTargetLocationDataTable table = (GeneralTargetLocationDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0032_tables.csv");
        validateIntegerValue(table.getTargetNumber(), otherLines, 0);
        validateIntegerValue(table.getLocationNumber(), otherLines, 1);
        validateASCIIValue(table.getStartTargetOrCornerLocation().asText(), otherLines, 2);
        validateDoubleValue(table.getStartTargetOrCornerElevation(), otherLines, 3);
        validateDoubleValue(table.getTargetDiameterOrWidth(), otherLines, 4);
        validateASCIIValue(table.getMapSeries(), otherLines, 5);
        validateASCIIValue(table.getSheetNumberOfTargetLocation(), otherLines, 6);
        validateDoubleValue(table.getInverseMapScale(), otherLines, 7);
        validateIntegerValue(table.getMapEditionNumber(), otherLines, 8);
        validateDTGValue(table.getMapEditionDate(), otherLines, 9);
        assertEquals(otherLines.size(), 10);
    }
}
