package com.sigmabravo.rnd.jim.npif.tables.targetinfo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class GeneralTargetRemarksDataTableParserTest extends TestSupport {

    public GeneralTargetRemarksDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0033.7023");
        assertTrue(dataTable instanceof GeneralTargetRemarksDataTable);
        GeneralTargetRemarksDataTable table = (GeneralTargetRemarksDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0033_tables.csv");
        validateIntegerValue(table.getTargetNumber(), otherLines, 0);
        validateIntegerValue(table.getLocationNumber(), otherLines, 1);
        validateASCIIValue(table.getRemarks(), otherLines, 2);
        assertEquals(otherLines.size(), 3);
    }
}
