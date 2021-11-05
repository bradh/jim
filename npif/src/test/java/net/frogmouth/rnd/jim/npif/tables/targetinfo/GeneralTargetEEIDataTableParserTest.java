package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class GeneralTargetEEIDataTableParserTest extends TestSupport {

    public GeneralTargetEEIDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0031.7023");
        assertTrue(dataTable instanceof GeneralTargetEEIDataTable);
        GeneralTargetEEIDataTable table = (GeneralTargetEEIDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0031_tables.csv");
        validateIntegerValue(table.getTargetNumber(), otherLines, 0);
        validateIntegerValue(table.getLocationNumber(), otherLines, 1);
        validateASCIIValue(table.getTargetCategoryEssentialElementsOfInformation(), otherLines, 2);
        validateASCIIValue(table.getEeiTargetCategoryDesignationSchemeAsText(), otherLines, 3);
        validateASCIIValue(table.getWeatherOverTheTargetReportingCode(), otherLines, 4);
        assertEquals(otherLines.size(), 5);
    }
}
