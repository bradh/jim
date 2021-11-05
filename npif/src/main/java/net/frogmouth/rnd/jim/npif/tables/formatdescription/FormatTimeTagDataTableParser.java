package net.frogmouth.rnd.jim.npif.tables.formatdescription;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class FormatTimeTagDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000001;

    public FormatTimeTagDataTableParser() {}

    @Override
    public FormatTimeTagDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        FormatTimeTagDataTable dataTable = new FormatTimeTagDataTable();
        dataTable.setName("Format Time Tag");
        dataTable.setSourceFile("Format Description");
        dataTable.setTimeTagIncrements(this.readDouble(mappedByteBuffer, offset, 8));
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.FORMAT_DESCRIPTION_SOURCE_ADDRESS)
                && (fileAddress == FILE_ADDRESS_SUPPORTED));
    }
}
