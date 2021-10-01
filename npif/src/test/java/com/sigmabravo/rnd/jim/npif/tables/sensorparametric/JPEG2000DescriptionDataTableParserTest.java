package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class JPEG2000DescriptionDataTableParserTest extends TestSupport {

    public JPEG2000DescriptionDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0027.7023");
        assertTrue(dataTable instanceof JPEG2000DescriptionDataTable);
        JPEG2000DescriptionDataTable table = (JPEG2000DescriptionDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0027_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateASCIIValue(table.getCodestreamCapabilityAsText(), otherLines, 1);
        validateASCIIValue(table.getProgressionOrderAsText(), otherLines, 2);
        validateIntegerValue(table.getNumberOfDecompositionLevels(), otherLines, 3);
        validateIntegerValue(table.getNumberOfLayers(), otherLines, 4);
        validateIntegerValue(table.getNumberOfComponents(), otherLines, 5);
        validateASCIIValue(table.getJpeg2000TilingPerformedAsText(), otherLines, 6);
        validateASCIIValue(table.getIrepAsText(), otherLines, 7);
        assertEquals(otherLines.size(), 8);
    }
}
