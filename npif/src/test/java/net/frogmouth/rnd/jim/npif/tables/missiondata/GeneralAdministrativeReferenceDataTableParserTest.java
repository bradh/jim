package net.frogmouth.rnd.jim.npif.tables.missiondata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class GeneralAdministrativeReferenceDataTableParserTest extends TestSupport {

    public GeneralAdministrativeReferenceDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0034.7023");
        assertTrue(dataTable instanceof GeneralAdministrativeReferenceDataTable);
        GeneralAdministrativeReferenceDataTable table =
                (GeneralAdministrativeReferenceDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0034_tables.csv");
        validateASCIIValue(table.getMissionNumber(), otherLines, 0);
        validateDTGValue(table.getMissionStartTime(), otherLines, 1);
        validateASCIIValue(table.getProjectIdentifierCode(), otherLines, 2);
        validateIntegerValue(table.getNumberOfTargets(), otherLines, 3);
        validateIntegerValue(table.getNumberOfRequesters(), otherLines, 4);
        assertEquals(otherLines.size(), 5);
    }
}
