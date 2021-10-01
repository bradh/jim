package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class PassiveSensorDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000001;

    public PassiveSensorDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        System.out.println("Passive Sensor Data Table");
        return new DataTable();
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}