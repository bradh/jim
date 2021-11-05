package net.frogmouth.rnd.jim.npif.tables.sensordata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorSampleXCoordinateDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000010;

    public SensorSampleXCoordinateDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorSampleXCoordinateDataTable dataTable = new SensorSampleXCoordinateDataTable();
        dataTable.setName("Sensor Sample \"x\" Coordinate");
        dataTable.setSourceFile("Sensor");
        dataTable.setSampleXCoordinate(
                this.readBytes(mappedByteBuffer, offset, header.getDataFileSize()));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
