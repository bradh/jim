package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorIndexDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int MIN_FILE_ADDRESS_SUPPORTED = 0x00000200;
    private static final int MAX_FILE_ADDRESS_SUPPORTED = 0x000002FF;

    public SensorIndexDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        System.out.println("Minimum Sensor Attitude Data Table");
        return new DataTable();
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return ((fileAddress >= MIN_FILE_ADDRESS_SUPPORTED)
                && (fileAddress <= MAX_FILE_ADDRESS_SUPPORTED));
    }
}
