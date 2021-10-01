package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorOperatingStatusDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000006;

    public SensorOperatingStatusDataTableParser() {}

    @Override
    public SensorOperatingStatusDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorOperatingStatusDataTable dataTable = new SensorOperatingStatusDataTable();
        dataTable.setName("Sensor Operating Status");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setStatus(this.readASCII(mappedByteBuffer, offset, 256));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
