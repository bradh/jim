package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorDataTimingDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000004;

    public SensorDataTimingDataTableParser() {}

    @Override
    public SensorDataTimingDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorDataTimingDataTable dataTable = new SensorDataTimingDataTable();
        dataTable.setName("Sensor Data Timing");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setFramePeriod(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setIntraFrameTime(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setLinePeriod(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setIntraLineTime(readDouble(mappedByteBuffer, offset, 8));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
