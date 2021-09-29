package com.sigmabravo.rnd.jim.npif.tables.missiondata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class MissionSecurityDataTableParserTest extends TestSupport {

    public MissionSecurityDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0035.7023");
        assertTrue(dataTable instanceof MissionSecurityDataTable);
        MissionSecurityDataTable table = (MissionSecurityDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0035_tables.csv");
        validateASCIIValue(table.getMissionSecurityClassification(), otherLines, 0);
        validateDTGValue(table.getDate(), otherLines, 1);
        validateASCIIValue(table.getAuthority(), otherLines, 2);
        validateASCIIValue(table.getDowngradingInstructions(), otherLines, 3);
        assertEquals(otherLines.size(), 4);
    }
}
