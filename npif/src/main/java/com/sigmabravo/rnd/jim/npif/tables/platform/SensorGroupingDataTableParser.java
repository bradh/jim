package com.sigmabravo.rnd.jim.npif.tables.platform;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorGroupingDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFFF00;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00410000;

    public SensorGroupingDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorGroupingDataTable dataTable = new SensorGroupingDataTable();
        dataTable.setName("Sensor Grouping");
        dataTable.setSourceFile("Platform");
        dataTable.setGroupType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setNumberOfSensorNumbersWithinTheGroup(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setCoverageRelationship(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTimingRelationship(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        for (int i = 0; i < header.getDataFileSize() - 4; i++) {
            int sensorNumber = this.readUnsignedBinary(mappedByteBuffer, offset + i, 1);
            dataTable.addSensorNumber(sensorNumber);
        }
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.PLATFORM_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
