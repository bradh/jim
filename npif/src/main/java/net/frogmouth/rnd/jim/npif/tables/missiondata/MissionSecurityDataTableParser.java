package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class MissionSecurityDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000010;

    public MissionSecurityDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        MissionSecurityDataTable dataTable = new MissionSecurityDataTable();
        dataTable.setName("Mission Security");
        dataTable.setSourceFile("Mission");
        dataTable.setMissionSecurityClassification(readASCII(mappedByteBuffer, offset, 64));
        offset += 64;
        dataTable.setDate(this.readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAuthority(this.readASCII(mappedByteBuffer, offset, 60));
        offset += 60;
        dataTable.setDowngradingInstructions(this.readASCII(mappedByteBuffer, offset, 1024));
        offset += 1024;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.MISSION_DATA_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
