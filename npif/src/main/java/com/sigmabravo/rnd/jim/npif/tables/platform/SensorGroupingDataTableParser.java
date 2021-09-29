package com.sigmabravo.rnd.jim.npif.tables.platform;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public class SensorGroupingDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFFF00;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00410000;

    public SensorGroupingDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        System.out.println("Sensor Grouping Data Table");
        return new DataTable();
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.PLATFORM_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
