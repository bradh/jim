package net.frogmouth.rnd.jim.npif.tables.sensordata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorSampleZCoordinateDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000030;

    public SensorSampleZCoordinateDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorSampleZCoordinateDataTable dataTable = new SensorSampleZCoordinateDataTable();
        dataTable.setName("Sensor Sample \"z\" Coordinate");
        dataTable.setSourceFile("Sensor");
        dataTable.setSampleZCoordinate(
                this.readBytes(mappedByteBuffer, offset, header.getDataFileSize()));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
