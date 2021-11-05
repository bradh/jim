package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class MinimumSensorAttitudeDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000020;

    public MinimumSensorAttitudeDataTableParser() {}

    @Override
    public MinimumSensorAttitudeDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        MinimumSensorAttitudeDataTable dataTable = new MinimumSensorAttitudeDataTable();
        dataTable.setName("Minimum Sensor Attitude");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setRotationAboutZAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAboutYAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAboutXAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
