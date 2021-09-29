package com.sigmabravo.rnd.jim.npif.tables.platform;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public class MinimumDynamicPlatformDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFF00FFFF;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;

    public MinimumDynamicPlatformDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        System.out.println("Minimum Dynamic Platform Data Table");
        return new DataTable();
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.PLATFORM_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
