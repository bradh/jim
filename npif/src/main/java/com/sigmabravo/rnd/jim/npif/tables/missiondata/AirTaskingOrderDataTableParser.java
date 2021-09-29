package com.sigmabravo.rnd.jim.npif.tables.missiondata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public class AirTaskingOrderDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000020;

    public AirTaskingOrderDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        AirTaskingOrderDataTable dataTable = new AirTaskingOrderDataTable();
        dataTable.setName("Air Tasking Order");
        dataTable.setSourceFile("Mission");
        dataTable.setAirTaskingOrderTitle(readASCII(mappedByteBuffer, offset, 7));
        offset += 7;
        dataTable.setAirTaskingOrderOriginator(readASCII(mappedByteBuffer, offset, 20));
        offset += 20;
        dataTable.setAirTaskingOrderSerial(readASCII(mappedByteBuffer, offset, 10));
        offset += 10;
        dataTable.setDateTimeGroup(readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setQualifier(readASCII(mappedByteBuffer, offset, 3));
        offset += 3;
        dataTable.setQualifierSerialNumber(readUnsignedBinary(mappedByteBuffer, offset, 2));
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.MISSION_DATA_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
