package net.frogmouth.rnd.jim.npif.tables.sensordata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class RangeFinderDataTableParser extends AbstractSensorDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000080;

    public RangeFinderDataTableParser() {}

    @Override
    public RangeFinderDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RangeFinderDataTable dataTable = new RangeFinderDataTable();
        dataTable.setName("Range Finder");
        dataTable.setSourceFile("Sensor");
        dataTable.setRange(this.readDouble(mappedByteBuffer, offset, 8));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
