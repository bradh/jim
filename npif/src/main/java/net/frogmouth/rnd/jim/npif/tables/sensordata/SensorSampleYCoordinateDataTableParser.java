package net.frogmouth.rnd.jim.npif.tables.sensordata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorSampleYCoordinateDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000020;

    public SensorSampleYCoordinateDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorSampleYCoordinateDataTable dataTable = new SensorSampleYCoordinateDataTable();
        dataTable.setName("Sensor Sample \"y\" Coordinate");
        dataTable.setSourceFile("Sensor");
        dataTable.setSampleYCoordinate(
                this.readBytes(mappedByteBuffer, offset, header.getDataFileSize()));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
