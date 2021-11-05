package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class GeneralTargetEEIDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFF000;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00002000;

    public GeneralTargetEEIDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        GeneralTargetEEIDataTable dataTable = new GeneralTargetEEIDataTable();
        dataTable.setName("General Target EEI");
        dataTable.setSourceFile("Target");
        dataTable.setTargetCategoryEssentialElementsOfInformation(
                this.readASCII(mappedByteBuffer, offset, 32));
        offset += 32;
        dataTable.setEeiTargetCategoryDesignationScheme(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setWeatherOverTheTargetReportingCode(this.readASCII(mappedByteBuffer, offset, 7));
        offset += 7;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.TARGET_DATA_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
