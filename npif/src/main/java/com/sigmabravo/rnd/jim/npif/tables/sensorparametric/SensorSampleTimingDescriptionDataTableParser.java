package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.nio.MappedByteBuffer;

public class SensorSampleTimingDescriptionDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00001020;

    public SensorSampleTimingDescriptionDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        System.out.println("Sensor Sample Timing Description Data Table");
        return new DataTable();
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
