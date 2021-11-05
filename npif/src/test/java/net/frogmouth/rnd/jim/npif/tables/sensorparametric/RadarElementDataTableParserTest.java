package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.npif.TestSupport;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import org.testng.annotations.Test;

public class RadarElementDataTableParserTest extends TestSupport {

    public RadarElementDataTableParserTest() {}

    @Test
    public void parseSingle() throws IOException, Exception {
        DataTable dataTable = parseDataTable("test_table_0019.7023");
        assertTrue(dataTable instanceof RadarElementDataTable);
        RadarElementDataTable table = (RadarElementDataTable) dataTable;
        List<String> otherLines = parseAndValidateHeader(table, "test_table_0019_tables.csv");
        validateIntegerValue(table.getSensorId(), otherLines, 0);
        validateIntegerValue(table.getEntries().size(), otherLines, 1);
        int i = 2;
        for (int entryNumber = 0; entryNumber < table.getEntries().size(); entryNumber++) {
            RadarElementDataTableEntry entry = table.getEntries().get(entryNumber);
            validateIntegerValueWithIndex(entry.getElementSize(), entryNumber, otherLines, i);
            i += 1;
            validateIntegerValueWithIndex(entry.getElementBitOffset(), entryNumber, otherLines, i);
            i += 1;
            validateIntegerValueWithIndex(entry.getSensorElementID(), entryNumber, otherLines, i);
            i += 1;
            validateASCIIValueWithIndex(entry.getTypeOfElementAsText(), entryNumber, otherLines, i);
            i += 1;
            validateASCIIValueWithIndex(
                    entry.getPhysicalCharacteristicAsText(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(entry.getRfCentreFrequency(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(entry.getRfBandwidth(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(
                    entry.getMeanDopplerFrequency(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(
                    entry.getLookCentreFrequency(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(entry.getLookBandwidth(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(
                    entry.getMinimumElementValue(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(
                    entry.getMaximumElementValue(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(
                    entry.getMinimumPhysicalValue(), entryNumber, otherLines, i);
            i += 1;
            validateDoubleValueWithIndex(
                    entry.getMaximumPhysicalValue(), entryNumber, otherLines, i);
            i += 1;
            validateASCIIValueWithIndex(entry.getPolarisationAsText(), entryNumber, otherLines, i);
            i += 1;
            validateASCIIValueWithIndex(entry.getUseOfElementAsText(), entryNumber, otherLines, i);
            i += 1;
            validateASCIIValueWithIndex(
                    entry.getTransferFunctionTypeAsText(), entryNumber, otherLines, i);
            i += 1;
        }
        assertEquals(otherLines.size(), 2 + 17 * table.getEntries().size());
    }
}
