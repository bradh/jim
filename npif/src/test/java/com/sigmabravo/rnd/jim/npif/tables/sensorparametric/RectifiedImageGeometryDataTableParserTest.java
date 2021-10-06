package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.TestSupport;
import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class RectifiedImageGeometryDataTableParserTest extends TestSupport {

    public RectifiedImageGeometryDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0015.7023");
        assertTrue(dataTable instanceof RectifiedImageGeometryDataTable);
        RectifiedImageGeometryDataTable table = (RectifiedImageGeometryDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0015_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateDoubleValue(table.getAxx(), otherLines, 1);
        validateDoubleValue(table.getAxy(), otherLines, 2);
        validateDoubleValue(table.getAyx(), otherLines, 3);
        validateDoubleValue(table.getAyy(), otherLines, 4);
        validateDoubleValue(table.getCx(), otherLines, 5);
        validateDoubleValue(table.getCy(), otherLines, 6);
        validateDoubleValue(table.getData1(), otherLines, 7);
        validateDoubleValue(table.getData2(), otherLines, 8);
        validateDoubleValue(table.getData3(), otherLines, 9);
        validateDoubleValue(table.getData4(), otherLines, 10);
        validateDoubleValue(table.getData5(), otherLines, 11);
        validateDoubleValue(table.getData6(), otherLines, 12);
        validateDoubleValue(table.getData7(), otherLines, 13);
        validateDoubleValue(table.getData8(), otherLines, 14);
        validateDoubleValue(table.getData9(), otherLines, 15);
        validateDoubleValue(table.getData10(), otherLines, 16);
        validateDoubleValue(table.getData11(), otherLines, 17);
        validateDoubleValue(table.getData12(), otherLines, 18);
        validateDoubleValue(table.getData13(), otherLines, 19);
        validateDoubleValue(table.getData14(), otherLines, 20);
        validateDoubleValue(table.getData15(), otherLines, 21);
        validateDoubleValue(table.getData16(), otherLines, 22);
        validateDoubleValue(table.getData17(), otherLines, 23);
        validateDoubleValue(table.getData18(), otherLines, 24);
        validateDoubleValue(table.getData19(), otherLines, 25);
        validateDoubleValue(table.getData20(), otherLines, 26);
        validateDoubleValue(table.getNearRangePointDepressionAngleDegrees(), otherLines, 27);
        validateDoubleValue(table.getFarRangePointDepressionAngleDegrees(), otherLines, 28);
        validateASCIIValue(table.getProjectionTypeAsText(), otherLines, 29);
        validateASCIIValue(table.getTerrainModelAsText(), otherLines, 30);
        assertEquals(otherLines.size(), 31);
    }
}
