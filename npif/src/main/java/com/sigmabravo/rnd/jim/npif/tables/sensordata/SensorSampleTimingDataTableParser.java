package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.nio.MappedByteBuffer;

public class SensorSampleTimingDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000050;

    public SensorSampleTimingDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        System.out.println("Sensor Sample Timing Data Table");
        return new DataTable();
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
