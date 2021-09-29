package com.sigmabravo.rnd.jim.npif.tables.missiondata;

import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public class CollectionPlatformIdentificationDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000030;

    public CollectionPlatformIdentificationDataTableParser() {}

    @Override
    public CollectionPlatformIdentificationDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset) {
        CollectionPlatformIdentificationDataTable dataTable =
                new CollectionPlatformIdentificationDataTable();
        dataTable.setName("Collection Platform Identification");
        dataTable.setSourceFile("Mission");
        dataTable.setSquadron(this.readASCII(mappedByteBuffer, offset, 6));
        offset += 6;
        dataTable.setWing(this.readASCII(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setAircraftType(this.readASCII(mappedByteBuffer, offset, 16));
        offset += 16;
        dataTable.setAircraftTailNumber(this.readASCII(mappedByteBuffer, offset, 6));
        offset += 6;
        dataTable.setSortieNumber(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setPilotID(this.readASCII(mappedByteBuffer, offset, 3));
        offset += 3;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.MISSION_DATA_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
