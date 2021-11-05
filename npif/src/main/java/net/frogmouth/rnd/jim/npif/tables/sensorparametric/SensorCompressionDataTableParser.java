package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorCompressionDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000100;

    public SensorCompressionDataTableParser() {}

    @Override
    public SensorCompressionDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorCompressionDataTable dataTable = new SensorCompressionDataTable();
        dataTable.setName("Sensor Compression");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setCompressionAlgorithm(readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
