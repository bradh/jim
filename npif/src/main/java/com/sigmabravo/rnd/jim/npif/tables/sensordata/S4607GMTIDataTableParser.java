package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class S4607GMTIDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000060;

    public S4607GMTIDataTableParser() {}

    @Override
    public S4607GMTIDataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        S4607GMTIDataTable dataTable = new S4607GMTIDataTable();
        dataTable.setName("4607 GMTI");
        dataTable.setSourceFile("Sensor");
        dataTable.setData(this.readBytes(mappedByteBuffer, offset, header.getDataFileSize()));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}