package com.sigmabravo.rnd.jim.npif;

import static org.testng.Assert.*;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.sensordata.SensorDataTable;
import com.sigmabravo.rnd.jim.npif.tables.sensorparametric.PassiveSensorDescriptionDataTable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import org.testng.annotations.Test;

public class ReaderTest extends TestSupport {

    public ReaderTest() {}

    @Test
    public void withSync() throws IOException {
        Reader reader = new Reader(getValidFile());
        assertNotNull(reader);
    }

    @Test(expectedExceptions = IOException.class)
    public void noSync() throws IOException {
        new Reader(getFileNoSync());
    }

    @Test
    public void withSyncOffset() throws IOException {
        Reader reader = new Reader(getValidFileSyncOffset());
        assertNotNull(reader);
    }

    @Test
    public void single() throws IOException {
        Reader reader = new Reader(getValidFileSingle());
        assertNotNull(reader);
        assertEquals(reader.getTableTables().size(), 1);
        DataTable dataTable = reader.getTableTables().get(0);
        assertEquals(dataTable.getHeader().getEditionNumber(), 3);
        assertEquals(dataTable.getHeader().isAmbleFlag(), false);
        assertEquals(dataTable.getHeader().isCompressionFlag(), false);
        assertEquals(dataTable.getHeader().isCrcFlag(), false);
        assertEquals(dataTable.getHeader().getSegmentNumber(), 1);
        assertEquals(dataTable.getHeader().getSourceAddress(), 32);
        assertEquals(dataTable.getHeader().getDataFileAddress(), 1);
        assertEquals(dataTable.getHeader().getDataFileSize(), 231);
        assertEquals(dataTable.getHeader().getDataFileNumber(), 0);
        assertEquals(dataTable.getHeader().getTimeTag(), 1);
        assertEquals(dataTable.getHeader().getSyncType(), 0);
    }

    @Test
    public void goldenLine8() throws IOException {
        if (haveGoldenFiles()) {
            Reader reader = new Reader(getGoldenFile("line-8"));
            assertNotNull(reader);
            assertEquals(reader.getTableTables().size(), 15849);
            WritableImage image = render(reader.getTableTables());
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File("line-8.png"));
        }
    }

    @Test
    public void goldenStepFrame8() throws IOException {
        if (haveGoldenFiles()) {
            Reader reader = new Reader(getGoldenFile("step-frame-8"));
            assertNotNull(reader);
            assertEquals(reader.getTableTables().size(), 424);
            WritableImage image = render(reader.getTableTables());
            ImageIO.write(
                    SwingFXUtils.fromFXImage(image, null), "png", new File("step-frame-8.png"));
        }
    }

    @Test
    public void goldenPushbroom10() throws IOException {
        if (haveGoldenFiles()) {
            Reader reader = new Reader(getGoldenFile("pushbroom-10"));
            assertNotNull(reader);
            assertEquals(reader.getTableTables().size(), 1780);
            WritableImage image = render(reader.getTableTables());
            ImageIO.write(
                    SwingFXUtils.fromFXImage(image, null), "png", new File("pushbroom-10.png"));
        }
    }

    @Test
    public void goldenPanFrame16() throws IOException {
        if (haveGoldenFiles()) {
            Reader reader = new Reader(getGoldenFile("pan-frame-16"));
            assertNotNull(reader);
            assertEquals(reader.getTableTables().size(), 1294);
            WritableImage image = render(reader.getTableTables());
            ImageIO.write(
                    SwingFXUtils.fromFXImage(image, null), "png", new File("pan-frame-16.png"));
        }
    }

    private WritableImage render(List<DataTable> tables) {
        int numSensorFiles = 0;
        int numColumns = 0;
        int numRowsPerFrame = 0;
        int numBitsPerPixel = 0;
        int bitShift = 0;
        for (DataTable table : tables) {
            if (table instanceof SensorDataTable) {
                numSensorFiles += 1;
            }
            if (table instanceof PassiveSensorDescriptionDataTable) {
                PassiveSensorDescriptionDataTable psd = (PassiveSensorDescriptionDataTable) table;
                // System.out.println("PassiveSensorDescriptionDataTable");
                numColumns = psd.getLineSizeOfActiveData();
                numRowsPerFrame = psd.getFrameOrSwathSize();
                numBitsPerPixel = psd.getPixelSize();
                if (numBitsPerPixel > Byte.SIZE) {
                    bitShift = Byte.SIZE - (Short.SIZE - numBitsPerPixel);
                }
                // System.out.println(psd.getNumberOfTilesAcrossALine());
                // System.out.println(psd.getNumberOfSwathsPerFrame());
                // System.out.println(psd.getSizeOfTileInTheHighFrequencyScanningDirection());
                // System.out.println(psd.getSizeOfTileInTheLowFrequencyScanningDirection());
            }
        }
        int rowNumber = 0;
        WritableImage image = new WritableImage(numColumns, numRowsPerFrame * numSensorFiles);
        PixelWriter pw = image.getPixelWriter();
        for (DataTable table : tables) {
            if (table instanceof SensorDataTable) {
                SensorDataTable sensorData = (SensorDataTable) table;
                byte[] data = sensorData.getSensorData();
                BitsExtractor bitsExtractor = new BitsExtractor(data);
                assert (data.length == numColumns * numRowsPerFrame * numBitsPerPixel / Byte.SIZE);
                for (int r = 0; r < numRowsPerFrame; r++) {
                    for (int c = 0; c < numColumns; c++) {
                        int sample = 0;
                        if (numBitsPerPixel == Byte.SIZE) {
                            sample = data[c + r * numColumns] & 0xFF;
                        } else {
                            sample = bitsExtractor.extractBits(numBitsPerPixel) >>> bitShift;
                        }
                        pw.setColor(c, rowNumber, Color.grayRgb(sample));
                    }
                    rowNumber += 1;
                }
            }
        }
        return image;
    }

    private boolean haveGoldenFiles() {
        // TODO: check properly
        return true;
    }
}
