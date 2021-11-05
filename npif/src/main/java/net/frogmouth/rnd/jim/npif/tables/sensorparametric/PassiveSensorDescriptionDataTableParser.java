package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class PassiveSensorDescriptionDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000001;

    public PassiveSensorDescriptionDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        PassiveSensorDescriptionDataTable dataTable = new PassiveSensorDescriptionDataTable();
        dataTable.setName("Passive Sensor Description");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setFrameOrSwathSize(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setActiveLineTime(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setLineSizeOfActiveData(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setPacketsPerFrameOrSwath(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setSizeOfTileInTheHighFrequencyScanningDirection(
                this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setSizeOfTileInTheLowFrequencyScanningDirection(
                this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setNumberOfTilesAcrossALine(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setNumberOfSwathsPerFrame(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setSensorMode(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setPixelSize(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setElementsPerPixel(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setDataOrdering(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setLineFOV(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setFrameOrSwathFOV(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setNumberOfFields(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setHighFrequencyScanningDirection(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setLowFrequencyScanningDirection(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
