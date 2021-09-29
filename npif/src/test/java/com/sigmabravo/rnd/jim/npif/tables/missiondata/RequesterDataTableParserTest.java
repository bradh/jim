package com.sigmabravo.rnd.jim.npif.tables.missiondata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class RequesterDataTableParserTest extends TestSupport {

    public RequesterDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0038.7023");
        assertTrue(dataTable instanceof RequesterDataTable);
        RequesterDataTable table = (RequesterDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0038_tables.csv");
        // TODO: extract and test requester id.
        validateASCIIValue(table.getReportMessageTypeAsText(), otherLines, 1);
        validateASCIIValue(table.getMessageCommunicationsChannel(), otherLines, 2);
        validateASCIIValue(table.getSecondaryImageryDisseminationChannel(), otherLines, 3);
        validateDTGValue(table.getLtoiv(), otherLines, 4);
        validateASCIIValue(table.getRequesterSerialNumber(), otherLines, 5);
        validateASCIIValue(table.getMissionPriorityAsText(), otherLines, 6);
        validateASCIIValue(table.getRequesterAddress(), otherLines, 7);
        validateASCIIValue(table.getRequesterTypeAsText(), otherLines, 8);
        validateASCIIValue(table.getOperationCodeword(), otherLines, 9);
        validateASCIIValue(table.getOperationPlanOriginatorAndNumber(), otherLines, 10);
        validateASCIIValue(table.getOperationOptionNamePrimary(), otherLines, 11);
        validateASCIIValue(table.getOperationOptionNameSecondary(), otherLines, 12);
        validateASCIIValue(table.getExerciseNickname(), otherLines, 13);
        validateASCIIValue(table.getMessageAdditionalIdentifier(), otherLines, 14);
        assertEquals(otherLines.size(), 15);
    }
}
