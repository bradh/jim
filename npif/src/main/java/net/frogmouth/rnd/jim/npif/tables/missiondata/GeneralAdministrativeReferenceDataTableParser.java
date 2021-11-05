package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class GeneralAdministrativeReferenceDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;

    public GeneralAdministrativeReferenceDataTableParser() {}

    @Override
    public GeneralAdministrativeReferenceDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        GeneralAdministrativeReferenceDataTable dataTable =
                new GeneralAdministrativeReferenceDataTable();
        dataTable.setName("General Administrative Reference");
        dataTable.setSourceFile("Mission");
        dataTable.setMissionNumber(readASCII(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setMissionStartTime(this.readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setProjectIdentifierCode(this.readASCII(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setNumberOfTargets(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setNumberOfRequesters(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.MISSION_DATA_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
