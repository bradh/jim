package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class RequesterRemarksDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFFFE0;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00000060;

    public RequesterRemarksDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RequesterRemarksDataTable dataTable = new RequesterRemarksDataTable();
        dataTable.setName("Requester Remarks");
        dataTable.setSourceFile("Mission");
        dataTable.setRemarks(this.readASCII(mappedByteBuffer, offset, 1024));
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.MISSION_DATA_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
