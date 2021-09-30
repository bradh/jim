package com.sigmabravo.rnd.jim.npif.tables.targetinfo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class GeneralTargetInformationDataTableParserTest extends TestSupport {

    public GeneralTargetInformationDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0030.7023");
        assertTrue(dataTable instanceof GeneralTargetInformationDataTable);
        GeneralTargetInformationDataTable table = (GeneralTargetInformationDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0030_tables.csv");
        validateIntegerValue(table.getTargetNumber(), otherLines, 0);
        validateASCIIValue(table.getTargetTypeAsText(), otherLines, 1);
        validateASCIIValue(table.getTargetPriorityAsText(), otherLines, 2);
        validateASCIIValue(table.getBasicEncyclopaediaNumber(), otherLines, 3);
        validateASCIIValue(table.getTargetSecurityClassification(), otherLines, 4);
        validateDTGValue(table.getRequiredTimeOnTarget(), otherLines, 5);
        validateASCIIValue(table.getRequestedSensorTypeAsText(), otherLines, 6);
        validateASCIIValue(table.getRequestedSensorResponseBandAsText(), otherLines, 7);
        validateASCIIValue(table.getRequestedCollectionTechniqueAsText(), otherLines, 8);
        validateIntegerValue(table.getNumberOfLocations(), otherLines, 9);
        validateASCIIValue(table.getRequesterAddressIndexAsText(), otherLines, 10);
        validateASCIIValue(table.getTargetName(), otherLines, 11);
        assertEquals(otherLines.size(), 12);
    }
}
