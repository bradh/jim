package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SensorIdentificationDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFF00FFFF;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;

    public SensorIdentificationDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorIdentificationDataTable dataTable = new SensorIdentificationDataTable();
        dataTable.setName("Sensor Identification");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setSensorType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setSensorSerialNumber(this.readASCII(mappedByteBuffer, offset, 16));
        offset += 16;
        dataTable.setSensorModelNumber(this.readASCII(mappedByteBuffer, offset, 16));
        offset += 16;
        dataTable.setSensorModellingMethod(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setNumberOfGimbals(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        // TODO: this may need to check the platform ID part
        return ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED);
    }
}
