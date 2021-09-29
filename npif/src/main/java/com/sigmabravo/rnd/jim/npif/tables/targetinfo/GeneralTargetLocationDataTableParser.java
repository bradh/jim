package com.sigmabravo.rnd.jim.npif.tables.targetinfo;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public class GeneralTargetLocationDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFF000;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00001000;

    public GeneralTargetLocationDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset) {
        GeneralTargetLocationDataTable dataTable = new GeneralTargetLocationDataTable();
        dataTable.setName("General Target Location");
        dataTable.setSourceFile("Target");
        dataTable.setStartTargetOrCornerLocation(readPosition(mappedByteBuffer, offset));
        offset += 16;
        dataTable.setStartTargetOrCornerElevation(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setTargetDiameterOrWidth(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setMapSeries(readASCII(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setSheetNumberOfTargetLocation(readASCII(mappedByteBuffer, offset, 14));
        offset += 14;
        dataTable.setInverseMapScale(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setMapEditionNumber(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setMapEditionDate(this.readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.TARGET_DATA_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
