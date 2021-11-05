package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorPositionDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000010;

    public SensorPositionDataTableParser() {}

    @Override
    public SensorPositionDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorPositionDataTable dataTable = new SensorPositionDataTable();
        dataTable.setName("Sensor Position");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setxVectorComponent(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setyVectorComponent(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setzVectorComponent(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
