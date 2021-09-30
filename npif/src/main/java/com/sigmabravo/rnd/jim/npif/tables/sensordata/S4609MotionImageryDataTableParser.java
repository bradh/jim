package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class S4609MotionImageryDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000070;

    public S4609MotionImageryDataTableParser() {}

    @Override
    public S4609MotionImageryDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        S4609MotionImageryDataTable dataTable = new S4609MotionImageryDataTable();
        dataTable.setName("4609 Motion Imagery");
        dataTable.setSourceFile("Sensor");
        dataTable.setData(this.readBytes(mappedByteBuffer, offset, header.getDataFileSize()));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
