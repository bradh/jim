package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.nio.MappedByteBuffer;

public class ComprehensiveSensorAttitudeDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000030;

    public ComprehensiveSensorAttitudeDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        System.out.println("Comprehensive Sensor Attitude Data Table");
        return new DataTable();
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
