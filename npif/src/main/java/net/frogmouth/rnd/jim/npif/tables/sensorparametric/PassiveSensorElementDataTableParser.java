package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class PassiveSensorElementDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00001000;

    public PassiveSensorElementDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        PassiveSensorElementDataTable dataTable = new PassiveSensorElementDataTable();
        dataTable.setName("Passive Sensor Element");
        dataTable.setSourceFile("Sensor Parametric");
        // TODO: this needs to loop
        PassiveSensorElementDataTableEntry entry = new PassiveSensorElementDataTableEntry();
        entry.setElementSize(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        entry.setElementBitOffset(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        entry.setSensorElementID(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        entry.setMinimumWavelength(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        entry.setMaximumWavelength(this.readDouble(mappedByteBuffer, offset, 8));
        dataTable.addEntry(entry);
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
