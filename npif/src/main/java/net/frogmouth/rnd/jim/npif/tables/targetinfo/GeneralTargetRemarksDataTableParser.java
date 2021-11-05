package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class GeneralTargetRemarksDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFF000;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00003000;

    public GeneralTargetRemarksDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        GeneralTargetRemarksDataTable dataTable = new GeneralTargetRemarksDataTable();
        dataTable.setName("General Target Remarks");
        dataTable.setSourceFile("Target");
        dataTable.setRemarks(readASCII(mappedByteBuffer, offset, 1024));
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED);
    }
}
