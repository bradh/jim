package net.frogmouth.rnd.jim.npif.tables.sensordata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorSampleTimingDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000050;

    public SensorSampleTimingDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorSampleTimingDataTable dataTable = new SensorSampleTimingDataTable();
        dataTable.setName("Sensor Sample Timing");
        dataTable.setSourceFile("Sensor");
        dataTable.setSampleTiming(
                this.readBytes(mappedByteBuffer, offset, header.getDataFileSize()));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
