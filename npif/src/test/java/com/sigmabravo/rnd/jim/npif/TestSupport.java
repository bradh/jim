package com.sigmabravo.rnd.jim.npif;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/** Shared test support code. */
public class TestSupport {

    public TestSupport() {}

    Path getValidFile() {
        String fileName = "test.7023";
        return getPathFromResourceName(fileName);
    }

    Path getValidFileSingle() {
        String fileName = "test_single.7023";
        return getPathFromResourceName(fileName);
    }

    Path getFileNoSync() {
        String fileName = "test2.7023";
        return getPathFromResourceName(fileName);
    }

    Path getValidFileSyncOffset() {
        String fileName = "test3.7023";
        return getPathFromResourceName(fileName);
    }

    Path getGoldenFile(String file) {
        String fileName = "goldenfiles/" + file + ".7023";
        return getPathFromResourceName(fileName);
    }

    protected Path getPathFromResourceName(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName).getPath());
    }

    protected File getFileFromResourceName(String fileName) {
        return getPathFromResourceName(fileName).toFile();
    }

    protected boolean intToBoolean(String v) {
        int i = Integer.parseInt(v);
        return i == 1;
    }

    protected int lookupSyncType(String syncAsText) throws Exception {
        switch (syncAsText) {
            case "INACTIVE":
                return 0;
            case "SUPER FRAME SYNC":
                return 1;
            case "FRAME SYNC":
                return 2;
            case "FIELD SYNC":
                return 4;
            case "SWATH SYNC":
                return 8;
            case "LINE SYNC":
                return 10;
            case "TILE SYNC":
                return 12;
            default:
                throw new Exception("Truth data looks broken");
        }
    }

    protected List<String> parseAndValidateHeader(DataTable dataTable, String groundTruthFile)
            throws Exception, NumberFormatException, IOException {
        List<String> lines = new ArrayList<>();
        try (final BufferedReader br =
                new BufferedReader(new FileReader(this.getFileFromResourceName(groundTruthFile)))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        String headerLine = lines.get(4);
        // System.out.println(headerLine);
        String[] headerLineParts = headerLine.split(",");
        assertEquals(dataTable.getSourceFile(), headerLineParts[1].trim());
        assertEquals(dataTable.getName(), headerLineParts[2].trim());
        assertEquals(
                dataTable.getHeader().getEditionNumber(),
                Integer.parseInt(headerLineParts[13].trim()));
        assertEquals(
                dataTable.getHeader().isCompressionFlag(), intToBoolean(headerLineParts[5].trim()));
        assertEquals(dataTable.getHeader().isCrcFlag(), intToBoolean(headerLineParts[6].trim()));
        assertEquals(dataTable.getHeader().isAmbleFlag(), intToBoolean(headerLineParts[7].trim()));
        assertEquals(
                dataTable.getHeader().getSegmentNumber(),
                Integer.parseInt(headerLineParts[9].trim()));
        assertEquals(
                dataTable.getHeader().getSourceAddress(),
                Integer.parseInt(headerLineParts[3].trim()));
        assertEquals(
                dataTable.getHeader().getDataFileAddress(),
                Integer.parseInt(headerLineParts[4].trim()));
        assertEquals(
                dataTable.getHeader().getDataFileSize(),
                Integer.parseInt(headerLineParts[8].trim()));
        assertEquals(
                dataTable.getHeader().getDataFileNumber(),
                Integer.parseInt(headerLineParts[10].trim()));
        assertEquals(
                dataTable.getHeader().getTimeTag(), Integer.parseInt(headerLineParts[11].trim()));
        assertEquals(
                dataTable.getHeader().getSyncType(), lookupSyncType(headerLineParts[12].trim()));
        List<String> otherLines = new ArrayList<>();
        for (int i = 5; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!line.isBlank()) {
                otherLines.add(lines.get(i));
            }
        }
        return otherLines;
    }

    protected DataTable parseDataTable(String testFile) throws IOException {
        Reader reader = new Reader(this.getPathFromResourceName(testFile));
        assertNotNull(reader);
        assertEquals(reader.getTableTables().size(), 1);
        DataTable dataTable = reader.getTableTables().get(0);
        return dataTable;
    }

    protected void validateASCIIValue(String asciiValue, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2].trim();
        if (asciiValue.isBlank()) {
            asciiValue = "<NULL>";
        }
        assertEquals(asciiValue, valueAsString, "Mismatch at " + label);
    }

    protected void validateASCIIValueWithIndex(
            String asciiValue, int index, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 4);
        String label = lineParts[1];
        String indexAsFormattedString = lineParts[2].trim();
        assertEquals(String.format("[%d]", index), indexAsFormattedString);
        String valueAsString = lineParts[3].trim();
        if (asciiValue.isBlank()) {
            asciiValue = "<NULL>";
        }
        assertEquals(asciiValue, valueAsString, "Mismatch at " + label);
    }

    protected void validateDTGValue(ZonedDateTime zdtValue, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2].trim();
        if (valueAsString.equals("<NULL>")) {
            assertNull(zdtValue);
        } else {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("uuuu-MM-dd, HH:mm:ss.SSSSSS")
                            .withZone(ZoneOffset.UTC);
            ZonedDateTime expectedZdt = ZonedDateTime.parse(valueAsString, formatter);
            assertEquals(zdtValue, expectedZdt, "Mismatch at " + label);
        }
    }

    protected void validateDTGValueWithIndex(
            ZonedDateTime zdtValue, int index, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 4);
        String label = lineParts[1];
        String indexAsFormattedString = lineParts[2].trim();
        assertEquals(String.format("[%d]", index), indexAsFormattedString);
        String valueAsString = lineParts[3].trim();
        if (valueAsString.equals("<NULL>")) {
            assertNull(zdtValue);
        } else {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("uuuu-MM-dd, HH:mm:ss.SSSSSS")
                            .withZone(ZoneOffset.UTC);
            ZonedDateTime expectedZdt = ZonedDateTime.parse(valueAsString, formatter);
            assertEquals(zdtValue, expectedZdt, "Mismatch at " + label);
        }
    }

    protected void validateIntegerValue(int value, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2].trim();
        int expectedInteger = Integer.parseInt(valueAsString);
        assertEquals(value, expectedInteger, "Mismatch at " + label);
    }

    protected void validateIntegerValueWithIndex(
            int value, int index, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 4);
        String label = lineParts[1];
        String indexAsFormattedString = lineParts[2].trim();
        String valueAsString = lineParts[3].trim();
        assertEquals(String.format("[%d]", index), indexAsFormattedString);
        int expectedInteger = Integer.parseInt(valueAsString);
        assertEquals(value, expectedInteger, "Mismatch at " + label);
    }

    protected void validateLongValue(long value, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2].trim();
        long expectedInteger = Long.parseLong(valueAsString);
        assertEquals(value, expectedInteger, "Mismatch at " + label);
    }

    protected void validateLongValueWithIndex(
            long value, int index, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 4);
        String label = lineParts[1];
        String indexAsFormattedString = lineParts[2].trim();
        String valueAsString = lineParts[3].trim();
        assertEquals(String.format("[%d]", index), indexAsFormattedString);
        long expectedInteger = Long.parseLong(valueAsString);
        assertEquals(value, expectedInteger, "Mismatch at " + label);
    }

    protected void validateDoubleValue(double value, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2].trim();
        if (valueAsString.equals("<NULL>")) {
            assertTrue(Double.isNaN(value));
        } else {
            double expectedDouble = Double.parseDouble(valueAsString);
            assertEquals(value, expectedDouble, 0.000000001, "Mismatch at " + label);
        }
    }

    protected void validateDoubleValueWithIndex(
            double value, int index, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 4);
        String label = lineParts[1];
        String indexAsFormattedString = lineParts[2].trim();
        String valueAsString = lineParts[3].trim();
        assertEquals(String.format("[%d]", index), indexAsFormattedString);
        double expectedDouble = Double.parseDouble(valueAsString);
        assertEquals(value, expectedDouble, 0.000000001, "Mismatch at " + label);
    }

    protected void validatePositionValue(Position position, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 3);
        String label = lineParts[1];
        String valueAsString = lineParts[2];
        String[] valueParts = valueAsString.split(",");
        if (valueParts[0].equals("<NULL>") && valueParts[1].equals("<NULL>")) {
            assertTrue(Double.isNaN(position.getLatitudeDegrees()));
            assertTrue(Double.isNaN(position.getLongitudeDegrees()));
        } else {
            double expectedLatitudeInDegrees = Double.parseDouble(valueParts[0]);
            double expectedLongitudeInDegrees = Double.parseDouble(valueParts[1]);
            assertEquals(position.getLatitudeDegrees(), expectedLatitudeInDegrees, 0.000001);
            assertEquals(position.getLongitudeDegrees(), expectedLongitudeInDegrees, 0.000001);
        }
    }

    protected void validatePositionValueWithIndex(
            Position position, int index, List<String> otherLines, int i) {
        String[] lineParts = otherLines.get(i).split(",", 4);
        String label = lineParts[1];
        String indexAsFormattedString = lineParts[2].trim();
        String valueAsString = lineParts[3];
        assertEquals(String.format("[%d]", index), indexAsFormattedString);
        String[] valueParts = valueAsString.split(",");
        if (valueParts[0].equals("<NULL>") && valueParts[1].equals("<NULL>")) {
            assertTrue(Double.isNaN(position.getLatitudeDegrees()));
            assertTrue(Double.isNaN(position.getLongitudeDegrees()));
        } else {
            double expectedLatitudeInDegrees = Double.parseDouble(valueParts[0]);
            double expectedLongitudeInDegrees = Double.parseDouble(valueParts[1]);
            assertEquals(position.getLatitudeDegrees(), expectedLatitudeInDegrees, 0.000001);
            assertEquals(position.getLongitudeDegrees(), expectedLongitudeInDegrees, 0.000001);
        }
    }
}
