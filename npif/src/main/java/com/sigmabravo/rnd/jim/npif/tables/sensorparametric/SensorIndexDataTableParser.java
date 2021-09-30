package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorIndexDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int MIN_FILE_ADDRESS_SUPPORTED = 0x00000200;
    private static final int MAX_FILE_ADDRESS_SUPPORTED = 0x000002FF;

    public SensorIndexDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorIndexDataTable dataTable = new SensorIndexDataTable();
        dataTable.setName("Sensor Index");
        dataTable.setSourceFile("Sensor Parametric");
        int numLoops = header.getDataFileSize() / 80;
        for (int i = 0; i < numLoops; i++) {
            SensorIndexDataTableEntry entry = new SensorIndexDataTableEntry();
            entry.setCollectionStartTime(this.readDTG(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setCollectionStopTime(this.readDTG(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setStartHeaderTimeTag(this.readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setEndHeaderTimeTag(this.readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setAircraftLocationAtCollectionStartTime(
                    this.readPosition(mappedByteBuffer, offset));
            offset += 16;
            entry.setAircraftLocationAtCollectionEndTime(
                    this.readPosition(mappedByteBuffer, offset));
            offset += 16;
            entry.setSensorStartPosition(this.readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setSensorEndPosition(this.readUnsignedBinaryLong(mappedByteBuffer, offset, 8));
            offset += 8;
            dataTable.addEntry(entry);
        }
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return ((fileAddress >= MIN_FILE_ADDRESS_SUPPORTED)
                && (fileAddress <= MAX_FILE_ADDRESS_SUPPORTED));
    }
}
