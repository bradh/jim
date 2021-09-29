package com.sigmabravo.rnd.jim.npif.tables.targetinfo;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public class GeneralTargetRemarksDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFF000;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00003000;

    public GeneralTargetRemarksDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
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
